/*    */ package com.alexander.rootoffear.network;
/*    */ 
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraftforge.network.NetworkDirection;
/*    */ import net.minecraftforge.network.NetworkRegistry;
/*    */ import net.minecraftforge.network.PacketDistributor;
/*    */ import net.minecraftforge.network.simple.SimpleChannel;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Messages
/*    */ {
/* 15 */   public static SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation("rootoffear", "messages")).clientAcceptedVersions("1"::equals)
/* 16 */     .serverAcceptedVersions("1"::equals).networkProtocolVersion(() -> "1").simpleChannel();
/*    */   
/* 18 */   private static int packetId = 0;
/*    */   
/*    */   private static int id() {
/* 21 */     return packetId++;
/*    */   }
/*    */   
/*    */   public static void register() {
/* 25 */     INSTANCE.messageBuilder(ClientboundShakeCameraPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
/* 26 */       .decoder(ClientboundShakeCameraPacket::new)
/* 27 */       .encoder(ClientboundShakeCameraPacket::toBytes)
/* 28 */       .consumerNetworkThread(ClientboundShakeCameraPacket::handle)
/* 29 */       .add();
/*    */     
/* 31 */     INSTANCE.messageBuilder(ClientboundTWClientEffectsPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
/* 32 */       .decoder(ClientboundTWClientEffectsPacket::new)
/* 33 */       .encoder(ClientboundTWClientEffectsPacket::toBytes)
/* 34 */       .consumerNetworkThread(ClientboundTWClientEffectsPacket::handle)
/* 35 */       .add();
/*    */     
/* 37 */     INSTANCE.messageBuilder(ClientboundStartPlayerMovementPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
/* 38 */       .decoder(ClientboundStartPlayerMovementPacket::new)
/* 39 */       .encoder(ClientboundStartPlayerMovementPacket::toBytes)
/* 40 */       .consumerNetworkThread(ClientboundStartPlayerMovementPacket::handle)
/* 41 */       .add();
/*    */   }
/*    */   
/*    */   public static <MSG> void sendToServer(MSG message) {
/* 45 */     INSTANCE.sendToServer(message);
/*    */   }
/*    */   
/*    */   public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
/* 49 */     INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
/*    */   }
/*    */   
/*    */   public static <MSG> void sendToAllPlayers(MSG message) {
/* 53 */     INSTANCE.send(PacketDistributor.ALL.noArg(), message);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\network\Messages.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */