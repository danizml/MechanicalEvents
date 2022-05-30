package com.danizml.mechanicalevents.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateCheckerManager {
    public static String latestVersion;

    public static void updateChecker() {
        try {
            HttpURLConnection con = (HttpURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=93016")).openConnection();
            con.setConnectTimeout(1250);
            con.setReadTimeout(1250);
            UpdateCheckerManager.latestVersion = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();
            if (UpdateCheckerManager.latestVersion.length() <= 7 && !PluginDescriptionManager.version.equals(UpdateCheckerManager.latestVersion)) {
                Bukkit.getConsoleSender().sendMessage(PluginDescriptionManager.prefix + ChatColor.RED + " There is a new version available. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + UpdateCheckerManager.latestVersion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(PluginDescriptionManager.prefix + ChatColor.RED + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/utilitycommands.93016");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(PluginDescriptionManager.prefix + ChatColor.RED + " Error while checking update.");
        }
    }
}
