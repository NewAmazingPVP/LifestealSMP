package newamazingpvp.lifestealsmp.utility;

import java.io.File;
import java.sql.*;
import java.util.*;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class DataBaseHelper {

    private Connection connection;

    /**
     * Create a new DatabaseHelper. The database file will be stored in your plugin's data folder.
     *
     * @param dbName The SQLite database file name (for example, "data.db").
     */
    public DataBaseHelper(String dbName) {
        connect(dbName);
    }

    private void connect(String dbName) {
        try {
            File dataFolder = lifestealSmp.getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }
            File dbFile = new File(dataFolder, dbName);
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile.getAbsolutePath());
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }

    /**
     * Create a table if it does not exist.
     *
     * @param tableName The name of the table.
     * @param columns   The column definitions (for example, "player_name TEXT PRIMARY KEY, crafted_at TIMESTAMP").
     */
    public void createTable(String tableName, String columns) {
        String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + columns + ")";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    /**
     * Insert data into a table. The number of columns must match the number of values.
     *
     * @param tableName The table name.
     * @param columns   An array of column names.
     * @param values    The values to insert.
     * @return The number of affected rows.
     */
    public int insertData(String tableName, String[] columns, Object... values) {
        if (columns.length != values.length) {
            throw new IllegalArgumentException("Columns count and values count do not match.");
        }
        String cols = String.join(", ", columns);
        String placeholders = String.join(", ", Collections.nCopies(values.length, "?"));
        String query = "INSERT INTO " + tableName + " (" + cols + ") VALUES (" + placeholders + ")";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }
            return stmt.executeUpdate();
        } catch (SQLException e) {
        }
        return 0;
    }

    /**
     * Update data in a table.
     *
     * @param tableName       The table name.
     * @param data            A map with column names as keys and new values as map values.
     * @param condition       The SQL condition (for example, "player_name = ?").
     * @param conditionValues The values to fill in the condition placeholders.
     * @return The number of affected rows.
     */
    public int updateData(String tableName, Map<String, Object> data, String condition, Object... conditionValues) {
        List<String> setClauses = new ArrayList<>();
        for (String column : data.keySet()) {
            setClauses.add(column + " = ?");
        }
        String setClause = String.join(", ", setClauses);
        String query = "UPDATE " + tableName + " SET " + setClause + " WHERE " + condition;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            int index = 1;
            for (Object value : data.values()) {
                stmt.setObject(index++, value);
            }
            for (Object condVal : conditionValues) {
                stmt.setObject(index++, condVal);
            }
            return stmt.executeUpdate();
        } catch (SQLException e) {
        }
        return 0;
    }

    /**
     * Get data from a table.
     *
     * @param tableName The table name.
     * @param condition The SQL condition (for example, "player_name = ?"). Pass null or empty string if no condition.
     * @param params    The values for the condition placeholders.
     * @return A list of maps. Each map represents one row with column names as keys.
     */
    public List<Map<String, Object>> getData(String tableName, String condition, Object... params) {
        String query = "SELECT * FROM " + tableName;
        if (condition != null && !condition.isEmpty()) {
            query += " WHERE " + condition;
        }
        List<Map<String, Object>> results = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                ResultSetMetaData meta = rs.getMetaData();
                int columnCount = meta.getColumnCount();
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(meta.getColumnName(i), rs.getObject(i));
                    }
                    results.add(row);
                }
            }
        } catch (SQLException e) {
        }
        return results;
    }

    /**
     * Delete data from a table.
     *
     * @param tableName The table name.
     * @param condition The SQL condition (for example, "player_name = ?").
     * @param params    The values for the condition placeholders.
     * @return The number of affected rows.
     */
    public int deleteData(String tableName, String condition, Object... params) {
        String query = "DELETE FROM " + tableName + " WHERE " + condition;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            return stmt.executeUpdate();
        } catch (SQLException e) {
        }
        return 0;
    }

    public void resetDatabase() {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet rs = metaData.getTables(null, null, "%", null);
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                if (tableName.startsWith("sqlite_")) {
                    continue;
                }
                String sql = "DELETE FROM " + tableName;
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.executeUpdate();
                }
            }
            rs.close();
        } catch (SQLException e) {
        }
    }

}
