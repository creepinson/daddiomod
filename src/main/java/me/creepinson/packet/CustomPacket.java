package me.creepinson.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CustomPacket implements IMessage{
	 public static String skin;
	// A default constructor is always required
	  public CustomPacket(String skin){
		  
		  this.skin = skin;
	  }
	 
	
	  
	  public CustomPacket() {
	    
	   
	  }

	  @Override public void toBytes(ByteBuf buffer) {
	
		  ByteBufUtils.writeUTF8String(buffer, this.skin);
	  
	  }

	  @Override public void fromBytes(ByteBuf buffer) {
	    // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
	
		  this.skin = ByteBufUtils.readUTF8String(buffer);
		 
		  	
	  
	  }
	}



