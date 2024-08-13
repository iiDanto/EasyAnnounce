package iiDanto.easyAnnounce;

import org.bukkit.plugin.java.JavaPlugin;

public final class EasyAnnounce extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("EasyAnnounce has started successfully.");
        this.getCommand("kit").setExecutor(new AnnounceCommand(this));
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
