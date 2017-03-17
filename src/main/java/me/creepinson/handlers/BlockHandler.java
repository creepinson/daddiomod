package me.creepinson.handlers;

import me.creepinson.blocks.BlockCreepinoBrick;
import me.creepinson.blocks.BlockCreepolaPortal;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockHandler {
	public static Block BlockCreepinoBrick;
	public static ItemBlock CreepinoBrick;
	public static BlockCreepolaPortal CreepolaPortal;
	
	public static void init(){
	 
		BlockCreepinoBrick = new BlockCreepinoBrick(Material.ROCK, "CreepinoBrick", CreativeTabHandler.tabMP_CREEPOLA, 5F, 15F, 3, "CreepinoBrick");

		GameRegistry.registerBlock(CreepolaPortal = new BlockCreepolaPortal(), CreepolaPortal.getUnlocalizedName().substring(5));

		
		
		CreepinoBrick = (ItemBlock) new ItemBlock(BlockCreepinoBrick);

	   
	    
	}
	 
	 public static void register(){
	
		 GameRegistry.registerWithItem(BlockCreepinoBrick);
		  GameRegistry.register(CreepolaPortal);
		  
		  
	 }
	 
	 public static void registerRenders(){
	 
		 registerRender(BlockCreepinoBrick);

		  registerRender(CreepolaPortal);
	 }
	 
	 public static void registerRender(Block block){
	 
Item item = Item.getItemFromBlock(block);
ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	 
	 }
	 
	 
}
