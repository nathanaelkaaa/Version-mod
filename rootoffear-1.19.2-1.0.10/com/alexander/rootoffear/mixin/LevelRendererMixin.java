/*    */ package com.alexander.rootoffear.mixin;
/*    */ 
/*    */ import com.alexander.rootoffear.events.HandleClientEffectsEvent;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.LevelRenderer;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyVariable;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({LevelRenderer.class})
/*    */ public abstract class LevelRendererMixin
/*    */ {
/*    */   @ModifyVariable(method = {"renderLevel"}, at = @At("STORE"), ordinal = 3)
/*    */   private boolean rootoffear_setfoggy(boolean flag1) {
/* 17 */     return ((HandleClientEffectsEvent.extraFogAmount > 0.025D && !(Minecraft.m_91087_()).f_91074_.m_5833_()) || flag1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\LevelRendererMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */