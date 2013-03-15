package widux.moreslabs2;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderSlab implements ISimpleBlockRenderingHandler
{
	
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}

	public boolean renderWorldBlock(IBlockAccess iba, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		
		Tessellator tess = Tessellator.instance;
		tess.setBrightness(block.getMixedBrightnessForBlock(iba, x, y, z));
		tess.setColorOpaque_F(1F, 1F, 1F);
		
		renderer.renderBlockAllFaces(block, x, y, z);
		
		//TileEntitySlab teSlab = (TileEntitySlab) iba.getBlockTileEntity(x, y, z);
		//boolean[] onSide = {true, false, false, false, false, false};
		//double[] bounds = teSlab.getBoundData();
		//Icon[] icons = teSlab.getIcons(0);
		//renderer.setRenderBounds(bounds[0], bounds[1], bounds[2], bounds[3], bounds[4], bounds[5]);
		
        double xModel = x;
        double yModel = (double)((float)y - 0.0625F);
        double zModel = z;
		
		return true;
	}
	
	public boolean shouldRender3DInInventory()
	{
		return false;
	}

	public int getRenderId()
	{
		return MoreSlabs2.renderSlabsID;
	}
	
}
