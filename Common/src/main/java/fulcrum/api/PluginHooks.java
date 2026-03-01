package fulcrum.api;

import com.author.examplemod.ModEntry;
import fulcrum.api.registry.BlockRegistry;
import fulcrum.api.registry.ItemRegistry;
import fulcrum.api.registry.RecipeRegistry;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PluginHooks {
	private static final List<Class<?>> classPath = new ArrayList<>();

	public static void loadClass(Class<?> className) {
		if (!classPath.contains(className)) {
			classPath.add(className);
		}
	}

	public static void initialize() {
		PluginHooks.loadClass(ModEntry.class);
		invokeInitClass();
	}

	public static void generateItems() {
		invokeAnnotation(Plugin.Registry.Item.class, ItemRegistry.getInstance());
	}

	public static void generateBlocks() {
		invokeAnnotation(Plugin.Registry.Block.class, BlockRegistry.getInstance());
	}

	public static void generateRecipes() {
		invokeAnnotation(Plugin.Registry.Recipe.class, RecipeRegistry.getInstance());
	}

	public static void invokeAnnotation(Class<? extends Annotation> annotation, Object object) {
		for (Class<?> classObj : classPath) {
			try {
				Object instance = classObj.getDeclaredConstructor().newInstance();

				for (Method method : classObj.getDeclaredMethods()) {
					if (method.isAnnotationPresent(annotation)) {

						method.setAccessible(true);
						method.invoke(instance, object);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void invokeInitClass() {
		List<Class<?>> copy = new ArrayList<>(classPath);

		for (Class<?> classObj : copy) {
			try {
				if (!classObj.isAnnotationPresent(Plugin.class)) continue;
				if (!IModEntry.class.isAssignableFrom(classObj)) continue;
				IModEntry entry = (IModEntry) classObj.getDeclaredConstructor().newInstance();
				entry.initialize();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
