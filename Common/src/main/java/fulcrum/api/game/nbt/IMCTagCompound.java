package fulcrum.api.game.nbt;

public interface IMCTagCompound {

	void setTag$(String key, IMCTagBase value);
	IMCTagBase getTag$(String key);

	void setByte$(String key, byte value);
	byte getByte$(String key);

	void setShort$(String key, short value);
	short getShort$(String key);

	void setInteger$(String key, int value);
	int getInteger$(String key);

	void setLong$(String key, long value);
	long getLong$(String key);

	void setFloat$(String key, float value);
	float getFloat$(String key);

	void setDouble$(String key, double value);
	double getDouble$(String key);

	void setString$(String key, String value);
	String getString$(String key);

	void setByteArray$(String key, byte[] value);
	byte[] getByteArray$(String key);

	void setIntArray$(String key, int[] value);
	int[] getIntArray$(String key);

	void setBoolean$(String key, boolean value);
	boolean getBoolean$(String key);

	boolean hasKey$(String key);
	boolean hasKey$(String key, int type);

	void removeTag$(String key);

	IMCTagCompound getCompoundTag$(String key);
	IMCTagList getTagList$(String key, int type);

}
