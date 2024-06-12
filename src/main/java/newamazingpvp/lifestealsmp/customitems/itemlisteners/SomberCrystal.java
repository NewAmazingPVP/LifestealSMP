package newamazingpvp.lifestealsmp.customitems.itemlisteners;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static newamazingpvp.lifestealsmp.customitems.itemlisteners.FeatherSword.getString;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.totemDisabledItem;
import static newamazingpvp.lifestealsmp.wip.mcbingo.gui.BingoCardGUIs.BingoPickaxeRecipeGUI;

public class SomberCrystal implements Listener {

    private static final Map<Player, Long> somberCooldowns = new HashMap<>();
    private final long somberMaxTime = 5000;//300000
    @EventHandler
    public void playerHitPlayer(EntityDamageByEntityEvent e) {


        Entity damagedPlayer = e.getEntity();
        Location loc = e.getDamager().getLocation();

        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            ItemMeta meta = itemInHand.getItemMeta();
            if (meta != null && meta.getLore() != null && meta.getLore().toString().contains("Disables totems of undying on someone for 5min")) {
                if (damagedPlayer instanceof Player) {



                    setSomberTimer((Player) damagedPlayer);
                    for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
                        onlineplayer.playSound(loc, Sound.BLOCK_GLASS_BREAK, 2.0f, 1.0f);
                        onlineplayer.playSound(loc, Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 2.0f, 0.0f);





                    }

                    if (itemInHand.getAmount() > 1) {
                        itemInHand.setAmount(itemInHand.getAmount() - 1);
                        player.getInventory().setItemInMainHand(itemInHand);
                    } else {
                        player.getInventory().setItemInMainHand(null);
                    }
                }
            }
        }
    }


    @EventHandler
    public void playerMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        if(!isTeleportCooldownExpired(player)){
            removeTotems(player);
        }else{
            addTotems(player);
        }
    }

    @EventHandler
    public void onPlayerRightClick(BlockPlaceEvent e) {

        Player player = e.getPlayer();
        ItemStack itemInHand = player.getItemInHand();

        if (itemInHand != null && itemInHand.getType() == Material.BEDROCK && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Disabled For 5min")) {
            player.playSound(player.getLocation(), Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 2.0f);
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Disabled for " + cooldownRemainingTime(player)+".");
        }

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        ItemStack itemInHand = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();

        if (itemInHand != null && itemInHand.getType() == Material.BEDROCK && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Disabled For 5min")) {
            player.playSound(player.getLocation(), Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 2.0f);
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Disabled for " + cooldownRemainingTime(player)+".");
        }

    }



    private static void removeTotems(Player player){

        for (int i = 0; i < player.getInventory().getSize(); i++) {
            ItemStack item = player.getInventory().getItem(i);

            if (item!= null && item.getType() == Material.TOTEM_OF_UNDYING) {
                player.getInventory().setItem(i, new ItemStack(totemDisabledItem()));
                break; // Stop checking once we've replaced the first Totem

            }
        }
    }

    private static void addTotems(Player player){

        for (int i = 0; i < player.getInventory().getSize(); i++) {
            ItemStack item = player.getInventory().getItem(i);

            if (item!= null && item.getType() == Material.BEDROCK) {
                player.getInventory().setItem(i, new ItemStack(Material.TOTEM_OF_UNDYING));
                break; // Stop checking once we've replaced the first Totem

            }
        }
    }



    private boolean isTeleportCooldownExpired(Player player) {
        if (somberCooldowns.containsKey(player)) {
            long lastTeleportTime = somberCooldowns.get(player);
            long currentTime = System.currentTimeMillis();
            return currentTime - lastTeleportTime >= somberMaxTime;
        }
        return true;
    }


    public static void setSomberTimer(Player player) {
        somberCooldowns.put(player, System.currentTimeMillis());
    }

    private String cooldownRemainingTime(Player player) {
        return getString(player, somberCooldowns, (long) somberMaxTime);
    }


}
