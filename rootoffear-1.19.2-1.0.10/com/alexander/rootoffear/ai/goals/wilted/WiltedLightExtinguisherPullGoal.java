/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.LightExtinguisher;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedLightExtinguisherPullGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   @Nullable
/*    */   public LivingEntity target;
/*    */   public int nextUseTime;
/*    */   
/*    */   public WiltedLightExtinguisherPullGoal(Wilted mob) {
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
/* 39 */     return (this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && MiscUtils.isEntityValid(this.target) && this.mob.f_19853_.m_6249_((Entity)this.mob, this.target.m_20191_().m_82400_(20.0D), entity -> { if (MiscUtils.isEntityValid(entity) && entity instanceof LightExtinguisher) { LightExtinguisher extinguisher = (LightExtinguisher)entity; if (extinguisher.getOwner() == this.mob && this.target.m_142582_((Entity)extinguisher)); }  return false; }).size() > 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 44 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 49 */     this.target = this.mob.m_5448_();
/* 50 */     for (Entity entity : this.mob.f_19853_.m_6249_((Entity)this.mob, this.target.m_20191_().m_82400_(20.0D), entity -> { if (MiscUtils.isEntityValid(entity) && entity instanceof LightExtinguisher) { LightExtinguisher extinguisher = (LightExtinguisher)entity; if (extinguisher.getOwner() == this.mob && this.target.m_142582_((Entity)extinguisher)); }  return false;
/* 51 */         })) { LightExtinguisher extinguisher = (LightExtinguisher)entity;
/* 52 */       extinguisher.m_5496_((SoundEvent)SoundEventInit.WILTED_DIG_OUT.get(), extinguisher.getSoundVolume(), extinguisher.getVoicePitch());
/* 53 */       extinguisher.pulledEntity = this.target; }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 59 */     super.m_8041_();
/* 60 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(600, 1200);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedLightExtinguisherPullGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */