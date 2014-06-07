package com.ep5.GUI;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getLogger().info("[GUI] Starting");
		Bukkit.getServer().getPluginManager().registerEvents(new GUI(), this);
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player =((Player)sender);
	if (command.getName().equalsIgnoreCase("gui")){
		player.openInventory(GUI.GUI);
	}
	
	
	return false;
	
	
	}

}
