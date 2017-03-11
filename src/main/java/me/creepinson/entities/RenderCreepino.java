package me.creepinson.entities;

import org.lwjgl.opengl.GL11;

import me.creepinson.lib.RefStrings;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCreepino extends RenderLiving<EntityCreepino>{
	public static final ResourceLocation textureSkin = new ResourceLocation(RefStrings.MODID + ":" + "textures/entity/ModelCreepino.png");
	protected static ModelCreepino model;
	public static final Factory die = new Factory();
   
	protected static float shadowOpaque = 1.0F;
	public RenderCreepino(RenderManager renderManager, ModelCreepino model, float shadowSize) {
		super(renderManager, new ModelCreepino(), shadowSize);
		this.model = model;
        
}    
	
	@Override
    protected void preRenderCallback(EntityCreepino entity, float partialTickTime)
    {
   	 GL11.glScalef(1.0F,1.0F, 1.0F);
    }

  
   

	



@Override
public void doRender(EntityCreepino entity, double x, double y, double z, float entityYaw, float partialTicks)
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
	protected ResourceLocation getEntityTexture(EntityCreepino entity) {
		// TODO Auto-generated method stub
		return textureSkin;
	}
	
	
	}

