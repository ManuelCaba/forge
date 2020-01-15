package com.github.ManuelCaba.mytest.config;

import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;

public class ItemConfig 
{
	public static DoubleValue mjlnirbasedamage;
	
	public static void init(Builder common)
	{
		common.comment("Item Config");
		
		mjlnirbasedamage = common.comment("Attack damage of the Mjlnir.").defineInRange("item.mjlnirbasedamage", 100.0D, 0.0D, 1000.0D);
	}
	
}
