/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import com.alexander.rootoffear.utils.PositionUtils;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.level.LightLayer;
/*    */ 
/*    */ 
/*    */ public class WiltedTeleportToMoveTargetGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   public int nextUseTime;
/*    */   
/*    */   public WiltedTeleportToMoveTargetGoal(Wilted mob) {
/* 19 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 20 */     this.mob = mob;
/*    */   }
/*    */   
/*    */   public boolean m_183429_() {
/* 24 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 29 */     return (this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && this.mob.m_21573_().m_26572_() && !this.mob.isBrightEnoughToBurn() && this.mob.f_19853_.m_45517_(LightLayer.BLOCK, this.mob.m_21573_().m_26567_()) < 3 && PositionUtils.hasLineOfSight((Entity)this.mob, this.mob.m_21573_().m_26567_().m_7494_()));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 34 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 39 */     this.mob.teleportTargetPos = this.mob.m_21573_().m_26567_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 44 */     super.m_8041_();
/* 45 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(40, 600);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedTeleportToMoveTargetGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */