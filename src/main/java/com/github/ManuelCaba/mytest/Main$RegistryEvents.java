package com.github.ManuelCaba.mytest;

import com.github.ManuelCaba.mytest.items.unique_items.MjlnirItem;
import com.github.ManuelCaba.mytest.lists.ItemList;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class Main$RegistryEvents 
{
	
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents 
    {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            // register a new item here
        	event.getRegistry().registerAll
        	(
                //ItemList.mjlnir = new Item(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("mjlnir")),
        		ItemList.mjlnir = (Item) (new MjlnirItem((new Properties()).group(Main.MYTESTTABWEAPONS).defaultMaxDamage(75000))).setRegistryName(new ResourceLocation("mytest", "mjlnir"))
        	);
        }
    }

}
