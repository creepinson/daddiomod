package me.creepinson.main;

import me.creepinson.blocks.ModBlocks;
import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.CraftingHandler;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.lib.IProxy;
import me.creepinson.lib.RefStrings;
import me.creepinson.packet.CustomPacket;
import me.creepinson.packet.CustomPacketHandler;
import me.creepinson.tileentity.TileEntityTest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy implements IProxy{
	public static SoundEvent creepinoHurt;
	
	public static SoundEvent creepinoDeath;
		
	public static SoundEvent creepinoScreech;

		public void registerRenderers(Main ins) {
		}
	 @Override
	public void preInit() {
		 ResourceLocation soundID1 = new ResourceLocation(RefStrings.MODID, "creepinoScreech");
		 ResourceLocation soundID2 = new ResourceLocation(RefStrings.MODID, "creepinoHurt");
		 ResourceLocation soundID3 = new ResourceLocation(RefStrings.MODID, "creepinoDeath");
	       
		 creepinoScreech = GameRegistry.register(new SoundEvent(soundID1).setRegistryName(soundID1));
		 creepinoHurt = GameRegistry.register(new SoundEvent(soundID2).setRegistryName(soundID2));
		 creepinoDeath = GameRegistry.register(new SoundEvent(soundID3).setRegistryName(soundID3));
		 
	 
		 BlockHandler.init();
		  BlockHandler.register();
         ModBlocks.init();
		 ItemHandler.init();
		  ItemHandler.register();
		  
	}
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("meepersplus");
	
	@Override
	public void init() {
	
		GameRegistry.registerTileEntity(TileEntityTest.class, RefStrings.MODID + ":"+ "mobchambercore");
		
		INSTANCE.registerMessage(CustomPacketHandler.class, CustomPacket.class, 0, Side.SERVER);
		
		
	}

	@Override
	public void postInit() {
		
	CraftingHandler.init();
		
	}
	
	public static void registerModelBakeryVarients(){

	
}
}