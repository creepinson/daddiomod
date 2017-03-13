package me.creepinson.handlers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabHandler {
	
	
	public static final CreativeTabs tabMP_CREEPOLA = new CreativeTabs("Creepola"){
	    @Override public Item getTabIconItem() {
	        return Items.GUNPOWDER;
	    }
	};
	
}
