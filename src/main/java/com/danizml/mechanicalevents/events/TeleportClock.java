package com.danizml.mechanicalevents.events;

import com.danizml.mechanicalevents.storage.ItemMeta;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

@SuppressWarnings({"deprecation"})
public class TeleportClock implements Listener {
    private static int number = 0;

    @EventHandler
    public void onClickWithTeleportClock(PlayerInteractEvent event) {
        if (number == 0) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR) {
                if (event.getPlayer().getItemInHand().getType() == Material.CLOCK) {
                    org.bukkit.inventory.meta.ItemMeta itemMeta = event.getPlayer().getItemInHand().getItemMeta();

                    if (Objects.equals(Objects.requireNonNull(itemMeta).getLore(), ItemMeta.getTeleportClock.getLore())) {
                        if (Objects.equals(Objects.requireNonNull(itemMeta).getDisplayName(), ItemMeta.getTeleportClock.getName())) {
                            Location location = event.getPlayer().getEyeLocation();
                            event.getPlayer().teleport(location);

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
