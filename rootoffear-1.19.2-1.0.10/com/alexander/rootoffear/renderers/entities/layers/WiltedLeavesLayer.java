/*    */ package com.alexander.rootoffear.renderers.entities.layers;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.models.entities.WiltedModel;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.GraphicsStatus;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class WiltedLeavesLayer
/*    */   extends RenderLayer<Wilted, WiltedModel<Wilted>> {
/* 21 */   private static final ResourceLocation TEXTURE = new ResourceLocation("rootoffear", "textures/entity/wilted_leaves.png");
/* 22 */   private static final ResourceLocation TEXTURE_FAST_GRAPHICS = new ResourceLocation("rootoffear", "textures/entity/wilted_leaves_fast_graphics.png");
/*    */   
/*    */   public WiltedLeavesLayer(RenderLayerParent<Wilted, WiltedModel<Wilted>> p_117707_) {
/* 25 */     super(p_117707_);
/*    */   }
/*    */   
/*    */   public void render(PoseStack p_117720_, MultiBufferSource p_117721_, int p_117722_, Wilted p_117723_, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
/* 29 */     if ((p_117723_.isDisguised() || p_117723_.stillShowingLeaves) && !p_117723_.m_20145_()) {
/* 30 */       Color colour = new Color(p_117723_.leafColour);
/* 31 */       m_117376_(m_117386_(), ((Minecraft.m_91087_()).f_91066_.m_232060_().m_231551_() == GraphicsStatus.FAST) ? TEXTURE_FAST_GRAPHICS : TEXTURE, p_117720_, p_117721_, p_117722_, (LivingEntity)p_117723_, colour.getRed() / 255.0F, colour.getGreen() / 255.0F, colour.getBlue() / 255.0F);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\renderers\entities\layers\WiltedLeavesLayer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */