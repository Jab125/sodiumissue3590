package dev.jab125.sodiumissue3590.fabric;

import dev.jab125.sodiumissue3590.CreativeModeTabRegisterer;
import dev.jab125.sodiumissue3590.Sodiumissue3590;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FabricMain implements ModInitializer {
	@Override
	public void onInitialize() {
		Sodiumissue3590.registerBlocks((id, instance) -> Registry.register(BuiltInRegistries.BLOCK, id, instance));
		Sodiumissue3590.registerItems((id, instance) -> Registry.register(BuiltInRegistries.ITEM, id, instance));
		CreativeModeTabEvents.MODIFY_OUTPUT_ALL.register((tab, output) -> Sodiumissue3590.registerCreativeModeTabs(new CreativeModeTabRegisterer() {
			@Override
			public CreativeModeTab getTab() {
				return tab;
			}

			@Override
			public void addToBeginning(ItemStack stack) {
				output.prepend(stack);
			}
		}));
	}
}
