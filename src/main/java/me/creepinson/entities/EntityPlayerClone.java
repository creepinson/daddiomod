package me.creepinson.entities;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityPlayerClone extends EntityLivingBase{
	ResourceLocation reLoc;
	public EntityPlayerClone(World world) {
		super(world);
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnumHandSide getPrimaryHand() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		
		
		 super.writeEntityToNBT(compound);
	}
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		
		super.readEntityFromNBT(compound);


	}




}
