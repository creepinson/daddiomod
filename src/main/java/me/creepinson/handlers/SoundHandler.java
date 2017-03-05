package me.creepinson.handlers;

import me.creepinson.lib.RefStrings;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoundHandler {

	 public static SoundEvent creepinoScreech;
	 public static SoundEvent creepinoDeath;
	 public static SoundEvent creepinoHurt;
	 
	 private static int size = 0;


		/**
		 * Register the {@link SoundEvent}s.
		 */
		public static void registerSounds() {
			creepinoHurt = registerSound("creepinoHurt");
			creepinoScreech = registerSound("creepinoScreech");
			creepinoDeath = registerSound("creepinoDeath");
		
		}

		/**
		 * Register a {@link SoundEvent}.
		 *
		 * @param soundName The SoundEvent's name without the testmod3 prefix
		 * @return The SoundEvent
		 */
		public static SoundEvent registerSound(String name){
			ResourceLocation location = new ResourceLocation(RefStrings.MODID + ":" + name);
			SoundEvent e = new SoundEvent(location);
			SoundEvent.REGISTRY.register(size, location, e);
			size++;
			System.out.println(e.getSoundName());
			
			return e;
		}
	
}
