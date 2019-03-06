package me.odogo.galactical.util;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {

	public ItemManager() {
		return;
	}

	public ItemStack[] getEmpty() {
		ItemStack[] clear = new ItemStack[] { null, null,	null, null, null, null, null, null, null }; return clear;
	}

	public ItemStack getCompressedIron() {
		ItemStack compIron = new ItemStack(Material.IRON_INGOT);
		ItemMeta compIronM = compIron.getItemMeta();

		compIronM.setDisplayName(ChatColor.GOLD + "Compressed Iron");
		compIronM.setLore(Arrays.asList(ChatColor.GRAY + "2 ingots of iron that were compressed together.", ChatColor.GOLD + "Galactical Material"));

		compIron.setItemMeta(compIronM);

		return compIron;
	}

	public ItemStack[] getCompressedIronShape() {

		ItemStack[] compIronShape = {
				null, null, null,
				null, new ItemStack(Material.IRON_INGOT), null,
				null, new ItemStack(Material.IRON_INGOT), null,
		};

		return compIronShape;
	}

	public ItemStack getCompressedGold() {
		ItemStack compGold = new ItemStack(Material.GOLD_INGOT);
		ItemMeta compGoldM = compGold.getItemMeta();

		compGoldM.setDisplayName(ChatColor.GOLD + "Compressed Gold");
		compGoldM.setLore(Arrays.asList(ChatColor.GRAY + "2 ingots of gold that were compressed together.", ChatColor.GOLD + "Galactical Material"));

		compGold.setItemMeta(compGoldM);
		return compGold;

	}

	public ItemStack[] getCompressedGoldShape() {

		ItemStack[] compGoldShape = {
				null, null, null,
				null, new ItemStack(Material.GOLD_INGOT), null,
				null, new ItemStack(Material.GOLD_INGOT), null,
		};

		return compGoldShape;

	}

	public ItemStack getCompressedDiamond() {
		ItemStack compDiamond = new ItemStack(Material.DIAMOND);
		ItemMeta compDiamondM = compDiamond.getItemMeta();

		compDiamondM.setDisplayName(ChatColor.GOLD + "Compressed Diamond");
		compDiamondM.setLore(Arrays.asList(ChatColor.GRAY + "2 ingots of diamond that were compressed together.", ChatColor.GOLD + "Galactical Material"));

		compDiamond.setItemMeta(compDiamondM);
		return compDiamond;

	}

	public ItemStack[] getCompressedDiamondShape() {

		ItemStack[] compDiamondShape = {
				null, null, null,
				null, new ItemStack(Material.DIAMOND), null,
				null, new ItemStack(Material.DIAMOND), null,
		};

		return compDiamondShape;

	}

	public ItemStack getCompressedEmerald() {
		ItemStack compEmerald = new ItemStack(Material.EMERALD);
		ItemMeta compEmeraldM = compEmerald.getItemMeta();

		compEmeraldM.setDisplayName(ChatColor.GOLD + "Compressed Emerald");
		compEmeraldM.setLore(Arrays.asList(ChatColor.GRAY + "2 ingots of emerald that were compressed together.", ChatColor.GOLD + "Galactical Material"));

		compEmerald.setItemMeta(compEmeraldM);
		return compEmerald;

	}

	public ItemStack[] getCompressedEmeraldShape() {

		ItemStack[] compEmeraldShape = {
				null, null, null,
				null, new ItemStack(Material.EMERALD), null,
				null, new ItemStack(Material.EMERALD), null,
		};

		return compEmeraldShape;
	}

	public ItemStack getOxygenWire() {
		ItemStack wire = new ItemStack(Material.END_ROD);
		ItemMeta wireM = wire.getItemMeta();

		wireM.setDisplayName(ChatColor.AQUA + "Oxygen Wire");
		wireM.setLore(Arrays.asList(ChatColor.GRAY + "Transfers Oxygen to one place to another.", ChatColor.GOLD + "Galactical Material", ChatColor.AQUA + "Oxygen Set Material"));

		wire.setItemMeta(wireM);
		return wire;
	}

	public ItemStack[] getOxygenWireShape() {

		ItemStack[] wireShape = {
				new ItemStack(Material.WOOL, 1, (short) 15), new ItemStack(Material.WOOL, 1, (short) 15), new ItemStack(Material.WOOL, 1, (short) 15),
				new ItemStack(Material.WOOL, 1, (short) 15), null, new ItemStack(Material.WOOL, 1, (short) 15),
				new ItemStack(Material.WOOL, 1, (short) 15), new ItemStack(Material.WOOL, 1, (short) 15), new ItemStack(Material.WOOL, 1, (short) 15),
		};

		return wireShape;

	}
}