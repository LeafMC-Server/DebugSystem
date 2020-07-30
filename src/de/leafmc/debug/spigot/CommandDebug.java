package de.leafmc.debug.spigot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public final class CommandDebug implements CommandExecutor {
	
	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String str, final String[] args) {
		if(!sender.hasPermission("system.debug")) return false;
		
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
			sender.sendMessage(Debug.PREFIX + "§c/debug show [PluginName]");
		}
		
		return false;
	}
	
}
