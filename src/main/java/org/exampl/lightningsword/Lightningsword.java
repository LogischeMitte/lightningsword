package org.exampl.lightningsword;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Lightningsword extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("lightningsword")).setExecutor(new lightningweapon());
        getServer().getPluginManager().registerEvents(new EntityListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();

            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Lightning Sword")) {
                event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
            }
        }

    }

}
