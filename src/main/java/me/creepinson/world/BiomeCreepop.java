package me.creepinson.world;

import me.creepinson.entities.Creepino;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeCreepop extends Biome {

	public BiomeCreepop(BiomeProperties properties) {
		super(properties);
		
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.RED_NETHER_BRICK.getDefaultState();
	
		this.theBiomeDecorator.treesPerChunk = 2;
		this.theBiomeDecorator.generateLakes = true;
		this.theBiomeDecorator.grassPerChunk = 20;
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 8, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(Creepino.EntitysheepGunner.class, 5, 2, 2));
		
	}
	

}
