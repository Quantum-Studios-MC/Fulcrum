package fulcrum.api.blocks;

import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemBlockBase;

public class BlockBase implements IBlock {
	private final String registryName;
	private String textureName;
	private final IItemBlock itemBlock;
	private BlockMaterial material;
	private BlockSound sound;
	private float hardness;
	private float resistance;

	public BlockBase(String registryName) {
		this.registryName = registryName;
		this.itemBlock = new ItemBlockBase(this);
		material = BlockMaterial.ROCK;
		sound = BlockSound.STONE;
		hardness = 1.5F;
		resistance = 10.0F;
	}

	@Override
	public IItemBlock getItemBlock() {
		return itemBlock;
	}

	@Override
	public String getRegistryName() {
		return registryName;
	}

	@Override
	public String getTextureName() {
		return textureName;
	}

	@Override
	public BlockMaterial getMaterial() {
		return material;
	}

	@Override
	public BlockSound getSound() {
		return sound;
	}

	@Override
	public float getHardness() {
		return hardness;
	}

	@Override
	public float getResistance() {
		return resistance;
	}

	public BlockBase setTextureName(String textureName) {
		this.textureName = textureName;
		return this;
	}

	public BlockBase setMaterial(BlockMaterial material) {
		this.material = material;
		return this;
	}

	public BlockBase setSound(BlockSound sound) {
		this.sound = sound;
		return this;
	}

	public BlockBase setHardness(float hardness) {
		this.hardness = hardness;
		return this;
	}

	public BlockBase setResistance(float resistance) {
		this.resistance = resistance;
		return this;
	}
}
