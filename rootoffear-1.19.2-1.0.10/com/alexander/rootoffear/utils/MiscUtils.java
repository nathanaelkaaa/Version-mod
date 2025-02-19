/*    */ package com.alexander.rootoffear.utils;
/*    */ 
/*    */ import com.alexander.rootoffear.init.TagInit;
/*    */ import net.minecraft.core.HolderSet;
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ 
/*    */ public class MiscUtils {
/* 15 */   public static RandomSource random = RandomSource.m_216327_();
/*    */   
/*    */   public static void disableShield(LivingEntity livingEntity, int ticks) {
/* 18 */     if (livingEntity instanceof Player && livingEntity.m_21254_()) {
/* 19 */       ((Player)livingEntity).m_36335_()
/* 20 */         .m_41524_(livingEntity.m_21120_(livingEntity.m_7655_()).m_41720_(), ticks);
/* 21 */       livingEntity.m_5810_();
/* 22 */       livingEntity.f_19853_.m_7605_((Entity)livingEntity, (byte)30);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean isEntityAttackable(LivingEntity attacker, LivingEntity target, double distance) {
/* 27 */     return (attacker.m_142582_((Entity)target) && attacker.m_20270_((Entity)target) <= getTargetDistance(attacker, target, distance));
/*    */   }
/*    */   
/*    */   public static boolean isEntityAttackable(LivingEntity attacker, LivingEntity target, double minDistance, double maxDistance) {
/* 31 */     return (attacker.m_142582_((Entity)target) && attacker.m_20270_((Entity)target) <= getTargetDistance(attacker, target, maxDistance) && attacker.m_20270_((Entity)target) >= getTargetDistance(attacker, target, minDistance));
/*    */   }
/*    */   
/*    */   public static boolean isEntityAttackableMin(LivingEntity attacker, LivingEntity target, double distance) {
/* 35 */     return (attacker.m_142582_((Entity)target) && attacker.m_20270_((Entity)target) >= getTargetDistance(attacker, target, distance));
/*    */   }
/*    */   
/*    */   public static double getTargetDistance(LivingEntity attacker, LivingEntity target, double distance) {
/* 39 */     return (attacker.m_20205_() / 2.0F + target.m_20205_() / 2.0F) + distance;
/*    */   }
/*    */   
/*    */   public static boolean isEntityValid(LivingEntity target) {
/* 43 */     return (target != null && !target.m_213877_() && !target.m_21224_());
/*    */   }
/*    */   
/*    */   public static boolean isEntityValid(Entity target) {
/* 47 */     return (target != null && !target.m_213877_());
/*    */   }
/*    */   
/*    */   public static boolean inSurvivalMode(LivingEntity target) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokestatic isEntityValid : (Lnet/minecraft/world/entity/LivingEntity;)Z
/*    */     //   4: ifeq -> 44
/*    */     //   7: aload_0
/*    */     //   8: invokevirtual m_5833_ : ()Z
/*    */     //   11: ifne -> 44
/*    */     //   14: aload_0
/*    */     //   15: instanceof net/minecraft/world/entity/player/Player
/*    */     //   18: ifeq -> 33
/*    */     //   21: aload_0
/*    */     //   22: checkcast net/minecraft/world/entity/player/Player
/*    */     //   25: astore_1
/*    */     //   26: aload_1
/*    */     //   27: invokevirtual m_7500_ : ()Z
/*    */     //   30: ifeq -> 40
/*    */     //   33: aload_0
/*    */     //   34: instanceof net/minecraft/world/entity/player/Player
/*    */     //   37: ifne -> 44
/*    */     //   40: iconst_1
/*    */     //   41: goto -> 45
/*    */     //   44: iconst_0
/*    */     //   45: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #51	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   26	7	1	player	Lnet/minecraft/world/entity/player/Player;
/*    */     //   0	46	0	target	Lnet/minecraft/world/entity/LivingEntity;
/*    */   }
/*    */   
/*    */   public static int randomIntBetween(int min, int max) {
/* 55 */     return (max - min <= min) ? min : (min + random.m_188503_(max - min));
/*    */   }
/*    */   
/*    */   public static float round(float number, float roundTo) {
/* 59 */     float temp = number % roundTo;
/* 60 */     if (temp < 0.0F)
/* 61 */       temp = roundTo + temp; 
/* 62 */     if (temp == 0.0F)
/* 63 */       return number; 
/* 64 */     return number + roundTo - temp;
/*    */   }
/*    */   
/*    */   public static float roundDegrees(float number, float roundTo) {
/* 68 */     float wrappedNumber = Mth.m_14177_(number);
/* 69 */     float wrappedRoundTo = Mth.m_14177_(roundTo);
/* 70 */     float temp = wrappedNumber % wrappedRoundTo;
/* 71 */     if (temp < 0.0F)
/* 72 */       temp = wrappedRoundTo + temp; 
/* 73 */     if (temp == 0.0F)
/* 74 */       return wrappedNumber; 
/* 75 */     return wrappedNumber + wrappedRoundTo - temp;
/*    */   }
/*    */   
/*    */   public static AABB getSpawnAABB(EntityType<?> type, double x, double y, double z) {
/* 79 */     float f = type.m_20678_() / 2.0F;
/* 80 */     float f1 = type.m_20679_();
/* 81 */     return new AABB(x - f, y, z - f, x + f, y + f1, z + f);
/*    */   }
/*    */   
/*    */   public static boolean isEntityInValidWiltedSpawnBiome(Entity entity) {
/* 85 */     return (entity.f_19853_.m_204166_(entity.m_20183_()).m_203656_(TagInit.Biomes.WILTED_SPAWNS_IN) || ((HolderSet.Named)((Registry)entity.m_20194_().m_206579_().m_6632_(Registry.f_122885_).get()).m_203431_(TagInit.Biomes.WILTED_SPAWNS_IN).get()).m_203614_().toList().isEmpty());
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffea\\utils\MiscUtils.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */