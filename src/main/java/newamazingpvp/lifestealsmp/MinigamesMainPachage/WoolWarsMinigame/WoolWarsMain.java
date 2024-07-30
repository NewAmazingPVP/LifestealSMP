package newamazingpvp.lifestealsmp.MinigamesMainPachage.WoolWarsMinigame;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.MinigamesMainPachage.WoolWarsMinigame.WoolWarsItemstacks.*;
import static newamazingpvp.lifestealsmp.utility.Utils.setPrefix;

public class WoolWarsMain {

    private static final String blueTeamPrefix = ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "[Blue]";
    private static final String redTeamPrefix = ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Red]";


    static List<Player> blueTeamWoolWars = new ArrayList<>();
    static List<Player> redTeamWoolWars = new ArrayList<>();

    public static void startWoolWarsMiniGame(){



    }


    private static void setPlayerOnBlueTeam(Player player){

        setPrefix(player, blueTeamPrefix);
        player.getInventory().setHelmet(blueTeamHelmet());
        player.getInventory().setChestplate(blueTeamChestplate());
        player.getInventory().setLeggings(blueTeamLeggings());
        player.getInventory().setBoots(blueTeamBoots());
        blueTeamWoolWars.add(player);

    }

    private static void setPlayerOnRedTeam(Player player){

        setPrefix(player, redTeamPrefix);
        player.getInventory().setHelmet(redTeamHelmet());
        player.getInventory().setChestplate(redTeamChestplate());
        player.getInventory().setLeggings(redTeamLeggings());
        player.getInventory().setBoots(redTeamBoots());
        redTeamWoolWars.add(player);

    }


}
