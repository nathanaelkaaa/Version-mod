/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapability;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapabilityProvider;
/*    */ import com.alexander.rootoffear.config.RoFCommonConfig;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.LogicalSide;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear")
/*    */ public class RandomlyPlayWiltedSoundsEvent
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void playSounds(TickEvent.LevelTickEvent event) {
/* 25 */     if (event.side == LogicalSide.SERVER && event.phase == TickEvent.Phase.START) {
/* 26 */       ServerLevel level = (ServerLevel)event.level;
/* 27 */       level.getCapability(RoFLevelCapabilityProvider.CAP).ifPresent(capability -> {
/* 28 */             boolean flag = (capability.getWiltedID() != null && MiscUtils.isEntityValid(level.m_8791_(capability.getWiltedID())));
/*    */             if (!capability.wasNight() && level.m_46462_() && !flag) {
/*    */               setNextUseTime(level, capability);
/*    */             }
/*    */             if (((level.m_46468_() / 24000L >= capability.getNextSpawnDay() - 3L && ((Boolean)RoFCommonConfig.wilted_warning_sounds.get()).booleanValue()) || flag) && level.m_46467_() >= capability.getNextSoundTime() && level.m_46462_()) {
/*    */               ServerPlayer serverPlayer = level.m_8890_();
/*    */               if (MiscUtils.isEntityValid((LivingEntity)serverPlayer) && (MiscUtils.isEntityInValidWiltedSpawnBiome((Entity)serverPlayer) || flag)) {
/*    */                 level.m_6263_(null, serverPlayer.m_20185_() + level.f_46441_.m_188583_() * 20.0D, serverPlayer.m_20186_(), serverPlayer.m_20189_() + level.f_46441_.m_188583_() * 20.0D, (SoundEvent)SoundEventInit.WILTED_IDLE.get(), SoundSource.HOSTILE, 3.0F, ((level.f_46441_.m_188501_() - level.f_46441_.m_188501_()) * 0.2F + 1.0F) / (1.0F + level.f_46441_.m_188501_() / 2.0F));
/*    */                 if (flag) {
/*    */                   capability.setNextSoundTime(level.m_46467_() + MiscUtils.randomIntBetween(100, 300));
/*    */                 } else {
/*    */                   setNextUseTime(level, capability);
/*    */                 } 
/*    */               } 
/*    */             } 
/*    */             capability.setWasNight(level.m_46462_());
/*    */           });
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void setNextUseTime(ServerLevel level, RoFLevelCapability capability) {
/* 49 */     capability.setNextSoundTime(level.m_46467_() + MiscUtils.randomIntBetween(600, (int)Math.max(2400L, (level.m_8044_() / 24000L - capability.getNextSpawnDay()) * 9600L)));
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\RandomlyPlayWiltedSoundsEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */