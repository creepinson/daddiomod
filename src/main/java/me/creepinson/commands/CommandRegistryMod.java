package me.creepinson.commands;

import net.minecraft.command.ICommand;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommandRegistryMod {

	private FMLServerStartingEvent event;

	public CommandRegistryMod(FMLServerStartingEvent par1Event)
	{
		this.event = par1Event;
		registerAll();
	}

	private void registerAll()
	{
		
		register(new CommandCloneCreate());
		register(new CommandCloneRemove());
	}

	protected void register(ICommand par1ICommand)
	{
		event.registerServerCommand(par1ICommand);
	}

}
