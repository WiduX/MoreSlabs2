package widux.moreslabs2;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{
	
	public void addComponents()
	{
		MoreSlabs2.slabs = new BlockSlabs(MoreSlabs2.config.getBlockID(1000, "Slabs Block", null), false).setUnlocalizedName("WiduXSlabs");
		MoreSlabs2.slabItem = new ItemSlab(MoreSlabs2.config.getItemID(11000, "Slab Item", null)).setUnlocalizedName("WiduXSlabsItem");
	}
	
	public void registerBlocks()
	{
		GameRegistry.registerBlock(MoreSlabs2.slabs, ItemBlockSlab.class, "WiduXSlabs");
		GameRegistry.registerTileEntity(TileEntitySlab.class, "WiduXSlabTE");
	}
	
	public void addNames()
	{
		
	}
	
	public void addRecipes()
	{
		
	}
	
	public void addRenderers()
	{
		
	}
	
}
