package com.ryorama.ryolib;

import com.ryorama.ryolib.core.client.world.ModifyWorldColor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.world.WorldTickCallback;

public class RyoLib implements ModInitializer {
	
	@Override
	public void onInitialize() {
		WorldTickCallback.EVENT.register((world -> {
			ModifyWorldColor.changeWorldColor("FF0000", 1, "FF0000", 0.4);
		}));
	}
}
