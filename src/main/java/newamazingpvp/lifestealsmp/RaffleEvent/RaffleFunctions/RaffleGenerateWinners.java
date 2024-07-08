package newamazingpvp.lifestealsmp.RaffleEvent.RaffleFunctions;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class RaffleGenerateWinners {

    //public static Player raffleWinner1 = null;
    //public static Player raffleWinner2 = null;
    //public static Player raffleWinner3 = null;

    private static final List<String> testWinnersREMOVE_THIS = List.of(ChatColor.AQUA + "John Doe", ChatColor.GOLD + "Comet99", ChatColor.GRAY + "NewAmazingPVP", ChatColor.GREEN + "Larry");


    public static void generateRaffleWinners(){

    }

    public static void showRaffleWinnerAnimation(){

        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> Bukkit.getOnlinePlayers().forEach(p -> p.sendTitle(org.bukkit.ChatColor.DARK_PURPLE + "" + org.bukkit.ChatColor.BOLD + "Death Beacon!", org.bukkit.ChatColor.RED + "" + org.bukkit.ChatColor.BOLD + ">30sec To Break<", 10, 40, 10)), 5);

    }

}
