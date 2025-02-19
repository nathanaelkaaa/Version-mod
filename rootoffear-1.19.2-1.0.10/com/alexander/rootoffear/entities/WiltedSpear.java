/*    */ package com.alexander.rootoffear.entities;
/*    */ 
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.network.protocol.Packet;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.entity.AnimationState;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.network.NetworkHooks;
/*    */ 
/*    */ public class WiltedSpear
/*    */   extends Entity
/*    */ {
/* 17 */   public AnimationState spearAnimationState = new AnimationState();
/*    */   public int delay;
/*    */   public Entity owner;
/*    */   
/*    */   public WiltedSpear(EntityType<? extends WiltedSpear> type, Level level) {
/* 22 */     super(type, level);
/*    */   }
/*    */   
/*    */   public WiltedSpear(Level level, Vec3 pos, float yRot, int delay, Entity owner) {
/* 26 */     this((EntityType<? extends WiltedSpear>)null, level);
/* 27 */     m_146884_(pos);
/* 28 */     m_146922_(yRot);
/* 29 */     this.delay = delay;
/* 30 */     this.owner = owner;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void m_7822_(byte event) {
/* 36 */     if (event == 4) {
/* 37 */       this.spearAnimationState.m_216982_(this.f_19797_);
/*    */     } else {
/* 39 */       super.m_7822_(event);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8119_() {
/* 45 */     super.m_8119_();
/* 46 */     if (!this.f_19853_.m_5776_()) {
/* 47 */       if (this.f_19797_ == this.delay) {
/* 48 */         this.f_19853_.m_7605_(this, (byte)4);
/*    */         
/* 50 */         for (LivingEntity entity : this.f_19853_.m_45976_(LivingEntity.class, m_20191_())) {
/* 51 */           entity.m_6469_(DamageSource.m_19337_(this, this.owner), 8.0F);
/*    */         }
/*    */       } 
/*    */       
/* 55 */       if (this.f_19797_ > this.delay + 20) {
/* 56 */         m_146870_();
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Packet<?> m_5654_() {
/* 63 */     return NetworkHooks.getEntitySpawningPacket(this);
/*    */   }
/*    */   
/*    */   protected void m_8097_() {}
/*    */   
/*    */   protected void m_7378_(CompoundTag p_20052_) {}
/*    */   
/*    */   protected void m_7380_(CompoundTag p_20139_) {}
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\entities\WiltedSpear.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */