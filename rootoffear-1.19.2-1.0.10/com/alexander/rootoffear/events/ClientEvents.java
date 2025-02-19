/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.init.EntityTypeInit;
/*    */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*    */ import com.alexander.rootoffear.models.entities.DecoyWiltedModel;
/*    */ import com.alexander.rootoffear.models.entities.LightExtinguisherDarknessModel;
/*    */ import com.alexander.rootoffear.models.entities.LightExtinguisherModel;
/*    */ import com.alexander.rootoffear.models.entities.ShadowWiltedModel;
/*    */ import com.alexander.rootoffear.models.entities.WiltedBarrierModel;
/*    */ import com.alexander.rootoffear.models.entities.WiltedHandsModel;
/*    */ import com.alexander.rootoffear.models.entities.WiltedModel;
/*    */ import net.minecraft.client.particle.ParticleEngine;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.core.particles.ParticleType;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.client.event.EntityRenderersEvent;
/*    */ import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear", bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*    */ public class ClientEvents
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
/* 38 */     event.registerLayerDefinition(WiltedModel.LAYER_LOCATION, WiltedModel::createBodyLayer);
/* 39 */     event.registerLayerDefinition(LightExtinguisherModel.LAYER_LOCATION, LightExtinguisherModel::createBodyLayer);
/* 40 */     event.registerLayerDefinition(LightExtinguisherDarknessModel.LAYER_LOCATION, LightExtinguisherDarknessModel::createBodyLayer);
/* 41 */     event.registerLayerDefinition(DecoyWiltedModel.LAYER_LOCATION, DecoyWiltedModel::createBodyLayer);
/* 42 */     event.registerLayerDefinition(WiltedHandsModel.LAYER_LOCATION, WiltedHandsModel::createBodyLayer);
/* 43 */     event.registerLayerDefinition(ShadowWiltedModel.LAYER_LOCATION, ShadowWiltedModel::createBodyLayer);
/* 44 */     event.registerLayerDefinition(WiltedBarrierModel.LAYER_LOCATION, WiltedBarrierModel::createBodyLayer);
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
/* 49 */     event.registerEntityRenderer((EntityType)EntityTypeInit.WILTED.get(), com.alexander.rootoffear.renderers.entities.WiltedRenderer::new);
/* 50 */     event.registerEntityRenderer((EntityType)EntityTypeInit.DECOY_WILTED.get(), com.alexander.rootoffear.renderers.entities.DecoyWiltedRenderer::new);
/* 51 */     event.registerEntityRenderer((EntityType)EntityTypeInit.LIGHT_EXTINGUISHER.get(), com.alexander.rootoffear.renderers.entities.LightExtinguisherRenderer::new);
/* 52 */     event.registerEntityRenderer((EntityType)EntityTypeInit.WILTED_HANDS.get(), com.alexander.rootoffear.renderers.entities.WiltedHandsRenderer::new);
/* 53 */     event.registerEntityRenderer((EntityType)EntityTypeInit.SHADOW_WILTED.get(), com.alexander.rootoffear.renderers.entities.ShadowWiltedRenderer::new);
/* 54 */     event.registerEntityRenderer((EntityType)EntityTypeInit.WILTED_BARRIER.get(), com.alexander.rootoffear.renderers.entities.WiltedBarrierRenderer::new);
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
/* 59 */     event.register((ParticleType)ParticleTypeInit.WILTED_LEAF.get(), com.alexander.rootoffear.particles.WiltedLeafParticle.Provider::new);
/* 60 */     event.register((ParticleType)ParticleTypeInit.WILTED_WALL.get(), com.alexander.rootoffear.particles.WiltedWallParticle.Provider::new);
/* 61 */     event.register((ParticleType)ParticleTypeInit.BLOCK_BREAKING.get(), com.alexander.rootoffear.particles.BlockBreakingParticle.Provider::new);
/* 62 */     event.register((ParticleType)ParticleTypeInit.WILTED_BREAK.get(), com.alexander.rootoffear.particles.WiltedBreakParticle.Provider::new);
/* 63 */     event.register((ParticleType)ParticleTypeInit.LEAF_STORM.get(), com.alexander.rootoffear.particles.LeafStormParticle.Provider::new);
/* 64 */     event.register((ParticleType)ParticleTypeInit.WILTED_GLOW.get(), com.alexander.rootoffear.particles.WiltedGlowParticle.Provider::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\ClientEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */