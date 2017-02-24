package me.creepinson.commands;

import java.util.ArrayList;
import java.util.List;

import me.creepinson.entities.EntityPlayerClone;
import me.creepinson.entities.RenderPlayerClone;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class CommandCloneCreate extends CommandBase
	{ 
	protected RenderPlayerClone renderClone;
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



						EntityPlayerClone entity = new EntityPlayerClone(world);
						NBTTagCompound tag = new NBTTagCompound();
						entity.writeEntityToNBT(tag);//create the base tag
						tag.setString("cloneName", argString[2]);//alter the tag, for instance here the health is changed. Bit devious but it's an example.
						entity.readEntityFromNBT(tag);//inject the entity with the altered tag.


	            			cloneUsername = argString[1];

		            entity.setCustomNameTag(argString[2]);
		         entity.setPosition(sender.getPosition().getX(), sender.getPosition().getY(), sender.getPosition().getZ());
	            		world.spawnEntityInWorld(entity);
		            	sender.addChatMessage(new TextComponentTranslation("Cloned Player: " + argString[1]));

	            		        	}
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

