package info.zgiuly.autogram;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import commandexecutor.ReloadExecutor;
import listeners.ChatListener;
import listeners.Developer;

public class Main extends JavaPlugin {
	private static Main instance;

	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
		Bukkit.getPluginManager().registerEvents(new Developer(), this);
		getCommand("autoreload").setExecutor(new ReloadExecutor());
		saveDefaultConfig();
	}

	@Override
	public void onDisable() {
		
	}

	public static Main getInstance() {
		return instance;
	}

}
