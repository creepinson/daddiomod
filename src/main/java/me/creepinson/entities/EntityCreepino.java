package me.creepinson.entities;

import io.netty.buffer.ByteBuf;
import me.creepinson.main.CommonProxy;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;



public class EntityCreepino extends EntityMob{

	World world;
	ResourceLocation reLoc;
	public EntityCreepino(World world) {
		
		super(world);
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

}
