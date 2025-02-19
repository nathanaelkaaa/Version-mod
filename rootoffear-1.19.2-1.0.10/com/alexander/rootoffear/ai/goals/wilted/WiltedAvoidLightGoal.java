/*    */ package com.alexander.rootoffear.ai.goals.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.PathfinderMob;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.entity.ai.util.DefaultRandomPos;
/*    */ import net.minecraft.world.level.LightLayer;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ 
/*    */ public class WiltedAvoidLightGoal
/*    */   extends Goal
/*    */ {
/*    */   public Wilted mob;
/*    */   public int tryTicks;
/*    */   public int nextUseTime;
/*    */   
/*    */   public WiltedAvoidLightGoal(Wilted mob) {
/* 21 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
/* 22 */     this.mob = mob;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 27 */     if (this.mob.isBrightEnoughToBurn() && this.mob.f_19797_ >= this.nextUseTime) {
/* 28 */       Vec3 pos = findTarget();
/* 29 */       if (pos != null) {
/* 30 */         this.mob.m_21573_().m_26519_(pos.f_82479_, pos.f_82480_, pos.f_82481_, 1.0D);
/* 31 */         return true;
/*    */       } 
/* 33 */       return false;
/*    */     } 
/*    */     
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public Vec3 findTarget() {
/* 41 */     for (int i = 0; i < 10; i++) {
/* 42 */       Vec3 pos = DefaultRandomPos.m_148407_((PathfinderMob)this.mob, 15, 10, MiscUtils.isEntityValid(this.mob.m_5448_()) ? this.mob.m_5448_().m_20182_() : this.mob.m_20182_());
/* 43 */       if (pos != null && this.mob.f_19853_.m_45517_(LightLayer.BLOCK, new BlockPos(pos)) == 0) {
/* 44 */         return pos;
/*    */       }
/*    */     } 
/*    */     
/* 48 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 53 */     super.m_8056_();
/* 54 */     this.tryTicks = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 59 */     return (!this.mob.m_21573_().m_26571_() && this.mob.isBrightEnoughToBurn() && this.tryTicks < 200);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 64 */     super.m_8037_();
/* 65 */     this.mob.targetMovementSpeed = 0.35D;
/* 66 */     this.tryTicks++;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 71 */     super.m_8041_();
/* 72 */     this.nextUseTime = this.mob.f_19797_ + 20;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\goals\wilted\WiltedAvoidLightGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */