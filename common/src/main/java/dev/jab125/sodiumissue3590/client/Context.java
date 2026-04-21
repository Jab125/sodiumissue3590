package dev.jab125.sodiumissue3590.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.CameraRenderState;

public interface Context {
		PoseStack poseStack();
		CameraRenderState cameraRenderState();
		SubmitNodeCollector submitNodeCollector();
	}