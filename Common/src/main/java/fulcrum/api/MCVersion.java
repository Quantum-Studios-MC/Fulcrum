package fulcrum.api;

public enum MCVersion {
	MC_1_12_2,
	MC_1_7_10;

	public static MCVersion currentVersion;

	public static void setVersion(MCVersion version) {
		currentVersion = version;
	}

	public static MCVersion getVersion() {
		return currentVersion;
	}
}
