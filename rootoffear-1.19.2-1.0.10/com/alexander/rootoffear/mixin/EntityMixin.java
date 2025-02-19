/*    */ package com.alexander.rootoffear.mixin;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import com.llamalad7.mixinextras.sugar.ref.LocalRef;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.border.WorldBorder;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraft.world.phys.shapes.VoxelShape;
/*    */ import net.minecraftforge.fml.ModList;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({Entity.class})
/*    */ public abstract class EntityMixin
/*    */ {
/*    */   @Inject(at = {@At("HEAD")}, method = {"collide"}, cancellable = true)
/*    */   private void rootoffear_fixRadiumAndCanaryIncompatibility(Vec3 vec, CallbackInfoReturnable<Vec3> callback) {
/* 31 */     Entity entity = (Entity)this;
/* 32 */     if ((ModList.get().isLoaded("radium") || ModList.get().isLoaded("canary") || ModList.get().isLoaded("lithium")) && entity instanceof Wilted) { Wilted wilted = (Wilted)entity; if (wilted.canPhaseThroughWalls() && (wilted.isPhasingThroughWall() || wilted.isNearWall() || wilted.bottomIsInGround() || wilted.wantsToGoDownwards)) {
/* 33 */         AABB aabb = wilted.m_20191_();
/* 34 */         List<VoxelShape> list = wilted.f_19853_.m_183134_((Entity)wilted, aabb.m_82369_(vec));
/* 35 */         Vec3 vec3 = (vec.m_82556_() == 0.0D) ? vec : collideBoundingBoxWilted(wilted, vec, aabb, wilted.f_19853_, list);
/* 36 */         boolean flag = (vec.f_82479_ != vec3.f_82479_);
/* 37 */         boolean flag1 = (vec.f_82480_ != vec3.f_82480_);
/* 38 */         boolean flag2 = (vec.f_82481_ != vec3.f_82481_);
/* 39 */         boolean flag3 = (wilted.m_20096_() || (flag1 && vec.f_82480_ < 0.0D));
/* 40 */         float stepHeight = wilted.getStepHeight();
/* 41 */         if (stepHeight > 0.0F && flag3 && (flag || flag2)) {
/* 42 */           Vec3 vec31 = collideBoundingBoxWilted(wilted, new Vec3(vec.f_82479_, stepHeight, vec.f_82481_), aabb, wilted.f_19853_, list);
/* 43 */           Vec3 vec32 = collideBoundingBoxWilted(wilted, new Vec3(0.0D, stepHeight, 0.0D), aabb.m_82363_(vec.f_82479_, 0.0D, vec.f_82481_), wilted.f_19853_, list);
/* 44 */           if (vec32.f_82480_ < stepHeight) {
/* 45 */             Vec3 vec33 = collideBoundingBoxWilted(wilted, new Vec3(vec.f_82479_, 0.0D, vec.f_82481_), aabb.m_82383_(vec32), wilted.f_19853_, list).m_82549_(vec32);
/* 46 */             if (vec33.m_165925_() > vec31.m_165925_()) {
/* 47 */               vec31 = vec33;
/*    */             }
/*    */           } 
/*    */           
/* 51 */           if (vec31.m_165925_() > vec3.m_165925_()) {
/* 52 */             callback.setReturnValue(vec31.m_82549_(collideBoundingBoxWilted(wilted, new Vec3(0.0D, -vec31.f_82480_ + vec.f_82480_, 0.0D), aabb.m_82383_(vec31), wilted.f_19853_, list)));
/*    */           }
/*    */         } 
/*    */         
/* 56 */         callback.setReturnValue(vec3);
/*    */       }  }
/*    */   
/*    */   }
/*    */   @Inject(at = {@At("RETURN")}, method = {"Lnet/minecraft/world/entity/Entity;collideBoundingBox(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/AABB;Lnet/minecraft/world/level/Level;Ljava/util/List;)Lnet/minecraft/world/phys/Vec3;"}, cancellable = true)
/*    */   private static void rootoffear_allowWiltedToMoveThroughWallsInDarkness(@Nullable Entity p_198895_, Vec3 p_198896_, AABB p_198897_, Level p_198898_, List<VoxelShape> p_198899_, CallbackInfoReturnable<Vec3> callback, @Local LocalRef<ImmutableList.Builder<VoxelShape>> builderRef) {
/* 62 */     if (p_198895_ != null && p_198895_ instanceof Wilted) { Wilted wilted = (Wilted)p_198895_; if (wilted.canPhaseThroughWalls() && (wilted.isPhasingThroughWall() || wilted.isNearWall() || wilted.bottomIsInGround() || wilted.wantsToGoDownwards))
/* 63 */         callback.setReturnValue(new Vec3(p_198896_.f_82479_, (!wilted.wantsToGoDownwards && p_198896_.f_82480_ <= 0.0D) ? (m_198900_(p_198896_, p_198897_, (List<VoxelShape>)((ImmutableList.Builder)builderRef.get()).build())).f_82480_ : p_198896_.f_82480_, p_198896_.f_82481_));  }
/*    */   
/*    */   }
/*    */   
/*    */   private static Vec3 collideBoundingBoxWilted(Wilted wilted, Vec3 p_198896_, AABB p_198897_, Level p_198898_, List<VoxelShape> p_198899_) {
/* 68 */     ImmutableList.Builder<VoxelShape> builder = ImmutableList.builderWithExpectedSize(p_198899_.size() + 1);
/* 69 */     if (!p_198899_.isEmpty()) {
/* 70 */       builder.addAll(p_198899_);
/*    */     }
/*    */     
/* 73 */     WorldBorder worldborder = p_198898_.m_6857_();
/*    */     
/* 75 */     boolean flag = (wilted != null && worldborder.m_187566_((Entity)wilted, p_198897_.m_82369_(p_198896_)));
/* 76 */     if (flag) {
/* 77 */       builder.add(worldborder.m_61946_());
/*    */     }
/*    */     
/* 80 */     builder.addAll(p_198898_.m_186434_((Entity)wilted, p_198897_.m_82369_(p_198896_)));
/* 81 */     return new Vec3(p_198896_.f_82479_, (
/* 82 */         !wilted.wantsToGoDownwards && p_198896_.f_82480_ <= 0.0D) ? 
/* 83 */         (m_198900_(p_198896_, p_198897_, (List<VoxelShape>)builder.build())).f_82480_ : 
/* 84 */         p_198896_.f_82480_, p_198896_.f_82481_);
/*    */   }
/*    */ 
/*    */   
/*    */   @Shadow
/*    */   public static Vec3 m_198900_(Vec3 p_198901_, AABB p_198902_, List<VoxelShape> p_198903_) {
/* 90 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\EntityMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */