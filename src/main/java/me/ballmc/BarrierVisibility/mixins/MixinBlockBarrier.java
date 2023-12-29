package me.ballmc.BarrierVisibility.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBarrier;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.ballmc.BarrierVisibility.BarrierVisibility;
import me.ballmc.BarrierVisibility.Config;

@Mixin(BlockBarrier.class)
public abstract class MixinBlockBarrier extends Block {
    BarrierVisibility bv = BarrierVisibility.getInstance();
    Config config = bv.getConfig();

    public MixinBlockBarrier(Material blockMaterialIn) {
        super(blockMaterialIn);
    }

    @Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
    public void getRenderType(CallbackInfoReturnable<Integer> cir) {
        if (config.BarrierVisibilityEnabled) {
            cir.setReturnValue(3);
        }
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return worldIn.getBlockState(pos).getBlock() != this && super.shouldSideBeRendered(worldIn, pos, side);
    }
}