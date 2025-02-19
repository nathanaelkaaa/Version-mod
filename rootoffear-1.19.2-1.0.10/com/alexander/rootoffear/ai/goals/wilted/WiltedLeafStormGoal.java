/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.particles.AdvancedParticleOption;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Pose;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedLeafStormGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   @Nullable
/*    */   public LivingEntity target;
/*    */   public int nextUseTime;
/*    */   public int useTicks;
/*    */   
/*    */   public WiltedLeafStormGoal(Wilted mob) {
/* 30 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 31 */     this.mob = mob;
/* 32 */     this.target = mob.m_5448_();
/*    */   }
/*    */   
/*    */   public boolean m_183429_() {
/* 36 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 41 */     this.target = this.mob.m_5448_();
/* 42 */     return (this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && MiscUtils.isEntityValid(this.target));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 52 */     this.target = this.mob.m_5448_();
/* 53 */     this.mob.m_20124_(Pose.SPIN_ATTACK);
/* 54 */     ((ServerLevel)this.mob.f_19853_).m_8767_((ParticleOptions)new AdvancedParticleOption(ParticleTypeInit.LEAF_STORM, List.of(Double.valueOf(this.target.m_19879_()))), this.mob.m_20185_(), this.mob.m_20186_() + this.mob.m_20206_() * 0.75D, this.mob.m_20189_(), 3000, 0.0D, 0.0D, 0.0D, 0.0D);
/* 55 */     this.useTicks = 0;
/* 56 */     this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_LEAF_STORM.get(), this.mob.m_6121_(), 1.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 61 */     super.m_8041_();
/* 62 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(400, 1200);
/* 63 */     this.mob.m_20124_(Pose.STANDING);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedLeafStormGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */