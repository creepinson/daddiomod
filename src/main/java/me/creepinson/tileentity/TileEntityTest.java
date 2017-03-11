package me.creepinson.tileentity;

import me.creepinson.handlers.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityTest extends TileEntity implements ITickable{
public ItemStack[] items = new ItemStack[9];
private ItemStack anItemStack;
private ItemStackHandler handler;	
private boolean isFormed = false;
	public TileEntityTest() {
		

	}
	@Override
	public void update() {
		
	}
	

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	    {
	        nbt.setBoolean("formed", isFormed);
	        return super.writeToNBT(nbt);
	    }

	    @Override
	    public SPacketUpdateTileEntity getUpdatePacket()
	    {
	        NBTTagCompound nbt = new NBTTagCompound();
	        writeToNBT(nbt);
	        return new SPacketUpdateTileEntity(pos, 0, nbt);
	    }

	    @Override
	    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt)
	    {
	        readFromNBT(pkt.getNbtCompound());
	    }
}