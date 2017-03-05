package me.creepinson.entities;

import me.creepinson.handlers.SoundHandler;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;



public class EntityCreepino extends EntityMob{

	World world;
	ResourceLocation reLoc;
	public EntityCreepino(World world) {
		
		super(world);
	}
	
	@Override
	public boolean isAIDisabled() {
		
		return false;
	}
@Override
protected SoundEvent getAmbientSound() {
	
	return SoundHandler.creepinoScreech;
}
	@Override
	protected SoundEvent getHurtSound() {
	
		return SoundHandler.creepinoHurt;
	}
@Override
protected SoundEvent getDeathSound() {
	
	
	return SoundHandler.creepinoDeath;
}

}
