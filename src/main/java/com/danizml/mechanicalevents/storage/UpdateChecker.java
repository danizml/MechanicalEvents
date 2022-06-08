package com.danizml.mechanicalevents.storage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {
    private static String latestVersion;

    public static void updateChecker() {
        try {
            HttpURLConnection con = (HttpURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=102325")).openConnection();
            con.setConnectTimeout(1250);
            con.setReadTimeout(1250);
            UpdateChecker.latestVersion = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();
            if (latestVersion.length() <= 7 && !PluginDescription.version.equals(latestVersion)) {
                Bukkit.getConsoleSender().sendMessage(PluginDescription.prefix + ChatColor.RED + " There is a new version available. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + latestVersion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(PluginDescription.prefix + ChatColor.RED + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/mechanicalevents.102325/");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(PluginDescription.prefix + ChatColor.RED + " Error while checking update.");
        }
    }

    public static String getLatestVersion() {
        return latestVersion;
    }
}
