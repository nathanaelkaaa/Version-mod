/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedApproachUltimateTargetGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   @Nullable
/*    */   public LivingEntity target;
/*    */   public int nextUseTime;
/*    */   
/*    */   public WiltedApproachUltimateTargetGoal(Wilted mob) {
/* 22 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 23 */     this.mob = mob;
/* 24 */     this.target = mob.getUltimateTarget();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 29 */     this.target = this.mob.getUltimateTarget();
/* 30 */     return (!MiscUtils.isEntityValid(this.mob.m_5448_()) && MiscUtils.inSurvivalMode(this.target));
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 35 */     this.target = this.mob.getUltimateTarget();
/* 36 */     if (MiscUtils.inSurvivalMode(this.target)) {
/* 37 */       this.mob.targetMovementSpeed = 0.7D;
/* 38 */       this.mob.m_21573_().m_5624_((Entity)this.target, 1.0D);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedApproachUltimateTargetGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */