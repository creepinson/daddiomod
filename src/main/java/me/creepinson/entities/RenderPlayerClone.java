package me.creepinson.entities;

import org.lwjgl.opengl.GL11;

import me.creepinson.lib.RefStrings;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

public class RenderPlayerClone extends RenderLivingBase<EntityPlayerClone>{
	public static final ModelResourceLocation textureSkin = new ModelResourceLocation(RefStrings.MODID, "textures/models/clonebase.png");
	protected ModelBiped model;
	public RenderPlayerClone(RenderManager renderManager, ModelBiped model, float shadowSize) {
		super(renderManager, model, shadowSize);
		this.model = model;

}

    protected void preRenderCallbackClone(EntityLivingBase entity, float f)
    {
        preRenderCallbackClone((EntityPlayerClone) entity, f);
    }
  
    protected void preRenderCallbackClone(EntityPlayerClone entity, float f)
    {
        // some people do some G11 transformations or blends here, like you can do
        // GL11.glScalef(2F, 2F, 2F); to scale up the entity
        // which is used for Slime entities.  I suggest having the entity cast to
        // your custom type to make it easier to access fields from your 
        // custom entity, eg. GL11.glScalef(entity.scaleFactor, entity.scaleFactor, 
        // entity.scaleFactor); 
    }

	

public void getPlayerSkin(AbstractClientPlayer player)
{
	String skin = player.getLocationSkin().toString();
	
	
	
}

@Override
public void doRender(EntityPlayerClone entity, double x, double y, double z, float entityYaw, float partialTicks)
{
	GlStateManager.pushMatrix();
	{
		
        bindTexture(textureSkin);
		GlStateManager.translate(x, y + 2.05, z);

		//Y-rotation
		GlStateManager.rotate(180F, 1, 0, 0);
		
		/*//X-rotation (facing north)
		GlStateManager.rotate(180F, 0F, 1F, 0F);*/
		
		GlStateManager.scale(1.0F, 1.0F, 1.0F);

		
		
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	}
	GlStateManager.popMatrix();
}
	@Override
	protected ResourceLocation getEntityTexture(EntityPlayerClone entity) {
		// TODO Auto-generated method stub
		return textureSkin;
	}
	
}
