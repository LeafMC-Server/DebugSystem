package de.leafmc.debug.bungee;

import de.leafmc.debug.core.Manager;
import net.md_5.bungee.api.plugin.Plugin;

public final class Debug extends Plugin {
	
	public static final String PREFIX = "§7[§bBungeeDebug§7] ";
	private static Debug instance;
	private Manager manager;
	
	@Override
	public void onLoad() {
		instance = this;
		manager = new Manager();
	}
	
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new CommandBungeeDebug("bdebug", "system.debug", "bungeedebug"));
	}
	
	public static Debug getInstance() {
		return instance;
	}
	
	public Manager getManager() {
		return manager;
	}
	
}
