package tsb.cacticraft.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.material.Material;
import tsb.cacticraft.blocks.Compost;
import tsb.cacticraft.blocks.CopperOre;
import tsb.cacticraft.blocks.FleshBlock;
import tsb.cacticraft.blocks.KimberliteBlock;
import tsb.cacticraft.blocks.LeadOre;
import tsb.cacticraft.blocks.NetherCobaltOre;
import tsb.cacticraft.blocks.NickelOre;
import tsb.cacticraft.blocks.ReinforcedNetherBricks;
import tsb.cacticraft.blocks.TinOre;
import tsb.cacticraft.blocks.machines.Forge;
import tsb.cacticraft.blocks.machines.Sinterer;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	public static final Block FLESH_BLOCK = new FleshBlock("flesh_block", Material.SPONGE);
	public static final Block COMPOST = new Compost("compost", Material.GROUND);
	public static final Block REINFORCED_NETHER_BRICKS = new ReinforcedNetherBricks("reinforced_nether_bricks", Material.ROCK);
	public static final Block KIMBERLITE_BLOCK = new KimberliteBlock("kimberlite_block", Material.ICE);
	
	//Ores
	public static final Block COPPER_ORE = new CopperOre("copper_ore", Material.ROCK);
	public static final Block TIN_ORE = new TinOre("tin_ore", Material.ROCK);
	public static final Block NICKEL_ORE = new NickelOre("nickel_ore", Material.ROCK);
	public static final Block NETHER_COBALT_ORE = new NetherCobaltOre("nether_cobalt_ore", Material.ROCK);
	public static final Block LEAD_ORE = new LeadOre("lead_ore", Material.ROCK);
	
	//Machines
	public static final Block FORGE = new Forge("forge");
	public static final Block SINTERER = new Sinterer("sinterer");
	
	
	//MC

	
	
}
