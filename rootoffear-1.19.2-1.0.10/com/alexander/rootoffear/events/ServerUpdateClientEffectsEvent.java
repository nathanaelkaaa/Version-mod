/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapability;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapabilityProvider;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.network.ClientboundTWClientEffectsPacket;
/*    */ import com.alexander.rootoffear.network.Messages;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear")
/*    */ public class ServerUpdateClientEffectsEvent {
/*    */   @SubscribeEvent
/*    */   public static void update(TickEvent.PlayerTickEvent event) {
/* 23 */     if (event.phase == TickEvent.Phase.START) { Player player = event.player; if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player; Level level = serverPlayer.f_19853_; if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 24 */           boolean fog = false;
/* 25 */           boolean music = false;
/* 26 */           if (serverLevel.getCapability(RoFLevelCapabilityProvider.CAP).isPresent() && serverLevel.getCapability(RoFLevelCapabilityProvider.CAP).resolve().get() != null) {
/* 27 */             RoFLevelCapability capability = serverLevel.getCapability(RoFLevelCapabilityProvider.CAP).resolve().get();
/* 28 */             if (serverLevel.m_46468_() / 24000L == capability.getNextSpawnDay() && MiscUtils.isEntityInValidWiltedSpawnBiome((Entity)serverPlayer)) {
/* 29 */               fog = true;
/*    */             }
/*    */             
/* 32 */             Entity entity = serverLevel.m_8791_(capability.getWiltedID()); if (entity instanceof Wilted) { Wilted foundWilted = (Wilted)entity; if (MiscUtils.isEntityValid((LivingEntity)foundWilted)) {
/* 33 */                 fog = true;
/* 34 */                 music = true;
/*    */               }  }
/*    */           
/* 37 */           }  Messages.sendToPlayer(new ClientboundTWClientEffectsPacket(fog, music), serverPlayer); }
/*    */          }
/*    */        }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\ServerUpdateClientEffectsEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */