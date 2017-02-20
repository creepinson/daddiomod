package me.creepinson.entities;

import org.lwjgl.opengl.GL11;

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

public class RenderPlayerClone extends RenderBiped<EntityPlayerClone>{
	protected static final ResourceLocation textureSkin =  new ResourceLocation(RefStrings.MODID + ":" + "textures/models/clonebase.png");
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
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return textureSkin;
		
	}
	@Override
	public void doRenderEntity(Entity entity, double x, double y, double z, float yaw, float partialTick) {
	// again, if you need some information from your custom entity class, you can cast to your
	// custom class, either passing off to another method, or just doing it here
	// in this example, it is not necessary

	// if you are going to do any openGL matrix transformations, be sure to always Push and Pop
	GL11.glPushMatrix();

	// bind your texture:
	bindTexture(textureSkin);

	// do whatever transformations you need, then render

	// typically you will at least want to translate for x/y/z position:
	GL11.glTranslated(x, y, z);

	// if you are using a model, you can do so like this:
	model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

	// note all the values are 0 except the final argument, which is scale
	// vanilla Minecraft almost excusively uses 0.0625F, but you can change it to whatever works

	GL11.glPopMatrix();
	}
	
}
