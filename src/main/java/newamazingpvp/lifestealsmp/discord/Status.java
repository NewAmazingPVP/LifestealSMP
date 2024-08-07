package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import static newamazingpvp.lifestealsmp.LifestealSMP.isSmp;
import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.channelId;
import static newamazingpvp.lifestealsmp.discord.DiscordBot.jda;

public class Status extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        if (!isSmp) return;
        new BukkitRunnable() {
            @Override
            public void run() {
                jda.getPresence().setActivity(Activity.playing("minecraft"));
                TextChannel channel = event.getJDA().getTextChannelById(channelId);

                if (channel != null) {
                    int num = Bukkit.getOnlinePlayers().size();
                    channel.getManager().setTopic("Total Players online: " + num).queue();
                }
            }
        }.runTaskTimerAsynchronously(lifestealSmp, 120L, 5 * 60 * 20);

    }
}
