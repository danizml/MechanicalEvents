package com.danizml.mechanicalevents.storage.yml;

import com.danizml.mechanicalevents.MechanicalEvents;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Items {
    private static FileConfiguration items = null;
    private static File itemsFile = null;

    public static FileConfiguration getItems() {
        if (items == null) {
            reloadItems();
        }return items;
    }

    public static void reloadItems() {
        if (items == null) {
            itemsFile = new File(MechanicalEvents.getPlugin().getDataFolder(), "items.yml");
        }

        items = YamlConfiguration.loadConfiguration(itemsFile);
        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(MechanicalEvents.getPlugin().getResource("items.yml")), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        items.setDefaults(defConfig);
    }

    public static void saveItems() {
        try {
            items.save(itemsFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static void registerItems() {
        itemsFile = new File(MechanicalEvents.getPlugin().getDataFolder(), "messages.yml");

        if (!itemsFile.exists()) {
            getItems().options().copyDefaults(true);
            saveItems();
        }
    }
}
