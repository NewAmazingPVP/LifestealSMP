package newamazingpvp.lifestealsmp.MinecraftBINGO;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class BingoMessageEvents {

    public static void bingoChallengeDone(Player player,String challengeName){

        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + challengeName + " Complete!");
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 3.0f, 1.0f);
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 3.0f, 2.0f), 10);


    }


}
