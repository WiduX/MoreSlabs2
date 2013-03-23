package widux.moreslabs2;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderSlab implements ISimpleBlockRenderingHandler
{
	
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		renderer.setRenderBounds(0D, 0D, 0D, 1D, 0.5D, 1D);
		block.setBlockBoundsForItemRender();
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addTranslation(0.0F, 0.0F, 0.0F);
        renderer.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, metadata));
        tessellator.addTranslation(0.0F, 0.0F, 0.0F);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addTranslation(0.0F, 0.0F, 0.0F);
        renderer.renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, metadata));
        tessellator.addTranslation(0.0F, 0.0F, 0.0F);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        tessellator.addTranslation(0.0F, 0.0F, 0.0F);
        renderer.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, metadata));
        tessellator.addTranslation(0.0F, 0.0F, 0.0F);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        tessellator.addTranslation(0.0F, 0.0F, 0.0F);
        renderer.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, metadata));
        tessellator.addTranslation(0.0F, 0.0F, 0.0F);
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	public boolean renderWorldBlock(IBlockAccess iba, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		
		Tessellator tess = Tessellator.instance;
		tess.setBrightness(block.getMixedBrightnessForBlock(iba, x, y, z));
		tess.setColorOpaque_F(1F, 1F, 1F);
		
		//TileEntitySlab teSlab = (TileEntitySlab) iba.getBlockTileEntity(x, y, z);
		//Icon[] icons = new Icon[6];
		//int[] slabData = new int[6];
		
		/*for(int face = 0; face < 6; face++)
		{
			//icons[face] = teSlab.getIconFromData(slabData[face]);
			//renderer.setOverrideBlockTexture(icons[face]);
			block.setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
		}*/
		
		block.setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
		renderer.renderStandardBlock(block, x, y, z);
		//renderer.renderBlockAllFaces(block, x, y, z);
		
		//TileEntitySlab teSlab = (TileEntitySlab) iba.getBlockTileEntity(x, y, z);
		//boolean[] onSide = {true, false, false, false, false, false};
		//double[] bounds = teSlab.getBoundData();
		//Icon[] icons = teSlab.getIcons(0);
		//renderer.setRenderBounds(bounds[0], bounds[1], bounds[2], bounds[3], bounds[4], bounds[5]);
		
        //double xModel = x;
        //double yModel = (double)((float)y - 0.0625F);
        //double zModel = z;
		
		return true;
	}
	
	public boolean shouldRender3DInInventory()
	{
		return true;
	}

	public int getRenderId()
	{
		return MoreSlabs2.renderSlabsID;
	}
	
}
