/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityTypes
/*    */ {
/* 16 */   public static final TagKey<EntityType<?>> NOT_SCARED_BY_WILTED = create("not_scared_by_wilted");
/*    */   
/*    */   private static TagKey<EntityType<?>> create(String p_203849_) {
/* 19 */     return TagKey.m_203882_(Registry.f_122903_, new ResourceLocation("rootoffear", p_203849_));
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\TagInit$EntityTypes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */