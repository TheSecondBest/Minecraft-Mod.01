package tsb.cacticraft;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import tsb.cacticraft.init.ModRecipes;
import tsb.cacticraft.proxy.CommonProxy;
import tsb.cacticraft.util.handlers.RegistryHandler;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class Main 
{
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;

	
	public static final CreativeTabs cactitab = new CactiTab("cactitab");

	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
	{	
		RegistryHandler.preInitRegistries(event);
		RegistryHandler.otherRegistries();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries(event);
		ModRecipes.init();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) 
	{
		RegistryHandler.postInitRegistries(event);
	}
}
