package me.creepinson.main;

import me.creepinson.entities.EntityCreepino;
import me.creepinson.entities.ModelCreepino;
import me.creepinson.entities.RenderCreepino;
import me.creepinson.entities.TileEntityTest;
import me.creepinson.entities.TileEntityTestSpecialRender;
import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.GuiHandler;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.handlers.SoundHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
RenderCreepino clone;
	
	@Override
	public void preInit() {
		  super.preInit();
		ItemHandler.registerRenders();
		BlockHandler.registerRenders();
		SoundHandler.registerSounds();
		RenderingRegistry.registerEntityRenderingHandler(EntityCreepino.class, RenderCreepino.die);
		
	}
     @Override
	public void init() {
		  super.init();
			
	        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTest.class, new TileEntityTestSpecialRender());


NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}

	
}
