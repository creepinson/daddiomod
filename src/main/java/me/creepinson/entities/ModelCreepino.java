package me.creepinson.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * Model for EntityCreepino by Creepinson
 * ---- Made with Qubble ----
 */
@SideOnly(Side.CLIENT)
public class ModelCreepino extends ModelBase {
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer Leg;
    public ModelRenderer ArmR;
    public ModelRenderer ShoulderR;
    public ModelRenderer ArmL;
    public ModelRenderer ShoulderL;

    public ModelCreepino() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.Head = new ModelRenderer(this, 0, 50);
        this.Head.setRotationPoint(-10.0F, -30.0F, 0.0F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(-6.5F, -20.0F, 1.5F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 10, 24, 13);
        this.Leg = new ModelRenderer(this, 0, 0);
        this.Leg.setRotationPoint(-4.0F, 4.0F, 5.5F);
        this.Leg.addBox(0.0F, 0.0F, 0.0F, 5, 22, 5);
        this.ArmR = new ModelRenderer(this, 0, 0);
        this.ArmR.setRotationPoint(-4.0F, -6.0F, 14.5F);
        this.ArmR.addBox(0.0F, 0.0F, 0.0F, 5, 22, 5);
        this.setRotationAngles(this.ArmR, 0.21223203437934937F, 0.0F, -0.7641051252178287F);
        this.ShoulderR = new ModelRenderer(this, 0, 50);
        this.ShoulderR.setRotationPoint(-5.9F, -10.0F, 14.0F);
        this.ShoulderR.addBox(0.0F, 0.0F, 0.0F, 6, 5, 7);
        this.ArmL = new ModelRenderer(this, 0, 0);
        this.ArmL.setRotationPoint(-4.0F, -6.0F, -5.0F);
        this.ArmL.addBox(0.0F, 0.0F, 0.0F, 5, 22, 5);
        this.setRotationAngles(this.ArmL, 0.0F, 0.08482300397719036F, -0.67928211291826F);
        this.ShoulderL = new ModelRenderer(this, 0, 50);
        this.ShoulderL.setRotationPoint(-5.9F, -10.0F, -5.0F);
        this.ShoulderL.addBox(0.0F, 0.0F, 0.0F, 6, 5, 7);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale)
    {
        this.Head.render(scale);
        this.Body.render(scale);
        this.Leg.render(scale);
        this.ArmR.render(scale);
        this.ShoulderR.render(scale);
        this.ArmL.render(scale);
        this.ShoulderL.render(scale);
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
