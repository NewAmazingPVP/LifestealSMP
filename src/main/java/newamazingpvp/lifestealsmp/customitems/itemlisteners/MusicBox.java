package newamazingpvp.lifestealsmp.customitems.itemlisteners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.wip.mcbingo.gui.BingoGUIItems.*;

public class MusicBox implements Listener {

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemMeta meta = event.getItem().getItemMeta();
        ItemStack item = player.getInventory().getItemInMainHand();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                event.hasItem() && event.getItem().getType() == Material.FEATHER) {
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box")) {
                if (meta.getLore() == null) return;

                openMusicBoxGUI(player);
                player.sendMessage("test");


            }
        }
    }


    @EventHandler
    public void playerPlaceBlock(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Music Box")) {
            e.setCancelled(true);
        }
    }



    private static void stopMusic(Player player){
        player.stopSound(Sound.MUSIC_DISC_13);
        player.stopSound(Sound.MUSIC_DISC_CAT);
        player.stopSound(Sound.MUSIC_DISC_BLOCKS);
        player.stopSound(Sound.MUSIC_DISC_CHIRP);
        player.stopSound(Sound.MUSIC_DISC_FAR);
        player.stopSound(Sound.MUSIC_DISC_MALL);
        player.stopSound(Sound.MUSIC_DISC_MELLOHI);
        player.stopSound(Sound.MUSIC_DISC_STAL);
        player.stopSound(Sound.MUSIC_DISC_STRAD);
        player.stopSound(Sound.MUSIC_DISC_WARD);
        player.stopSound(Sound.MUSIC_DISC_11);
        player.stopSound(Sound.MUSIC_DISC_WAIT);
        player.stopSound(Sound.MUSIC_DISC_OTHERSIDE);
        player.stopSound(Sound.MUSIC_DISC_RELIC);
        player.stopSound(Sound.MUSIC_DISC_5);
        player.stopSound(Sound.MUSIC_DISC_PIGSTEP);
    }



    private static void openMusicBoxGUI(Player player){

        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 2.0f);

        Inventory musicBoxGUI = Bukkit.createInventory(player, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box");

        musicBoxGUI.setItem(0, orangeGlassGUI());
        musicBoxGUI.setItem(1, orangeGlassGUI());
        musicBoxGUI.setItem(2, orangeGlassGUI());




        player.openInventory(musicBoxGUI);

    }



    //GUI items for the GUI


    ItemStack disc1 = new ItemStack(Material.MUSIC_DISC_13);
    ItemStack disc2 = new ItemStack(Material.MUSIC_DISC_CAT);
    ItemStack disc3 = new ItemStack(Material.MUSIC_DISC_BLOCKS);
    ItemStack disc4 = new ItemStack(Material.MUSIC_DISC_CHIRP);
    ItemStack disc5 = new ItemStack(Material.MUSIC_DISC_FAR);
    ItemStack disc6 = new ItemStack(Material.MUSIC_DISC_MALL);
    ItemStack disc7 = new ItemStack(Material.MUSIC_DISC_MELLOHI);
    ItemStack disc8 = new ItemStack(Material.MUSIC_DISC_STAL);
    ItemStack disc9 = new ItemStack(Material.MUSIC_DISC_STRAD);
    ItemStack disc10 = new ItemStack(Material.MUSIC_DISC_WARD);
    ItemStack disc11 = new ItemStack(Material.MUSIC_DISC_11);
    ItemStack disc12 = new ItemStack(Material.MUSIC_DISC_WAIT);
    ItemStack disc13 = new ItemStack(Material.MUSIC_DISC_OTHERSIDE);
    ItemStack disc14 = new ItemStack(Material.MUSIC_DISC_RELIC);
    ItemStack disc15 = new ItemStack(Material.MUSIC_DISC_5);
    ItemStack disc16 = new ItemStack(Material.MUSIC_DISC_PIGSTEP);






}

