package com.danizml.mechanicalevents.commands;

import com.danizml.mechanicalevents.manager.YMLManager;
import com.danizml.mechanicalevents.menus.MainMenu;
import com.danizml.mechanicalevents.storage.Colors;
import com.danizml.mechanicalevents.storage.yml.Messages;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class PrimaryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mevents")) {
            if (args[0].equalsIgnoreCase("help")) {
                if (sender.hasPermission("mechanicalevents.help")) {
                    Colors.sendMessage((Player) sender, "&9&l[&bMechanicalEvents&9&l]");
                    Colors.sendMessage((Player) sender, "&9&l[&b+&9&l] &8help");
                    Colors.sendMessage((Player) sender, "&9&l[&b+&9&l] &8config");
                    Colors.sendMessage((Player) sender, "&9&l[&b+&9&l] &8reload");
                    Colors.sendMessage((Player) sender, "&9&l[&b+&9&l] &8tools");

                } else {
                    Colors.sendMessage((Player) sender, Messages.getMessages().getString("Messages.PermissionErrorMessage"));
                }
            }

            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("mechanicalevents.reload")) {
                    YMLManager.reloadYML();
                    Colors.sendMessage((Player) sender, "&9&l[&bMechanicalEvents&9&l] -> &8The config has been reloaded");

                } else {
                    Colors.sendMessage((Player) sender, Messages.getMessages().getString("Messages.PermissionErrorMessage"));
                }

            }

            //------------------
            if (args[0].equalsIgnoreCase("tools")) {
                if (sender.hasPermission("mechanicalevents.tools")) {
                    if (args[1].equalsIgnoreCase("tracker")) {
                        if (sender.hasPermission("mechanicalevents.tracker")) {
                            if (args[2].equalsIgnoreCase("on")) {

                            }

                            if (args[2].equalsIgnoreCase("off")) {

                            }
                        } else {
                            Colors.sendMessage((Player) sender, Messages.getMessages().getString("Messages.PermissionErrorMessage"));
                        }
                    }

                    if (args[1].equalsIgnoreCase("stickinfo")) {
                        ItemStack item = new ItemStack(Material.STICK, 1);
                        ItemMeta itemMeta = item.getItemMeta();

                        Objects.requireNonNull(itemMeta).setDisplayName(com.danizml.mechanicalevents.storage.ItemMeta.getStickInfo.getName());
                        itemMeta.setLore(com.danizml.mechanicalevents.storage.ItemMeta.getStickInfo.getLore());
                        itemMeta.addEnchant(Enchantment.DURABILITY, 3,true);
                        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                        item.setItemMeta(itemMeta);

                        ((Player) sender).getInventory().addItem(item);
                    } else {
                        Colors.sendMessage((Player) sender, Messages.getMessages().getString("Messages.PermissionErrorMessage"));
                    }

                    if (args[1].equalsIgnoreCase("teleportclock")) {
                        ItemStack item = new ItemStack(Material.COMPASS, 1);
                        ItemMeta itemMeta = item.getItemMeta();

                        Objects.requireNonNull(itemMeta).setDisplayName(com.danizml.mechanicalevents.storage.ItemMeta.getTeleportClock.getName());
                        itemMeta.setLore(com.danizml.mechanicalevents.storage.ItemMeta.getTeleportClock.getLore());
                        itemMeta.addEnchant(Enchantment.DURABILITY, 3,true);
                        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                        item.setItemMeta(itemMeta);

                        ((Player) sender).getInventory().addItem(item);
                    } else {
                        Colors.sendMessage((Player) sender, Messages.getMessages().getString("Messages.PermissionErrorMessage"));
                    }

                    if (args[1].equalsIgnoreCase("playerping")) {
                        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
                        ItemMeta itemMeta = item.getItemMeta();

                        Objects.requireNonNull(itemMeta).setDisplayName(com.danizml.mechanicalevents.storage.ItemMeta.getPlayerping.getName());
                        itemMeta.setLore(com.danizml.mechanicalevents.storage.ItemMeta.getPlayerping.getLore());
                        itemMeta.addEnchant(Enchantment.DURABILITY, 3,true);
                        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                        item.setItemMeta(itemMeta);

                        ((Player) sender).getInventory().addItem(item);
                    } else {
                        Colors.sendMessage((Player) sender, Messages.getMessages().getString("Messages.PermissionErrorMessage"));
                    }
                } else {
                    Colors.sendMessage((Player) sender, Messages.getMessages().getString("Messages.PermissionErrorMessage"));
                }
            }


            //-------------------
            if (args[0].equalsIgnoreCase("config")) {
                if (sender.hasPermission("mechanicalevents.config")) {
                    Player player = (Player) sender;
                    MainMenu.CreateGuiPrimary();
                    player.openInventory(MainMenu.config);
                } else {
                    Colors.sendMessage((Player) sender, Messages.getMessages().getString("Messages.PermissionErrorMessage"));
                }
            }
        }return true;
    }
}
