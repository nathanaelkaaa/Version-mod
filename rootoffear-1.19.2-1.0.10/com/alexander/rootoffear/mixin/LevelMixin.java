/*    */ package com.alexander.rootoffear.mixin;
/*    */ import com.alexander.rootoffear.config.RoFCommonConfig;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.tags.FluidTags;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.minecraft.world.level.block.LiquidBlock;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import net.minecraftforge.common.capabilities.CapabilityProvider;
/*    */ import net.minecraftforge.common.extensions.IForgeLevel;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({Level.class})
/*    */ public abstract class LevelMixin extends CapabilityProvider<Level> implements LevelAccessor, AutoCloseable, IForgeLevel {
/*    */   @Shadow
/*    */   @Final
/*    */   private boolean f_46443_;
/*    */   
/*    */   protected LevelMixin(Class<Level> baseClass) {
/* 30 */     super(baseClass);
/*    */   }
/*    */   
/*    */   @Inject(at = {@At("HEAD")}, method = {"Lnet/minecraft/world/level/Level;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;II)Z"}, cancellable = true)
/*    */   private void rootoffear_stopDynamicLights(BlockPos p_46605_, BlockState p_46606_, int p_46607_, int p_46608_, CallbackInfoReturnable<Boolean> callback) {
/* 35 */     if (((Boolean)RoFCommonConfig.wilted_disables_nearby_dynamic_lights.get()).booleanValue() && m_45976_(Wilted.class, (new AABB(p_46605_.m_123341_(), p_46605_.m_123342_(), p_46605_.m_123343_(), (p_46605_.m_123341_() + 1), (p_46605_.m_123342_() + 1), (p_46605_.m_123343_() + 1))).m_82400_(30.0D)).size() > 0) { if (p_46606_
/* 36 */         .m_60734_() != Blocks.f_152480_) if (p_46606_
/* 37 */           .getLightEmission((BlockGetter)this, p_46605_) > 0) { if (!p_46606_.m_60795_()) { Block block = p_46606_.m_60734_(); if (block instanceof LiquidBlock) { LiquidBlock liquid = (LiquidBlock)block; if (liquid.getFluid().m_205067_(FluidTags.f_13131_))
/* 38 */               { callback.setReturnValue(Boolean.valueOf(false)); return; }  }  return; }  } else { return; }   } else { return; }  callback.setReturnValue(Boolean.valueOf(false));
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\LevelMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */