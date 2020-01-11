package com.github.ManuelCaba.MyTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;

@Mod(MyTest.MODID)
public final class MyTest {
	
	public static final String MODID ="mytest"; 
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public MyTest() 
	{
		LOGGER.debug("Hello from My Test!");
	}
}
