package dev.jab125.sodiumissue3590.fabric.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.jab125.sodiumissue3590.client.Context;
import dev.jab125.sodiumissue3590.client.Sodiumissue3590Client;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderEvents;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.CameraRenderState;

public class FabricMainClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Sodiumissue3590Client.blockTint(BlockColorRegistry::register);

		LevelRenderEvents.COLLECT_SUBMITS.register(context -> {
			Sodiumissue3590Client.collectSubmits(new Context() {
				@Override
				public PoseStack poseStack() {
					return context.poseStack();
				}

				@Override
				public CameraRenderState cameraRenderState() {
					return context.levelState().cameraRenderState;
				}

				@Override
				public SubmitNodeCollector submitNodeCollector() {
					return context.submitNodeCollector();
				}
			});
		});
	}
}
