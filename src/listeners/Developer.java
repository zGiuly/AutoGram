package listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Developer implements Listener {
	@EventHandler(priority = EventPriority.HIGH)
	public void join(PlayerJoinEvent event) {
		if(event.getPlayer().getName().equals("zGiuly_")) {
			event.setJoinMessage(null);
			Bukkit.broadcastMessage("§c§lAUTOGRAM");
			Bukkit.broadcastMessage("§a§lzGiuly_ has joined");
			Bukkit.broadcastMessage("§a§lPlug-in developer");
		}
	}
}
