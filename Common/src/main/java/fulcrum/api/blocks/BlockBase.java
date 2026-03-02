package fulcrum.api.blocks;

import fulcrum.api.creativetabs.CreativeTab;
import fulcrum.api.creativetabs.ICreativeTab;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemBlockBase;
import fulcrum.api.items.ItemType;

public class BlockBase implements IBlock {
	private final String registryName;
	private String textureName;
	private final IItemBlock itemBlock;
	private IBlockMaterial material;
	private IBlockSound sound;
	private ICreativeTab creativeTab;
	private float hardness;
	private float resistance;
	private BlockType blockType;
	private BlockModelType blockModelType;
	private ItemType itemBlockType;
	private boolean isFullCube;
	private boolean isOpaqueCube;

	public BlockBase(String registryName) {
		this.registryName = registryName;
		this.itemBlock = new ItemBlockBase(this);
		setMaterial(BlockMaterial.ROCK);
		setCreativeTab(CreativeTab.MISC);
		setSound(BlockSound.STONE);
		setHardness(1.5F);
		setResistance(10.0F);
		setItemBlockType(ItemType.BLOCK);
		setModelType(BlockModelType.CUBE);
		setType(BlockType.BASIC);
		setFullCube(true);
		setOpaqueCube(true);
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
	public BlockType getType() {
		return blockType;
	}

	@Override
	public BlockModelType getModelType() {
		return blockModelType;
	}

	@Override
	public ItemType getItemBlockType() {
		return itemBlockType;
	}

	@Override
	public ICreativeTab getCreativeTab() {
		return creativeTab;
	}

	@Override
	public IBlockMaterial getMaterial() {
		return material;
	}

	@Override
	public IBlockSound getSound() {
		return sound;
	}

	@Override
	public boolean isFullCube() {
		return isFullCube;
	}

	@Override
	public boolean isOpaqueCube() {
		return isOpaqueCube;
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

	public BlockBase setFullCube(boolean fullCube) {
		isFullCube = fullCube;
		return this;
	}

	public BlockBase setOpaqueCube(boolean opaqueCube) {
		isOpaqueCube = opaqueCube;
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

	public BlockBase setType(BlockType blockType) {
		this.blockType = blockType;
		return this;
	}

	public BlockBase setModelType(BlockModelType blockType) {
		this.blockModelType = blockType;
		return this;
	}

	public BlockBase setItemBlockType(ItemType itemBlockType) {
		this.itemBlockType = itemBlockType;
		return this;
	}

	public BlockBase setCreativeTab(ICreativeTab creativeTab) {
		this.creativeTab = creativeTab;
		return this;
	}
}
