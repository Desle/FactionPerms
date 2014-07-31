package com.desle.fp;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;

public class FactionManager {
	
	
	
	/*
	 *               * INSTANCE
	 */
	
	private static FactionManager instance;
	
	public static FactionManager getInstance() {
		if (instance == null)
			instance = new FactionManager();
		return instance;
	}
	
	
	
	
	
	
	
	
	
	/*
	 *               * GETTERS
	 */
	
	public List<String> getFactionPerms(Player player) {
	
		List<String> permissions = new ArrayList<String>();
		
		for (PermissionAttachmentInfo p : player.getEffectivePermissions()) {
			
			String stringed = p.getPermission();
			
			if (stringed.startsWith("factionperms."))
				permissions.add(stringed.replace("factionperms.", ""));
			
		}
		
		return permissions;
	}
	
	
	
	
	
	
	
	public boolean canInvite(Player sender, Player reciever) {
		
		List<String> senderPerms = getFactionPerms(sender);
		List<String> recieverPerms = getFactionPerms(reciever);
		
		
		// CHECKERS
		if (senderPerms.isEmpty()) return false;
		if (recieverPerms.isEmpty()) return false;
		// CHECKERS
		
		
		for (String perm : senderPerms) {
			
			if (recieverPerms.contains(perm)) 
				return true;
			
		}
		
		
		return false;
	}
}
