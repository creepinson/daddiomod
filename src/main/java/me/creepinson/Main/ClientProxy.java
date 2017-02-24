package me.creepinson.main;

import me.creepinson.entities.EntityPlayerClone;
import me.creepinson.entities.RenderPlayerClone;
import me.creepinson.entities.TileEntityTest;
import me.creepinson.entities.TileEntityTestSpecialRender;
import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.GuiHandler;
import me.creepinson.handlers.ItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
RenderPlayerClone clone;
	
	@Override
	public void preInit() {
		  super.preInit();
		ItemHandler.registerRenders();
		BlockHandler.registerRenders();
	
	}

	public void init() {
		  super.init();
			RenderingRegistry.registerEntityRenderingHandler(EntityPlayerClone.class,new RenderPlayerClone(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0.5F));
	
	        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTest.class, new TileEntityTestSpecialRender());


NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}

	
}
