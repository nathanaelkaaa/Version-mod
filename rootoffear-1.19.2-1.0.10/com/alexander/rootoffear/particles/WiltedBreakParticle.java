/*     */ package com.alexander.rootoffear.particles;
/*     */ 
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.multiplayer.ClientLevel;
/*     */ import net.minecraft.client.particle.Particle;
/*     */ import net.minecraft.client.particle.ParticleProvider;
/*     */ import net.minecraft.client.particle.ParticleRenderType;
/*     */ import net.minecraft.client.particle.SpriteSet;
/*     */ import net.minecraft.client.particle.TextureSheetParticle;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.SimpleParticleType;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ 
/*     */ public class WiltedBreakParticle
/*     */   extends TextureSheetParticle
/*     */ {
/*     */   private final float uo;
/*     */   private final float vo;
/*     */   private final double targetX;
/*     */   private final double targetZ;
/*     */   private final boolean isMoving;
/*     */   private final float movementSpeedMultiplier;
/*     */   
/*     */   protected WiltedBreakParticle(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd) {
/*  31 */     super(level, xCoord, yCoord, zCoord, xd, yd, zd);
/*     */     
/*  33 */     this.f_107226_ = 1.0F;
/*  34 */     this.f_107663_ /= 2.0F;
/*  35 */     this.uo = this.f_107223_.m_188501_() * 3.0F;
/*  36 */     this.vo = this.f_107223_.m_188501_() * 3.0F;
/*  37 */     this.f_107215_ = 0.0D;
/*  38 */     this.f_107216_ = 0.0D;
/*  39 */     this.f_107217_ = 0.0D;
/*  40 */     this.targetX = xd;
/*  41 */     this.isMoving = (yd > 0.0D);
/*  42 */     this.targetZ = zd;
/*  43 */     if (this.isMoving) {
/*  44 */       this.f_107225_ = 200;
/*     */     }
/*  46 */     m_108337_(spriteSet.m_5819_(this.isMoving ? 1 : 0, 1));
/*  47 */     this.movementSpeedMultiplier = 0.01F + this.f_107223_.m_188501_() * 0.04F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int m_6355_(float p_107249_) {
/*  52 */     return this.isMoving ? 255 : super.m_6355_(p_107249_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_5989_() {
/*  57 */     if (this.isMoving && this.f_107218_) {
/*  58 */       double distance = PositionUtils.distanceTo(getPos(), new Vec3(this.targetX, this.f_107213_, this.targetZ));
/*  59 */       this.f_107215_ = (this.targetX - this.f_107212_) / distance * this.movementSpeedMultiplier;
/*  60 */       this.f_107217_ = (this.targetZ - this.f_107214_) / distance * this.movementSpeedMultiplier;
/*  61 */       if (distance <= 0.05D) {
/*  62 */         m_107274_();
/*     */       }
/*     */     } 
/*  65 */     super.m_5989_();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6257_(double p_107246_, double p_107247_, double p_107248_) {
/*  70 */     double d0 = p_107246_;
/*  71 */     double d1 = p_107247_;
/*  72 */     double d2 = p_107248_;
/*  73 */     if (this.f_107219_ && (p_107246_ != 0.0D || p_107247_ != 0.0D || p_107248_ != 0.0D) && p_107246_ * p_107246_ + p_107247_ * p_107247_ + p_107248_ * p_107248_ < 
/*  74 */       Mth.m_144952_(100.0D)) {
/*  75 */       Vec3 vec3 = Entity.m_198894_((Entity)null, new Vec3(p_107246_, p_107247_, p_107248_), 
/*  76 */           m_107277_(), (Level)this.f_107208_, List.of());
/*  77 */       p_107246_ = vec3.f_82479_;
/*  78 */       p_107247_ = vec3.f_82480_;
/*  79 */       p_107248_ = vec3.f_82481_;
/*     */     } 
/*     */     
/*  82 */     if (p_107246_ != 0.0D || p_107247_ != 0.0D || p_107248_ != 0.0D) {
/*  83 */       m_107259_(m_107277_().m_82386_(p_107246_, p_107247_, p_107248_));
/*  84 */       m_107275_();
/*     */     } 
/*     */     
/*  87 */     this.f_107218_ = (d1 != p_107247_ && d1 < 0.0D);
/*  88 */     if (d0 != p_107246_) {
/*  89 */       this.f_107215_ = 0.0D;
/*     */     }
/*     */     
/*  92 */     if (d2 != p_107248_) {
/*  93 */       this.f_107217_ = 0.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleRenderType m_7556_() {
/*  99 */     return ParticleRenderType.f_107431_;
/*     */   }
/*     */   
/*     */   protected float m_5970_() {
/* 103 */     return this.f_108321_.m_118367_(((this.uo + 1.0F) / 4.0F * 16.0F));
/*     */   }
/*     */   
/*     */   protected float m_5952_() {
/* 107 */     return this.f_108321_.m_118367_((this.uo / 4.0F * 16.0F));
/*     */   }
/*     */   
/*     */   protected float m_5951_() {
/* 111 */     return this.f_108321_.m_118393_((this.vo / 4.0F * 16.0F));
/*     */   }
/*     */   
/*     */   protected float m_5950_() {
/* 115 */     return this.f_108321_.m_118393_(((this.vo + 1.0F) / 4.0F * 16.0F));
/*     */   }
/*     */   
/*     */   public Vec3 getPos() {
/* 119 */     return new Vec3(this.f_107212_, this.f_107213_, this.f_107214_);
/*     */   }
/*     */   
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public static class Provider implements ParticleProvider<SimpleParticleType> {
/*     */     private final SpriteSet sprites;
/*     */     
/*     */     public Provider(SpriteSet spriteSet) {
/* 127 */       this.sprites = spriteSet;
/*     */     }
/*     */ 
/*     */     
/*     */     public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
/* 132 */       return (Particle)new WiltedBreakParticle(level, x, y, z, this.sprites, dx, dy, dz);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\particles\WiltedBreakParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */