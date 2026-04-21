package dev.jab125.sodiumissue3590.client;

import dev.jab125.sodiumissue3590.Sodiumissue3590;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.LightCoordsUtil;
import net.minecraft.world.level.block.state.BlockState;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;

public class Sodiumissue3590Client {
	public static void blockTint(BlockColorRegisterer registerer) {
		registerer.register(List.of(_ -> 0xFFFF8500), Sodiumissue3590.MY_TINTED_BLOCK);
	}

	public static void collectSubmits(Context context) {
		context.poseStack().pushPose();
		context.poseStack().translate(context.cameraRenderState().pos.multiply(-1, -1, -1));
		context.poseStack().translate(0, 200, 0);
		context.poseStack().scale(3, 3, 3);
		BlockState blockState = Sodiumissue3590.MY_TINTED_BLOCK.defaultBlockState();
		{
			BlockModelRenderState blockModelRenderState = new BlockModelRenderState();
			Sodiumissue3590Client.resolver.apply(Minecraft.getInstance()).update(blockModelRenderState, blockState, BlockDisplayContext.create());
			blockModelRenderState.submit(context.poseStack(), context.submitNodeCollector(), LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, 0);
		}
		context.poseStack().popPose();
	}

	public static final Function<Minecraft, BlockModelResolver> resolver;
	static {
		Field blockModelResolver;
		try {
			blockModelResolver = Minecraft.class.getDeclaredField("blockModelResolver");
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
		blockModelResolver.setAccessible(true);
		MethodHandle methodHandle;
		try {
			methodHandle = MethodHandles.lookup().unreflectGetter(blockModelResolver);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		resolver = minecraft -> {
			try {
				return (BlockModelResolver) methodHandle.invokeExact(minecraft);
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		};
	}
}
