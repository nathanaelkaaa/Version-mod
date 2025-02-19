/*    */ package com.alexander.rootoffear.config;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraftforge.common.ForgeConfigSpec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RoFClientConfig
/*    */ {
/* 13 */   private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final ForgeConfigSpec SPEC;
/*    */ 
/*    */ 
/*    */   
/* 22 */   public static ForgeConfigSpec.ConfigValue<Boolean> wilted_fog = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Wilted Fog (default: true)"), true);
/*    */   
/* 24 */   public static ForgeConfigSpec.ConfigValue<Boolean> wilted_overrides_music = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Wilted Overrides Music (default: true)"), true);
/*    */   static {
/* 26 */     SPEC = BUILDER.build();
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\config\RoFClientConfig.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */