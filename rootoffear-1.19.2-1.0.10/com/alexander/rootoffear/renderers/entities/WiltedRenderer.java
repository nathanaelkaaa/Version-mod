/*    */ package com.alexander.rootoffear.renderers.entities;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.models.entities.WiltedModel;
/*    */ import com.alexander.rootoffear.renderers.entities.layers.WiltedActivatedLayer;
/*    */ import com.alexander.rootoffear.renderers.entities.layers.WiltedLeavesLayer;
/*    */ import net.minecraft.client.renderer.culling.Frustum;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.MobRenderer;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class WiltedRenderer extends MobRenderer<Wilted, WiltedModel<Wilted>> {
/* 19 */   private static final ResourceLocation TEXTURE = new ResourceLocation("rootoffear", "textures/entity/wilted.png");
/*    */   
/*    */   public WiltedRenderer(EntityRendererProvider.Context p_173933_) {
/* 22 */     super(p_173933_, (EntityModel)new WiltedModel(p_173933_.m_174023_(WiltedModel.LAYER_LOCATION)), 2.0F);
/* 23 */     m_115326_((RenderLayer)new WiltedEyesLayer((RenderLayerParent)this));
/* 24 */     m_115326_((RenderLayer)new WiltedActivatedLayer((RenderLayerParent)this));
/* 25 */     m_115326_((RenderLayer)new WiltedLeavesLayer((RenderLayerParent)this));
/*    */   }
/*    */ 
/*    */   
/*    */   protected float getFlipDegrees(Wilted p_115337_) {
/* 30 */     return 0.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRender(Wilted wilted, Frustum p_115469_, double p_115470_, double p_115471_, double p_115472_) {
/* 36 */     return !wilted.disableRendering;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ResourceLocation getTextureLocation(Wilted entity) {
/* 43 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\renderers\entities\WiltedRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */