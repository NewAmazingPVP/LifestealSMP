package newamazingpvp.lifestealsmp.utility;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.blacklistener.DisableCustomItems.dbHelper;
import static newamazingpvp.lifestealsmp.game.AutoBan.autoBanDb;
import static newamazingpvp.lifestealsmp.game.PlayerLifeManager.clearEliminatedPlayers;
import static newamazingpvp.lifestealsmp.runes.RuneHandler.runeDb;
import static org.bukkit.Bukkit.getServer;

public class SeasonUtils {
    public static void startNewSeason() {
        clearEliminatedPlayers();
        runeDb.resetDatabase();
        dbHelper.resetDatabase();
        //maceDb.resetDatabase();
        autoBanDb.resetDatabase();
        getServer().dispatchCommand(getServer().getConsoleSender(), "chunky world world");
        getServer().dispatchCommand(getServer().getConsoleSender(), "chunky radius 12500");
        getServer().dispatchCommand(getServer().getConsoleSender(), "chunky start");
        getServer().dispatchCommand(getServer().getConsoleSender(), "chunky world world_nether");
        getServer().dispatchCommand(getServer().getConsoleSender(), "chunky radius 12500");
        getServer().dispatchCommand(getServer().getConsoleSender(), "chunky start");
        getServer().dispatchCommand(getServer().getConsoleSender(), "chunky world world_the_end");
        getServer().dispatchCommand(getServer().getConsoleSender(), "chunky radius 12500");
        getServer().dispatchCommand(getServer().getConsoleSender(), "chunky start");
        setSeasonStartTime(getSeasonStartTime().plusDays(35));
        //updateServerJar(new ArrayList<>(List.of("/home/ubuntu/Smp/server.jar", "/home/ubuntu/Dev/server.jar")));
        //updateVelocityProxy("/home/ubuntu/Velocity/velocity.jar");
        //regenerateWorlds();
    }

    public static void regenerateWorlds() {
        //Bukkit.broadcastMessage("Regenerating worlds...");

        for (Player player : Bukkit.getOnlinePlayers()) {
            //player.kickPlayer("World is regenerating. Please rejoin in a few seconds.");
        }

        for (World world : Bukkit.getWorlds()) {
            Bukkit.savePlayers();
            world.save();
            world.setAutoSave(false);
        }

        //TODO: Don't use a script, directly do it in the code itself to make it work anywhere
        try {
            File script = new File("/home/ubuntu/Smp/deleteFolders.sh");

            ProcessBuilder builder = new ProcessBuilder("/bin/bash", script.getAbsolutePath());
            builder.redirectErrorStream(true);

            builder.directory(new File("/home/ubuntu/Smp/"));

            Process process = builder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServer().shutdown();
    }


    public static ZonedDateTime getSeasonStartTime() {
        lifestealSmp.saveDefaultConfig();
        String dateString = lifestealSmp.getConfig().getString("season-start-time");
        return ZonedDateTime.parse(dateString);
    }

    public static void setSeasonStartTime(ZonedDateTime newStartTime) {
        lifestealSmp.getConfig().set("season-start-time", newStartTime.toString());
        lifestealSmp.saveConfig();
    }

    public static void updateServerJar(List<String> outputPaths) {
        try {
            String purpurApi = "https://api.purpurmc.org/v2/purpur";
            HttpURLConnection connection = (HttpURLConnection) new URL(purpurApi).openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response;
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            Gson gson = new Gson();
            JsonObject root = gson.fromJson(response.toString(), JsonObject.class);
            String currentVersion = root
                    .getAsJsonObject("metadata")
                    .get("current")
                    .getAsString();

            String downloadUrl = String.format(
                    "https://api.purpurmc.org/v2/purpur/%s/latest/download",
                    currentVersion
            );

            byte[] jarBytes = downloadFile(downloadUrl);

            for (String path : outputPaths) {
                saveBytesToFile(jarBytes, path);
                Bukkit.getLogger().info("Saved Purpur " + currentVersion + " to " + path);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("Failed to update Purpur server jar.");
        }
    }

    public static void updateVelocityProxy(String outputPath) {
        try {
            String velocityApi = "https://api.papermc.io/v2/projects/velocity";
            HttpURLConnection connection = (HttpURLConnection) new URL(velocityApi).openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response;
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            Gson gson = new Gson();
            JsonObject root = gson.fromJson(response.toString(), JsonObject.class);
            JsonArray versions = root.getAsJsonArray("versions");
            String latestVersion = versions.get(versions.size() - 1).getAsString();

            String versionApi = String.format(
                    "https://api.papermc.io/v2/projects/velocity/versions/%s",
                    latestVersion
            );
            connection = (HttpURLConnection) new URL(versionApi).openConnection();
            connection.setRequestMethod("GET");

            StringBuilder versionResponse;
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                versionResponse = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    versionResponse.append(line);
                }
            }

            JsonObject versionRoot = gson.fromJson(versionResponse.toString(), JsonObject.class);
            JsonArray builds = versionRoot.getAsJsonArray("builds");

            int latestBuild = builds.get(builds.size() - 1).getAsInt();

            String downloadUrl = String.format(
                    "https://api.papermc.io/v2/projects/velocity/versions/%s/builds/%d/downloads/velocity-%s-%d.jar",
                    latestVersion,
                    latestBuild,
                    latestVersion,
                    latestBuild
            );

            byte[] jarBytes = downloadFile(downloadUrl);
            saveBytesToFile(jarBytes, outputPath);
            Bukkit.getLogger().info("Saved Velocity " + latestVersion + "-" + latestBuild + " to " + outputPath);

        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("Failed to update Velocity proxy.");
        }
    }

    private static byte[] downloadFile(String fileUrl) throws IOException {
        ByteArrayOutputStream buffer;
        try (InputStream in = new URL(fileUrl).openStream()) {
            buffer = new ByteArrayOutputStream();
            byte[] data = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, bytesRead);
            }
        }
        return buffer.toByteArray();
    }

    private static void saveBytesToFile(byte[] bytes, String outputPath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(bytes);
        }
    }
}
