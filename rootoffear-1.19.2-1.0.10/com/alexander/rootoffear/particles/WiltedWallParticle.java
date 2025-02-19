/*    */ package com.alexander.rootoffear.particles;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.particle.Particle;
/*    */ import net.minecraft.client.particle.ParticleProvider;
/*    */ import net.minecraft.client.particle.SpriteSet;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.SimpleParticleType;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ public class WiltedWallParticle
/*    */   extends BlockWrappingParticle
/*    */ {
/* 17 */   private static final ResourceLocation[] textures = new ResourceLocation[] { new ResourceLocation("rootoffear", "textures/particle/wilted_wall_0.png"), new ResourceLocation("rootoffear", "textures/particle/wilted_wall_1.png"), new ResourceLocation("rootoffear", "textures/particle/wilted_wall_2.png"), new ResourceLocation("rootoffear", "textures/particle/wilted_wall_3.png"), new ResourceLocation("rootoffear", "textures/particle/wilted_wall_3.png") };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected WiltedWallParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet, double xd, double yd, double zd) {
/* 27 */     super(level, x, y, z, spriteSet, xd, yd, zd);
/*    */     
/* 29 */     this.f_172258_ = 1.0F;
/* 30 */     this.f_107215_ = xd;
/* 31 */     this.f_107216_ = yd;
/* 32 */     this.f_107217_ = zd;
/* 33 */     this.f_107663_ = 1.0F;
/* 34 */     this.f_107225_ = 20;
/*    */     
/* 36 */     this.f_107227_ = 1.0F;
/* 37 */     this.f_107228_ = 1.0F;
/* 38 */     this.f_107229_ = 1.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTexture() {
/* 43 */     return textures[Mth.m_14143_((textures.length - 1) * this.f_107224_ / this.f_107225_)];
/*    */   }
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public static class Provider implements ParticleProvider<SimpleParticleType> {
/*    */     private final SpriteSet sprites;
/*    */     
/*    */     public Provider(SpriteSet spriteSet) {
/* 51 */       this.sprites = spriteSet;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
/* 57 */       return (Particle)new WiltedWallParticle(level, x, y, z, this.sprites, dx, dy, dz);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\particles\WiltedWallParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */