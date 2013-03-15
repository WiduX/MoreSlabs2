package widux.moreslabs2;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSlabs extends BlockContainer
{
	
	public BlockSlabs(int ID, boolean glows)
	{
		super(ID, Material.ground);
		this.setCreativeTab(MoreSlabs2.slabsTab);
		
		if(glows)
		{
			this.setLightValue(1F);
		}
	}
	
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntitySlab();
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public int getRenderType()
	{
		return MoreSlabs2.renderSlabsID;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public int idDropped(int meta, Random random, int i)
	{
		return 0;
	}
	
	public int quantityDropped(Random random)
	{
		return 0;
	}
	
}
