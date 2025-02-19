/*    */ package com.alexander.rootoffear.network;
/*    */ 
/*    */ import com.alexander.rootoffear.events.CameraShakeEvents;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClientboundShakeCameraPacket
/*    */ {
/*    */   private final int duration;
/*    */   private final float amount;
/*    */   private final BlockPos causePos;
/*    */   private final int range;
/*    */   
/*    */   public ClientboundShakeCameraPacket(int duration, float amount, BlockPos causePos, int range) {
/* 19 */     this.duration = duration;
/* 20 */     this.amount = amount;
/* 21 */     this.causePos = causePos;
/* 22 */     this.range = range;
/*    */   }
/*    */   
/*    */   public ClientboundShakeCameraPacket(FriendlyByteBuf buf) {
/* 26 */     this.duration = buf.readInt();
/* 27 */     this.amount = buf.readFloat();
/* 28 */     this.causePos = buf.m_130135_();
/* 29 */     this.range = buf.readInt();
/*    */   }
/*    */   
/*    */   public void toBytes(FriendlyByteBuf buf) {
/* 33 */     buf.writeInt(this.duration);
/* 34 */     buf.writeFloat(this.amount);
/* 35 */     buf.m_130064_(this.causePos);
/* 36 */     buf.writeInt(this.range);
/*    */   }
/*    */   
/*    */   public boolean handle(Supplier<NetworkEvent.Context> supplier) {
/* 40 */     NetworkEvent.Context ctx = supplier.get();
/* 41 */     ctx.enqueueWork(() -> CameraShakeEvents.addCameraShake(null, this.duration, this.amount, this.causePos, this.range));
/*    */ 
/*    */     
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\network\ClientboundShakeCameraPacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */