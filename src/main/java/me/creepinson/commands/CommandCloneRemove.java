package me.creepinson.commands;

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
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class CommandCloneRemove extends CommandBase
	{ 
	
    protected String cloneName;
	protected EntityPlayerClone cloneEntity; 
	  
	    public CommandCloneRemove(World world) 
	    { 
	    	 cloneEntity = new EntityPlayerClone(world); 
	  	  
	      
	    } 
	  

	    @Override 
	    public String getCommandName() 
	    { 
	        return "clonerem"; 
	    } 

	    @Override         
	    public String getCommandUsage(ICommandSender var1) 
	    { 
	        return "clonerem"; 
	    } 

	    @Override 
	    public List getCommandAliases() 
	    {
			return null; 
	       
	    } 

	    public void processCommand(ICommandSender sender, String[] argString)
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
	                sender.addChatMessage(new TextComponentTranslation("Invalid arguments!")); 
	                return; 
	            } 
	            else if(cloneEntity.getEntityData().hasKey("name"))
   if  (argString[0] == cloneEntity.getEntityData().getString("name")){
	    	           
	            	cloneEntity.setDead();
	            } 
   else{
   	sender.addChatMessage(new TextComponentTranslation("Please Choose a Clone to Remove.")); 
       
   }
	            
	            	
	            }
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
		public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
			// TODO Auto-generated method stub
			
		}


		@Override
		public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args,
				BlockPos pos) {
			// TODO Auto-generated method stub
			return null;
		} 
	}

