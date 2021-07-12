package com.h4ks1u.randomsheeploot.listeners;

import com.h4ks1u.randomsheeploot.RandomSheepLoot;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class SheepListener implements Listener {

    private RandomSheepLoot plugin;

    public Material[] materials = Material.values();


    public Random rand = new Random();

    public SheepListener(RandomSheepLoot plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerShear(PlayerShearEntityEvent event) {
        Player player = event.getPlayer();
        ItemStack mainhand = player.getInventory().getItemInMainHand();
        if (event.getEntity().getType().equals(EntityType.SHEEP)) {
            Sheep sheep = (Sheep) event.getEntity();
            Location loc = sheep.getLocation().add(0.0D, 0.4D, 0.0D);
            World world = sheep.getWorld();

            if (equals(mainhand, new ItemStack(Material.SHEARS))) {
                Material mat = this.materials[this.rand.nextInt(this.materials.length)];
                while (mat.name().contains("COMMAND") || mat.isAir() || !mat.isItem()) {
                    mat = this.materials[this.rand.nextInt(this.materials.length)];
                }
                int times = rand.nextInt(63) + 1;
                sheep.getWorld().dropItem(loc, new ItemStack(mat, times));
            }
        }
    }

        public static boolean equals(ItemStack a, ItemStack b) {
            if (a.getType() != b.getType())
                return false;
            return a.getItemMeta().getDisplayName().equals(b.getItemMeta().getDisplayName());
        }
}
