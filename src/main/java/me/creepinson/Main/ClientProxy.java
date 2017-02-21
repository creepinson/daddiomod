package me.creepinson.Main;

import me.creepinson.entities.EntityPlayerClone;
import me.creepinson.entities.RenderPlayerClone;
import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.GuiHandler;
import me.creepinson.handlers.ItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;

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
			
NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}

	
}
