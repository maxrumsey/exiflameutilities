package xyz.maxrumsey.exiflameutilities.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import xyz.maxrumsey.exiflameutilities.ExiFlameUtilities;

public class PlayerIPNotifier implements Listener {

    final Plugin plugin = ExiFlameUtilities.getPlugin(ExiFlameUtilities.class);

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        plugin.getLogger().info(player.getDisplayName() + " has joined the server. IP: " + player.getAddress().getHostName());
        for (Player onlinePlayer: Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.hasPermission("exiflameutil.ipjoins") || onlinePlayer.isOp()) {
                onlinePlayer.sendMessage(ChatColor.AQUA + player.getDisplayName() + ChatColor.WHITE + " has joined the server. IP: " + ChatColor.RED + player.getAddress().getHostName());
            }
        }
    }
    @EventHandler
    void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        plugin.getLogger().info(player.getDisplayName() + " has left the server. IP: " + player.getAddress().getHostName());
        for (Player onlinePlayer: Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.hasPermission("exiflameutil.ipjoins") || onlinePlayer.isOp()) {
                onlinePlayer.sendMessage(ChatColor.AQUA + player.getDisplayName() + ChatColor.WHITE + " has left the server. IP: " + ChatColor.RED + player.getAddress().getHostName());
            }
        }
    }
}
