/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ public class WiltedFreezeWhenLookedAtGoal
/*    */   extends Goal {
/*    */   public Wilted mob;
/*    */   public Player looker;
/*    */   public int lookedAtFor;
/* 18 */   public double lastTeleportDistance = 0.0D;
/*    */   
/*    */   public WiltedFreezeWhenLookedAtGoal(Wilted mob) {
/* 21 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 22 */     this.mob = mob;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 27 */     this.looker = null;
/* 28 */     for (Player player : this.mob.f_19853_.m_6907_()) {
/* 29 */       if (this.mob.isLookingAtMe(player) && MiscUtils.inSurvivalMode((LivingEntity)player)) {
/* 30 */         this.looker = player;
/*    */         break;
/*    */       } 
/*    */     } 
/* 34 */     return (this.mob.isDisguised() && this.looker != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_183429_() {
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 44 */     this.mob.m_21573_().m_26573_();
/* 45 */     this.mob.m_20334_(0.0D, (this.mob.m_20184_()).f_82480_, 0.0D);
/* 46 */     if (this.lookedAtFor++ > 100 && this.mob.m_217043_().m_188503_(20) == 0) {
/* 47 */       if (this.lastTeleportDistance == 0.0D) {
/* 48 */         this.lastTeleportDistance = this.mob.m_20270_((Entity)this.looker);
/*    */       }
/*    */       
/* 51 */       int distance = Mth.m_14107_(Math.min(this.lastTeleportDistance, this.mob.m_20270_((Entity)this.looker))) - 10;
/* 52 */       this.mob.teleportTargetPos = Wilted.findSpawnablePosition(this.looker.m_20183_(), (ServerLevel)this.mob.f_19853_, distance - 10, distance, 0, 20, true);
/* 53 */       this.lookedAtFor = 0;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedFreezeWhenLookedAtGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */