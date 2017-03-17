package me.creepinson.handlers;

import me.creepinson.handlers.EnumHandler.SyringeTypes;
import me.creepinson.item.CreepoMatic;
import me.creepinson.item.DaddioEssence;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {
	public static Item CreepoMatic;

	public static Item DaddioEssence;
	public static void init(){
		CreepoMatic = new CreepoMatic("CreepoMatic", CreativeTabHandler.tabMP_CREEPOLA).setUnlocalizedName("daddiomod:CreepoMatic");
		DaddioEssence = new DaddioEssence("DaddioEssence", CreativeTabs.MATERIALS);
	 }
	 
	 public static void register(){
	  
		 
		 GameRegistry.register(CreepoMatic);
		 GameRegistry.register(DaddioEssence);
	 
	 }
	 
	 public static void registerRenders(){
     
      registerRender(CreepoMatic);
      registerRender(DaddioEssence);
	 }
	 
	 public static void registerRender(Item item, int meta, String fileName){
			
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName().toString() + "_" + EnumHandler.SyringeTypes.values()[meta].getName(), "inventory"));

	 }

	 
	 public static void registerRender(Item item){
			
		 ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	 }
}
