/*     */ package com.alexander.rootoffear.particles;
/*     */ 
/*     */ import com.alexander.rootoffear.entities.Wilted;
/*     */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.multiplayer.ClientLevel;
/*     */ import net.minecraft.client.particle.Particle;
/*     */ import net.minecraft.client.particle.ParticleProvider;
/*     */ import net.minecraft.client.particle.ParticleRenderType;
/*     */ import net.minecraft.client.particle.SpriteSet;
/*     */ import net.minecraft.client.particle.TextureSheetParticle;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LeafStormParticle<T extends AdvancedParticleOption>
/*     */   extends TextureSheetParticle
/*     */ {
/*     */   private float rollSpeed;
/*     */   private double circleRange;
/*     */   private float circleProgress;
/*     */   private float circleSpeed;
/*     */   private int followedEntityID;
/*     */   private Vec3 circleCentrePos;
/*     */   private double yOffset;
/*     */   public double startX;
/*     */   public double startY;
/*     */   public double startZ;
/*  35 */   public float lerp = 0.0F;
/*     */ 
/*     */   
/*     */   protected LeafStormParticle(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd, T particleOptions) {
/*  39 */     super(level, xCoord, yCoord, zCoord, xd, yd, zd);
/*  40 */     this.startX = xCoord;
/*  41 */     this.startY = yCoord;
/*  42 */     this.startZ = zCoord;
/*  43 */     this.circleRange = 0.5D + (this.f_107223_.m_188501_() * 5.0F);
/*  44 */     this.circleProgress = this.f_107223_.m_188501_() * 360.0F;
/*  45 */     this.circleSpeed = this.f_107223_.m_188501_() * 0.25F;
/*  46 */     this.followedEntityID = (int)((AdvancedParticleOption)particleOptions).v0;
/*  47 */     this.rollSpeed = this.f_107223_.m_188501_() * 0.1F;
/*  48 */     this.f_172258_ = 0.8F;
/*  49 */     this.f_107663_ = 0.2F;
/*  50 */     this.f_107225_ = 100 + this.f_107223_.m_188503_(200);
/*  51 */     this.yOffset = this.f_107223_.m_188500_() * 3.0D;
/*  52 */     this.f_107230_ = 0.0F;
/*  53 */     this.f_107227_ = Wilted.revealedLeafColour.getRed() / 255.0F;
/*  54 */     this.f_107228_ = Wilted.revealedLeafColour.getGreen() / 255.0F;
/*  55 */     this.f_107229_ = Wilted.revealedLeafColour.getBlue() / 255.0F;
/*  56 */     m_108335_(spriteSet);
/*     */     
/*  58 */     this.circleCentrePos = new Vec3(this.f_107212_, this.f_107213_, this.f_107214_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_5989_() {
/*  63 */     super.m_5989_();
/*  64 */     m_107264_(Mth.m_14139_(this.lerp, this.startX, this.circleCentrePos.f_82479_ + this.circleRange * Mth.m_14089_(this.circleProgress)), Mth.m_14139_(this.lerp, this.startY, this.circleCentrePos.f_82480_), Mth.m_14139_(this.lerp, this.startZ, this.f_107214_ = this.circleCentrePos.f_82481_ + this.circleRange * Mth.m_14031_(this.circleProgress)));
/*     */     
/*  66 */     this.lerp = Mth.m_14179_(0.1F, this.lerp, 1.0F);
/*     */     
/*  68 */     this.circleProgress += this.circleSpeed;
/*  69 */     this.f_107204_ = this.f_107231_;
/*  70 */     this.f_107231_ += this.rollSpeed;
/*  71 */     if (this.f_107224_ <= 2) {
/*  72 */       this.f_107230_ = 0.0F;
/*     */     } else {
/*  74 */       this.f_107230_ = 1.0F;
/*     */     } 
/*     */     
/*  77 */     if (this.followedEntityID != 0 && this.f_107208_.m_6815_(this.followedEntityID) == null) {
/*  78 */       m_107274_();
/*     */     }
/*     */     
/*  81 */     if (this.followedEntityID != 0 && this.f_107208_.m_6815_(this.followedEntityID) != null) {
/*  82 */       Entity entity = this.f_107208_.m_6815_(this.followedEntityID);
/*  83 */       this.circleCentrePos = entity.m_20182_().m_82520_(0.0D, entity.m_20206_() * this.yOffset - (entity.m_20206_() / 2.0F), 0.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_107274_() {
/*  89 */     super.m_107274_();
/*  90 */     this.f_107208_.m_7107_(new AdvancedParticleOption(ParticleTypeInit.WILTED_LEAF, 
/*  91 */           List.of(
/*  92 */             Double.valueOf(Wilted.revealedLeafColour.getRGB()), 
/*  93 */             Double.valueOf(this.f_107212_), 
/*  94 */             Double.valueOf(this.f_107213_), 
/*  95 */             Double.valueOf(this.f_107214_), 
/*  96 */             Double.valueOf(1.0D))), this.f_107212_, this.f_107213_, this.f_107214_, 0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ParticleRenderType m_7556_() {
/* 102 */     return ParticleRenderType.f_107431_;
/*     */   }
/*     */   
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public static class Provider implements ParticleProvider<AdvancedParticleOption> {
/*     */     private final SpriteSet sprites;
/*     */     
/*     */     public Provider(SpriteSet spriteSet) {
/* 110 */       this.sprites = spriteSet;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Particle createParticle(AdvancedParticleOption particleOptions, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
/* 116 */       return (Particle)new LeafStormParticle<>(level, x, y, z, this.sprites, dx, dy, dz, particleOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\particles\LeafStormParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */