package me.gardeningtool.playerlist;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;

public class PlayerList extends JavaPlugin {

	@Getter private static PlayerList instance;
	
	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		getCommand("list").setExecutor(new ListCommand());
	}
}
