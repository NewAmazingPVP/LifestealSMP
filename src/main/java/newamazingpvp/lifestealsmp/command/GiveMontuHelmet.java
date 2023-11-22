package newamazingpvp.lifestealsmp.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.Bukkit;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class GiveMontuHelmet implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if the sender is a player
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Create a new ItemStack for the skull
            ItemStack skull = new ItemStack(Material.PLAYER_HEAD);

            // Get the SkullMeta of the skull
            SkullMeta meta = (SkullMeta) skull.getItemMeta();

            // Set the owner profile of the skull to the Anubis texture
            PlayerProfile profile = getProfile("https://minecraft-heads.com/custom-heads/humanoid/25946-anubis");
            meta.setOwnerProfile(profile);

            // Set the SkullMeta of the skull
            skull.setItemMeta(meta);

            // Add the skull to the player's inventory
            player.getInventory().addItem(skull);

            return true;
        }

        return false;
    }

    private PlayerProfile getProfile(String url) {
        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.fromString("92864445-51c5-4c3b-9039-517c9927d1b4"));
        PlayerTextures textures = profile.getTextures();
        URL urlObject;
        try {
            urlObject = new URL(url);
        } catch (MalformedURLException exception) {
            throw new RuntimeException("Invalid URL", exception);
        }
        textures.setSkin(urlObject);
        profile.setTextures(textures);
        return profile;
    }
}