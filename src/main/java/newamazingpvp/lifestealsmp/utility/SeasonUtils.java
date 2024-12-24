package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static org.bukkit.Bukkit.getServer;

public class SeasonUtils {
    public static void startNewSeason() {
        setSeasonStartTime(getSeasonStartTime().plusDays(35));
        regenerateWorlds();
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
}
