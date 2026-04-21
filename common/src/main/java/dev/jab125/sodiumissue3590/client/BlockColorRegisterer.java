package dev.jab125.sodiumissue3590.client;

import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.world.level.block.Block;

import java.util.List;

public interface BlockColorRegisterer {
	void register(List<BlockTintSource> list, Block... blocks);
}
