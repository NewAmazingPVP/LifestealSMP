package newamazingpvp.lifestealsmp.utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class AutoUpload {
    private static final String RELEASE_URL = "https://api.github.com/repos/NewAmazingPVP/LifestealSMP/releases/latest";
    private static String defaultUrl = "https://api.github.com/repos/NewAmazingPVP/LifestealSMP/releases/latest";
    private static String downloadUrl = null;

    public static void startReleaseChecker() {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    checkForNewRelease();
                } catch (Exception ignored) {
                }
            }
        }.runTaskTimerAsynchronously(lifestealSmp, 0L, 300L);
    }

    private static synchronized String getApiKey() {
        return lifestealSmp.getConfig().getString("Key");
    }

    private static void checkForNewRelease() {
        try {
            URL url = new URL(RELEASE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if(!isAutoUploadEnabled()) return;
            connection.setRequestProperty("Authorization", "Token " + getApiKey());

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode node = objectMapper.readTree(response.toString());

                for (JsonNode asset : node.get("assets")) {
                    if (asset.has("name") && asset.get("name").asText().endsWith(".jar")) {
                        downloadUrl = asset.get("browser_download_url").asText();
                        break;
                    }
                }
                if (!(Objects.equals(downloadUrl, defaultUrl)) && downloadUrl != null) {
                    lifestealSmp.getServer().broadcastMessage(ChatColor.GREEN + "New LifestealSMP plugin release available. Updating plugin...");
                    updatePlugin(downloadUrl, "LifestealSMP-1.0");
                }
            } else {
                lifestealSmp.getLogger().info("Failed to check for new releases. Response code: " + connection.getResponseCode());
            }

            connection.disconnect();

        } catch (IOException e) {
            lifestealSmp.getLogger().info("Failed to check for new releases: " + e.getMessage());
        }
    }

    public static void updatePlugin(String link, String fileName) {
        String outputFilePath = "plugins/" + fileName + ".jar";

        try (InputStream in = new URL(link).openStream();
             FileOutputStream out = new FileOutputStream(outputFilePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            defaultUrl = downloadUrl;
            lifestealSmp.getServer().broadcastMessage(ChatColor.AQUA + "LifestealSMP plugin updated, restart server now...");
        } catch (IOException e) {
            lifestealSmp.getServer().broadcastMessage(ChatColor.RED + "Failed to download plugin: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean isAutoUploadEnabled(){
        return !getApiKey().isEmpty();
    }
}

