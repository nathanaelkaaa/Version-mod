/*     */ package com.alexander.rootoffear.ai.goals.wilted;
/*     */ 
/*     */ import com.alexander.rootoffear.entities.Wilted;
/*     */ import com.alexander.rootoffear.events.CameraShakeEvents;
/*     */ import com.alexander.rootoffear.events.PlayerMovementEvents;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
/*     */ import com.alexander.rootoffear.utils.MiscUtils;
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import java.util.EnumSet;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Pose;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.LightLayer;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WiltedGrabAttackGoal
/*     */   extends Goal
/*     */ {
/*     */   public Wilted mob;
/*     */   @Nullable
/*     */   public LivingEntity target;
/*     */   public int nextUseTime;
/*     */   public int useTicks;
/*     */   public boolean canContinue;
/*     */   
/*     */   public WiltedGrabAttackGoal(Wilted mob) {
/*  39 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/*  40 */     this.mob = mob;
/*  41 */     this.target = mob.m_5448_();
/*     */   }
/*     */   
/*     */   public boolean m_183429_() {
/*  45 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8036_() {
/*  50 */     this.target = this.mob.m_5448_();
/*  51 */     return (!this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && !this.mob.m_6060_() && MiscUtils.isEntityValid(this.target) && (
/*  52 */       MiscUtils.isEntityAttackable((LivingEntity)this.mob, this.target, 5.0D) || (this.mob.isPhasingThroughWall() && this.mob.f_19853_.m_45517_(LightLayer.BLOCK, this.target.m_20183_()) < 3 && this.mob.m_20191_().m_82377_(3.5D, 0.0D, 3.5D).m_82381_(this.target.m_20191_()))));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/*  57 */     return (this.canContinue && !this.mob.m_6060_());
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8056_() {
/*  62 */     this.mob.setSilentTimer(0);
/*  63 */     this.mob.startAnimation(0);
/*  64 */     this.mob.m_20124_(Pose.SPIN_ATTACK);
/*  65 */     this.useTicks = 0;
/*  66 */     this.canContinue = true;
/*  67 */     Vec3 pos = pickUpPos();
/*  68 */     LivingEntity livingEntity = this.target; if (livingEntity instanceof ServerPlayer) { ServerPlayer player = (ServerPlayer)livingEntity;
/*  69 */       PlayerMovementEvents.addPlayerMovement((Entity)player, (Entity)this.mob, 0); }
/*     */     else
/*  71 */     { this.target.m_146884_(pos); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/*  77 */     this.mob.m_21573_().m_26573_();
/*     */     
/*  79 */     AABB bb = this.mob.m_20191_().m_82377_(5.0D, 10.0D, 5.0D);
/*  80 */     if (MiscUtils.inSurvivalMode(this.target) && bb.m_82381_(this.target.m_20191_())) {
/*  81 */       moveTargetToPickUpPos();
/*     */       
/*  83 */       if (this.mob.m_6060_()) {
/*  84 */         this.target.m_20254_(5);
/*     */       }
/*  86 */       if (this.useTicks % 40 == 0) {
/*  87 */         this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_ATTACK.get(), this.mob.m_6121_(), 1.0F);
/*     */       }
/*  89 */       if (this.useTicks % 40 == 19) {
/*  90 */         this.target.m_6469_(DamageSource.m_19370_((LivingEntity)this.mob), 20.0F);
/*  91 */         CameraShakeEvents.addCameraShake(this.mob.f_19853_, 10, 2.0F, this.target.m_20183_(), 15);
/*  92 */         MiscUtils.disableShield(this.target, 60);
/*  93 */         for (LivingEntity entity : this.mob.f_19853_.m_45971_(LivingEntity.class, Wilted.TARGETING, (LivingEntity)this.mob, this.target.m_20191_().m_82400_(2.0D))) {
/*  94 */           if (entity != this.target && entity != this.mob) {
/*  95 */             entity.m_6469_(DamageSource.m_19370_((LivingEntity)this.mob), 10.0F);
/*  96 */             MiscUtils.disableShield(entity, 60);
/*     */           } 
/*     */         } 
/*  99 */         if (MiscUtils.isEntityValid(this.mob.m_5448_()) && this.mob.m_5448_() != this.target) {
/* 100 */           this.canContinue = false;
/*     */         }
/* 102 */         if (this.target instanceof ServerPlayer && !this.target.m_6084_() && this.mob.f_19853_.m_45971_(Player.class, Wilted.TARGETING.m_26888_(entity -> (entity != this.target)), (LivingEntity)this.mob, this.target.m_20191_().m_82400_(this.mob.m_21133_(Attributes.f_22277_))).size() <= 0) {
/* 103 */           this.mob.teleportTargetPos = Wilted.findSpawnablePosition(this.mob.m_20183_(), (ServerLevel)this.mob.f_19853_, 48, 64, 32, 500, true);
/* 104 */           if (this.mob.teleportTargetPos != null) {
/* 105 */             this.mob.wantsToRevealCooldown = 100;
/* 106 */             this.mob.wantsToReveal = false;
/* 107 */             this.mob.willDisguiseOnNextTeleport = true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/* 112 */       this.canContinue = false;
/*     */     } 
/*     */     
/* 115 */     this.useTicks++;
/*     */   }
/*     */   
/*     */   public Vec3 pickUpPos() {
/* 119 */     Vec3 finalVec = Vec3.f_82478_;
/* 120 */     Vec3 targetVec1 = new Vec3(0.0D, 3.0D, 4.0D);
/* 121 */     Vec3 targetVec2 = new Vec3(0.0D, 4.5D, 3.0D);
/* 122 */     Vec3 targetVec3 = new Vec3(0.0D, -0.5D, 4.5D);
/* 123 */     int ticks = this.useTicks % 40;
/* 124 */     if (ticks <= 10) {
/* 125 */       finalVec = targetVec1.m_165921_(targetVec2, (ticks / 10.0F));
/* 126 */     } else if (ticks < 14) {
/* 127 */       finalVec = targetVec2;
/* 128 */     } else if (ticks <= 17) {
/* 129 */       finalVec = targetVec2.m_165921_(targetVec3, ((ticks - 14) / 3.0F));
/* 130 */     } else if (ticks < 28) {
/* 131 */       finalVec = targetVec3;
/* 132 */     } else if (ticks <= 40) {
/* 133 */       finalVec = targetVec3.m_165921_(targetVec1, ((ticks - 27) / 13.0F));
/*     */     } 
/* 135 */     return PositionUtils.getOffsetPos((Entity)this.mob, finalVec.f_82479_, finalVec.f_82480_, finalVec.f_82481_, 0.0F, this.mob.f_20883_);
/*     */   }
/*     */   
/*     */   public void moveTargetToPickUpPos() {
/* 139 */     if (!(this.target instanceof ServerPlayer)) {
/* 140 */       Vec3 pos = pickUpPos();
/* 141 */       double distance = Math.max(PositionUtils.distanceTo((Entity)this.target, pos), 1.0F);
/* 142 */       this.target.m_20256_(new Vec3((pos.f_82479_ - this.target.m_20185_()) / distance, (pos.f_82480_ - this.target.m_20186_()) / distance, (pos.f_82481_ - this.target.m_20189_()) / distance));
/*     */     } 
/* 144 */     this.target.m_183634_();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8041_() {
/* 149 */     super.m_8041_();
/* 150 */     this.nextUseTime = this.mob.f_19797_ + 40;
/* 151 */     this.mob.m_20124_(Pose.STANDING);
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedGrabAttackGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */