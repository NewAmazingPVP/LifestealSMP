package newamazingpvp.lifestealsmp.unused.misc;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

public class IceCube implements Listener {


    public static ItemStack FrozenIceHelm() {

        ItemStack IceCube = new ItemStack(Material.ICE);
        ItemMeta SI = IceCube.getItemMeta();
        SI.addEnchant(Enchantment.UNBREAKING, 1, false);
        SI.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SI.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Ice");
        SI.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> BL = new ArrayList<>();
        BL.add(ChatColor.DARK_RED + "If you see this...");
        BL.add(ChatColor.DARK_RED + "you are frozen.");
        SI.setLore(BL);
        IceCube.setItemMeta(SI);

        return IceCube;
    }

    public static ItemStack FrozenIceCP() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Ice");
        chestplateMeta.setColor(Color.fromRGB(0, 239, 255));
        chestplateMeta.setUnbreakable(true);
        List<String> CHESTPLATELORE = new ArrayList<>();
        CHESTPLATELORE.add(ChatColor.DARK_RED + "If you see this...");
        CHESTPLATELORE.add(ChatColor.DARK_RED + "you are frozen.");
        chestplateMeta.setLore(CHESTPLATELORE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        chestplate.setItemMeta(chestplateMeta);
        return chestplate;
    }

    public static ItemStack FrozenIceLEG() {
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
        legMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Ice");
        legMeta.setColor(Color.fromRGB(0, 239, 255));
        legMeta.setUnbreakable(true);
        List<String> LEGGINGSLORE = new ArrayList<>();
        LEGGINGSLORE.add(ChatColor.DARK_RED + "If you see this...");
        LEGGINGSLORE.add(ChatColor.DARK_RED + "you are frozen.");
        legMeta.setLore(LEGGINGSLORE);
        legMeta.addItemFlags(ItemFlag.HIDE_DYE);
        legMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        legMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        leggings.setItemMeta(legMeta);
        return leggings;
    }

    public static ItemStack FrozenIceBOOTS() {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Ice");
        bootsMeta.setColor(Color.fromRGB(0, 239, 255));
        bootsMeta.setUnbreakable(true);
        List<String> BOOTSELORE = new ArrayList<>();
        BOOTSELORE.add(ChatColor.DARK_RED + "If you see this...");
        BOOTSELORE.add(ChatColor.DARK_RED + "you are frozen.");
        bootsMeta.setLore(BOOTSELORE);
        bootsMeta.addItemFlags(ItemFlag.HIDE_DYE);
        bootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        boots.setItemMeta(bootsMeta);
        return boots;
    }

    @EventHandler
    public void onPlayerInteract(BlockPlaceEvent e) {

        Player player = e.getPlayer();
        ItemStack item = e.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        Player closestPlayer = null;
        double minDistance = Double.MAX_VALUE;

        Location location = e.getBlock().getLocation();
        if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Ice Cube")) {
            //location.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, location, 10);
            e.setCancelled(true);
            player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
            for (Player onlineplayer : Bukkit.getOnlinePlayers()) {

                double distance = player.getLocation().distance(location);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPlayer = player;
                }
                if (closestPlayer != null) {

                    PlayerInventory closeInventory = closestPlayer.getInventory();
                    closestPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 5));

                    ItemStack[] armorContents = closestPlayer.getInventory().getArmorContents();

                    closestPlayer.getInventory().setHelmet(FrozenIceHelm());
                    closestPlayer.getInventory().setChestplate(FrozenIceCP());
                    closestPlayer.getInventory().setLeggings(FrozenIceLEG());
                    closestPlayer.getInventory().setBoots(FrozenIceBOOTS());

                    closestPlayer.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT_FREEZE, 1.0f, 0.0f);

                    closestPlayer.sendTitle(ChatColor.AQUA + "" + ChatColor.BOLD + "You Are Frozen!", "", 10, 70, 20);
                    closestPlayer.addScoreboardTag("frozen");
                    Player finalClosestPlayer = closestPlayer;

                    Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> finalClosestPlayer.removeScoreboardTag("frozen"), 40);
                    Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> closeInventory.setArmorContents(armorContents), 40);


                }
            }
            if (item.getAmount() > 1) {
                item.setAmount(item.getAmount() - 1);
                player.getInventory().setItemInMainHand(item);
            } else {
                player.getInventory().setItemInMainHand(null);
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboardTags().contains("frozen")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerJump(PlayerJumpEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboardTags().contains("frozen")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerHit(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboardTags().contains("frozen")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerPlace(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboardTags().contains("frozen")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getScoreboardTags().contains("frozen")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract2(EntityDamageByEntityEvent event) {
        Player player = (Player) event.getDamager();
        if (player.getScoreboardTags().contains("frozen")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Ice")) {
            player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
            event.setCancelled(true);
        }
    }
}