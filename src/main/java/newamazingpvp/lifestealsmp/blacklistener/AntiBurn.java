package newamazingpvp.lifestealsmp.blacklistener;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class AntiBurn implements Listener {
    /*@EventHandler
    public void onEntityCombust(EntityCombustEvent e) {
        getServer().broadcastMessage("um");
        if (e.getEntity().getType() == EntityType.ITEM) {
            System.out.println("no");
            getServer().broadcastMessage("no");
            Item i = (Item) e.getEntity();
            ItemStack item = i.getItemStack();
            if (item.hasItemMeta() && item.hasLore()){
                String lore = item.getLore().toString();
                System.out.println("yes");
                getServer().broadcastMessage("yes");
                if(lore.toLowerCase().contains("rune") ||
                        lore.toLowerCase().contains("special") ||
                        lore.toLowerCase().contains("ability") ||
                        lore.toLowerCase().contains("right") ||
                        lore.toLowerCase().contains("heart")){
                    e.setCancelled(true);
                }
            }
        }
    }*/

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Item) {
            EntityDamageEvent.DamageCause cause = event.getCause();
            if (!(cause == EntityDamageEvent.DamageCause.VOID)) {
                Item i = (Item) event.getEntity();
                ItemStack item = i.getItemStack();
                if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    String lore = item.getLore().toString();
                    if (lore.toLowerCase().contains("rune") ||
                            lore.toLowerCase().contains("special") ||
                            lore.toLowerCase().contains("ability") ||
                            lore.toLowerCase().contains("right") ||
                            lore.toLowerCase().contains("heart")) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
