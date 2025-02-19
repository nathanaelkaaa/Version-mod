/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
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
/*    */ public class WiltedTeleportGoal
/*    */   extends Goal {
/*    */   public Wilted mob;
/*    */   public int useTicks;
/*    */   
/*    */   public WiltedTeleportGoal(Wilted mob) {
/* 21 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 22 */     this.mob = mob;
/*    */   }
/*    */   
/*    */   public boolean m_183429_() {
/* 26 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_6767_() {
/* 31 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 36 */     return (this.mob.teleportTargetPos != null && this.mob.m_20096_());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 41 */     return (this.useTicks > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 46 */     this.useTicks = 60;
/* 47 */     this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_DIG_IN.get(), this.mob.m_6121_(), this.mob.m_6100_());
/* 48 */     this.mob.startAnimation(2);
/* 49 */     this.mob.m_20124_(Pose.SPIN_ATTACK);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 54 */     this.mob.m_21573_().m_26573_();
/*    */     
/* 56 */     if (this.useTicks == 30) {
/* 57 */       this.mob.m_6034_(this.mob.teleportTargetPos.m_123341_(), this.mob.teleportTargetPos.m_123342_(), this.mob.teleportTargetPos.m_123343_());
/* 58 */       Player nearestPlayer = this.mob.f_19853_.m_45930_((Entity)this.mob, 128.0D);
/* 59 */       if (MiscUtils.isEntityValid((LivingEntity)nearestPlayer)) {
/* 60 */         this.mob.m_7618_(EntityAnchorArgument.Anchor.EYES, nearestPlayer.m_146892_());
/*    */       }
/*    */     } 
/*    */     
/* 64 */     if (this.useTicks == 44) {
/* 65 */       this.mob.f_19853_.m_7605_((Entity)this.mob, (byte)17);
/* 66 */       if (this.mob.willDisguiseOnNextTeleport) {
/* 67 */         this.mob.setDisguised(true);
/* 68 */         this.mob.f_19853_.m_7605_((Entity)this.mob, (byte)13);
/* 69 */         this.mob.willDisguiseOnNextTeleport = false;
/*    */       } 
/*    */     } 
/*    */     
/* 73 */     if (this.useTicks == 15) {
/* 74 */       this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_DIG_OUT.get(), 1.0F, this.mob.m_6100_());
/* 75 */       this.mob.f_19853_.m_7605_((Entity)this.mob, (byte)16);
/*    */     } 
/*    */     
/* 78 */     if (this.useTicks > 0) {
/* 79 */       this.useTicks--;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 85 */     super.m_8041_();
/* 86 */     this.mob.teleportTargetPos = null;
/* 87 */     this.mob.m_20124_(Pose.STANDING);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedTeleportGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */