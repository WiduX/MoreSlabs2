package widux.moreslabs2;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySlab extends TileEntity
{
	
	private final String NBT_DATA = "SlabData";
	private int[] slabData = {1, 0, 0, 0, 0, 0};
	
	public TileEntitySlab()
	{
		
	}
	
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		slabData = nbt.getIntArray(NBT_DATA);
	}
	
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setIntArray(NBT_DATA, slabData);
	}
	
	public double[] getBoundData()
	{
		double[] out = {0F, 0F, 0F, 1F, 1F, 1F};
		return out;
	}
	
	public int[] getData()
	{
		return slabData;
	}
	
}