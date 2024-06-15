package newamazingpvp.lifestealsmp.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.customitems.MagicStaffs.MagicStaffUtils.MagicStaffItemstacks.magicStaffDefault;
import static newamazingpvp.lifestealsmp.customitems.utils.ItemStacks.*;
import static newamazingpvp.lifestealsmp.runes.RunesDrops.*;

public class GiveCustomItem implements CommandExecutor, TabCompleter {

    private final ArrayList<String> subcommands = new ArrayList<>(List.of("feathersword", "homingbow", "tntbow", "tpbow", "oppickaxe", "treecutteraxe", "heart", "revivebeacon", "corruptedmobsoul", "severedmobheart", "lightfether", "instaboomtnt", "lifestealstick", "powerstick", "heavynetherstar", "quarryhelmet", "quarrychestplate", "quarryleggings", "quarryboots", "witherrune", "aquarune", "hellrune", "trollrune", "lightningrune", "darkrune", "bloodrune", "airrune","sombercrystal","musicbox","magicstaffdefault"));
    private final ArrayList<ItemStack> subItems = new ArrayList<>(List.of(createFeatherSword(), createHomingBow(), createTNTBow(), createCustomBow(), createOpPickaxe(), createCustomAxe(), extraHeart(), createReviveBeacon(), corruptedMobSoul(), severedMobHeart(), lightFeather(), InstaBoomTNT(), LifestealStick(), powerStick(), heavyNetherStar(), QuarryArmor_HELM(), QuarryArmor_CP(), QuarryArmor_LEGS(), QuarryArmor_BOOTS(), witherRune(), aquaRune(), hellRune(), trollRune(), lightningRune(), darkRune(), bloodRune(), airRune(),somberCrystal(),musicBox(),magicStaffDefault()));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            int index = subcommands.indexOf(args[0].toLowerCase());
            if (index == -1) return false;
            Player p = (Player) sender;
            p.getInventory().addItem(subItems.get(index));
        } else if (args.length == 2) {
            {
                Player p = Bukkit.getPlayer(args[0]);
                int index = subcommands.indexOf(args[1].toLowerCase());
                if (index == -1 || p == null) return false;
                p.getInventory().addItem(subItems.get(index));
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1 || args.length == 2) {
            return subcommands;
        }
        return null;
    }
}
