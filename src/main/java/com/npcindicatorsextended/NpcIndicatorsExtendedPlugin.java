package com.npcindicatorsextended;

import com.google.inject.Provides;
import java.util.Optional;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.npchighlight.NpcIndicatorsPlugin;

@Slf4j
@PluginDescriptor(
	name = "NPC Indicators Extended"
)
public class NpcIndicatorsExtendedPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private PluginManager pluginManager;

	private NpcIndicatorsPlugin npcIndicators;

	@Override
	protected void startUp() throws Exception
	{
		final Optional<Plugin> indicatorsPlugin = pluginManager.getPlugins().stream().filter(
			p -> p.getName().equals("NPC Indicators")
		).findFirst();

		if (indicatorsPlugin.isPresent())
		{
			npcIndicators = (NpcIndicatorsPlugin) indicatorsPlugin.get();
			log.info("Found indicators plugin.");
		}

		if (indicatorsPlugin.isPresent() && !pluginManager.isPluginEnabled(indicatorsPlugin.get()))
		{
			pluginManager.setPluginEnabled(indicatorsPlugin.get(), true);
			log.info("Enabled indicators plugin.");
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}
}
