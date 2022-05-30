package com.danizml.mechanicalevents.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class LoggerManager {

    public LoggerManager() {
    }

    public static void broadcast(LoggerManager.BroadcastLevel level, String message) {
        if (message != null) {
            switch (level) {
                case ERROR:
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&c&lERROR&r&8] &f" + message));
                case WARNING:
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6&lWARNING&r&8] &f" + message));
                case INFO:
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&e&lINFO&r&8] &f" + message));
                case SUCCESS:
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&a&lSUCCESS&r&8] &f" + message));
                case OUTLINE:
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7" + message));
            }
        }
    }

    public enum BroadcastLevel {
        ERROR,
        WARNING,
        INFO,
        SUCCESS,
        OUTLINE;

        BroadcastLevel() {
        }
    }

    public static void sender(LoggerManager.SenderLevel level, String message, CommandSender sender) {
        if (message != null) {
            switch (level) {
                case ERROR:
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&c&lERROR&r&8] &f" + message));
                case WARNING:
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6&lWARNING&r&8] &f" + message));
                case INFO:
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&e&lINFO&r&8] &f" + message));
                case SUCCESS:
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&a&lSUCCESS&r&8] &f" + message));
                case OUTLINE:
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7" + message));
            }
        }
    }

    public enum SenderLevel {
        ERROR,
        WARNING,
        INFO,
        SUCCESS,
        OUTLINE;

        SenderLevel() {
        }
    }

    public static void console(LoggerManager.ConsoleLevel level, String message) {
        if (message != null) {
            switch (level) {
                case ERROR:
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&c&lERROR&r&8] &f" + message));
                case WARNING:
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6&lWARNING&r&8] &f" + message));
                case INFO:
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&e&lINFO&r&8] &f" + message));
                case SUCCESS:
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&a&lSUCCESS&r&8] &f" + message));
                case OUTLINE:
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7" + message));
            }
        }
    }

    public enum ConsoleLevel {
        ERROR,
        WARNING,
        INFO,
        SUCCESS,
        OUTLINE;

        ConsoleLevel() {
        }
    }
}
