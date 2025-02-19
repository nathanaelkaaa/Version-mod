/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapability;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapabilityProvider;
/*    */ import com.alexander.rootoffear.config.RoFCommonConfig;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.network.protocol.Packet;
/*    */ import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear")
/*    */ public class StopPortalTravelEvent {
/*    */   @SubscribeEvent
/*    */   public static void stopPortalTravel(TickEvent.PlayerTickEvent event) {
/* 32 */     Player player = event.player; if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player; if (MiscUtils.inSurvivalMode((LivingEntity)serverPlayer) && ((Boolean)RoFCommonConfig.wilted_prevents_portal_travel.get()).booleanValue()) {
/* 33 */         ServerLevel level = (ServerLevel)serverPlayer.f_19853_;
/* 34 */         level.getCapability(RoFLevelCapabilityProvider.CAP).ifPresent(capability -> {
/*    */               if (capability.getWiltedID() != null) {
/*    */                 Entity patt1673$temp = level.m_8791_(capability.getWiltedID());
/*    */                 if (patt1673$temp instanceof Wilted) {
/*    */                   Wilted wilted = (Wilted)patt1673$temp;
/*    */                   if (MiscUtils.isEntityValid((LivingEntity)wilted)) {
/*    */                     AABB aabb = player.m_20191_().m_82400_(1.0D);
/*    */                     for (BlockPos blockpos : BlockPos.m_121976_(Mth.m_14107_(aabb.f_82288_), Mth.m_14107_(aabb.f_82289_), Mth.m_14107_(aabb.f_82290_), Mth.m_14107_(aabb.f_82291_), Mth.m_14107_(aabb.f_82292_), Mth.m_14107_(aabb.f_82293_))) {
/*    */                       BlockState blockstate = player.f_19853_.m_8055_(blockpos);
/*    */                       Block block = blockstate.m_60734_();
/*    */                       if (block instanceof net.minecraft.world.level.block.NetherPortalBlock || block instanceof net.minecraft.world.level.block.EndPortalBlock) {
/*    */                         level.m_6263_(null, blockpos.m_123341_(), blockpos.m_123342_(), blockpos.m_123343_(), (SoundEvent)SoundEventInit.WILTED_CURSE_ITEM.get(), SoundSource.HOSTILE, 1.0F, (level.f_46441_.m_188501_() - level.f_46441_.m_188501_()) * 0.2F + 1.0F);
/*    */                         double x = player.m_20185_() - blockpos.m_123341_();
/*    */                         double y = player.m_20186_() - blockpos.m_123342_();
/*    */                         double z = player.m_20189_() - blockpos.m_123343_();
/*    */                         double distance = Math.max(x * x + y * y + z * z, 1.0D);
/*    */                         player.m_20256_(player.m_20184_().m_82549_((new Vec3(x / distance, y / distance, z / distance)).m_82490_(2.0D)));
/*    */                         player.f_8906_.m_9829_((Packet)new ClientboundSetEntityMotionPacket((Entity)player));
/*    */                         break;
/*    */                       } 
/*    */                     } 
/*    */                   } 
/*    */                 } 
/*    */               } 
/*    */             });
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\StopPortalTravelEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */