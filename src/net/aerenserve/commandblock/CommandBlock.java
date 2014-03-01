package net.aerenserve.commandblock;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandBlock extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		getLogger().info("CommandBlockLite v1.0 by hatten33 enabled.");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("CommandBlockLite v1.0 by hatten33 disabled.");
	}
	
	@EventHandler
	public void onCommandEvent(PlayerCommandPreprocessEvent event) {
		for(String s : getConfig().getStringList("blockedcommands")) {
			if(event.getMessage().substring(1).equalsIgnoreCase(s)) {
				event.getPlayer().sendMessage(ChatColor.RED + "This command is blocked for all users.");
				event.setCancelled(true);
			}
		}
	}

}
