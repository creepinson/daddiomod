package me.creepinson.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import me.creepinson.dimensions.CreepolaTeleporter;
import me.creepinson.dimensions.DimensionRegistry_MOD;
import me.creepinson.entities.Creepino;
import me.creepinson.handlers.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketPlayer.Rotation;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCreepolaPortal extends BlockBreakable{
	
	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis> create("axis", EnumFacing.Axis.class, new EnumFacing.Axis[]{EnumFacing.Axis.X, EnumFacing.Axis.Z});
	protected static final AxisAlignedBB X = new AxisAlignedBB(0.0d, 0.0d, 0.375d, 1.0d, 1.0d, 0.625d);
	protected static final AxisAlignedBB Y = new AxisAlignedBB(0.375d, 0.0d, 0.0d, 0.625d, 1.0d, 1.0d);
	protected static final AxisAlignedBB Z = new AxisAlignedBB(0.375d, 0.0d, 0.375d, 0.625d, 1.0d, 0.625d);
	
	public BlockCreepolaPortal() {
		super(Material.PORTAL, false);
		this.setUnlocalizedName("CreepolaPortal");
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Z));
		this.setTickRandomly(true);
	
	}
	
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World world, BlockPos pos) {
		return NULL_AABB;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Nullable
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return null;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		
		switch ((EnumFacing.Axis)state.getValue(AXIS)) {
		case X:
			return X;
		case Y:
		default:
			return Y;
		case Z:
			return Z;
		}
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		
		if(worldIn.provider.isSurfaceWorld() && worldIn.getGameRules().getBoolean("doMobSpawning") && rand.nextInt(2000) < worldIn.getDifficulty().getDifficultyId()) {
			int i = pos.getY();
			BlockPos blockpos;
			
			for(blockpos = pos; !worldIn.getBlockState(blockpos).isFullyOpaque() && blockpos.getY() > 0; blockpos = blockpos.down()) {
				;
			}
			
			if(i > 0 && !worldIn.getBlockState(blockpos.up()).isNormalCube()) {
				Entity entity = ItemMonsterPlacer.spawnCreature(worldIn, EntityList.getEntityStringFromClass(Creepino.EntitysheepGunner.class), (double)blockpos.getX() + 0.5d, (double)blockpos.getY() + 1.1f, (double)blockpos.getZ() + 0.5d);
				if(entity != null) {
					entity.timeUntilPortal = entity.getPortalCooldown();
				}
			}
		}
	}
	
	public static int getMetaForAxis(EnumFacing.Axis axis) {
		return axis == EnumFacing.Axis.X ? 1 : (axis == EnumFacing.Axis.Z ? 2 : 0);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return getMetaForAxis((EnumFacing.Axis)state.getValue(AXIS));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AXIS, (meta & 3) == 2 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
	}
	
	public boolean trySpawnPortal(World worldIn, BlockPos pos) {
		BlockCreepolaPortal.Size blockportal$size = new BlockCreepolaPortal.Size(worldIn, pos, EnumFacing.Axis.X);
		
		if(blockportal$size.isValid() && blockportal$size.portalBlockCount == 0) {
			blockportal$size.placePortalBlocks();
			return true;
		}
		else {
			BlockCreepolaPortal.Size blockportal$size1 = new BlockCreepolaPortal.Size(worldIn, pos, EnumFacing.Axis.Z);
			
			if(blockportal$size1.isValid() && blockportal$size1.portalBlockCount == 0) {
				blockportal$size1.placePortalBlocks();
				return true;
			} else {
				return false;
			}
		}
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
		EnumFacing.Axis enumfacing$axis = (EnumFacing.Axis)state.getValue(AXIS);
		
		if(enumfacing$axis == EnumFacing.Axis.X) {
			BlockCreepolaPortal.Size blockportal$size = new BlockCreepolaPortal.Size(worldIn, pos, EnumFacing.Axis.X);
			
			if(!blockportal$size.isValid() || blockportal$size.portalBlockCount < blockportal$size.width * blockportal$size.height) {
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			}
		}else if (enumfacing$axis == EnumFacing.Axis.Z) {
			BlockCreepolaPortal.Size blockportal$size = new BlockCreepolaPortal.Size(worldIn, pos, EnumFacing.Axis.Z);
			
			if(!blockportal$size.isValid() || blockportal$size.portalBlockCount < blockportal$size.width * blockportal$size.height) {
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		pos = pos.offset(side);
		EnumFacing.Axis enumfacing$axis = null;
		
		if(blockState.getBlock() == this) {
			enumfacing$axis = (EnumFacing.Axis)blockState.getValue(AXIS);
			
			if(enumfacing$axis == null) {
				return false;
			}
			
			if(enumfacing$axis == EnumFacing.Axis.Z && side != EnumFacing.EAST && side != EnumFacing.WEST) {
				return false;
			}
			
			if(enumfacing$axis == EnumFacing.Axis.X && side != EnumFacing.SOUTH && side != EnumFacing.NORTH) {
				return false;
			}
		}
		
		boolean flag = blockAccess.getBlockState(pos.west()).getBlock() == this && blockAccess.getBlockState(pos.west(2)).getBlock() != this;
		boolean flag1 = blockAccess.getBlockState(pos.east()).getBlock() == this && blockAccess.getBlockState(pos.east(2)).getBlock() != this;
		boolean flag2 = blockAccess.getBlockState(pos.north()).getBlock() == this && blockAccess.getBlockState(pos.north(2)).getBlock() != this;
		boolean flag3 = blockAccess.getBlockState(pos.south()).getBlock() == this && blockAccess.getBlockState(pos.south(2)).getBlock() != this;
		boolean flag4 = flag || flag1 || enumfacing$axis == EnumFacing.Axis.X;
		boolean flag5 = flag2 || flag3 || enumfacing$axis == EnumFacing.Axis.Z;
		return flag4 && side == EnumFacing.WEST ? true : (flag4 && side == EnumFacing.EAST ? true : (flag5 && side == EnumFacing.NORTH ? true : flag5 && side == EnumFacing.SOUTH));
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 0;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(!entityIn.isRiding() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && entityIn instanceof EntityPlayerMP) {
			EntityPlayerMP thePlayer = (EntityPlayerMP)entityIn;
			if(thePlayer.timeUntilPortal > 0) {
				thePlayer.timeUntilPortal = 10;
			} else if (thePlayer.dimension != DimensionRegistry_MOD.creepolaDimensionID) {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, DimensionRegistry_MOD.creepolaDimensionID, new CreepolaTeleporter(thePlayer.mcServer.worldServerForDimension(DimensionRegistry_MOD.creepolaDimensionID)));
			} else {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, 0, new CreepolaTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		
		if(rand.nextInt(100) == 0) {
			worldIn.playSound((double)pos.getX() + 0.5d, (double)pos.getY() + 0.5d, (double)pos.getZ() + 0.5d, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.MASTER, 0.5f, rand.nextFloat() * 0.4f + 0.8f, false);
		}
		
		for(int i = 0; i < 4; ++i) {
			double d0 = (double)((float)pos.getX() + rand.nextFloat());
			double d1 = (double)((float)pos.getY() + rand.nextFloat());
			double d2 = (double)((float)pos.getZ() + rand.nextFloat());
			double d3 = ((double)rand.nextFloat() - 0.5d) * 0.5d;
			double d4 = ((double)rand.nextFloat() - 0.5d) * 0.5d;
			double d5 = ((double)rand.nextFloat() - 0.5d) * 0.5d;
			int j = rand.nextInt(2) * 2 - 1;
			
			if(worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this) {
				d0 = (double)pos.getX() + 0.5d + 0.25d * (double)j;
				d3 = (double)(rand.nextFloat() * 2.0f * (float)j);
			} else {
				d2 = (double)pos.getZ() + 0.5d + 0.25d * (double)j;
				d5 = (double)(rand.nextFloat() * 2.0f * (float)j);
			}
			
			worldIn.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, d3, d4, d5, new int[0]);
		}
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, net.minecraft.util.Rotation rot) {

		switch(rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			
			switch((EnumFacing.Axis)state.getValue(AXIS)) {
			case X:
				return state.withProperty(AXIS, EnumFacing.Axis.Z);
			case Z:
				return state.withProperty(AXIS, EnumFacing.Axis.X);
			default:
				return state;
			}
		default:
			return state;
		}
	
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {AXIS});
	}
	
	public static class Size
    {
        private final World world;
        private final EnumFacing.Axis axis;
        private final EnumFacing rightDir;
        private final EnumFacing leftDir;
        private int portalBlockCount;
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public Size(World worldIn, BlockPos p_i45694_2_, EnumFacing.Axis p_i45694_3_)
        {
            this.world = worldIn;
            this.axis = p_i45694_3_;

            if (p_i45694_3_ == EnumFacing.Axis.X)
            {
                this.leftDir = EnumFacing.EAST;
                this.rightDir = EnumFacing.WEST;
            }
            else
            {
                this.leftDir = EnumFacing.NORTH;
                this.rightDir = EnumFacing.SOUTH;
            }

            for (BlockPos blockpos = p_i45694_2_; p_i45694_2_.getY() > blockpos.getY() - 21 && p_i45694_2_.getY() > 0 && this.isEmptyBlock(worldIn.getBlockState(p_i45694_2_.down()).getBlock()); p_i45694_2_ = p_i45694_2_.down())
            {
                ;
            }

            int i = this.getDistanceUntilEdge(p_i45694_2_, this.leftDir) - 1;

            if (i >= 0)
            {
                this.bottomLeft = p_i45694_2_.offset(this.leftDir, i);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);

                if (this.width < 2 || this.width > 21)
                {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if (this.bottomLeft != null)
            {
                this.height = this.calculatePortalHeight();
            }
        }

        protected int getDistanceUntilEdge(BlockPos p_180120_1_, EnumFacing p_180120_2_)
        {
            int i;

            for (i = 0; i < 22; ++i)
            {
                BlockPos blockpos = p_180120_1_.offset(p_180120_2_, i);

                if (!this.isEmptyBlock(this.world.getBlockState(blockpos).getBlock()) || this.world.getBlockState(blockpos.down()).getBlock() != Blocks.BOOKSHELF)
                {
                    break;
                }
            }

            Block block = this.world.getBlockState(p_180120_1_.offset(p_180120_2_, i)).getBlock();
            return block == Blocks.BOOKSHELF ? i : 0;
        }

        public int getHeight()
        {
            return this.height;
        }

        public int getWidth()
        {
            return this.width;
        }

        protected int calculatePortalHeight()
        {
            label24:

            for (this.height = 0; this.height < 21; ++this.height)
            {
                for (int i = 0; i < this.width; ++i)
                {
                    BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
                    Block block = this.world.getBlockState(blockpos).getBlock();

                    if (!this.isEmptyBlock(block))
                    {
                        break label24;
                    }

                    if (block == BlockHandler.CreepolaPortal)
                    {
                        ++this.portalBlockCount;
                    }

                    if (i == 0)
                    {
                        block = this.world.getBlockState(blockpos.offset(this.leftDir)).getBlock();

                        if (block != Blocks.BOOKSHELF)
                        {
                            break label24;
                        }
                    }
                    else if (i == this.width - 1)
                    {
                        block = this.world.getBlockState(blockpos.offset(this.rightDir)).getBlock();

                        if (block != Blocks.BOOKSHELF)
                        {
                            break label24;
                        }
                    }
                }
            }

            for (int j = 0; j < this.width; ++j)
            {
                if (this.world.getBlockState(this.bottomLeft.offset(this.rightDir, j).up(this.height)).getBlock() != Blocks.BOOKSHELF)
                {
                    this.height = 0;
                    break;
                }
            }

            if (this.height <= 21 && this.height >= 3)
            {
                return this.height;
            }
            else
            {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        protected boolean isEmptyBlock(Block blockIn)
        {
            return blockIn.getMaterial(blockIn.getDefaultState()) == Material.AIR || blockIn == Blocks.FIRE || blockIn == BlockHandler.CreepolaPortal;
        }

        public boolean isValid()
        {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        public void placePortalBlocks()
        {
            for (int i = 0; i < this.width; ++i)
            {
                BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i);

                for (int j = 0; j < this.height; ++j)
                {
                    this.world.setBlockState(blockpos.up(j), BlockHandler.CreepolaPortal.getDefaultState().withProperty(BlockPortal.AXIS, this.axis), 2);
                }
            }
        }
    }
}