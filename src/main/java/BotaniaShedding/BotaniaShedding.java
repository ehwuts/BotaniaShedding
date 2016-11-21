package botaniashedding;

import botaniashedding.SheddingHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "botaniashedding", name="BotaniaShedding", version = "1.0", dependencies = "after:Botania")
public class BotaniaShedding
{	
	public static Configuration config;

	public void saveConfig() {
		if(config.hasChanged())
			config.save();	
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		saveConfig();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new SheddingHandler());
	}
	@EventHandler
	
	public void postInit(FMLPostInitializationEvent event) {
		SheddingHandler.loadFromConfig(config);
		saveConfig();
	}
}