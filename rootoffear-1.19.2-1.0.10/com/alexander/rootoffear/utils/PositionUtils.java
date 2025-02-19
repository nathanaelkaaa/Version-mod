/*     */ package com.alexander.rootoffear.utils;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.ClipContext;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.HitResult;
/*     */ import net.minecraft.world.phys.Vec2;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ 
/*     */ public class PositionUtils
/*     */ {
/*     */   public static Vec2 rotationToFace(Vec3 rotatingFrom, Vec3 facing) {
/*  21 */     double x = facing.f_82479_ - rotatingFrom.f_82479_;
/*  22 */     double y = facing.f_82480_ - rotatingFrom.f_82480_;
/*  23 */     double z = facing.f_82481_ - rotatingFrom.f_82481_;
/*  24 */     double distance = Math.sqrt(x * x + z * z);
/*  25 */     float yRot = (float)(Mth.m_14136_(z, x) * 57.2957763671875D) - 90.0F;
/*  26 */     float xRot = (float)-(Mth.m_14136_(y, distance) * 57.2957763671875D);
/*  27 */     return new Vec2(xRot, yRot);
/*     */   }
/*     */   
/*     */   public static boolean hasLineOfSight(Entity entitySearching, Vec3 targetPos) {
/*  31 */     Vec3 vec3 = new Vec3(entitySearching.m_20185_(), entitySearching.m_20188_(), entitySearching.m_20189_());
/*  32 */     Vec3 vec31 = new Vec3(targetPos.f_82479_, targetPos.f_82480_, targetPos.f_82481_);
/*  33 */     if (vec31.m_82554_(vec3) > 128.0D) {
/*  34 */       return false;
/*     */     }
/*  36 */     BlockHitResult clip = entitySearching.f_19853_.m_45547_(new ClipContext(vec3, vec31, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entitySearching));
/*     */     
/*  38 */     return (clip.m_6662_() == HitResult.Type.MISS);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean hasLineOfSight(Entity entitySearching, BlockPos targetPos) {
/*  43 */     Vec3 vec3 = new Vec3(entitySearching.m_20185_(), entitySearching.m_20188_(), entitySearching.m_20189_());
/*  44 */     Vec3 vec31 = new Vec3(targetPos.m_123341_() + 0.5D, targetPos.m_123342_() + 0.5D, targetPos.m_123343_() + 0.5D);
/*  45 */     if (vec31.m_82554_(vec3) > 128.0D) {
/*  46 */       return false;
/*     */     }
/*  48 */     BlockHitResult clip = entitySearching.f_19853_.m_45547_(new ClipContext(vec3, vec31, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entitySearching));
/*     */     
/*  50 */     return (clip.m_6662_() == HitResult.Type.MISS);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean hasLineOfSight(Level level, Vec3 searchingPos, Vec3 targetPos) {
/*  55 */     Vec3 vec3 = new Vec3(searchingPos.f_82479_, searchingPos.f_82480_, searchingPos.f_82481_);
/*  56 */     Vec3 vec31 = new Vec3(targetPos.f_82479_, targetPos.f_82480_, targetPos.f_82481_);
/*  57 */     if (vec31.m_82554_(vec3) > 128.0D) {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     BlockHitResult clip = level.m_45547_(new ClipContext(vec3, vec31, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, null));
/*  62 */     return (clip.m_6662_() == HitResult.Type.MISS);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float distanceTo(Entity mob, BlockPos pos) {
/*  67 */     float f = (float)(mob.m_20185_() - pos.m_123341_());
/*  68 */     float f1 = (float)(mob.m_20186_() - pos.m_123342_());
/*  69 */     float f2 = (float)(mob.m_20189_() - pos.m_123343_());
/*  70 */     return Mth.m_14116_(f * f + f1 * f1 + f2 * f2);
/*     */   }
/*     */   
/*     */   public static float distanceTo(Entity mob, Vec3 pos) {
/*  74 */     float f = (float)(mob.m_20185_() - pos.f_82479_);
/*  75 */     float f1 = (float)(mob.m_20186_() - pos.f_82480_);
/*  76 */     float f2 = (float)(mob.m_20189_() - pos.f_82481_);
/*  77 */     return Mth.m_14116_(f * f + f1 * f1 + f2 * f2);
/*     */   }
/*     */   
/*     */   public static float distanceTo(Vec3 posA, Vec3 posB) {
/*  81 */     float f = (float)(posA.f_82479_ - posB.f_82479_);
/*  82 */     float f1 = (float)(posA.f_82480_ - posB.f_82480_);
/*  83 */     float f2 = (float)(posA.f_82481_ - posB.f_82481_);
/*  84 */     return Mth.m_14116_(f * f + f1 * f1 + f2 * f2);
/*     */   }
/*     */   
/*     */   public static float distanceTo(BlockPos posA, BlockPos posB) {
/*  88 */     float f = (posA.m_123341_() - posB.m_123341_());
/*  89 */     float f1 = (posA.m_123342_() - posB.m_123342_());
/*  90 */     float f2 = (posA.m_123343_() - posB.m_123343_());
/*  91 */     return Mth.m_14116_(f * f + f1 * f1 + f2 * f2);
/*     */   }
/*     */   
/*     */   public static boolean isBlockCollidable(Level level, BlockPos pos) {
/*  95 */     return (!level.m_8055_(pos).m_60795_() && !level.m_8055_(pos).m_60812_((BlockGetter)level, pos).m_83281_());
/*     */   }
/*     */   
/*     */   public static boolean isBlockCollidable(Level level, Vec3 pos) {
/*  99 */     return isBlockCollidable(level, new BlockPos(pos));
/*     */   }
/*     */   
/*     */   public static Vec3 getOffsetPos(Entity entity, double offsetX, double offsetY, double offsetZ, float rotationX, float rotationY) {
/* 103 */     Vec3 Vec3 = (new Vec3(offsetZ, offsetY, offsetX)).m_82535_((float)Math.toRadians(rotationX)).m_82524_(-rotationY * 0.017453292F - 1.5707964F);
/* 104 */     return entity.m_20182_().m_82520_(Vec3.f_82479_, Vec3.f_82480_, Vec3.f_82481_);
/*     */   }
/*     */   
/*     */   public static Vec3 getOffsetPos(Vec3 pos, double offsetX, double offsetY, double offsetZ, float rotationX, float rotationY) {
/* 108 */     Vec3 vec3 = (new Vec3(offsetZ, offsetY, offsetX)).m_82535_((float)Math.toRadians(rotationX)).m_82524_(-rotationY * 0.017453292F - 1.5707964F);
/* 109 */     return pos.m_82520_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_);
/*     */   }
/*     */   
/*     */   public static Comparator<BlockPos> distanceComparator(BlockPos pos) {
/* 113 */     return (a, b) -> (int)distanceTo(pos, a) - (int)distanceTo(pos, b);
/*     */   }
/*     */   
/*     */   public static void moveToGroundHeight(Entity entity, boolean discardIfOutOfBounds) {
/* 117 */     BlockPos blockpos = new BlockPos((int)entity.m_20185_(), entity.f_19853_.m_151558_(), (int)entity.m_20189_());
/* 118 */     boolean flag = false;
/* 119 */     double d0 = 0.0D;
/*     */     
/* 121 */     int i = 0;
/*     */     
/*     */     do {
/* 124 */       blockpos = entity.m_20183_().m_7918_(0, i, 0);
/* 125 */       BlockPos blockpos1 = blockpos.m_7495_();
/* 126 */       BlockState blockstate = entity.f_19853_.m_8055_(blockpos1);
/* 127 */       if (blockstate.m_60783_((BlockGetter)entity.f_19853_, blockpos1, Direction.UP) && (entity.f_19853_.m_46859_(blockpos) || entity.f_19853_.m_8055_(blockpos).m_60812_((BlockGetter)entity.f_19853_, blockpos).m_83281_())) {
/* 128 */         if (!entity.f_19853_.m_46859_(blockpos)) {
/* 129 */           BlockState blockState = entity.f_19853_.m_8055_(blockpos);
/* 130 */           VoxelShape voxelshape = blockState.m_60812_((BlockGetter)entity.f_19853_, blockpos);
/* 131 */           if (!voxelshape.m_83281_()) {
/* 132 */             d0 = voxelshape.m_83297_(Direction.Axis.Y);
/*     */           }
/*     */         } 
/*     */         
/* 136 */         flag = true;
/*     */         
/*     */         break;
/*     */       } 
/* 140 */       blockpos = entity.m_20183_().m_7918_(0, -i, 0);
/* 141 */       BlockPos blockpos2 = blockpos.m_7495_();
/* 142 */       BlockState blockstate1 = entity.f_19853_.m_8055_(blockpos2);
/* 143 */       if (blockstate1.m_60783_((BlockGetter)entity.f_19853_, blockpos2, Direction.UP) && (entity.f_19853_.m_46859_(blockpos) || entity.f_19853_.m_8055_(blockpos).m_60812_((BlockGetter)entity.f_19853_, blockpos).m_83281_())) {
/* 144 */         if (!entity.f_19853_.m_46859_(blockpos)) {
/* 145 */           BlockState blockstate11 = entity.f_19853_.m_8055_(blockpos);
/* 146 */           VoxelShape voxelshape = blockstate11.m_60812_((BlockGetter)entity.f_19853_, blockpos);
/* 147 */           if (!voxelshape.m_83281_()) {
/* 148 */             d0 = voxelshape.m_83297_(Direction.Axis.Y);
/*     */           }
/*     */         } 
/*     */         
/* 152 */         flag = true;
/*     */         
/*     */         break;
/*     */       } 
/* 156 */       if (blockpos.m_123342_() > entity.f_19853_.m_151558_() || blockpos.m_123342_() < entity.f_19853_.m_141937_()) {
/* 157 */         if (discardIfOutOfBounds) {
/* 158 */           entity.m_146870_();
/*     */         }
/* 160 */         blockpos = entity.m_20183_();
/* 161 */         flag = true;
/*     */         
/*     */         break;
/*     */       } 
/* 165 */       i++;
/* 166 */     } while (!flag);
/*     */     
/* 168 */     if (flag) {
/* 169 */       entity.m_6027_(entity.m_20185_(), blockpos.m_123342_() + d0, entity.m_20189_());
/*     */     }
/*     */   }
/*     */   
/*     */   public static BlockPos moveToGroundHeight(Level level, BlockPos pos, int maxDistance) {
/* 174 */     BlockPos blockpos = new BlockPos(pos.m_123341_(), level.m_151558_(), pos.m_123343_());
/* 175 */     boolean flag = false;
/*     */     
/* 177 */     int i = 0;
/*     */     
/*     */     do {
/* 180 */       blockpos = pos.m_7918_(0, i, 0);
/* 181 */       BlockPos blockpos1 = blockpos.m_7495_();
/* 182 */       BlockState blockstate = level.m_8055_(blockpos1);
/* 183 */       if (blockstate.m_60783_((BlockGetter)level, blockpos1, Direction.UP) && (level.m_46859_(blockpos) || level.m_8055_(blockpos).m_60812_((BlockGetter)level, blockpos).m_83281_())) {
/* 184 */         flag = true;
/*     */         
/*     */         break;
/*     */       } 
/* 188 */       blockpos = pos.m_7918_(0, -i, 0);
/* 189 */       BlockPos blockpos2 = blockpos.m_7495_();
/* 190 */       BlockState blockstate1 = level.m_8055_(blockpos2);
/* 191 */       if (blockstate1.m_60783_((BlockGetter)level, blockpos2, Direction.UP) && (level.m_46859_(blockpos) || level.m_8055_(blockpos).m_60812_((BlockGetter)level, blockpos).m_83281_())) {
/* 192 */         flag = true;
/*     */         
/*     */         break;
/*     */       } 
/* 196 */       if (blockpos.m_123342_() > level.m_151558_() || blockpos.m_123342_() < level.m_141937_() || i > maxDistance) {
/* 197 */         return null;
/*     */       }
/*     */       
/* 200 */       i++;
/* 201 */     } while (!flag);
/*     */     
/* 203 */     return blockpos;
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffea\\utils\PositionUtils.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */