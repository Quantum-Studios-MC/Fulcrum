package fulcrum.api.blocks;

public enum BlockModel implements IBlockModel {
	CUBE,
	CROSS;

	@Override
	public ModelType getModelType() {
		return ModelType.SIMPLE;
	}
}
