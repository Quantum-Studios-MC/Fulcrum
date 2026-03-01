package com.author.examplemod;

import fulcrum.api.*;

@Plugin()
public class ModEntry implements IModEntry {
	public static final String modid = "examplemod";
	public static final String modname = "ExampleMod";

	/**
		This function cannot be removed.
		Here you add the classes you want to add to the class path
		By default only ModEntry is in here
		Load all classes that use @Plugin annotations
	 **/
	public void initialize() {
		PluginHooks.loadClass(ModEntry.class);
		PluginHooks.loadClass(ModRegistry.class);
	}
}
