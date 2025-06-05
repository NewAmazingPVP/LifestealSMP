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
import static newamazingpvp.lifestealsmp.variables.Misc.endFightParticipants;
import static newamazingpvp.lifestealsmp.variables.Misc.isEndFightEnabled;
import static org.bukkit.Bukkit.getServer;

public class StartEndFight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        isEndFightEnabled = true;

        World world = Bukkit.getWorld("end_fight_world");
        if (world == null) {
            world = Bukkit.createWorld(new WorldCreator("end_fight_world")
                    .type(WorldType.NORMAL)
                    .environment(World.Environment.THE_END));
        }

        World finalWorld = world;
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!isEndFightEnabled) {
                    this.cancel();
                    return;
                }
                if (finalWorld.getWorldType() == null || finalWorld.getEnvironment() == null || Bukkit.getWorld(finalWorld.getName()) == null) {
                    return;
                }

                WorldBorder worldBorder = finalWorld.getWorldBorder();
                worldBorder.setCenter(0, 0);
                worldBorder.setSize(310);
                finalWorld.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);

                for (Player p : lifestealSmp.getServer().getOnlinePlayers()) {
                    p.teleportAsync(new Location(Bukkit.getWorld("end_fight_world"), 25.0, 80.0, 25.0));
                    p.setInvulnerable(true);

                    getServer().getScheduler().runTaskLater(lifestealSmp, () -> p.setInvulnerable(false), 1200);

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
                if (isEndFightEnabled) {
                    new BukkitRunnable() {
                        int minutesPassed = 0;

                        @Override
                        public void run() {
                            if (!isEndFightEnabled) {
                                this.cancel();
                                return;
                            }
                            //if minutes passed is between 30 and 33 then do below but dont this.cancel and if greater than 33 then just apply poison if in survival

                            if (minutesPassed >= 60 && minutesPassed < 63) {
                                //this.cancel();
                                //worldBorder.setSize(1);
                                //Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "Border is now 1 block wide. Going outside border may instant kill you");
                                //worldBorder.setDamageBuffer(0);
                                //worldBorder.setDamageAmount(1);
                                //worldBorder.setWarningDistance(10);
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if (p.getGameMode() == GameMode.SURVIVAL) {
                                        // p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 2, true, false));
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1, true, false));
                                        p.sendTitle(ChatColor.RED + "WARNING!", ChatColor.YELLOW + "Fight to the death, or get eliminated by wither effect!");
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 0, true, false));
                                    }
                                }
                                Bukkit.broadcastMessage(ChatColor.DARK_RED + "Fight to the death. Wither effect applied!");
                                return;
                            } else if (minutesPassed >= 63) {
                                //this.cancel();
                                //worldBorder.setSize(1);
                                //Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "Border is now 1 block wide. Going outside border may instant kill you");
                                //worldBorder.setDamageBuffer(0);
                                //worldBorder.setDamageAmount(4);
                                //.setWarningDistance(10);
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if (p.getGameMode() == GameMode.SURVIVAL) {
                                        // p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 2, true, false));
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1, true, false));
                                        p.sendTitle(ChatColor.RED + "WARNING!", ChatColor.YELLOW + "Fight to the death, or get eliminated by wither effect!");
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1, true, false));
                                    }
                                }
                                Bukkit.broadcastMessage(ChatColor.DARK_RED + "Fight to the death. Even stronger wither effect applied!");
                                return;
                            }

                            double newSize = worldBorder.getSize() - 5;
                            Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "Border is now " + newSize + " blocks!");
                            worldBorder.setSize(newSize);
                            minutesPassed++;
                        }
                    }.runTaskTimer(lifestealSmp, 1200, 20 * 60);
                }
                this.cancel();
            }
        }.runTaskTimer(lifestealSmp, 0L, 20L);

        return true;
    }
}
