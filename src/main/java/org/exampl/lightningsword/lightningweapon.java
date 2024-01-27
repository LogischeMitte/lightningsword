package org.exampl.lightningsword;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class lightningweapon implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack lsword = new ItemStack(Material.DIAMOND_SWORD);

            ItemMeta lswordmeta = lsword.getItemMeta();

            lswordmeta.setDisplayName(ChatColor.GOLD +"Lightning Sword");

            ArrayList<String> lore = new ArrayList<String>();
            lore.add("Creates lightning on hit");
            lswordmeta.setLore(lore);

            lsword.setItemMeta(lswordmeta);
            player.getInventory().addItem(lsword);
        }

        return true;

    }


}



