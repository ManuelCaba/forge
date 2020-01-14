package com.github.ManuelCaba.mytest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ManuelCaba.mytest.config.Config;
import com.github.ManuelCaba.mytest.tabs.MyTestTabWeapons;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Main.MODID)
public final class Main {
	
	public static Main instance;
	public static final String MODID ="mytest"; 
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup MYTESTTABWEAPONS = new MyTestTabWeapons();
	
	//public static final ItemGroup Test
	
	public Main() 
	{
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
		
		/* 106 */       ModLoadingContext.get().registerConfig(Type.COMMON, Config.config);
		/* 107 */       Config.loadConfig(Config.config, FMLPaths.CONFIGDIR.get().resolve("funmod-common.toml").toString());
		/* 108 */       FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		/* 109 */       FMLJavaModLoadingContext.get().getModEventBus().addListener(this::client);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
	}
	
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("Setup method registered");
    }
    
    private void client(final FMLClientSetupEvent event) 
    {
        // do something that can only be done on the client
    	LOGGER.info("clientRegistries method registered");
    }
}
