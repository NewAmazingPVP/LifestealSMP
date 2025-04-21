package newamazingpvp.lifestealsmp.blacklistener;

import newamazingpvp.lifestealsmp.utility.DataBaseHelper;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.customitems.utils.GUI.basicItems;
import static newamazingpvp.lifestealsmp.customitems.utils.GUI.customItems;
import static newamazingpvp.lifestealsmp.events.TimeManager.*;
import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;

public class DisableCustomItems implements Listener {

    public static final DataBaseHelper dbHelper;
    static {
        dbHelper = new DataBaseHelper("customItems.db");
        dbHelper.createTable("custom_items", "item_id TEXT PRIMARY KEY, crafted_at TIMESTAMP");
    }

//    @EventHandler
//    public void onCrafter(CrafterCraftEvent event) {
//        if(customItems.contains(event.getResult()) && !basicItems.contains(event.getResult())){
//            event.setCancelled(true);
//        }
//    }


    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        ItemStack currentItem = event.getCurrentItem();
        if (currentItem == null) {
            return;
        }
        if (customItems.contains(currentItem) && !basicItems.contains(currentItem) && !isTimePassed(CUSTOM_ITEMS_AND_RUNES)) {
            event.getWhoClicked().sendMessage(ChatColor.RED + "This custom item is not enabled yet. It will enable in " + formatDuration(CUSTOM_ITEMS_AND_RUNES));
            Player player = (Player) event.getView().getPlayer();
            player.sendTitle(ChatColor.RED + "WARNING!", ChatColor.YELLOW + "This custom item is not enabled yet. It will enable in " + formatDuration(CUSTOM_ITEMS_AND_RUNES));
            event.setCancelled(true);
            return;
        }

        if (customItems.contains(currentItem) && !basicItems.contains(currentItem)) {
            Player player = (Player) event.getWhoClicked();
            String itemId = getCustomItemId(currentItem);
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));

            List<Map<String, Object>> results = dbHelper.getData("custom_items", "item_id = ?", itemId);
            if (!results.isEmpty()) {
                Map<String, Object> record = results.get(0);
                Object craftedAtObj = record.get("crafted_at");
                Timestamp ts;
                if (craftedAtObj instanceof Long) {
                    ts = new Timestamp((Long) craftedAtObj);
                } else {
                    ts = (Timestamp) craftedAtObj;
                }
                ZonedDateTime lastCrafted = ts.toLocalDateTime().atZone(ZoneId.of("America/New_York"));
                if (!isTimePassed(lastCrafted.plusDays(1))) {
                    player.sendMessage(ChatColor.RED + "You must wait " + formatDuration(lastCrafted.plusDays(1)) + " before crafting this limited custom item because it was recently crafted by someone.");
                    event.setCancelled(true);
                    return;
                } else {
                    Map<String, Object> updateValues = new HashMap<>();
                    updateValues.put("crafted_at", Timestamp.valueOf(now.toLocalDateTime()));
                    dbHelper.updateData("custom_items", updateValues, "item_id = ?", itemId);
                }
            } else {
                dbHelper.insertData("custom_items", new String[]{"item_id", "crafted_at"}, itemId, Timestamp.valueOf(now.toLocalDateTime()));
            }
        }
    }

    private String getCustomItemId(ItemStack item) {
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            return item.getItemMeta().getDisplayName();
        }
        return item.getType().name();
    }
}
