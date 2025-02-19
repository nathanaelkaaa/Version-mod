/*    */ package com.alexander.rootoffear.ai.controllers.wilted;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Position;
/*    */ import net.minecraft.core.Vec3i;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.pathfinder.BlockPathTypes;
/*    */ import net.minecraft.world.level.pathfinder.NodeEvaluator;
/*    */ import net.minecraft.world.level.pathfinder.PathFinder;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ 
/*    */ public class WiltedNavigation extends GroundPathNavigation {
/*    */   public WiltedNavigation(Mob mob, Level level) {
/* 14 */     super(mob, level);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void m_7636_() {
/* 19 */     Vec3 vec3 = m_7475_();
/* 20 */     this.f_26505_ = this.f_26494_.m_20205_() * 2.0F;
/* 21 */     BlockPos blockPos = this.f_26496_.m_77400_();
/* 22 */     double d0 = Math.abs(this.f_26494_.m_20185_() - blockPos.m_123341_() + (this.f_26494_.m_20205_() + 1.0F) / 2.0D);
/* 23 */     double d1 = Math.abs(this.f_26494_.m_20186_() - blockPos.m_123342_());
/* 24 */     double d2 = Math.abs(this.f_26494_.m_20189_() - blockPos.m_123343_() + (this.f_26494_.m_20205_() + 1.0F) / 2.0D);
/* 25 */     boolean flag = (d0 <= this.f_26505_ && d2 <= this.f_26505_ && d1 < (this.f_26494_.m_20206_() / 2.0F));
/* 26 */     if (flag || (canCutCorner((this.f_26496_.m_77401_()).f_77282_) && m_26559_(vec3))) {
/* 27 */       this.f_26496_.m_77374_();
/*    */     }
/*    */     
/* 30 */     m_6481_(vec3);
/*    */   }
/*    */   
/*    */   private boolean m_26559_(Vec3 p_26560_) {
/* 34 */     if (this.f_26496_.m_77399_() + 1 >= this.f_26496_.m_77398_()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Vec3 vec3 = Vec3.m_82539_((Vec3i)this.f_26496_.m_77400_());
/* 38 */     if (!p_26560_.m_82509_((Position)vec3, 2.0D))
/* 39 */       return false; 
/* 40 */     if (m_183431_(p_26560_, this.f_26496_.m_77380_((Entity)this.f_26494_))) {
/* 41 */       return true;
/*    */     }
/* 43 */     Vec3 vec31 = Vec3.m_82539_((Vec3i)this.f_26496_.m_77396_(this.f_26496_.m_77399_() + 1));
/* 44 */     Vec3 vec32 = vec3.m_82546_(p_26560_);
/* 45 */     Vec3 vec33 = vec31.m_82546_(p_26560_);
/* 46 */     double d0 = vec32.m_82556_();
/* 47 */     double d1 = vec33.m_82556_();
/* 48 */     boolean flag = (d1 < d0);
/* 49 */     boolean flag1 = (d0 < 0.5D);
/* 50 */     if (!flag && !flag1) {
/* 51 */       return false;
/*    */     }
/* 53 */     Vec3 vec34 = vec32.m_82541_();
/* 54 */     Vec3 vec35 = vec33.m_82541_();
/* 55 */     return (vec35.m_82526_(vec34) < 0.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected PathFinder m_5532_(int maxVisitedNodes) {
/* 63 */     this.f_26508_ = (NodeEvaluator)new WiltedNodeEvaluator();
/* 64 */     this.f_26508_.m_77351_(true);
/* 65 */     return new PathFinder(this.f_26508_, maxVisitedNodes);
/*    */   }
/*    */   
/*    */   public boolean canCutCorner(BlockPathTypes p_265292_) {
/* 69 */     return (p_265292_ != BlockPathTypes.DANGER_FIRE && p_265292_ != BlockPathTypes.DANGER_OTHER && p_265292_ != BlockPathTypes.WALKABLE_DOOR);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\controllers\wilted\WiltedNavigation.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */