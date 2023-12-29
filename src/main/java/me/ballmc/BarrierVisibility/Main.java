package me.ballmc.BarrierVisibility;

import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;
import me.ballmc.BarrierVisibility.command.BarrierVisibility;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class Main implements ModInitializer {
    @Override
    public void preInit() {
        System.out.println("Initializing BarrierVisibility!");
        CommandBus.register(new BarrierVisibility());
    }
}