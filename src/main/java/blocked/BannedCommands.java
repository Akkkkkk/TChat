package blocked;

import config.BannedCommandsManager;
import minealex.tchat.TChat;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;


public class BannedCommands implements Listener {

    private final BannedCommandsManager bannedCommandsManager;
    private final TChat plugin;

    public BannedCommands(TChat plugin) {
        this.bannedCommandsManager = plugin.getBannedCommandsManager();
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (event.isCancelled()) { return; }

        Player player = event.getPlayer();

        if (!event.getPlayer().hasPermission(bannedCommandsManager.getBypassPermissionCommand()) && !event.getPlayer().hasPermission("tchat.admin")) {
            String command = event.getMessage().split(" ")[0].substring(1).toLowerCase();
            List<String> bannedCommands = bannedCommandsManager.getBannedCommands();

            if (bannedCommands.contains(command)) {
                List<String> blockedMessages = bannedCommandsManager.getBlockedMessage();
                for (String message : blockedMessages) {
                    event.getPlayer().sendMessage(plugin.getTranslateColors().translateColors(player, message));
                }

                if (bannedCommandsManager.getTitleEnabled()) {
                    String title = plugin.getTranslateColors().translateColors(player, bannedCommandsManager.getTitle());
                    String subtitle = plugin.getTranslateColors().translateColors(player, bannedCommandsManager.getSubTitle());
                    sendTitle(event.getPlayer(), title, subtitle);
                }

                if (bannedCommandsManager.getActionBarEnabled()) {
                    String actionBar = plugin.getTranslateColors().translateColors(player, bannedCommandsManager.getActionBar());
                    sendActionBar(event.getPlayer(), actionBar);
                }

                if (bannedCommandsManager.getSoundEnabled()) {
                    playSound(event.getPlayer(), bannedCommandsManager.getSound());
                }

                if (bannedCommandsManager.isParticlesEnabled()) {
                    showParticles(event.getPlayer());
                }

                if (plugin.getConfigManager().isLogBannedCommandsEnabled()) {
                    plugin.getLogsManager().logBannedCommand(event.getPlayer().getName(), command);
                }

                event.setCancelled(true);
            }
        }
    }

    private void sendTitle(Player player, String title, String subtitle) {
        new BukkitRunnable() {
            @Override
            public void run() {
                player.sendTitle(title, subtitle, 10, 70, 20);
            }
        }.runTask(bannedCommandsManager.getPlugin());
    }

    private void sendActionBar(Player player, String message) {
        new BukkitRunnable() {
            @Override
            public void run() {
                player.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
            }
        }.runTask(bannedCommandsManager.getPlugin());
    }

    private void playSound(Player player, String soundName) {
        Sound sound = Sound.valueOf(soundName.toUpperCase());
        player.playSound(player.getLocation(), sound, 1.0F, 1.0F);
    }

    private void showParticles(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                player.getWorld().spawnParticle(bannedCommandsManager.getParticle(), player.getLocation(), bannedCommandsManager.getParticles());
            }
        }.runTask(bannedCommandsManager.getPlugin());
    }
}
