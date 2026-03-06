package fulcrum.forge1710.mixins;

import fulcrum.api.game.nbt.IMCTagBase;
import fulcrum.api.game.nbt.IMCTagCompound;
import fulcrum.api.game.nbt.IMCTagList;
import net.minecraft.nbt.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(NBTTagCompound.class)
public abstract class MixinNBTTagCompound implements IMCTagCompound {

	@Shadow public abstract void setTag(String key, NBTBase value);
	@Shadow public abstract void setByte(String key, byte value);
	@Shadow public abstract void setShort(String key, short value);
	@Shadow public abstract void setInteger(String key, int value);
	@Shadow public abstract void setLong(String key, long value);
	@Shadow public abstract void setFloat(String key, float value);
	@Shadow public abstract void setDouble(String key, double value);
	@Shadow public abstract void setString(String key, String value);
	@Shadow public abstract void setByteArray(String key, byte[] value);
	@Shadow public abstract void setIntArray(String key, int[] value);
	@Shadow public abstract void setBoolean(String key, boolean value);

	@Shadow public abstract NBTBase getTag(String key);
	@Shadow public abstract boolean hasKey(String key);
	@Shadow public abstract boolean hasKey(String key, int type);

	@Shadow public abstract byte getByte(String key);
	@Shadow public abstract short getShort(String key);
	@Shadow public abstract int getInteger(String key);
	@Shadow public abstract long getLong(String key);
	@Shadow public abstract float getFloat(String key);
	@Shadow public abstract double getDouble(String key);
	@Shadow public abstract String getString(String key);

	@Shadow public abstract byte[] getByteArray(String key);
	@Shadow public abstract int[] getIntArray(String key);

	@Shadow public abstract NBTTagCompound getCompoundTag(String key);
	@Shadow public abstract NBTTagList getTagList(String key, int type);

	@Shadow public abstract boolean getBoolean(String key);

	@Shadow public abstract void removeTag(String key);

	// ================= API IMPLEMENTATION =================

	@Override
	public void setTag$(String key, IMCTagBase value) {
		setTag(key, (NBTBase) value);
	}

	@Override
	public IMCTagBase getTag$(String key) {
		return (IMCTagBase) getTag(key);
	}

	@Override
	public void setByte$(String key, byte value) {
		setByte(key, value);
	}

	@Override
	public byte getByte$(String key) {
		return getByte(key);
	}

	@Override
	public void setShort$(String key, short value) {
		setShort(key, value);
	}

	@Override
	public short getShort$(String key) {
		return getShort(key);
	}

	@Override
	public void setInteger$(String key, int value) {
		setInteger(key, value);
	}

	@Override
	public int getInteger$(String key) {
		return getInteger(key);
	}

	@Override
	public void setLong$(String key, long value) {
		setLong(key, value);
	}

	@Override
	public long getLong$(String key) {
		return getLong(key);
	}

	@Override
	public void setFloat$(String key, float value) {
		setFloat(key, value);
	}

	@Override
	public float getFloat$(String key) {
		return getFloat(key);
	}

	@Override
	public void setDouble$(String key, double value) {
		setDouble(key, value);
	}

	@Override
	public double getDouble$(String key) {
		return getDouble(key);
	}

	@Override
	public void setString$(String key, String value) {
		setString(key, value);
	}

	@Override
	public String getString$(String key) {
		return getString(key);
	}

	@Override
	public void setByteArray$(String key, byte[] value) {
		setByteArray(key, value);
	}

	@Override
	public byte[] getByteArray$(String key) {
		return getByteArray(key);
	}

	@Override
	public void setIntArray$(String key, int[] value) {
		setIntArray(key, value);
	}

	@Override
	public int[] getIntArray$(String key) {
		return getIntArray(key);
	}

	@Override
	public void setBoolean$(String key, boolean value) {
		setBoolean(key, value);
	}

	@Override
	public boolean getBoolean$(String key) {
		return getBoolean(key);
	}

	@Override
	public boolean hasKey$(String key) {
		return hasKey(key);
	}

	@Override
	public boolean hasKey$(String key, int type) {
		return hasKey(key, type);
	}

	@Override
	public void removeTag$(String key) {
		removeTag(key);
	}

	@Override
	public IMCTagCompound getCompoundTag$(String key) {
		return (IMCTagCompound) getCompoundTag(key);
	}

	@Override
	public IMCTagList getTagList$(String key, int type) {
		return (IMCTagList) getTagList(key, type);
	}
}
