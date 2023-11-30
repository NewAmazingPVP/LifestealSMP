package newamazingpvp.lifestealsmp.sekhmetitems;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import static newamazingpvp.lifestealsmp.game.CustomRecipe.*;

public class GiveSekhmetSetSpeedADMINONLY implements CommandExecutor {

    private static final UUID RANDOM_UUID = UUID.fromString("92864445-51c5-4c3b-9039-517c9927d1b4"); // We reuse the same "random" UUID all the time

    public static PlayerProfile getProfile(String url) {
        PlayerProfile profileaqua = Bukkit.createPlayerProfile(RANDOM_UUID); // Get a new player profile
        PlayerTextures textures = profileaqua.getTextures();
        URL urlObject;
        try {
            urlObject = new URL(url); // The URL to the skin
        } catch (MalformedURLException exception) {
            throw new RuntimeException("Invalid URL", exception);
        }
        textures.setSkin(urlObject); // Set the skin of the player profile to the URL
        profileaqua.setTextures(textures); // Set the textures back to the profile
        return profileaqua;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }




        Player player = (Player) sender;


        player.getInventory().addItem(SekhmetCHEST1());
        player.getInventory().addItem(SekhmetLEG1());
        player.getInventory().addItem(SekhmetBOOT1());

        player.getInventory().addItem(AquaHealm());




        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        return true;
    }
}
