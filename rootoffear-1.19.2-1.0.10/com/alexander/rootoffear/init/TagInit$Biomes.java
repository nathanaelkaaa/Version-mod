/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import net.minecraft.world.level.biome.Biome;
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
/*    */ public class Biomes
/*    */ {
/* 40 */   public static final TagKey<Biome> WILTED_SPAWNS_IN = tag("wilted_spawns_in");
/*    */   
/*    */   private static TagKey<Biome> tag(String name) {
/* 43 */     return TagKey.m_203882_(Registry.f_122885_, new ResourceLocation("rootoffear", name));
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\TagInit$Biomes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */