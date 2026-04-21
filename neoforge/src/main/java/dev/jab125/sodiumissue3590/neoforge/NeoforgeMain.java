package dev.jab125.sodiumissue3590.neoforge;

import dev.jab125.sodiumissue3590.CreativeModeTabRegisterer;
import dev.jab125.sodiumissue3590.Sodiumissue3590;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber
@Mod("sodiumissue3590")
public class NeoforgeMain {
	@SubscribeEvent
	public static void registerBlocksEvent(RegisterEvent event) {
		if (event.getRegistry() == BuiltInRegistries.BLOCK) {
			Sodiumissue3590.registerBlocks((id, instance) -> event.register(Registries.BLOCK, id, () -> instance));
		} else if (event.getRegistry() == BuiltInRegistries.ITEM) {
			Sodiumissue3590.registerItems((id, instance) -> event.register(Registries.ITEM, id, () -> instance));
		}
	}

	@SubscribeEvent
	public static void event(BuildCreativeModeTabContentsEvent registry) {
		Sodiumissue3590.registerCreativeModeTabs(new CreativeModeTabRegisterer() {
			@Override
			public CreativeModeTab getTab() {
				return registry.getTab();
			}

			@Override
			public void addToBeginning(ItemStack stack) {
				registry.insertFirst(stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			}
		});
	}
}
