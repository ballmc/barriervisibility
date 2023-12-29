package me.ballmc.BarrierVisibility.command;

import net.weavemc.loader.api.command.Command;
import me.ballmc.BarrierVisibility.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import me.ballmc.BarrierVisibility.BarrierVisibility;
import me.ballmc.BarrierVisibility.Config;

public class BarrierVisibilityToggle extends Command {
    public BarrierVisibilityToggle() {
        super("bv", "barriervisibility");
    }

    BarrierVisibility bv = BarrierVisibility.getInstance();
    Config config = bv.getConfig();

    private void setEnabled(boolean value) {
        config.BarrierVisibilityEnabled = value;
        bv.saveConfig();
        EnumChatFormatting statusColor = config.BarrierVisibilityEnabled ? EnumChatFormatting.GREEN : EnumChatFormatting.RED;
        String message = EnumChatFormatting.BLUE + "Barrier Visibility" + EnumChatFormatting.RESET +
                " has been " + statusColor + (config.BarrierVisibilityEnabled ? "enabled" : "disabled") + EnumChatFormatting.RESET + ".";
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }

    @Override
    public void handle(String[] args) {
        setEnabled(!config.BarrierVisibilityEnabled);
        Minecraft.getMinecraft().renderGlobal.loadRenderers();
    }
}
