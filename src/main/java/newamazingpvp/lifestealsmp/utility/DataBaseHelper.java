package newamazingpvp.lifestealsmp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseHelper {

    private Connection connection;

    public DataBaseHelper(String dbName) {
        connect(dbName);
    }

    private void connect(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, String columns) {
        String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + columns + ");";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String tableName, String columns, String values) {
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ");";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getData(String tableName, String condition) {
        String query = "SELECT * FROM " + tableName + " WHERE " + condition + ";";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteData(String tableName, String condition) {
        String query = "DELETE FROM " + tableName + " WHERE " + condition + ";";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
