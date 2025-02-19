/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.entities.WiltedSpear;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Pose;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedSpearGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   @Nullable
/*    */   public LivingEntity target;
/*    */   public int nextUseTime;
/*    */   public int useTicks;
/*    */   
/*    */   public WiltedSpearGoal(Wilted mob) {
/* 26 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 27 */     this.mob = mob;
/* 28 */     this.target = mob.m_5448_();
/*    */   }
/*    */   
/*    */   public boolean m_183429_() {
/* 32 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 37 */     this.target = this.mob.m_5448_();
/* 38 */     return (!this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && MiscUtils.isEntityValid(this.target));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 43 */     return (this.useTicks <= 100);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 48 */     this.target = this.mob.m_5448_();
/* 49 */     this.mob.startAnimation(7);
/* 50 */     this.mob.m_20124_(Pose.SPIN_ATTACK);
/* 51 */     this.useTicks = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_6767_() {
/* 56 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 61 */     this.target = this.mob.m_5448_();
/*    */     
/* 63 */     this.mob.m_21573_().m_26573_();
/*    */     
/* 65 */     if (MiscUtils.isEntityValid(this.target) && 
/* 66 */       this.useTicks > 10 && this.useTicks % 5 == 0 && this.mob.m_217043_().m_188499_() && this.useTicks <= 90) {
/* 67 */       this.mob.f_19853_.m_7967_((Entity)new WiltedSpear(this.mob.f_19853_, this.target.m_20182_().m_82520_((this.target.m_20185_() - this.target.f_19790_) * 20.0D, 0.0D, (this.target.m_20189_() - this.target.f_19792_) * 20.0D), this.mob.m_217043_().m_188501_() * 360.0F, 10, (Entity)this.mob));
/*    */     }
/*    */ 
/*    */     
/* 71 */     this.useTicks++;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 76 */     super.m_8041_();
/* 77 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(200, 600);
/* 78 */     this.mob.m_20124_(Pose.STANDING);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedSpearGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */