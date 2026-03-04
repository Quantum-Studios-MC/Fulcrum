package fulcrum.cleanroom1122.mixins;

import fulcrum.api.game.util.IMCPos;
import net.minecraft.util.math.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Vec3i.class)
public abstract class MixinVec3i implements IMCPos {
	@Shadow
	public abstract int getX();
	@Shadow
	public abstract int getY();
	@Shadow
	public abstract int getZ();

	@Override
	public int getX$() {
		return getX();
	}

	@Override
	public int getY$() {
		return getY();
	}

	@Override
	public int getZ$() {
		return getZ();
	}
}
