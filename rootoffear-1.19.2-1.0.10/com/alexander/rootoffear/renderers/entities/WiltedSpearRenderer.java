/*    */ package com.alexander.rootoffear.renderers.entities;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.WiltedSpear;
/*    */ import com.alexander.rootoffear.models.entities.WiltedSpearModel;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class WiltedSpearRenderer
/*    */   extends EntityRenderer<WiltedSpear> {
/* 19 */   private static final ResourceLocation TEXTURE = new ResourceLocation("rootoffear", "textures/entity/decoy_wilted.png");
/*    */   private final WiltedSpearModel<WiltedSpear> model;
/*    */   
/*    */   public WiltedSpearRenderer(EntityRendererProvider.Context context) {
/* 23 */     super(context);
/* 24 */     this.model = new WiltedSpearModel(context.m_174023_(WiltedSpearModel.LAYER_LOCATION));
/*    */   }
/*    */   
/*    */   public void render(WiltedSpear entity, float p_115374_, float partialTick, PoseStack stack, MultiBufferSource buffer, int packedLight) {
/* 28 */     if (entity.spearAnimationState.m_216984_()) {
/* 29 */       stack.m_85836_();
/* 30 */       stack.m_85841_(-1.0F, -1.0F, 1.0F);
/* 31 */       stack.m_85837_(0.0D, -1.5010000467300415D, 0.0D);
/* 32 */       float f = entity.f_19797_ + partialTick;
/* 33 */       this.model.setupAnim(entity, partialTick, 0.0F, f, 0.0F, 0.0F);
/* 34 */       (this.model.m_142109_()).f_104204_ = (float)Math.toRadians((entity.m_146908_() + 180.0F));
/* 35 */       VertexConsumer vertexconsumer = buffer.m_6299_(this.model.m_103119_(getTextureLocation(entity)));
/* 36 */       this.model.m_7695_(stack, vertexconsumer, packedLight, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
/* 37 */       stack.m_85849_();
/*    */     } 
/* 39 */     super.m_7392_((Entity)entity, p_115374_, partialTick, stack, buffer, packedLight);
/*    */   }
/*    */   
/*    */   public ResourceLocation getTextureLocation(WiltedSpear entity) {
/* 43 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\renderers\entities\WiltedSpearRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */