/*    */ package com.alexander.rootoffear.particles;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.particle.Particle;
/*    */ import net.minecraft.client.particle.ParticleProvider;
/*    */ import net.minecraft.client.particle.ParticleRenderType;
/*    */ import net.minecraft.client.particle.SpriteSet;
/*    */ import net.minecraft.client.particle.TextureSheetParticle;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.SimpleParticleType;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.level.LightLayer;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ public class WiltedGlowParticle
/*    */   extends TextureSheetParticle {
/* 22 */   public static final int[] PARTICLE_COLOURS = new int[] { 15704887, 15495700, 12342561 };
/*    */   
/*    */   private float glowAmount;
/*    */   
/*    */   protected WiltedGlowParticle(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd) {
/* 27 */     super(level, xCoord, yCoord, zCoord, xd, yd, zd);
/* 28 */     this.f_107215_ *= 0.25D;
/* 29 */     this.f_107217_ *= 0.25D;
/* 30 */     this.f_107216_ += 0.01D;
/* 31 */     this.glowAmount = Math.max((7.5F - level.m_45517_(LightLayer.BLOCK, new BlockPos(getPos()))) / 7.5F, 0.0F);
/* 32 */     this.f_172258_ = 0.975F;
/* 33 */     this.f_107663_ = 0.075F;
/* 34 */     this.f_107225_ = 10 + this.f_107223_.m_188503_(5);
/*    */     
/* 36 */     Color glowColour = new Color(PARTICLE_COLOURS[this.f_107223_.m_188503_(PARTICLE_COLOURS.length)]);
/* 37 */     this.f_107227_ = Mth.m_14179_(this.glowAmount, Wilted.revealedLeafColour.getRed() / 255.0F, glowColour.getRed() / 255.0F);
/* 38 */     this.f_107228_ = Mth.m_14179_(this.glowAmount, Wilted.revealedLeafColour.getGreen() / 255.0F, glowColour.getGreen() / 255.0F);
/* 39 */     this.f_107229_ = Mth.m_14179_(this.glowAmount, Wilted.revealedLeafColour.getBlue() / 255.0F, glowColour.getBlue() / 255.0F);
/* 40 */     m_108335_(spriteSet);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int m_6355_(float p_107249_) {
/* 45 */     return (int)(255.0F * this.glowAmount);
/*    */   }
/*    */ 
/*    */   
/*    */   public ParticleRenderType m_7556_() {
/* 50 */     return ParticleRenderType.f_107431_;
/*    */   }
/*    */   
/*    */   public Vec3 getPos() {
/* 54 */     return new Vec3(this.f_107212_, this.f_107213_, this.f_107214_);
/*    */   }
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public static class Provider implements ParticleProvider<SimpleParticleType> {
/*    */     private final SpriteSet sprites;
/*    */     
/*    */     public Provider(SpriteSet spriteSet) {
/* 62 */       this.sprites = spriteSet;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Particle createParticle(SimpleParticleType particleOptions, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
/* 68 */       return (Particle)new WiltedGlowParticle(level, x, y, z, this.sprites, dx, dy, dz);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\particles\WiltedGlowParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */