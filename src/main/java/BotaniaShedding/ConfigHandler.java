/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jan 13, 2014, 9:01:32 PM (GMT)]
 */
package vazkii.botania.common.core.handler;

import botaniashedding.SheddingHandler;

import net.minecraftforge.common.config.Configuration;

public final class ConfigHandler {

	public static Configuration config;
	
	public static void loadConfig(File configFile) {
		config = new Configuration(configFile);

		config.load();
		if(config.hasChanged())
			config.save();
	}

	public static void loadPostInit() {
		SheddingHandler.loadFromConfig(config);

		if(config.hasChanged())
			config.save();
	}
}
