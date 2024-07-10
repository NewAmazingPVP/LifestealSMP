package newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Enigma.EnigmaEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.Random;

import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleItemStacks.raffleTicket;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleMain.currentRaffleEventID;
import static newamazingpvp.lifestealsmp.unused.mcbingo.gui.BingoCardGUI.OpenTheBingoCardGUI;


public class EnigmaGUI implements Listener {


    @EventHandler
    public void playerClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack itemInHand = e.getCurrentItem();
        Inventory inv = e.getClickedInventory();


        //GUI RED
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Click All The Red]")) {

            if (e.getCurrentItem() == null) {
                return;
            }

            if (itemInHand != null && itemInHand.getType() == Material.RED_CONCRETE && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Red]")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 2.0f);
                e.setCurrentItem(new ItemStack(correctGlass()));
            } else if (itemInHand != null && itemInHand.getType() == Material.LIME_STAINED_GLASS && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "✔")) {
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2.0f, 0.0f);
            } else {
                double hpToDamage = (player.getHealth() / 2);
                player.damage(hpToDamage);
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 2.0f, 0.0f);
                player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Fail!] -1/2 your current HP! (" + hpToDamage + " ❤)");
                player.closeInventory();
            }

            ItemStack[] items = inv.getContents();
            for (int i = 0; i < items.length; i++) {
                ItemStack item = items[i];
                if (item != null && item.getType() == Material.RED_CONCRETE) {
                    break;
                } else if (i >= 53) {
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0f, 1.0f);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]");
                    player.sendTitle(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]", " ", 0, 80, 0);
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                }
            }

            e.setCancelled(true);

        }


        //GUI ORANGE
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "[Click All The Orange]")) {

            if (e.getCurrentItem() == null) {
                return;
            }

            if (itemInHand != null && itemInHand.getType() == Material.ORANGE_CONCRETE && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "[Orange]")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 2.0f);
                e.setCurrentItem(new ItemStack(correctGlass()));
            } else if (itemInHand != null && itemInHand.getType() == Material.LIME_STAINED_GLASS && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "✔")) {
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2.0f, 0.0f);
            } else {
                double hpToDamage = (player.getHealth() / 2);
                player.damage(hpToDamage);
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 2.0f, 0.0f);
                player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Fail!] -1/2 your current HP! (" + hpToDamage + " ❤)");
                player.closeInventory();
            }

            ItemStack[] items = inv.getContents();
            for (int i = 0; i < items.length; i++) {
                ItemStack item = items[i];
                if (item != null && item.getType() == Material.ORANGE_CONCRETE) {
                    break;
                } else if (i >= 53) {
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0f, 1.0f);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]");
                    player.sendTitle(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]", " ", 0, 80, 0);
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                }
            }

            e.setCancelled(true);


        }

        //GUI YELLOW
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Click All The Yellow]")) {

            if (e.getCurrentItem() == null) {
                return;
            }

            if (itemInHand != null && itemInHand.getType() == Material.YELLOW_CONCRETE && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Yellow]")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 2.0f);
                e.setCurrentItem(new ItemStack(correctGlass()));
            } else if (itemInHand != null && itemInHand.getType() == Material.LIME_STAINED_GLASS && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "✔")) {
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2.0f, 0.0f);
            } else {
                double hpToDamage = (player.getHealth() / 2);
                player.damage(hpToDamage);
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 2.0f, 0.0f);
                player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Fail!] -1/2 your current HP! (" + hpToDamage + " ❤)");
                player.closeInventory();
            }

            ItemStack[] items = inv.getContents();
            for (int i = 0; i < items.length; i++) {
                ItemStack item = items[i];
                if (item != null && item.getType() == Material.YELLOW_CONCRETE) {
                    break;
                } else if (i >= 53) {
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0f, 1.0f);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]");
                    player.sendTitle(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]", " ", 0, 80, 0);
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                }
            }


            e.setCancelled(true);

        }

        //GUI GREEN
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Click All The Green]")) {

            if (e.getCurrentItem() == null) {
                return;
            }

            if (itemInHand != null && itemInHand.getType() == Material.GREEN_CONCRETE && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Green]")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 2.0f);
                e.setCurrentItem(new ItemStack(correctGlass()));
            } else if (itemInHand != null && itemInHand.getType() == Material.LIME_STAINED_GLASS && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "✔")) {
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2.0f, 0.0f);
            } else {
                double hpToDamage = (player.getHealth() / 2);
                player.damage(hpToDamage);
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 2.0f, 0.0f);
                player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Fail!] -1/2 your current HP! (" + hpToDamage + " ❤)");
                player.closeInventory();
            }

            ItemStack[] items = inv.getContents();
            for (int i = 0; i < items.length; i++) {
                ItemStack item = items[i];
                if (item != null && item.getType() == Material.GREEN_CONCRETE) {
                    break;
                } else if (i >= 53) {
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0f, 1.0f);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]");
                    player.sendTitle(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]", " ", 0, 80, 0);
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                }
            }

            e.setCancelled(true);


        }

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[Click All The Blue]")) {

            if (e.getCurrentItem() == null) {
                return;
            }

            if (itemInHand != null && itemInHand.getType() == Material.BLUE_CONCRETE && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[Blue]")) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 2.0f);
                e.setCurrentItem(new ItemStack(correctGlass()));
            } else if (itemInHand != null && itemInHand.getType() == Material.LIME_STAINED_GLASS && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "✔")) {
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2.0f, 0.0f);
            } else {
                double hpToDamage = (player.getHealth() / 2);
                player.damage(hpToDamage);
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 2.0f, 0.0f);
                player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Fail!] -1/2 your current HP! (" + hpToDamage + " ❤)");
                player.closeInventory();
            }

            ItemStack[] items = inv.getContents();
            for (int i = 0; i < items.length; i++) {
                ItemStack item = items[i];
                if (item != null && item.getType() == Material.BLUE_CONCRETE) {
                    break;
                } else if (i >= 53) {
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0f, 1.0f);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]");
                    player.sendTitle(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+5 Tickets]", " ", 0, 80, 0);
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                    player.getInventory().addItem(raffleTicket(currentRaffleEventID));
                }

                e.setCancelled(true);
            }


        }


    }

    @EventHandler
    public void playerClick(InventoryCloseEvent e) {

        Player player = (Player) e.getPlayer();
        Inventory savedMenu = e.getInventory();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Click All The Red]")) {

            player.openInventory(savedMenu);

        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "[Click All The Orange]")) {

            player.openInventory(savedMenu);

        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Click All The Yellow]")) {

            player.openInventory(savedMenu);

        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Click All The Green]")) {

            player.openInventory(savedMenu);

        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[Click All The Blue]")) {

            player.openInventory(savedMenu);

        }



    }














    private static final List<ItemStack> GUIItems = List.of(redGUI(), orangeGUI(), yellowGUI(), greenGUI(),blueGUI());


    public static void startEnigmaMobPuzzle(Player player){

        Inventory EnigmaGUI1 = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Click All The Red]");
        Inventory EnigmaGUI2 = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "[Click All The Orange]");
        Inventory EnigmaGUI3 = Bukkit.createInventory(player, 54, ChatColor.YELLOW + "" + ChatColor.BOLD + "[Click All The Yellow]");
        Inventory EnigmaGUI4 = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Click All The Green]");
        Inventory EnigmaGUI5 = Bukkit.createInventory(player, 54, ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[Click All The Blue]");

        List<Inventory> GUIs = List.of(EnigmaGUI1, EnigmaGUI2, EnigmaGUI3, EnigmaGUI4,EnigmaGUI5);

        Random random = new Random();
        int randomGUI = random.nextInt(GUIs.size());
        Inventory selectedMenu = GUIs.get(randomGUI);

        fillEnigmaGUIWithThings(selectedMenu);

        player.openInventory(selectedMenu);


    }

    public static void fillEnigmaGUIWithThings(Inventory gui) {

        Random random = new Random();

        for (int i = 0; i < gui.getSize(); i++) {

            int randomIndex = random.nextInt(GUIItems.size());
            ItemStack generatedItem = GUIItems.get(randomIndex);

            gui.setItem(i, generatedItem);

        }
    }








    //Item stacks for the GUI

    public static ItemStack redGUI() {
        ItemStack raffleTicket = new ItemStack(Material.RED_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Red]");
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    private static ItemStack orangeGUI() {
        ItemStack raffleTicket = new ItemStack(Material.ORANGE_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "[Orange]");
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    private static ItemStack yellowGUI() {
        ItemStack raffleTicket = new ItemStack(Material.YELLOW_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Yellow]");
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    private static ItemStack greenGUI() {
        ItemStack raffleTicket = new ItemStack(Material.GREEN_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Green]");
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    private static ItemStack blueGUI() {
        ItemStack raffleTicket = new ItemStack(Material.BLUE_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[Blue]");
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    private static ItemStack correctGlass() {
        ItemStack raffleTicket = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "✔");
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }



}
