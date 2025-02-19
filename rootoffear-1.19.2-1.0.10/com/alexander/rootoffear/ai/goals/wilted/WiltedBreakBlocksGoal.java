/*     */ package com.alexander.rootoffear.ai.goals.wilted;
/*     */ 
/*     */ import com.alexander.rootoffear.entities.Wilted;
/*     */ import com.alexander.rootoffear.events.CameraShakeEvents;
/*     */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
/*     */ import com.alexander.rootoffear.particles.AdvancedParticleOption;
/*     */ import com.alexander.rootoffear.utils.MiscUtils;
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import java.util.EnumSet;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.commands.arguments.EntityAnchorArgument;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Pose;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec2;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WiltedBreakBlocksGoal
/*     */   extends Goal
/*     */ {
/*     */   public Wilted mob;
/*     */   @Nullable
/*     */   public LivingEntity target;
/*     */   public int nextUseTime;
/*     */   public int useTicks;
/*     */   public int breakAmount;
/*     */   public AABB breakArea;
/*     */   public int lookedAwayTicks;
/*     */   public boolean canContinue;
/*     */   public boolean startedBreaking = false;
/*     */   
/*     */   public WiltedBreakBlocksGoal(Wilted mob) {
/*  47 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/*  48 */     this.mob = mob;
/*  49 */     this.target = mob.m_5448_();
/*     */   }
/*     */   
/*     */   public boolean m_183429_() {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6767_() {
/*  58 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8036_() {
/*  63 */     this.target = this.mob.m_5448_();
/*  64 */     return (ForgeEventFactory.getMobGriefingEvent(this.mob.f_19853_, (Entity)this.mob) && this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && MiscUtils.isEntityValid(this.target) && !this.mob.canPhaseThroughWalls() && !this.mob.m_142582_((Entity)this.target));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/*  69 */     return (this.canContinue && this.lookedAwayTicks < 100 && (this.startedBreaking || MiscUtils.isEntityValid(this.target)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8056_() {
/*  74 */     this.useTicks = 0;
/*  75 */     this.breakAmount = 0;
/*  76 */     this.lookedAwayTicks = 0;
/*  77 */     this.startedBreaking = false;
/*  78 */     this.canContinue = true;
/*  79 */     this.mob.setSilentTimer(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/*  84 */     this.target = this.mob.m_5448_();
/*     */     
/*  86 */     if (!this.startedBreaking) {
/*  87 */       if (MiscUtils.isEntityValid(this.target)) {
/*  88 */         this.mob.targetMovementSpeed = 0.5D;
/*  89 */         this.mob.m_21573_().m_5624_((Entity)this.target, 1.0D);
/*  90 */         this.mob.m_7618_(EntityAnchorArgument.Anchor.EYES, this.target.m_146892_());
/*  91 */         if (this.mob.m_20270_((Entity)this.target) <= 15.0F) {
/*  92 */           makeBreakArea();
/*  93 */           int collidableBlocks = 0;
/*  94 */           for (BlockPos pos : BlockPos.m_121976_(Mth.m_14107_(this.breakArea.f_82288_), Mth.m_14107_(this.breakArea.f_82289_), Mth.m_14107_(this.breakArea.f_82290_), Mth.m_14107_(this.breakArea.f_82291_), Mth.m_14107_(this.breakArea.f_82292_), Mth.m_14107_(this.breakArea.f_82293_))) {
/*     */             
/*  96 */             collidableBlocks++;
/*  97 */             if (PositionUtils.isBlockCollidable(this.mob.f_19853_, pos) && this.mob.f_19853_.m_8055_(pos).m_60734_().m_155943_() < 50.0F && collidableBlocks >= 16) {
/*  98 */               this.startedBreaking = true;
/*  99 */               this.mob.startAnimation(3);
/* 100 */               this.mob.m_20124_(Pose.SPIN_ATTACK);
/* 101 */               this.useTicks = 0;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 109 */       if (this.useTicks >= 200 && !this.startedBreaking) {
/* 110 */         this.canContinue = false;
/*     */       }
/*     */     } 
/*     */     
/* 114 */     if (this.startedBreaking) {
/* 115 */       this.mob.m_21573_().m_26573_();
/*     */       
/* 117 */       this.mob.m_20124_(Pose.SPIN_ATTACK);
/* 118 */       boolean flag = false;
/* 119 */       for (Player player : this.mob.f_19853_.m_6907_()) {
/* 120 */         if (this.mob.isLookingAtMe(player) && MiscUtils.inSurvivalMode((LivingEntity)player)) {
/* 121 */           flag = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 126 */       if (!flag) {
/* 127 */         this.mob.m_20124_(Pose.STANDING);
/* 128 */         this.lookedAwayTicks++;
/*     */       } 
/*     */       
/* 131 */       if (this.useTicks % 30 == 12 && this.mob.m_217003_(Pose.SPIN_ATTACK)) {
/* 132 */         this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_ATTACK.get(), this.mob.m_6121_(), 1.0F);
/*     */       }
/*     */       
/* 135 */       if (this.useTicks % 30 == 3 && this.mob.m_217003_(Pose.SPIN_ATTACK)) {
/* 136 */         this.breakAmount++;
/* 137 */         this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_LAND.get(), this.mob.m_6121_(), this.mob.m_6100_());
/* 138 */         this.mob.m_5496_(SoundEvents.f_12555_, this.mob.m_6121_(), this.mob.m_6100_());
/*     */         
/* 140 */         CameraShakeEvents.addCameraShake(this.mob.f_19853_, 15, 2.0F, new BlockPos(this.breakArea.m_82399_()), 15);
/*     */         
/* 142 */         for (BlockPos pos : BlockPos.m_121976_(Mth.m_14107_(this.breakArea.f_82288_), Mth.m_14107_(this.breakArea.f_82289_), Mth.m_14107_(this.breakArea.f_82290_), Mth.m_14107_(this.breakArea.f_82291_), Mth.m_14107_(this.breakArea.f_82292_), Mth.m_14107_(this.breakArea.f_82293_))) {
/* 143 */           if (PositionUtils.isBlockCollidable(this.mob.f_19853_, pos) && this.mob.f_19853_.m_8055_(pos).m_60734_().m_155943_() < 50.0F) {
/* 144 */             if (this.breakAmount >= 5) {
/* 145 */               this.mob.f_19853_.m_46953_(pos, false, (Entity)this.mob); continue;
/*     */             } 
/* 147 */             ((ServerLevel)this.mob.f_19853_).m_8767_((ParticleOptions)new AdvancedParticleOption(ParticleTypeInit.BLOCK_BREAKING, 
/* 148 */                   List.of(Double.valueOf(this.breakAmount * 2.0D))), pos.m_123341_(), pos.m_123342_(), pos.m_123343_(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 153 */         if (this.breakAmount >= 5) {
/* 154 */           this.canContinue = false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     this.useTicks++;
/*     */   }
/*     */   
/*     */   public void makeBreakArea() {
/* 163 */     Vec2 rot = PositionUtils.rotationToFace(this.mob.m_146892_(), this.target.m_146892_());
/* 164 */     Vec3 pos = PositionUtils.getOffsetPos((Entity)this.mob, 0.0D, this.mob.m_20192_(), 3.0D, rot.f_82470_, rot.f_82471_);
/* 165 */     AABB aabb = (new AABB(pos.m_82520_(-2.5D, -2.5D, -2.5D), pos.m_82520_(2.5D, 2.5D, 2.5D))).m_165887_(this.mob.m_20186_() + 0.1D);
/* 166 */     this.breakArea = aabb;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8041_() {
/* 171 */     super.m_8041_();
/* 172 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(200, 600);
/* 173 */     this.mob.m_20124_(Pose.STANDING);
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedBreakBlocksGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */