/*    */ package com.alexander.rootoffear.mixin;
/*    */ 
/*    */ import com.alexander.rootoffear.enums.RoFBedSleepingProblems;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Mutable;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.gen.Invoker;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Unique
/*    */ @Mixin({Player.BedSleepingProblem.class})
/*    */ public class BedSleepingProblemMixin
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   @Mutable
/*    */   private static Player.BedSleepingProblem[] $VALUES;
/* 27 */   private static final Player.BedSleepingProblem WILTED = rootoffear_addNewBedSleepingProblem(RoFBedSleepingProblems.WILTED.K, (Component)Component.m_237115_("block.minecraft.bed.wilted"));
/*    */   
/*    */   @Invoker("<init>")
/*    */   public static Player.BedSleepingProblem rootoffear_initNewBedSleepingProblem(String internalName, int internalId, Component message) {
/* 31 */     throw new AssertionError();
/*    */   }
/*    */   
/*    */   private static Player.BedSleepingProblem rootoffear_addNewBedSleepingProblem(String internalName, Component message) {
/* 35 */     ArrayList<Player.BedSleepingProblem> currentTypes = new ArrayList<>(Arrays.asList($VALUES));
/* 36 */     Player.BedSleepingProblem newType = rootoffear_initNewBedSleepingProblem(internalName, ((Player.BedSleepingProblem)currentTypes.get(currentTypes.size() - 1)).ordinal() + 1, message);
/* 37 */     currentTypes.add(newType);
/* 38 */     $VALUES = currentTypes.<Player.BedSleepingProblem>toArray(new Player.BedSleepingProblem[0]);
/*    */     
/* 40 */     return newType;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\BedSleepingProblemMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */