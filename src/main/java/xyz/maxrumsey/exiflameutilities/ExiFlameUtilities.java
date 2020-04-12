package xyz.maxrumsey.exiflameutilities;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.maxrumsey.exiflameutilities.commands.GetIP;
import xyz.maxrumsey.exiflameutilities.commands.Respawn;
import xyz.maxrumsey.exiflameutilities.events.PlayerIPNotifier;


public final class ExiFlameUtilities extends JavaPlugin {
    
    @Override
    public void onEnable() {
        // Plugin startup logic

        //Loading Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Registering Events
        getServer().getPluginManager().registerEvents(new PlayerIPNotifier(), this);

        // Registering Commands
        this.getCommand("respawn").setExecutor(new Respawn());
        this.getCommand("getip").setExecutor(new GetIP());

        getLogger().info("Plugin has booted.");

    }

}
