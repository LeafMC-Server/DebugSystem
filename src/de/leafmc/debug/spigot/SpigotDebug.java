package de.leafmc.debug.spigot;

import org.bukkit.plugin.java.JavaPlugin;

import de.leafmc.debug.core.Manager;

/**
 * 
 * <h1>SpigotDebug</h1>
 * This class is is the core class for the spigot-instance.
 * This is a link between spigot and the debugcore.
 * 
 * @author PlugDev
 * @version 1.0
 * @since 2021-07-22
 *
 */

public final class SpigotDebug extends JavaPlugin {
	
	public static final String PREFIX = "§7[§bDebug§7] ";
	private static SpigotDebug instance;
	private Manager manager;
	
	/**
	 * <h2>onLoad()</h2>
	 * This method sets the instance and
	 * creates a new Manager object with their benefits.
	 * 
	 * @author PlugDev
	 * @version 1.0
	 * @since 2021-07-22
	 * 
	 */
	
	@Override
	public void onLoad() {
		instance = this;
		manager = new Manager();
	}
	
	
	/**
	 * 
	 * <h2>onEnable()</h2>
	 * The onEnable()-Method is responsible for the registration
	 * of new commands xor listeners. It extends from the superclass Plugin.
	 * 
	 * @author PlugDev
	 * @version 1.0
	 * @since 2021-07-22
	 * 
	 */
	
	@Override
	public void onEnable() {
		getCommand("sdebug").setExecutor(new CommandSpigotDebug());
	}
	
	
	/**
	 * 
	 * <h2>static getInstance()</h2>
	 * 
	 * This method returns the in onLoad() set field \"instance\".
	 * 
	 * @author PlugDev
	 * @version 10
	 * @since 2021-07-22
	 * @return instance
	 * 
	 */
	
	public static SpigotDebug getInstance() {
		return instance;
	}
	
	public Manager getManager() {
		return manager;
	}
	
}
