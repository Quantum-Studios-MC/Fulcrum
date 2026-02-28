package fulcrum.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RegistryType<T extends IRegistryObject> {
	private final Map<String, T> entries = new HashMap<>();

	public void register(T value) {
		String id = value.getRegistryName();
		if (entries.containsKey(value.getRegistryName())) {
			throw new IllegalArgumentException("Duplicate id: " + id);
		}
		entries.put(id, value);
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
}
