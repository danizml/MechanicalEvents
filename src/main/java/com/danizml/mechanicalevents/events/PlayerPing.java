package com.danizml.mechanicalevents.events;

import com.danizml.mechanicalevents.storage.ItemMeta;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.print.DocFlavor;
import java.util.Objects;

@SuppressWarnings({"deprecation"})
public class PlayerPing implements Listener {
    private static int number = 0;

    @EventHandler
    public void onClickWithPlayerPing(PlayerInteractEvent event) {
        if (number == 0) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (event.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD) {
                    org.bukkit.inventory.meta.ItemMeta itemMeta = event.getPlayer().getItemInHand().getItemMeta();

                    if (Objects.equals(Objects.requireNonNull(itemMeta).getLore(), ItemMeta.getStickInfo.getLore())) {
                        if (Objects.equals(Objects.requireNonNull(itemMeta).getDisplayName(), ItemMeta.getStickInfo.getName())) {

                            String ping = String.valueOf(Objects.requireNonNull(event.getPlayer().getPing()));
                            String player = String.valueOf(Objects.requireNonNull(event.getPlayer().getDisplayName()));

                            event.getPlayer().sendMessage("[" + player + "] has: " + ping + " of ping");
                            number++;
                        }
                    }
                }
            }
        } else {
            number = 0;
        }
    }
}
