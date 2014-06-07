package com.ep5.GUI;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI implements Listener {

	private static ItemStack spawn;
	
	public static Inventory GUI = Bukkit.createInventory(null, 18, "Test GUI");
	
	static
	{
		
		spawn = item1(ChatColor.RED + "Spawn");
		
		GUI.setItem(4, spawn);
		
	}
	
	
	
	private static ItemStack item1(String name){
		ItemStack i = new ItemStack(new ItemStack(Material.ANVIL, 1));
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(name);
		im.setLore(Arrays.asList("§aGo to the server spawn!"));
		i.setItemMeta(im);
		return i;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!e.getInventory().getName().equalsIgnoreCase(GUI.getName())) return;
		if (e.getCurrentItem().getItemMeta() == null) return;
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Spawn")){
			e.setCancelled(true);
			e.getWhoClicked().teleport(e.getWhoClicked().getWorld().getSpawnLocation());
			e.getWhoClicked().closeInventory();
		}
	}
	
	
	
	
	
}
		