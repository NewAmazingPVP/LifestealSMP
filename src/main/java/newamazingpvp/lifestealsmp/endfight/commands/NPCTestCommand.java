package newamazingpvp.lifestealsmp.endfight.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NPCTestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location loc = player.getLocation();

            NPCRegistry registry = CitizensAPI.getNPCRegistry();
            NPC npc = registry.createNPC(EntityType.PLAYER, "fullwall");
            // Set the spawn location for the NPC
            npc.spawn(loc);


        }


        return true;

    }
}


