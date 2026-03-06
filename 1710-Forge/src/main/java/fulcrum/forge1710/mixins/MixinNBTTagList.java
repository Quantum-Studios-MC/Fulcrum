package fulcrum.forge1710.mixins;

import fulcrum.api.game.nbt.IMCTagBase;
import fulcrum.api.game.nbt.IMCTagCompound;
import fulcrum.api.game.nbt.IMCTagList;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(NBTTagList.class)
public abstract class MixinNBTTagList implements IMCTagList {

	@Shadow public abstract void appendTag(NBTBase tag);

	@Shadow public abstract void setTag(int index, NBTBase tag);

	@Shadow public abstract NBTBase removeTag(int index);

	@Shadow public abstract NBTTagCompound getCompoundTagAt(int index);

	@Override
	public void appendTag$(IMCTagBase tag) {
		appendTag((NBTBase) tag);
	}

	@Override
	public void setTag$(int index, IMCTagBase tag) {
		setTag(index, (NBTBase) tag);
	}

	@Override
	public IMCTagBase removeTag$(int index) {
		return (IMCTagBase) removeTag(index);
	}

	@Override
	public IMCTagCompound getCompoundTagAt$(int index) {
		return (IMCTagCompound) getCompoundTagAt(index);
	}
}