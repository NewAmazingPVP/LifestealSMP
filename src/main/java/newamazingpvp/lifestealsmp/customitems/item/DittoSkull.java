package newamazingpvp.lifestealsmp.customitems.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.profile.PlayerProfile;

import java.util.*;

import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;

public class DittoSkull implements Listener {


    List<Player> playersInDittoChat = new ArrayList<>();

    @EventHandler
    public void playerRightClick(PlayerInteractEvent e){

        Player player = e.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (e.getAction().name().contains("RIGHT_CLICK") && e.getItem() != null && itemInHand != null && itemInHand.hasItemMeta() && meta.getLore().toString().contains("and this skull will take its texture!")) {


            if(!playersInDittoChat.contains(player)) {
                playersInDittoChat.add(player);
            }

            player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "[Say a name or skin URL in chat or type cancel]");

        }
    }

    @EventHandler
    public void playerChat(PlayerChatEvent e){
        Player player = e.getPlayer();
        
        String chatString = e.getMessage();
        
        if(playersInDittoChat.contains(player)) {
            e.setCancelled(true);
            
            if(chatString.equals("cancel")){
                playersInDittoChat.remove(player);
                player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "[Canceled!]"); 
            } else if (chatString.length() > 70) {
                player.getInventory().addItem(dittoSkullURL(chatString));
                playersInDittoChat.remove(player);
            }else{
                player.getInventory().addItem(dittoSkullName(chatString));
                playersInDittoChat.remove(player);
            }

        }
    }



    //RecoverDittoSkullAfterItemPickup

    @EventHandler
    public void playerPickupItem(PlayerMoveEvent e) {

        Player player = e.getPlayer();
        Inventory inv = player.getInventory();


        for (int i = 0; i < player.getInventory().getSize(); i++) {
            ItemStack item = player.getInventory().getItem(i);
            if (item != null && item.getType() == Material.PLAYER_HEAD && item.getDisplayName() == ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Ditto Skull") {
                //player.getInventory().setItem(i, convertToUsableDitto());
                inv.addItem(convertToUsableDitto());
                if (item.getAmount() > 1) {
                    item.setAmount(item.getAmount() - 1);
                }
            }
        }
    }

    private static ItemStack convertToUsableDitto (){


        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/3caf617f26c177ae56eb5dcef19b1ea307df3d5567750c52dcd14f60742df641");
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
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
        item.setItemMeta(meta);

        return item;

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
