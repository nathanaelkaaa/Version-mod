/*    */ package com.alexander.rootoffear.ai.controllers.wilted;
/*    */ 
/*    */ import com.alexander.rootoffear.utils.PositionUtils;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.world.level.LightLayer;
/*    */ import net.minecraft.world.level.pathfinder.Node;
/*    */ import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedNodeEvaluator
/*    */   extends WalkNodeEvaluator
/*    */ {
/*    */   protected boolean m_77626_(@Nullable Node neighbor, Node node) {
/* 16 */     return (super.m_77626_(neighbor, node) && isNodeDarkEnough(neighbor));
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean m_77629_(Node root, @Nullable Node xNode, @Nullable Node yNode, @Nullable Node zNode) {
/* 21 */     return (super.m_77629_(root, xNode, yNode, zNode) && isNodeDarkEnough(xNode) && isNodeDarkEnough(yNode) && isNodeDarkEnough(zNode));
/*    */   }
/*    */   
/*    */   public boolean isNodeDarkEnough(Node node) {
/* 25 */     int i = (this.f_77313_ instanceof com.alexander.rootoffear.entities.ShadowWilted) ? 0 : 2;
/* 26 */     return (PositionUtils.isBlockCollidable(this.f_77313_.f_19853_, node.m_77288_()) || this.f_77313_.f_19853_.m_45517_(LightLayer.BLOCK, node.m_77288_()) <= i || this.f_77313_.f_19853_.m_45517_(LightLayer.BLOCK, node.m_77288_()) < this.f_77313_.f_19853_.m_45517_(LightLayer.BLOCK, this.f_77313_.m_20183_()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\controllers\wilted\WiltedNodeEvaluator.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */