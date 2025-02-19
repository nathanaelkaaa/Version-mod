/*    */ package com.alexander.rootoffear.mixin;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.level.pathfinder.NodeEvaluator;
/*    */ import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({WalkNodeEvaluator.class})
/*    */ public abstract class WalkNodeEvaluatorMixin
/*    */   extends NodeEvaluator
/*    */ {
/*    */   @Inject(at = {@At("HEAD")}, method = {"hasCollisions"}, cancellable = true)
/*    */   private void rootoffear_nodeEvaluatorDoesntConsiderCollisionsForWiltedsInDarkness(AABB p_77635_, CallbackInfoReturnable<Boolean> callback) {
/* 19 */     Mob mob = this.f_77313_; if (mob instanceof Wilted) { Wilted wilted = (Wilted)mob; if (wilted.canPhaseThroughWalls())
/* 20 */         callback.setReturnValue(Boolean.valueOf(false));  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\WalkNodeEvaluatorMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */