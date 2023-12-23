package newamazingpvp.lifestealsmp.discord;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.channelId;
import static newamazingpvp.lifestealsmp.utility.DiscordBot.jda;

public class Status extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);

        new BukkitRunnable() {
            @Override
            public void run() {
                jda.getPresence().setActivity(Activity.playing("Playing minecraft"));
                TextChannel channel = event.getJDA().getTextChannelById(channelId);

                if (channel != null) {
                    int num = Bukkit.getOnlinePlayers().size();
                    channel.getManager().setTopic("Total Players online: " + num).queue();
                }
            }
        }.runTaskTimerAsynchronously(lifestealSmp, 120L, 5 * 60 * 20);

    }
}
