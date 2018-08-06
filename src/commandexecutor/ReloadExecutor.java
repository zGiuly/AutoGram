package commandexecutor;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import info.zgiuly.autogram.Main;

public class ReloadExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.isOp()) {
				Main.getInstance().reloadConfig();
				Bukkit.getPluginManager().disablePlugin(Main.getInstance());
				Bukkit.getPluginManager().enablePlugin(Main.getInstance());
				p.sendMessage("§cPlugin reloaded§a made by zGiuly");
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 10, 5);
				return true;
			}
		} else if (sender instanceof ConsoleCommandSender) {
			Main.getInstance().reloadConfig();
			Bukkit.getPluginManager().disablePlugin(Main.getInstance());
			Bukkit.getPluginManager().enablePlugin(Main.getInstance());
			Bukkit.getConsoleSender().sendMessage("Plugin reloaded!");
			return true;
		} else {
			return false;
		}
		return false;
	}

}
