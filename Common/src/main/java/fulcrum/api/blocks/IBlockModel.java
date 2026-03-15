package fulcrum.api.blocks;

public interface IBlockModel {
	public enum ModelType {
		SIMPLE,
		JSON
	}

	ModelType getModelType();
}
