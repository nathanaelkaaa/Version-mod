/*    */ package com.alexander.rootoffear.ai.controllers.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.ai.control.BodyRotationControl;
/*    */ 
/*    */ public class WiltedBodyRotationControl
/*    */   extends BodyRotationControl {
/*    */   public final Wilted wilted;
/*    */   
/*    */   public WiltedBodyRotationControl(Wilted wilted) {
/* 14 */     super((Mob)wilted);
/* 15 */     this.wilted = wilted;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8121_() {
/* 20 */     if (this.wilted.isDisguised()) {
/* 21 */       if (m_24884_()) {
/* 22 */         this.wilted.f_20883_ = this.wilted.m_146908_();
/*    */       } else {
/* 24 */         this.wilted.f_20883_ = Mth.m_14179_(0.3F, Mth.m_14177_(this.wilted.f_20883_), MiscUtils.roundDegrees(this.wilted.m_146908_(), 90.0F));
/*    */       } 
/*    */     } else {
/* 27 */       super.m_8121_();
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean m_24884_() {
/* 32 */     double d0 = this.wilted.m_20185_() - this.wilted.f_19854_;
/* 33 */     double d1 = this.wilted.m_20189_() - this.wilted.f_19856_;
/* 34 */     return (d0 * d0 + d1 * d1 > 2.500000277905201E-7D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\controllers\wilted\WiltedBodyRotationControl.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */