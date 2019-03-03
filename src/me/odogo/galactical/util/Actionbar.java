package me.odogo.galactical.util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction;

public class Actionbar {

	private PacketPlayOutTitle packet;
	private String message;
	private Player player;

	public Actionbar(String message) {
		this.message = message;

		packet = new PacketPlayOutTitle(EnumTitleAction.ACTIONBAR, ChatSerializer.a("{\"text\":\"" + this.message + "\"}"), 0, 30, 0);
	}

	public Actionbar(String message, Player player) {
		this.player = player;
		this.message = message;
		
		packet = new PacketPlayOutTitle(EnumTitleAction.ACTIONBAR, ChatSerializer.a("{\"text\":\"" + this.message + "\"}"), 0, 30, 0);
	}

	public void sendActionbar(Player player) {
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

	public void sendActionbar() {
		if(player == null) {
			NullPointerException e = new NullPointerException("Player cannot be null.");
			e.printStackTrace();
			return;
		}

		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

	public void sendActionbarToPlayers(ArrayList<Player> player) {
		for(Player players : player) {
			((CraftPlayer) players).getHandle().playerConnection.sendPacket(packet);
		}
	}

	public void sendActionbarToPlayersOnline() {
		for(Player players : Bukkit.getOnlinePlayers()) {
			((CraftPlayer) players).getHandle().playerConnection.sendPacket(packet);
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
