package me.creepinson.item;

import me.creepinson.dimensions.CreepolaTeleporter;
import me.creepinson.dimensions.DimensionRegistry_MOD;
import me.creepinson.handlers.BlockHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CreepoMatic extends ModItems{

	public CreepoMatic(String name, CreativeTabs tab) {
		super(name, tab);
		
	}
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack item, World world, EntityPlayer user, EnumHand hand)

	{
if(user instanceof EntityPlayerMP) {
	world.playSound(user, new BlockPos(user.posX, user.posY, user.posZ), SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.MUSIC, 1.0f, itemRand.nextFloat() * 0.4f + 0.8f);
		
	user.getServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) user, DimensionRegistry_MOD.creepolaDimensionID, new CreepolaTeleporter(user.getServer().worldServerForDimension(DimensionRegistry_MOD.creepolaDimensionID)));
	
		 return new ActionResult(EnumActionResult.SUCCESS, new ItemStack(this));
			
    }

return new ActionResult(EnumActionResult.FAIL, new ItemStack(this));

}
	
}
