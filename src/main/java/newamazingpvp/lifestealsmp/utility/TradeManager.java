package newamazingpvp.lifestealsmp.utility;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static newamazingpvp.lifestealsmp.LifestealSMP.lifestealSmp;

import java.util.HashMap;
import java.util.Map;

public class TradeManager {
    private static final Map<Player, Player> pendingTrades = new HashMap<>();
    private static final Map<Player, Inventory> tradeInventories = new HashMap<>();
    private static final Map<Player, Boolean> tradeAccepted = new HashMap<>();

    public static void initiateTrade(Player sender, Player receiver) {
        if (pendingTrades.containsKey(receiver) && pendingTrades.get(receiver).equals(sender)) {
            openTradeGui(sender, receiver);
            pendingTrades.remove(receiver);
        } else {
            sender.sendMessage("Trade request sent to " + receiver.getName());
            receiver.sendMessage(sender.getName() + " wants to trade with you. Type /trade " + sender.getName() + " to accept.");
            pendingTrades.put(sender, receiver);
            Bukkit.getScheduler().runTaskLater(lifestealSmp, () -> pendingTrades.remove(sender), 20 * 60); // Remove the request after 1 minute
        }
    }

    private static void openTradeGui(Player player1, Player player2) {
        Inventory tradeInventory1 = Bukkit.createInventory(null, 27, "Trading with " + player2.getName());
        Inventory tradeInventory2 = Bukkit.createInventory(null, 27, "Trading with " + player1.getName());

        ItemStack confirmItem = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta confirmMeta = confirmItem.getItemMeta();
        confirmMeta.setDisplayName("Accept Trade");
        confirmItem.setItemMeta(confirmMeta);

        tradeInventory1.setItem(26, confirmItem);
        tradeInventory2.setItem(26, confirmItem);

        tradeInventories.put(player1, tradeInventory1);
        tradeInventories.put(player2, tradeInventory2);

        tradeAccepted.put(player1, false);
        tradeAccepted.put(player2, false);

        player1.openInventory(tradeInventory1);
        player2.openInventory(tradeInventory2);
    }

    public static void handleTradeAcceptance(Player player) {
        tradeAccepted.put(player, true);
        Player otherPlayer = getOtherPlayer(player);
        if (tradeAccepted.get(otherPlayer)) {
            finalizeTrade(player, otherPlayer);
        }
    }

    private static Player getOtherPlayer(Player player) {
        for (Map.Entry<Player, Inventory> entry : tradeInventories.entrySet()) {
            if (!entry.getKey().equals(player)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static void finalizeTrade(Player player1, Player player2) {
        Inventory inv1 = tradeInventories.get(player1);
        Inventory inv2 = tradeInventories.get(player2);

        for (int i = 0; i < 26; i++) {
            ItemStack item1 = inv1.getItem(i);
            ItemStack item2 = inv2.getItem(i);

            if (item1 != null) {
                player2.getInventory().addItem(item1);
            }
            if (item2 != null) {
                player1.getInventory().addItem(item2);
            }
        }

        player1.closeInventory();
        player2.closeInventory();

        player1.sendMessage("Trade completed with " + player2.getName());
        player2.sendMessage("Trade completed with " + player1.getName());

        tradeInventories.remove(player1);
        tradeInventories.remove(player2);
        tradeAccepted.remove(player1);
        tradeAccepted.remove(player2);
    }

    public static void cancelTrade(Player player) {
        Player otherPlayer = getOtherPlayer(player);
        if (otherPlayer != null) {
            otherPlayer.closeInventory();
            otherPlayer.sendMessage("Trade canceled.");
        }
        tradeInventories.remove(player);
        tradeAccepted.remove(player);
    }

    public static boolean isTradeInventory(Inventory inventory) {
        return tradeInventories.containsValue(inventory);
    }
}
