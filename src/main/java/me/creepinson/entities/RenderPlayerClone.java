package me.creepinson.entities;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

public class RenderPlayerClone extends RenderBiped {
	protected ResourceLocation textureSkin;
	public RenderPlayerClone(RenderManager renderManagerIn, ModelBiped modelBipedIn, float shadowSizeIn) {
		super(renderManagerIn, modelBipedIn, shadowSizeIn);
		
	
	}


    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f)
    {
        preRenderCallbackSerpent((EntityPlayerClone) entity, f);
    }
  
    protected void preRenderCallbackSerpent(EntityPlayerClone entity, float f)
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
	protected ResourceLocation getEntityTexture(Entity entity) {
		EntityPlayerClone eyb = (EntityPlayerClone) entity;
		return eyb.reLoc;
		
	}
	
	
	
}
