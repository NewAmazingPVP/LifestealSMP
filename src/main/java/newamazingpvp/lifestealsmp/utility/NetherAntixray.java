package newamazingpvp.lifestealsmp.utility;

import newamazingpvp.lifestealsmp.LifestealSMP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class NetherAntixray {
    public static void addAntiXray() {
        File serverDir = lifestealSmp.getDataFolder().getParentFile().getParentFile();
        File worldNetherDir = new File(serverDir, "world_nether");
        File paperWorldFile = new File(worldNetherDir, "paper-world.yml");

        FileConfiguration config = YamlConfiguration.loadConfiguration(paperWorldFile);

        if (!config.contains("anticheat.anti-xray")) {
            config.set("anticheat.anti-xray.enabled", true);
            config.set("anticheat.anti-xray.engine-mode", 3);
            config.set("anticheat.anti-xray.hidden-blocks", Arrays.asList(
                    "air",
                    "ancient_debris",
                    "bone_block",
                    "glowstone",
                    "magma_block",
                    "nether_bricks",
                    "nether_gold_ore",
                    "nether_quartz_ore",
                    "polished_blackstone_bricks"
            ));
            config.set("anticheat.anti-xray.lava-obscures", false);
            config.set("anticheat.anti-xray.max-block-height", 128);
            config.set("anticheat.anti-xray.replacement-blocks", Arrays.asList(
                    "basalt",
                    "blackstone",
                    "gravel",
                    "netherrack",
                    "soul_sand",
                    "soul_soil"
            ));
            config.set("anticheat.anti-xray.update-radius", 2);
            config.set("anticheat.anti-xray.use-permission", false);

            try {
                config.save(paperWorldFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
