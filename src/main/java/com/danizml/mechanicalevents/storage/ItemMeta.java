package com.danizml.mechanicalevents.storage;

import com.danizml.mechanicalevents.storage.yml.Items;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.Objects;

public class ItemMeta {
    private static String stickInfoName;
    private static List<String> stickInfoLore;

    public static void register() {
        stickInfoName = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Items.getItems().getString("stickInfo.name")));
        stickInfoLore = Items.getItems().getStringList("stickInfo.lore");
    }

    public static class getStickInfo {
        public static String getName() {
            return stickInfoName;
        }

        public static List<String> getLore() {
            return stickInfoLore;
        }
    }
}
