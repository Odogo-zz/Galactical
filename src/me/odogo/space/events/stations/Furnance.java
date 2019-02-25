package me.odogo.space.events.stations;

public class Furnance implements Listener {
	
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
		
		if(block.getType() != Material.ANVIL) {
			return;
		}
		
		Block bottom = new Location(world, bLoc.getX(), bLoc.getY() - 1, bLoc.getZ()).getBlock();
		Block aboveOne = new Location(world, bLoc.getX(), bLoc.getY() + 1, bLoc.getZ()).getBlock();
		
		if(bottom.getType() == Material.DROPPER && aboveOne.getType() == Material.CRAFTING_TABLE) {
				
			Dropper dropper = (Dropper) bottom;
			ItemStack[] shape = droppper.getInventory().getContains();
			
		}
	}
	
	@EventHandler
	public void onStationCreation(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		
		Block block = e.getBlock();
		World world = block.getWorld();
		Location bLoc = block.getLocation();
		
		if(block.getType() == Material.CRAFTING_TABLE) {
			
			Block bottomOne = new Location(world, bLoc.getX(), bLoc.getY() - 1, bLoc.getZ()).getBlock();
			Block bottomTwo = new Location(world, bLoc.getX(), bLoc.getY() - 2, bLoc.getZ()).getBlock();
			
			if(bottomOne.getType() == Material.ANVIL && bottomTwo.getType() == Material.DROPPER) {
				
				player.sendMessage(prefix + ChatColor.GREEN + "Successfully created a Crafting Station!");
				player.playSound(bLoc, Sound.BLOCK_ANVIL_USE, 1, 1);
				
			}
		}
	}
}
