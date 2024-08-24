package newamazingpvp.lifestealsmp.customitems.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
                player.getInventory().addItem(dittoSkullPlayer(chatString));
                playersInDittoChat.remove(player);
            }

        }
    }

    public static ItemStack dittoSkullURL(String URL) {

        PlayerProfile profile = getProfile(URL);
        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Used Ditto Skull");
        meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;
    }

    public static ItemStack dittoSkullPlayer(String player) {

        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setOwner(player);
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Used Ditto Skull");
        info.setItemMeta(meta);

        return info;
    }




}
