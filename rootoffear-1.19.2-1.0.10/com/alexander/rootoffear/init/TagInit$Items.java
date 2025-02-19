/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import net.minecraft.world.item.Item;
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
/*    */ public class Items
/*    */ {
/* 24 */   public static final TagKey<Item> WILTED_ADDS_COOLDOWN_TO = create("wilted_adds_cooldown_to");
/*    */   
/*    */   private static TagKey<Item> create(String p_203849_) {
/* 27 */     return TagKey.m_203882_(Registry.f_122904_, new ResourceLocation("rootoffear", p_203849_));
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\TagInit$Items.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */