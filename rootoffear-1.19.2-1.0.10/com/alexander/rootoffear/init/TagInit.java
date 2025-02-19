/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.level.biome.Biome;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ 
/*    */ 
/*    */ public class TagInit
/*    */ {
/*    */   public static class EntityTypes
/*    */   {
/* 16 */     public static final TagKey<EntityType<?>> NOT_SCARED_BY_WILTED = create("not_scared_by_wilted");
/*    */     
/*    */     private static TagKey<EntityType<?>> create(String p_203849_) {
/* 19 */       return TagKey.m_203882_(Registry.f_122903_, new ResourceLocation("rootoffear", p_203849_));
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Items {
/* 24 */     public static final TagKey<Item> WILTED_ADDS_COOLDOWN_TO = create("wilted_adds_cooldown_to");
/*    */     
/*    */     private static TagKey<Item> create(String p_203849_) {
/* 27 */       return TagKey.m_203882_(Registry.f_122904_, new ResourceLocation("rootoffear", p_203849_));
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Blocks {
/* 32 */     public static final TagKey<Block> DESTROYED_NOT_EXTINGUISHED = create("destroyed_not_extinguished");
/*    */     
/*    */     private static TagKey<Block> create(String p_203849_) {
/* 35 */       return TagKey.m_203882_(Registry.f_122901_, new ResourceLocation("rootoffear", p_203849_));
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Biomes {
/* 40 */     public static final TagKey<Biome> WILTED_SPAWNS_IN = tag("wilted_spawns_in");
/*    */     
/*    */     private static TagKey<Biome> tag(String name) {
/* 43 */       return TagKey.m_203882_(Registry.f_122885_, new ResourceLocation("rootoffear", name));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\TagInit.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */