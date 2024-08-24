package newamazingpvp.lifestealsmp.visuals.CustomToasts;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public final class PlayerJoinToastCreate {

    private final NamespacedKey key;
    private final String icon;
    private final String message;
    private final CreateCustomToast.Style style;
    //private final String player;

    private PlayerJoinToastCreate(String icon, String message, CreateCustomToast.Style style) {
        this.key = new NamespacedKey(lifestealSmp, UUID.randomUUID().toString());
        this.icon = icon;
        this.message = message;
        this.style = style;
        //this.player = player;
    }

    private void start(String player) {
        createAdvancement(player);
        grantAdvancement();

        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
            revokeAdvancement();
        }, 25);
    }

    //line 8 in json map changed item to id for test

    private void createAdvancement(String playerName) {
        Bukkit.getUnsafe().loadAdvancement(key, "{\n" +
                "    \"criteria\": {\n" +
                "        \"trigger\": {\n" +
                "            \"trigger\": \"minecraft:impossible\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"display\": {\n" +
                "        \"icon\": {\n" +
                "            \"id\": \"minecraft:" + icon + "\"\n" +
                "            \"nbt\": \"[profile=PlayerNameHere]\"\n" +
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


    public static void displayTo(String icon, String message, CreateCustomToast.Style style, String player) {
        new PlayerJoinToastCreate(icon, message, style).start(player);
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

    public static enum Style {
        GOAL,
        TASK,
        CHALLENGE
    }


}
