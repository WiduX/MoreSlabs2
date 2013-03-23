package widux.moreslabs2;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy
{
	
	@Override
	public void addNames()
	{
		LanguageRegistry.instance().addStringLocalization("itemGroup.MoreSlabs2", "en_US", "MoreSlabs 2");
		//LanguageRegistry.addName(MoreSlabs2.slabs, "Slab");
		LanguageRegistry.addName(MoreSlabs2.slabItem, "SlabItem");
		
		for(int meta = 0; meta < TileEntitySlab.itemNames.length; meta++)
		{
			LanguageRegistry.addName(new ItemStack(MoreSlabs2.slabs, 1, meta), TileEntitySlab.itemNames[meta]);
		}
		
	}
	
	@Override
	public void addRenderers()
	{
		MoreSlabs2.renderSlabsID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(MoreSlabs2.renderSlabsID, new RenderSlab());
		MinecraftForgeClient.registerItemRenderer(MoreSlabs2.slabItem.itemID, new RenderSlabItem());
		
		//TextureMap textures = Minecraft.getMinecraft().renderEngine.field_94154_l;
		//TileEntitySlab.textures[0] = textures.func_94245_a("cloth_1");
	}
	
}
