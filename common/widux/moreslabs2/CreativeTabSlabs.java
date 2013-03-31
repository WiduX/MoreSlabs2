package widux.moreslabs2;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabSlabs extends CreativeTabs
{
	
	public CreativeTabSlabs(String name)
	{
		super(name);
	}
	
	public ItemStack getIconItemStack()
	{
		return new ItemStack(MoreSlabs2.slabItem, 1, 14);
	}
	
}
