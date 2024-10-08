package newamazingpvp.lifestealsmp.unused;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;

public class DittoSkull implements Listener {


    List<Player> playersInDittoChat = new ArrayList<>();

    @EventHandler
    public void playerRightClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (e.getAction().name().contains("RIGHT_CLICK") && e.getItem() != null && itemInHand != null && itemInHand.hasItemMeta() && meta.getLore().toString().contains("and this skull will take its texture!")) {


            if (!playersInDittoChat.contains(player)) {
                playersInDittoChat.add(player);
            }

            player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "[Say a name or skin URL in chat or type cancel]");

        }
    }

    @EventHandler
    public void playerChat(PlayerChatEvent e) {
        Player player = e.getPlayer();

        String chatString = e.getMessage();

        if (playersInDittoChat.contains(player)) {
            e.setCancelled(true);

            if (chatString.equals("cancel")) {
                playersInDittoChat.remove(player);
                player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "[Canceled!]");
            } else if (chatString.length() > 70) {
                player.getInventory().addItem(dittoSkullURL(chatString));
                playersInDittoChat.remove(player);
            } else {
                player.getInventory().addItem(dittoSkullName(chatString));
                playersInDittoChat.remove(player);
            }

        }
    }


    //RecoverDittoSkullAfterItemPickup

    @EventHandler
    public void playerMove(InventoryInteractEvent e) {

        Player player = (Player) e.getWhoClicked();
        Inventory inv = player.getInventory();

        ItemStack[] items = inv.getContents();

        for (int i = 0; i < items.length; i++) {
            ItemStack item = items[i];
            ItemMeta meta = item.getItemMeta();
            if (item != null && item.getType() == Material.PLAYER_HEAD && meta.getDisplayName().contains("Ditto Skull")) {
                //player.getInventory().addItem(dittoSkull());
            }
        }
    }

    @EventHandler
    public void playerMove(PlayerPickupItemEvent e) {

        Player player = e.getPlayer();
        Inventory inv = player.getInventory();

        ItemStack[] items = inv.getContents();

        for (int i = 0; i < items.length; i++) {
            ItemStack item = items[i];
            ItemMeta meta = item.getItemMeta();
            if (item != null && item.getType() == Material.PLAYER_HEAD && meta.getDisplayName().contains("Ditto Skull")) {
                //player.getInventory().addItem(dittoSkull());
            }
        }
    }


    //ItemStacks
    public static ItemStack dittoSkullURL(String url) {

        PlayerProfile profile = getProfile(url);
        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Ditto Skull");

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Right Click]");
        lore.add(ChatColor.DARK_PURPLE + "Type a player's name or a");
        lore.add(ChatColor.DARK_PURPLE + "Minecraft skin URL from a");
        lore.add(ChatColor.DARK_PURPLE + "website such as Minecraft heads");
        lore.add(ChatColor.DARK_PURPLE + "and this skull will take its texture!");
        lore.add(ChatColor.DARK_PURPLE + "You can use it for decoration or whatever u want.");
        lore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Ask if you don't know how it works!]");


        meta.setLore(lore);


        meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;
    }

    public static ItemStack dittoSkullName(String player) {

        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Ditto Skull");

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Right Click]");
        lore.add(ChatColor.DARK_PURPLE + "Type a player's name or a");
        lore.add(ChatColor.DARK_PURPLE + "Minecraft skin URL from a");
        lore.add(ChatColor.DARK_PURPLE + "website such as Minecraft heads");
        lore.add(ChatColor.DARK_PURPLE + "and this skull will take its texture!");
        lore.add(ChatColor.DARK_PURPLE + "You can use it for decoration or whatever u want.");
        lore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Ask if you don't know how it works!]");


        meta.setLore(lore);


        meta.setOwner(player);

        //meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;
    }


}
