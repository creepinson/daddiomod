package me.creepinson.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import me.creepinson.main.Main;
import me.creepinson.handlers.GuiHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockCreepinoBrick extends ModBlocks 

{
 
	public BlockCreepinoBrick(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		 
		super(mat, tool, tab, resistance, resistance);
		 this.setUnlocalizedName("CreepinoBrick");
	        this.setHardness(2.0f);
	        this.setResistance(6.0f);
	       
	       
	       
	       
	       
		 }

	
	
			 
	 
	 
					

	 



	



}





