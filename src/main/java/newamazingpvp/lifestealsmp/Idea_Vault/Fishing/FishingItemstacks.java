package newamazingpvp.lifestealsmp.Idea_Vault.Fishing;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FishingItemstacks {

    //COMMON FISH LOOT ====================================================================================================
    public static ItemStack fishBone(){
        ItemStack item = new ItemStack(Material.BONE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.valueOf("#dbdbdb") + "§lFish Bone");
        List<String> lore = new ArrayList<>();
        lore.add("§3Its dead... How did it bite?");
        lore.add("§f§l[Common Fish]");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack cod(){
        ItemStack item = new ItemStack(Material.COD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.valueOf("#935300") + "§lCod");
        List<String> lore = new ArrayList<>();
        lore.add("§3Who knew, a fish named after a FPS game!");
        lore.add("§f§l[Common Fish]");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack salmon(){
        ItemStack item = new ItemStack(Material.SALMON);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.valueOf("#d84403") + "§lSalmon");
        List<String> lore = new ArrayList<>();
        lore.add("§3Fun Fact: Hold this next to a bear to see God faster.");
        lore.add("§f§l[Common Fish]");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack tropicalFish(){
        ItemStack item = new ItemStack(Material.TROPICAL_FISH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.valueOf("#ffc101") + "§lTropical Fish");
        List<String> lore = new ArrayList<>();
        lore.add("§3Put Tropical in front of anything... it sounds 10X more fancy.");
        lore.add("§f§l[Common Fish]");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack pufferfish(){
        ItemStack item = new ItemStack(Material.PUFFERFISH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.valueOf("#c9ff00") + "§lPufferfish");
        List<String> lore = new ArrayList<>();
        lore.add("§3Go ahead... eat it... see what happens...");
        lore.add("§f§l[Common Fish]");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack anchovy(){
        ItemStack item = new ItemStack(Material.COD); //TODO: Needs texture!
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.valueOf("#d1daad") + "§lPufferfish");
        List<String> lore = new ArrayList<>();
        lore.add("§3Go put it on pizza you fucking psychopath!");
        lore.add("§f§l[Common Fish]");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack haddock(){
        ItemStack item = new ItemStack(Material.COD); //TODO: Needs texture!
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.valueOf("#e6d4f4") + "§lHaddock");
        List<String> lore = new ArrayList<>();
        lore.add("§3I did not know this was a fish either.");
        lore.add("§f§l[Common Fish]");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack clownFish(){
        ItemStack item = new ItemStack(Material.TROPICAL_FISH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.valueOf("#e77700") + "§lClown Fish");

        Random rand = new Random();
        int randomJoke = rand.nextInt(10);
        List<String> lore = new ArrayList<>();

        if(randomJoke == 0){
            lore.add("§3What is a pirate’s favorite fish? A swordfish.");
        }else if(randomJoke == 1){
            lore.add("§3What do you call a lazy Crawfish? A slobster.");
        }else if(randomJoke == 2){
            lore.add("§3Where do you find a fish in orbit? Trouter space.");
        }else if(randomJoke == 3){
            lore.add("§3What’s the fastest fish in the lake? A motor-Pike.");
        }else if(randomJoke == 4){
            lore.add("§3Why don’t fish like basketball? Because they’re afraid of the net!");
        }else if(randomJoke == 5){
            lore.add("§3Why are fish so easy to weigh? Because they have their own scales.");
        }else if(randomJoke == 6){
            lore.add("§3Why didn’t the fish pass their exams? They worked below C – level.");
        }else if(randomJoke == 7){
            lore.add("§3What happens when you mix a fish and a banker? You get a loan shark.");
        }else if(randomJoke == 8){
            lore.add("§3What did the shark say after eating a clownfish? That tasted a little bit funny!");
        }else {
            lore.add("§3How do you kill a fish? You fuck it.");
        }

        lore.add("§f§l[Common Fish]");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }


    //LEGENDARY FISH LOOT ====================================================================================================

                //added as joke because people keep asking for them
    public static ItemStack prisonUniformChstplate(){
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Prisoner Uniform Chestplate");
        chestplateMeta.setColor(Color.fromRGB(255, 85, 0));
        List<String> CHESTPLATELORE = new ArrayList<>();
        CHESTPLATELORE.add(ChatColor.DARK_RED + "Go to prison you fucking criminal!");
        chestplateMeta.setLore(CHESTPLATELORE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplate.setItemMeta(chestplateMeta);
        return chestplate;
    }

    public static ItemStack prisonUniformLeggings(){
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        leggingsMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Prisoner Uniform Leggings");
        leggingsMeta.setColor(Color.fromRGB(255, 85, 0));
        List<String> LEGGINGSLORE = new ArrayList<>();
        LEGGINGSLORE.add(ChatColor.DARK_RED + "Prisoner probably drowned trying to escape...");
        leggingsMeta.setLore(LEGGINGSLORE);
        leggingsMeta.addItemFlags(ItemFlag.HIDE_DYE);
        leggings.setItemMeta(leggingsMeta);
        return leggings;
    }

    public static ItemStack prisonUniformBoots(){
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Prisoner Uniform");
        bootsMeta.setColor(Color.fromRGB(255, 85, 0));
        List<String> BOOTSLORE = new ArrayList<>();
        BOOTSLORE.add(ChatColor.DARK_RED + "Fun Fact: NAP has been to jail!"); //do not change this or bad things will happen =D
        bootsMeta.setLore(BOOTSLORE);
        bootsMeta.addItemFlags(ItemFlag.HIDE_DYE);
        boots.setItemMeta(bootsMeta);
        return boots;
    }

}
