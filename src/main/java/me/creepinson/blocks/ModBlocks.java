package me.creepinson.blocks;

import me.creepinson.entities.TileEntityTest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.tools.nsc.backend.icode.BasicBlocks.BasicBlock;

public class ModBlocks extends Block{

	public static  TileEntityTest tileEntityTest;
	public static Block BlockMobChamberCore;
	public ModBlocks(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		  super(mat);
		  setUnlocalizedName(name);
		  setRegistryName(name);
		  setCreativeTab(tab);
		  setHardness(hardness);
		  setResistance(resistance);
		  setHarvestLevel(tool, harvest);
		 }
		 
		 public ModBlocks(Material mat, String name, CreativeTabs tab, float hardness, float resistance) {
		  super(mat);
		  setUnlocalizedName(name);
		  setRegistryName(name);
		  setCreativeTab(tab);
		  setHardness(hardness);
		  setResistance(resistance);
		 }
		 public static final void init() {
		   
		    }
}
