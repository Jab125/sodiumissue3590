package dev.jab125.sodiumissue3590;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sodiumissue3590  {
	public static final Logger LOGGER = LoggerFactory.getLogger(Sodiumissue3590.class);
	public static final Block MY_TINTED_BLOCK = new Block(BlockBehaviour.Properties.of().noOcclusion().setId(ResourceKey.create(Registries.BLOCK, id("my_tinted_block"))));
	public static final Item MY_TINTED_BLOCK_ITEM = new BlockItem(MY_TINTED_BLOCK, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id("my_tinted_block"))));

	public static void registerBlocks(Registerer<Block> blockRegisterer) {
		blockRegisterer.register(id("my_tinted_block"), MY_TINTED_BLOCK);
		LOGGER.info("Registered the tinted block!");
	}

	public static void registerItems(Registerer<Item> blockRegisterer) {
		blockRegisterer.register(id("my_tinted_block"), MY_TINTED_BLOCK_ITEM);
		LOGGER.info("Registered the tinted block item!");
	}

	public static void registerCreativeModeTabs(CreativeModeTabRegisterer registerer) {
		if (registerer.getTab().equals(CreativeModeTabs.tabs().getFirst())) {
			registerer.addToBeginning(MY_TINTED_BLOCK_ITEM.getDefaultInstance());
		}
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath("sodiumissue3590", path);
	}
}
