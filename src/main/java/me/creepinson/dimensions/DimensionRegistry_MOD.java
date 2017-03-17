package me.creepinson.dimensions;

import me.creepinson.handlers.ConfigHandler;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry_MOD {

	public static void mainRegistry(){
		
		registerDimensions();
		
	}

	public static final int creepolaDimensionID = ConfigHandler.creepolaDimensionID;
	public static final DimensionType CREEPOLA_NORMAL = DimensionType.register("Creepola", "_creepolaDimension", creepolaDimensionID, DimensionTypeCreepola.class, false);
	public static void registerDimensions() {
	
		
		DimensionManager.registerDimension(creepolaDimensionID, CREEPOLA_NORMAL);
		
	}
	
	
	
	
}
