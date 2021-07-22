package de.leafmc.debug.bungee;

import de.leafmc.debug.core.Manager;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * 
 * <h1>BungeeDebug</h1>
 * This class is is the core class for the bungeecord-instance.
 * This is a link between proxy and the debugcore.
 * 
 * @author PlugDev
 * @version 1.0
 * @since 2021-07-22
 *
 */

public final class BungeeDebug extends Plugin {
	
	public static final String PREFIX = "§7[§bBungeeDebug§7] ";
	private static BungeeDebug instance;
	private Manager manager;
	
	/**
	 * <h2>onLoad()</h2>
	 * This method sets the instance and
	 * creates a new Manager object with their benefits.
	 * 
	 * Called when the plugin has just been loaded.
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
	 * Called when this plugin enabled.
	 * 
	 * @author PlugDev
	 * @version 1.0
	 * @since 2021-07-22
	 * 
	 */
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new CommandBungeeDebug("bdebug", "system.debug", "bungeedebug"));
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
	
	public static BungeeDebug getInstance() {
		return instance;
	}
	
	public Manager getManager() {
		return manager;
	}
	
}
