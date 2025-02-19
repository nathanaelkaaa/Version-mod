/*     */ package com.alexander.rootoffear.ai.goals.wilted;
/*     */ 
/*     */ import com.alexander.rootoffear.entities.Wilted;
/*     */ import com.alexander.rootoffear.entities.WiltedHands;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
/*     */ import com.alexander.rootoffear.utils.MiscUtils;
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import java.util.EnumSet;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.commands.arguments.EntityAnchorArgument;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Pose;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.level.LightLayer;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WiltedGroundGrabGoal
/*     */   extends Goal
/*     */ {
/*     */   public Wilted mob;
/*     */   @Nullable
/*     */   public LivingEntity target;
/*     */   public int nextUseTime;
/*     */   public int useTicks;
/*     */   public WiltedHands hands;
/*     */   
/*     */   public WiltedGroundGrabGoal(Wilted mob) {
/*  35 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/*  36 */     this.mob = mob;
/*  37 */     this.target = mob.m_5448_();
/*     */   }
/*     */   
/*     */   public boolean m_183429_() {
/*  41 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8036_() {
/*  46 */     this.target = this.mob.m_5448_();
/*  47 */     return (this.mob.chosenBonusBehaviours.contains(this) && !this.mob.isDisguised() && this.mob.f_19797_ >= this.nextUseTime && !this.mob.isPhasingThroughWall() && MiscUtils.isEntityValid(this.target) && this.target.m_20096_() && (this.mob.m_20270_((Entity)this.target) > 10.0F || !this.mob.m_142582_((Entity)this.target) || this.mob.f_19853_.m_45517_(LightLayer.BLOCK, this.target.m_20183_()) >= 3));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/*  52 */     return (MiscUtils.isEntityValid(this.target) && MiscUtils.isEntityValid((Entity)this.hands) && this.useTicks <= 155);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8056_() {
/*  57 */     this.target = this.mob.m_5448_();
/*  58 */     this.mob.startAnimation(6);
/*  59 */     this.mob.m_20124_(Pose.SPIN_ATTACK);
/*  60 */     this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_DIG_IN.get(), this.mob.m_6121_(), this.mob.m_6100_());
/*     */     
/*  62 */     this.hands = new WiltedHands(this.mob.f_19853_, this.target.m_20182_(), this.mob.m_217043_().m_188501_() * 360.0F, this.target);
/*  63 */     this.mob.f_19853_.m_7967_((Entity)this.hands);
/*  64 */     this.mob.f_19853_.m_7605_((Entity)this.hands, (byte)7);
/*  65 */     this.hands.m_5496_((SoundEvent)SoundEventInit.WILTED_DIG_OUT.get(), this.mob.m_6121_(), this.mob.m_6100_());
/*  66 */     this.hands.m_5496_((SoundEvent)SoundEventInit.WILTED_GROUND_GRAB.get(), 1.0F, 1.0F);
/*     */     
/*  68 */     this.useTicks = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6767_() {
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/*  78 */     this.target = this.mob.m_5448_();
/*     */     
/*  80 */     this.mob.m_21573_().m_26573_();
/*     */     
/*  82 */     if (MiscUtils.isEntityValid(this.target) && MiscUtils.isEntityValid((Entity)this.hands) && this.hands.m_20191_().m_165887_(this.hands.m_20186_() - 2.0D).m_82381_(this.target.m_20191_())) {
/*  83 */       this.mob.m_7618_(EntityAnchorArgument.Anchor.EYES, this.target.m_146892_());
/*  84 */       if (this.target.m_5830_() && this.useTicks == 150) {
/*  85 */         this.mob.m_5496_((SoundEvent)SoundEventInit.WILTED_DIG_OUT.get(), this.mob.m_6121_(), this.mob.m_6100_());
/*  86 */         Vec3 pos = PositionUtils.getOffsetPos((Entity)this.mob, 0.0D, -1.5D, 2.5D, 0.0F, this.mob.f_20883_);
/*  87 */         this.target.m_146884_(pos);
/*  88 */         this.target.m_20334_(0.0D, 0.5D, 0.0D);
/*  89 */         LivingEntity livingEntity = this.target; if (livingEntity instanceof ServerPlayer) { ServerPlayer player = (ServerPlayer)livingEntity;
/*  90 */           player.m_6021_(pos.f_82479_, pos.f_82480_, pos.f_82481_);
/*  91 */           player.f_8906_.m_9829_((Packet)new ClientboundSetEntityMotionPacket((Entity)player)); }
/*     */       
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     this.useTicks++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8041_() {
/* 101 */     super.m_8041_();
/* 102 */     this.nextUseTime = this.mob.f_19797_ + MiscUtils.randomIntBetween(200, 600);
/* 103 */     this.mob.m_20124_(Pose.STANDING);
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedGroundGrabGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */