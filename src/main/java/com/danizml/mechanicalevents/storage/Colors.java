package com.danizml.mechanicalevents.storage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;


public class Colors {
    public static Map<Player, BukkitTask> tasks = new HashMap<>();

    public static void sendMessage(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void sendBroadcastMessage(Player player, String message) {
        Bukkit.broadcastMessage(message.replaceAll("&", "§").replaceAll("%world%", String.valueOf(player.getWorld())).replaceAll("%player%", player.getName()));
    }
}
