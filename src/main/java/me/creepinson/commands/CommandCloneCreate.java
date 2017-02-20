package me.creepinson.commands;

import java.util.ArrayList;
import java.util.List;

import me.creepinson.Main.Main;
import me.creepinson.entities.EntityPlayerClone;
import me.creepinson.lib.RefStrings;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class CommandCloneCreate extends CommandBase
	{ 
	
    protected String cloneUsername;
	protected EntityPlayerClone cloneEntity; 
	  
	    public CommandCloneCreate() 
	    { 
	    	
	  	  
	      
	    } 
	  

	    @Override 
	    public String getCommandName() 
	    { 
	        return "clonecreate"; 
	    } 

	    @Override         
	    public String getCommandUsage(ICommandSender var1) 
	    { 
	        return "clonecreate"; 
	    } 

@Override
	    public List getCommandAliases() 
	    {
	    	  List<String> list = new ArrayList<String>();
			list.add("clonecreate");
	    	  return list;
		
	       
	    } 
	    public void execute(MinecraftServer server, ICommandSender sender, String[] argString)
	    { 
	        World world = sender.getEntityWorld(); 
	    
	        if (world.isRemote) 
	        { 
	            System.out.println("Not processing on Client side"); 
	        } 
	        else 
	        { 
	            System.out.println("Processing on Server side"); 
	            if(argString.length == 0) 
	            { 
	                sender.addChatMessage(new TextComponentTranslation("Invalid argument")); 
	                return; 
	            } 

	             if(argString[0].equalsIgnoreCase("player") || argString[0].equalsIgnoreCase("p")){
	           
	            	 if(argString[1] != null);
	            	{
	            		if(argString[2] != null){
	            			 cloneEntity = new EntityPlayerClone(world); 
	            			cloneEntity.getEntityData().setString("cloneName", argString[2]);	
	            	      
	            			cloneUsername = argString[1];       
	            		cloneEntity.getLocationSkin(argString[1]);
		            cloneEntity.setCustomNameTag(argString[2]);
		         
	            		world.spawnEntityInWorld(cloneEntity);
		            	sender.addChatMessage(new TextComponentTranslation("Cloned Player: " + argString[1])); 
		    
	            	
	            		}}}}	
	             }
	             
	            
	        
	           
	           

	    

	    public boolean canCommandSenderUseCommand(ICommandSender var1) 
	    { 
	        return true;
	    } 

	    public List addTabCompletionOptions(ICommandSender var1, String[] var2) 
	    { 
	        // TODO Auto-generated method stub 
	        return null; 
	    } 

	    @Override 
	    public boolean isUsernameIndex(String[] var1, int var2) 
	    { 
	        // TODO Auto-generated method stub 
	        return false;
	    }


		@Override
		public int compareTo(ICommand o) {
			
			return 0;
		}


		


		@Override
		public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args,
				BlockPos pos) {
			// TODO Auto-generated method stub
			return null;
		} 
	}

