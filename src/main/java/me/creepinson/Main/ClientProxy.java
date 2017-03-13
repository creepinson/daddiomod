package me.creepinson.main;


import me.creepinson.entities.ModelCreepino;
import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.GuiHandler;
import me.creepinson.handlers.ItemHandler;

import me.creepinson.tileentity.TileEntityTest;
import me.creepinson.tileentity.TileEntityTestSpecialRender;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {

@Override
public void registerRenderers(Main ins) {
	ins.mcreator_0.registerRenderers();
	ins.mcreator_1.registerRenderers();

}
	@Override
	public void preInit() {
		  super.preInit();
		ItemHandler.registerRenders();
		BlockHandler.registerRenders();
		
	
		
	}
     @Override
	public void init() {
		  super.init();
			
	        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTest.class, new TileEntityTestSpecialRender());


NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}

	
}
