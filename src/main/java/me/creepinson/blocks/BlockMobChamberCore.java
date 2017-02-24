package me.creepinson.blocks;

import me.creepinson.entities.TileEntityTest;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMobChamberCore extends ModBlocks implements ITileEntityProvider{

	
    public BlockMobChamberCore(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		 
		super(mat, tool, tab, resistance, resistance);
		 this.setUnlocalizedName("MobChamberCore");
	        this.setHardness(2.0f);
	        this.setResistance(6.0f);
	       
	       
	       
	       
	       
		 }

	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTest();
    }

}
