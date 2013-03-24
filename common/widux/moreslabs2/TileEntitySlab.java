package widux.moreslabs2;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySlab extends TileEntity
{
	public static SlabType[] textures = {
		new SlabType("cloth_0", null), 
		new SlabType("cloth_1", null), 
		new SlabType("cloth_2", null), 
		new SlabType("cloth_3", null), 
		new SlabType("cloth_4", null), 
		new SlabType("cloth_5", null), 
		new SlabType("cloth_6", null), 
		new SlabType("cloth_7", null), 
		new SlabType("cloth_8", null), 
		new SlabType("cloth_9", null), 
		new SlabType("cloth_10", null), 
		new SlabType("cloth_11", null), 
		new SlabType("cloth_12", null), 
		new SlabType("cloth_13", null), 
		new SlabType("cloth_14", null), 
		new SlabType("cloth_15", null), 
		new SlabType("glass", null), 
		new SlabType(null, MultiTextureSlabs.logOak), 
		new SlabType(null, MultiTextureSlabs.logBirch), 
		new SlabType(null, MultiTextureSlabs.logSpruce), 
		new SlabType(null, MultiTextureSlabs.logJungle)};
	
	public static final String[] itemNames = {"White Wool Slab", "Orange Wool Slab", "Magenta Wool Slab", "Light Blue Wool Slab", "Yellow Wool Slab", "Lime Wool Slab", "Pink Wool Slab", "Gray Wool Slab", "Light Gray Wool Slab", "Cyan Wool Slab", "Purple Wool Slab", "Blue Wool Slab", "Brown Wool Slab", "Green Wool Slab", "Red Wool Slab", "Black Wool Slab", "Glass Slab", "Oak Log Slab", "Birch Log Slab", "Spruce Log Slab", "Jungle Log Slab"}; 
	
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