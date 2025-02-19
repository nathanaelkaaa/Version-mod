/*     */ package com.alexander.rootoffear.entities;
/*     */ 
/*     */ import com.alexander.rootoffear.events.LightExtinguisherTrackingEvent;
/*     */ import com.alexander.rootoffear.init.EntityTypeInit;
/*     */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
/*     */ import com.alexander.rootoffear.utils.MiscUtils;
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import java.util.Optional;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.nbt.NbtUtils;
/*     */ import net.minecraft.nbt.Tag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.syncher.EntityDataAccessor;
/*     */ import net.minecraft.network.syncher.EntityDataSerializers;
/*     */ import net.minecraft.network.syncher.SynchedEntityData;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.players.OldUsersConverter;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.AnimationState;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelReader;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec2;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ 
/*     */ 
/*     */ public class LightExtinguisher
/*     */   extends AbstractHurtableEntity
/*     */ {
/*  43 */   private static final EntityDataAccessor<Optional<BlockPos>> DATA_EXTINGUISHED_POS_ID = SynchedEntityData.m_135353_(Wilted.class, EntityDataSerializers.f_135039_);
/*  44 */   private static final EntityDataAccessor<Optional<BlockState>> DATA_EXTINGUISHED_STATE_ID = SynchedEntityData.m_135353_(Wilted.class, EntityDataSerializers.f_135034_);
/*  45 */   private static final EntityDataAccessor<Integer> PULLED_ENTITY_ID = SynchedEntityData.m_135353_(Wilted.class, EntityDataSerializers.f_135028_);
/*     */   
/*  47 */   public AnimationState extinguishAnimationState = new AnimationState();
/*  48 */   public AnimationState hurtAnimationState = new AnimationState();
/*     */   
/*     */   public boolean foundDirection = false;
/*     */   
/*  52 */   public Direction attachDirection = Direction.UP;
/*  53 */   public CompoundTag extingishedBlockEntityData = null;
/*     */   
/*  55 */   public float darkness = 0.0F;
/*  56 */   public float darknessO = 0.0F;
/*     */   
/*     */   public int deadDespawnTimer;
/*     */   
/*  60 */   public UUID ownerID = null;
/*     */   
/*  62 */   public LivingEntity pulledEntity = null;
/*     */   
/*     */   public int pull;
/*     */   
/*     */   public int pullO;
/*     */   public float pullLengthLerp;
/*     */   public float pullLengthLerpO;
/*  69 */   public Vec2 facingAngle = Vec2.f_82462_;
/*  70 */   public Vec2 facingAngleO = Vec2.f_82462_;
/*     */   
/*     */   public double pullTargetDist;
/*     */   public double pullTargetDistO;
/*     */   
/*     */   public LightExtinguisher(EntityType<? extends LightExtinguisher> type, Level level) {
/*  76 */     super(type, level);
/*     */   }
/*     */   
/*     */   public LightExtinguisher(Level level, BlockPos pos, Entity owner) {
/*  80 */     this((EntityType<? extends LightExtinguisher>)EntityTypeInit.LIGHT_EXTINGUISHER.get(), level);
/*  81 */     m_6027_(Mth.m_14143_(pos.m_123341_()) + 0.5D, Mth.m_14143_(pos.m_123342_()), Mth.m_14143_(pos.m_123343_()) + 0.5D);
/*  82 */     if (owner instanceof LivingEntity) { LivingEntity living = (LivingEntity)owner; if (MiscUtils.isEntityValid(living)) {
/*  83 */         this.ownerID = living.m_20148_();
/*     */       } }
/*     */   
/*     */   }
/*     */   
/*     */   public void m_7822_(byte event) {
/*  89 */     if (event == 5) {
/*  90 */       for (int i = 0; i < 100; i++) {
/*  91 */         this.f_19853_.m_7107_((ParticleOptions)ParticleTypeInit.WILTED_BREAK.get(), m_20208_(0.85D), m_20187_(), m_20262_(0.85D), 0.0D, 0.0D, 0.0D);
/*     */       }
/*  93 */       super.m_7822_(event);
/*  94 */     } else if (event == 7) {
/*  95 */       this.extinguishAnimationState.m_216977_(this.f_19797_);
/*     */     } else {
/*  97 */       super.m_7822_(event);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundEvent hurtSound() {
/* 103 */     return (SoundEvent)SoundEventInit.WILTED_SWAY.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getVoicePitch() {
/* 108 */     return super.getVoicePitch() * 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(DamageSource source, float amount) {
/* 113 */     if (!this.f_19853_.m_5776_() && this.pulledEntity != null) {
/* 114 */       this.pulledEntity = null;
/* 115 */       m_5496_((SoundEvent)SoundEventInit.WILTED_DIG_IN.get(), getSoundVolume(), getVoicePitch());
/*     */     } 
/* 117 */     return super.m_6469_(source, amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 123 */     super.m_8119_();
/*     */     
/* 125 */     if (!this.f_19853_.m_5776_() && this.pull > 200) {
/* 126 */       this.pulledEntity = null;
/* 127 */       m_5496_((SoundEvent)SoundEventInit.WILTED_DIG_IN.get(), getSoundVolume(), getVoicePitch());
/*     */     } 
/*     */     
/* 130 */     if (!this.f_19853_.m_5776_() && this.f_19797_ > 20 && this.ownerID != null && !MiscUtils.isEntityValid(getOwner())) {
/* 131 */       m_6469_(DamageSource.f_19313_, 1.0F);
/*     */     }
/*     */     
/* 134 */     if (this.f_19853_.m_5776_()) {
/* 135 */       LightExtinguisherTrackingEvent.extinguishers.put(this, m_20183_());
/* 136 */       this.darknessO = this.darkness;
/* 137 */       this.darkness = Mth.m_14179_(0.2F, this.darkness, getExtinguishedPos().isPresent() ? 0.85F : 0.0F);
/*     */     }
/* 139 */     else if (MiscUtils.inSurvivalMode(this.pulledEntity)) {
/* 140 */       setPulledEntityID(this.pulledEntity.m_19879_());
/*     */     } else {
/* 142 */       setPulledEntityID(0);
/*     */     } 
/*     */ 
/*     */     
/* 146 */     if (MiscUtils.inSurvivalMode(getPulledEntity()) && !this.killed) {
/* 147 */       this.pullLengthLerpO = this.pullLengthLerp;
/* 148 */       this.pullLengthLerp = Mth.m_14179_(0.3F, this.pullLengthLerp, 1.0F);
/* 149 */       this.pullTargetDistO = this.pullTargetDist;
/* 150 */       this.pullTargetDist = m_20270_((Entity)getPulledEntity());
/* 151 */       this.facingAngleO = this.facingAngle;
/* 152 */       this.facingAngle = PositionUtils.rotationToFace(m_146892_(), getPulledEntity().m_146892_());
/* 153 */       if (this.pull % 100 == 0) {
/* 154 */         m_5496_((SoundEvent)SoundEventInit.WILTED_GROUND_GRAB.get(), getSoundVolume(), 1.4F);
/*     */       }
/* 156 */       this.pullO = this.pull;
/* 157 */       this.pull++;
/* 158 */       double x = m_20185_() - getPulledEntity().m_20185_();
/* 159 */       double y = m_20186_() - getPulledEntity().m_20186_();
/* 160 */       double z = m_20189_() - getPulledEntity().m_20189_();
/* 161 */       double d = Math.max(m_20270_((Entity)getPulledEntity()), 1.0F);
/* 162 */       getPulledEntity().m_20256_(getPulledEntity().m_20184_().m_82549_((new Vec3(x / d, y / d, z / d)).m_82490_(0.05D)));
/*     */     } else {
/* 164 */       this.pullLengthLerp = Mth.m_14179_(0.3F, this.pullLengthLerp, 0.0F);
/* 165 */       this.pull = 0;
/*     */     } 
/*     */     
/* 168 */     m_6027_(Mth.m_14107_(m_20185_()) + 0.5D, Mth.m_14107_(m_20186_()), Mth.m_14107_(m_20189_()) + 0.5D);
/*     */     
/* 170 */     if (!this.f_19853_.m_5776_() && !this.killed && (this.lifeTime > 20 || getExtinguishedPos().isPresent())) {
/* 171 */       if (getExtinguishedPos().isEmpty()) {
/* 172 */         extinguish(m_20183_());
/* 173 */       } else if (getExtinguishedPos().isPresent() && m_20183_() != getExtinguishedPos().get()) {
/* 174 */         replaceExtinguishedBlock();
/* 175 */       } else if (getExtinguishedPos().isPresent() && (!((BlockState)getExtinguishedState().get()).m_60710_((LevelReader)this.f_19853_, getExtinguishedPos().get()) || ((BlockState)getExtinguishedState().get()).m_60795_())) {
/* 176 */         m_216990_(((BlockState)getExtinguishedState().get()).m_60827_().m_56775_());
/* 177 */         this.f_19853_.m_7605_(this, (byte)5);
/* 178 */         m_146870_();
/*     */       } 
/*     */     }
/*     */     
/* 182 */     if (!this.foundDirection) {
/* 183 */       if (PositionUtils.isBlockCollidable(this.f_19853_, m_20183_().m_7495_())) {
/* 184 */         this.attachDirection = Direction.UP;
/* 185 */       } else if (PositionUtils.isBlockCollidable(this.f_19853_, m_20183_().m_7494_())) {
/* 186 */         this.attachDirection = Direction.DOWN;
/* 187 */       } else if (PositionUtils.isBlockCollidable(this.f_19853_, m_20183_().m_122029_())) {
/* 188 */         this.attachDirection = Direction.WEST;
/* 189 */       } else if (PositionUtils.isBlockCollidable(this.f_19853_, m_20183_().m_122024_())) {
/* 190 */         this.attachDirection = Direction.EAST;
/* 191 */       } else if (PositionUtils.isBlockCollidable(this.f_19853_, m_20183_().m_122012_())) {
/* 192 */         this.attachDirection = Direction.SOUTH;
/* 193 */       } else if (PositionUtils.isBlockCollidable(this.f_19853_, m_20183_().m_122019_())) {
/* 194 */         this.attachDirection = Direction.NORTH;
/*     */       } 
/* 196 */       this.foundDirection = true;
/*     */     } 
/*     */     
/* 199 */     if (this.killed) {
/* 200 */       if (this.deadDespawnTimer > 200) {
/* 201 */         m_6074_();
/*     */       }
/* 203 */       this.deadDespawnTimer++;
/*     */     } 
/*     */     
/* 206 */     updateHurtable();
/*     */   }
/*     */   
/*     */   public void setPulledEntityID(int setTo) {
/* 210 */     this.f_19804_.m_135381_(PULLED_ENTITY_ID, Integer.valueOf(setTo));
/*     */   }
/*     */   
/*     */   public boolean hasPulledEntity() {
/* 214 */     return (((Integer)this.f_19804_.m_135370_(PULLED_ENTITY_ID)).intValue() != 0);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public LivingEntity getPulledEntity() {
/* 219 */     if (!hasPulledEntity())
/* 220 */       return null; 
/* 221 */     if (this.f_19853_.m_5776_()) {
/* 222 */       if (this.pulledEntity != null) {
/* 223 */         return this.pulledEntity;
/*     */       }
/* 225 */       Entity entity = this.f_19853_.m_6815_(((Integer)this.f_19804_.m_135370_(PULLED_ENTITY_ID)).intValue());
/* 226 */       if (entity instanceof LivingEntity) {
/* 227 */         this.pulledEntity = (LivingEntity)entity;
/* 228 */         return this.pulledEntity;
/*     */       } 
/* 230 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 234 */     return this.pulledEntity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_6075_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean m_6087_() {
/* 244 */     return (!m_213877_() && (!this.killed || this.deadDespawnTimer < 10));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onKilled() {
/* 249 */     this.f_19853_.m_7605_(this, (byte)5);
/* 250 */     m_5496_((SoundEvent)SoundEventInit.WILTED_STEP.get(), getSoundVolume(), getVoicePitch() * 4.0F);
/* 251 */     if (getExtinguishedPos().isPresent()) {
/* 252 */       replaceExtinguishedBlock();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_5829_() {
/* 258 */     return (!m_213877_() && !this.killed && this.f_19853_.m_6249_(this, m_20191_().m_82400_(1.0E-7D), entity -> (entity instanceof Wilted || entity instanceof ShadowWilted)).size() <= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6074_() {
/* 263 */     if (!this.f_19853_.m_5776_() && getExtinguishedPos().isPresent()) {
/* 264 */       replaceExtinguishedBlock();
/*     */     }
/* 266 */     super.m_6074_();
/*     */   }
/*     */   
/*     */   public void extinguish(BlockPos pos) {
/* 270 */     setExtinguishedPos(pos);
/* 271 */     setExtinguishedState(this.f_19853_.m_8055_(pos));
/* 272 */     if (this.f_19853_.m_7702_(pos) != null) {
/* 273 */       this.extingishedBlockEntityData = this.f_19853_.m_7702_(pos).m_187481_();
/*     */     }
/* 275 */     this.f_19853_.m_46597_(pos, Blocks.f_50016_.m_49966_());
/*     */   }
/*     */   
/*     */   public void replaceExtinguishedBlock() {
/* 279 */     this.f_19853_.m_46597_(getExtinguishedPos().get(), getExtinguishedState().get());
/* 280 */     if (this.f_19853_.m_7702_(getExtinguishedPos().get()) != null) {
/* 281 */       this.f_19853_.m_7702_(getExtinguishedPos().get()).m_142466_(this.extingishedBlockEntityData);
/* 282 */       this.f_19853_.m_151543_(getExtinguishedPos().get());
/*     */     } 
/* 284 */     setExtinguishedPos((BlockPos)null);
/* 285 */     setExtinguishedState((BlockState)null);
/* 286 */     this.extingishedBlockEntityData = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_8097_() {
/* 291 */     this.f_19804_.m_135372_(DATA_EXTINGUISHED_POS_ID, Optional.empty());
/* 292 */     this.f_19804_.m_135372_(DATA_EXTINGUISHED_STATE_ID, Optional.empty());
/* 293 */     this.f_19804_.m_135372_(PULLED_ENTITY_ID, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   public void setExtinguishedPos(BlockPos value) {
/* 297 */     if (value == null) {
/* 298 */       this.f_19804_.m_135381_(DATA_EXTINGUISHED_POS_ID, Optional.empty());
/*     */     } else {
/* 300 */       this.f_19804_.m_135381_(DATA_EXTINGUISHED_POS_ID, Optional.of(value));
/*     */     } 
/*     */   }
/*     */   
/*     */   public Optional<BlockPos> getExtinguishedPos() {
/* 305 */     return (Optional<BlockPos>)this.f_19804_.m_135370_(DATA_EXTINGUISHED_POS_ID);
/*     */   }
/*     */   
/*     */   public void setExtinguishedState(BlockState value) {
/* 309 */     if (value == null) {
/* 310 */       this.f_19804_.m_135381_(DATA_EXTINGUISHED_STATE_ID, Optional.empty());
/*     */     } else {
/* 312 */       this.f_19804_.m_135381_(DATA_EXTINGUISHED_STATE_ID, Optional.of(value));
/*     */     } 
/*     */   }
/*     */   
/*     */   public Optional<BlockState> getExtinguishedState() {
/* 317 */     return (Optional<BlockState>)this.f_19804_.m_135370_(DATA_EXTINGUISHED_STATE_ID);
/*     */   }
/*     */   
/*     */   public LivingEntity getOwner() {
/* 321 */     Entity target = (this.ownerID == null || this.f_19853_.m_5776_()) ? null : ((ServerLevel)this.f_19853_).m_8791_(this.ownerID);
/* 322 */     LivingEntity living = (LivingEntity)target; return (target instanceof LivingEntity) ? living : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7378_(CompoundTag tag) {
/* 327 */     super.m_7378_(tag);
/* 328 */     if (tag.m_128425_("ExtinguishedPos", 10))
/* 329 */       setExtinguishedPos(NbtUtils.m_129239_(tag.m_128469_("ExtinguishedPos"))); 
/* 330 */     if (tag.m_128425_("ExtinguishedState", 10))
/* 331 */       setExtinguishedState(NbtUtils.m_129241_(tag.m_128469_("ExtinguishedState"))); 
/* 332 */     if (tag.m_128425_("ExtinguishedBlockEntityData", 10))
/* 333 */       this.extingishedBlockEntityData = tag.m_128469_("ExtinguishedBlockEntityData"); 
/* 334 */     if (tag.m_128441_("OwnerID")) {
/*     */       UUID uuid;
/* 336 */       if (tag.m_128403_("OwnerID")) {
/* 337 */         uuid = tag.m_128342_("OwnerID");
/*     */       } else {
/* 339 */         String s = tag.m_128461_("OwnerID");
/* 340 */         uuid = OldUsersConverter.m_11083_(m_20194_(), s);
/*     */       } 
/*     */       
/* 343 */       if (uuid != null) {
/*     */         try {
/* 345 */           this.ownerID = uuid;
/* 346 */         } catch (Throwable throwable) {
/* 347 */           this.ownerID = null;
/*     */         } 
/*     */       }
/*     */     } 
/* 351 */     if (tag.m_128441_("DeadDespawnTimer")) {
/* 352 */       this.deadDespawnTimer = tag.m_128451_("DeadDespawnTimer");
/*     */     }
/*     */   }
/*     */   
/*     */   protected void m_7380_(CompoundTag tag) {
/* 357 */     super.m_7380_(tag);
/* 358 */     if (getExtinguishedPos().isPresent())
/* 359 */       tag.m_128365_("ExtinguishedPos", (Tag)NbtUtils.m_129224_(getExtinguishedPos().get())); 
/* 360 */     if (getExtinguishedState().isPresent())
/* 361 */       tag.m_128365_("ExtinguishedState", (Tag)NbtUtils.m_129202_(getExtinguishedState().get())); 
/* 362 */     if (this.extingishedBlockEntityData != null)
/* 363 */       tag.m_128365_("ExtinguishedBlockEntityData", (Tag)this.extingishedBlockEntityData); 
/* 364 */     if (this.ownerID != null)
/* 365 */       tag.m_128362_("OwnerID", this.ownerID); 
/* 366 */     tag.m_128405_("DeadDespawnTimer", this.deadDespawnTimer);
/*     */   }
/*     */ 
/*     */   
/*     */   public float m_6143_() {
/* 371 */     return 0.1F;
/*     */   }
/*     */ 
/*     */   
/*     */   public Packet<?> m_5654_() {
/* 376 */     return NetworkHooks.getEntitySpawningPacket(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxHits() {
/* 381 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hurtCooldown() {
/* 386 */     return 15;
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxLifeTime() {
/* 391 */     return 6000;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnimationState hurtAnimationState() {
/* 396 */     return this.hurtAnimationState;
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\entities\LightExtinguisher.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */