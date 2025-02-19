/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.TheRootOfFear;
/*    */ import com.alexander.rootoffear.customspawners.WiltedSpawner;
/*    */ import com.alexander.rootoffear.mixin.ServerLevelAccessor;
/*    */ import java.util.List;
/*    */ import java.util.stream.Collectors;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.level.CustomSpawner;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraftforge.event.level.LevelEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear")
/*    */ public class AddCustomSpawnersEvent
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onWorldLoaded(LevelEvent.Load event) {
/* 22 */     LevelAccessor levelAccessor = event.getLevel(); if (levelAccessor instanceof ServerLevel) { ServerLevel level = (ServerLevel)levelAccessor; if (TheRootOfFear.WILTED_SPAWNABLE_DIMENSIONS.contains(level.m_46472_())) {
/* 23 */         ServerLevelAccessor accessor = castToAccessor(level);
/* 24 */         List<CustomSpawner> customSpawners = accessor.getCustomSpawners();
/* 25 */         List<CustomSpawner> newCustomSpawners = (List<CustomSpawner>)customSpawners.stream().collect(Collectors.toList());
/* 26 */         newCustomSpawners.add(new WiltedSpawner());
/* 27 */         accessor.setCustomSpawners(newCustomSpawners);
/*    */       }  }
/*    */   
/*    */   }
/*    */   public static ServerLevelAccessor castToAccessor(ServerLevel serverWorld) {
/* 32 */     return (ServerLevelAccessor)serverWorld;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\AddCustomSpawnersEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */