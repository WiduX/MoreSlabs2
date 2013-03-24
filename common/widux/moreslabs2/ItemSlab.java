package widux.moreslabs2;

//import net.minecraft.block.Block;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
//import net.minecraft.entity.Entity;

public class ItemSlab extends Item
{
	
	public ItemSlab(int ID)
	{
		super(ID);
		this.setCreativeTab(MoreSlabs2.slabsTab);
	}
	
	public String getItemDisplayName(ItemStack itemstack)
	{
		return TileEntitySlab.textures[itemstack.getItemDamage()].getName();
	}
	
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset)
    {
		int i1 = world.getBlockId(x, y, z);
		int spawnID = MoreSlabs2.slabs.blockID;
		
        if (i1 == Block.snow.blockID && (world.getBlockMetadata(x, y, z) & 7) < 1)
        {
            side = 1;
        }
        else if (i1 != Block.vine.blockID && i1 != Block.tallGrass.blockID && i1 != Block.deadBush.blockID)
        {
            if (side == 0)
            {
                --y;
            }

            if (side == 1)
            {
                ++y;
            }

            if (side == 2)
            {
                --z;
            }

            if (side == 3)
            {
                ++z;
            }

            if (side == 4)
            {
                --x;
            }

            if (side == 5)
            {
                ++x;
            }
        }

        if (!player.canPlayerEdit(x, y, z, side, item))
        {
            return false;
        }
        else if (item.stackSize == 0)
        {
            return false;
        }
        else
        {
            if (world.canPlaceEntityOnSide(spawnID, x, y, z, false, side, (Entity)null, item))
            {
                Block block = Block.blocksList[spawnID];
                int place = block.onBlockPlaced(world, x, y, z, side, xOffset, yOffset, zOffset, 0);

                if (world.setBlock(x, y, z, spawnID, place, 3))
                {
                    if (world.getBlockId(x, y, z) == spawnID)
                    {
                        Block.blocksList[spawnID].onBlockPlacedBy(world, x, y, z, player, item);
                        Block.blocksList[spawnID].onPostBlockPlaced(world, x, y, z, place);
                        
                        TileEntitySlab slab = (TileEntitySlab) world.getBlockTileEntity(x, y, z);
                        slab.setSlabType(item.getItemDamage());
                    }

                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block.stepSound.getPlaceSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                    --item.stackSize;
                }
            }

            return true;
        }
    }
	
	public Icon getIconFromDamage(int meta)
	{
		return iconIndex;
	}
	
	@Override
    public void updateIcons(IconRegister iconRegister)
    {
        //iconIndex = iconRegister.func_94245_a("cloth_1");
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int i, CreativeTabs tab, List subItems)
	{
		for(int meta = 0; meta < TileEntitySlab.getSlabTypeAmount(); meta++)
		{
			subItems.add(new ItemStack(this, 1, meta));
		}
	}
	
}
