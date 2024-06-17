package newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class staffSound {

    public static void playMagicStaffSound(Player attacker,Sound sound1, Float pitch1, Sound sound2, Float pitch2){
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(attacker.getLocation(), sound1, 1.0f, pitch1);
            onlinePlayer.playSound(attacker.getLocation(), sound2, 1.0f, pitch2);
        }
    }


}
