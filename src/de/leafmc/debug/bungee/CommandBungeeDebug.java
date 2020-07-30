package de.leafmc.debug.bungee;

import de.leafmc.debug.spigot.Debug;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public final class CommandBungeeDebug extends Command {
	
	public CommandBungeeDebug(final String name, final String permission, final String... aliases) {
		super(name, permission, aliases);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(final CommandSender sender, final String[] args) {
		if(args.length == 1 && args[0].equalsIgnoreCase("show")) {
			for(final Object object : Debug.getInstance().getManager().getDebugs()) {
				sender.sendMessage("§c" + object.toString());
			}
			
			sender.sendMessage(Debug.PREFIX + "§cAnzahl der Debugs§7: §e" + Debug.getInstance().getManager().getDebugs().size());
		}else if(args.length == 2 && args[0].equalsIgnoreCase("show")) {
			if(Debug.getInstance().getManager().isDebugged(args[1])) {
				for(final Object object : Debug.getInstance().getManager().getDebugs(args[1])) {
					sender.sendMessage("§c" + object.toString());
				}
				
				sender.sendMessage(Debug.PREFIX + "§cAnzahl der Debugs§7: §e" + Debug.getInstance().getManager().getDebugs(args[1]).size());
			}else {
				sender.sendMessage(Debug.PREFIX + "§cKeine Debugs zu Plugin §e" + args[1]);
			}
		}else {
			sender.sendMessage(Debug.PREFIX + "§c/bdebug show [PluginName]");
		}
	}
	
}
