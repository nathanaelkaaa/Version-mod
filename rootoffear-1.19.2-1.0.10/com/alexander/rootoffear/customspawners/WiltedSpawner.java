/*    */ package com.alexander.rootoffear.customspawners;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapability;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapabilityProvider;
/*    */ import com.alexander.rootoffear.config.RoFCommonConfig;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.init.EntityTypeInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.MobSpawnType;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.CustomSpawner;
/*    */ 
/*    */ public class WiltedSpawner implements CustomSpawner {
/*    */   private static final int FIND_SPAWN_LOCATION_ATTEMPTS = 20;
/*    */   
/*    */   public int m_7995_(ServerLevel level, boolean p_35923_, boolean p_35924_) {
/* 26 */     level.getCapability(RoFLevelCapabilityProvider.CAP).ifPresent(capability -> {
/*    */           if (capability.getOldWiltedSpawnCooldown() != -1) {
/*    */             capability.setNextSpawnDay((level.m_46468_() + capability.getOldWiltedSpawnCooldown()) / 24000L);
/*    */             
/*    */             capability.setOldWiltedSpawnCooldown(-1);
/*    */           } 
/*    */           
/*    */           this.nextSpawnDay = capability.getNextSpawnDay();
/*    */         });
/* 35 */     if (spawn(level)) {
/* 36 */       return 1;
/*    */     }
/* 38 */     return 0;
/*    */   }
/*    */   public long nextSpawnDay;
/*    */   
/*    */   private boolean spawn(ServerLevel level) {
/* 43 */     ServerPlayer serverPlayer = level.m_8890_();
/* 44 */     if (serverPlayer == null || !MiscUtils.isEntityInValidWiltedSpawnBiome((Entity)serverPlayer) || level.m_46468_() / 24000L < this.nextSpawnDay || (!level.m_6042_().m_63967_() && level.m_7445_() < 10)) {
/* 45 */       return false;
/*    */     }
/* 47 */     BlockPos blockpos2 = findSpawnPositionNear(level, (Player)serverPlayer);
/* 48 */     if (blockpos2 != null && hasEnoughSpace((BlockGetter)level, blockpos2)) {
/* 49 */       Wilted wilted = (Wilted)((EntityType)EntityTypeInit.WILTED.get()).m_20600_(level, (CompoundTag)null, (Component)null, null, blockpos2, MobSpawnType.EVENT, false, false);
/* 50 */       if (wilted != null) {
/* 51 */         level.getCapability(RoFLevelCapabilityProvider.CAP).ifPresent(capability -> {
/*    */               capability.setWiltedID(wilted.m_20148_());
/*    */               capability.setNextSpawnDay(level.m_46468_() / 24000L + Mth.m_216287_(level.m_213780_(), ((Integer)RoFCommonConfig.min_wilted_spawn_cooldown.get()).intValue(), ((Integer)RoFCommonConfig.max_wilted_spawn_cooldown.get()).intValue()));
/*    */               capability.setNextSoundTime(0L);
/*    */             });
/* 56 */         wilted.setDisguised(true);
/* 57 */         wilted.setNaturallySpawned(true);
/* 58 */         wilted.ultimateTargetID = serverPlayer.m_20148_();
/* 59 */         return true;
/*    */       } 
/*    */     } 
/*    */     
/* 63 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   private BlockPos findSpawnPositionNear(ServerLevel level, Player player) {
/* 69 */     return Wilted.findSpawnablePosition(player.m_20183_(), level, 96, 112, 0, 20, true);
/*    */   }
/*    */   
/*    */   private boolean hasEnoughSpace(BlockGetter p_35926_, BlockPos p_35927_) {
/* 73 */     for (BlockPos blockpos : BlockPos.m_121940_(p_35927_, p_35927_.m_7918_(1, 2, 1))) {
/* 74 */       if (!p_35926_.m_8055_(blockpos).m_60812_(p_35926_, blockpos).m_83281_()) {
/* 75 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\customspawners\WiltedSpawner.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */