package newamazingpvp.lifestealsmp.visuals.CustomToasts;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public final class PlayerJoinToastCreate {

    private final NamespacedKey key;
    private final ItemStack icon;
    private final String message;
    private final CreateCustomToast.Style style;

    private PlayerJoinToastCreate(ItemStack icon, String message, CreateCustomToast.Style style) {
        this.key = new NamespacedKey(lifestealSmp, UUID.randomUUID().toString());
        this.icon = icon;
        this.message = message;
        this.style = style;
    }

    private void start() {
        createAdvancement();
        grantAdvancement();

        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
            revokeAdvancement();
        }, 25);
    }

    //line 8 in json map changed item to id for test

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

    /*private void grantAdvancement(Player player) {
        player.getAdvancementProgress(Bukkit.getAdvancement(key)).awardCriteria("trigger");
    }

    private void revokeAdvancement(Player player) {
        player.getAdvancementProgress(Bukkit.getAdvancement(key)).revokeCriteria("trigger");
    }*/

    public static void displayTo(ItemStack icon, String message, CreateCustomToast.Style style) {
        new PlayerJoinToastCreate(icon, message, style).start();
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
