package me.creepinson.main;

import me.creepinson.blocks.ModBlocks;
import me.creepinson.entities.TileEntityTest;
import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.CraftingHandler;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.lib.IProxy;
import me.creepinson.lib.RefStrings;
import me.creepinson.packet.CustomPacket;
import me.creepinson.packet.CustomPacketHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy implements IProxy{
	 public static SoundEvent creepinoScreech;
	 public static SoundEvent creepinoDeath;
	 public static SoundEvent creepinoHurt;



		/**
		 * Register the {@link SoundEvent}s.
		 */
		public static void registerSounds() {
			creepinoHurt = registerSound("creepinoHurt");
			creepinoScreech = registerSound("creepinoScreech");
			creepinoDeath = registerSound("creepinoDeath");
		
		}

		/**
		 * Register a {@link SoundEvent}.
		 *
		 * @param soundName The SoundEvent's name without the testmod3 prefix
		 * @return The SoundEvent
		 */
		private static SoundEvent registerSound(String soundName) {
			final ResourceLocation soundID = new ResourceLocation(RefStrings.MODID, soundName);
			return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
		}
	 @Override
	public void preInit() {
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