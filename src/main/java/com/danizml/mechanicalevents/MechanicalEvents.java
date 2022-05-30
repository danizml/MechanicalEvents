package com.danizml.mechanicalevents;

import com.danizml.mechanicalevents.manager.RegisterManager;
import com.danizml.mechanicalevents.manager.UnregisterManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MechanicalEvents extends JavaPlugin {
    private static MechanicalEvents plugin;

    @Override
    public void onEnable() {
        plugin = this;
        RegisterManager.register();
    }

    @Override
    public void onDisable() {
        UnregisterManager.unregister();
    }

    public static MechanicalEvents getPlugin() {
        return plugin;
    }
}
