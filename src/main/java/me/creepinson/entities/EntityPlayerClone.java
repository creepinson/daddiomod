package me.creepinson.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

public class EntityPlayerClone extends EntityLivingBase{

	public EntityPlayerClone(World worldIn) {
		super(worldIn);

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
	public static ResourceLocation getLocationSkin(String username)
    {
        return new ResourceLocation("skins/" + StringUtils.stripControlCodes(username));
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
