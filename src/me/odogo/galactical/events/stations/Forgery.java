package me.odogo.galactical.events.stations;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.odogo.galactical.Core;

public class Forgery implements Listener {

	private Core plugin = Core.getPlugin(Core.class);
	private final String prefix = plugin.prefix;

	@EventHandler
	public void onStationCraft(PlayerInteractEvent e) {
		Player player = e.getPlayer();

		if(e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}

		Block block = e.getClickedBlock();
		World world = block.getWorld();
		Location bLoc = block.getLocation();

		if(block.getType() != Material.ANVIL) {
			return;
		}

		Block bottom = new Location(world, bLoc.getX(), bLoc.getY() - 1, bLoc.getZ()).getBlock();
		Block aboveOne = new Location(world, bLoc.getX(), bLoc.getY() + 1, bLoc.getZ()).getBlock();

		if(bottom.getType() == Material.DROPPER && aboveOne.getType() == Material.ANVIL) {

			Dropper dropper = (Dropper) bottom;
			ItemStack[] shape = dropper.getInventory().getContents();

		}
	}

	@EventHandler
	public void onStationCreation(BlockPlaceEvent e) {
		Player player = e.getPlayer();

		Block block = e.getBlock();
		World world = block.getWorld();
		Location bLoc = block.getLocation();

		if(block.getType() == Material.ANVIL) {

			Block bottomOne = new Location(world, bLoc.getX(), bLoc.getY() - 1, bLoc.getZ()).getBlock();
			Block bottomTwo = new Location(world, bLoc.getX(), bLoc.getY() - 2, bLoc.getZ()).getBlock();

			if(bottomOne.getType() == Material.ANVIL && bottomTwo.getType() == Material.DROPPER) {

				player.sendMessage(prefix + ChatColor.GREEN + "Successfully created a Forgery Station!");
				player.playSound(bLoc, Sound.BLOCK_ANVIL_USE, 1, 1);

			}
		}
	}
}
