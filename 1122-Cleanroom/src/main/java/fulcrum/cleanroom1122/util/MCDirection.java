package fulcrum.cleanroom1122.util;

import fulcrum.api.util.Direction;
import net.minecraft.util.EnumFacing;

public class MCDirection {
	public static Direction getDirection(EnumFacing facing) {
		return switch (facing) {
			case UP -> Direction.UP;
			case DOWN -> Direction.DOWN;
			case EAST -> Direction.EAST;
			case WEST -> Direction.WEST;
			case NORTH -> Direction.NORTH;
			case SOUTH -> Direction.SOUTH;
		};
	}
}
