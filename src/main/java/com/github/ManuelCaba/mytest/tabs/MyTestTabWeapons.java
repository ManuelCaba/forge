package com.github.ManuelCaba.mytest.tabs;

import com.github.ManuelCaba.mytest.lists.ItemList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MyTestTabWeapons extends ItemGroup 
{
	public MyTestTabWeapons()
	{
		super("mytesttabweapons");
	}

	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.mjlnir);
	}
}
