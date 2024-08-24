package newamazingpvp.lifestealsmp.visuals.CustomToasts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;
import static newamazingpvp.lifestealsmp.visuals.CustomToasts.CreateCustomToast.Style.TASK;

public class PlayerJoinToast implements Listener {

    private static String displayMessage = ChatColor.DARK_RED + "[ERROR]";


    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e){
        Player player = e.getPlayer();

        String name = player.getName();


        displayMessage = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + name + " Has Joined " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[+]";

        final String materialName = "emerald";

        try {
            Material.valueOf(materialName.toUpperCase());

        } catch (final Throwable t) {

            return;
        }




        PlayerJoinToastCreate.displayTo(materialName, displayMessage, TASK);

    }

    public static ItemStack playerJoinHeadTexture() {

        PlayerProfile profile = getProfile("https://textures.minecraft.net/texture/6db32b15d7f32704ed626fa52d06fb2b4071d336fdbfe61e6e41c669d6e37f47");
        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;


    }





}
