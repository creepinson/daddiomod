package me.creepinson.main;


import java.util.Random;

import me.creepinson.commands.CommandRegistryMod;
import me.creepinson.entities.EntityCreepino;
import me.creepinson.handlers.EventHandlerMOD;
import me.creepinson.handlers.MobDropsHandler;

import me.creepinson.lib.IProxy;
import me.creepinson.lib.RefStrings;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;


@net.minecraftforge.fml.common.Mod(modid = me.creepinson.lib.RefStrings.MODID, version =  me.creepinson.lib.RefStrings.VERSION)
public class Main {
	
	
	@Mod.Instance(RefStrings.MODID)
	public static Main instance;
	
	@net.minecraftforge.fml.common.SidedProxy(clientSide = RefStrings.CLIENTSIDE, serverSide = RefStrings.SERVERSIDE)
//VARIABLES
	
	
	public static IProxy proxy;

	@EventHandler
	public void severStarting(FMLServerStartingEvent event)
	{
		new CommandRegistryMod(event);
	}

    //INITS
    @net.minecraftforge.fml.common.Mod.EventHandler
    public void preInit(FMLPreInitializationEvent PreEvent)
    {
    	registerEntity(EntityCreepino.class, "entityCreepino");
		proxy.preInit();
		OBJLoader.INSTANCE.addDomain(RefStrings.MODID + ":" + "models/entity/Creepino.obj");
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	 
		proxy.init();
    	MinecraftForge.EVENT_BUS.register(new EventHandlerMOD());
    	MinecraftForge.EVENT_BUS.register(new MobDropsHandler());
    
    	
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent PostEvent)
    {
		
		proxy.postInit();	
    	
    }
    public static void registerEntity(Class entityClass, String name)
    {
    
    long seed = name.hashCode();
    Random rand = new Random(seed);
    int primaryColor = rand.nextInt() * 16777215;
    int secondaryColor = rand.nextInt() * 16777215;
    int id = 1;
    EntityRegistry.registerModEntity(entityClass, name, 2018, instance, 64, 10, true, primaryColor, secondaryColor);

    }
    
    
    
    
}
