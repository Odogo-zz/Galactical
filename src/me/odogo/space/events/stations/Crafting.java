package me.odogo.space.events.stations;

public class Crafting implements Listener {
	
	private Core plugin = Core.getPlugin(Core.class);
	private final String prefix = plugin.prefix;
	
	@EventHandler
	public void onStationCraft(PlayerInteractionEvent e) {
		Player player = e.getPlayer();
		
		if(e.getAction != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		
		Block block = e.getBlock();
		World world = block.getWorld();
		Location bLoc = block.getLocation();
	}
	
	@EventHandler
	public void onStationCreation(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		
		Block block = e.getBlock();
		World world = block.getWorld();
		Location bLoc = block.getLocation();
	}
}
