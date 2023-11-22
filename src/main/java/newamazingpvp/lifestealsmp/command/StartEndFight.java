package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.variables.Loc.endFightSpawn;
import static newamazingpvp.lifestealsmp.variables.Misc.endFightParticipants;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;
import static org.bukkit.Bukkit.getServer;

public class StartEndFight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        isEndFightEnabled = true;
        WorldBorder worldBorder = lifestealSmp.getServer().getWorld("world_the_end").getWorldBorder();
        worldBorder.setCenter(0, 0);
        worldBorder.setSize(100);
        for(Player p : lifestealSmp.getServer().getOnlinePlayers()){
            p.teleport(endFightSpawn);
            p.setInvulnerable(true);
            getServer().getScheduler().runTaskLater(lifestealSmp, () -> p.setInvulnerable(false), 20 * 60);
            p.sendMessage(ChatColor.AQUA + "60 seconds to get ready for the final fight!");
            endFightParticipants.add(p.getName());
            //PotionEffect effect = new PotionEffect(PotionEffectType.GLOWING, 200000000, 1);
            //p.addPotionEffect(effect);
        }
        return true;
    }
}
