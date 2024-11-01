package newamazingpvp.lifestealsmp.variables;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Loc {

    public static World SMPworld = Bukkit.getWorld("world");
    //public static Location endFightSpawn = new Location(Bukkit.getWorld("end_fight_world"), 25.0, 80.0, 25.0);
    //public static Location endSpawn = new Location(Bukkit.getWorld("end_fight_world"), 0, 60.0, 0);
    //public static Location endPortalCenter = new Location(Bukkit.getWorld("end_fight_world"), 0, 70.0, 0);
    public static Location lobby = new Location(Bukkit.getWorld("world"), -20, 270.0, 27);
    public static Location spawnLoc1 = new Location(Bukkit.getWorld("world"), -100, -64, -100);
    public static Location spawnLoc2 = new Location(Bukkit.getWorld("world"), 100, 320, 100);

    //public static Location signLoc2 = new Location(Bukkit.getWorld("world"), -250, 320, -205);
    //public static Location signLoc1 = new Location(Bukkit.getWorld("world"), -439, 276, -221);
}
