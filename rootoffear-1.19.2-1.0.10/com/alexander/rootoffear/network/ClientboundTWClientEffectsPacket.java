/*    */ package com.alexander.rootoffear.network;
/*    */ 
/*    */ import com.alexander.rootoffear.config.RoFClientConfig;
/*    */ import com.alexander.rootoffear.events.HandleClientEffectsEvent;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClientboundTWClientEffectsPacket
/*    */ {
/*    */   private final boolean addExtraFog;
/*    */   private final boolean changeMusic;
/*    */   
/*    */   public ClientboundTWClientEffectsPacket(boolean addExtraFog, boolean changeMusic) {
/* 17 */     this.addExtraFog = addExtraFog;
/* 18 */     this.changeMusic = changeMusic;
/*    */   }
/*    */   
/*    */   public ClientboundTWClientEffectsPacket(FriendlyByteBuf buf) {
/* 22 */     this.addExtraFog = buf.readBoolean();
/* 23 */     this.changeMusic = buf.readBoolean();
/*    */   }
/*    */   
/*    */   public void toBytes(FriendlyByteBuf buf) {
/* 27 */     buf.writeBoolean(this.addExtraFog);
/* 28 */     buf.writeBoolean(this.changeMusic);
/*    */   }
/*    */   
/*    */   public boolean handle(Supplier<NetworkEvent.Context> supplier) {
/* 32 */     NetworkEvent.Context ctx = supplier.get();
/* 33 */     ctx.enqueueWork(() -> {
/* 34 */           HandleClientEffectsEvent.addExtraFog = (this.addExtraFog && ((Boolean)RoFClientConfig.wilted_fog.get()).booleanValue());
/* 35 */           HandleClientEffectsEvent.changeMusic = (this.changeMusic && ((Boolean)RoFClientConfig.wilted_overrides_music.get()).booleanValue());
/*    */         });
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\network\ClientboundTWClientEffectsPacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */