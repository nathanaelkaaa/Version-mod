/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.events.CameraShakeEvents;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.commands.arguments.EntityAnchorArgument;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Pose;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ public class WiltedRevealGoal
/*    */   extends Goal {
/*    */   public Wilted mob;
/*    */   public int useTicks;
/*    */   
/*    */   public WiltedRevealGoal(Wilted mob) {
/* 22 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 23 */     this.mob = mob;
/*    */   }
/*    */   
/*    */   public boolean m_183429_() {
/* 27 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_6767_() {
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 37 */     return (this.mob.isDisguised() && this.mob.wantsToReveal);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 42 */     return (this.useTicks > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 47 */     this.useTicks = 46;
/* 48 */     this.mob.setDisguised(false);
/* 49 */     this.mob.startAnimation(1);
/* 50 */     this.mob.m_20124_(Pose.SPIN_ATTACK);
/* 51 */     this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_REVEAL.get(), 5.0F, 1.0F);
/* 52 */     CameraShakeEvents.addCameraShake(this.mob.f_19853_, 80, 0.25F, this.mob.m_20183_(), 20);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 57 */     this.mob.m_21573_().m_26573_();
/*    */     
/* 59 */     this.mob.targetMovementSpeed = 0.5D;
/*    */     
/* 61 */     Player nearestPlayer = this.mob.f_19853_.m_45930_((Entity)this.mob, 128.0D);
/* 62 */     if (MiscUtils.isEntityValid((LivingEntity)nearestPlayer)) {
/* 63 */       this.mob.m_7618_(EntityAnchorArgument.Anchor.EYES, nearestPlayer.m_146892_());
/*    */     }
/*    */     
/* 66 */     if (this.useTicks > 10 && this.useTicks <= 35) {
/* 67 */       this.mob.f_19853_.m_7605_((Entity)this.mob, (byte)19);
/*    */     }
/*    */     
/* 70 */     if (this.useTicks == 10) {
/* 71 */       this.mob.f_19853_.m_7605_((Entity)this.mob, (byte)18);
/*    */     }
/*    */     
/* 74 */     if (this.useTicks > 0) {
/* 75 */       this.useTicks--;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 81 */     super.m_8041_();
/* 82 */     this.mob.m_20124_(Pose.STANDING);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedRevealGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */