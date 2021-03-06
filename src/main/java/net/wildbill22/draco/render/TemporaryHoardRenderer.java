package net.wildbill22.draco.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

// import java.util.Calendar;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.wildbill22.draco.blocks.TemporaryHoard;
import net.wildbill22.draco.lib.REFERENCE;
import net.wildbill22.draco.tile_entity.TileEntityTemporaryHoard;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * 
 * @author WILLIAM
*/ 
@SideOnly(Side.CLIENT)
public class TemporaryHoardRenderer extends TileEntitySpecialRenderer {

    private static final ResourceLocation doubleChestTexture = new ResourceLocation(REFERENCE.MODID, "textures/blocks/treasurechest_double.png");
    private static final ResourceLocation singleChestTexture = new ResourceLocation(REFERENCE.MODID, "textures/blocks/temporaryHoard.png");
    private ModelChest singleChest = new ModelChest();
    private ModelChest doubleChest = new ModelLargeChest();
//    private boolean field_147509_j; // Christmas chest
//    private static final String __OBFID = "CL_00000965";

    public TemporaryHoardRenderer()
    {
//        Calendar calendar = Calendar.getInstance();
//
//        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26)
//        {
//            this.field_147509_j = true;
//        }
    }

    public void renderTileEntityAt(TileEntityTemporaryHoard chestEntity, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        int i;

        if (!chestEntity.hasWorldObj())
        {
            i = 0;
        }
        else
        {
            Block block = chestEntity.getBlockType();
            i = chestEntity.getBlockMetadata();

            if (block instanceof TemporaryHoard && i == 0)
            {
                try
                {
                ((TemporaryHoard)block).func_149954_e(chestEntity.getWorldObj(), chestEntity.xCoord, chestEntity.yCoord, chestEntity.zCoord);
                }
                catch (ClassCastException e)
                {
                    FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest", chestEntity.xCoord, chestEntity.yCoord, chestEntity.zCoord);
                }
                i = chestEntity.getBlockMetadata();
            }

            chestEntity.checkForAdjacentChests();
        }

        if (chestEntity.adjacentChestZNeg == null && chestEntity.adjacentChestXNeg == null)
        {
            ModelChest modelchest;

            if (chestEntity.adjacentChestXPos == null && chestEntity.adjacentChestZPos == null)
            {
                modelchest = this.singleChest;
                this.bindTexture(singleChestTexture);
            }
            else
            {
                modelchest = this.doubleChest;
                this.bindTexture(doubleChestTexture);
            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float)p_147500_2_, (float)p_147500_4_ + 1.0F, (float)p_147500_6_ + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short short1 = 0;

            if (i == 2)
            {
                short1 = 180;
            }

            if (i == 3)
            {
                short1 = 0;
            }

            if (i == 4)
            {
                short1 = 90;
            }

            if (i == 5)
            {
                short1 = -90;
            }

            if (i == 2 && chestEntity.adjacentChestXPos != null)
            {
                GL11.glTranslatef(1.0F, 0.0F, 0.0F);
            }

            if (i == 5 && chestEntity.adjacentChestZPos != null)
            {
                GL11.glTranslatef(0.0F, 0.0F, -1.0F);
            }

            GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = chestEntity.prevLidAngle + (chestEntity.lidAngle - chestEntity.prevLidAngle) * p_147500_8_;
            float f2;

            if (chestEntity.adjacentChestZNeg != null)
            {
                f2 = chestEntity.adjacentChestZNeg.prevLidAngle + (chestEntity.adjacentChestZNeg.lidAngle - chestEntity.adjacentChestZNeg.prevLidAngle) * p_147500_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            if (chestEntity.adjacentChestXNeg != null)
            {
                f2 = chestEntity.adjacentChestXNeg.prevLidAngle + (chestEntity.adjacentChestXNeg.lidAngle - chestEntity.adjacentChestXNeg.prevLidAngle) * p_147500_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            modelchest.chestLid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
            modelchest.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        this.renderTileEntityAt((TileEntityTemporaryHoard)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
    }
}