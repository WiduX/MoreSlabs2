package widux.moreslabs2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;

public class ItemBlockSlab extends ItemBlock
{
	
	private Block blockPlaced;
	
	public ItemBlockSlab(int ID)
	{
		super(ID);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.blockPlaced = MoreSlabs2.slabs;
	}
	
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta)
    {
        return this.blockPlaced.getBlockTextureFromSideAndMetadata(2, meta);
    }

    public int getMetadata(int meta)
    {
        return meta;
    }
	
}
