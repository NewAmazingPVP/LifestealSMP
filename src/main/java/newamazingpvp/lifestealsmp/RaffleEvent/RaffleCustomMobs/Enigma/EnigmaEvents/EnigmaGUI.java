package newamazingpvp.lifestealsmp.RaffleEvent.RaffleCustomMobs.Enigma.EnigmaEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class EnigmaGUI {

    public static void startEnigmaMobPuzzle(Player player){

        Inventory EnigmaGUI1 = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Click The Red]");
        Inventory EnigmaGUI2 = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Click The Red]");
        Inventory EnigmaGUI3 = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "[Click The Orange]");
        Inventory EnigmaGUI4 = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "[Click The Orange]");
        Inventory EnigmaGUI5 = Bukkit.createInventory(player, 54, ChatColor.YELLOW + "" + ChatColor.BOLD + "[Click The Yellow]");
        Inventory EnigmaGUI6 = Bukkit.createInventory(player, 54, ChatColor.YELLOW + "" + ChatColor.BOLD + "[Click The Yellow]");
        Inventory EnigmaGUI7 = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Click The Green]");
        Inventory EnigmaGUI8 = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Click The Green]");
        Inventory EnigmaGUI9 = Bukkit.createInventory(player, 54, ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[Click The Blue]");
        Inventory EnigmaGUI10 = Bukkit.createInventory(player, 54, ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[Click The Blue]");

    }

    public static void fillEnigmaGUIWithThings(Inventory gui){

        int randomNum = (int)(Math.random() * 54);

    }








    //Item stacks for the GUI

    public static ItemStack redGUI() {
        ItemStack raffleTicket = new ItemStack(Material.RED_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Red]");
        //List<String> lore = new ArrayList<>();
        //lore.add(ChatColor.DARK_PURPLE + "Has a chance to randomly spawn");
        //meta.setLore(lore);
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    private static ItemStack orangeGUI() {
        ItemStack raffleTicket = new ItemStack(Material.ORANGE_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "[Orange]");
        //List<String> lore = new ArrayList<>();
        //lore.add(ChatColor.DARK_PURPLE + "Has a chance to randomly spawn");
        //meta.setLore(lore);
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    private static ItemStack yellowGUI() {
        ItemStack raffleTicket = new ItemStack(Material.YELLOW_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Yellow]");
        //List<String> lore = new ArrayList<>();
        //lore.add(ChatColor.DARK_PURPLE + "Has a chance to randomly spawn");
        //meta.setLore(lore);
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    private static ItemStack greenGUI() {
        ItemStack raffleTicket = new ItemStack(Material.GREEN_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[Green]");
        //List<String> lore = new ArrayList<>();
        //lore.add(ChatColor.DARK_PURPLE + "Has a chance to randomly spawn");
        //meta.setLore(lore);
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }

    private static ItemStack blueGUI() {
        ItemStack raffleTicket = new ItemStack(Material.BLUE_CONCRETE);
        ItemMeta meta = raffleTicket.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[Blue]");
        //List<String> lore = new ArrayList<>();
        //lore.add(ChatColor.DARK_PURPLE + "Has a chance to randomly spawn");
        //meta.setLore(lore);
        raffleTicket.setItemMeta(meta);
        return raffleTicket;
    }
    


}
