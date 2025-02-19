/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import net.minecraft.world.level.block.Block;
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
/*    */ public class Blocks
/*    */ {
/* 32 */   public static final TagKey<Block> DESTROYED_NOT_EXTINGUISHED = create("destroyed_not_extinguished");
/*    */   
/*    */   private static TagKey<Block> create(String p_203849_) {
/* 35 */     return TagKey.m_203882_(Registry.f_122901_, new ResourceLocation("rootoffear", p_203849_));
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\TagInit$Blocks.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */