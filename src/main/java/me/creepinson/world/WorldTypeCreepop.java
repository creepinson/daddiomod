package me.creepinson.world;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeCreepop extends WorldType{

	public WorldTypeCreepop(String name) {
		super(name);
		
		
	}
	
	
	public GenLayer getBiomeLayer(long worldSeed, net.minecraft.world.gen.layer.GenLayer parentLayer, String chunkProviderSettingsJson)
    {
		
        GenLayer ret = new CreepopGenLayerBiome(200L, parentLayer, this, chunkProviderSettingsJson);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
	
	
	
}
