package me.creepinson.handlers;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

public class ConfigHandler {

	public static Configuration config;
		
	//Biomes
	
	public static int creepopBiomeID;
	public static boolean biomeInOverworld;
	
	//Dimensions
	public static int creepolaDimensionID = 40;
	
	public static void init(File file){
		
		config = new Configuration(file);
		
		
	}
	
 public static void syncConfig(){
	 
	 String category;
	 category = "Biomes";
	 config.addCustomCategoryComment(category, "(DON'T MESS WITH UNLESS YOU NEED TO!!) Biome Settings");
	
	 creepopBiomeID = config.getInt("creepopBiomeID", category, 40, 40, 126, "The biome ID of the Creepop Biome.");
	biomeInOverworld = config.getBoolean("biomeInOverworld",  category, true, "Wether or not the Biome from this mod is spawn in the Overworld.") ;
 
	String category2 = "Dimensions";
	config.addCustomCategoryComment(category2, "(DON'T MESS WITH UNLESS YOU NEED TO!!) Dimension Settings");
	
	creepolaDimensionID = config.getInt("creepolaBiomeID", category2, 42, 40, 126, "The biome ID of the Creepop Biome.");
	
	
	config.save();
	 
 }
	
	
}
