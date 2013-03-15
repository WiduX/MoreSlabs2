package widux.moreslabs2;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	
	@Override
	public void addNames()
	{
		
	}
	
	@Override
	public void addRenderers()
	{
		MoreSlabs2.renderSlabsID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(MoreSlabs2.renderSlabsID, new RenderSlab());
	}
	
}
