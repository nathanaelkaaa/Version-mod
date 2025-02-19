/*    */ package com.alexander.rootoffear.ai.controllers.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.ai.control.LookControl;
/*    */ 
/*    */ public class WiltedLookControl
/*    */   extends LookControl {
/*    */   public final Wilted wilted;
/*    */   
/*    */   public WiltedLookControl(Wilted wilted) {
/* 12 */     super((Mob)wilted);
/* 13 */     this.wilted = wilted;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void m_142586_() {
/* 18 */     if (this.wilted.isDisguised()) {
/* 19 */       this.f_24937_.f_20885_ = this.f_24937_.f_20883_;
/*    */     } else {
/* 21 */       super.m_142586_();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\controllers\wilted\WiltedLookControl.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */