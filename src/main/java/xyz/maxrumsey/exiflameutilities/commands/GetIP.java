package xyz.maxrumsey.exiflameutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import xyz.maxrumsey.exiflameutilities.ExiFlameUtilities;

public class GetIP implements CommandExecutor {

    final Plugin plugin = ExiFlameUtilities.getPlugin(ExiFlameUtilities.class);

    // Called on command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean enabled = plugin.getConfig().getBoolean("GetIP");

        if (!enabled) return true;

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!(player.hasPermission("exiflameutil.getip") || player.isOp())) {
               player.sendMessage(ChatColor.RED + "You lack the permission to execute this command.");
               return true;
            }
        }
        if (args.length != 1) return false;

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage(ChatColor.RED + "That player could not be found.");
            return false;
        } else {
            sender.sendMessage(ChatColor.AQUA + args[0] + ChatColor.WHITE + "'s IP is: " + ChatColor.RED + target.getAddress().getHostName());
            return true;
        }

    }
}
