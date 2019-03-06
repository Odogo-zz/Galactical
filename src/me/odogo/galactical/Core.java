package me.odogo.galactical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.odogo.galactical.cmds.Galactical;
import me.odogo.galactical.events.stations.Crafting;
import me.odogo.galactical.events.stations.Forgery;
import me.odogo.galactical.events.stations.Furnance;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Core extends JavaPlugin {

	public ArrayList<Player> astronauts = new ArrayList<Player>();
	public HashMap<Player, Boolean> astronautRadio = new HashMap<Player, Boolean>();

	public final String prefix = ChatColor.GRAY + "-[ " + ChatColor.AQUA + "Galactical" + ChatColor.GRAY + " ]- " + ChatColor.RESET;

	private static Economy econ = null;
	private static Permission perms = null;
	private static Chat chat = null;

	@Override
	public void onEnable() {
		registerConfigs();

		if(getConfig().getBoolean("use-vault-intergration")) {

			if (!setupEconomy() ) {
				getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
				getLogger().severe("Please disable the vault integration in the configuration of this plugin.");
				getServer().getPluginManager().disablePlugin(this);
				return;
			}
			setupPermissions();
			setupChat();

		} else { this.getLogger().log(Level.INFO, "'use-vault-intergration' was set to false. Skipping Vault Intergration."); }

		registerEvents();
	}

	private void registerEvents() {
		PluginManager pm = this.getServer().getPluginManager();

		pm.registerEvents(new Crafting(), this);
		pm.registerEvents(new Forgery(), this);
		pm.registerEvents(new Furnance(), this);

		pm.registerEvents(new Galactical(), this);
		getCommand("galactical").setExecutor(new Galactical());
	}

	private void registerConfigs() {

		getConfig().addDefault("use-vault-intergration", true);
		getConfig().addDefault("gameplay-settings.quick-mode", false);
		getConfig().options().copyDefaults(true);
		saveConfig();

	}

	@Override
	public void onDisable() {

	}

	//Vault Integration
	//Copyright (C) 2011-2018 Morgan Humes morgan@lanaddict.com for the next 3 methods.

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	private boolean setupChat() {
		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
		chat = rsp.getProvider();
		return chat != null;
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	//The rest of the methods below are now by me.

	public void addAstronaut(Player player) {
		if(player == null) {
			NullPointerException e = new NullPointerException("The player cannot be null");
			e.printStackTrace();
			return;
		}

		astronauts.add(player);
	}

	public void removeAstronaut(Player player) {
		astronauts.remove(player);
	}

	public ArrayList<Player> getAstronauts() {
		return astronauts;
	}

	public Player getAstronautByName(String idientifier) {

		if(astronauts.contains(this.getServer().getPlayer(idientifier))) {
			return this.getServer().getPlayer(idientifier);
		} else {
			return null;
		}
	}

	public Player getAstronautByUUID(UUID idientifier) {
		if(astronauts.contains(this.getServer().getPlayer(idientifier))) {
			return this.getServer().getPlayer(idientifier);
		} else {
			return null;
		}
	}

	public HashMap<Player, Boolean> getAstronautRadio() {
		return astronautRadio;
	}

	public void setAstronautRadio(Player player, boolean state) {
		if(player == null) {
			NullPointerException e = new NullPointerException("The player cannot be null");
			e.printStackTrace();
			return;
		}

		astronautRadio.put(player, state);
	}
}
