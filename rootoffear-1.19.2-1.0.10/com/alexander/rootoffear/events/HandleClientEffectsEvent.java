/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.sounds.Musics;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear", value = {Dist.CLIENT})
/*    */ public class HandleClientEffectsEvent
/*    */ {
/*    */   public static boolean addExtraFog = false;
/*    */   public static boolean changeMusic = false;
/*    */   public static boolean changeMusicO = false;
/* 21 */   public static float extraFogAmount = 0.0F;
/* 22 */   public static float extraFogAmountO = 0.0F;
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void tickClientEffects(TickEvent.ClientTickEvent event) {
/* 26 */     if (event.phase == TickEvent.Phase.START) {
/* 27 */       extraFogAmountO = extraFogAmount;
/* 28 */       extraFogAmount = Mth.m_14179_(0.025F, extraFogAmount, addExtraFog ? 1.0F : 0.0F);
/* 29 */       if (changeMusicO == true && !changeMusic && Minecraft.m_91087_().m_91397_().m_120187_(Musics.f_11648_)) {
/* 30 */         Minecraft.m_91087_().m_91397_().m_120186_();
/*    */       }
/* 32 */       changeMusicO = changeMusic;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\HandleClientEffectsEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */