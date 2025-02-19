/*     */ package com.alexander.rootoffear.entities;
/*     */ import com.alexander.rootoffear.ai.controllers.wilted.WiltedBodyRotationControl;
/*     */ import com.alexander.rootoffear.ai.controllers.wilted.WiltedLookControl;
/*     */ import com.alexander.rootoffear.ai.controllers.wilted.WiltedMoveControl;
/*     */ import com.alexander.rootoffear.ai.controllers.wilted.WiltedNavigation;
/*     */ import com.alexander.rootoffear.ai.goals.AdvancedNearestAttackableTargetGoal;
/*     */ import com.alexander.rootoffear.ai.goals.LookAtTargetGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedAvoidLightGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedBreakBlocksGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedCreateBarriersGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedCreateShadowsGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedExtinguishLightsGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedFreezeWhenLookedAtGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedGrabAttackGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedGroundGrabGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedLeafStormGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedLeapToMoveTargetGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedLightExtinguisherPullGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedRevealGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedTeleportGoal;
/*     */ import com.alexander.rootoffear.ai.goals.wilted.WiltedTeleportToMoveTargetGoal;
/*     */ import com.alexander.rootoffear.animations.WalkAnimationState;
/*     */ import com.alexander.rootoffear.capabilities.RoFLevelCapability;
/*     */ import com.alexander.rootoffear.capabilities.RoFLevelCapabilityProvider;
/*     */ import com.alexander.rootoffear.config.RoFCommonConfig;
/*     */ import com.alexander.rootoffear.events.CameraShakeEvents;
/*     */ import com.alexander.rootoffear.init.EntityTypeInit;
/*     */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
/*     */ import com.alexander.rootoffear.utils.MiscUtils;
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.awt.Color;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.ClientLevel;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.syncher.EntityDataAccessor;
/*     */ import net.minecraft.network.syncher.EntityDataSerializers;
/*     */ import net.minecraft.network.syncher.SynchedEntityData;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.players.OldUsersConverter;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.AnimationState;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityDimensions;
/*     */ import net.minecraft.world.entity.EntitySelector;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.Pose;
/*     */ import net.minecraft.world.entity.SpawnPlacements;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.control.BodyRotationControl;
/*     */ import net.minecraft.world.entity.ai.control.LookControl;
/*     */ import net.minecraft.world.entity.ai.control.MoveControl;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
/*     */ import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
/*     */ import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
/*     */ import net.minecraft.world.entity.ai.navigation.PathNavigation;
/*     */ import net.minecraft.world.entity.ai.targeting.TargetingConditions;
/*     */ import net.minecraft.world.entity.animal.Cat;
/*     */ import net.minecraft.world.entity.animal.Wolf;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LightLayer;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.biome.Biome;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import net.minecraft.world.level.pathfinder.BlockPathTypes;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.BooleanOp;
/*     */ import net.minecraft.world.phys.shapes.Shapes;
/*     */ import net.minecraftforge.common.ForgeMod;
/*     */ 
/*     */ public class Wilted extends Monster {
/*  95 */   private static final EntityDataAccessor<Boolean> DATA_NATURALLY_SPAWNED_ID = SynchedEntityData.m_135353_(Wilted.class, EntityDataSerializers.f_135035_);
/*  96 */   private static final EntityDataAccessor<Boolean> DATA_DISGUISED_ID = SynchedEntityData.m_135353_(Wilted.class, EntityDataSerializers.f_135035_);
/*  97 */   private static final EntityDataAccessor<Boolean> DATA_PHASING_THROUGH_WALL_ID = SynchedEntityData.m_135353_(Wilted.class, EntityDataSerializers.f_135035_);
/*  98 */   private static final EntityDataAccessor<Integer> SILENT_TIMER = SynchedEntityData.m_135353_(Wilted.class, EntityDataSerializers.f_135028_);
/*  99 */   public static final TargetingConditions TARGETING = TargetingConditions.m_148352_().m_148355_().m_26893_();
/*     */   
/*     */   public UUID ultimateTargetID;
/*     */   
/* 103 */   public AnimationState hurtAnimationState = new AnimationState();
/* 104 */   public AnimationState idleAnimationState = new AnimationState();
/* 105 */   public AnimationState attackAnimationState = new AnimationState();
/* 106 */   public AnimationState revealAnimationState = new AnimationState();
/* 107 */   public AnimationState teleportAnimationState = new AnimationState();
/* 108 */   public AnimationState breakBlocksAnimationState = new AnimationState();
/* 109 */   public AnimationState leapAnimationState = new AnimationState();
/* 110 */   public AnimationState landAnimationState = new AnimationState();
/* 111 */   public AnimationState groundGrabAnimationState = new AnimationState();
/* 112 */   public AnimationState spearAnimationState = new AnimationState();
/* 113 */   public AnimationState twitchingAnimationState = new AnimationState();
/* 114 */   public AnimationState deathAnimationState = new AnimationState();
/* 115 */   public final WalkAnimationState walkAnimation = new WalkAnimationState();
/*     */   
/* 117 */   public static final Color revealedLeafColour = new Color(12897215);
/* 118 */   public int leafColour = 0;
/*     */   
/*     */   public boolean wantsToReveal = false;
/*     */   
/*     */   public int wantsToRevealCooldown;
/*     */   public boolean willDisguiseOnNextTeleport = false;
/* 124 */   public final EntityDimensions disguisedDimensions = EntityDimensions.m_20395_(1.0F, 4.0F);
/*     */   
/* 126 */   public BlockPos teleportTargetPos = null;
/*     */   
/*     */   public boolean disableRendering = false;
/*     */   
/* 130 */   public double targetMovementSpeed = 0.2D;
/* 131 */   public double wallPhasingMovementSpeed = 0.2D;
/*     */   
/*     */   public int notPhasingThroughWallFor;
/*     */   
/*     */   public int bottomInGroundTime;
/*     */   
/*     */   public int aggroCooldown;
/*     */   
/*     */   public boolean wantsToGoDownwards = false;
/*     */   
/*     */   public int phasingThroughWallTick;
/*     */   
/*     */   public float walkAnimPosO;
/*     */   
/*     */   public int wallUnstuckCooldown;
/*     */   
/*     */   public List<Goal> allBonusBehaviours;
/*     */   public List<Goal> chosenBonusBehaviours;
/*     */   public int lastPulseGlow;
/*     */   public int pulseCooldown;
/*     */   public boolean stillShowingLeaves = false;
/*     */   public int skyDarkenO;
/*     */   public int rerollBonusBehavioursCooldown;
/*     */   
/*     */   public Wilted(EntityType<? extends Wilted> type, Level level) {
/* 156 */     super(type, level);
/* 157 */     m_21441_(BlockPathTypes.WATER, 0.0F);
/* 158 */     m_21441_(BlockPathTypes.WATER_BORDER, 0.0F);
/* 159 */     m_21441_(BlockPathTypes.DANGER_OTHER, 0.0F);
/* 160 */     m_21441_(BlockPathTypes.DAMAGE_OTHER, 0.0F);
/* 161 */     m_21441_(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
/* 162 */     m_21441_(BlockPathTypes.FENCE, 0.0F);
/* 163 */     this.f_21342_ = (MoveControl)new WiltedMoveControl((Mob)this);
/* 164 */     this.f_21365_ = (LookControl)new WiltedLookControl(this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/* 168 */     this.chosenBonusBehaviours = Lists.newArrayList();
/* 169 */     this.allBonusBehaviours = Lists.newArrayList((Object[])new Goal[] { (Goal)new WiltedCreateDecoyGoal(this), (Goal)new WiltedTeleportToMoveTargetGoal(this), (Goal)new WiltedLeapToMoveTargetGoal(this), (Goal)new WiltedBreakBlocksGoal(this), (Goal)new WiltedGroundGrabGoal(this), (Goal)new WiltedLeafStormGoal(this), (Goal)new WiltedCreateShadowsGoal(this), (Goal)new WiltedBecomeSilentGoal(this), (Goal)new WiltedLightExtinguisherPullGoal(this), (Goal)new WiltedCreateBarriersGoal(this) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     randomiseBonusBehaviours();
/* 182 */     int p = 0;
/* 183 */     this.f_21345_.m_25352_(p++, (Goal)new WiltedRevealGoal(this));
/* 184 */     this.f_21345_.m_25352_(p++, (Goal)new WiltedTeleportGoal(this));
/* 185 */     this.f_21345_.m_25352_(p++, (Goal)new WiltedFreezeWhenLookedAtGoal(this));
/* 186 */     this.f_21345_.m_25352_(p++, (Goal)new WiltedGrabAttackGoal(this));
/* 187 */     this.f_21345_.m_25352_(p++, (Goal)new WiltedAvoidLightGoal(this));
/* 188 */     this.f_21345_.m_25352_(p++, (Goal)new WiltedExtinguishLightsGoal(this));
/* 189 */     for (Goal goal : this.allBonusBehaviours) {
/* 190 */       this.f_21345_.m_25352_(p++, goal);
/*     */     }
/* 192 */     this.f_21345_.m_25352_(p++, (Goal)new WiltedApproachUltimateTargetGoal(this));
/* 193 */     this.f_21345_.m_25352_(p++, (Goal)new LookAtTargetGoal((Mob)this));
/* 194 */     this.f_21345_.m_25352_(p++, (Goal)new WiltedApproachTargetGoal((Mob)this));
/* 195 */     this.f_21345_.m_25352_(p++, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0D));
/* 196 */     this.f_21345_.m_25352_(p++, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0F));
/* 197 */     this.f_21345_.m_25352_(p++, (Goal)new RandomLookAroundGoal((Mob)this));
/* 198 */     this.f_21346_.m_25352_(0, (Goal)new AdvancedNearestAttackableTargetGoal((Mob)this, Player.class, false, false, true, true, null));
/*     */   }
/*     */   
/*     */   public void randomiseBonusBehaviours() {
/* 202 */     List<Goal> bonusBehaviours = Lists.newArrayList();
/* 203 */     bonusBehaviours.addAll(this.allBonusBehaviours);
/* 204 */     this.chosenBonusBehaviours.clear();
/* 205 */     for (int i = 0; i < ((Integer)RoFCommonConfig.wilted_bonus_behaviour_amount.get()).intValue(); i++) {
/* 206 */       if (!bonusBehaviours.isEmpty()) {
/* 207 */         Collections.shuffle(bonusBehaviours);
/* 208 */         Goal goal = bonusBehaviours.get(0);
/* 209 */         this.chosenBonusBehaviours.add(goal);
/* 210 */         bonusBehaviours.remove(goal);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected int m_7302_(int p_28882_) {
/* 216 */     return p_28882_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_20067_() {
/* 221 */     return (super.m_20067_() || getSilentTimer() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent m_7515_() {
/* 226 */     return isDisguised() ? null : (SoundEvent)SoundEventInit.WILTED_IDLE.get();
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent m_7975_(DamageSource p_33034_) {
/* 231 */     return (SoundEvent)SoundEventInit.WILTED_HURT.get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_7355_(BlockPos p_20135_, BlockState p_20136_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent m_5592_() {
/* 241 */     return (SoundEvent)SoundEventInit.WILTED_DEATH.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public float m_6121_() {
/* 246 */     return 3.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float m_6100_() {
/* 251 */     return m_21224_() ? 1.0F : super.m_6100_();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean m_6129_() {
/* 256 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7601_(BlockState p_20006_, Vec3 p_20007_) {}
/*     */ 
/*     */   
/*     */   public static BlockPos findSpawnablePosition(BlockPos origin, ServerLevel level, int minDistance, int maxDistance, int minDistanceFromAnyPlayer, int tries, boolean surface) {
/* 264 */     BlockPos blockpos = null;
/*     */     
/* 266 */     for (int i = 0; i < tries; i++) {
/* 267 */       int j = origin.m_123341_() + level.f_46441_.m_188503_(maxDistance * 2) - maxDistance;
/* 268 */       int k = origin.m_123343_() + level.f_46441_.m_188503_(maxDistance * 2) - maxDistance;
/* 269 */       int l = surface ? level.m_6924_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, j, k) : origin.m_123342_();
/* 270 */       BlockPos blockpos1 = new BlockPos(j, l, k);
/*     */       
/* 272 */       if (!surface) {
/* 273 */         blockpos1 = PositionUtils.moveToGroundHeight((Level)level, blockpos1, 15);
/*     */       }
/*     */       
/* 276 */       if (blockpos1 != null) {
/* 277 */         boolean somebodyLookingHere = false;
/* 278 */         for (Player player2 : level.m_6907_()) {
/* 279 */           if (MiscUtils.inSurvivalMode((LivingEntity)player2) && (isLookingAt(player2, blockpos1) || PositionUtils.distanceTo(player2.m_20183_(), blockpos1) < minDistanceFromAnyPlayer)) {
/* 280 */             somebodyLookingHere = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 285 */         if (PositionUtils.distanceTo(origin, blockpos1) >= minDistance && level.m_45517_(LightLayer.BLOCK, blockpos1) <= 1 && !somebodyLookingHere && isPosSpawnableForWilted(level, blockpos1) && ((surface && level.m_45527_(blockpos1.m_7494_())) || !surface)) {
/* 286 */           blockpos = blockpos1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 292 */     return blockpos;
/*     */   }
/*     */   
/*     */   public static boolean checkWiltedSpawnRules(EntityType<? extends Wilted> entity, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
/* 296 */     return (level.m_8055_(pos.m_7495_()).m_60643_((BlockGetter)level, pos.m_7495_(), entity) && level.m_6425_(pos).m_76178_() && m_219009_(level, pos, random));
/*     */   }
/*     */   
/*     */   public static boolean isPosSpawnableForWilted(ServerLevel level, BlockPos pos) {
/* 300 */     if (level.m_45772_(MiscUtils.getSpawnAABB((EntityType)EntityTypeInit.WILTED.get(), pos.m_123341_() + 0.5D, pos.m_123342_(), pos.m_123343_() + 0.5D))) {
/* 301 */       BlockPos blockpos = new BlockPos(pos.m_123341_() + 0.5D, pos.m_123342_(), pos.m_123343_() + 0.5D);
/* 302 */       return SpawnPlacements.m_217074_((EntityType)EntityTypeInit.WILTED.get(), (ServerLevelAccessor)level, MobSpawnType.SPAWNER, blockpos, level.m_213780_());
/*     */     } 
/* 304 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityDimensions m_6972_(Pose p_21047_) {
/* 310 */     return isDisguised() ? this.disguisedDimensions : super.m_6972_(p_21047_);
/*     */   }
/*     */   
/*     */   public void m_7350_(EntityDataAccessor<?> p_33609_) {
/* 314 */     if (DATA_DISGUISED_ID.equals(p_33609_)) {
/* 315 */       m_6210_();
/*     */     }
/*     */     
/* 318 */     super.m_7350_(p_33609_);
/*     */   }
/*     */   
/*     */   public boolean isLookingAtMe(Player player) {
/* 322 */     return isLookingAt(player, m_20185_(), m_20188_(), m_20189_());
/*     */   }
/*     */   
/*     */   public static boolean isLookingAt(Player player, BlockPos pos) {
/* 326 */     return isLookingAt(player, pos.m_123341_() + 0.5D, pos.m_123342_() + 0.5D, pos.m_123343_() + 0.5D);
/*     */   }
/*     */   
/*     */   public static boolean isLookingAt(Player player, double x, double y, double z) {
/* 330 */     Vec3 vec3 = player.m_20252_(1.0F).m_82541_();
/* 331 */     Vec3 vec31 = new Vec3(x - player.m_20185_(), y - player.m_20188_(), z - player.m_20189_());
/* 332 */     vec31 = vec31.m_82541_();
/* 333 */     double d1 = vec3.m_82526_(vec31);
/* 334 */     return (d1 > 0.5D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_6043_() {}
/*     */ 
/*     */   
/*     */   protected void m_8097_() {
/* 343 */     super.m_8097_();
/* 344 */     this.f_19804_.m_135372_(DATA_DISGUISED_ID, Boolean.valueOf(false));
/* 345 */     this.f_19804_.m_135372_(DATA_NATURALLY_SPAWNED_ID, Boolean.valueOf(false));
/* 346 */     this.f_19804_.m_135372_(DATA_PHASING_THROUGH_WALL_ID, Boolean.valueOf(false));
/* 347 */     this.f_19804_.m_135372_(SILENT_TIMER, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   public void setDisguised(boolean value) {
/* 351 */     this.f_19804_.m_135381_(DATA_DISGUISED_ID, Boolean.valueOf(value));
/*     */   }
/*     */   
/*     */   public boolean isDisguised() {
/* 355 */     return ((Boolean)this.f_19804_.m_135370_(DATA_DISGUISED_ID)).booleanValue();
/*     */   }
/*     */   
/*     */   public void setNaturallySpawned(boolean value) {
/* 359 */     this.f_19804_.m_135381_(DATA_NATURALLY_SPAWNED_ID, Boolean.valueOf(value));
/*     */   }
/*     */   
/*     */   public boolean isNaturallySpawned() {
/* 363 */     return ((Boolean)this.f_19804_.m_135370_(DATA_NATURALLY_SPAWNED_ID)).booleanValue();
/*     */   }
/*     */   
/*     */   public void setWasPhasingThroughWall(boolean value) {
/* 367 */     this.f_19804_.m_135381_(DATA_PHASING_THROUGH_WALL_ID, Boolean.valueOf(value));
/*     */   }
/*     */   
/*     */   public boolean wasPhasingThroughWall() {
/* 371 */     return ((Boolean)this.f_19804_.m_135370_(DATA_PHASING_THROUGH_WALL_ID)).booleanValue();
/*     */   }
/*     */   
/*     */   public void setSilentTimer(int value) {
/* 375 */     this.f_19804_.m_135381_(SILENT_TIMER, Integer.valueOf(value));
/*     */   }
/*     */   
/*     */   public int getSilentTimer() {
/* 379 */     return ((Integer)this.f_19804_.m_135370_(SILENT_TIMER)).intValue();
/*     */   }
/*     */   
/*     */   public LivingEntity getUltimateTarget() {
/* 383 */     Entity target = (this.ultimateTargetID == null || this.f_19853_.m_5776_()) ? null : ((ServerLevel)this.f_19853_).m_8791_(this.ultimateTargetID);
/* 384 */     LivingEntity living = (LivingEntity)target; return (target instanceof LivingEntity) ? living : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(CompoundTag tag) {
/* 389 */     super.m_7380_(tag);
/* 390 */     if (this.ultimateTargetID != null) {
/* 391 */       tag.m_128362_("UltimateTargetID", this.ultimateTargetID);
/*     */     }
/* 393 */     tag.m_128379_("Disguised", isDisguised());
/* 394 */     tag.m_128379_("NaturallySpawned", isNaturallySpawned());
/* 395 */     tag.m_128405_("LeafColour", this.leafColour);
/* 396 */     tag.m_128405_("RerollBonusBehavioursCooldown", this.rerollBonusBehavioursCooldown);
/* 397 */     if (!this.f_19853_.m_5776_()) {
/* 398 */       int i = 0;
/* 399 */       for (Goal goal : this.chosenBonusBehaviours) {
/* 400 */         tag.m_128405_("BonusBehaviour" + i, this.allBonusBehaviours.indexOf(goal));
/* 401 */         i++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void m_7378_(CompoundTag tag) {
/*     */     UUID uuid;
/* 408 */     super.m_7378_(tag);
/*     */     
/* 410 */     if (tag.m_128403_("UltimateTargetID")) {
/* 411 */       uuid = tag.m_128342_("UltimateTargetID");
/*     */     } else {
/* 413 */       String s = tag.m_128461_("UltimateTargetID");
/* 414 */       uuid = OldUsersConverter.m_11083_(m_20194_(), s);
/*     */     } 
/*     */     
/* 417 */     if (uuid != null) {
/*     */       try {
/* 419 */         this.ultimateTargetID = uuid;
/* 420 */       } catch (Throwable throwable) {
/* 421 */         this.ultimateTargetID = null;
/*     */       } 
/*     */     }
/* 424 */     setDisguised(tag.m_128471_("Disguised"));
/* 425 */     setNaturallySpawned(tag.m_128471_("NaturallySpawned"));
/* 426 */     this.leafColour = tag.m_128451_("LeafColour");
/* 427 */     this.rerollBonusBehavioursCooldown = tag.m_128451_("RerollBonusBehavioursCooldown");
/* 428 */     if (this.f_19853_ instanceof ServerLevel) {
/* 429 */       int i = 0;
/* 430 */       while (tag.m_128441_("BonusBehaviour" + i)) {
/* 431 */         if (i == 0) {
/* 432 */           this.chosenBonusBehaviours.clear();
/*     */         }
/* 434 */         this.chosenBonusBehaviours.add(this.allBonusBehaviours.get(tag.m_128451_("BonusBehaviour" + i)));
/* 435 */         i++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int maxBrightness() {
/* 441 */     List<Integer> brightnesses = Lists.newArrayList();
/* 442 */     AABB aabb = m_20191_().m_82400_(1.0D);
/* 443 */     for (BlockPos pos : BlockPos.m_121976_(Mth.m_14107_(aabb.f_82288_), Mth.m_14107_(aabb.f_82289_), Mth.m_14107_(aabb.f_82290_), Mth.m_14107_(aabb.f_82291_), Mth.m_14107_(aabb.f_82292_), Mth.m_14107_(aabb.f_82293_))) {
/* 444 */       brightnesses.add(Integer.valueOf(this.f_19853_.m_45517_(LightLayer.BLOCK, pos)));
/*     */     }
/* 446 */     brightnesses.sort(Collections.reverseOrder());
/* 447 */     return ((Integer)brightnesses.get(0)).intValue();
/*     */   }
/*     */   
/*     */   public boolean canPhaseThroughWalls() {
/* 451 */     return (this.f_19853_.m_46749_(m_20183_()) && !this.f_19853_.m_46461_() && maxBrightness() < 3);
/*     */   }
/*     */   
/*     */   public boolean isPhasingThroughWall() {
/* 455 */     AABB aabb = wasPhasingThroughWall() ? m_20191_().m_82377_(0.05D, 0.0D, 0.05D) : m_20191_().m_165887_(m_20188_()).m_82377_(0.05D, 0.0D, 0.05D);
/* 456 */     return (canPhaseThroughWalls() && BlockPos.m_121921_(aabb).anyMatch(p_201942_ -> {
/*     */           BlockState blockstate = this.f_19853_.m_8055_(p_201942_);
/* 458 */           return (!blockstate.m_60795_() && Shapes.m_83157_(blockstate.m_60812_((BlockGetter)this.f_19853_, p_201942_).m_83216_(p_201942_.m_123341_(), p_201942_.m_123342_(), p_201942_.m_123343_()), Shapes.m_83064_(aabb), BooleanOp.f_82689_));
/*     */         }));
/*     */   }
/*     */   
/*     */   public boolean isStuckInWall() {
/* 463 */     AABB aabb = m_20191_().m_82377_(-0.05D, -0.05D, -0.05D);
/* 464 */     return (!canPhaseThroughWalls() && BlockPos.m_121921_(aabb).anyMatch(p_201942_ -> {
/*     */           BlockState blockstate = this.f_19853_.m_8055_(p_201942_);
/* 466 */           return (!blockstate.m_60795_() && Shapes.m_83157_(blockstate.m_60812_((BlockGetter)this.f_19853_, p_201942_).m_83216_(p_201942_.m_123341_(), p_201942_.m_123342_(), p_201942_.m_123343_()), Shapes.m_83064_(aabb), BooleanOp.f_82689_));
/*     */         }));
/*     */   }
/*     */   
/*     */   public boolean bottomIsInGround() {
/* 471 */     AABB aabb = m_20191_().m_165893_(m_20186_() + 1.1D).m_82377_(0.05D, 0.0D, 0.05D);
/* 472 */     return (canPhaseThroughWalls() && BlockPos.m_121921_(aabb).anyMatch(p_201942_ -> {
/*     */           BlockState blockstate = this.f_19853_.m_8055_(p_201942_);
/* 474 */           return (!blockstate.m_60795_() && Shapes.m_83157_(blockstate.m_60812_((BlockGetter)this.f_19853_, p_201942_).m_83216_(p_201942_.m_123341_(), p_201942_.m_123342_(), p_201942_.m_123343_()), Shapes.m_83064_(aabb), BooleanOp.f_82689_));
/*     */         }));
/*     */   }
/*     */   
/*     */   public boolean isNearWall() {
/* 479 */     AABB aabb = m_20191_().m_82377_(0.5D, 0.0D, 0.5D).m_165887_(m_20186_() + 1.1D);
/* 480 */     return (canPhaseThroughWalls() && BlockPos.m_121921_(aabb).anyMatch(p_201942_ -> {
/*     */           BlockState blockstate = this.f_19853_.m_8055_(p_201942_);
/* 482 */           return (!blockstate.m_60795_() && Shapes.m_83157_(blockstate.m_60812_((BlockGetter)this.f_19853_, p_201942_).m_83216_(p_201942_.m_123341_(), p_201942_.m_123342_(), p_201942_.m_123343_()), Shapes.m_83064_(aabb), BooleanOp.f_82689_));
/*     */         }));
/*     */   }
/*     */ 
/*     */   
/*     */   protected PathNavigation m_6037_(Level level) {
/* 488 */     return (PathNavigation)new WiltedNavigation((Mob)this, level);
/*     */   }
/*     */ 
/*     */   
/*     */   protected BodyRotationControl m_7560_() {
/* 493 */     return (BodyRotationControl)new WiltedBodyRotationControl(this);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 497 */     return Monster.m_33035_().m_22268_(Attributes.f_22276_, 200.0D).m_22268_(Attributes.f_22279_, 0.2D).m_22268_(Attributes.f_22278_, 1.0D).m_22268_(Attributes.f_22277_, 20.0D).m_22268_((Attribute)ForgeMod.STEP_HEIGHT_ADDITION.get(), 2.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float m_6431_(Pose p_21131_, EntityDimensions p_21132_) {
/* 502 */     return 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6075_() {
/* 507 */     super.m_6075_();
/*     */     
/* 509 */     if (!this.f_19853_.m_5776_() && this.rerollBonusBehavioursCooldown <= 0 && this.f_19853_.m_7445_() < this.skyDarkenO) {
/* 510 */       randomiseBonusBehaviours();
/* 511 */       this.rerollBonusBehavioursCooldown = 6000;
/*     */     } 
/* 513 */     this.skyDarkenO = this.f_19853_.m_7445_();
/*     */     
/* 515 */     if (this.rerollBonusBehavioursCooldown > 0) {
/* 516 */       this.rerollBonusBehavioursCooldown--;
/*     */     }
/*     */     
/* 519 */     if (!this.f_19853_.m_5776_()) {
/* 520 */       if (getSilentTimer() > 0) {
/* 521 */         setSilentTimer(getSilentTimer() - 1);
/*     */       }
/* 523 */       setWasPhasingThroughWall(isPhasingThroughWall());
/*     */     } 
/*     */     
/* 526 */     this.wantsToGoDownwards = false;
/*     */     
/* 528 */     if (this.f_19853_.m_5776_()) {
/* 529 */       this.idleAnimationState.m_216982_(this.f_19797_);
/* 530 */       if (!isDisguised()) {
/* 531 */         this.twitchingAnimationState.m_216982_(this.f_19797_);
/*     */       } else {
/* 533 */         this.twitchingAnimationState.m_216973_();
/*     */       } 
/* 535 */       if (m_21224_()) {
/* 536 */         this.deathAnimationState.m_216982_(this.f_19797_);
/*     */       } else {
/* 538 */         this.deathAnimationState.m_216973_();
/*     */       } 
/*     */       
/* 541 */       if (!isDisguised() && this.pulseCooldown > 0 && this.f_19796_.m_188499_()) {
/* 542 */         this.f_19853_.m_7107_((ParticleOptions)ParticleTypeInit.WILTED_GLOW.get(), m_20208_(1.0D), m_20187_(), m_20262_(1.0D), 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */       
/* 545 */       if (this.f_19796_.m_188503_(isDisguised() ? 30 : 60) == 0) {
/* 546 */         createLeafParticle();
/*     */       }
/*     */       
/* 549 */       if (this.leafColour == 0) {
/* 550 */         this.leafColour = ((Biome)((ClientLevel)this.f_19853_).m_204166_(m_20183_()).get()).m_47542_();
/*     */       }
/*     */       
/* 553 */       if (wasPhasingThroughWall() || (this.teleportAnimationState.m_216984_() && !m_217003_(Pose.STANDING))) {
/* 554 */         CameraShakeEvents.addCameraShake(this.f_19853_, 3, 0.1F, m_20183_(), 10);
/* 555 */         if (this.phasingThroughWallTick % 20 == 0) {
/* 556 */           AABB aabb = m_20191_().m_82400_(1.0D);
/*     */           
/* 558 */           for (BlockPos blockpos : BlockPos.m_121976_(Mth.m_14107_(aabb.f_82288_), Mth.m_14107_(aabb.f_82289_), Mth.m_14107_(aabb.f_82290_), Mth.m_14107_(aabb.f_82291_), Mth.m_14107_(aabb.f_82292_), Mth.m_14107_(aabb.f_82293_))) {
/* 559 */             if (PositionUtils.distanceTo(m_20183_().m_6630_(2), blockpos) <= aabb.m_82362_() && PositionUtils.isBlockCollidable(this.f_19853_, blockpos)) {
/* 560 */               this.f_19853_.m_7106_((ParticleOptions)ParticleTypeInit.WILTED_WALL.get(), blockpos.m_123341_(), blockpos.m_123342_(), blockpos.m_123343_(), 0.0D, 0.0D, 0.0D);
/*     */             }
/*     */           } 
/*     */         } 
/* 564 */         this.phasingThroughWallTick++;
/*     */       } else {
/* 566 */         this.phasingThroughWallTick = 0;
/*     */       } 
/*     */     } else {
/* 569 */       if (this.wantsToRevealCooldown-- <= 0 && MiscUtils.isEntityValid(m_5448_())) {
/* 570 */         this.wantsToReveal = true;
/*     */       }
/*     */       
/* 573 */       if (this.f_19797_ % 30 == 0) {
/* 574 */         for (Cat cat : this.f_19853_.m_6443_(Cat.class, m_20191_().m_82400_(50.0D), EntitySelector.f_20402_)) {
/* 575 */           if (this.f_19796_.m_188503_(5) == 0) {
/* 576 */             cat.m_28167_();
/*     */           }
/*     */         } 
/*     */         
/* 580 */         for (Wolf wolf : this.f_19853_.m_6443_(Wolf.class, m_20191_().m_82400_(50.0D), EntitySelector.f_20402_)) {
/* 581 */           if (this.f_19796_.m_188503_(5) == 0) {
/* 582 */             wolf.m_5496_(SoundEvents.f_12620_, 0.4F, wolf.m_6100_());
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 587 */       if (m_21573_().m_26572_() && (isPhasingThroughWall() || (m_20072_() && m_21573_().m_26570_().m_77406_().m_123342_() > m_20186_() && PositionUtils.distanceTo((Entity)this, new BlockPos(m_21573_().m_26570_().m_77406_().m_123341_(), (int)m_20186_(), m_21573_().m_26570_().m_77406_().m_123343_())) <= 4.0F) || (m_20096_() && m_21573_().m_26570_().m_77406_().m_123342_() < m_20186_() - 0.1D && PositionUtils.distanceTo((Entity)this, new BlockPos(m_21573_().m_26570_().m_77406_().m_123341_(), (int)m_20186_(), m_21573_().m_26570_().m_77406_().m_123343_())) <= 6.0F && !PositionUtils.hasLineOfSight((Entity)this, m_21573_().m_26570_().m_77406_())))) {
/* 588 */         this.wantsToGoDownwards = (m_21573_().m_26570_().m_77406_().m_123342_() < m_20186_() - 0.1D);
/* 589 */         if (this.wantsToGoDownwards || m_21573_().m_26570_().m_77406_().m_123342_() > m_20186_()) {
/* 590 */           m_20256_(new Vec3((m_20184_()).f_82479_ + m_217043_().m_188583_() * 0.01D, this.wantsToGoDownwards ? -0.1D : 0.1D, (m_20184_()).f_82481_ + m_217043_().m_188583_() * 0.01D));
/* 591 */           if (m_20072_()) {
/* 592 */             m_20256_(m_20184_().m_82542_(0.0D, 10.0D, 0.0D));
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 597 */       if (!this.wantsToGoDownwards && bottomIsInGround()) {
/* 598 */         this.bottomInGroundTime++;
/* 599 */         if (this.bottomInGroundTime > 5) {
/* 600 */           m_20256_(new Vec3((m_20184_()).f_82479_ + m_217043_().m_188583_() * 0.01D, 0.1D, (m_20184_()).f_82481_ + m_217043_().m_188583_() * 0.01D));
/*     */         }
/*     */       } else {
/* 603 */         this.bottomInGroundTime = 0;
/*     */       } 
/*     */       
/* 606 */       Level level = this.f_19853_; if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 607 */         if (serverLevel.m_46461_() && !this.f_19853_.m_45527_(m_20183_())) {
/* 608 */           boolean lookedAt = false;
/* 609 */           for (Player player : serverLevel.m_6907_()) {
/* 610 */             if (isLookingAtMe(player) && player.m_142582_((Entity)this) && MiscUtils.isEntityValid((LivingEntity)player) && !player.m_5833_()) {
/* 611 */               lookedAt = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 615 */           if (!lookedAt) {
/* 616 */             m_146870_();
/*     */           }
/*     */         } 
/* 619 */         if (isNaturallySpawned()) {
/* 620 */           serverLevel.getCapability(RoFLevelCapabilityProvider.CAP).ifPresent(capability -> {
/*     */                 // Byte code:
/*     */                 //   0: aload_2
/*     */                 //   1: invokevirtual getWiltedID : ()Ljava/util/UUID;
/*     */                 //   4: ifnull -> 36
/*     */                 //   7: aload_1
/*     */                 //   8: aload_2
/*     */                 //   9: invokevirtual getWiltedID : ()Ljava/util/UUID;
/*     */                 //   12: invokevirtual m_8791_ : (Ljava/util/UUID;)Lnet/minecraft/world/entity/Entity;
/*     */                 //   15: astore #4
/*     */                 //   17: aload #4
/*     */                 //   19: instanceof com/alexander/rootoffear/entities/Wilted
/*     */                 //   22: ifeq -> 36
/*     */                 //   25: aload #4
/*     */                 //   27: checkcast com/alexander/rootoffear/entities/Wilted
/*     */                 //   30: astore_3
/*     */                 //   31: aload_3
/*     */                 //   32: aload_0
/*     */                 //   33: if_acmpne -> 43
/*     */                 //   36: aload_2
/*     */                 //   37: invokevirtual getWiltedID : ()Ljava/util/UUID;
/*     */                 //   40: ifnonnull -> 47
/*     */                 //   43: aload_0
/*     */                 //   44: invokevirtual m_146870_ : ()V
/*     */                 //   47: return
/*     */                 // Line number table:
/*     */                 //   Java source line number -> byte code offset
/*     */                 //   #621	-> 0
/*     */                 //   #622	-> 43
/*     */                 //   #624	-> 47
/*     */                 // Local variable table:
/*     */                 //   start	length	slot	name	descriptor
/*     */                 //   17	14	4	patt27112$temp	Lnet/minecraft/world/entity/Entity;
/*     */                 //   31	5	3	wilted	Lcom/alexander/rootoffear/entities/Wilted;
/*     */                 //   0	48	0	this	Lcom/alexander/rootoffear/entities/Wilted;
/*     */                 //   0	48	1	serverLevel	Lnet/minecraft/server/level/ServerLevel;
/*     */                 //   0	48	2	capability	Lcom/alexander/rootoffear/capabilities/RoFLevelCapability;
/*     */               });
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 627 */         if (this.wallUnstuckCooldown > 0) {
/* 628 */           this.wallUnstuckCooldown--;
/*     */         }
/*     */         
/* 631 */         if (isStuckInWall() && this.wallUnstuckCooldown <= 0) {
/* 632 */           Vec3 pos = m_20182_().m_82520_(0.0D, (m_20206_() / 2.0F), 0.0D);
/* 633 */           int areaSize = 5;
/*     */           
/* 635 */           List<BlockPos> validPositions = Lists.newArrayList();
/*     */           
/* 637 */           for (BlockPos blockpos : BlockPos.m_121976_(Mth.m_14107_(pos.f_82479_ - areaSize), Mth.m_14107_(pos.f_82480_ - areaSize), Mth.m_14107_(pos.f_82481_ - areaSize), Mth.m_14107_(pos.f_82479_ + areaSize), Mth.m_14107_(pos.f_82480_ + areaSize), Mth.m_14107_(pos.f_82481_ + areaSize))) {
/* 638 */             if (PositionUtils.isBlockCollidable((Level)serverLevel, blockpos) && !PositionUtils.isBlockCollidable((Level)serverLevel, blockpos.m_7494_()) && (!m_21573_().m_26572_() || PositionUtils.distanceTo(blockpos, m_21573_().m_26567_()) >= PositionUtils.distanceTo((Entity)this, m_21573_().m_26567_()))) {
/* 639 */               validPositions.add(new BlockPos(blockpos.m_123341_(), blockpos.m_123342_(), blockpos.m_123343_()));
/*     */             }
/*     */           } 
/*     */           
/* 643 */           if (validPositions.size() > 0) {
/* 644 */             Collections.shuffle(validPositions);
/* 645 */             validPositions.sort(PositionUtils.distanceComparator(m_20183_()));
/* 646 */             m_146884_(Vec3.m_82512_((Vec3i)validPositions.get(0)));
/*     */           } 
/* 648 */           this.wallUnstuckCooldown = 20;
/*     */         }  }
/*     */     
/*     */     } 
/*     */     
/* 653 */     if (canPhaseThroughWalls()) {
/* 654 */       if (isNearWall() || isPhasingThroughWall()) {
/* 655 */         m_21441_(BlockPathTypes.BLOCKED, 8.0F);
/*     */       } else {
/* 657 */         m_21441_(BlockPathTypes.BLOCKED, BlockPathTypes.BLOCKED.m_77124_());
/*     */       } 
/* 659 */       m_21441_(BlockPathTypes.LEAVES, 0.0F);
/*     */     } else {
/* 661 */       m_21441_(BlockPathTypes.BLOCKED, BlockPathTypes.BLOCKED.m_77124_());
/* 662 */       m_21441_(BlockPathTypes.LEAVES, BlockPathTypes.LEAVES.m_77124_());
/*     */     } 
/*     */     
/* 665 */     if (this.revealAnimationState.m_216984_()) {
/* 666 */       Color currentColour = new Color(this.leafColour);
/* 667 */       float transitionSpeed = 0.1F;
/* 668 */       this
/*     */ 
/*     */         
/* 671 */         .leafColour = (new Color(Mth.m_14179_(transitionSpeed, currentColour.getRed() / 255.0F, revealedLeafColour.getRed() / 255.0F), Mth.m_14179_(transitionSpeed, currentColour.getGreen() / 255.0F, revealedLeafColour.getGreen() / 255.0F), Mth.m_14179_(transitionSpeed, currentColour.getBlue() / 255.0F, revealedLeafColour.getBlue() / 255.0F))).getRGB();
/*     */     } 
/* 673 */     if (!this.f_19853_.m_5776_() && this.f_19853_.m_46749_(m_20183_()) && !m_20072_()) {
/* 674 */       if (maxBrightness() > 1 || m_6060_()) {
/* 675 */         this.f_19853_.m_7605_((Entity)this, (byte)15);
/* 676 */         if (!isBrightEnoughToBurn()) {
/* 677 */           this.targetMovementSpeed = 0.25D;
/*     */         }
/*     */       } 
/* 680 */       if (isBrightEnoughToBurn()) {
/* 681 */         m_6469_(DamageSource.f_19307_, this.f_19853_.m_46461_() ? 20.0F : 1.0F);
/*     */       }
/*     */     } 
/*     */     
/* 685 */     if (isPhasingThroughWall()) {
/* 686 */       this.wallPhasingMovementSpeed = Math.min(this.wallPhasingMovementSpeed + 0.001D, 0.5D);
/* 687 */       this.targetMovementSpeed = this.wallPhasingMovementSpeed;
/* 688 */       this.notPhasingThroughWallFor = 0;
/*     */     } else {
/* 690 */       this.notPhasingThroughWallFor++;
/* 691 */       if (this.notPhasingThroughWallFor >= 20) {
/* 692 */         this.wallPhasingMovementSpeed = 0.15D;
/*     */       }
/*     */     } 
/*     */     
/* 696 */     m_21051_(Attributes.f_22279_).m_22100_(Mth.m_14139_((isPhasingThroughWall() || maxBrightness() > 1) ? 1.0D : 0.05D, m_21051_(Attributes.f_22279_).m_22115_(), this.targetMovementSpeed));
/* 697 */     this.targetMovementSpeed = 0.25D;
/*     */     
/* 699 */     if (this.pulseCooldown > 0) {
/* 700 */       this.pulseCooldown--;
/*     */     }
/*     */     
/* 703 */     if (this.aggroCooldown > 0) {
/* 704 */       this.aggroCooldown--;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_6153_() {
/* 710 */     this.f_20919_++;
/* 711 */     for (int i = 0; i < 30; i++) {
/* 712 */       this.f_19853_.m_7107_((ParticleOptions)ParticleTypeInit.WILTED_BREAK.get(), m_20208_(1.0D), m_20187_() + m_217043_().m_188501_(), m_20262_(1.0D), m_20185_(), 0.0D, m_20189_());
/*     */     }
/* 714 */     if (this.f_20919_ >= 30 && !this.f_19853_.m_5776_() && !m_213877_()) {
/* 715 */       this.f_19853_.m_7605_((Entity)this, (byte)60);
/* 716 */       m_142687_(Entity.RemovalReason.KILLED);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6667_(DamageSource p_21014_) {
/* 722 */     super.m_6667_(p_21014_);
/* 723 */     if (this.f_19853_.m_5776_()) {
/* 724 */       CameraShakeEvents.addCameraShake(this.f_19853_, 80, 0.25F, m_20183_(), 20);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6060_() {
/* 730 */     return (super.m_6060_() || this.f_20916_ > 0 || m_21224_());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_6135_() {
/* 735 */     if (!isPhasingThroughWall()) {
/* 736 */       super.m_6135_();
/* 737 */       double d0 = this.f_21342_.m_24999_();
/* 738 */       if (d0 > 0.0D) {
/* 739 */         double d1 = m_20184_().m_165925_();
/* 740 */         if (d1 < 0.01D) {
/* 741 */           m_19920_(0.1F, new Vec3(0.0D, 0.0D, 1.0D));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isBrightEnoughToBurn() {
/* 748 */     return (maxBrightness() > 10 || (this.f_19853_.m_46461_() && this.f_19853_.m_45527_(m_20183_())));
/*     */   }
/*     */   
/*     */   public void createLeafParticle() {
/* 752 */     this.f_19853_.m_7107_((ParticleOptions)new AdvancedParticleOption(ParticleTypeInit.WILTED_LEAF, 
/* 753 */           List.of(
/* 754 */             Double.valueOf((isDisguised() ? this.leafColour : revealedLeafColour.getRGB())), 
/* 755 */             Double.valueOf(m_20185_() + this.f_19796_.m_188583_()), 
/* 756 */             Double.valueOf(m_20186_() + ((isDisguised() || this.stillShowingLeaves) ? 4 : 2) + this.f_19796_.m_188583_()), 
/* 757 */             Double.valueOf(m_20189_() + this.f_19796_.m_188583_()))), 
/*     */         
/* 759 */         (Minecraft.m_91087_()).f_91074_.m_20185_(), (Minecraft.m_91087_()).f_91074_.m_20186_(), (Minecraft.m_91087_()).f_91074_.m_20189_(), 0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_21043_(LivingEntity p_21044_, boolean p_21045_) {
/* 764 */     super.m_21043_(p_21044_, p_21045_);
/* 765 */     float f = (float)Mth.m_184648_(m_20185_() - this.f_19854_, p_21045_ ? (m_20186_() - this.f_19855_) : 0.0D, m_20189_() - this.f_19856_);
/* 766 */     updateWalkAnimation(f);
/*     */   }
/*     */   
/*     */   protected void updateWalkAnimation(float speed) {
/* 770 */     float f = Math.min(speed * 4.0F, 1.0F);
/* 771 */     this.walkAnimation.update(f, isDisguised() ? 0.9F : 0.4F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7822_(byte event) {
/* 776 */     if (event > 3 && event < 13) {
/* 777 */       startAnimation(event - 4);
/* 778 */     } else if (event == 19) {
/* 779 */       if (isDisguised() || this.stillShowingLeaves) {
/* 780 */         int i; for (i = 0; i < 5; i++) {
/* 781 */           this.f_19853_.m_7107_((ParticleOptions)ParticleTypeInit.WILTED_BREAK.get(), m_20208_(0.75D), m_20187_(), m_20262_(0.75D), m_20185_(), 0.0D, m_20189_());
/*     */         }
/* 783 */         for (i = 0; i < 5 + this.f_19796_.m_188503_(5); i++) {
/* 784 */           createLeafParticle();
/*     */         }
/*     */       } else {
/* 787 */         for (int i = 0; i < 20 + this.f_19796_.m_188503_(80); i++) {
/* 788 */           this.f_19853_.m_7107_((ParticleOptions)ParticleTypeInit.WILTED_GLOW.get(), m_20208_(1.0D), m_20187_(), m_20262_(1.0D), 0.0D, 0.0D, 0.0D);
/*     */         }
/*     */       } 
/* 791 */       if (!this.revealAnimationState.m_216984_()) {
/* 792 */         this.hurtAnimationState.m_216977_(this.f_19797_);
/*     */       }
/* 794 */     } else if (event == 18) {
/* 795 */       for (int i = 0; i < 250; i++) {
/* 796 */         createLeafParticle();
/*     */       }
/* 798 */       this.stillShowingLeaves = false;
/* 799 */     } else if (event == 17) {
/* 800 */       this.disableRendering = true;
/* 801 */     } else if (event == 16) {
/* 802 */       this.disableRendering = false;
/* 803 */     } else if (event == 15) {
/* 804 */       for (int i = 0; i < 2; i++) {
/* 805 */         this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123755_, m_20208_(1.0D), m_20187_(), m_20262_(1.0D), 0.0D, 0.0D, 0.0D);
/*     */       }
/* 807 */     } else if (event == 13) {
/* 808 */       this.stillShowingLeaves = true;
/* 809 */       this.leafColour = 0;
/* 810 */       cancelAnimations();
/* 811 */     } else if (event == 60) {
/* 812 */       int i; for (i = 0; i < 500; i++) {
/* 813 */         this.f_19853_.m_7107_((ParticleOptions)ParticleTypeInit.WILTED_BREAK.get(), m_20208_(0.75D), m_20187_(), m_20262_(0.75D), m_20185_(), 1.0D, m_20189_());
/*     */       }
/* 815 */       for (i = 0; i < 50; i++) {
/* 816 */         this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123755_, m_20208_(1.5D), m_20187_(), m_20262_(1.5D), 0.0D, 0.0D, 0.0D);
/* 817 */         this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123759_, m_20208_(1.5D), m_20187_(), m_20262_(1.5D), 0.0D, 0.0D, 0.0D);
/*     */       } 
/*     */     } else {
/* 820 */       super.m_7822_(event);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void startAnimation(int animation) {
/* 825 */     if (!this.f_19853_.f_46443_) {
/* 826 */       this.f_19853_.m_7605_((Entity)this, (byte)(4 + animation));
/*     */     } else {
/* 828 */       cancelAnimations();
/* 829 */       switch (animation) {
/*     */         case 0:
/* 831 */           this.attackAnimationState.m_216977_(this.f_19797_);
/*     */           break;
/*     */         case 1:
/* 834 */           this.stillShowingLeaves = true;
/* 835 */           this.revealAnimationState.m_216977_(this.f_19797_);
/*     */           break;
/*     */         case 2:
/* 838 */           this.teleportAnimationState.m_216977_(this.f_19797_);
/*     */           break;
/*     */         case 3:
/* 841 */           this.breakBlocksAnimationState.m_216977_(this.f_19797_);
/*     */           break;
/*     */         case 4:
/* 844 */           this.leapAnimationState.m_216977_(this.f_19797_);
/*     */           break;
/*     */         case 5:
/* 847 */           this.landAnimationState.m_216977_(this.f_19797_);
/*     */           break;
/*     */         case 6:
/* 850 */           this.groundGrabAnimationState.m_216977_(this.f_19797_);
/*     */           break;
/*     */         case 7:
/* 853 */           this.spearAnimationState.m_216977_(this.f_19797_);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void cancelAnimations() {
/* 860 */     this.attackAnimationState.m_216973_();
/* 861 */     this.revealAnimationState.m_216973_();
/* 862 */     this.teleportAnimationState.m_216973_();
/* 863 */     this.breakBlocksAnimationState.m_216973_();
/* 864 */     this.leapAnimationState.m_216973_();
/* 865 */     this.landAnimationState.m_216973_();
/* 866 */     this.groundGrabAnimationState.m_216973_();
/* 867 */     this.spearAnimationState.m_216973_();
/* 868 */     this.deathAnimationState.m_216973_();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(DamageSource source, float amount) {
/* 873 */     boolean flag = super.m_6469_(source, amount);
/* 874 */     if (!this.f_19853_.m_5776_() && source.m_7639_() != null) {
/* 875 */       if (!flag) {
/* 876 */         m_5496_((SoundEvent)SoundEventInit.WILTED_SWAY.get(), m_6121_(), m_6100_());
/* 877 */         this.f_19853_.m_7605_((Entity)this, (byte)19);
/*     */       } 
/* 879 */       Entity entity = source.m_7639_(); if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (MiscUtils.inSurvivalMode(living) && living != m_5448_() && TARGETING.m_26885_((LivingEntity)this, living) && (this.aggroCooldown <= 0 || !MiscUtils.inSurvivalMode(m_5448_()) || (!(m_5448_() instanceof Player) && living instanceof Player))) {
/* 880 */           m_6710_(living);
/* 881 */           if (living instanceof Player) {
/* 882 */             this.aggroCooldown = 200;
/*     */           } else {
/* 884 */             this.aggroCooldown = 80;
/*     */           } 
/*     */         }  }
/*     */     
/* 888 */     }  return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6673_(DamageSource p_20122_) {
/* 893 */     return (super.m_6673_(p_20122_) || (((Boolean)RoFCommonConfig.wilted_immune_to_damage.get()).booleanValue() && !p_20122_.m_19384_() && p_20122_ != DamageSource.f_19317_));
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\entities\Wilted.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */