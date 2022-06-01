package com.danizml.mechanicalevents.manager;

import com.danizml.mechanicalevents.MechanicalEvents;
import com.danizml.mechanicalevents.commands.PrimaryCommand;
import com.danizml.mechanicalevents.events.StickInfo;
import com.danizml.mechanicalevents.menus.MainMenu;
import com.danizml.mechanicalevents.storage.ItemMeta;
import com.danizml.mechanicalevents.storage.TabCompleter;

import java.util.Objects;

public class RegisterManager {
    public static void register() {
        YMLManager.registerYML();
        registerCommands();
        registerTabulatorCompleter();
        registerEvents();
        MessageManager.start();
        ItemMeta.register();
    }

    private static void registerUpdateChecker() {
        if (MechanicalEvents.getPlugin().getConfig().getBoolean("UpdateChecker")) {

        }
    }

    private static void registerCommands() {
        Objects.requireNonNull(MechanicalEvents.getPlugin().getCommand("mevents")).setExecutor(new PrimaryCommand());
    }

    private static void registerTabulatorCompleter() {
        Objects.requireNonNull(MechanicalEvents.getPlugin().getCommand("mevents")).setTabCompleter(new TabCompleter());
    }

    private static void registerEvents() {
        MechanicalEvents.getPlugin().getServer().getPluginManager().registerEvents(new MainMenu(), MechanicalEvents.getPlugin());
        MechanicalEvents.getPlugin().getServer().getPluginManager().registerEvents(new StickInfo(), MechanicalEvents.getPlugin());
    }
}
