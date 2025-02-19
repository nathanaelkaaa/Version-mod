/*     */ package com.alexander.rootoffear.entities;
/*     */ 
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.AnimationState;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.level.Level;
/*     */ 
/*     */ public abstract class AbstractHurtableEntity extends Entity {
/*  14 */   public int remainingHits = maxHits();
/*     */   public int hurtCooldown;
/*  16 */   public int lifeTime = 0;
/*     */   public boolean killed = false;
/*     */   
/*     */   public AbstractHurtableEntity(EntityType<?> p_19870_, Level p_19871_) {
/*  20 */     super(p_19870_, p_19871_);
/*     */   }
/*     */   
/*     */   public abstract int maxHits();
/*     */   
/*     */   public abstract int hurtCooldown();
/*     */   
/*     */   public abstract int maxLifeTime();
/*     */   
/*     */   public abstract AnimationState hurtAnimationState();
/*     */   
/*     */   public boolean discardAfterLifeTimeReached() {
/*  32 */     return false;
/*     */   }
/*     */   
/*     */   public SoundEvent hurtSound() {
/*  36 */     return null;
/*     */   }
/*     */   
/*     */   public float getSoundVolume() {
/*  40 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float getVoicePitch() {
/*  44 */     return (this.f_19796_.m_188501_() - this.f_19796_.m_188501_()) * 0.2F + 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(DamageSource source, float amount) {
/*  49 */     if (!this.f_19853_.m_5776_() && !m_6673_(source) && amount > 0.0F && this.hurtCooldown <= 0) {
/*  50 */       this.f_19853_.m_7605_(this, (byte)4);
/*  51 */       this.remainingHits--;
/*  52 */       this.hurtCooldown = hurtCooldown();
/*  53 */       if (hurtSound() != null) {
/*  54 */         m_5496_(hurtSound(), getSoundVolume(), getVoicePitch());
/*     */       }
/*  56 */       return true;
/*     */     } 
/*  58 */     return super.m_6469_(source, amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6673_(DamageSource source) {
/*  63 */     return (super.m_6673_(source) || this.killed);
/*     */   }
/*     */   
/*     */   public void updateHurtable() {
/*  67 */     if (!this.f_19853_.m_5776_() && !this.killed && this.remainingHits <= 0 && this.hurtCooldown <= Math.max(0, hurtCooldown() - 5)) {
/*  68 */       onKilled();
/*  69 */       this.killed = true;
/*  70 */       this.f_19853_.m_7605_(this, (byte)6);
/*     */     } 
/*     */     
/*  73 */     if (this.hurtCooldown > 0) {
/*  74 */       this.hurtCooldown--;
/*     */     }
/*     */     
/*  77 */     if (this.lifeTime > maxLifeTime()) {
/*  78 */       if (discardAfterLifeTimeReached()) {
/*  79 */         m_146870_();
/*  80 */       } else if (this.f_19797_ % 40 == 0) {
/*  81 */         m_6469_(DamageSource.f_19313_, 1.0F);
/*     */       } 
/*     */     }
/*     */     
/*  85 */     this.lifeTime++;
/*     */   }
/*     */   
/*     */   public void onKilled() {
/*  89 */     this.f_19853_.m_7605_(this, (byte)5);
/*  90 */     m_6074_();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7822_(byte event) {
/*  95 */     if (event == 4) {
/*  96 */       if (hurtAnimationState() != null) {
/*  97 */         hurtAnimationState().m_216977_(this.f_19797_);
/*     */       }
/*  99 */       this.hurtCooldown = hurtCooldown() / 2;
/* 100 */     } else if (event == 5) {
/* 101 */       for (int i = 0; i < 20; i++) {
/* 102 */         double d0 = this.f_19796_.m_188583_() * 0.02D;
/* 103 */         double d1 = this.f_19796_.m_188583_() * 0.02D;
/* 104 */         double d2 = this.f_19796_.m_188583_() * 0.02D;
/* 105 */         this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123759_, m_20208_(1.0D), m_20187_(), m_20262_(1.0D), d0, d1, d2);
/*     */       } 
/* 107 */     } else if (event == 6) {
/* 108 */       this.killed = true;
/*     */     } else {
/* 110 */       super.m_7822_(event);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7378_(CompoundTag tag) {
/* 116 */     if (tag.m_128441_("RemainingHits"))
/* 117 */       this.remainingHits = tag.m_128451_("RemainingHits"); 
/* 118 */     if (tag.m_128441_("LifeTime"))
/* 119 */       this.lifeTime = tag.m_128451_("LifeTime"); 
/* 120 */     if (tag.m_128441_("Killed")) {
/* 121 */       this.killed = tag.m_128471_("Killed");
/*     */     }
/*     */   }
/*     */   
/*     */   protected void m_7380_(CompoundTag tag) {
/* 126 */     tag.m_128405_("RemainingHits", this.remainingHits);
/* 127 */     tag.m_128405_("LifeTime", this.lifeTime);
/* 128 */     tag.m_128379_("Killed", this.killed);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6087_() {
/* 133 */     return !m_213877_();
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\entities\AbstractHurtableEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */