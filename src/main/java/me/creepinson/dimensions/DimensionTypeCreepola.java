package me.creepinson.dimensions;

import me.creepinson.world.MeepersPlusBiomeRegistry;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DimensionTypeCreepola extends WorldProvider{

	@Override 
	public void createBiomeProvider(){
		
		this.biomeProvider = new BiomeProviderSingle(MeepersPlusBiomeRegistry.creepop);
		this.hasNoSky = false;
		
	}
	
	@Override
	public DimensionType getDimensionType() {
		
		return DimensionRegistry_MOD.CREEPOLA_NORMAL;
	}

	@Override
	public boolean isSurfaceWorld(){
		
		return true;
		
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int par1, int par2){
		
		return true;
		
	}@Override
	public boolean canRespawnHere(){
		
		return false;
		
	}
      @Override
	  @SideOnly(Side.CLIENT)
	    public boolean doesXZShowFog(int x, int z)
	    {
	        return false;
	    }
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float par1, float par2){
		
		return new Vec3d(0.6D, 0.5D, 0.7D);
		
	}
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new CreepolaChunkProvider(worldObj, worldObj.getSeed(), false);

	}
	
}
