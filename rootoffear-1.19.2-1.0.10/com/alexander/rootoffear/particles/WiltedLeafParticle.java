/*     */ package com.alexander.rootoffear.particles;
/*     */ 
/*     */ import com.alexander.rootoffear.entities.Wilted;
/*     */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*     */ import com.mojang.math.Quaternion;
/*     */ import com.mojang.math.Vector3f;
/*     */ import java.awt.Color;
/*     */ import net.minecraft.Util;
/*     */ import net.minecraft.client.Camera;
/*     */ import net.minecraft.client.multiplayer.ClientLevel;
/*     */ import net.minecraft.client.particle.Particle;
/*     */ import net.minecraft.client.particle.ParticleProvider;
/*     */ import net.minecraft.client.particle.ParticleRenderType;
/*     */ import net.minecraft.client.particle.SpriteSet;
/*     */ import net.minecraft.client.particle.TextureSheetParticle;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ 
/*     */ public class WiltedLeafParticle<T extends AdvancedParticleOption>
/*     */   extends TextureSheetParticle {
/*  24 */   private static final Vector3f ROTATION_VECTOR = (Vector3f)Util.m_137469_(new Vector3f(0.5F, 0.5F, 0.5F), Vector3f::m_122278_);
/*  25 */   private static final Vector3f TRANSFORM_VECTOR = new Vector3f(-1.0F, -1.0F, 0.0F);
/*     */   private float rotSpeed;
/*     */   private final float particleRandom;
/*     */   private final float spinAcceleration;
/*     */   private final float landedHeightModifier;
/*     */   
/*     */   public WiltedLeafParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet, T particleOptions) {
/*  32 */     super(level, ((AdvancedParticleOption)particleOptions).v1, ((AdvancedParticleOption)particleOptions).v2, ((AdvancedParticleOption)particleOptions).v3);
/*  33 */     m_108335_(spriteSet);
/*  34 */     this.rotSpeed = (float)Math.toRadians(this.f_107223_.m_188499_() ? -30.0D : 30.0D);
/*  35 */     this.particleRandom = this.f_107223_.m_188501_();
/*  36 */     this.spinAcceleration = (float)Math.toRadians(this.f_107223_.m_188499_() ? -5.0D : 5.0D);
/*  37 */     this.f_107225_ = (((AdvancedParticleOption)particleOptions).v4 > 0.0D) ? (100 + this.f_107223_.m_188503_(100)) : 1200;
/*  38 */     this.f_107226_ = 0.01F;
/*  39 */     float size = 0.2F;
/*  40 */     this.f_107663_ = size;
/*  41 */     m_107250_(size, size);
/*  42 */     this.f_172258_ = 1.0F;
/*  43 */     this.f_107215_ = 0.0D;
/*  44 */     this.f_107216_ = 0.0D;
/*  45 */     this.f_107217_ = 0.0D;
/*  46 */     Color col = new Color((int)((AdvancedParticleOption)particleOptions).v0);
/*  47 */     this.f_107227_ = col.getRed() / 255.0F;
/*  48 */     this.f_107228_ = col.getGreen() / 255.0F;
/*  49 */     this.f_107229_ = col.getBlue() / 255.0F;
/*  50 */     this.landedHeightModifier = 0.001F + this.f_107223_.m_188501_() * 0.01F;
/*     */   }
/*     */   
/*     */   public ParticleRenderType m_7556_() {
/*  54 */     return ParticleRenderType.f_107430_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_5989_() {
/*  59 */     this.f_107209_ = this.f_107212_;
/*  60 */     this.f_107210_ = this.f_107213_;
/*  61 */     this.f_107211_ = this.f_107214_;
/*  62 */     if (this.f_107225_-- <= 0) {
/*  63 */       m_107274_();
/*     */     }
/*     */     
/*  66 */     if (!this.f_107220_) {
/*  67 */       if (this.f_107225_ < 1180) {
/*  68 */         float transitionSpeed = 0.05F;
/*  69 */         this.f_107227_ = Mth.m_14179_(transitionSpeed, this.f_107227_, Wilted.revealedLeafColour.getRed() / 255.0F);
/*  70 */         this.f_107228_ = Mth.m_14179_(transitionSpeed, this.f_107228_, Wilted.revealedLeafColour.getGreen() / 255.0F);
/*  71 */         this.f_107229_ = Mth.m_14179_(transitionSpeed, this.f_107229_, Wilted.revealedLeafColour.getBlue() / 255.0F);
/*     */       } 
/*  73 */       float f = (1200 - this.f_107225_);
/*  74 */       float f1 = Math.min(f / 1200.0F, 1.0F);
/*  75 */       double d0 = Math.cos(Math.toRadians((this.particleRandom * 60.0F))) * 2.0D * Math.pow(f1, 1.25D);
/*  76 */       double d1 = Math.sin(Math.toRadians((this.particleRandom * 60.0F))) * 2.0D * Math.pow(f1, 1.25D);
/*  77 */       this.f_107215_ += d0 * 0.0024999999441206455D;
/*  78 */       this.f_107217_ += d1 * 0.0024999999441206455D;
/*  79 */       this.f_107216_ -= this.f_107226_;
/*  80 */       if (!this.f_107218_) {
/*  81 */         this.rotSpeed += this.spinAcceleration / 20.0F;
/*     */       }
/*  83 */       this.f_107204_ = this.f_107231_;
/*  84 */       if (!this.f_107218_) {
/*  85 */         this.f_107231_ += this.rotSpeed / 20.0F;
/*     */       }
/*  87 */       m_6257_(this.f_107215_, this.f_107216_, this.f_107217_);
/*     */       
/*  89 */       if (!this.f_107220_) {
/*  90 */         this.f_107215_ *= this.f_172258_;
/*  91 */         this.f_107216_ *= this.f_172258_;
/*  92 */         this.f_107217_ *= this.f_172258_;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_5744_(VertexConsumer consumer, Camera camera, float partialTick) {
/*  99 */     if (this.f_107218_) {
/* 100 */       Vec3 vec3 = camera.m_90583_();
/* 101 */       float f = (float)(Mth.m_14139_(partialTick, this.f_107209_, this.f_107212_) - vec3.m_7096_());
/* 102 */       float f1 = (float)(Mth.m_14139_(partialTick, this.f_107210_, this.f_107213_) - vec3.m_7098_());
/* 103 */       float f2 = (float)(Mth.m_14139_(partialTick, this.f_107211_, this.f_107214_) - vec3.m_7094_());
/* 104 */       Quaternion quaternionf = new Quaternion(ROTATION_VECTOR, 0.0F, true);
/* 105 */       quaternionf.m_80148_(Vector3f.f_122223_.m_122270_((float)Math.toRadians(90.0D)));
/* 106 */       quaternionf.m_80148_(Vector3f.f_122227_.m_122270_(Mth.m_14179_(partialTick, this.f_107204_, this.f_107231_)));
/* 107 */       TRANSFORM_VECTOR.m_122251_(quaternionf);
/* 108 */       Vector3f[] avector3f = { new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F) };
/* 109 */       float f3 = m_5902_(partialTick);
/*     */       
/* 111 */       for (int i = 0; i < 4; i++) {
/* 112 */         Vector3f vector3f = avector3f[i];
/* 113 */         vector3f.m_122251_(quaternionf);
/* 114 */         vector3f.m_122261_(f3);
/* 115 */         vector3f.m_122272_(f, f1 + this.landedHeightModifier, f2);
/*     */       } 
/*     */       
/* 118 */       float f7 = m_5970_();
/* 119 */       float f8 = m_5952_();
/* 120 */       float f5 = m_5951_();
/* 121 */       float f6 = m_5950_();
/* 122 */       int j = m_6355_(partialTick);
/* 123 */       consumer.m_5483_(avector3f[0].m_122239_(), avector3f[0].m_122260_(), avector3f[0].m_122269_()).m_7421_(f8, f6).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(j).m_5752_();
/* 124 */       consumer.m_5483_(avector3f[1].m_122239_(), avector3f[1].m_122260_(), avector3f[1].m_122269_()).m_7421_(f8, f5).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(j).m_5752_();
/* 125 */       consumer.m_5483_(avector3f[2].m_122239_(), avector3f[2].m_122260_(), avector3f[2].m_122269_()).m_7421_(f7, f5).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(j).m_5752_();
/* 126 */       consumer.m_5483_(avector3f[3].m_122239_(), avector3f[3].m_122260_(), avector3f[3].m_122269_()).m_7421_(f7, f6).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(j).m_5752_();
/*     */     } else {
/* 128 */       super.m_5744_(consumer, camera, partialTick);
/*     */     } 
/*     */   }
/*     */   
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public static class Provider implements ParticleProvider<AdvancedParticleOption> {
/*     */     private final SpriteSet sprites;
/*     */     
/*     */     public Provider(SpriteSet spriteSet) {
/* 137 */       this.sprites = spriteSet;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Particle createParticle(AdvancedParticleOption particleOptions, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
/* 143 */       return (Particle)new WiltedLeafParticle<>(level, x, y, z, this.sprites, particleOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\particles\WiltedLeafParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */