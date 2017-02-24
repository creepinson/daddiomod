package me.creepinson.entities;

import org.lwjgl.opengl.GL11;

import me.creepinson.lib.RefStrings;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTestSpecialRender extends TileEntitySpecialRenderer{
	public static String modid = RefStrings.MODID;
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTick, int destroyStage) {

		
		GL11.glPushMatrix();
		

GL11.glScalef(5,5,5);

GL11.glPopMatrix();
	}
	
	
	
	
	
	
}
