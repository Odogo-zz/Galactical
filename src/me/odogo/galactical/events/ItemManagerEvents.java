package me.odogo.galactical.events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.odogo.galactical.Core;
import me.odogo.galactical.util.ItemManager;

public class ItemManagerEvents implements Listener {

	private Core plugin = Core.getPlugin(Core.class);
	private final String prefix = plugin.prefix;

	private ItemManager im = new ItemManager();

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {

		Player player = e.getPlayer();

		ItemStack item = e.getItem();

		if(item.isSimilar(im.getOxygenMask())) {
			e.setCancelled(true);

			if(e.getAction() != Action.RIGHT_CLICK_AIR) {		
				player.sendMessage(prefix + ChatColor.RED + "You are not supposed to place this item.");
				player.playSound(player.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 0);
				return;
			}

			if(player.getInventory().getHelmet() != null) {
				player.sendMessage(prefix + ChatColor.RED + "To wear this item, please clear your helmet slot.");
				player.playSound(player.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 0);
				return;
			}

			if(!player.isSneaking()) {
				player.sendMessage(prefix + ChatColor.RED + "To wear this item, please crouch.");
				player.playSound(player.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 0);
				return;
			}

			player.getInventory().setHelmet(im.getOxygenMask());
			player.getInventory().setItem(player.getInventory().getHeldItemSlot(), null);
			player.sendMessage(prefix + ChatColor.GREEN + "Successfully put on the helmet.");
			player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
			return;
		}

	}

}
