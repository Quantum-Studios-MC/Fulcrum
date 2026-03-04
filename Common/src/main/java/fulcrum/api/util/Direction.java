package fulcrum.api.util;

public enum Direction {
	DOWN(0, -1, 0),
	UP(0, 1, 0),
	NORTH(0, 0, -1),
	SOUTH(0, 0, 1),
	WEST(-1, 0, 0),
	EAST(1, 0, 0),
	UNKNOWN(0, 0, 0);

	public final int offsetX;
	public final int offsetY;
	public final int offsetZ;
	public final int flag;
	public static final Direction[] VALID_DIRECTIONS = new Direction[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};
	public static final int[] OPPOSITES = new int[]{1, 0, 3, 2, 5, 4, 6};
	public static final int[][] ROTATION_MATRIX = new int[][]{{0, 1, 4, 5, 3, 2, 6}, {0, 1, 5, 4, 2, 3, 6}, {5, 4, 2, 3, 0, 1, 6}, {4, 5, 2, 3, 1, 0, 6}, {2, 3, 1, 0, 4, 5, 6}, {3, 2, 0, 1, 4, 5, 6}, {0, 1, 2, 3, 4, 5, 6}};

	private Direction(int x, int y, int z) {
		this.offsetX = x;
		this.offsetY = y;
		this.offsetZ = z;
		this.flag = 1 << this.ordinal();
	}

	public static Direction getOrientation(int id) {
		return id >= 0 && id < VALID_DIRECTIONS.length ? VALID_DIRECTIONS[id] : UNKNOWN;
	}

	public Direction getOpposite() {
		return getOrientation(OPPOSITES[this.ordinal()]);
	}

	public Direction getRotation(Direction axis) {
		return getOrientation(ROTATION_MATRIX[axis.ordinal()][this.ordinal()]);
	}
}
