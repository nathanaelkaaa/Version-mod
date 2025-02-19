/*     */ package com.alexander.rootoffear.entities;
/*     */ 
/*     */ import com.alexander.rootoffear.init.EntityTypeInit;
/*     */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.AnimationState;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ 
/*     */ public class WiltedBarrier
/*     */   extends AbstractHurtableEntity
/*     */ {
/*  20 */   public AnimationState emergeAnimationState = new AnimationState();
/*     */   
/*     */   public WiltedBarrier(EntityType<? extends WiltedBarrier> type, Level level) {
/*  23 */     super(type, level);
/*  24 */     m_146922_(this.f_19796_.m_188501_() * 360.0F);
/*     */   }
/*     */   
/*     */   public WiltedBarrier(Level level, Vec3 pos) {
/*  28 */     this((EntityType<? extends WiltedBarrier>)EntityTypeInit.WILTED_BARRIER.get(), level);
/*  29 */     m_6027_(Mth.m_14107_(pos.f_82479_) + 0.5D, Mth.m_14107_(pos.f_82480_), Mth.m_14107_(pos.f_82481_) + 0.5D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7822_(byte event) {
/*  34 */     if (event == 5) {
/*  35 */       for (int i = 0; i < 200; i++) {
/*  36 */         this.f_19853_.m_7107_((ParticleOptions)ParticleTypeInit.WILTED_BREAK.get(), m_20208_(0.85D), m_20187_(), m_20262_(0.85D), 0.0D, 0.0D, 0.0D);
/*     */       }
/*  38 */     } else if (event == 7) {
/*  39 */       this.emergeAnimationState.m_216977_(this.f_19797_);
/*     */     } else {
/*  41 */       super.m_7822_(event);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundEvent hurtSound() {
/*  47 */     return (SoundEvent)SoundEventInit.WILTED_SWAY.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3 m_7371_(float p_20309_) {
/*  52 */     double d0 = Mth.m_14139_(p_20309_, this.f_19854_, m_20185_());
/*  53 */     double d1 = Mth.m_14139_(p_20309_, this.f_19855_, m_20186_()) + 0.1D;
/*  54 */     double d2 = Mth.m_14139_(p_20309_, this.f_19856_, m_20189_());
/*  55 */     return new Vec3(d0, d1, d2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  60 */     super.m_8119_();
/*     */     
/*  62 */     updateHurtable();
/*     */     
/*  64 */     m_6027_(Mth.m_14107_(m_20185_()) + 0.5D, Mth.m_14107_(m_20186_()), Mth.m_14107_(m_20189_()) + 0.5D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onKilled() {
/*  69 */     m_5496_((SoundEvent)SoundEventInit.WILTED_STEP.get(), getSoundVolume(), getVoicePitch() * 1.5F);
/*  70 */     m_5496_((SoundEvent)SoundEventInit.WILTED_SWAY.get(), getSoundVolume(), getVoicePitch() / 4.0F);
/*  71 */     super.onKilled();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_5829_() {
/*  76 */     return (!m_213877_() && !this.killed && this.f_19853_.m_6249_(this, m_20191_().m_82400_(1.0E-7D), entity -> (entity instanceof Wilted || entity instanceof ShadowWilted)).size() <= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Packet<?> m_5654_() {
/*  81 */     return NetworkHooks.getEntitySpawningPacket(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxHits() {
/*  86 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hurtCooldown() {
/*  91 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxLifeTime() {
/*  96 */     return 600;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnimationState hurtAnimationState() {
/* 101 */     return null;
/*     */   }
/*     */   
/*     */   protected void m_8097_() {}
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\entities\WiltedBarrier.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */