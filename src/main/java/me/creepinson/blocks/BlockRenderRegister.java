package me.creepinson.blocks;

import me.creepinson.entities.TileEntityTest;
import me.creepinson.entities.TileEntityTestSpecialRender;
import me.creepinson.lib.RefStrings;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public final class BlockRenderRegister {

    public static void registerBlockRenderer() {

        reg(ModBlocks.BlockMobChamberCore);

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTest.class, new TileEntityTestSpecialRender());
    }

    //=========================================================================

    public static String modid = RefStrings.MODID;

    public static void reg(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }
}