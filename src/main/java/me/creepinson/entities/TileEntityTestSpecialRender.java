package me.creepinson.entities;

import me.creepinson.lib.RefStrings;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileEntityTestSpecialRender extends TileEntitySpecialRenderer<TileEntityTest>{
	public static String modid = RefStrings.MODID;
	@Override
	public void renderTileEntityAt(TileEntityTest te, double x, double y, double z, float partialTick, int destroyStage) {

		
		  GlStateManager.pushMatrix();
		    GlStateManager.translate(x, y, z);

		  GlStateManager.scale(5,5,5);

		    GlStateManager.popMatrix();
	}
	
	
	
	
	
	
}
