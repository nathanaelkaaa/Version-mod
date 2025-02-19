/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.entities.WiltedBarrier;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import com.alexander.rootoffear.utils.PositionUtils;
/*    */ import java.util.EnumSet;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ 
/*    */ 
/*    */ public class WiltedCreateBarriersGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   @Nullable
/*    */   public LivingEntity target;
/*    */   public int nextUseTime;
/*    */   
/*    */   public WiltedCreateBarriersGoal(Wilted mob) {
/* 28 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 29 */     this.mob = mob;
/* 30 */     this.target = mob.m_5448_();
/*    */   }
/*    */   
/*    */   public boolean m_183429_() {
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 39 */     this.target = this.mob.m_5448_();
/* 40 */     return (this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && MiscUtils.isEntityValid(this.target) && this.target.m_20096_() && (createBarrier(PositionUtils.getOffsetPos((Entity)this.target, -1.0D, 0.0D, 2.0D, 0.0F, this.target.f_20885_)) | createBarrier(PositionUtils.getOffsetPos((Entity)this.target, 0.0D, 0.0D, 2.0D, 0.0F, this.target.f_20885_)) | createBarrier(PositionUtils.getOffsetPos((Entity)this.target, 1.0D, 0.0D, 2.0D, 0.0F, this.target.f_20885_))) != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 45 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 50 */     super.m_8041_();
/* 51 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(300, 600);
/*    */   }
/*    */   
/*    */   public boolean createBarrier(Vec3 pos) {
/* 55 */     BlockPos blockpos = new BlockPos(pos);
/* 56 */     boolean flag = false;
/* 57 */     if (PositionUtils.isBlockCollidable(this.mob.f_19853_, blockpos.m_7495_()) && (!PositionUtils.isBlockCollidable(this.mob.f_19853_, blockpos) || !PositionUtils.isBlockCollidable(this.mob.f_19853_, blockpos.m_7494_()) || !PositionUtils.isBlockCollidable(this.mob.f_19853_, blockpos.m_7494_().m_7494_())) && this.mob.f_19853_.m_45976_(WiltedBarrier.class, new AABB(blockpos.m_123341_(), blockpos.m_123342_(), blockpos.m_123343_(), (blockpos.m_123341_() + 1), (blockpos.m_123342_() + 1), (blockpos.m_123343_() + 1))).size() <= 0) {
/* 58 */       WiltedBarrier barrier = new WiltedBarrier(this.mob.f_19853_, pos);
/* 59 */       flag = this.mob.f_19853_.m_7967_((Entity)barrier);
/* 60 */       this.mob.f_19853_.m_7605_((Entity)barrier, (byte)7);
/* 61 */       barrier.m_5496_((SoundEvent)SoundEventInit.WILTED_DIG_OUT.get(), 1.0F, barrier.getVoicePitch());
/*    */     } 
/* 63 */     return flag;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedCreateBarriersGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */