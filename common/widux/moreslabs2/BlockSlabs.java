package widux.moreslabs2;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSlabs extends BlockContainer
{
	
	Icon[][] icons; // [meta][side]
	
	public BlockSlabs(int ID, boolean glows)
	{
		super(ID, Material.ground);
		//this.setCreativeTab(MoreSlabs2.slabsTab);
		
		if(glows)
		{
			this.setLightValue(1F);
		}
	}
	
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntitySlab();
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.icons = new Icon[TileEntitySlab.getSlabTypeAmount()][6];

        for (int meta = 0; meta < this.icons.length; meta++)
        {
        	for(int side = 0; side < 6; side++)
        	{
        		this.icons[meta][side] = iconRegister.registerIcon(TileEntitySlab.getTextureName(meta, side));
        	}
        }
    }
	
    public Icon getBlockTexture(IBlockAccess iba, int x, int y, int z, int blockSide)
    {
    	TileEntitySlab teSlab = (TileEntitySlab) iba.getBlockTileEntity(x, y, z);
    	return this.icons[teSlab.getSlabType(blockSide)][blockSide];
    }
	
    public Icon getBlockTextureFromSideAndMetadata(int side, int meta)
    {
    	return this.icons[meta][side];
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
	
    /*@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int meta = 0; meta < TileEntitySlab.getSlabTypeAmount(); meta++)
    	{
    		subItems.add(new ItemStack(this, 1, meta));
    	}
    }*/
	
}
