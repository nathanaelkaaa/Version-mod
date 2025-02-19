/*    */ package com.alexander.rootoffear.ai.goals;
/*    */ 
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ 
/*    */ public class LookAtTargetGoal
/*    */   extends Goal {
/*    */   protected final Mob mob;
/*    */   
/*    */   public LookAtTargetGoal(Mob mob) {
/* 12 */     m_7021_(EnumSet.of(Goal.Flag.LOOK));
/* 13 */     this.mob = mob;
/*    */   }
/*    */   
/*    */   public boolean m_8036_() {
/* 17 */     return (this.mob.m_5448_() != null && this.mob.m_5448_().m_6084_());
/*    */   }
/*    */   
/*    */   public boolean m_8045_() {
/* 21 */     return (this.mob.m_5448_() != null && this.mob.m_5448_().m_6084_());
/*    */   }
/*    */   
/*    */   public void m_8037_() {
/* 25 */     if (this.mob.m_5448_() != null && this.mob.m_5448_().m_6084_())
/* 26 */       this.mob.m_21563_().m_24946_(this.mob.m_5448_().m_20185_(), this.mob.m_5448_().m_20188_(), this.mob.m_5448_().m_20189_()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\LookAtTargetGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */