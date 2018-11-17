package tsb.cacticraft.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import tsb.cacticraft.Main;
import tsb.cacticraft.init.ModBlocks;
import tsb.cacticraft.init.ModItems;
import tsb.cacticraft.util.IHasModel;
import tsb.cacticraft.world.ModWorldGen;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new BlockEventHandler());
	}
	
	public static void initRegistries(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{
		
	}

	public static void otherRegistries()
	{
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
	}
	

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
    	ResourceLocation pick1 = new ResourceLocation("minecraft:wooden_pickaxe");
    	ResourceLocation pick2 = new ResourceLocation("minecraft:stone_pickaxe");
    	ResourceLocation pick3 = new ResourceLocation("minecraft:iron_pickaxe");
    	ResourceLocation pick4 = new ResourceLocation("minecraft:golden_pickaxe");
    	ResourceLocation pick5 = new ResourceLocation("minecraft:diamond_pickaxe");
    	ResourceLocation axe1 = new ResourceLocation("minecraft:wooden_axe");
    	ResourceLocation axe2 = new ResourceLocation("minecraft:stone_axe");
    	ResourceLocation axe3 = new ResourceLocation("minecraft:iron_axe");
    	ResourceLocation axe4 = new ResourceLocation("minecraft:golden_axe");
    	ResourceLocation axe5 = new ResourceLocation("minecraft:diamond_axe");
    	ResourceLocation sword1 = new ResourceLocation("minecraft:wooden_sword");
    	ResourceLocation sword2 = new ResourceLocation("minecraft:stone_sword");
    	ResourceLocation sword3 = new ResourceLocation("minecraft:iron_sword");
    	ResourceLocation sword4 = new ResourceLocation("minecraft:golden_sword");
    	ResourceLocation sword5 = new ResourceLocation("minecraft:diamond_sword");
    	ResourceLocation spade1 = new ResourceLocation("minecraft:wooden_spade");
    	ResourceLocation spade2 = new ResourceLocation("minecraft:stone_spade");
    	ResourceLocation spade3 = new ResourceLocation("minecraft:iron_spade");
    	ResourceLocation spade4 = new ResourceLocation("minecraft:golden_spade");
    	ResourceLocation spade5 = new ResourceLocation("minecraft:diamond_spade");
    	ResourceLocation hoe1 = new ResourceLocation("minecraft:wooden_hoe");
    	ResourceLocation hoe2 = new ResourceLocation("minecraft:stone_hoe");
    	ResourceLocation hoe3 = new ResourceLocation("minecraft:iron_hoe");
    	ResourceLocation hoe4 = new ResourceLocation("minecraft:golden_hoe");
    	ResourceLocation hoe5 = new ResourceLocation("minecraft:diamond_hoe");
    	ResourceLocation foot1 = new ResourceLocation("minecraft:leather_boots");
    	ResourceLocation foot2 = new ResourceLocation("minecraft:iron_boots");
    	ResourceLocation foot3 = new ResourceLocation("minecraft:golden_boots");
    	ResourceLocation foot4 = new ResourceLocation("minecraft:diamond_boots");
    	ResourceLocation leg1 = new ResourceLocation("minecraft:leather_leggings");
    	ResourceLocation leg2 = new ResourceLocation("minecraft:iron_leggings");
    	ResourceLocation leg3 = new ResourceLocation("minecraft:golden_leggings");
    	ResourceLocation leg4 = new ResourceLocation("minecraft:diamond_leggings");
    	ResourceLocation chest1 = new ResourceLocation("minecraft:leather_chestplate");
    	ResourceLocation chest2 = new ResourceLocation("minecraft:iron_chestplate");
    	ResourceLocation chest3 = new ResourceLocation("minecraft:golden_chestplate");
    	ResourceLocation chest4 = new ResourceLocation("minecraft:diamond_chestplate");
    	ResourceLocation hat1 = new ResourceLocation("minecraft:leather_helmet");
    	ResourceLocation hat2 = new ResourceLocation("minecraft:iron_helmet");
    	ResourceLocation hat3 = new ResourceLocation("minecraft:golden_helmet");
    	ResourceLocation hat4 = new ResourceLocation("minecraft:diamond_helmet");
    	ResourceLocation block4 = new ResourceLocation("minecraft:gold_block");
    	ResourceLocation ingot4 = new ResourceLocation("minecraft:gold_ingot_from_block");
        modRegistry.remove(pick1);
        modRegistry.remove(pick2);
        modRegistry.remove(pick3);
        modRegistry.remove(pick4);
        modRegistry.remove(pick5);
        modRegistry.remove(axe1);
        modRegistry.remove(axe2);
        modRegistry.remove(axe3);
        modRegistry.remove(axe4);
        modRegistry.remove(axe5);
        modRegistry.remove(sword1);
        modRegistry.remove(sword2);
        modRegistry.remove(sword3);
        modRegistry.remove(sword4);
        modRegistry.remove(sword5);
        modRegistry.remove(spade1);
        modRegistry.remove(spade2);
        modRegistry.remove(spade3);
        modRegistry.remove(spade4);
        modRegistry.remove(spade5);
        modRegistry.remove(hoe1);
        modRegistry.remove(hoe2);
        modRegistry.remove(hoe3);
        modRegistry.remove(hoe4);
        modRegistry.remove(hoe5);
        modRegistry.remove(foot1);
        modRegistry.remove(foot2);
        modRegistry.remove(foot3);
        modRegistry.remove(foot4);
        modRegistry.remove(leg1);
        modRegistry.remove(leg2);
        modRegistry.remove(leg3);
        modRegistry.remove(leg4);
        modRegistry.remove(chest1);
        modRegistry.remove(chest2);
        modRegistry.remove(chest3);
        modRegistry.remove(chest4);
        modRegistry.remove(hat1);
        modRegistry.remove(hat2);
        modRegistry.remove(hat3);
        modRegistry.remove(hat4);
        modRegistry.remove(block4);
        modRegistry.remove(ingot4);
   }
}
