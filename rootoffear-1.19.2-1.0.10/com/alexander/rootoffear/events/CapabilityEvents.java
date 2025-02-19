/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.TheRootOfFear;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapability;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapabilityProvider;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.common.capabilities.ICapabilityProvider;
/*    */ import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
/*    */ import net.minecraftforge.event.AttachCapabilitiesEvent;
/*    */ import net.minecraftforge.eventbus.api.IEventBus;
/*    */ 
/*    */ public class CapabilityEvents
/*    */ {
/*    */   public static void onAttachCapabilitiesWorld(AttachCapabilitiesEvent<Level> event) {
/* 18 */     Object object = event.getObject(); if (object instanceof ServerLevel) { ServerLevel level = (ServerLevel)object; if (TheRootOfFear.WILTED_SPAWNABLE_DIMENSIONS.contains(level.m_46472_()) && 
/* 19 */         !((Level)event.getObject()).getCapability(RoFLevelCapabilityProvider.CAP).isPresent()) {
/* 20 */         event.addCapability(new ResourceLocation("rootoffear", "level_capability"), (ICapabilityProvider)new RoFLevelCapabilityProvider());
/*    */       } }
/*    */   
/*    */   }
/*    */   
/*    */   public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
/* 26 */     event.register(RoFLevelCapability.class);
/*    */   }
/*    */   
/*    */   public static void setup() {
/* 30 */     IEventBus bus = MinecraftForge.EVENT_BUS;
/* 31 */     bus.addGenericListener(Level.class, CapabilityEvents::onAttachCapabilitiesWorld);
/* 32 */     bus.addListener(CapabilityEvents::onRegisterCapabilities);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\CapabilityEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */