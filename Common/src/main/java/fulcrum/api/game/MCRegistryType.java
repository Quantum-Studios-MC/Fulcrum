package fulcrum.api.game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MCRegistryType<T extends IMCRegistryObject> {
	private final Map<String, T> entries = new HashMap<>();

	public void register(T value) {
		String id = value.getDelegateRegistryObject$fulcrum().getRegistryName();
		if (!entries.containsKey(value.getDelegateRegistryObject$fulcrum().getRegistryName())) {
			entries.put(id, value);
		}
	}

	public T get(String id) {
		return entries.get(id);
	}

	public Collection<T> values() {
		return entries.values();
	}

	public int size() {
		return entries.size();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(T value : values()) {
			builder.append(value.getDelegateRegistryObject$fulcrum().getRegistryName());
		}
		return builder.toString();
	}
}
