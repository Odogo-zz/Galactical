package me.odogo.galactical.events.stations;

import java.util.Arrays;

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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.odogo.galactical.Core;
import me.odogo.galactical.util.ItemManager;

public class Crafting implements Listener {

	private Core plugin = Core.getPlugin(Core.class);
	private final String prefix = plugin.prefix;
	private ItemManager im = new ItemManager();

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

		if(bottom.getType() == Material.DROPPER && aboveOne.getType() == Material.WORKBENCH) {

			e.setCancelled(true);

			Dropper dropper = (Dropper) bottom.getState();
			Inventory inv = dropper.getInventory();
			ItemStack[] shape = dropper.getInventory().getContents();

			if(Arrays.equals(shape, im.getEmpty())) {
				player.sendMessage(prefix + ChatColor.RED + "Your crafting was unsuccessful. The shape is empty.");
				player.playSound(bLoc, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1, 1);
				return;
			}

			if(Arrays.equals(shape, im.getOxygenWireShape())) {

				inv.clear();

				inv.setItem(4, im.getOxygenWire());

				player.sendMessage(prefix + ChatColor.GREEN + "Your crafting was successful. You made " + im.getOxygenWire().getItemMeta().getDisplayName());				
				player.playSound(bLoc, Sound.BLOCK_ANVIL_USE, 1, 1);

			} else if(Arrays.equals(shape, im.getOxygenMaskShape())) {

				inv.clear();
				inv.setItem(4, im.getOxygenMask());

				player.sendMessage(prefix + ChatColor.GREEN + "Your crafting was successful. You made " + im.getOxygenMask().getItemMeta().getDisplayName());				
				player.playSound(bLoc, Sound.BLOCK_ANVIL_USE, 1, 1);

			}


		}
	}

	@EventHandler
	public void onStationCreation(BlockPlaceEvent e) {
		Player player = e.getPlayer();

		Block block = e.getBlock();
		World world = block.getWorld();
		Location bLoc = block.getLocation();

		if(block.getType() == Material.WORKBENCH) {

			Block bottomOne = new Location(world, bLoc.getX(), bLoc.getY() - 1, bLoc.getZ()).getBlock();
			Block bottomTwo = new Location(world, bLoc.getX(), bLoc.getY() - 2, bLoc.getZ()).getBlock();

			if(bottomOne.getType() == Material.ANVIL && bottomTwo.getType() == Material.DROPPER) {

				player.sendMessage(prefix + ChatColor.GREEN + "Successfully created a Crafting Station!");
				player.playSound(bLoc, Sound.BLOCK_ANVIL_USE, 1, 1);

			}
		}
	}
}
