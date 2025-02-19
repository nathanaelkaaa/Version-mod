/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.LightExtinguisher;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear", value = {Dist.CLIENT})
/*    */ public class LightExtinguisherTrackingEvent
/*    */ {
/* 22 */   public static final Map<LightExtinguisher, BlockPos> extinguishers = Maps.newHashMap();
/* 23 */   public static final List<LightExtinguisher> toRemove = Lists.newArrayList();
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void tickExtinguishers(TickEvent.ClientTickEvent event) {
/* 27 */     if (event.phase == TickEvent.Phase.END) {
/* 28 */       toRemove.clear();
/* 29 */       extinguishers.forEach((extinguisher, pos) -> {
/*    */             if (!MiscUtils.isEntityValid((Entity)extinguisher) || extinguisher.killed) {
/*    */               toRemove.add(extinguisher);
/*    */             }
/*    */           });
/* 34 */       for (LightExtinguisher extinguisher : toRemove)
/* 35 */         extinguishers.remove(extinguisher); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\LightExtinguisherTrackingEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */