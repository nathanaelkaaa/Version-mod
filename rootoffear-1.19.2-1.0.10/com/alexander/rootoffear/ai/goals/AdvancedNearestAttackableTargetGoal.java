/*    */ package com.alexander.rootoffear.ai.goals;
/*    */ 
/*    */ import java.util.function.Predicate;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ 
/*    */ 
/*    */ public class AdvancedNearestAttackableTargetGoal<T extends LivingEntity>
/*    */   extends NearestAttackableTargetGoal<T>
/*    */ {
/*    */   public final boolean allDirections;
/*    */   
/*    */   public AdvancedNearestAttackableTargetGoal(Mob mob, Class<T> targetType, boolean mustSee, boolean mustReach, boolean allDirections, boolean targetsWithoutLineOfSight, @Nullable Predicate<LivingEntity> targetPredicate) {
/* 17 */     super(mob, targetType, mustSee, mustReach);
/* 18 */     if (targetsWithoutLineOfSight) {
/* 19 */       this.f_26051_.m_148355_();
/*    */     }
/* 21 */     this.allDirections = allDirections;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AABB m_7255_(double targetDistance) {
/* 26 */     return this.allDirections ? this.f_26135_.m_20191_().m_82377_(targetDistance, targetDistance, targetDistance) : super.m_7255_(targetDistance);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\AdvancedNearestAttackableTargetGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */