package newamazingpvp.lifestealsmp.command;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.variables.Loc.endFightSpawn;
import static newamazingpvp.lifestealsmp.variables.Misc.endFightParticipants;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;
import static org.bukkit.Bukkit.getServer;

public class StartEndFight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        isEndFightEnabled = true;

        World world = Bukkit.createWorld(new WorldCreator("end_fight_world")
                .type(WorldType.NORMAL)
                .environment(World.Environment.THE_END));

        WorldBorder worldBorder = world.getWorldBorder();
        worldBorder.setCenter(0, 0);
        worldBorder.setSize(310);

        new BukkitRunnable() {
            int minutesPassed = 0;

            @Override
            public void run() {
                if (minutesPassed >= 30) {
                    this.cancel();
                    worldBorder.setSize(1);
                    Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "Border is now 1 block wide. Going outside border may instant kill you");
                    worldBorder.setDamageBuffer(0);
                    worldBorder.setDamageAmount(4);
                    worldBorder.setWarningDistance(10);
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (p.getGameMode() == GameMode.SURVIVAL) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INSTANT_DAMAGE, Integer.MAX_VALUE, 1, true, false));
                            p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1, true, false));
                            p.sendTitle(ChatColor.RED + "WARNING!", ChatColor.YELLOW + "Fight to the death, or get eliminated by instant harming!");
                        }
                    }
                    Bukkit.broadcastMessage(ChatColor.DARK_RED + "Fight to the death, or get eliminated by instant harming!");
                    return;
                }

                double newSize = worldBorder.getSize() - 10;
                Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "Border is now " + newSize + " blocks!");
                worldBorder.setSize(newSize);
                //worldBorder.setDamageBuffer(0);
                //worldBorder.setDamageAmount(1);
                //worldBorder.setWarningDistance(10);
                minutesPassed++;
            }
        }.runTaskTimer(lifestealSmp, 1200, 20 * 60);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : lifestealSmp.getServer().getOnlinePlayers()) {
                    p.teleport(endFightSpawn);
                    p.setInvulnerable(true);

                    getServer().getScheduler().runTaskLater(lifestealSmp, () -> p.setInvulnerable(false), 20 * 60);

                    p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "GET READY!" + ChatColor.YELLOW + " The end fight will be starting in 60 seconds!");
                    endFightParticipants.add(p.getName());
                }

                Bukkit.getScheduler().runTaskLater(lifestealSmp, () ->
                        lifestealSmp.getServer().broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "GET READY!" + ChatColor.YELLOW + " The end fight will be starting in 30 seconds!"), 600);

                int delay = 1000;
                for (int i = 10; i > 0; i--) {
                    final int count = i;
                    Bukkit.getScheduler().runTaskLater(lifestealSmp, () ->
                            lifestealSmp.getServer().broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "GET READY!" + ChatColor.YELLOW + " The end fight will be starting in " + count + " seconds!"), delay);
                    delay += 20;
                }

                Bukkit.getScheduler().runTaskLater(lifestealSmp, () ->
                        lifestealSmp.getServer().broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "GO!"), 1200);

                for (Player p : lifestealSmp.getServer().getOnlinePlayers()) {
                    Bukkit.getScheduler().runTaskLater(lifestealSmp, () ->
                            p.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "GO!", ChatColor.GOLD + "Good Luck!"), 1200);
                }
            }
        }.runTaskLater(lifestealSmp, 100L);

        return true;
    }
}
