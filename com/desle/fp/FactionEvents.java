package com.desle.fp;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.massivecraft.factions.event.FactionsEventCreate;
import com.massivecraft.factions.event.FactionsEventInvitedChange;

public class FactionEvents implements Listener {
	
	
	@EventHandler
	public void onFactionCreate(FactionsEventCreate e) {
		
		FactionManager fm = FactionManager.getInstance();
		
		if (fm.getFactionPerms(e.getUSender().getPlayer()).isEmpty()) {
			
			/*
			 *  CAN NOT CREATE
			 */
			
			
			String msg = ChatColor.translateAlternateColorCodes('&', "&7[&3RC&7] &bYou need to join a legion before you can create a faction.");
			
			e.getSender().sendMessage(msg);
			e.setCancelled(true);
		}
		
	}
	
	
	
	
	@EventHandler
	public void onFactionInvite(FactionsEventInvitedChange e) {
		
		FactionManager fm = FactionManager.getInstance();
		
		if (!fm.canInvite(e.getUSender().getPlayer(), e.getUPlayer().getPlayer())) {
			
			/*
			 * CAN NOT INVITE
			 */
			
			String msg = ChatColor.translateAlternateColorCodes('&', "&7[&3RC&7] &bYou can only invite players from the same legion as you.");
			e.setCancelled(true);
			
			e.getSender().sendMessage(msg);
		}		
	}
}
