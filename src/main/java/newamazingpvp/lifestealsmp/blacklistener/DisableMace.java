/*
package newamazingpvp.lifestealsmp.blacklistener;

import newamazingpvp.lifestealsmp.utility.DataBaseHelper;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.events.TimeManager.formatDuration;
import static newamazingpvp.lifestealsmp.events.TimeManager.isTimePassed;

public class DisableMace implements Listener {

    public static final DataBaseHelper maceDb;

    static {
        maceDb = new DataBaseHelper("maceCrafting.db");
        maceDb.createTable("mace_crafting", "mace_id TEXT PRIMARY KEY, crafted_at TIMESTAMP");
    }

//    @EventHandler
//    public void onCrafter(CrafterCraftEvent event) {
//        if (event.getResult().getType() == Material.MACE) {
//            event.setCancelled(true);
//        }
//    }


    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.MACE) {
            String maceId = "MACE";
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
            List<Map<String, Object>> results = maceDb.getData("mace_crafting", "mace_id = ?", maceId);
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
                if (!isTimePassed(lastCrafted.plusDays(12))) {
                    event.getWhoClicked().sendMessage(ChatColor.RED + "You must wait for some time before crafting mace (limited item) because it was recently crafted by someone.");
                    event.setCancelled(true);
                    return;
                } else {
                    Map<String, Object> updateValues = new HashMap<>();
                    updateValues.put("crafted_at", Timestamp.valueOf(now.toLocalDateTime()));
                    maceDb.updateData("mace_crafting", updateValues, "mace_id = ?", maceId);
                }
            } else {
                maceDb.insertData("mace_crafting", new String[]{"mace_id", "crafted_at"}, maceId, Timestamp.valueOf(now.toLocalDateTime()));
            }

            event.getWhoClicked().sendMessage(ChatColor.RED + "The mace is allowed but is nerfed in PVP for balance. Please refer to /rules for more information.");
            Player player = (Player) event.getView().getPlayer();
            player.sendTitle(ChatColor.RED + "WARNING!", "The mace is allowed but is nerfed in PVP for balance.");
        }
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getType() == InventoryType.CRAFTING && event.getSlotType() == InventoryType.SlotType.RESULT) {
            ItemStack item = event.getCurrentItem();
            if (item != null && item.getType() == Material.MACE) {
                */
/*event.setCancelled(true);
                if (event.getWhoClicked() instanceof Player) {
                    event.getWhoClicked().sendMessage(ChatColor.RED + "Crafting mace in your inventory is disabled.");
                }*//*


                String maceId = "MACE";
                ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
                List<Map<String, Object>> results = maceDb.getData("mace_crafting", "mace_id = ?", maceId);
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
                    if (!isTimePassed(lastCrafted.plusDays(12))) {
                        event.getWhoClicked().sendMessage(ChatColor.RED + "You must wait " + formatDuration(lastCrafted.plusDays(12)) + " before crafting mace (limited item) because it was recently crafted by someone.");
                        event.setCancelled(true);
                        return;
                    } else {
                        Map<String, Object> updateValues = new HashMap<>();
                        updateValues.put("crafted_at", Timestamp.valueOf(now.toLocalDateTime()));
                        maceDb.updateData("mace_crafting", updateValues, "mace_id = ?", maceId);
                    }
                } else {
                    maceDb.insertData("mace_crafting", new String[]{"mace_id", "crafted_at"}, maceId, Timestamp.valueOf(now.toLocalDateTime()));
                }

                event.getWhoClicked().sendMessage(ChatColor.RED + "The mace is allowed but is nerfed in PVP for balance. Please refer to /rules for more information.");
                Player player = (Player) event.getView().getPlayer();
                player.sendTitle(ChatColor.RED + "WARNING!", "The mace is allowed but is nerfed in PVP for balance.");
            }
        }
    }
}
*/
