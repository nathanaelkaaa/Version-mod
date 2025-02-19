/*     */ package com.alexander.rootoffear.entities;
/*     */ 
/*     */ import com.alexander.rootoffear.events.PlayerMovementEvents;
/*     */ import com.alexander.rootoffear.init.EntityTypeInit;
/*     */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
/*     */ import com.alexander.rootoffear.utils.MiscUtils;
/*     */ import net.minecraft.core.particles.BlockParticleOption;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.entity.AnimationState;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ 
/*     */ public class WiltedHands
/*     */   extends AbstractHurtableEntity
/*     */ {
/*  25 */   public AnimationState grabAnimationState = new AnimationState();
/*     */   public LivingEntity target;
/*     */   
/*     */   public WiltedHands(EntityType<? extends WiltedHands> type, Level level) {
/*  29 */     super(type, level);
/*     */   }
/*     */   
/*     */   public WiltedHands(Level level, Vec3 pos, float yRot, LivingEntity target) {
/*  33 */     this((EntityType<? extends WiltedHands>)EntityTypeInit.WILTED_HANDS.get(), level);
/*  34 */     m_146884_(pos);
/*  35 */     m_146922_(yRot);
/*  36 */     this.target = target;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7822_(byte event) {
/*  41 */     if (event == 5) {
/*  42 */       for (int i = 0; i < 100; i++) {
/*  43 */         this.f_19853_.m_7107_((ParticleOptions)ParticleTypeInit.WILTED_BREAK.get(), m_20208_(0.85D), m_20187_(), m_20262_(0.85D), 0.0D, 0.0D, 0.0D);
/*     */       }
/*  45 */     } else if (event == 7) {
/*  46 */       this.grabAnimationState.m_216977_(this.f_19797_);
/*     */     } else {
/*  48 */       super.m_7822_(event);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundEvent hurtSound() {
/*  54 */     return (SoundEvent)SoundEventInit.WILTED_SWAY.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  59 */     super.m_8119_();
/*  60 */     updateHurtable();
/*  61 */     if (!this.f_19853_.m_5776_() && MiscUtils.inSurvivalMode(this.target) && m_20191_().m_165887_(m_20186_() - 2.0D).m_82381_(this.target.m_20191_())) {
/*  62 */       this.target.m_6853_(false);
/*  63 */       this.target.m_183634_();
/*  64 */       LivingEntity livingEntity = this.target; if (livingEntity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingEntity;
/*  65 */         PlayerMovementEvents.addPlayerMovement((Entity)serverPlayer, this, 1); }
/*     */       else
/*  67 */       { Vec3 targetVec1 = m_20182_().m_82492_(0.0D, 0.0D, 0.0D);
/*  68 */         Vec3 targetVec2 = m_20182_().m_82492_(0.0D, this.target.m_20206_(), 0.0D);
/*  69 */         Vec3 targetPos = (this.f_19797_ <= 10) ? targetVec1 : targetVec1.m_165921_(targetVec2, ((this.f_19797_ - 10) / 140.0F));
/*     */         
/*  71 */         this.target.m_146884_(targetPos);
/*  72 */         this.target.m_20334_(0.0D, 0.0D, 0.0D); }
/*     */     
/*     */     } 
/*  75 */     this.f_19853_.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, m_20075_()), m_20208_(0.8D), m_20186_(), m_20262_(0.8D), 0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onKilled() {
/*  80 */     if (MiscUtils.inSurvivalMode(this.target) && m_20191_().m_165887_(m_20186_() - 2.0D).m_82381_(this.target.m_20191_())) {
/*  81 */       LivingEntity livingEntity = this.target; if (livingEntity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingEntity;
/*  82 */         serverPlayer.m_6021_(m_20185_(), m_20186_(), m_20189_()); }
/*     */       else
/*  84 */       { this.target.m_20219_(m_20182_()); }
/*     */     
/*     */     } 
/*  87 */     m_5496_((SoundEvent)SoundEventInit.WILTED_STEP.get(), getSoundVolume(), getVoicePitch() * 2.0F);
/*  88 */     super.onKilled();
/*     */   }
/*     */ 
/*     */   
/*     */   public Packet<?> m_5654_() {
/*  93 */     return NetworkHooks.getEntitySpawningPacket(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxHits() {
/*  98 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hurtCooldown() {
/* 103 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxLifeTime() {
/* 108 */     return 155;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean discardAfterLifeTimeReached() {
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnimationState hurtAnimationState() {
/* 118 */     return null;
/*     */   }
/*     */   
/*     */   protected void m_8097_() {}
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\entities\WiltedHands.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */