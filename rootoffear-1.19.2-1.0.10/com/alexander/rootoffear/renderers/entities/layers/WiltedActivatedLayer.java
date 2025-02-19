/*    */ package com.alexander.rootoffear.renderers.entities.layers;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.events.CameraShakeEvents;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.models.entities.WiltedModel;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.client.renderer.entity.LivingEntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.level.LightLayer;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class WiltedActivatedLayer extends RenderLayer<Wilted, WiltedModel<Wilted>> {
/* 25 */   private static final ResourceLocation TEXTURE_0 = new ResourceLocation("rootoffear", "textures/entity/wilted_activated_0.png");
/* 26 */   private static final ResourceLocation TEXTURE_1 = new ResourceLocation("rootoffear", "textures/entity/wilted_activated_1.png");
/*    */   private static final int pulseTime = 5;
/*    */   
/*    */   public WiltedActivatedLayer(RenderLayerParent<Wilted, WiltedModel<Wilted>> p_117707_) {
/* 30 */     super(p_117707_);
/*    */   }
/*    */   
/*    */   public void render(PoseStack p_117720_, MultiBufferSource p_117721_, int p_117722_, Wilted entity, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
/* 34 */     if (!entity.m_6060_()) {
/* 35 */       float glow = 0.5F + Mth.m_14031_(p_117727_ * 0.1F) / 2.0F;
/* 36 */       int pulseGlow = Mth.m_14143_(glow * 100.0F);
/* 37 */       float lightMultiplier = Math.max((7.5F - entity.f_19853_.m_45517_(LightLayer.BLOCK, entity.m_20183_())) / 7.5F, 0.0F);
/* 38 */       if (lightMultiplier > 0.0F && entity.pulseCooldown <= 0 && entity.lastPulseGlow < pulseGlow && 5 <= pulseGlow && 5 >= entity.lastPulseGlow) {
/* 39 */         CameraShakeEvents.addCameraShake(entity.f_19853_, 30, 0.03F, entity.m_20183_(), 80);
/* 40 */         entity.f_19853_.m_7785_((Minecraft.m_91087_()).f_91074_.m_20185_(), (Minecraft.m_91087_()).f_91074_.m_20188_(), (Minecraft.m_91087_()).f_91074_.m_20189_(), (SoundEvent)SoundEventInit.WILTED_PULSE.get(), entity.m_5720_(), Mth.m_14179_(1.0F - Mth.m_14036_((Minecraft.m_91087_()).f_91074_.m_20270_((Entity)entity) / 80.0F, 0.0F, 1.0F), 0.0F, 0.75F), entity.m_6100_() * lightMultiplier, false);
/* 41 */         entity.pulseCooldown = 20;
/*    */       } 
/* 43 */       entity.lastPulseGlow = pulseGlow;
/* 44 */       if (!entity.isDisguised()) {
/* 45 */         VertexConsumer vertexconsumer = p_117721_.m_6299_(RenderType.m_234338_(TEXTURE_0));
/* 46 */         ((WiltedModel)m_117386_()).m_7695_(p_117720_, vertexconsumer, p_117722_, LivingEntityRenderer.m_115338_((LivingEntity)entity, 0.0F), 1.0F, 1.0F, 1.0F, glow * lightMultiplier);
/* 47 */         VertexConsumer vertexconsumer1 = p_117721_.m_6299_(RenderType.m_234338_(TEXTURE_1));
/* 48 */         float glow1 = 0.5F + Mth.m_14031_((p_117727_ - 5.0F) * 0.1F) / 2.0F;
/* 49 */         ((WiltedModel)m_117386_()).m_7695_(p_117720_, vertexconsumer1, p_117722_, LivingEntityRenderer.m_115338_((LivingEntity)entity, 0.0F), 1.0F, 1.0F, 1.0F, glow1 * lightMultiplier);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\renderers\entities\layers\WiltedActivatedLayer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */