package widux.moreslabs2;


public class SlabType extends Object
{
	
	private String texture;
	private String[] addTextures;
	private String itemName;
	
	public SlabType(String texture, String[] addTextures, String itemName)
	{
		this.texture = texture;
		this.addTextures = addTextures;
		this.itemName = itemName;
	}
	
	public String[] getTextures()
	{
		if(addTextures == null)
		{
			String[] out = new String[6];
			for(int side = 0; side < 6; side++)
			{
				out[side] = this.texture;
			}
			return out;
		}
		else if(addTextures.length != 6)
		{
			System.out.println("[MoreSlabs2] --- BEGIN ERROR REPORT ---");
			System.out.println("[MoreSlabs2] A SEVERE ERROR HAS OCCURRED. MINECRAFT CANNOT CONTINUE RUNNING.");
			System.out.println("[MoreSlabs2] Slab type is multi-textured, but doesn't have 6 textures!");
			System.out.println("[MoreSlabs2] This is an internal mod error. Please report the following information to the developer:");
			System.out.println("[MoreSlabs2] ArrayLength: " + addTextures.length);
			System.out.print("[MoreSlabs2] ArrayContents: | ");
			for(int i = 0; i < addTextures.length; i++)
			{
				System.out.print(addTextures[i] + " | ");
			}
			System.out.println("");
			System.out.println("[MoreSlabs2] --- END ERROR REPORT ---");
			return null;
		}
		else
		{
			return addTextures;
		}
	}
	
	public String getName()
	{
		return this.itemName;
	}
	
}
