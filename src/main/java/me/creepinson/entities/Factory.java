package me.creepinson.entities;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class Factory implements IRenderFactory<EntityCreepino> {
	protected static float shadowOpaque = 1.0F;
      @Override
      public Render<? super EntityCreepino> createRenderFor(RenderManager manager) {
          return new RenderCreepino(manager, new ModelCreepino(), shadowOpaque);
      }

  }

