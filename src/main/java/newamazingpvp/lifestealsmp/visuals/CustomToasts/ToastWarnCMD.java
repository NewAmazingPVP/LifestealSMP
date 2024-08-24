package newamazingpvp.lifestealsmp.visuals.CustomToasts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class ToastWarnCMD implements CommandExecutor {

    private final NamespacedKey key = new NamespacedKey(lifestealSmp, UUID.randomUUID().toString());
    private final String icon = "STONE_BLOCK";
    private final String message = ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "test123...";
    private final String style = "TASK";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");

        }




        return true;


    }




    private void createAdvancement() {
        Bukkit.getUnsafe().loadAdvancement(key, "{\n" +
                "    \"criteria\": {\n" +
                "        \"trigger\": {\n" +
                "            \"trigger\": \"minecraft:impossible\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"display\": {\n" +
                "        \"icon\": {\n" +
                "            \"id\": \"minecraft:" + icon + "\"\n" +
                "        },\n" +
                "        \"title\": {\n" +
                "            \"text\": \"" + message.replace("|", "\n") + "\"\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "            \"text\": \"\"\n" +
                "        },\n" +
                "        \"background\": \"minecraft:textures/gui/advancements/backgrounds/adventure.png\",\n" +
                "        \"frame\": \"" + style.toString().toLowerCase() + "\",\n" +
                "        \"announce_to_chat\": false,\n" +
                "        \"show_toast\": true,\n" +
                "        \"hidden\": true\n" +
                "    },\n" +
                "    \"requirements\": [\n" +
                "        [\n" +
                "            \"trigger\"\n" +
                "        ]\n" +
                "    ]\n" +
                "}");
    }

    private void grantAdvancement() {

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.getAdvancementProgress(Bukkit.getAdvancement(key)).awardCriteria("trigger");
        }


    }

    private void revokeAdvancement() {

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.getAdvancementProgress(Bukkit.getAdvancement(key)).revokeCriteria("trigger");
        }

    }

    private void start() {
        createAdvancement();
        grantAdvancement();

        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
            revokeAdvancement();
        }, 10);
    }

}

