package me.creepinson.Main;


import java.util.Random;

import jline.internal.Log;
import me.creepinson.commands.CommandCloneCreate;
import me.creepinson.commands.CommandCloneRemove;
import me.creepinson.commands.CommandRegistryMod;
import me.creepinson.entities.EntityPlayerClone;
import me.creepinson.handlers.EventHandlerMOD;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.handlers.MobDropsHandler;

import me.creepinson.lib.IProxy;
import me.creepinson.lib.RefStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
    	registerEntity(EntityPlayerClone.class, "entityPlayerClone");
		proxy.preInit();
     
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
    int entityID = 2019;
    EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
    EntityList.ENTITY_EGGS.put(name, new EntityList.EntityEggInfo(name, primaryColor, secondaryColor));
    }
    
    
    
    
}
