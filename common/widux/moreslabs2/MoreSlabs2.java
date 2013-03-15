package widux.moreslabs2;

import java.io.File;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import widux.core.ConfigAssist;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod
(
	modid = ModInfo.INTERNAL_NAME,
	name = ModInfo.NAME,
	version = ModInfo.VERSION
)
@NetworkMod
(
	clientSideRequired = true,
	serverSideRequired = false
)
public class MoreSlabs2
{
	
	public static ConfigAssist config;
	
	public static Block slabTable;
	public static Block slabs;
	
	//public static TileEntitySlab teSlabs;
	
	//public static Material slabMaterial = new MaterialSlabs();
	
	public static CreativeTabs slabsTab = new CreativeTabSlabs("MoreSlabs 2");
	
	public static int renderSlabsID;
	
	@Instance(ModInfo.INTERNAL_NAME)
	public static MoreSlabs2 instance;
	
	@SidedProxy
	(
		clientSide = "widux.moreslabs2.ClientProxy",
		serverSide = "widux.moreslabs2.CommonProxy"
	)
	public static CommonProxy common;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		config = new ConfigAssist(ModInfo.NAME, new File(event.getModConfigurationDirectory() + "/WiduX/MoreSlabs2.cfg"));
		config.init();
	}
	
	@Init
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		config.save();
	}
	
}
