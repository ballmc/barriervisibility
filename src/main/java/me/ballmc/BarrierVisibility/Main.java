package me.ballmc.BarrierVisibility;

import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;
import me.ballmc.BarrierVisibility.command.BarrierVisibilityToggle;

public class Main implements ModInitializer {
    @Override
    public void preInit() {
        System.out.println("Initializing BarrierVisibility!");
        BarrierVisibility bv = BarrierVisibility.getInstance();
        bv.initialize(System.getProperty("user.home") + "/.weave/mods");
        CommandBus.register(new BarrierVisibilityToggle());
    }
}