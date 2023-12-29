package me.ballmc.BarrierVisibility.command;

import net.weavemc.loader.api.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class BarrierVisibility extends Command {
    public BarrierVisibility() {
        super("bv", "barriervisibility");
    }

    @Override
    public void handle(String[] args) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("This is a command!"));

        if (args.length != 0) {
            return;
        }
    }
}
