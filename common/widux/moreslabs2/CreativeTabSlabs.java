package widux.moreslabs2;

import net.minecraft.block.Block;
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
		//return new ItemStack(MoreSlabs2.slabs, 1, 0);
		return new ItemStack(Block.dirt, 1);
	}
	
}
