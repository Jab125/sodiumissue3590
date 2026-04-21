package dev.jab125.sodiumissue3590;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public interface CreativeModeTabRegisterer {
	CreativeModeTab getTab();
	void addToBeginning(ItemStack stack);
}
