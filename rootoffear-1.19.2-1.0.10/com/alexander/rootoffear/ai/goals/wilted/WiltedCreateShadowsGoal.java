/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.ShadowWilted;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.init.EntityTypeInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ public class WiltedCreateShadowsGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   public int nextUseTime;
/*    */   public boolean lookedAt;
/* 23 */   public BlockPos pos = null;
/*    */   
/*    */   public WiltedCreateShadowsGoal(Wilted mob) {
/* 26 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 27 */     this.mob = mob;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 32 */     boolean wasLookedAt = this.lookedAt;
/* 33 */     this.lookedAt = false;
/* 34 */     for (Player player : this.mob.f_19853_.m_6907_()) {
/* 35 */       if (this.mob.isLookingAtMe(player) && MiscUtils.inSurvivalMode((LivingEntity)player)) {
/* 36 */         this.lookedAt = true;
/*    */         break;
/*    */       } 
/*    */     } 
/* 40 */     if (this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && MiscUtils.isEntityValid(this.mob.m_5448_()) && this.mob.f_19797_ >= this.nextUseTime && !this.mob.isBrightEnoughToBurn() && this.mob.m_20096_()) {
/* 41 */       if (!this.lookedAt && wasLookedAt) {
/* 42 */         this.pos = Wilted.findSpawnablePosition(this.mob.m_20183_(), (ServerLevel)this.mob.f_19853_, 15, 25, 15, 50, false);
/* 43 */         return (this.pos != null);
/*    */       } 
/* 45 */       return false;
/*    */     } 
/*    */     
/* 48 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 54 */     super.m_8056_();
/* 55 */     if (this.pos != null) {
/* 56 */       this.mob.f_19853_.m_7605_((Entity)this.mob, (byte)17);
/* 57 */       for (int i = 0; i < 5; i++) {
/* 58 */         ShadowWilted shadow = (ShadowWilted)((EntityType)EntityTypeInit.SHADOW_WILTED.get()).m_20615_(this.mob.f_19853_);
/* 59 */         shadow.m_20035_(this.mob.m_20183_(), 0.0F, 0.0F);
/* 60 */         shadow.ownerID = this.mob.m_20148_();
/* 61 */         shadow.m_21051_(Attributes.f_22279_).m_22100_(0.125D + shadow.m_217043_().m_188501_() * 0.175D);
/* 62 */         this.mob.f_19853_.m_7967_((Entity)shadow);
/*    */       } 
/* 64 */       this.mob.teleportTargetPos = this.pos;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 70 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_183429_() {
/* 75 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 80 */     super.m_8041_();
/* 81 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(400, 800);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedCreateShadowsGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */