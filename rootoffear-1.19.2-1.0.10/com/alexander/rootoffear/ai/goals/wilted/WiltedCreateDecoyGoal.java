/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.DecoyWilted;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ public class WiltedCreateDecoyGoal
/*    */   extends Goal {
/*    */   public Wilted mob;
/*    */   public int nextUseTime;
/*    */   public boolean lookedAt;
/* 19 */   public BlockPos pos = null;
/*    */   
/*    */   public WiltedCreateDecoyGoal(Wilted mob) {
/* 22 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 23 */     this.mob = mob;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 28 */     boolean wasLookedAt = this.lookedAt;
/* 29 */     this.lookedAt = false;
/* 30 */     for (Player player : this.mob.f_19853_.m_6907_()) {
/* 31 */       if (this.mob.isLookingAtMe(player) && MiscUtils.inSurvivalMode((LivingEntity)player)) {
/* 32 */         this.lookedAt = true;
/*    */         break;
/*    */       } 
/*    */     } 
/* 36 */     if (this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && MiscUtils.isEntityValid(this.mob.m_5448_()) && this.mob.f_19797_ >= this.nextUseTime && !this.mob.isBrightEnoughToBurn() && this.mob.m_20096_()) {
/* 37 */       if (this.lookedAt && !wasLookedAt) {
/* 38 */         this.pos = Wilted.findSpawnablePosition(this.mob.m_20183_(), (ServerLevel)this.mob.f_19853_, 15, 25, 15, 50, false);
/* 39 */         return (this.pos != null);
/*    */       } 
/* 41 */       return false;
/*    */     } 
/*    */     
/* 44 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 50 */     super.m_8056_();
/* 51 */     if (this.pos != null) {
/* 52 */       this.mob.f_19853_.m_7605_((Entity)this.mob, (byte)17);
/* 53 */       this.mob.f_19853_.m_7967_((Entity)new DecoyWilted(this.mob.f_19853_, this.mob.m_20182_(), this.mob.f_20885_));
/* 54 */       this.mob.teleportTargetPos = this.pos;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 60 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_183429_() {
/* 65 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 70 */     super.m_8041_();
/* 71 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(400, 800);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedCreateDecoyGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */