package newamazingpvp.lifestealsmp.RaffleEvent.RaffleFunctions;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Random;

import static newamazingpvp.lifestealsmp.LifestealSMP.SMPworld;
import static newamazingpvp.lifestealsmp.RaffleEvent.RaffleItemStacks.raffleTicket;

public class RaffleNormalMining {

    private static int tempTestNum = 2383847;

    public static void playerMineRaffleNormal(Player player, Location loc){


        Random rand = new Random();
        double randomNumber = rand.nextDouble();

        if (randomNumber > 0.5){


            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+1 Ticket]");
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
            player.getWorld().dropItemNaturally(loc, raffleTicket(tempTestNum));


        }


    }

}
