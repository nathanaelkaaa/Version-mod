/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import com.alexander.rootoffear.commands.AssignedWiltedCommands;
/*    */ import com.alexander.rootoffear.commands.DisguisedCommands;
/*    */ import com.alexander.rootoffear.commands.SpawnDayCommands;
/*    */ import com.alexander.rootoffear.commands.UltimateTargetCommands;
/*    */ import net.minecraftforge.event.RegisterCommandsEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear")
/*    */ public class CommandInit
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void registerCommands(RegisterCommandsEvent event) {
/* 18 */     SpawnDayCommands.registerGet(event.getDispatcher());
/* 19 */     SpawnDayCommands.registerGetRelative(event.getDispatcher());
/* 20 */     SpawnDayCommands.registerSet(event.getDispatcher());
/* 21 */     SpawnDayCommands.registerSetRelative(event.getDispatcher());
/*    */     
/* 23 */     AssignedWiltedCommands.registerGetAssignedWilted(event.getDispatcher());
/* 24 */     AssignedWiltedCommands.registerSetAssignedWilted(event.getDispatcher());
/* 25 */     AssignedWiltedCommands.registerClearAssignedWilted(event.getDispatcher());
/*    */     
/* 27 */     UltimateTargetCommands.registerGetUltimateTarget(event.getDispatcher());
/* 28 */     UltimateTargetCommands.registerSetUltimateTarget(event.getDispatcher());
/* 29 */     UltimateTargetCommands.registerClearUltimateTarget(event.getDispatcher());
/*    */     
/* 31 */     DisguisedCommands.registerSetDisguised(event.getDispatcher());
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\CommandInit.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */