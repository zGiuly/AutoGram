package listeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import info.zgiuly.autogram.Main;

public class ChatListener implements Listener {
	private FileConfiguration config = Main.getInstance().getConfig();

	@EventHandler
	public void chat(AsyncPlayerChatEvent event) {
		if (!event.getMessage().startsWith("/")) {
			if (config.getBoolean("Settings.enable_autogram")) {
				if (config.getBoolean("Settings.enable_autopoint") && config.getBoolean("Settings.enable_autocolor")) {
					event.setCancelled(true);
					char init = event.getMessage().toUpperCase().replace("&", "§").charAt(0);
					String fixed = event.getMessage().substring(1).replace("&", "§");
					Bukkit.broadcastMessage(event.getPlayer().getDisplayName() + " " + init + fixed + ".");
				} else if (!config.getBoolean("Settings.enable_autopoint")
						&& config.getBoolean("Settings.enable_autocolor")) {
					event.setCancelled(true);
					char init = event.getMessage().toUpperCase().replace("&", "§").charAt(0);
					String fixed = event.getMessage().substring(1).replace("&", "§");
					Bukkit.broadcastMessage(event.getPlayer().getDisplayName() + " " + init + fixed);
				} else if (!config.getBoolean("Settings.enable_autopoint")
						&& !config.getBoolean("Settings.enable_autocolor")) {
					event.setCancelled(true);
					char init = event.getMessage().toUpperCase().charAt(0);
					String fixed = event.getMessage().substring(1);
					Bukkit.broadcastMessage(event.getPlayer().getDisplayName() + " " + init + fixed);
				} else if (config.getBoolean("Settings.enable_autopoint")
						&& !config.getBoolean("Settings.enable_autocolor")) {
					event.setCancelled(true);
					char init = event.getMessage().toUpperCase().charAt(0);
					String fixed = event.getMessage().substring(1);
					Bukkit.broadcastMessage(event.getPlayer().getDisplayName() + " " + init + fixed + ".");
				}
			}
		}
	}
}
