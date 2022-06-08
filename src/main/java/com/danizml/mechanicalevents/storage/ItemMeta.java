package com.danizml.mechanicalevents.storage;

import com.danizml.mechanicalevents.storage.yml.Items;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.Objects;

public class ItemMeta {
    private static String playerPingName;
    private static List<String> playerPingLore;

    private static String stickInfoName;
    private static List<String> stickInfoLore;

    private static String teleportClockName;
    private static List<String> teleportClockLore;

    public static void register() {
        stickInfoName = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Items.getItems().getString("stickInfo.name")));
        stickInfoLore = Items.getItems().getStringList("stickInfo.lore");
        playerPingName = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Items.getItems().getString("playerPing.name")));
        playerPingLore = Items.getItems().getStringList("playerPing.lore");
        teleportClockName = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Items.getItems().getString("teleportClock.name")));
        teleportClockLore = Items.getItems().getStringList("teleportClock.lore");
    }

    public static class getStickInfo {
        public static String getName() {
            return stickInfoName;
        }

        public static List<String> getLore() {
            return stickInfoLore;
        }
    }

    public static class getPlayerping {
        public static String getName() {
            return playerPingName;
        }
        public static List<String> getLore() {
            return playerPingLore;
        }
    }

    public static class getTeleportClock {
        public static String getName() {
            return teleportClockName;
        }
        public static List<String> getLore() {
            return teleportClockLore;
        }
    }

}
