package listeners;

import minealex.tchat.TChat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;

public class RepeatMessagesListener implements Listener {
    private final Map<Player, String> lastMessages = new HashMap<>();
    private final TChat plugin;

    public RepeatMessagesListener(TChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void checkRepeatMessages(AsyncPlayerChatEvent event, Player player, String newMessage) {
        if (lastMessages.containsKey(player)) {
            String lastMessage = lastMessages.get(player);

            if (isSimilar(lastMessage, newMessage)) {
                event.setCancelled(true);
                String message = plugin.getMessagesManager().getRepeatMessage();
                String prefix = plugin.getMessagesManager().getPrefix();
                player.sendMessage(plugin.getTranslateColors().translateColors(player, prefix + message));
                return;
            }
        }

        lastMessages.put(player, newMessage);
    }

    private boolean isSimilar(String message1, String message2) {
        message1 = message1.toLowerCase();
        message2 = message2.toLowerCase();

        int maxLength = Math.max(message1.length(), message2.length());
        int similarChars = 0;

        for (int i = 0; i < Math.min(message1.length(), message2.length()); i++) {
            if (message1.charAt(i) == message2.charAt(i)) {
                similarChars++;
            }
        }

        double similarity = (double) similarChars / maxLength;
        return similarity >= plugin.getConfigManager().getRepeatMessagesPercent();
    }
}
