package me.gardeningtool.playerlist;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.gardeningtool.playerlist.util.CommandBase;
import me.gardeningtool.playerlist.util.ConfigUtil;

public class ListCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		CommandBase base = CommandBase.fromArgs(sender, args, cmd);
		if (!base.hasPermission(ConfigUtil.PERMISSION)) {
			base.sendMessage(ConfigUtil.PERMISSION_MESSAGE);
		}
		base.sendMessage(ConfigUtil.getFormattedMesssage());
		return true;
	}
}
