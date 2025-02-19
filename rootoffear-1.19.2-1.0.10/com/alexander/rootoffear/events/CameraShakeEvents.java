/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.network.ClientboundShakeCameraPacket;
/*    */ import com.alexander.rootoffear.network.Messages;
/*    */ import com.alexander.rootoffear.utils.PositionUtils;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.NonNullList;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.client.event.ViewportEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear", value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.FORGE)
/*    */ public class CameraShakeEvents
/*    */ {
/* 26 */   public Random random = new Random();
/*    */   
/* 28 */   public static NonNullList<CameraShakeHandler> cameraShakes = NonNullList.m_122779_();
/*    */   
/*    */   public static int cameraEntityLastTickCount;
/*    */   
/*    */   @SubscribeEvent
/*    */   protected static void cameraShake(ViewportEvent.ComputeCameraAngles event) {
/* 34 */     for (int i = 0; i < cameraShakes.size(); i++) {
/* 35 */       CameraShakeHandler handler = (CameraShakeHandler)cameraShakes.get(i);
/*    */       
/* 37 */       Entity cameraEntity = (Minecraft.m_91087_()).f_91075_;
/*    */       
/* 39 */       if (handler != null) {
/* 40 */         if (handler.time <= 0) {
/* 41 */           cameraShakes.remove(handler);
/*    */         }
/*    */         
/* 44 */         if ((event.getCamera().m_90592_()).f_19797_ != cameraEntityLastTickCount && handler.time > 0) {
/* 45 */           handler.time--;
/*    */         }
/*    */         
/* 48 */         if (cameraEntity != null && 
/* 49 */           handler.time > 0 && 
/* 50 */           PositionUtils.distanceTo(cameraEntity, handler.causePosition) <= handler.range) {
/* 51 */           shakeCamera(event, cameraEntity, handler.amount * handler.time / handler.duration);
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 57 */     cameraEntityLastTickCount = (event.getCamera().m_90592_()).f_19797_;
/*    */   }
/*    */   
/*    */   public static void addCameraShake(Level level, int duration, float amount, BlockPos causePosition, int range) {
/* 61 */     if (level == null || level.f_46443_) {
/* 62 */       cameraShakes.add(0, new CameraShakeHandler(amount, duration, duration, causePosition, range));
/*    */     }
/*    */     
/* 65 */     if (level != null && !level.f_46443_) {
/* 66 */       for (Player player : level.m_6907_()) {
/* 67 */         if (player instanceof ServerPlayer) {
/* 68 */           Messages.sendToPlayer(new ClientboundShakeCameraPacket(duration, amount, causePosition, range), (ServerPlayer)player);
/*    */         }
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   private static void shakeCamera(ViewportEvent.ComputeCameraAngles event, Entity cameraEntity, float amount) {
/* 75 */     if (!Minecraft.m_91087_().m_91104_()) {
/* 76 */       float delta = Minecraft.m_91087_().m_91297_();
/* 77 */       float ticksExistedDelta = cameraEntity.f_19797_ + delta;
/* 78 */       float finalAmount = amount * 0.1F;
/* 79 */       event.setPitch((float)Mth.m_14139_(Minecraft.m_91087_().getPartialTick(), event.getPitch(), event.getPitch() + finalAmount * Math.cos((ticksExistedDelta * 3.0F + 2.0F)) * 25.0D));
/* 80 */       event.setYaw((float)Mth.m_14139_(Minecraft.m_91087_().getPartialTick(), event.getYaw(), event.getYaw() + finalAmount * Math.cos((ticksExistedDelta * 5.0F + 9.0F)) * 25.0D));
/* 81 */       event.setRoll((float)Mth.m_14139_(Minecraft.m_91087_().getPartialTick(), event.getRoll(), event.getRoll() + finalAmount * Math.cos((ticksExistedDelta * 4.0F)) * 25.0D));
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class CameraShakeHandler
/*    */   {
/*    */     public float amount;
/*    */     public int duration;
/*    */     public int time;
/*    */     public BlockPos causePosition;
/*    */     public int range;
/*    */     
/*    */     public CameraShakeHandler(float amount, int duration, int time, BlockPos causePosition, int range) {
/* 94 */       this.amount = amount;
/* 95 */       this.duration = duration;
/* 96 */       this.time = duration;
/* 97 */       this.causePosition = causePosition;
/* 98 */       this.range = range;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\CameraShakeEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */