package com.danizml.mechanicalevents.manager;

import com.danizml.mechanicalevents.MechanicalEvents;
import org.bukkit.plugin.Plugin;

public class PluginManager {
    public static boolean enablePlugin(String pluginName) {
        Plugin plugin = MechanicalEvents.getPlugin().getServer().getPluginManager().getPlugin(pluginName);

        if (plugin != null) {
            MechanicalEvents.getPlugin().getServer().getPluginManager().enablePlugin(plugin);
            return true;
        } else {
            return false;
        }
    }

    public static boolean disablePlugin(String pluginName) {
        Plugin plugin = MechanicalEvents.getPlugin().getServer().getPluginManager().getPlugin(pluginName);
        if (plugin != null) {
            MechanicalEvents.getPlugin().getServer().getPluginManager().disablePlugin(plugin);
            return true;
        } else {
            return false;
        }
    }
}
