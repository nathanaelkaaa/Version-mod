/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import com.alexander.rootoffear.utils.PositionUtils;
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.Collections;
/*    */ import java.util.EnumSet;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.level.LightLayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedApproachTargetGoal
/*    */   extends Goal
/*    */ {
/*    */   public Mob mob;
/*    */   @Nullable
/*    */   public LivingEntity target;
/*    */   public int tryTime;
/*    */   
/*    */   public WiltedApproachTargetGoal(Mob mob) {
/* 30 */     m_7021_(EnumSet.of(Goal.Flag.MOVE));
/* 31 */     this.mob = mob;
/* 32 */     this.target = mob.m_5448_();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 37 */     this.target = this.mob.m_5448_();
/* 38 */     return MiscUtils.inSurvivalMode(this.target);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 43 */     super.m_8056_();
/* 44 */     this.tryTime = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 49 */     this.target = this.mob.m_5448_();
/* 50 */     if (MiscUtils.inSurvivalMode(this.target)) {
/* 51 */       Mob mob = this.mob; if (mob instanceof Wilted) { Wilted wilted = (Wilted)mob;
/* 52 */         wilted.targetMovementSpeed = 0.7D; }
/*    */       
/* 54 */       if (this.tryTime >= 300 || this.mob.m_21573_().m_26571_() || this.mob.f_19853_.m_45517_(LightLayer.BLOCK, this.target.m_20183_()) < 3) {
/* 55 */         if ((this.mob.m_142582_((Entity)this.target) || this.mob.f_19853_.m_45517_(LightLayer.BLOCK, this.target.m_20183_()) < 3) && !(this.mob instanceof com.alexander.rootoffear.entities.ShadowWilted)) {
/* 56 */           this.mob.m_21573_().m_5624_((Entity)this.target, 1.0D);
/*    */         } else {
/* 58 */           BlockPos pos = findTarget();
/* 59 */           if (pos != null) {
/* 60 */             this.mob.m_21573_().m_26519_(pos.m_123341_(), pos.m_123342_(), pos.m_123343_(), 1.0D);
/*    */           }
/*    */         } 
/* 63 */         this.tryTime = 0;
/*    */       } 
/*    */     } 
/* 66 */     this.tryTime++;
/*    */   }
/*    */   
/*    */   public BlockPos findTarget() {
/* 70 */     List<BlockPos> validPositions = Lists.newArrayList();
/* 71 */     for (int i = 0; i < 10; i++) {
/* 72 */       BlockPos pos = this.target.m_20183_().m_7918_((int)(this.mob.m_217043_().m_188583_() * 10.0D), 0, (int)(this.mob.m_217043_().m_188583_() * 10.0D));
/* 73 */       if (pos != null && this.mob.f_19853_.m_45517_(LightLayer.BLOCK, pos) < 3) {
/* 74 */         validPositions.add(new BlockPos(pos.m_123341_(), pos.m_123342_(), pos.m_123343_()));
/*    */       }
/*    */     } 
/*    */     
/* 78 */     if (validPositions.size() > 0) {
/* 79 */       Collections.shuffle(validPositions);
/* 80 */       Collections.sort(validPositions, PositionUtils.distanceComparator(this.mob.m_20183_()));
/* 81 */       return validPositions.get(validPositions.size() - 1);
/*    */     } 
/*    */     
/* 84 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedApproachTargetGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */