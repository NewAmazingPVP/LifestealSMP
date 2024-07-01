package newamazingpvp.lifestealsmp.customitems.item;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
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

import static newamazingpvp.lifestealsmp.wip.mcbingo.gui.BingoGUIItems.orangeGlassGUI;

public class MusicBox implements Listener {

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!event.hasItem()) return;
        if (!event.getItem().hasItemMeta()) return;
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
        ItemStack offHanditem = player.getInventory().getItemInOffHand();
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box")) {
            e.setCancelled(true);
        }
        if (offHanditem.hasItemMeta() && offHanditem.getItemMeta().hasDisplayName() && offHanditem.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box")) {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {

        ItemStack itemInHand = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Music Box")) {


            if (itemInHand != null && itemInHand.getType() == Material.BARRIER && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Stop Music")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.0f);
                player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[Music Box] " + ChatColor.GREEN + ChatColor.BOLD + "Stopped Music");

            }


            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_13 && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Disc 13")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_13, 100.0f, 1.0f);
                chatMusic(player, "Disc 13");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_CAT && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Cat")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_CAT, 100.0f, 1.0f);
                chatMusic(player, "Cat");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_BLOCKS && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Blocks")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_BLOCKS, 100.0f, 1.0f);
                chatMusic(player, "Blocks");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_CHIRP && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Chirp")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_CHIRP, 100.0f, 1.0f);
                chatMusic(player, "Chirp");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_FAR && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Far")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_FAR, 100.0f, 1.0f);
                chatMusic(player, "Far");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_MALL && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Mall")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_MALL, 100.0f, 1.0f);
                chatMusic(player, "Mall");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_MELLOHI && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Mellohi")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_MELLOHI, 100.0f, 1.0f);
                chatMusic(player, "Mellohi");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_STAL && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Stal")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_STAL, 100.0f, 1.0f);
                chatMusic(player, "Stal");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_STRAD && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Strad")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_STRAD, 100.0f, 1.0f);
                chatMusic(player, "Stard");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_WARD && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Ward")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_WARD, 100.0f, 1.0f);
                chatMusic(player, "Ward");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_11 && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Disc 11")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_11, 100.0f, 1.0f);
                chatMusic(player, "Disc 11");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_WAIT && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Wait")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_WAIT, 100.0f, 1.0f);
                chatMusic(player, "Wait");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_OTHERSIDE && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Otherside")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_OTHERSIDE, 100.0f, 1.0f);
                chatMusic(player, "Otherside");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_RELIC && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Relic")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_RELIC, 100.0f, 1.0f);
                chatMusic(player, "Relic");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_5 && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Disc 5")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_5, 100.0f, 1.0f);
                chatMusic(player, "Disc 5");
            }

            if (itemInHand != null && itemInHand.getType() == Material.MUSIC_DISC_PIGSTEP && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Pigstep")) {
                stopMusic(player);
                player.playSound(player.getLocation(), Sound.MUSIC_DISC_PIGSTEP, 100.0f, 1.0f);
                chatMusic(player, "Pigstep");
            }

            event.setCancelled(true);

        }
    }

    private static void chatMusic(Player player, String musicName) {
        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[Music Box] " + ChatColor.GREEN + ChatColor.BOLD + "Now Playing " + musicName);
    }


    private static void stopMusic(Player player) {
        player.stopSound(Sound.MUSIC_DISC_13);//
        player.stopSound(Sound.MUSIC_DISC_CAT);//
        player.stopSound(Sound.MUSIC_DISC_BLOCKS);//
        player.stopSound(Sound.MUSIC_DISC_CHIRP);//
        player.stopSound(Sound.MUSIC_DISC_FAR);//
        player.stopSound(Sound.MUSIC_DISC_MALL);//
        player.stopSound(Sound.MUSIC_DISC_MELLOHI);//
        player.stopSound(Sound.MUSIC_DISC_STAL);//
        player.stopSound(Sound.MUSIC_DISC_STRAD);//
        player.stopSound(Sound.MUSIC_DISC_WARD);//
        player.stopSound(Sound.MUSIC_DISC_11);//
        player.stopSound(Sound.MUSIC_DISC_WAIT);//
        player.stopSound(Sound.MUSIC_DISC_OTHERSIDE);//
        player.stopSound(Sound.MUSIC_DISC_RELIC);//
        player.stopSound(Sound.MUSIC_DISC_5);//
        player.stopSound(Sound.MUSIC_DISC_PIGSTEP);//
    }


    private static void openMusicBoxGUI(Player player) {

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
        musicBoxGUI.setItem(10, disc1());
        musicBoxGUI.setItem(11, disc2());
        musicBoxGUI.setItem(12, disc3());
        musicBoxGUI.setItem(13, disc4());
        musicBoxGUI.setItem(14, disc5());
        musicBoxGUI.setItem(15, disc6());
        musicBoxGUI.setItem(16, disc7());
        musicBoxGUI.setItem(17, orangeGlassGUI());

        musicBoxGUI.setItem(18, orangeGlassGUI());
        musicBoxGUI.setItem(19, disc8());
        musicBoxGUI.setItem(20, disc9());
        musicBoxGUI.setItem(21, disc10());
        musicBoxGUI.setItem(22, disc11());
        musicBoxGUI.setItem(23, disc12());
        musicBoxGUI.setItem(24, disc13());
        musicBoxGUI.setItem(25, disc14());
        musicBoxGUI.setItem(26, orangeGlassGUI());

        musicBoxGUI.setItem(27, orangeGlassGUI());
        musicBoxGUI.setItem(28, disc15());
        musicBoxGUI.setItem(29, disc16());
        musicBoxGUI.setItem(30, stopAllMusicItem());
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
        musicBoxGUI.setItem(44, orangeGlassGUI());


        player.openInventory(musicBoxGUI);

    }


    //GUI items for the GUI


    public static ItemStack disc1() {

        ItemStack disc1 = new ItemStack(Material.MUSIC_DISC_13);
        ItemMeta SI = disc1.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Disc 13");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc1.setItemMeta(SI);

        return disc1;
    }

    public static ItemStack disc2() {

        ItemStack disc2 = new ItemStack(Material.MUSIC_DISC_CAT);
        ItemMeta SI = disc2.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Cat");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc2.setItemMeta(SI);

        return disc2;
    }

    public static ItemStack disc3() {

        ItemStack disc3 = new ItemStack(Material.MUSIC_DISC_BLOCKS);
        ItemMeta SI = disc3.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Blocks");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc3.setItemMeta(SI);

        return disc3;
    }

    public static ItemStack disc4() {

        ItemStack disc4 = new ItemStack(Material.MUSIC_DISC_CHIRP);
        ItemMeta SI = disc4.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Chirp");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc4.setItemMeta(SI);

        return disc4;
    }

    public static ItemStack disc5() {

        ItemStack disc5 = new ItemStack(Material.MUSIC_DISC_FAR);
        ItemMeta SI = disc5.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Far");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc5.setItemMeta(SI);

        return disc5;
    }

    public static ItemStack disc6() {

        ItemStack disc6 = new ItemStack(Material.MUSIC_DISC_MALL);
        ItemMeta SI = disc6.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Mall");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc6.setItemMeta(SI);

        return disc6;
    }

    public static ItemStack disc7() {

        ItemStack disc7 = new ItemStack(Material.MUSIC_DISC_MELLOHI);
        ItemMeta SI = disc7.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Mellohi");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc7.setItemMeta(SI);

        return disc7;
    }

    public static ItemStack disc8() {

        ItemStack disc8 = new ItemStack(Material.MUSIC_DISC_STAL);
        ItemMeta SI = disc8.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Stal");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc8.setItemMeta(SI);

        return disc8;
    }

    public static ItemStack disc9() {

        ItemStack disc9 = new ItemStack(Material.MUSIC_DISC_STRAD);
        ItemMeta SI = disc9.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Strad");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc9.setItemMeta(SI);

        return disc9;
    }

    public static ItemStack disc10() {

        ItemStack disc10 = new ItemStack(Material.MUSIC_DISC_WARD);
        ItemMeta SI = disc10.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Ward");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc10.setItemMeta(SI);

        return disc10;
    }

    public static ItemStack disc11() {

        ItemStack disc11 = new ItemStack(Material.MUSIC_DISC_11);
        ItemMeta SI = disc11.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Disc 11");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc11.setItemMeta(SI);

        return disc11;
    }

    public static ItemStack disc12() {

        ItemStack disc12 = new ItemStack(Material.MUSIC_DISC_WAIT);
        ItemMeta SI = disc12.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Wait");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc12.setItemMeta(SI);

        return disc12;
    }

    public static ItemStack disc13() {

        ItemStack disc13 = new ItemStack(Material.MUSIC_DISC_OTHERSIDE);
        ItemMeta SI = disc13.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Otherside");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc13.setItemMeta(SI);

        return disc13;
    }

    public static ItemStack disc14() {

        ItemStack disc14 = new ItemStack(Material.MUSIC_DISC_RELIC);
        ItemMeta SI = disc14.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Relic");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc14.setItemMeta(SI);

        return disc14;
    }

    public static ItemStack disc15() {

        ItemStack disc15 = new ItemStack(Material.MUSIC_DISC_5);
        ItemMeta SI = disc15.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Disc 5");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc15.setItemMeta(SI);

        return disc15;
    }

    public static ItemStack disc16() {

        ItemStack disc16 = new ItemStack(Material.MUSIC_DISC_PIGSTEP);
        ItemMeta SI = disc16.getItemMeta();
        SI.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Pigstep");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        SI.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        disc16.setItemMeta(SI);

        return disc16;
    }


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

