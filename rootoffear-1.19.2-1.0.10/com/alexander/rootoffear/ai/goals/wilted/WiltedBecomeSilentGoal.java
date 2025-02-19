/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedBecomeSilentGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   @Nullable
/*    */   public LivingEntity target;
/*    */   public int nextUseTime;
/*    */   
/*    */   public WiltedBecomeSilentGoal(Wilted mob) {
/* 31 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 32 */     this.mob = mob;
/* 33 */     this.target = mob.m_5448_();
/*    */   }
/*    */   
/*    */   public boolean m_183429_() {
/* 37 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 42 */     this.target = this.mob.m_5448_();
/* 43 */     return (this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && MiscUtils.isEntityValid(this.target));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 48 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 53 */     this.target = this.mob.m_5448_();
/* 54 */     this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_CURSE_ITEM.get(), this.mob.m_6121_(), this.mob.m_6100_() / 2.0F);
/* 55 */     this.mob.setSilentTimer(300);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 60 */     super.m_8041_();
/* 61 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(600, 1200);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedBecomeSilentGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */