/*     */ package com.alexander.rootoffear.events;
/*     */ 
/*     */ import com.alexander.rootoffear.network.ClientboundStartPlayerMovementPacket;
/*     */ import com.alexander.rootoffear.network.Messages;
/*     */ import com.alexander.rootoffear.utils.MiscUtils;
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Pose;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.event.TickEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.LogicalSide;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber(modid = "rootoffear")
/*     */ public class PlayerMovementEvents
/*     */ {
/*  28 */   public static final List<PlayerMovement> clientPlayerMovements = Lists.newArrayList();
/*  29 */   public static final List<PlayerMovement> serverPlayerMovements = Lists.newArrayList();
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void tickPlayerMovements(TickEvent.PlayerTickEvent event) {
/*  33 */     if (event.phase == TickEvent.Phase.START) {
/*  34 */       List<PlayerMovement> toRemove = Lists.newArrayList();
/*  35 */       for (PlayerMovement movement : (event.side == LogicalSide.CLIENT) ? clientPlayerMovements : serverPlayerMovements) {
/*  36 */         movement.tick();
/*  37 */         if (movement.done) {
/*  38 */           toRemove.add(movement);
/*     */         }
/*     */       } 
/*  41 */       for (PlayerMovement movement : toRemove) {
/*  42 */         if (event.side == LogicalSide.CLIENT) {
/*  43 */           clientPlayerMovements.remove(movement); continue;
/*     */         } 
/*  45 */         serverPlayerMovements.remove(movement);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean alreadyHasMovement(Entity player, Entity cause, int type) {
/*  52 */     for (PlayerMovement movement : serverPlayerMovements) {
/*  53 */       if (movement.player == player && movement.cause == cause && movement.type == type) {
/*  54 */         return true;
/*     */       }
/*     */     } 
/*  57 */     return false;
/*     */   }
/*     */   
/*     */   public static void addPlayerMovement(Entity player, Entity cause, int type) {
/*  61 */     if (!alreadyHasMovement(player, cause, type)) {
/*  62 */       serverPlayerMovements.add(new PlayerMovement(player, cause, type));
/*  63 */       Messages.sendToAllPlayers(new ClientboundStartPlayerMovementPacket(player, cause, type));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void addClientPlayerMovement(int playerID, int causeID, int type) {
/*  68 */     clientPlayerMovements.add(new PlayerMovement((Minecraft.m_91087_()).f_91073_.m_6815_(playerID), (Minecraft.m_91087_()).f_91073_.m_6815_(causeID), type));
/*     */   }
/*     */   
/*     */   public static class PlayerMovement {
/*     */     public final Player player;
/*     */     public final Entity cause;
/*     */     public final int type;
/*     */     public int tickCount;
/*     */     public boolean done = false;
/*     */     public Pose oldPose;
/*     */     
/*     */     public PlayerMovement(Entity player, Entity cause, int type) {
/*  80 */       if (player instanceof Player) { Player realPlayer = (Player)player;
/*  81 */         this.player = realPlayer; }
/*     */       else
/*  83 */       { this.player = null;
/*  84 */         this.done = true; }
/*     */       
/*  86 */       if (type == 0 && cause instanceof LivingEntity) { LivingEntity livingCause = (LivingEntity)cause;
/*  87 */         this.player.m_20219_(PositionUtils.getOffsetPos(cause, 0.0D, 3.0D, 4.0D, 0.0F, livingCause.f_20883_)); }
/*     */       
/*  89 */       this.oldPose = cause.m_20089_();
/*  90 */       this.cause = cause;
/*  91 */       this.type = type;
/*     */     }
/*     */     
/*     */     public void tick() {
/*  95 */       if (!this.done)
/*  96 */         if (MiscUtils.inSurvivalMode((LivingEntity)this.player) && MiscUtils.isEntityValid(this.cause)) {
/*  97 */           if (this.type == 0) {
/*  98 */             if (this.cause.m_20191_().m_82377_(5.0D, 10.0D, 5.0D).m_82381_(this.player.m_20191_())) { Entity entity = this.cause; if (entity instanceof LivingEntity) { LivingEntity livingCause = (LivingEntity)entity;
/*  99 */                 Vec3 finalVec = Vec3.f_82478_;
/* 100 */                 Vec3 targetVec1 = new Vec3(0.0D, 3.0D, 4.0D);
/* 101 */                 Vec3 targetVec2 = new Vec3(0.0D, 4.5D, 3.0D);
/* 102 */                 Vec3 targetVec3 = new Vec3(0.0D, -0.5D, 4.5D);
/* 103 */                 int ticks = this.tickCount % 40;
/* 104 */                 if (ticks <= 10) {
/* 105 */                   finalVec = targetVec1.m_165921_(targetVec2, (ticks / 10.0F));
/* 106 */                 } else if (ticks < 14) {
/* 107 */                   finalVec = targetVec2;
/* 108 */                 } else if (ticks <= 17) {
/* 109 */                   finalVec = targetVec2.m_165921_(targetVec3, ((ticks - 14) / 3.0F));
/* 110 */                 } else if (ticks < 28) {
/* 111 */                   finalVec = targetVec3;
/* 112 */                 } else if (ticks <= 40) {
/* 113 */                   finalVec = targetVec3.m_165921_(targetVec1, ((ticks - 27) / 13.0F));
/*     */                 } 
/* 115 */                 Vec3 pos = PositionUtils.getOffsetPos(this.cause, finalVec.f_82479_, finalVec.f_82480_, finalVec.f_82481_, 0.0F, livingCause.f_20883_);
/* 116 */                 double distance = Math.max(PositionUtils.distanceTo((Entity)this.player, pos), 1.0F);
/* 117 */                 this.player.m_20256_(new Vec3((pos.f_82479_ - this.player.m_20185_()) / distance, (pos.f_82480_ - this.player.m_20186_()) / distance, (pos.f_82481_ - this.player.m_20189_()) / distance)); }
/*     */                }
/* 119 */              if (this.oldPose != this.cause.m_20089_() && this.cause.m_20089_() == Pose.STANDING) {
/* 120 */               this.done = true;
/*     */             }
/* 122 */             this.oldPose = this.cause.m_20089_();
/* 123 */           } else if (this.type == 1 && this.cause.m_20191_().m_165887_(this.cause.m_20186_() - 2.0D).m_82381_(this.player.m_20191_())) {
/* 124 */             Vec3 targetVec1 = this.cause.m_20182_().m_82492_(0.0D, 0.0D, 0.0D);
/* 125 */             Vec3 targetVec2 = this.cause.m_20182_().m_82492_(0.0D, this.player.m_20206_(), 0.0D);
/* 126 */             Vec3 target = (this.tickCount <= 10) ? targetVec1 : targetVec1.m_165921_(targetVec2, ((this.tickCount - 10) / 140.0F));
/*     */             
/* 128 */             this.player.m_20334_(0.0D, 0.0D, 0.0D);
/* 129 */             double xo = this.player.f_19854_;
/* 130 */             double xOld = this.player.f_19790_;
/* 131 */             double yo = this.player.f_19855_;
/* 132 */             double yOld = this.player.f_19791_;
/* 133 */             double zo = this.player.f_19856_;
/* 134 */             double zOld = this.player.f_19792_;
/* 135 */             this.player.m_20219_(target);
/* 136 */             this.player.f_19854_ = xo;
/* 137 */             this.player.f_19790_ = xOld;
/* 138 */             this.player.f_19855_ = yo;
/* 139 */             this.player.f_19791_ = yOld;
/* 140 */             this.player.f_19856_ = zo;
/* 141 */             this.player.f_19792_ = zOld;
/* 142 */             if (this.tickCount >= 150) {
/* 143 */               this.done = true;
/*     */             }
/*     */           } 
/* 146 */           this.tickCount++;
/*     */         } else {
/* 148 */           this.done = true;
/*     */         }  
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\PlayerMovementEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */