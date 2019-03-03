package me.odogo.galactical;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GalacticalManager {

	private Core plugin = Core.getPlugin(Core.class);
	private ArrayList<Player> astronauts = plugin.getAstronauts();

	public GalacticalManager() {
		return;
	}

	public void startTimer() {

		new BukkitRunnable() {

			@Override
			public void run() {

				for(Player player : astronauts) {

					if(player == null || !player.isOnline()) {
						return;
					}

					if(player.getWorld().getName().equals("Moon")) {



					}
				}
			}
		}.runTaskTimer(plugin, 0, 20);
	}

	public boolean playerEquipmentCheck(Player player) {

		//Just in case if the player logged out.


		return true;

	}

}
