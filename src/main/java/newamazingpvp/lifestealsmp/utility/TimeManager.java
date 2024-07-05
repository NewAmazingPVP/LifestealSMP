package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.World;

import java.awt.*;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static newamazingpvp.lifestealsmp.LifestealSMP.*;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsEmbedTitle;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.sendDiscordNewsMessage;
import static org.bukkit.Bukkit.getServer;


public class TimeManager {
    //TODO: ALWAYS KEEP THIS A SATURDAY IF POSSIBLE (START SEASONS ON SATURDAY)
    public static final ZonedDateTime SEASON_START_TIME = ZonedDateTime.of(
            2024, 6, 22, 12, 0, 0, 0, ZoneId.of("America/New_York")
    );

    public static final ZonedDateTime END_OPEN_TIME = SEASON_START_TIME.plusDays(14).plusHours(2);
    public static final ZonedDateTime FINAL_FIGHT = SEASON_START_TIME.plusDays(35).plusHours(2);

    //this is because season starts 12pm est auto restart at 3am Saturday morning
    public static final ZonedDateTime CUSTOM_ITEMS_AND_RUNES = SEASON_START_TIME.plusDays(6).plusHours(14);

    private static final CooldownManager cooldown = new CooldownManager();

    public static void doEvents() {
        if (!isSmp) return;
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        long weeksPassed = getWeeksPassed(SEASON_START_TIME, currentTime);
        if (isTimePassed(CUSTOM_ITEMS_AND_RUNES)) {
            registerCustomItemsAndRunes();
        }

        if (isTimePassed(CUSTOM_ITEMS_AND_RUNES) &&
                !isTimePassed(CUSTOM_ITEMS_AND_RUNES.plusHours(2))) {
            Bukkit.getWorld("world").getWorldBorder().setSize(25000);
            Bukkit.getWorld("world_nether").getWorldBorder().setSize(25000);
            for (World w : Bukkit.getWorlds()) {
                w.setDifficulty(Difficulty.HARD);
            }
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage("<@&1047168915500966048> Custom items and runes are now available! Map size expanded to 25k by 25k and difficulty set to hard. " +
                    "Runes give permanent effects while in inventory and custom items has special abilities. " +
                    "Various buffs/nerfs have been made so do /runes /recipes for more info! " +
                    "\n\n**End will open next weekend in " + formatDuration(Duration.between(ZonedDateTime.now(ZoneId.of("America/New_York")), SEASON_START_TIME.plusDays(14).plusHours(2))) + "**", "1032411739351941120"), 1200);
        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 3, 14, 0, 0) &&
                !isTimePassed(SEASON_START_TIME, currentTime, 3, 16, 0, 0)) {
            for (World w : Bukkit.getWorlds()) {
                w.setDifficulty(Difficulty.NORMAL);
            }
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> sendDiscordNewsMessage("Difficulty on SMP now set to normal!", "1032411739351941120"), 1200);
        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 10, 0, 0, 0)) {

        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 0, 5, 0, 0)) {

        }

        if (isTimePassed(SEASON_START_TIME, currentTime, 0, 0, 30, 0)) {

        }
    }

    public static void timeBasedEvents() {
        if (!isSmp) return;
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        long weeksPassed = getWeeksPassed(SEASON_START_TIME, currentTime);

        if (isTimePassed(SEASON_START_TIME.minusDays(1), currentTime, 0, 0, 0, 1) &&
                !isTimePassed(SEASON_START_TIME.minusDays(1), currentTime, 0, 0, 1, 0)) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> The new season will be released in a day!", "1032411739351941120");
        }

        if (isTimePassed(SEASON_START_TIME.minusHours(1), currentTime, 0, 0, 0, 1) &&
                !isTimePassed(SEASON_START_TIME.minusHours(1), currentTime, 0, 0, 1, 0)) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> The new season will be released in 1 hour/ " + formatDuration(Duration.between(SEASON_START_TIME, ZonedDateTime.now(ZoneId.of("America/New_York")))), "1032411739351941120");
        }

        if (isTimePassed(SEASON_START_TIME) &&
                !isTimePassed(SEASON_START_TIME.plusMinutes(1))) {
            if (cooldown.isOnCooldown()) return;
            getServer().dispatchCommand(getServer().getConsoleSender(), "whitelist off");
            getServer().dispatchCommand(getServer().getConsoleSender(), "gamerule playersSleepingPercentage 1");
            getServer().dispatchCommand(getServer().getConsoleSender(), "gamerule doImmediateRespawn true");
            Bukkit.getWorld("world").setTime(1000);
            Bukkit.getWorld("world").getWorldBorder().setSize(10000);
            Bukkit.getWorld("world_nether").getWorldBorder().setSize(10000);
            sendDiscordNewsEmbedTitle("New season has started!!", Color.GREEN, "1032411739351941120");
            sendDiscordNewsMessage("<@&1047168915500966048> The server has opened!\n" +
                    "\n" +
                    "**Rules and Info**\n" +
                    "- The end will open in 2 weeks\n" +
                    "- 10k by 10k map size (will be expanded to 25k by 25k next weekend)\n" +
                    "- Custom items /recipes and runes /runes will be enabled next weekend\n" +
                    "- Current difficulty easy, will be set to normal on Wednesday and hard next weekend\n" +
                    "- Combat logging (90 seconds)\n" +
                    "- [/prefix for custom prefix with rgb colors](https://www.birdflop.com/resources/rgb/) \n" +
                    "- Do /help /rules in game for more\n" +
                    "\n" +
                    "Java IP is **NapPixel.tk** and port is **25565** if needed.\n" +
                    "For bedrock its **NapPixel.tk** and port is **19132** if needed.\n" +
                    "**1.21** is the recommended version, but it is compatible with **1.7-1.21**\n" +
                    "\n" +
                    "**NOTE**\n" +
                    "Each person will have their own individual newbie protection for 3 hours along with 5 hours playtime tracking protection. \n" +
                    "\n" +
                    "Anyways goodluck! And fyi if you don't want to be tracked you and use an invis potion!", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(END_OPEN_TIME.minusDays(3))
                && !isTimePassed(END_OPEN_TIME.minusDays(2).minusHours(23).minusMinutes(59))) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> End will be opening in " + formatDuration(Duration.between(END_OPEN_TIME, ZonedDateTime.now(ZoneId.of("America/New_York")))) + " exactly!", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(END_OPEN_TIME.minusDays(1))
                && !isTimePassed(END_OPEN_TIME.minusHours(23).minusMinutes(59))) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> End will be opening in exactly 24 hours! Be prepared, this is a mid-season 1st end fight with the 2nd one being at the end of season, and to spice things up, whoever has the dragon egg in their inventory will get a perk! Furthermore dragon will drop 1 and only dragon rune and custom lifesteal stick when killed!", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(END_OPEN_TIME.minusHours(1))
                && !isTimePassed(END_OPEN_TIME.minusMinutes(59))) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> End will be opening in " + formatDuration(Duration.between(SEASON_START_TIME.plusDays(14), ZonedDateTime.now(ZoneId.of("America/New_York")))) + " exactly!", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(END_OPEN_TIME.minusMinutes(10))
                && !isTimePassed(END_OPEN_TIME.minusMinutes(9))) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> End will be opening in 10 minutes! Make sure to find a stronghold and portal!", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(END_OPEN_TIME)
                && !isTimePassed(END_OPEN_TIME.plusMinutes(1))) {
            if (cooldown.isOnCooldown()) return;
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "End has now opened!");
            sendDiscordNewsEmbedTitle("End has opened!", Color.GREEN, "1032411739351941120");
            sendDiscordNewsMessage("<@&1047168915500966048> The end has opened!", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(CUSTOM_ITEMS_AND_RUNES.minusHours(14))
                && !isTimePassed(CUSTOM_ITEMS_AND_RUNES.minusHours(13).minusMinutes(59))) {
            if (cooldown.isOnCooldown()) return;
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Custom items releasing in " + formatDuration(Duration.between(CUSTOM_ITEMS_AND_RUNES, ZonedDateTime.now(ZoneId.of("America/New_York")))) + " hours! Check announcements");
            sendDiscordNewsEmbedTitle("Custom items and runes!", Color.GREEN, "1032411739351941120");
            sendDiscordNewsMessage("<@&1047168915500966048> In " + formatDuration(Duration.between(CUSTOM_ITEMS_AND_RUNES, ZonedDateTime.now(ZoneId.of("America/New_York")))) + ", custom items /recipes and runes /runes are going to be available! Map size will be expanded to 25k by 25k and difficulty will be set to hard.", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT.minusDays(3))
                && !isTimePassed(FINAL_FIGHT.minusDays(2).minusHours(23).minusMinutes(59))) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> The final fight event to conclude the season will be on Saturday, in " + formatDuration(Duration.between(SEASON_START_TIME.plusDays(28), ZonedDateTime.now(ZoneId.of("America/New_York")))) + " exactly!", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT.minusDays(1))
                && !isTimePassed(FINAL_FIGHT.minusHours(23).minusMinutes(59))) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> Final fight in exactly 24 hours! Be prepared, the last one standing will be the winner of this season!", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT.minusHours(1))
                && !isTimePassed(FINAL_FIGHT.minusMinutes(59))) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> Final fight in " + formatDuration(Duration.between(SEASON_START_TIME.plusDays(28), ZonedDateTime.now(ZoneId.of("America/New_York"))))  + " exactly!", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT.minusMinutes(10))
                && !isTimePassed(FINAL_FIGHT.minusMinutes(9))) {
            if (cooldown.isOnCooldown()) return;
            sendDiscordNewsMessage("<@&1047168915500966048> Final fight is in 10 minutes! Be ready, you will be teleported in-game", "1032411739351941120");
            cooldown.setCooldown(70);
        }

        if (isTimePassed(FINAL_FIGHT)
                && !isTimePassed(END_OPEN_TIME.plusMinutes(1))) {
            if (cooldown.isOnCooldown()) return;
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Final fight is starting!");
            sendDiscordNewsEmbedTitle("Final fight is on!", Color.GREEN, "1032411739351941120");
            sendDiscordNewsMessage("<@&1047168915500966048> Final fight has begun! May the best win goodluck!", "1032411739351941120");
            cooldown.setCooldown(70);
        }
    }

    public static long getWeeksPassed(ZonedDateTime startTime, ZonedDateTime currentTime) {
        Duration duration = Duration.between(startTime, currentTime);
        return duration.toDays() / 7;
    }

    public static long getDaysPassed(ZonedDateTime startTime, ZonedDateTime currentTime) {
        Duration duration = Duration.between(startTime, currentTime);
        return duration.toHours() / 24;
    }

    public static boolean isWeekPassed(int weekNum, long weeksPassed) {
        return weeksPassed >= weekNum;
    }

    public static boolean isTimePassed(ZonedDateTime startTime, ZonedDateTime currentTime, int days, int hours, int minutes, int seconds) {
        Duration duration = Duration.between(startTime, currentTime);
        Duration targetDuration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
        return duration.compareTo(targetDuration) >= 0;
    }

    public static boolean isTimePassed(ZonedDateTime time) {
        return ZonedDateTime.now(ZoneId.of("America/New_York")).compareTo(time) >= 0;
    }


    public static String formatDuration(Duration duration) {
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        StringBuilder formattedDuration = new StringBuilder();

        if (days != 0) {
            formattedDuration.append(days).append(" days");
        }

        if (hours != 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", ");
            }
            formattedDuration.append(hours).append(" hours");
        }

        if (minutes != 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", ");
            }
            formattedDuration.append(minutes).append(" minutes");
        }

        if (seconds != 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", ");
            }
            formattedDuration.append(seconds).append(" seconds");
        }

        return formattedDuration.toString().replace("-", "");
    }
}
