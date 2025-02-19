/*     */ package com.alexander.rootoffear.ai.goals.wilted;
/*     */ 
/*     */ import com.alexander.rootoffear.entities.LightExtinguisher;
/*     */ import com.alexander.rootoffear.entities.Wilted;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
/*     */ import com.alexander.rootoffear.init.TagInit;
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.ai.targeting.TargetingConditions;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WiltedExtinguishLightsGoal
/*     */   extends Goal
/*     */ {
/*     */   public Wilted mob;
/*     */   public int nextUseTime;
/*     */   public int useTicks;
/*  29 */   public List<BlockPos> targetPositions = Lists.newArrayList();
/*     */   
/*     */   public WiltedExtinguishLightsGoal(Wilted mob) {
/*  32 */     this.mob = mob;
/*     */   }
/*     */   
/*     */   public boolean m_183429_() {
/*  36 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8036_() {
/*  41 */     if (this.mob.f_19797_ > 10 && this.mob.f_19797_ >= this.nextUseTime) {
/*  42 */       findTargetPos();
/*  43 */       return !this.targetPositions.isEmpty();
/*     */     } 
/*  45 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/*  51 */     return (this.useTicks > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8056_() {
/*  56 */     this.useTicks = 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/*  61 */     if (this.useTicks == 10) {
/*  62 */       for (BlockPos pos : this.targetPositions) {
/*  63 */         if (this.mob.f_19853_.m_8055_(pos).m_204336_(TagInit.Blocks.DESTROYED_NOT_EXTINGUISHED)) {
/*  64 */           this.mob.f_19853_.m_46961_(pos, false); continue;
/*     */         } 
/*  66 */         LightExtinguisher extinguisher = new LightExtinguisher(this.mob.f_19853_, pos, (Entity)this.mob);
/*  67 */         this.mob.f_19853_.m_7967_((Entity)extinguisher);
/*  68 */         this.mob.f_19853_.m_7605_((Entity)extinguisher, (byte)7);
/*  69 */         extinguisher.m_216990_((SoundEvent)SoundEventInit.WILTED_EXTINGUISH.get());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  74 */     if (this.useTicks > 0) {
/*  75 */       this.useTicks--;
/*     */     }
/*     */   }
/*     */   
/*     */   public void findTargetPos() {
/*  80 */     Vec3 pos = this.mob.m_20182_().m_82520_(0.0D, (this.mob.m_20206_() / 2.0F), 0.0D);
/*  81 */     int areaSize = 20;
/*     */     
/*  83 */     List<BlockPos> validPositions = Lists.newArrayList();
/*     */     
/*  85 */     for (BlockPos blockpos : BlockPos.m_121976_(Mth.m_14107_(pos.f_82479_ - areaSize), Mth.m_14107_(pos.f_82480_ - areaSize), Mth.m_14107_(pos.f_82481_ - areaSize), Mth.m_14107_(pos.f_82479_ + areaSize), Mth.m_14107_(pos.f_82480_ + areaSize), Mth.m_14107_(pos.f_82481_ + areaSize))) {
/*  86 */       if (this.mob.f_19853_.m_7146_(blockpos) > 6 && this.mob.f_19853_.m_45976_(LightExtinguisher.class, new AABB(blockpos.m_123341_(), blockpos.m_123342_(), blockpos.m_123343_(), (blockpos.m_123341_() + 1), (blockpos.m_123342_() + 1), (blockpos.m_123343_() + 1))).size() <= 0 && (this.mob.f_19853_.m_6425_(blockpos).m_76178_() || this.mob.f_19853_.m_6425_(blockpos).m_76170_())) {
/*  87 */         validPositions.add(new BlockPos(blockpos.m_123341_(), blockpos.m_123342_(), blockpos.m_123343_()));
/*     */       }
/*     */     } 
/*     */     
/*  91 */     if (validPositions.size() > 0) {
/*  92 */       Collections.shuffle(validPositions);
/*  93 */       validPositions.sort(PositionUtils.distanceComparator(this.mob.m_20183_()));
/*     */       
/*  95 */       for (int i = 0; i < Math.max(1, validPositions.size() / 10) * Math.max(1, this.mob.f_19853_.m_45955_(TargetingConditions.m_148352_(), (LivingEntity)this.mob, this.mob.m_20191_().m_82400_(30.0D)).size()); i++) {
/*  96 */         if (validPositions.size() > i) {
/*  97 */           this.targetPositions.add(validPositions.get(i));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8041_() {
/* 105 */     super.m_8041_();
/* 106 */     this.nextUseTime = this.mob.f_19797_ + 30;
/* 107 */     this.targetPositions.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedExtinguishLightsGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */