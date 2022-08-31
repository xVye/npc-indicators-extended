package com.npcindicatorsextended;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class NpcIndicatorsExtendedPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(NpcIndicatorsExtendedPlugin.class);
		RuneLite.main(args);
	}
}