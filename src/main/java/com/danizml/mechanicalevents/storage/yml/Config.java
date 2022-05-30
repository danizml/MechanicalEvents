package com.danizml.mechanicalevents.storage.yml;

import com.danizml.mechanicalevents.MechanicalEvents;

import java.io.File;

public class Config {
    public static void registerConfig() {
        File config = new File(MechanicalEvents.getPlugin().getDataFolder(), "config.yml");

        if (!config.exists()) {
            MechanicalEvents.getPlugin().getConfig().options().copyDefaults(true);
            MechanicalEvents.getPlugin().saveConfig();
        }
    }

    public static void reloadConfig() {
    }
}
