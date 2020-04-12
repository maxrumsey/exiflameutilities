package xyz.maxrumsey.exiflameutilities.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import xyz.maxrumsey.exiflameutilities.ExiFlameUtilities;

public class Respawn implements CommandExecutor {

    final Plugin plugin = ExiFlameUtilities.getPlugin(ExiFlameUtilities.class);

    // Called on command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean enabled = plugin.getConfig().getBoolean("Respawn");

        if (!enabled) return true;

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("exiflameutil.respawn") || player.isOp()) {
                player.setHealth(0);
                player.sendMessage("You respawned.");
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_DEATH, 1f, 1f);
            } else {
                player.sendMessage("You lack the permission (exiflameutil.respawn), and can not run this command.");
            }
        } else {
            System.out.println("You need to be a player to execute this command.");
        }
        return true;
    }
}
