package dev.jab125.sodiumissue3590;

import net.minecraft.resources.Identifier;

public interface Registerer<T> {
	void register(Identifier id, T instance);
}
