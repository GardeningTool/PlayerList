package me.gardeningtool.playerlist.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Gardening_Tool
 *
 */
public class CommandBase {

	private CommandSender sender;
	private String[] args;
	private String commandName;
	private Player player;
	private boolean isPlayer;

	/**
	 * 
	 * @param sender the CommandSender object
	 * @param args the arguments
	 * @param cmd the command
	 */
	public CommandBase(CommandSender sender, String[] args, Command cmd) {
		this.sender = sender;
		this.args = args;
		this.commandName = cmd.getName();
		this.isPlayer = sender instanceof Player;
	}
	
	/**
	 * 
	 * @param sender
	 * @param args
	 * @param cmd
	 * @return a new CommandBase object
	 */
	public static CommandBase fromArgs(CommandSender sender, String[] args, Command cmd) {
		return new CommandBase(sender, args, cmd);
	}
	
	/**
	 * 
	 * @return the CommandSender as a player
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * 
	 * @return the CommandSender
	 */
	public CommandSender getSender() {
		return this.sender;
	}

	/**
	 * 
	 * @return the arguments of the command
	 */
	public String[] getArgs() {
		return this.args;
	}
	
	/**
	 * 
	 * @return the arguments of the command as a list
	 */
	
	public List<String> getArgsAsList() {
		return Arrays.asList(args);
	}

	/**
	 * 
	 * @param index get a specific argument to return
	 * @return the argument
	 */
	public String get(int index) {
		return this.args[index];
	}

	/**
	 * 
	 * @return whether the CommandSender is a player or not
	 */
	public boolean isPlayer() {
		return this.isPlayer;
	}

	/**
	 * 
	 * @return the command name
	 */
	public String getCmd() {
		return this.commandName;
	}

	/**
	 * 
	 * @param index the arg to evaluate
	 * @return whether the arg is a player or not
	 */
	public boolean isPlayer(int index) {
		return Bukkit.getPlayer(args[index]) == null;
	}

	/**
	 * 
	 * @param index the arg to parse as player
	 * @return the player object of the index
	 */
	@SuppressWarnings("deprecation")
	public OfflinePlayer getOfflinePlayer(int index) {
		return Bukkit.getOfflinePlayer(args[index]);
	}

	/**
	 * 
	 * @param index the arg to evaluate
	 * @return whether the arg is a player/offlineplayer or not
	 */
	@SuppressWarnings("deprecation")
	public boolean isOfflinePlayer(int index) {
		return Bukkit.getOfflinePlayer(args[index]) == null;
	}

	/**
	 * 
	 * @param permission the permission to evaluate for
	 * @return whether the CommandSender has the specified permission
	 */
	public boolean hasPermission(String permission) {
		return sender.hasPermission(permission);
	}

	/**
	 * 
	 * @param index the arg to parse as player
	 * @return the player object of the index
	 */
	public Player getPlayer(int index) {
		return Bukkit.getPlayer(args[index]);
	}

	/**
	 * 
	 * @return the name of the Player if the CommandSender instances a Player
	 */
	public String getName() {
		return this.player.getName();
	}
	
	/**
	 * 
	 * @param messages to be sent
	 */
	public void sendMessage(String...messages) {
		Arrays.asList(messages).forEach(m -> {
			this.sender.sendMessage(ChatColor.translateAlternateColorCodes('&', m));
		});
	}
	
	/**
	 * 
	 * @param messages to be sent
	 */
	public void sendMessage(Collection<String> messages) {
		messages.forEach(message -> sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message)));
	}

	/**
	 * 
	 * @return the args count
	 */

	public int count() {
		return args.length;
	}

	/**
	 * 
	 * @param index the argument to try
	 * @return boolean if the arg is able to parse
	 */
	public boolean isInt(int index) {
		try {
			Integer.parseInt(args[index]);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param index the argument to try
	 * @return boolean if the arg is able to parse
	 */
	public boolean isDouble(int index) {
		try {
			Double.parseDouble(args[index]);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param index the argument to try
	 * @return boolean if the arg is able to parse
	 */
	public boolean isLong(int index) {
		try {
			Long.parseLong(args[index]);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param index the argument to try
	 * @return boolean if the String is able to parse
	 */
	public boolean isInt(String index) {
		try {
			Integer.parseInt(index);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param index the argument to try
	 * @return boolean if the String is able to parse
	 */
	public boolean isDouble(String index) {
		try {
			Double.parseDouble(index);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param index the argument to try
	 * @return boolean if the String is able to parse
	 */
	public boolean isLong(String index) {
		try {
			Long.parseLong(index);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
