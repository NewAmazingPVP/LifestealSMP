package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;
import static newamazingpvp.lifestealsmp.utility.Utils.addItemOrDrop;

public class TradeManager {
    private static final Map<Player, Player> pendingTrades = new HashMap<>();
    private static final Map<Player, Inventory> tradeInventories = new HashMap<>();
    public static final Map<Player, Player> traders = new HashMap<>();
    private static final Map<Player, Boolean> tradeAccepted = new HashMap<>();
    public static final List<Integer> firstFourColumns = Arrays.asList(
            0, 1, 2, 3,
            9, 10, 11, 12,
            18, 19, 20, 21,
            27, 28, 29, 30,
            36, 37, 38, 39,
            45, 46, 47, 48
    );

    public static final List<Integer> lastFourColumns = Arrays.asList(
            8, 5, 6, 7,
            17, 14, 15, 16,
            26, 23, 24, 25,
            35, 32, 33, 34,
            44, 41, 42, 43,
            53, 50, 51, 52
    );



    public static void initiateTrade(Player sender, Player receiver) {
        if (pendingTrades.containsKey(receiver) && pendingTrades.get(receiver).equals(sender)) {
            openTradeGui(sender, receiver);
            pendingTrades.remove(receiver);
        } else {
            sender.sendMessage("Trade request sent to " + receiver.getName());
            receiver.sendMessage(sender.getName() + " wants to trade with you. Type /trade " + sender.getName() + " to accept.");
            pendingTrades.put(sender, receiver);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> pendingTrades.remove(sender), 20 * 60);
        }
    }

    private static void openTradeGui(Player player1, Player player2) {
        Inventory tradeInventory = Bukkit.createInventory(null, 54, "Trading: " + player1.getName() + " ↔ " + player2.getName());

        ItemStack confirmItem1 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta confirmMeta1 = confirmItem1.getItemMeta();
        confirmMeta1.setDisplayName("Accept Trade (Player 1)");
        confirmItem1.setItemMeta(confirmMeta1);

        ItemStack confirmItem2 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta confirmMeta2 = confirmItem2.getItemMeta();
        confirmMeta2.setDisplayName("Accept Trade (Player 2)");
        confirmItem2.setItemMeta(confirmMeta2);

        tradeInventory.setItem(45, confirmItem1);
        tradeInventory.setItem(53, confirmItem2);
        tradeInventory.setItem(4, new ItemStack(Material.ORANGE_STAINED_GLASS_PANE));
        tradeInventory.setItem(13, new ItemStack(Material.ORANGE_STAINED_GLASS_PANE));
        tradeInventory.setItem(22, new ItemStack(Material.ORANGE_STAINED_GLASS_PANE));
        tradeInventory.setItem(31, new ItemStack(Material.ORANGE_STAINED_GLASS_PANE));
        tradeInventory.setItem(40, new ItemStack(Material.ORANGE_STAINED_GLASS_PANE));
        tradeInventory.setItem(49, new ItemStack(Material.ORANGE_STAINED_GLASS_PANE));


        traders.put(player1, player2);

        tradeInventories.put(player1, tradeInventory);
        tradeInventories.put(player2, tradeInventory);

        tradeAccepted.put(player1, false);
        tradeAccepted.put(player2, false);

        player1.openInventory(tradeInventory);
        player2.openInventory(tradeInventory);
    }

    public static void handleTradeAcceptance(Player player) {
        tradeAccepted.put(player, true);
        Player otherPlayer = getOtherPlayer(player);
        if (tradeAccepted.get(otherPlayer)) {
            finalizeTrade(player, otherPlayer);
        }
    }

    public static void handleTradeCancellation(Player player){
        tradeAccepted.put(player, false);
    }

    public static Player getOtherPlayer(Player player) {
        if(traders.get(player) != null){
            return traders.get(player);
        }
        if(traders.containsValue(player)){
            for (Map.Entry<Player, Player> entry : traders.entrySet()) {
                if (entry.getValue().equals(player)) {
                    return entry.getKey();
                }
            }
        }
            return null;
    }

    private static void finalizeTrade(Player player1, Player player2) {
        Inventory tradeInventory = tradeInventories.get(player1);

        for (int i = 0; i < 54; i++) {
            ItemStack item1 = tradeInventory.getItem(i);

            if (item1 != null && firstFourColumns.contains(i)) {
                if(!(item1.getType() == Material.GREEN_STAINED_GLASS_PANE) && !(item1.getType() == Material.RED_STAINED_GLASS_PANE) ) {
                    addItemOrDrop(player1, item1, ChatColor.AQUA + "Some items were dropped due to inventory being full");
                }
            }
            if (item1 != null && lastFourColumns.contains(i)) {
                if(!(item1.getType() == Material.GREEN_STAINED_GLASS_PANE) && !(item1.getType() == Material.RED_STAINED_GLASS_PANE)) {
                    addItemOrDrop(player2, item1, ChatColor.AQUA + "Some items were dropped due to inventory being full");
                }
            }
        }

        player1.sendMessage("Trade completed with " + player2.getName());
        player2.sendMessage("Trade completed with " + player1.getName());

        tradeInventories.remove(player1);
        tradeInventories.remove(player2);
        traders.remove(player1);
        traders.remove(player2);
        tradeAccepted.remove(player1);
        tradeAccepted.remove(player2);

        player1.closeInventory();
        player2.closeInventory();

    }

    public static void cancelTrade(Player player) {
        Inventory tradeInventory = tradeInventories.get(player);
        if(tradeInventory == null) return;

        for (int i = 0; i < 54; i++) {
            ItemStack item1 = tradeInventory.getItem(i);

            if (item1 != null && traders.containsValue(player) && firstFourColumns.contains(i)) {
                if(!(item1.getType() == Material.GREEN_STAINED_GLASS_PANE) && !(item1.getType() == Material.RED_STAINED_GLASS_PANE) ) {
                    addItemOrDrop(player, item1, ChatColor.AQUA + "Some items were dropped due to inventory being full");
                }
            }
            if (item1 != null && traders.containsKey(player) && lastFourColumns.contains(i)) {
                if(!(item1.getType() == Material.GREEN_STAINED_GLASS_PANE) && !(item1.getType() == Material.RED_STAINED_GLASS_PANE)) {
                    addItemOrDrop(player, item1, ChatColor.AQUA + "Some items were dropped due to inventory being full");
                }
            }
        }
        tradeInventories.remove(player);
        tradeAccepted.remove(player);
        Player otherPlayer = getOtherPlayer(player);
        if (otherPlayer != null) {
            otherPlayer.closeInventory();
            otherPlayer.sendMessage("Trade canceled.");
        }
        traders.remove(player);

    }

    public static boolean isTradeInventory(Inventory inventory) {
        return tradeInventories.containsValue(inventory);
    }
}
