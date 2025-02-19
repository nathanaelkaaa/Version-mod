/*    */ package com.alexander.rootoffear.events;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapability;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapabilityProvider;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.enums.RoFBedSleepingProblems;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear")
/*    */ public class PreventSleepingEvent {
/*    */   @SubscribeEvent
/*    */   public static void preventSleeping(PlayerSleepInBedEvent event) {
/* 19 */     Level level = (event.getEntity()).f_19853_; if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (MiscUtils.inSurvivalMode((LivingEntity)event.getEntity()))
/* 20 */         serverLevel.getCapability(RoFLevelCapabilityProvider.CAP).ifPresent(capability -> {
/*    */               if (serverLevel.m_46468_() / 24000L != capability.getNextSpawnDay() || !(event.getEntity()).f_19853_.m_46462_()) {
/*    */                 if (capability.getWiltedID() != null) {
/*    */                   Entity patt1151$temp = serverLevel.m_8791_(capability.getWiltedID());
/*    */                   if (patt1151$temp instanceof Wilted) {
/*    */                     Wilted wilted = (Wilted)patt1151$temp;
/*    */                     if (MiscUtils.isEntityValid((LivingEntity)wilted) && MiscUtils.inSurvivalMode(wilted.getUltimateTarget()) && wilted.getUltimateTarget() == event.getEntity()) {
/*    */                       event.setResult(RoFBedSleepingProblems.WILTED.T());
/*    */                       return;
/*    */                     } 
/*    */                   } 
/*    */                 } 
/*    */                 return;
/*    */               } 
/*    */               event.setResult(RoFBedSleepingProblems.WILTED.T());
/*    */             });  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\PreventSleepingEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */