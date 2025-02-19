/*     */ package com.alexander.rootoffear.entities;
/*     */ import com.alexander.rootoffear.ai.controllers.wilted.WiltedMoveControl;
/*     */ import com.alexander.rootoffear.ai.controllers.wilted.WiltedNavigation;
/*     */ import com.alexander.rootoffear.ai.goals.AdvancedNearestAttackableTargetGoal;
/*     */ import com.alexander.rootoffear.ai.goals.LookAtTargetGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedApproachTargetGoal;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
/*     */ import com.alexander.rootoffear.utils.MiscUtils;
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.players.OldUsersConverter;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.AnimationState;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityDimensions;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.Pose;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.control.MoveControl;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
/*     */ import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
/*     */ import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
/*     */ import net.minecraft.world.entity.ai.navigation.PathNavigation;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LightLayer;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.pathfinder.BlockPathTypes;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec2;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.common.ForgeMod;
/*     */ 
/*     */ public class ShadowWilted extends Monster {
/*     */   public int lifeTime;
/*  53 */   public Vec2 facingAngle = Vec2.f_82462_; public UUID ownerID;
/*  54 */   public Vec2 facingAngleO = Vec2.f_82462_;
/*     */   
/*  56 */   public AnimationState idleAnimationState = new AnimationState();
/*     */   
/*     */   public ShadowWilted(EntityType<? extends ShadowWilted> type, Level level) {
/*  59 */     super(type, level);
/*  60 */     m_21441_(BlockPathTypes.WATER, 0.0F);
/*  61 */     m_21441_(BlockPathTypes.WATER_BORDER, 0.0F);
/*  62 */     m_21441_(BlockPathTypes.DANGER_OTHER, 0.0F);
/*  63 */     m_21441_(BlockPathTypes.DAMAGE_OTHER, 0.0F);
/*  64 */     m_21441_(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
/*  65 */     m_21441_(BlockPathTypes.FENCE, 0.0F);
/*  66 */     this.f_21342_ = (MoveControl)new WiltedMoveControl((Mob)this);
/*  67 */     this.f_21364_ = 0;
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  71 */     int p = 0;
/*  72 */     this.f_21345_.m_25352_(p++, (Goal)new LookAtTargetGoal((Mob)this));
/*  73 */     this.f_21345_.m_25352_(p++, (Goal)new WiltedApproachTargetGoal((Mob)this));
/*  74 */     this.f_21345_.m_25352_(p++, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0D));
/*  75 */     this.f_21345_.m_25352_(p++, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0F));
/*  76 */     this.f_21345_.m_25352_(p++, (Goal)new RandomLookAroundGoal((Mob)this));
/*  77 */     this.f_21346_.m_25352_(0, (Goal)new AdvancedNearestAttackableTargetGoal((Mob)this, Player.class, false, false, true, true, null));
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7822_(byte event) {
/*  82 */     if (event == 60) {
/*  83 */       for (int i = 0; i < 50; i++) {
/*  84 */         this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123755_, m_20208_(0.75D), m_20187_(), m_20262_(0.75D), 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */     } else {
/*  87 */       super.m_7822_(event);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_6153_() {
/*  93 */     if (!this.f_19853_.m_5776_() && !m_213877_()) {
/*  94 */       this.f_19853_.m_7605_((Entity)this, (byte)60);
/*  95 */       m_142687_(Entity.RemovalReason.KILLED);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6075_() {
/* 101 */     super.m_6075_();
/*     */     
/* 103 */     if (this.f_19853_.m_5776_()) {
/* 104 */       this.idleAnimationState.m_216982_(this.f_19797_);
/*     */     }
/*     */     
/* 107 */     this.facingAngleO = this.facingAngle;
/*     */     
/* 109 */     if (!this.f_19853_.m_5776_() && this.f_19797_ > 20 && this.ownerID != null && !MiscUtils.isEntityValid(getOwner())) {
/* 110 */       m_6469_(DamageSource.f_19313_, 1.0F);
/*     */     }
/*     */     
/* 113 */     Player player = this.f_19853_.m_45930_((Entity)this, 100.0D);
/*     */     
/* 115 */     if (player != null) {
/* 116 */       this.facingAngle = PositionUtils.rotationToFace(m_146892_(), player.m_146892_());
/*     */     }
/* 118 */     if (!this.f_19853_.m_5776_()) {
/* 119 */       if (this.lifeTime++ > 1200) {
/* 120 */         m_6469_(DamageSource.f_19313_, 1.0F);
/*     */       }
/* 122 */       if (this.f_19853_.m_46749_(m_20183_()) && !m_20072_() && isBrightEnoughToBurn()) {
/* 123 */         m_6469_(DamageSource.f_19307_, 1.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_7334_(Entity p_21294_) {}
/*     */ 
/*     */   
/*     */   protected void m_7324_(Entity p_20971_) {}
/*     */ 
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 137 */     return Monster.m_33035_().m_22268_(Attributes.f_22276_, 1.0D).m_22268_(Attributes.f_22279_, 0.25D).m_22268_(Attributes.f_22278_, 1.0D).m_22268_(Attributes.f_22277_, 50.0D).m_22268_((Attribute)ForgeMod.STEP_HEIGHT_ADDITION.get(), 2.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float m_6431_(Pose p_21131_, EntityDimensions p_21132_) {
/* 142 */     return 2.0F;
/*     */   }
/*     */   
/*     */   public int maxBrightness() {
/* 146 */     List<Integer> brightnesses = Lists.newArrayList();
/* 147 */     AABB aabb = m_20191_().m_82400_(1.0D);
/* 148 */     for (BlockPos pos : BlockPos.m_121976_(Mth.m_14107_(aabb.f_82288_), Mth.m_14107_(aabb.f_82289_), Mth.m_14107_(aabb.f_82290_), Mth.m_14107_(aabb.f_82291_), Mth.m_14107_(aabb.f_82292_), Mth.m_14107_(aabb.f_82293_))) {
/* 149 */       brightnesses.add(Integer.valueOf(this.f_19853_.m_45517_(LightLayer.BLOCK, pos)));
/*     */     }
/* 151 */     brightnesses.sort(Collections.reverseOrder());
/* 152 */     return ((Integer)brightnesses.get(0)).intValue();
/*     */   }
/*     */   
/*     */   public boolean isBrightEnoughToBurn() {
/* 156 */     return (maxBrightness() > 10 || (this.f_19853_.m_46461_() && this.f_19853_.m_45527_(m_20183_())));
/*     */   }
/*     */ 
/*     */   
/*     */   protected float m_6121_() {
/* 161 */     return 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected PathNavigation m_6037_(Level level) {
/* 166 */     return (PathNavigation)new WiltedNavigation((Mob)this, level);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean m_6129_() {
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7601_(BlockState p_20006_, Vec3 p_20007_) {}
/*     */ 
/*     */   
/*     */   protected int m_7302_(int p_28882_) {
/* 179 */     return p_28882_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent m_7515_() {
/* 184 */     return this.f_19796_.m_188499_() ? (SoundEvent)SoundEventInit.WILTED_STEP.get() : (SoundEvent)SoundEventInit.WILTED_IDLE.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public int m_8100_() {
/* 189 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent m_7975_(DamageSource p_33034_) {
/* 194 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_7355_(BlockPos p_20135_, BlockState p_20136_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent m_5592_() {
/* 204 */     return (SoundEvent)SoundEventInit.WILTED_HURT.get();
/*     */   }
/*     */   
/*     */   public LivingEntity getOwner() {
/* 208 */     Entity target = (this.ownerID == null || this.f_19853_.m_5776_()) ? null : ((ServerLevel)this.f_19853_).m_8791_(this.ownerID);
/* 209 */     LivingEntity living = (LivingEntity)target; return (target instanceof LivingEntity) ? living : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(CompoundTag tag) {
/* 214 */     super.m_7378_(tag);
/* 215 */     if (tag.m_128441_("OwnerID")) {
/*     */       UUID uuid;
/* 217 */       if (tag.m_128403_("OwnerID")) {
/* 218 */         uuid = tag.m_128342_("OwnerID");
/*     */       } else {
/* 220 */         String s = tag.m_128461_("OwnerID");
/* 221 */         uuid = OldUsersConverter.m_11083_(m_20194_(), s);
/*     */       } 
/*     */       
/* 224 */       if (uuid != null) {
/*     */         try {
/* 226 */           this.ownerID = uuid;
/* 227 */         } catch (Throwable throwable) {
/* 228 */           this.ownerID = null;
/*     */         } 
/*     */       }
/*     */     } 
/* 232 */     if (tag.m_128441_("LifeTime")) {
/* 233 */       this.lifeTime = tag.m_128451_("LifeTime");
/*     */     }
/*     */   }
/*     */   
/*     */   public void m_7380_(CompoundTag tag) {
/* 238 */     super.m_7380_(tag);
/* 239 */     if (this.ownerID != null)
/* 240 */       tag.m_128362_("OwnerID", this.ownerID); 
/* 241 */     tag.m_128405_("LifeTime", this.lifeTime);
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\entities\ShadowWilted.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */