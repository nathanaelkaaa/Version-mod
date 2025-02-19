/*    */ package com.alexander.rootoffear.renderers.entities.layers;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.models.entities.WiltedModel;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.EyesLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class WiltedEyesLayer<T extends Wilted>
/*    */   extends EyesLayer<T, WiltedModel<T>>
/*    */ {
/* 16 */   private static final RenderType TEXTURE = RenderType.m_110488_(new ResourceLocation("rootoffear", "textures/entity/wilted_eyes.png"));
/*    */   
/*    */   public WiltedEyesLayer(RenderLayerParent<T, WiltedModel<T>> p_117342_) {
/* 19 */     super(p_117342_);
/*    */   }
/*    */   
/*    */   public RenderType m_5708_() {
/* 23 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\renderers\entities\layers\WiltedEyesLayer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */