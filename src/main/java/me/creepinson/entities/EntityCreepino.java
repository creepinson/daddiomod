package me.creepinson.entities;

import me.creepinson.main.CommonProxy;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
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
	
	return CommonProxy.creepinoScreech;
}
	@Override
	protected SoundEvent getHurtSound() {
	
		return CommonProxy.creepinoHurt;
	}
	
@Override
protected SoundEvent getDeathSound() {
	
	
	return CommonProxy.creepinoDeath;
}




public boolean attackEntityAsMob(Entity par1Entity)
{
    this.setLastAttacker(this);
    return false;
}
@Override
protected void initEntityAI() {
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[] {EntityCreepino.class}));
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
}

}
