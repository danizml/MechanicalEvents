package com.danizml.mechanicalevents.commands;

import com.danizml.mechanicalevents.manager.YMLManager;
import com.danizml.mechanicalevents.menus.MainMenu;
import com.danizml.mechanicalevents.storage.Colors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerEvent;

public class PrimaryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mevents")) {
            if (args[0].equalsIgnoreCase("help")) {
                if (sender.hasPermission("mechanicalevents.help")) {
                    Colors.sendMessage((Player) sender, "&9&l[&bMechanicalEvents&9&l]");
                    Colors.sendMessage((Player) sender, "&9&l[&b+&9&l] -> &8help");
                    Colors.sendMessage((Player) sender, "&9&l[&b+&9&l] -> &8config");
                    Colors.sendMessage((Player) sender, "&9&l[&b+&9&l] -> &8reload");

                } else {
                    Colors.sendMessage((Player) sender, "&0&l[&4ERROR&0&l] -> &4commandNotFound");
                }
            }

            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("mechanicalevents.reload")) {
                    YMLManager.reloadYML();
                    Colors.sendMessage((Player) sender, "&9&l[&bMechanicalEvents&9&l] -> &8The config has been reloaded");

                } else {
                    Colors.sendMessage((Player) sender, "&0&l[&4ERROR&0&l] -> &4commandNotFound");
                }

            }
            //------------------
            if (args[0].equalsIgnoreCase("tracker")) {
                if (sender.hasPermission("mechanicalevents.tracker")) {


                } else {
                    Colors.sendMessage((Player) sender, "&0&l[&4ERROR&0&l] -> &4commandNotFound");
                }

            }
            //-------------------
            if (args[0].equalsIgnoreCase("config")) {
                if (sender.hasPermission("mechanicalevents.config")) {
                    Player player = (Player) sender;
                    MainMenu.CreateGuiPrimary();
                    player.openInventory(MainMenu.config);
                }
            }
        }return true;
    }
}
