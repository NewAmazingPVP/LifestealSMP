package newamazingpvp.lifestealsmp.unused.visuals.toasts;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowCustomToastCMD implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");

            return true;
        }

        if (args.length < 3)
            return false;

        final CreateCustomToast.Style style;

        try {
            style = CreateCustomToast.Style.valueOf(args[0].toUpperCase());

        } catch (final Throwable t) {
            sender.sendMessage(ChatColor.RED + "Invalid style: " + args[0]);

            return true;
        }

        final String materialName = args[1];

        try {
            Material.valueOf(materialName.toUpperCase());

        } catch (final Throwable t) {
            sender.sendMessage(ChatColor.RED + "Invalid material: " + materialName);

            return true;
        }

        String message = "";

        for (int i = 2; i < args.length; i++)
            message += args[i] + " ";

        message = ChatColor.translateAlternateColorCodes('&', message.trim());

        CreateCustomToast.displayTo(materialName, message, style);

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final List<String> tab = new ArrayList<>();

        switch (args.length) {
            case 1:
                for (final CreateCustomToast.Style style : CreateCustomToast.Style.values())
                    tab.add(style.toString().toLowerCase());
                break;

            case 2:
                for (final Material material : Material.values())
                    tab.add(material.toString().toLowerCase());
                break;

            case 3:
                tab.add("Hello");
                break;
        }

        return tab.stream().filter(completion -> completion.startsWith(args[args.length - 1])).collect(Collectors.toList());
    }

}
