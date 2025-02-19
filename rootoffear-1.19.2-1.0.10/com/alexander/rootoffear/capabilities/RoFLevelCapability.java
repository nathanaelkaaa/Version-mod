/*    */ package com.alexander.rootoffear.capabilities;
/*    */ 
/*    */ import com.alexander.rootoffear.config.RoFCommonConfig;
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoFLevelCapability
/*    */ {
/*    */   private UUID wiltedID;
/* 16 */   private long nextSpawnDay = ((Integer)RoFCommonConfig.wilted_first_spawn_day.get()).intValue();
/* 17 */   private int oldWiltedSpawnCooldown = -1;
/*    */   private long nextSoundTime;
/*    */   private boolean wasNight;
/*    */   
/*    */   @Nullable
/*    */   public UUID getWiltedID() {
/* 23 */     return this.wiltedID;
/*    */   }
/*    */   
/*    */   public void setWiltedID(UUID wiltedID) {
/* 27 */     this.wiltedID = wiltedID;
/*    */   }
/*    */   
/*    */   public long getNextSpawnDay() {
/* 31 */     return this.nextSpawnDay;
/*    */   }
/*    */   
/*    */   public void setNextSpawnDay(long nextSpawnDay) {
/* 35 */     this.nextSpawnDay = nextSpawnDay;
/*    */   }
/*    */   
/*    */   public int getOldWiltedSpawnCooldown() {
/* 39 */     return this.oldWiltedSpawnCooldown;
/*    */   }
/*    */   
/*    */   public void setOldWiltedSpawnCooldown(int setTo) {
/* 43 */     this.oldWiltedSpawnCooldown = setTo;
/*    */   }
/*    */   
/*    */   public long getNextSoundTime() {
/* 47 */     return this.nextSoundTime;
/*    */   }
/*    */   
/*    */   public void setNextSoundTime(long nextSoundTime) {
/* 51 */     this.nextSoundTime = nextSoundTime;
/*    */   }
/*    */   
/*    */   public boolean wasNight() {
/* 55 */     return this.wasNight;
/*    */   }
/*    */   
/*    */   public void setWasNight(boolean wasNight) {
/* 59 */     this.wasNight = wasNight;
/*    */   }
/*    */   
/*    */   public void saveNBTData(CompoundTag tag) {
/* 63 */     if (this.wiltedID != null) {
/* 64 */       tag.m_128362_("WiltedID", this.wiltedID);
/*    */     }
/* 66 */     tag.m_128356_("NextSpawnDay", this.nextSpawnDay);
/* 67 */     tag.m_128356_("NextSoundTime", this.nextSoundTime);
/* 68 */     tag.m_128379_("WasNight", this.wasNight);
/*    */   }
/*    */   
/*    */   public void loadNBTData(CompoundTag tag) {
/* 72 */     if (tag.m_128441_("WiltedID")) {
/* 73 */       this.wiltedID = tag.m_128342_("WiltedID");
/*    */     }
/* 75 */     if (tag.m_128441_("WiltedSpawnCooldown")) {
/* 76 */       this.oldWiltedSpawnCooldown = tag.m_128451_("WiltedSpawnCooldown");
/*    */     }
/* 78 */     this.nextSpawnDay = tag.m_128454_("NextSpawnDay");
/* 79 */     this.nextSoundTime = tag.m_128454_("NextSoundTime");
/* 80 */     this.wasNight = tag.m_128471_("WasNight");
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\capabilities\RoFLevelCapability.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */