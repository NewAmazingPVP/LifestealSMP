package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.variables.Loc.endFightSpawn;
import static newamazingpvp.lifestealsmp.variables.Misc.endFightParticipants;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;
import static org.bukkit.Bukkit.getServer;

public class StartEndFight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        isEndFightEnabled = true;
        //WorldBorder worldBorder = lifestealSmp.getServer().getWorld("world_the_end").getWorldBorder();
        //worldBorder.setCenter(0, 0);
        //worldBorder.setSize(150);
        for (Player p : lifestealSmp.getServer().getOnlinePlayers()) {
            p.teleport(endFightSpawn);
            p.setInvulnerable(true);
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> p.setInvulnerable(false), 20 * 60);
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "GET READY!" + ChatColor.YELLOW + " The end fight will be starting in 60sec!");
            endFightParticipants.add(p.getName());
            //PotionEffect effect = new PotionEffect(PotionEffectType.GLOWING, 200000000, 1);
            //p.addPotionEffect(effect);

        }
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> lifestealSmp.getServer().broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "GET READY!" + ChatColor.YELLOW + " The end fight will be starting in 30sec!"), 600);
        int delay = 1000;

        for (int i = 10; i > 0; i--) {
            final int count = i;
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> {
                lifestealSmp.getServer().broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "GET READY!" + ChatColor.YELLOW + " The end fight will be starting in " + count + " seconds!");
            }, delay);

            delay += 20;
        }
        Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> lifestealSmp.getServer().broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "GO!"), 1200);
        for (Player p : lifestealSmp.getServer().getOnlinePlayers()) {
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> p.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "GO!", ChatColor.GOLD + "Good Luck!"), 1200);
        }
        Bukkit.getWorld("world_the_end").getWorldBorder().setSize(300);
        return true;
    }
}
