package me.creepinson.world;

import me.creepinson.handlers.ConfigHandler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class MeepersPlusBiomeRegistry {

	
	
	
	public static void mainRegistry(){
		
		
		
	}
	
	public static Biome creepop;
	
	public static final int creepopBiomeID = ConfigHandler.creepopBiomeID;
	
	
	
	
	public static void initBiomes(){
		
		creepop = new BiomeCreepop(new BiomeProperties("Creepop").setRainfall(0.0f).setRainDisabled().setWaterColor(52326).setBaseHeight(0.8f).setHeightVariation(2.0f));
		Biome.registerBiome(creepopBiomeID, "Creepop", creepop);
		
	}
	
	public static void registerBiomes(){

		BiomeDictionary.registerBiomeType(creepop, Type.COLD);
        BiomeManager.addSpawnBiome(creepop);
	}
	
}
