/*    */ package com.alexander.rootoffear.network;
/*    */ 
/*    */ import com.alexander.rootoffear.events.PlayerMovementEvents;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClientboundStartPlayerMovementPacket
/*    */ {
/*    */   private final int playerID;
/*    */   private final int causeID;
/*    */   private final int movementType;
/*    */   
/*    */   public ClientboundStartPlayerMovementPacket(Entity player, Entity cause, int movementType) {
/* 18 */     this.playerID = player.m_19879_();
/* 19 */     this.causeID = cause.m_19879_();
/* 20 */     this.movementType = movementType;
/*    */   }
/*    */   
/*    */   public ClientboundStartPlayerMovementPacket(FriendlyByteBuf buf) {
/* 24 */     this.playerID = buf.readInt();
/* 25 */     this.causeID = buf.readInt();
/* 26 */     this.movementType = buf.readInt();
/*    */   }
/*    */   
/*    */   public void toBytes(FriendlyByteBuf buf) {
/* 30 */     buf.writeInt(this.playerID);
/* 31 */     buf.writeInt(this.causeID);
/* 32 */     buf.writeInt(this.movementType);
/*    */   }
/*    */   
/*    */   public boolean handle(Supplier<NetworkEvent.Context> supplier) {
/* 36 */     NetworkEvent.Context ctx = supplier.get();
/* 37 */     ctx.enqueueWork(() -> PlayerMovementEvents.addClientPlayerMovement(this.playerID, this.causeID, this.movementType));
/*    */ 
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\network\ClientboundStartPlayerMovementPacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */