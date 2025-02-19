/*    */ package com.alexander.rootoffear.renderers.entities;
/*    */ import com.alexander.rootoffear.entities.ShadowWilted;
/*    */ import com.alexander.rootoffear.models.entities.ShadowWiltedModel;
/*    */ import com.alexander.rootoffear.renderers.entities.layers.ShadowWiltedEyesLayer;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.math.Vector3f;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.MobRenderer;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class ShadowWiltedRenderer extends MobRenderer<ShadowWilted, ShadowWiltedModel<ShadowWilted>> {
/*    */   public ShadowWiltedRenderer(EntityRendererProvider.Context p_173933_) {
/* 21 */     super(p_173933_, (EntityModel)new ShadowWiltedModel(p_173933_.m_174023_(ShadowWiltedModel.LAYER_LOCATION)), 0.0F);
/* 22 */     m_115326_((RenderLayer)new ShadowWiltedEyesLayer((RenderLayerParent)this));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setupRotations(ShadowWilted entity, PoseStack p_115318_, float p_115319_, float p_115320_, float p_115321_) {
/* 28 */     p_115318_.m_85837_(0.0D, (entity.m_20206_() / 2.0F), 0.0D);
/* 29 */     p_115318_.m_85845_(Vector3f.f_122225_.m_122240_(180.0F - Mth.m_14179_(p_115321_, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_)));
/* 30 */     p_115318_.m_85845_(Vector3f.f_122223_.m_122240_(-Mth.m_14179_(p_115321_, entity.facingAngleO.f_82470_, entity.facingAngle.f_82470_)));
/* 31 */     p_115318_.m_85837_(0.0D, (-entity.m_20206_() / 2.0F), 0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   protected float getFlipDegrees(ShadowWilted p_115337_) {
/* 36 */     return 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   protected RenderType getRenderType(ShadowWilted p_115322_, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
/* 41 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ResourceLocation getTextureLocation(ShadowWilted entity) {
/* 48 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\renderers\entities\ShadowWiltedRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */