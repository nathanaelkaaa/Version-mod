/*    */ package com.alexander.rootoffear.animations;
/*    */ 
/*    */ import net.minecraft.util.Mth;
/*    */ 
/*    */ public class WalkAnimationState {
/*    */   private float speedOld;
/*    */   private float speed;
/*    */   private float position;
/*    */   
/*    */   public void setSpeed(float p_268265_) {
/* 11 */     this.speed = p_268265_;
/*    */   }
/*    */   
/*    */   public void update(float p_267993_, float p_267967_) {
/* 15 */     this.speedOld = this.speed;
/* 16 */     this.speed += (p_267993_ - this.speed) * p_267967_;
/* 17 */     this.position += this.speed;
/*    */   }
/*    */   
/*    */   public float speed() {
/* 21 */     return this.speed;
/*    */   }
/*    */   
/*    */   public float speed(float p_268054_) {
/* 25 */     return Mth.m_14179_(p_268054_, this.speedOld, this.speed);
/*    */   }
/*    */   
/*    */   public float position() {
/* 29 */     return this.position;
/*    */   }
/*    */   
/*    */   public float position(float p_268007_) {
/* 33 */     return this.position - this.speed * (1.0F - p_268007_);
/*    */   }
/*    */   
/*    */   public boolean isMoving() {
/* 37 */     return (this.speed > 1.0E-5F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\animations\WalkAnimationState.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */