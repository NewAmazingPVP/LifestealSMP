package newamazingpvp.lifestealsmp.customitems.unused;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static newamazingpvp.lifestealsmp.MinecraftBINGO.BingoGUI.BingoGUIItems.*;

public class RecipeBook implements Listener {


    @EventHandler
    public void playerOpenBINOCard(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemMeta meta = e.getItem().getItemMeta();

        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                e.hasItem() && e.getItem().getType() == Material.PAINTING) {

            if (meta.getLore() == null) {
                return;
            }

            if (meta.getLore().toString().contains("Right Click To View Recipes")) {

                openCustomRecipesGUIMAIN(player);

            }
        }
    }










    public static void openARecipePageForAItem(Player player, String itemName, ItemStack SLOT1, ItemStack SLOT2, ItemStack SLOT3, ItemStack SLOT4, ItemStack SLOT5, ItemStack SLOT6, ItemStack SLOT7, ItemStack SLOT8, ItemStack SLOT9, ItemStack OUTPUT){

        Inventory openARecipePageForAItem = Bukkit.createInventory(player, 45, ChatColor.GOLD + "" + ChatColor.BOLD + itemName + " Recipe");

        openARecipePageForAItem.setItem(0,orangeGlassGUI());                     //Crafting Menu Layout          1 2 3
        openARecipePageForAItem.setItem(1,orangeGlassGUI());                     //                              4 5 6
        openARecipePageForAItem.setItem(2,orangeGlassGUI());                     //                              7 8 9
        openARecipePageForAItem.setItem(3,orangeGlassGUI());
        openARecipePageForAItem.setItem(4,orangeGlassGUI());
        openARecipePageForAItem.setItem(5,orangeGlassGUI());
        openARecipePageForAItem.setItem(6,orangeGlassGUI());
        openARecipePageForAItem.setItem(7,orangeGlassGUI());
        openARecipePageForAItem.setItem(8,orangeGlassGUI());

        openARecipePageForAItem.setItem(9,orangeGlassGUI());
        openARecipePageForAItem.setItem(10,orangeGlassGUI());
        openARecipePageForAItem.setItem(11,SLOT1);             //SLOT1
        openARecipePageForAItem.setItem(12,SLOT2);              //SLOT2
        openARecipePageForAItem.setItem(13,SLOT3);            //SLOT3
        openARecipePageForAItem.setItem(14,orangeGlassGUI());
        openARecipePageForAItem.setItem(15,orangeGlassGUI());
        openARecipePageForAItem.setItem(16,orangeGlassGUI());
        openARecipePageForAItem.setItem(17,orangeGlassGUI());

        openARecipePageForAItem.setItem(18,orangeGlassGUI());
        openARecipePageForAItem.setItem(19,orangeGlassGUI());
        openARecipePageForAItem.setItem(20,SLOT4);            //SLOT4
        openARecipePageForAItem.setItem(21,SLOT5);              //SLOT5
        openARecipePageForAItem.setItem(22,SLOT6);             //SLOT6
        openARecipePageForAItem.setItem(23,orangeGlassGUI());
        openARecipePageForAItem.setItem(24,OUTPUT);    //OUTPUT
        openARecipePageForAItem.setItem(25,orangeGlassGUI());
        openARecipePageForAItem.setItem(26,orangeGlassGUI());

        openARecipePageForAItem.setItem(27,orangeGlassGUI());
        openARecipePageForAItem.setItem(28,orangeGlassGUI());
        openARecipePageForAItem.setItem(29,SLOT7);                //SLOT7
        openARecipePageForAItem.setItem(30,SLOT8);              //SLOT8
        openARecipePageForAItem.setItem(31,SLOT9);             //SLOT9
        openARecipePageForAItem.setItem(32,orangeGlassGUI());
        openARecipePageForAItem.setItem(33,orangeGlassGUI());
        openARecipePageForAItem.setItem(34,orangeGlassGUI());
        openARecipePageForAItem.setItem(35,orangeGlassGUI());

        openARecipePageForAItem.setItem(36,backGUI());
        openARecipePageForAItem.setItem(37,orangeGlassGUI());
        openARecipePageForAItem.setItem(38,orangeGlassGUI());
        openARecipePageForAItem.setItem(39,orangeGlassGUI());
        openARecipePageForAItem.setItem(40,orangeGlassGUI());
        openARecipePageForAItem.setItem(41,orangeGlassGUI());
        openARecipePageForAItem.setItem(42,orangeGlassGUI());
        openARecipePageForAItem.setItem(43,orangeGlassGUI());
        openARecipePageForAItem.setItem(44,closeGUI());



        player.openInventory(openARecipePageForAItem);

    }




    public static void openCustomRecipesGUIMAIN(Player player){

        Inventory openCustomRecipesGUIMAIN = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "Custom Item Recipes");


        openCustomRecipesGUIMAIN.setItem(0,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(1,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(2,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(3,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(4,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(5,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(6,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(7,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(8,orangeGlassGUI());

        openCustomRecipesGUIMAIN.setItem(9,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(10,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(11,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(12,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(13,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(14,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(15,orangeGlassGUI());
        //.setItem(16,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(17,orangeGlassGUI());

        openCustomRecipesGUIMAIN.setItem(18,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(19,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(20,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(21,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(22,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(23,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(24,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(25,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(26,orangeGlassGUI());

        openCustomRecipesGUIMAIN.setItem(27,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(28,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(29,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(30,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(31,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(32,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(33,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(34,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(35,orangeGlassGUI());

        openCustomRecipesGUIMAIN.setItem(36,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(37,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(38,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(39,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(40,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(41,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(42,orangeGlassGUI());
        //openCustomRecipesGUIMAIN.setItem(43,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(44,orangeGlassGUI());

        openCustomRecipesGUIMAIN.setItem(45,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(46,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(47,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(48,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(49,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(50,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(51,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(52,orangeGlassGUI());
        openCustomRecipesGUIMAIN.setItem(53,orangeGlassGUI());

        player.openInventory(openCustomRecipesGUIMAIN);

    }




}
