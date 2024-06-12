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
import org.bukkit.event.inventory.InventoryClickEvent;
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
                event.hasItem() && event.getItem().getType() == Material.NOTE_BLOCK) {
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box")) {
                if (meta.getLore() == null) return;

                openMusicBoxGUI(player);


            }
        }
    }


    @EventHandler
    public void playerPlaceBlock(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box")) {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {

        ItemStack itemInHand = event.getCurrentItem();
        ItemMeta meta = itemInHand.getItemMeta();
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box")) {


            if (meta != null && meta.getLore() != null && meta.getLore().toString().contains("C418 - 13")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_13, 1.0f, 2.0f);
                chatMusic(player,"Disc 13");
            }


            event.setCancelled(true);

        }
    }

    private static void chatMusic(Player player, String musicName){
        player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Now playing " + musicName);
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

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);

        Inventory musicBoxGUI = Bukkit.createInventory(player, 45, ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box");

        musicBoxGUI.setItem(0, orangeGlassGUI());
        musicBoxGUI.setItem(1, orangeGlassGUI());
        musicBoxGUI.setItem(2, orangeGlassGUI());
        musicBoxGUI.setItem(3, orangeGlassGUI());
        musicBoxGUI.setItem(4, orangeGlassGUI());
        musicBoxGUI.setItem(5, orangeGlassGUI());
        musicBoxGUI.setItem(6, orangeGlassGUI());
        musicBoxGUI.setItem(7, orangeGlassGUI());
        musicBoxGUI.setItem(8, orangeGlassGUI());

        musicBoxGUI.setItem(9, orangeGlassGUI());
        musicBoxGUI.setItem(10, disc1);
        musicBoxGUI.setItem(11, disc2);
        musicBoxGUI.setItem(12, disc3);
        musicBoxGUI.setItem(13, disc4);
        musicBoxGUI.setItem(14, disc5);
        musicBoxGUI.setItem(15, disc6);
        musicBoxGUI.setItem(16, disc7);
        musicBoxGUI.setItem(17, orangeGlassGUI());

        musicBoxGUI.setItem(18, orangeGlassGUI());
        musicBoxGUI.setItem(19, disc8);
        musicBoxGUI.setItem(20, disc9);
        musicBoxGUI.setItem(21, disc10);
        musicBoxGUI.setItem(22, disc11);
        musicBoxGUI.setItem(23, disc12);
        musicBoxGUI.setItem(24, disc13);
        musicBoxGUI.setItem(25, disc14);
        musicBoxGUI.setItem(26, orangeGlassGUI());

        musicBoxGUI.setItem(27, orangeGlassGUI());
        musicBoxGUI.setItem(28, disc15);
        musicBoxGUI.setItem(29, disc16);
        //musicBoxGUI.setItem(30, orangeGlassGUI());
        //musicBoxGUI.setItem(31, orangeGlassGUI());
        //musicBoxGUI.setItem(32, orangeGlassGUI());
        //musicBoxGUI.setItem(33, orangeGlassGUI());
        //musicBoxGUI.setItem(34, orangeGlassGUI());
        musicBoxGUI.setItem(35, orangeGlassGUI());

        musicBoxGUI.setItem(36, orangeGlassGUI());
        musicBoxGUI.setItem(37, orangeGlassGUI());
        musicBoxGUI.setItem(38, orangeGlassGUI());
        musicBoxGUI.setItem(39, orangeGlassGUI());
        musicBoxGUI.setItem(40, orangeGlassGUI());
        musicBoxGUI.setItem(41, orangeGlassGUI());
        musicBoxGUI.setItem(42, orangeGlassGUI());
        musicBoxGUI.setItem(43, orangeGlassGUI());
        musicBoxGUI.setItem(44, stopAllMusicItem());




        player.openInventory(musicBoxGUI);

    }



    //GUI items for the GUI


    static ItemStack disc1 = new ItemStack(Material.MUSIC_DISC_13);
    static ItemStack disc2 = new ItemStack(Material.MUSIC_DISC_CAT);
    static ItemStack disc3 = new ItemStack(Material.MUSIC_DISC_BLOCKS);
    static ItemStack disc4 = new ItemStack(Material.MUSIC_DISC_CHIRP);
    static ItemStack disc5 = new ItemStack(Material.MUSIC_DISC_FAR);
    static ItemStack disc6 = new ItemStack(Material.MUSIC_DISC_MALL);
    static ItemStack disc7 = new ItemStack(Material.MUSIC_DISC_MELLOHI);
    static ItemStack disc8 = new ItemStack(Material.MUSIC_DISC_STAL);
    static ItemStack disc9 = new ItemStack(Material.MUSIC_DISC_STRAD);
    static ItemStack disc10 = new ItemStack(Material.MUSIC_DISC_WARD);
    static ItemStack disc11 = new ItemStack(Material.MUSIC_DISC_11);
    static ItemStack disc12 = new ItemStack(Material.MUSIC_DISC_WAIT);
    static ItemStack disc13 = new ItemStack(Material.MUSIC_DISC_OTHERSIDE);
    static ItemStack disc14 = new ItemStack(Material.MUSIC_DISC_RELIC);
    static ItemStack disc15 = new ItemStack(Material.MUSIC_DISC_5);
    static ItemStack disc16 = new ItemStack(Material.MUSIC_DISC_PIGSTEP);


    public static ItemStack stopAllMusicItem() {

        ItemStack powerStick = new ItemStack(Material.BARRIER);
        ItemMeta SI = powerStick.getItemMeta();
        SI.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Stop Music");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        powerStick.setItemMeta(SI);

        return powerStick;
    }




}

