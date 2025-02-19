/*    */ package com.alexander.rootoffear.mixin;
/*    */ 
/*    */ import com.alexander.rootoffear.events.HandleClientEffectsEvent;
/*    */ import net.minecraft.client.Camera;
/*    */ import net.minecraft.client.renderer.FogRenderer;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.material.FogType;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({FogRenderer.class})
/*    */ public abstract class FogRendererMixin
/*    */ {
/*    */   @Inject(at = {@At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogStart(F)V")}, method = {"setupFog"}, cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
/*    */   private static void rootoffear_createFog(Camera camera, FogRenderer.FogMode fogMode, float farPlaneDistance, boolean shouldCreateFog, float partialTick, CallbackInfo callback, FogType fogtype, Entity entity, FogRenderer.FogData fogrenderer$fogdata, FogRenderer.MobEffectFogFunction fogrenderer$mobeffectfogfunction) {
/* 24 */     if (fogrenderer$mobeffectfogfunction == null && fogtype == FogType.NONE && !entity.m_5833_() && HandleClientEffectsEvent.extraFogAmount > 0.025D) {
/* 25 */       float originalFogEnd = fogrenderer$fogdata.f_234201_;
/* 26 */       float originalFogStart = fogrenderer$fogdata.f_234200_;
/*    */       
/* 28 */       if (fogtype == FogType.NONE) {
/* 29 */         if (fogMode == FogRenderer.FogMode.FOG_SKY) {
/* 30 */           originalFogStart = 0.0F;
/* 31 */           originalFogEnd = farPlaneDistance;
/*    */         } else {
/* 33 */           float f = Mth.m_14036_(farPlaneDistance / 10.0F, 4.0F, 64.0F);
/* 34 */           originalFogStart = farPlaneDistance - f;
/* 35 */           originalFogEnd = farPlaneDistance;
/*    */         } 
/*    */       }
/*    */       
/* 39 */       float fogAmount = Mth.m_14179_(partialTick, HandleClientEffectsEvent.extraFogAmountO, HandleClientEffectsEvent.extraFogAmount);
/* 40 */       fogrenderer$fogdata.f_234201_ = Mth.m_14179_(fogAmount, (fogtype == FogType.NONE) ? (farPlaneDistance * 2.0F) : originalFogEnd, Math.min(originalFogEnd, 80.0F));
/* 41 */       fogrenderer$fogdata.f_234200_ = Mth.m_14179_(fogAmount, (fogtype == FogType.NONE) ? (farPlaneDistance * 2.0F) : (originalFogStart * 2.5F), 0.0F);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\FogRendererMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */