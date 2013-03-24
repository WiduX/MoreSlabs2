package widux.moreslabs2;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySlab extends TileEntity
{
	public static SlabType[] textures = {
		new SlabType("cloth_0", null, "White Wool Slab"), 
		new SlabType("cloth_1", null, "Orange Wool Slab"), 
		new SlabType("cloth_2", null, "Magenta Wool Slab"), 
		new SlabType("cloth_3", null, "Light Blue Wool Slab"), 
		new SlabType("cloth_4", null, "Yellow Wool Slab"), 
		new SlabType("cloth_5", null, "Lime Wool Slab"), 
		new SlabType("cloth_6", null, "Pink Wool Slab"), 
		new SlabType("cloth_7", null, "Gray Wool Slab"), 
		new SlabType("cloth_8", null, "Light Gray Wool Slab"), 
		new SlabType("cloth_9", null, "Cyan Wool Slab"), 
		new SlabType("cloth_10", null, "Purple Wool Slab"), 
		new SlabType("cloth_11", null, "Blue Wool Slab"), 
		new SlabType("cloth_12", null, "Brown Wool Slab"), 
		new SlabType("cloth_13", null, "Green Wool Slab"), 
		new SlabType("cloth_14", null, "Red Wool Slab"), 
		new SlabType("cloth_15", null, "Black Wool Slab"), 
		new SlabType("glass", null, "Glass Slab"), 
		new SlabType(null, MultiTextureSlabs.logOak, "Oak Log Slab"), 
		new SlabType(null, MultiTextureSlabs.logBirch, "Birch Log Slab"), 
		new SlabType(null, MultiTextureSlabs.logSpruce, "Spruce Log Slab"), 
		new SlabType(null, MultiTextureSlabs.logJungle, "Jungle Log Slab"), 
		new SlabType("dirt", null, "Dirt Slab"),
		new SlabType("hellrock", null, "Netherrack Slab"),
		new SlabType("stoneMoss", null, "Mossy Cobblestone Slab"), 
		new SlabType("hellsand", null, "Soul Sand Slab"), 
		new SlabType(null, MultiTextureSlabs.bookshelf, "Bookshelf Slab"), 
		new SlabType("stonebricksmooth_mossy", null, "Mossy Stone Brick Slab"),
		new SlabType("stonebricksmooth_cracked", null, "Cracked Stone Brick Slab"),
		new SlabType("stonebricksmooth_carved", null, "Chiseled Stone Brick Slab"),
		new SlabType("obsidian", null, "Obsidian Slab"),
		new SlabType("blockLapis", null, "Lapis Lazuli Slab"),
		new SlabType("blockIron", null, "Iron Slab"),
		new SlabType("blockGold", null, "Gold Slab"),
		new SlabType("blockDiamond", null, "Diamond Slab"),
		new SlabType("blockRedstone", null, "Redstone Slab"),
		new SlabType("stone", null, "Stone Slab"),
		new SlabType("lightgem", null, "Glowstone Slab"),
		new SlabType("bedrock", null, "Bedrock Slab"),
		new SlabType("blockEmerald", null, "Emerald Slab"),
		new SlabType("clay", null, "Clay Slab"),
		new SlabType("ice", null, "Ice Slab"),
		new SlabType("sponge", null, "Sponge Slab"),
		new SlabType("whiteStone", null, "End Stone Slab"),
		new SlabType(null, MultiTextureSlabs.sandstoneSmooth, "Smooth Sandstone Slab"),
		new SlabType(null, MultiTextureSlabs.sandstoneChiseled, "Chiseled Sandstone Slab"),
		new SlabType(null, MultiTextureSlabs.quartzChiseled, "Chiseled Quartz Slab"),
		new SlabType(null, MultiTextureSlabs.quartzPillar, "Quartz Pillar Slab")};
	
	//private final String NBT_DATA = "SlabData";
	//private int[] slabData = {1, 0, 0, 0, 0, 0};
	
	private final String NBT_TYPE = "SlabType";
	private int slabType;
	
	public TileEntitySlab()
	{
		
	}
	
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		//slabData = nbt.getIntArray(NBT_DATA);
		slabType = nbt.getInteger(NBT_TYPE);
		
	}
	
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		//nbt.setIntArray(NBT_DATA, slabData);
		nbt.setInteger(NBT_TYPE, slabType);
	}
	
	public int getSlabType()
	{
		return this.slabType;
	}
	
	public void setSlabType(int newType)
	{
		this.slabType = newType;
	}
	
	public static int getSlabTypeAmount()
	{
		return textures.length;
	}
	
	public static String getTextureName(int slabType, int side)
	{
		return textures[slabType].getTextures()[side];
	}
	
    public Packet getDescriptionPacket()
    {
    	NBTTagCompound tileTag = new NBTTagCompound();
    	this.writeToNBT(tileTag);
    	return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 0, tileTag);
    }

    @Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
    {
    	this.readFromNBT(pkt.customParam1);
    }
	
}