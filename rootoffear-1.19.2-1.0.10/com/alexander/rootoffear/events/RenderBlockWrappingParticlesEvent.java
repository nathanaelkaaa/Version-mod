/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.particles.BlockWrappingParticle;
/*    */ import com.google.common.collect.Lists;
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.blaze3d.vertex.SheetedDecalTextureGenerator;
/*    */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.renderer.GameRenderer;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.level.BlockAndTintGetter;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.client.event.RenderLevelStageEvent;
/*    */ import net.minecraftforge.client.model.data.ModelData;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear", value = {Dist.CLIENT})
/*    */ public class RenderBlockWrappingParticlesEvent
/*    */ {
/* 29 */   public static final List<BlockWrappingParticle> queuedBlockWrappingParticles = Lists.newArrayList();
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void renderBlockWrappingParticles(RenderLevelStageEvent event) {
/* 33 */     if (event.getStage().equals(RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS)) {
/* 34 */       Minecraft minecraft = Minecraft.m_91087_();
/* 35 */       PoseStack poseStack = event.getPoseStack();
/* 36 */       ClientLevel clientLevel = minecraft.f_91073_;
/* 37 */       Vec3 cameraPos = minecraft.f_91063_.m_109153_().m_90583_();
/* 38 */       for (BlockWrappingParticle particle : queuedBlockWrappingParticles) {
/* 39 */         poseStack.m_85836_();
/* 40 */         Vec3 particlePos = particle.getPos();
/* 41 */         poseStack.m_85837_(particlePos.f_82479_ - cameraPos.f_82479_, particlePos.f_82480_ - cameraPos.f_82480_, particlePos.f_82481_ - cameraPos.f_82481_);
/* 42 */         BlockPos pos = new BlockPos(particlePos);
/* 43 */         PoseStack.Pose posestack$pose1 = poseStack.m_85850_();
/* 44 */         RenderSystem.m_157427_(GameRenderer::m_172829_);
/*    */         
/* 46 */         SheetedDecalTextureGenerator sheetedDecalTextureGenerator = new SheetedDecalTextureGenerator(minecraft.m_91269_().m_110104_().m_6299_(particle.renderType()), posestack$pose1.m_85861_(), posestack$pose1.m_85864_());
/* 47 */         ModelData modelData = clientLevel.getModelDataManager().getAt(pos);
/* 48 */         minecraft.m_91289_().renderBreakingTexture(clientLevel.m_8055_(pos), pos, (BlockAndTintGetter)clientLevel, poseStack, (VertexConsumer)sheetedDecalTextureGenerator, (modelData == null) ? ModelData.EMPTY : modelData);
/* 49 */         poseStack.m_85849_();
/*    */       } 
/* 51 */       queuedBlockWrappingParticles.clear();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\RenderBlockWrappingParticlesEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */