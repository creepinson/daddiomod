package me.creepinson.entities;

import me.creepinson.lib.RefStrings;
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
	protected static final ResourceLocation textureSkin =  new ResourceLocation(RefStrings.MODID + ":" + "textures/models/clonebase.png");
	
	public RenderPlayerClone(RenderManager renderManager, ModelBiped model, float shadowSize) {
		super(renderManager, model, shadowSize);
		
	
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
		
		return textureSkin;
		
	}
	
	
	
}
