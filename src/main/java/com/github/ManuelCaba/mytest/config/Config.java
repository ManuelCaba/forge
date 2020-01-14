package com.github.ManuelCaba.mytest.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import java.io.File;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder; 
 
public class Config 
{
	private static final Builder builder = new Builder();
    public static final ForgeConfigSpec config;
 
    static 
    {
    	ItemConfig.init(builder);
 
    	config = builder.build();
    }
    
    public static void loadConfig(ForgeConfigSpec config, String path) 
    {
       CommentedFileConfig file = (CommentedFileConfig)CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
       file.load();
       config.setConfig(file);
    }
}