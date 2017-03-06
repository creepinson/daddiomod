package me.creepinson.entities;

import me.creepinson.handlers.SoundHandler;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOcelotAttack;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.player.EntityPlayer;
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

@Override
protected void initEntityAI() {
    this.tasks.addTask(0, new EntityAISwimming(this));
 this.tasks.addTask(1, new EntityAIWander(this, 0.5D));
    this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    this.tasks.addTask(3, new EntityAILeapAtTarget(this, 2));
    this.targetTasks.addTask(0, new EntityAIOcelotAttack(this));
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, EntityPlayer.class));
}

}
