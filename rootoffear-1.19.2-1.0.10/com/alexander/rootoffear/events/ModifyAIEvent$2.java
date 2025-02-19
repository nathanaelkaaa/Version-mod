/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
/*    */ import net.minecraft.world.entity.animal.Wolf;
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
/*    */ class null
/*    */   extends NearestAttackableTargetGoal<Wilted>
/*    */ {
/*    */   null(Mob p_26060_, Class<Wilted> p_26061_, boolean p_26062_) {
/* 42 */     super(p_26060_, p_26061_, p_26062_);
/*    */   }
/*    */   public boolean m_8036_() {
/* 45 */     if (super.m_8036_()) { Mob mob = this.f_26135_; if (mob instanceof Wolf) { Wolf wolf = (Wolf)mob; if (wolf.m_21824_()); }  }  return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\ModifyAIEvent$2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */