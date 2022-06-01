package com.danizml.mechanicalevents.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("CommentedOutCode")
public class MainMenu implements Listener {
    public static Inventory config;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory() == config) {
            event.setCancelled(true);
        }
    }
    public static void CreateGuiPrimary() {

//----------------------Panels----------------------//

        MainMenu.glassPane(0);
        MainMenu.glassPane(1);
        MainMenu.glassPane(2);
        MainMenu.glassPane(3);
        MainMenu.glassPane(4);
        MainMenu.glassPane(5);
        MainMenu.glassPane(6);
        MainMenu.glassPane(7);
        MainMenu.glassPane(8);
        MainMenu.glassPane(9);
        MainMenu.glassPane(17);
        MainMenu.glassPane(18);
        MainMenu.glassPane(26);
        MainMenu.glassPane(27);
        MainMenu.glassPane(35);
        MainMenu.glassPane(36);
        MainMenu.glassPane(44);
        MainMenu.glassPane(45);
        MainMenu.glassPane(46);
        MainMenu.glassPane(47);
        MainMenu.glassPane(48);
        MainMenu.glassPane(49);
        MainMenu.glassPane(50);
        MainMenu.glassPane(51);
        MainMenu.glassPane(52);

//---------------------Function---------------------//

        ItemStack icon8 = new ItemStack(Material.BARRIER);
        ItemMeta meta8 = icon8.getItemMeta();
        assert meta8 != null;
        meta8.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dClose menu"));
        List<String> lore8 = new ArrayList<>();
        lore8.add(ChatColor.translateAlternateColorCodes('&', "&5Click for close the menu."));
        meta8.setLore(lore8);
        icon8.setItemMeta(meta8);
        config.setItem(53, icon8);

    }

    static {
        config = Bukkit.createInventory(null, 54, ChatColor.DARK_BLUE + "Config");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void InventoryClickPrimaryMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().equals(config)) {
            event.setCancelled(true);

            //if (event.getCurrentItem() == null) {
                //player.sendMessage(ChatColor.DARK_RED + "[Error] -> item.null");
            //}

            if (event.getCurrentItem().getType() == Material.BARRIER && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dClose menu"))) {
                player.closeInventory();
            }

            //if (event.getCurrentItem().getType() == Material.COMMAND_BLOCK && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dCommands"))) {
                //HelpMenu.CreateGuiHelp();
                //player.openInventory(HelpMenu.help);
            //}

            //if //(event.getCurrentItem().getType() == Material.BOOK && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dItems"))) {
                //ItemsMenu.CreateGuiItems();
                //player.openInventory(ItemsMenu.items);
            //}

        }
    }

    public static void glassPane(int icon) {
        ItemStack glass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta glassMeta = glass.getItemMeta();
        assert glassMeta != null;
        glassMeta.setDisplayName(". ");
        glass.setItemMeta(glassMeta);
        config.setItem(icon, glass);
    }
}
