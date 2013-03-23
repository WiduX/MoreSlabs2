package widux.moreslabs2;

//import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
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
	
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset)
    {
        /*int currentBlockID = world.getBlockId(x, y, z);

        if (currentBlockID == Block.snow.blockID && (world.getBlockMetadata(x, y, z) & 7) < 1)
        {
            side = 1;
        }
        else if (currentBlockID != Block.vine.blockID && currentBlockID != Block.tallGrass.blockID && currentBlockID != Block.deadBush.blockID)
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
        {*/
            if (world.getBlockTileEntity(x, y, z) != null && world.getBlockTileEntity(x, y, z) instanceof TileEntitySlab)
            {
            	TileEntitySlab teSlab = (TileEntitySlab) world.getBlockTileEntity(x, y, z);
            	
            	teSlab.setSlabType(teSlab.getSlabType() + 1);
            	
            	world.markBlockForRenderUpdate(x, y, z);
            	
                /*Block block = Block.blocksList[this.spawnID];
                int j1 = block.onBlockPlaced(world, x, y, z, side, xOffset, paryOffset0, 0);

                if (world.setBlockAndMetadataWithNotify(x, y, z, this.spawnID, j1, 3))
                {
                    if (world.getBlockId(x, y, z) == this.spawnID)
                    {
                        Block.blocksList[this.spawnID].onBlockPlacedBy(world, x, y, z, player, item);
                        Block.blocksList[this.spawnID].onPostBlockPlaced(world, x, y, z, j1);
                    }

                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block.stepSound.getPlaceSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                    --item.stackSize;
                }*/
            }

            return true;
        //}
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
	
}
