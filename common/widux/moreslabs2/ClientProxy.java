package widux.moreslabs2;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy
{
	
	@Override
	public void addNames()
	{
		LanguageRegistry.instance().addStringLocalization("itemGroup.MoreSlabs2", "en_US", "MoreSlabs 2");
		
	}
	
	@Override
	public void addRenderers()
	{
		MoreSlabs2.renderSlabsID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(MoreSlabs2.renderSlabsID, new RenderSlab());
		MinecraftForgeClient.registerItemRenderer(MoreSlabs2.slabItem.itemID, new RenderSlabItem());
	}
	
}
