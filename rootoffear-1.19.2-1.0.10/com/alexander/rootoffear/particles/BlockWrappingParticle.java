/*    */ package com.alexander.rootoffear.particles;
/*    */ 
/*    */ import com.alexander.rootoffear.events.RenderBlockWrappingParticlesEvent;
/*    */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*    */ import net.minecraft.client.Camera;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.particle.ParticleRenderType;
/*    */ import net.minecraft.client.particle.SpriteSet;
/*    */ import net.minecraft.client.particle.TextureSheetParticle;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ 
/*    */ public abstract class BlockWrappingParticle
/*    */   extends TextureSheetParticle {
/*    */   public final SpriteSet sprites;
/*    */   
/*    */   protected BlockWrappingParticle(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd) {
/* 20 */     super(level, Mth.m_14107_(xCoord), Mth.m_14107_(yCoord), Mth.m_14107_(zCoord), xd, yd, zd);
/* 21 */     this.sprites = spriteSet;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_5744_(VertexConsumer consumer, Camera camera, float partialTick) {
/* 26 */     RenderBlockWrappingParticlesEvent.queuedBlockWrappingParticles.add(this);
/*    */   }
/*    */   
/*    */   public Vec3 getPos() {
/* 30 */     return new Vec3(this.f_107212_, this.f_107213_, this.f_107214_);
/*    */   }
/*    */   
/*    */   public abstract ResourceLocation getTexture();
/*    */   
/*    */   public RenderType renderType() {
/* 36 */     return RenderType.m_110494_(getTexture());
/*    */   }
/*    */ 
/*    */   
/*    */   public ParticleRenderType m_7556_() {
/* 41 */     return ParticleRenderType.f_107431_;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\particles\BlockWrappingParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */