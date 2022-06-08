package com.danizml.mechanicalevents.events;

import com.danizml.mechanicalevents.storage.ItemMeta;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

@SuppressWarnings({"deprecation"})
public class StickInfo implements Listener {
    private static int number = 0;

    @EventHandler
    public void onClickWithStickInfo(PlayerInteractEvent event) {
        if (number == 0) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (event.getPlayer().getItemInHand().getType() == Material.STICK) {
                    org.bukkit.inventory.meta.ItemMeta itemMeta = event.getPlayer().getItemInHand().getItemMeta();

                    if (Objects.equals(Objects.requireNonNull(itemMeta).getLore(), ItemMeta.getStickInfo.getLore())) {
                        if (Objects.equals(Objects.requireNonNull(itemMeta).getDisplayName(), ItemMeta.getStickInfo.getName())) {
                            String x = String.valueOf(Objects.requireNonNull(event.getClickedBlock()).getX());
                            String y = String.valueOf(Objects.requireNonNull(event.getClickedBlock()).getY());
                            String z = String.valueOf(Objects.requireNonNull(event.getClickedBlock()).getZ());

                            String drop = String.valueOf(Objects.requireNonNull(event.getClickedBlock().getDrops()));


                            String type = String.valueOf(Objects.requireNonNull(event.getClickedBlock()).getType());
                            String chunkX = String.valueOf(Objects.requireNonNull(event.getClickedBlock()).getChunk().getX());
                            String chunkZ = String.valueOf(Objects.requireNonNull(event.getClickedBlock()).getChunk().getZ());

                            event.getPlayer().sendMessage("+------------------------------------------------+");
                            event.getPlayer().sendMessage("This block is in: X: " + x + " Y: " + y + " Z: " + z);
                            event.getPlayer().sendMessage("This block is: " + type);
                            event.getPlayer().sendMessage("This block drop is: " + drop.replaceAll("ItemStack", "").replace("{", "").replace("}", ""));
                            event.getPlayer().sendMessage("This block is in the chunk: X: " + chunkX + " Z: " + chunkZ);
                            event.getPlayer().sendMessage("+------------------------------------------------+");
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
