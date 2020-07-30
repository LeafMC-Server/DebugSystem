package de.leafmc.debug.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Manager {
	
	private final List<Object> debugs = new ArrayList<>();
	private final Map<String, List<Object>> pluginDebugs = new HashMap<>();
	
	public void add(final Object object) {
		debugs.add(object);
	}
	
	public void add(final String plugin, final Object object) {
		if(pluginDebugs.containsKey(plugin)) {
			pluginDebugs.get(plugin).add(object);
		}else {
			final List<Object> list = new ArrayList<>();
			list.add(object);
			pluginDebugs.put(plugin, list);
		}
	}
	
	public boolean isDebugged(final String pluginName) {
		for(final String plugin : pluginDebugs.keySet()) {
			if(plugin.equalsIgnoreCase(pluginName)) return true;
		}
		
		return false;
	}
	
	public List<Object> getDebugs() {
		return this.debugs;
	}
	
	public List<Object> getDebugs(final String pluginName) {
		if(isDebugged(pluginName)) {
			return pluginDebugs.get(pluginName);
		}
		
		return new ArrayList<Object>();
	}
	
}
