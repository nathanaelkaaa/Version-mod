/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.events.CameraShakeEvents;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.commands.arguments.EntityAnchorArgument;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.entity.Pose;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.level.LightLayer;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedLeapToMoveTargetGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   public int nextUseTime;
/*    */   public int groundTime;
/*    */   public BlockPos target;
/*    */   
/*    */   public WiltedLeapToMoveTargetGoal(Wilted mob) {
/* 28 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 29 */     this.mob = mob;
/*    */   }
/*    */   
/*    */   public boolean m_183429_() {
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 38 */     return (this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && !this.mob.m_20072_() && !this.mob.isPhasingThroughWall() && this.mob.m_21573_().m_26572_() && this.mob.f_19853_.m_45517_(LightLayer.BLOCK, this.mob.m_21573_().m_26567_()) < 3);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 43 */     return (this.groundTime <= 15);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_6767_() {
/* 48 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 53 */     this.target = this.mob.m_21573_().m_26567_();
/* 54 */     double x = this.target.m_123341_() - this.mob.m_20185_();
/* 55 */     double z = this.target.m_123343_() - this.mob.m_20189_();
/* 56 */     this.mob.m_20334_(x * 0.15D, 1.5D, z * 0.15D);
/* 57 */     this.groundTime = 0;
/* 58 */     this.mob.startAnimation(4);
/* 59 */     this.mob.m_20124_(Pose.SPIN_ATTACK);
/* 60 */     this.mob.m_7618_(EntityAnchorArgument.Anchor.EYES, new Vec3(this.target.m_123341_(), this.target.m_123342_(), this.target.m_123343_()));
/* 61 */     this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_LEAP.get(), this.mob.m_6121_(), this.mob.m_6100_());
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 66 */     super.m_8037_();
/* 67 */     if (MiscUtils.isEntityValid(this.mob.m_5448_())) {
/* 68 */       this.mob.m_7618_(EntityAnchorArgument.Anchor.EYES, this.mob.m_5448_().m_146892_());
/*    */     } else {
/* 70 */       this.mob.m_7618_(EntityAnchorArgument.Anchor.EYES, new Vec3(this.target.m_123341_(), this.target.m_123342_(), this.target.m_123343_()));
/*    */     } 
/* 72 */     if ((this.mob.m_20096_() || this.mob.m_20072_() || this.mob.isPhasingThroughWall()) && ((this.mob.m_20184_()).f_82480_ <= 0.0D || this.mob.isPhasingThroughWall())) {
/* 73 */       this.mob.m_21573_().m_26573_();
/* 74 */       this.mob.m_20334_(0.0D, (this.mob.m_20184_()).f_82480_, 0.0D);
/* 75 */       if (this.groundTime <= 0) {
/* 76 */         this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_LAND.get(), this.mob.m_6121_(), this.mob.m_6100_());
/* 77 */         this.mob.startAnimation(5);
/* 78 */         CameraShakeEvents.addCameraShake(this.mob.f_19853_, 20, 1.0F, this.mob.m_20183_(), 15);
/*    */       } 
/* 80 */       this.groundTime++;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 86 */     super.m_8041_();
/* 87 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(100, 300);
/* 88 */     this.mob.m_20124_(Pose.STANDING);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedLeapToMoveTargetGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */