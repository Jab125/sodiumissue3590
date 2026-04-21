package dev.jab125.sodiumissue3590.neoforge.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.jab125.sodiumissue3590.client.Context;
import dev.jab125.sodiumissue3590.client.Sodiumissue3590Client;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.SubmitCustomGeometryEvent;

@EventBusSubscriber
@Mod(value = "sodiumissue3590", dist = Dist.CLIENT)
public class NeoforgeClient {
	@SubscribeEvent
	public static void event(RegisterColorHandlersEvent.BlockTintSources event) {
		Sodiumissue3590Client.blockTint(event::register);
	}

	@SubscribeEvent
	public static void event(SubmitCustomGeometryEvent event) {
		Sodiumissue3590Client.collectSubmits(new Context() {
			@Override
			public PoseStack poseStack() {
				return event.getPoseStack();
			}

			@Override
			public CameraRenderState cameraRenderState() {
				return event.getLevelRenderState().cameraRenderState;
			}

			@Override
			public SubmitNodeCollector submitNodeCollector() {
				return event.getSubmitNodeCollector();
			}
		});
	}
}
