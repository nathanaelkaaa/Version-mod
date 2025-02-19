/*    */ package com.alexander.rootoffear.particles;
/*    */ 
/*    */ import com.mojang.brigadier.StringReader;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.ParticleType;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ParticleOptions.Deserializer<AdvancedParticleOption>
/*    */ {
/*    */   public AdvancedParticleOption fromCommand(ParticleType<AdvancedParticleOption> type, StringReader reader) throws CommandSyntaxException {
/* 60 */     reader.expect(' ');
/* 61 */     return new AdvancedParticleOption(reader.readString(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble());
/*    */   }
/*    */   
/*    */   public AdvancedParticleOption fromNetwork(ParticleType<AdvancedParticleOption> type, FriendlyByteBuf buf) {
/* 65 */     return new AdvancedParticleOption(buf.m_130277_(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble());
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\particles\AdvancedParticleOption$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */