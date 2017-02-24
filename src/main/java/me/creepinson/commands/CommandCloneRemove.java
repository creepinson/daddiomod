package me.creepinson.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class CommandCloneRemove extends CommandBase
	{ 
	 
    protected String cloneName;

	  
	    public CommandCloneRemove() 
	    { 
	    	
	    	
	  	  
	      
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
	    	  List<String> list = new ArrayList<String>();
	    		list.add("clonerem");
	    		list.add("cloneremove");
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
	                sender.addChatMessage(new TextComponentTranslation("Invalid arguments!")); 
	                return; 
	            } 
	          for(int i = 0; i < world.getLoadedEntityList().size() ;i++)
	        if(argString[0].equalsIgnoreCase(world.getLoadedEntityList().get(i).getEntityData().getString("cloneName"))){
	        
	        	
	        	
	        	world.getLoadedEntityList().get(i).setDead();
	        sender.addChatMessage(new TextComponentTranslation("Removed Clone: " + argString[0])); 
			    
	        
	        }

	        else{
	        	  sender.addChatMessage(new TextComponentTranslation("You need to specify a clone to remove. ")); 
	      		
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

