package com.danizml.mechanicalevents.manager;

import com.danizml.mechanicalevents.MechanicalEvents;
import com.danizml.mechanicalevents.storage.yml.Config;

public class YMLManager {
    public static void registerYML() {
        Config.registerConfig();
    }

    public static void unregisterYML() {
        MechanicalEvents.getPlugin().saveConfig();
        MechanicalEvents.getPlugin().reloadConfig();
    }

    public static void reloadYML() {
        MechanicalEvents.getPlugin().saveConfig();
        MechanicalEvents.getPlugin().reloadConfig();
    }
}
