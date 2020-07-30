package de.leafmc.debug.spigot;

import org.bukkit.plugin.java.JavaPlugin;

import de.leafmc.debug.core.Manager;

public final class Debug extends JavaPlugin {
	
	public static final String PREFIX = "§7[§bDebug§7] ";
	private static Debug instance;
	private Manager manager;
	
	@Override
	public void onLoad() {
		instance = this;
		manager = new Manager();
	}
	
	@Override
	public void onEnable() {
		getCommand("debug").setExecutor(new CommandDebug());
	}
	
	public static Debug getInstance() {
		return instance;
	}
	
	public Manager getManager() {
		return manager;
	}
	
}
