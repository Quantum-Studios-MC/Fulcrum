package fulcrum.cleanroom1122.gen;

import fulcrum.cleanroom1122.CleanroomModEntry;

public class Generator {
	public static void main(String[] args) {
		//Create Instance
		CleanroomModEntry cleanroomModEntry = new CleanroomModEntry();

		ModelGenerator.registerModels();
	}
}
