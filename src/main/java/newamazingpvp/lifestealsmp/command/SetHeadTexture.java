package newamazingpvp.lifestealsmp.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.unused.endfight.custommobs.PublicMobMethods.getProfile;

public class SetHeadTexture implements CommandExecutor, TabCompleter {

    private final ArrayList<String> subcommands = new ArrayList<>(List.of("url", "name"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Inventory inv = player.getInventory();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        int numOfItemsInHand = itemInMainHand.getAmount();

        if (!(sender instanceof Player)) return true;

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Please specify if you are using a URL or player name.");
            return false;
        }

        if(args.length < 2){

            sender.sendMessage(ChatColor.RED + "plz put a name or URL."); 

            return false;
        }

        if(itemInMainHand.getType() != Material.PLAYER_HEAD){

            sender.sendMessage(ChatColor.RED + "You must be holding a head.");

            return false;
        }

        String texture = "";

        for (int i = 2; i < args.length; i++)
            texture += args[i] + " ";

        switch (args[0].toLowerCase()) {
            case "url":

                for(int i = 0; i<numOfItemsInHand; i++) {
                    if (itemInMainHand.getAmount() > 1) {
                        itemInMainHand.setAmount(itemInMainHand.getAmount() - 1);
                    } else {
                        player.getInventory().setItemInMainHand(null);
                    }
                }

                for(int e = 0; e < numOfItemsInHand; e++){
                    player.getInventory().setItemInMainHand(headTextureable(texture));
                }



                break;
            case "name":

                break;
            default:
                sender.sendMessage(ChatColor.RED + "Error: Unknown argument.");
                return false;
        }

        return true;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            for (String subcommand : subcommands) {
                if (subcommand.startsWith(args[0].toLowerCase())) {
                    completions.add(subcommand);
                }
            }
            return completions;
        }
        return null;
    }




    public static ItemStack headTextureable(String url) {



        PlayerProfile profile = getProfile(url);
        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Ditto Skull");

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Hold Item]");
        lore.add(ChatColor.DARK_PURPLE + "Use /stetheadtexture");

        meta.setLore(lore);


        meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;
    }




}
