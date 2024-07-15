package newamazingpvp.lifestealsmp.events.raffle.functions;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Random;

import static newamazingpvp.lifestealsmp.events.raffle.ItemStacks.raffleTicket;
import static newamazingpvp.lifestealsmp.events.raffle.RaffleMain.currentRaffleEventID;

public class NormalMining {


    public static void playerMineRaffleNormal(Player player, Location loc) {


        Random rand = new Random();
        double randomNumber = rand.nextDouble();

        if (randomNumber > 0.5) {


            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[+1 Ticket]");
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
            player.getWorld().dropItemNaturally(loc, raffleTicket(currentRaffleEventID));


        }


    }

}
