package com.desle.fp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class FactionPerms extends JavaPlugin {
	
	
	
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new FactionEvents(), this);
	}

}
