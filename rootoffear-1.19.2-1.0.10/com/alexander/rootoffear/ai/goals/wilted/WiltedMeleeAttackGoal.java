/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.commands.arguments.EntityAnchorArgument;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Pose;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedMeleeAttackGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   @Nullable
/*    */   public LivingEntity target;
/*    */   public int nextUseTime;
/*    */   public int useTicks;
/*    */   
/*    */   public WiltedMeleeAttackGoal(Wilted mob) {
/* 27 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 28 */     this.mob = mob;
/* 29 */     this.target = mob.m_5448_();
/*    */   }
/*    */   
/*    */   public boolean m_183429_() {
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 38 */     this.target = this.mob.m_5448_();
/* 39 */     return (!this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && MiscUtils.isEntityValid(this.target) && 
/* 40 */       MiscUtils.isEntityAttackable((LivingEntity)this.mob, this.target, 4.0D));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 45 */     return (this.useTicks > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 50 */     this.useTicks = 23;
/* 51 */     this.mob.startAnimation(0);
/* 52 */     this.mob.m_20124_(Pose.SPIN_ATTACK);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 57 */     this.target = this.mob.m_5448_();
/*    */     
/* 59 */     this.mob.m_21573_().m_26573_();
/*    */     
/* 61 */     if (MiscUtils.isEntityValid(this.target)) {
/* 62 */       this.mob.m_7618_(EntityAnchorArgument.Anchor.EYES, this.target.m_146892_());
/*    */       
/* 64 */       if (MiscUtils.isEntityAttackable((LivingEntity)this.mob, this.target, 6.0D) && this.useTicks == 15) {
/* 65 */         boolean bool = this.target.m_6469_(DamageSource.m_19370_((LivingEntity)this.mob), 12.0F);
/*    */       }
/*    */     } 
/*    */     
/* 69 */     if (this.useTicks > 0) {
/* 70 */       this.useTicks--;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 76 */     super.m_8041_();
/* 77 */     this.nextUseTime = this.mob.f_19797_ + 20;
/* 78 */     this.mob.m_20124_(Pose.STANDING);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedMeleeAttackGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */