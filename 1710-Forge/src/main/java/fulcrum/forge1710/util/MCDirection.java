package fulcrum.forge1710.util;

import fulcrum.api.util.Direction;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.util.ForgeDirection;

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

	public static Direction getDirection(ForgeDirection facing) {
		return switch (facing) {
			case UP -> Direction.UP;
			case DOWN -> Direction.DOWN;
			case EAST -> Direction.EAST;
			case WEST -> Direction.WEST;
			case NORTH -> Direction.NORTH;
			case SOUTH -> Direction.SOUTH;
			case UNKNOWN -> null;
		};
	}
	public static Direction getDirection(int side) {
		return switch (side) {
			case 0 -> Direction.DOWN;
			case 1 -> Direction.UP;
			case 2 -> Direction.NORTH;
			case 3 -> Direction.SOUTH;
			case 4 -> Direction.WEST;
			case 5 -> Direction.EAST;
			default -> Direction.UP;
		};
	}
}
