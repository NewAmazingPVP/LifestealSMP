package newamazingpvp.lifestealsmp.Idea_Vault.Fishing;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static newamazingpvp.lifestealsmp.Idea_Vault.Fishing.FishingItemstacks.*;

public class FishingLootGen {

    public static final ArrayList<ItemStack> commonFishLoot = new ArrayList<>(List.of(fishBone(), cod(), salmon(), tropicalFish(), pufferfish(), anchovy(), haddock(), clownFish(),
            new ItemStack(Material.LILY_PAD), new ItemStack(Material.BOW), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER_BOOTS),
            new ItemStack(Material.ROTTEN_FLESH), new ItemStack(Material.STICK), new ItemStack(Material.STRING), new ItemStack(Material.GLASS_BOTTLE), new ItemStack(Material.BONE),
            new ItemStack(Material.INK_SAC), new ItemStack(Material.TRIPWIRE_HOOK))); //Fishing rod loot type not implemented
    public static final ArrayList<ItemStack> rareFishLoot = new ArrayList<>(List.of(new ItemStack(Material.NAME_TAG), new ItemStack(Material.NAUTILUS_SHELL), new ItemStack(Material.SADDLE))); // Enchant book and Bow and Fishing rod loot type not implemented
    public static final ArrayList<ItemStack> legendaryFishLoot = new ArrayList<>(List.of(prisonUniformChstplate(), prisonUniformLeggings(), prisonUniformBoots()));
    public static final ArrayList<ItemStack> godlyFishLoot = new ArrayList<>(List.of(new ItemStack(Material.NETHER_STAR)));


    public static ItemStack generateFishingDrop(Player player) {

        //60% common | 30% rare | 9% legendary | 1% godly TODO: adjust to make more balanced also odds are a little off in code
        Random rand = new Random();
        int lootRarity = rand.nextInt(101);

        if (lootRarity <= 60) {

            int randomIndex = rand.nextInt(commonFishLoot.size());
            return commonFishLoot.get(randomIndex);

        } else if (lootRarity <= 90) {

            int randomIndex = rand.nextInt(rareFishLoot.size());
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 2.0f);
            player.sendMessage(ChatColor.valueOf("#00e8ff") + "§l[Fishing] " + ChatColor.valueOf("#00ffcd") + "You fished up " + ChatColor.BLUE + "§lRare " +  ChatColor.valueOf("#00ffcd") + "loot!");
            return rareFishLoot.get(randomIndex);

        } else if (lootRarity <= 99) {

            int randomIndex = rand.nextInt(legendaryFishLoot.size());
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0f, 2.0f);
            player.sendMessage(ChatColor.valueOf("#00e8ff") + "§l[Fishing] " + ChatColor.valueOf("#00ffcd") + "You fished up " + ChatColor.GOLD + "§lLegendary " +  ChatColor.valueOf("#00ffcd") + "loot!");
            return legendaryFishLoot.get(randomIndex);

        } else {

            int randomIndex = rand.nextInt(godlyFishLoot.size());
            player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 2.0f, 1.0f);
            player.sendMessage(ChatColor.valueOf("#00e8ff") + "§l[Fishing] " + ChatColor.valueOf("#00ffcd") + "You fished up " + ChatColor.LIGHT_PURPLE + "§lGODLY " +  ChatColor.valueOf("#00ffcd") + "loot!!!");
            return godlyFishLoot.get(randomIndex);

        }

    }

}
