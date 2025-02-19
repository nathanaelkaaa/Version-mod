/*    */ package com.alexander.rootoffear.capabilities;
/*    */ 
/*    */ import javax.annotation.Nonnull;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.core.Direction;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.nbt.Tag;
/*    */ import net.minecraftforge.common.capabilities.Capability;
/*    */ import net.minecraftforge.common.capabilities.CapabilityManager;
/*    */ import net.minecraftforge.common.capabilities.CapabilityToken;
/*    */ import net.minecraftforge.common.capabilities.ICapabilitySerializable;
/*    */ import net.minecraftforge.common.util.LazyOptional;
/*    */ 
/*    */ public class RoFLevelCapabilityProvider
/*    */   implements ICapabilitySerializable<CompoundTag> {
/* 16 */   public static Capability<RoFLevelCapability> CAP = CapabilityManager.get(new CapabilityToken<RoFLevelCapability>() {  }
/*    */     );
/* 18 */   private RoFLevelCapability cap = null;
/* 19 */   private final LazyOptional<RoFLevelCapability> opt = LazyOptional.of(this::createTWLevelCapability);
/*    */   
/*    */   @Nonnull
/*    */   private RoFLevelCapability createTWLevelCapability() {
/* 23 */     if (this.cap == null) {
/* 24 */       this.cap = new RoFLevelCapability();
/*    */     }
/* 26 */     return this.cap;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
/* 32 */     if (cap == CAP) {
/* 33 */       return this.opt.cast();
/*    */     }
/* 35 */     return LazyOptional.empty();
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
/* 41 */     return getCapability(cap);
/*    */   }
/*    */ 
/*    */   
/*    */   public CompoundTag serializeNBT() {
/* 46 */     CompoundTag nbt = new CompoundTag();
/* 47 */     createTWLevelCapability().saveNBTData(nbt);
/* 48 */     return nbt;
/*    */   }
/*    */ 
/*    */   
/*    */   public void deserializeNBT(CompoundTag nbt) {
/* 53 */     createTWLevelCapability().loadNBTData(nbt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\capabilities\RoFLevelCapabilityProvider.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */