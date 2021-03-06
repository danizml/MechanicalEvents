package com.danizml.mechanicalevents.storage;

import com.danizml.mechanicalevents.MechanicalEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;

public class PluginDescription {
    private static final PluginDescriptionFile pdffile = MechanicalEvents.getPlugin().getDescription();
    public static String permissionDefault;
    public static String primaryPrefix;
    public static String permissions;
    public static String description;
    public static String softDepend;
    public static String loadBefore;
    public static String awareness;
    public static String commands;
    public static String fullname;
    public static String authors;
    public static String website;
    public static String version;
    public static String prefix;
    public static String depend;
    public static String main;
    public static String name;
    public static String load;

    public static void description() {
        name = pdffile.getName();
        website = pdffile.getWebsite();
        version = pdffile.getVersion();
        main = pdffile.getMain();
        commands = String.valueOf(pdffile.getCommands());
        permissions = String.valueOf(pdffile.getPermissions());
        awareness = String.valueOf(pdffile.getAwareness());
        description = pdffile.getDescription();
        authors = String.valueOf(pdffile.getAuthors());
        depend = String.valueOf(pdffile.getDepend());
        fullname = pdffile.getFullName();
        load = String.valueOf(pdffile.getLoad());
        loadBefore = String.valueOf(pdffile.getLoadBefore());
        permissionDefault = String.valueOf(pdffile.getPermissionDefault());
        primaryPrefix = pdffile.getPrefix();
        softDepend = String.valueOf(pdffile.getSoftDepend());
        prefix = ChatColor.GOLD + "[" + ChatColor.DARK_BLUE + name + ChatColor.GOLD + "]";
    }
}
