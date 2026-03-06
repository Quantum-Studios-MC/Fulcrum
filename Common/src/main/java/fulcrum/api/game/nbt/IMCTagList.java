package fulcrum.api.game.nbt;

public interface IMCTagList {
	void appendTag$(IMCTagBase tag);

	void setTag$(int index, IMCTagBase tag);

	IMCTagBase removeTag$(int index);

	IMCTagCompound getCompoundTagAt$(int index);
}
