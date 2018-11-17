package tsb.cacticraft.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tsb.cacticraft.Reference;
import tsb.cacticraft.blocks.machines.TileEntityForge;
import tsb.cacticraft.blocks.machines.TileEntitySinterer;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityForge.class, new ResourceLocation(Reference.MODID + ":forge"));
		GameRegistry.registerTileEntity(TileEntitySinterer.class, new ResourceLocation(Reference.MODID + ":sinterer"));
	}
}
