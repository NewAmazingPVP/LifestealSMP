package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVision  implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (hasNightVision(player)) {
            removeNightVision(player);
            player.sendMessage(ChatColor.GREEN + "Night vision removed!");
        } else {
            giveNightVision(player);
            player.sendMessage(ChatColor.GREEN + "Night vision enabled!");
        }

        return true;
    }

    private void giveNightVision(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
    }

    private void removeNightVision(Player player) {
        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
    }

    private boolean hasNightVision(Player player) {
        return player.hasPotionEffect(PotionEffectType.NIGHT_VISION);
    }
}
