/*    */ package com.alexander.rootoffear.ai.goals;
/*    */ 
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.PathfinderMob;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
/*    */ 
/*    */ public class ApproachTargetGoal
/*    */   extends MeleeAttackGoal
/*    */ {
/*    */   public double distanceToApproachTo;
/*    */   
/*    */   public ApproachTargetGoal(PathfinderMob attackingMob, double distanceToApproachTo, double moveSpeed, boolean shouldFollowUnseenTarget) {
/* 16 */     super(attackingMob, moveSpeed, shouldFollowUnseenTarget);
/* 17 */     m_7021_(EnumSet.of(Goal.Flag.MOVE));
/* 18 */     this.distanceToApproachTo = distanceToApproachTo;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_6767_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public boolean m_8036_() {
/* 27 */     return (super.m_8036_() && (this.f_25540_.m_20270_((Entity)this.f_25540_.m_5448_()) >= this.distanceToApproachTo || 
/* 28 */       !this.f_25540_.m_142582_((Entity)this.f_25540_.m_5448_())));
/*    */   }
/*    */   
/*    */   public boolean m_8045_() {
/* 32 */     return (super.m_8045_() && (this.f_25540_.m_20270_((Entity)this.f_25540_.m_5448_()) >= this.distanceToApproachTo || 
/* 33 */       !this.f_25540_.m_142582_((Entity)this.f_25540_.m_5448_())));
/*    */   }
/*    */   
/*    */   protected double m_6639_(LivingEntity p_179512_1_) {
/* 37 */     return 0.0D;
/*    */   }
/*    */   
/*    */   protected void m_6739_(LivingEntity p_25557_, double p_25558_) {}
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\ApproachTargetGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */