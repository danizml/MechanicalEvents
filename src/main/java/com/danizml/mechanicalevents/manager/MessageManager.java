package com.danizml.mechanicalevents.manager;

import com.danizml.mechanicalevents.MechanicalEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class MessageManager {
    public static void start() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "[MechanicalEvents] -> Was enable");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "[MechanicalEvents] -> " + MechanicalEvents.getPlugin().getDescription().getVersion());
    }

    public static void stop() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "MechanicalEvents: was disable");
    }
}
