/*    */ package com.alexander.rootoffear.enums;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Map;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum RoFBedSleepingProblems
/*    */ {
/* 11 */   WILTED("WILTED");
/*    */ 
/*    */   
/* 14 */   private final Map<String, Player.BedSleepingProblem> MAPPED_TYPES = Maps.newHashMap();
/*    */   
/*    */   RoFBedSleepingProblems(String key) {
/* 17 */     this.K = key;
/*    */   }
/*    */   public final String K;
/*    */   public Player.BedSleepingProblem T() {
/* 21 */     return this.MAPPED_TYPES.put(this.K, Player.BedSleepingProblem.valueOf(this.K));
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\enums\RoFBedSleepingProblems.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */