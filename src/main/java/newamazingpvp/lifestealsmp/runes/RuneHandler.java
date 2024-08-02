package newamazingpvp.lifestealsmp.runes;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.ShulkerBox;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.events.TimeManager.CUSTOM_ITEMS_AND_RUNES;
import static newamazingpvp.lifestealsmp.events.TimeManager.isTimePassed;
import static newamazingpvp.lifestealsmp.runes.AbstractRune.deserialize;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;

public class RuneHandler implements Listener {
    public static final List<Rune> runes = new ArrayList<>();
    public static Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Runes");
    public static double runeMultiplier = 1;

    public RuneHandler() {
        runes.add(new AbsorptionRune());
        runes.add(new BadOmenRune());
        runes.add(new BadOmenRune.II());
        runes.add(new BadOmenRune.III());
        runes.add(new BadOmenRune.IV());
        runes.add(new BadOmenRune.V());
        runes.add(new ConduitPowerRune());
        runes.add(new DolphinsGraceRune());
        runes.add(new FireResistanceRune());
        runes.add(new HasteRune());
        runes.add(new HasteRune.II());
        runes.add(new HealthBoostRune());
        runes.add(new HealthRune());
        runes.add(new HeroOfTheVillageRune());
        runes.add(new HeroOfTheVillageRune.II());
        runes.add(new HeroOfTheVillageRune.III());
        runes.add(new HeroOfTheVillageRune.IV());
        runes.add(new HeroOfTheVillageRune.V());
        runes.add(new InvisibilityRune());
        runes.add(new JumpBoostRune());
        runes.add(new JumpBoostRune.II());
        runes.add(new LuckRune());
        //runes.add(new RaidOmenRune());
        // runes.add(new RaidOmenRune.II());
        //runes.add(new RaidOmenRune.III());
        //runes.add(new RaidOmenRune.IV());
        //runes.add(new RaidOmenRune.V());
        runes.add(new RegenerationRune());
        //runes.add(new RegenerationRune.II());
        runes.add(new ResistanceRune());
        runes.add(new SaturationRune());
        runes.add(new SlowFallingRune());
        runes.add(new SpeedRune());
        runes.add(new SpeedRune.II());
        runes.add(new StrengthRune());
        runes.add(new StrengthRune.II());
        //runes.add(new TrialOmenRune());
        //runes.add(new TrialOmenRune.II());
        //runes.add(new TrialOmenRune.III());
        //runes.add(new TrialOmenRune.IV());
        //runes.add(new TrialOmenRune.V());
        runes.add(new WaterRune());
        for (Rune r : runes) {
            inv.addItem(createRuneItem(r));
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!isTimePassed(CUSTOM_ITEMS_AND_RUNES)) {
                    return;
                }
                for (Player p : Bukkit.getOnlinePlayers()) {
                    for (ItemStack t : p.getInventory().getContents()) {
                        if (t != null) {
                            if (t.getType() == Material.DRAGON_EGG) {
                                ItemMeta meta = t.getItemMeta();
                                List<String> lore = new ArrayList<>(List.of(ChatColor.DARK_PURPLE + "Have in inventory for " + ChatColor.GOLD + "15%" + ChatColor.DARK_PURPLE + " less damage!"));
                                meta.setLore(lore);
                                t.setItemMeta(meta);
                            } else if (ChatColor.stripColor(t.getDisplayName()).toLowerCase().contains("rune pouch")) {
                                BlockStateMeta bsm = (BlockStateMeta) t.getItemMeta();
                                ShulkerBox shulkerBox = (ShulkerBox) bsm.getBlockState();
                                for (ItemStack f : shulkerBox.getInventory().getContents()) {
                                    for (Rune r : runes) {
                                        if (f != null && f.getLore() != null && f.getLore().contains(r.getLore())) {
                                            p.addPotionEffect(r.getEffect());
                                        }
                                    }
                                }
                            } else if (t.hasItemMeta()) {
                                if (t.hasLore()) {
                                    ItemMeta meta = t.getItemMeta();
                                    List<String> lore = meta.getLore();
                                    /*if (lore.get(0).contains("Use To Craft Extra Hearts!")) {
                                        lore.clear();
                                        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Severed Mob Heart");
                                        lore.add(ChatColor.DARK_PURPLE + "Use To Craft Extra Hearts!");
                                        meta.setLore(lore);
                                        t.setItemMeta(meta);
                                    } else if (lore.get(0).contains("U$e To Cr")) {
                                        lore.clear();
                                        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.MAGIC + "LL" + ChatColor.GOLD + ChatColor.BOLD + "Corrupted Mob Soul" + ChatColor.GOLD + ChatColor.MAGIC + "LL");
                                        lore.add(ChatColor.DARK_PURPLE + "U$e To Cr" + ChatColor.MAGIC + "a" + ChatColor.DARK_PURPLE + "ft Extra Hearts!" + ChatColor.MAGIC + "L");
                                        meta.setLore(lore);
                                        t.setItemMeta(meta);*/
                                    //} else {
                                    for (Rune r : runes) {
                                        if (lore != null && lore.contains(r.getLore())) {
                                            p.addPotionEffect(r.getEffect());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(lifestealSmp, 0L, 199L);
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        if (!isTimePassed(CUSTOM_ITEMS_AND_RUNES)) return;
        Entity entity = event.getEntity();
        if (event.getEntity().getKiller() == null) return;
        Player player = event.getEntity().getKiller();
        Random random = new Random();

        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        int lootingLevel = mainHandItem.getEnchantmentLevel(Enchantment.LOOTING);

        for (Rune rune : runes) {
            if (entity.getType() == rune.getMob()) {
                double adjustedDropRate = rune.getDropRate() * (1 + 0.10 * lootingLevel);

                if (random.nextDouble() < adjustedDropRate * runeMultiplier) {
                    ItemStack runeItem = createRuneItem(rune);
                    //entity.getWorld().dropItemNaturally(entity.getLocation(), runeItem);
                    //player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "RUNE DROP!" + ChatColor.GOLD + " " + rune.getName() + ": " + rune.getLore());
                    player.sendMessage(deserialize("RUNE DROP!").color(NamedTextColor.GOLD).decorate(TextDecoration.BOLD).append(deserialize(" ")).append(rune.getName()).append(deserialize(": ").append(deserialize(rune.getLore()))));
                    addItemOrDrop(player, runeItem, ChatColor.RED + "Rune was dropped because inventory was full!");
                }
            }
        }
    }

    public static ItemStack createRuneItem(Rune rune) {
        ItemStack runeItem = new ItemStack(Material.PAPER);
        ItemMeta meta = runeItem.getItemMeta();
        meta.displayName(rune.getName());
        meta.addEnchant(Enchantment.UNBREAKING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "[Item just needs to be in your inventory]");
        lore.add(ChatColor.YELLOW + "[Rare chance to drop from " + rune.getMob().toString().replace("_", " ") + "]");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + rune.getMob().toString().replace("_", " ") + " RUNE ABILITY:");
        lore.add(rune.getLore());
        meta.setLore(lore);
        runeItem.setItemMeta(meta);
        return runeItem;
    }
}
