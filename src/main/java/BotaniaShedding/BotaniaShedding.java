package botaniashedding;

import botaniashedding.SheddingHandler;
import botaniashedding.ConfigHandler;

import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "botaniashedding", name="BotaniaShedding", version = "1.0", dependencies = "after:Botania")
public class BotaniaShedding
{	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.loadConfig(event.getSuggestedConfigurationFile());
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new SheddingHandler());
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ConfigHandler.loadPostInit();
	}
}