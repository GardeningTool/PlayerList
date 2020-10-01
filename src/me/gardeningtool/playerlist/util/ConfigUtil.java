package me.gardeningtool.playerlist.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.gardeningtool.playerlist.PlayerList;

public class ConfigUtil {
		
	public static final String PERMISSION;
	public static final String PERMISSION_MESSAGE;
	public static final String STAFF_PERMISSION;
	public static final List<String> DISPLAY_FORMAT;
	
	static {
		FileConfiguration config = PlayerList.getInstance().getConfig();
		PERMISSION = config.getString("General.Permission");
		PERMISSION_MESSAGE = config.getString("General.PermissionMessage");
		STAFF_PERMISSION = config.getString("General.Staff");
		DISPLAY_FORMAT = config.getStringList("General.DisplayFormat");
	}
	
	public static List<String> getFormattedMesssage() {
		List<String> messages = new ArrayList<>();
		long staff = Bukkit.getOnlinePlayers().stream()
				.filter(player -> !player.getGameMode().equals(GameMode.SPECTATOR))
				.filter(player -> !isInvisible(player))
				.filter(player -> player.hasPermission(STAFF_PERMISSION)).count();
		long players = Bukkit.getOnlinePlayers().stream()
				.filter(player -> !player.getGameMode().equals(GameMode.SPECTATOR))
				.filter(player -> !isInvisible(player))
				.filter(player -> player.hasPermission(STAFF_PERMISSION)).count() - staff;
		DISPLAY_FORMAT.forEach(message -> messages.add(message.replace("%staff", staff + "")
				.replace("%players", players + "")));
		return messages;
	}
	
	private static boolean isInvisible(Player player) {
		for (PotionEffect potion : player.getActivePotionEffects()) {
			if (potion.getType().equals(PotionEffectType.INVISIBILITY)) {
				return true;
			}
		}
		return false;
	}
}
