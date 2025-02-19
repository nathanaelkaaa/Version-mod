/*    */ package com.alexander.rootoffear.particles;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.particle.Particle;
/*    */ import net.minecraft.client.particle.ParticleProvider;
/*    */ import net.minecraft.client.particle.SpriteSet;
/*    */ import net.minecraft.client.resources.model.ModelBakery;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ public class BlockBreakingParticle<T extends AdvancedParticleOption>
/*    */   extends BlockWrappingParticle {
/*    */   private final int texture;
/*    */   
/*    */   protected BlockBreakingParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet, double xd, double yd, double zd, T options) {
/* 18 */     super(level, x, y, z, spriteSet, xd, yd, zd);
/*    */     
/* 20 */     this.f_172258_ = 1.0F;
/* 21 */     this.f_107215_ = 0.0D;
/* 22 */     this.f_107216_ = 0.0D;
/* 23 */     this.f_107217_ = 0.0D;
/* 24 */     this.f_107663_ = 1.0F;
/* 25 */     this.f_107225_ = 29;
/* 26 */     this.texture = (int)((AdvancedParticleOption)options).v0;
/*    */     
/* 28 */     this.f_107227_ = 1.0F;
/* 29 */     this.f_107228_ = 1.0F;
/* 30 */     this.f_107229_ = 1.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTexture() {
/* 35 */     return ModelBakery.f_119228_.get(this.texture);
/*    */   }
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public static class Provider implements ParticleProvider<AdvancedParticleOption> {
/*    */     private final SpriteSet sprites;
/*    */     
/*    */     public Provider(SpriteSet spriteSet) {
/* 43 */       this.sprites = spriteSet;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Particle createParticle(AdvancedParticleOption particleType, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
/* 49 */       return (Particle)new BlockBreakingParticle<>(level, x, y, z, this.sprites, dx, dy, dz, particleType);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\particles\BlockBreakingParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */