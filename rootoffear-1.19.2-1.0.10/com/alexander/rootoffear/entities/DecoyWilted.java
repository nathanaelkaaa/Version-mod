/*    */ package com.alexander.rootoffear.entities;
/*    */ 
/*    */ import com.alexander.rootoffear.init.EntityTypeInit;
/*    */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.network.protocol.Packet;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.entity.AnimationState;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.MoverType;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.network.NetworkHooks;
/*    */ 
/*    */ public class DecoyWilted
/*    */   extends AbstractHurtableEntity {
/*    */   public DecoyWilted(EntityType<? extends DecoyWilted> type, Level level) {
/* 20 */     super(type, level);
/* 21 */     this.f_19794_ = false;
/*    */   }
/*    */   
/*    */   public DecoyWilted(Level level, Vec3 pos, float yRot) {
/* 25 */     this((EntityType<? extends DecoyWilted>)EntityTypeInit.DECOY_WILTED.get(), level);
/* 26 */     m_146884_(pos);
/* 27 */     m_146922_(yRot);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_7822_(byte event) {
/* 32 */     if (event == 5) {
/* 33 */       for (int i = 0; i < 500; i++) {
/* 34 */         this.f_19853_.m_7107_((ParticleOptions)ParticleTypeInit.WILTED_BREAK.get(), m_20208_(0.85D), m_20187_(), m_20262_(0.85D), 0.0D, 0.0D, 0.0D);
/*    */       }
/*    */     } else {
/* 37 */       super.m_7822_(event);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8119_() {
/* 43 */     super.m_8119_();
/* 44 */     updateHurtable();
/* 45 */     m_20334_((m_20184_()).f_82479_ * 0.6D, m_20096_() ? 0.0D : ((m_20184_()).f_82480_ - 0.08D), (m_20184_()).f_82481_ * 0.6D);
/* 46 */     m_6478_(MoverType.SELF, m_20184_());
/* 47 */     m_20101_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onKilled() {
/* 52 */     m_5496_((SoundEvent)SoundEventInit.WILTED_STEP.get(), getSoundVolume(), getVoicePitch() * 1.5F);
/* 53 */     m_5496_((SoundEvent)SoundEventInit.WILTED_SWAY.get(), getSoundVolume(), getVoicePitch() / 4.0F);
/* 54 */     super.onKilled();
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_7334_(Entity entity) {
/* 59 */     if (!(entity instanceof Wilted)) {
/* 60 */       super.m_7334_(entity);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_6094_() {
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public Packet<?> m_5654_() {
/* 71 */     return NetworkHooks.getEntitySpawningPacket(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int maxHits() {
/* 76 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hurtCooldown() {
/* 81 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int maxLifeTime() {
/* 86 */     return 600;
/*    */   }
/*    */ 
/*    */   
/*    */   public AnimationState hurtAnimationState() {
/* 91 */     return null;
/*    */   }
/*    */   
/*    */   protected void m_8097_() {}
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\entities\DecoyWilted.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */