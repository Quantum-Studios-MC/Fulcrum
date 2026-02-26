package com.author.examplemod;

import cpw.mods.fml.common.Mod;

@Mod(modid = ModConstants.MODID, version = "1.0.0", name = ModConstants.MODNAME, acceptedMinecraftVersions = "[1.7.10]")
public class ExampleModForge {

	public ExampleModForge() {
		ExampleModCommon.initialize();
	}
}
