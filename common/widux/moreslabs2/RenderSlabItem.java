package widux.moreslabs2;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.client.IItemRenderer;

public class RenderSlabItem implements IItemRenderer
{

	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case ENTITY:
			return true;
		case EQUIPPED:
			return true;
		case INVENTORY:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch(type)
		{
		case ENTITY:
			doSlabRender((RenderBlocks) data[0], item, -0.5F, -0.5F, -0.5F);
			break;
		case EQUIPPED:
			doSlabRender((RenderBlocks) data[0], item, -0.4F, 0.5F, 0.35F);
			break;
		case INVENTORY:
			doSlabRender((RenderBlocks) data[0], item, -0.5F, -0.5F, -0.5F);
			break;
		default:
			break;
		}
	}
	
	private void doSlabRender(RenderBlocks render, ItemStack item, float translateX, float translateY, float translateZ)
	{
		Tessellator tessellator = Tessellator.instance;

		Block block = MoreSlabs2.slabs;
		//int slabType;
		Icon[] textures = new Icon[6];

		for(int side = 0; side < 6; side++)
		{
			textures[side] = block.getBlockTextureFromSideAndMetadata(side, 0);
		}
		
		// Magical code! Switches the texture currently used.
		Minecraft.getMinecraft().renderEngine.func_98187_b("/terrain.png");
		
		block.setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
		block.setBlockBoundsForItemRender();
		render.setRenderBoundsFromBlock(block);

		GL11.glTranslatef(translateX, translateY, translateZ);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		render.renderBottomFace(block, 0.0D, 0.0D, 0.0D, textures[0]);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		render.renderTopFace(block, 0.0D, 0.0D, 0.0D, textures[1]);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		render.renderEastFace(block, 0.0D, 0.0D, 0.0D, textures[2]);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		render.renderWestFace(block, 0.0D, 0.0D, 0.0D, textures[3]);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		render.renderNorthFace(block, 0.0D, 0.0D, 0.0D, textures[4]);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		render.renderSouthFace(block, 0.0D, 0.0D, 0.0D, textures[5]);
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		block.setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
	}
	
}
