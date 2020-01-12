package com.github.ManuelCaba.MyTest;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lists.ThorsHummerItem;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MyTest.MODID)
public final class MyTest {
	
	public static MyTest instance;
	public static final String MODID ="mytest"; 
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	//public static final ItemGroup Test
	
	public MyTest() 
	{
		instance = this;
		
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
	}
	
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("Setup method registered");
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        // do something that can only be done on the client
    	LOGGER.info("clientRegistries method registered");
    }
    
    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("mytest", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents 
    {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            // register a new item here
        	event.getRegistry().registerAll
        	(
                ThorsHummerItem.thors_hummer = new Item(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("thors_hummer"))
        	);
        	
            LOGGER.info("Item registered");
        }
    }
    
    private static ResourceLocation location(String name)
    {
    	return new ResourceLocation(MODID, name);
    }
    
    
}
