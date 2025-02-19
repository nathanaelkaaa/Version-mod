/*    */ package com.alexander.rootoffear.commands;
/*    */ 
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapability;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapabilityProvider;
/*    */ import com.mojang.brigadier.CommandDispatcher;
/*    */ import com.mojang.brigadier.arguments.ArgumentType;
/*    */ import com.mojang.brigadier.arguments.LongArgumentType;
/*    */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.commands.Commands;
/*    */ import net.minecraft.network.chat.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpawnDayCommands
/*    */ {
/*    */   public static void registerGet(CommandDispatcher<CommandSourceStack> dispatcher) {
/* 21 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("spawnday")
/* 22 */         .then(Commands.m_82127_("get").executes(SpawnDayCommands::get)));
/* 23 */     dispatcher.register(command);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerGetRelative(CommandDispatcher<CommandSourceStack> dispatcher) {
/* 30 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("spawnday")
/* 31 */         .then(Commands.m_82127_("getrelative").executes(SpawnDayCommands::getRelative)));
/* 32 */     dispatcher.register(command);
/*    */   }
/*    */   
/*    */   private static int get(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/* 36 */     return get((CommandSourceStack)context.getSource(), false);
/*    */   }
/*    */   
/*    */   private static int getRelative(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/* 40 */     return get((CommandSourceStack)context.getSource(), true);
/*    */   }
/*    */   
/*    */   private static int get(CommandSourceStack source, boolean relative) {
/* 44 */     if (source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).isPresent() && source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get() != null) {
/* 45 */       long returnValue = relative ? (((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).getNextSpawnDay() - source.m_81372_().m_46468_() / 24000L) : ((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).getNextSpawnDay();
/* 46 */       source.m_81354_((Component)Component.m_237110_(relative ? "commands.rootoffear.getspawndayrelative.success" : "commands.rootoffear.getspawnday.success", new Object[] { Long.valueOf(returnValue) }), true);
/* 47 */       return (int)returnValue;
/*    */     } 
/* 49 */     source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail"));
/* 50 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerSet(CommandDispatcher<CommandSourceStack> dispatcher) {
/* 59 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("spawnday")
/* 60 */         .then(Commands.m_82127_("set")
/* 61 */           .then(Commands.m_82129_("day", (ArgumentType)LongArgumentType.longArg())
/* 62 */             .executes(SpawnDayCommands::set))));
/* 63 */     dispatcher.register(command);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerSetRelative(CommandDispatcher<CommandSourceStack> dispatcher) {
/* 71 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("spawnday")
/* 72 */         .then(Commands.m_82127_("setrelative")
/* 73 */           .then(Commands.m_82129_("addeddays", (ArgumentType)LongArgumentType.longArg())
/* 74 */             .executes(SpawnDayCommands::setRelative))));
/* 75 */     dispatcher.register(command);
/*    */   }
/*    */   
/*    */   private static int set(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/* 79 */     return set(context, false);
/*    */   }
/*    */   
/*    */   private static int setRelative(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/* 83 */     return set(context, true);
/*    */   }
/*    */   
/*    */   private static int set(CommandContext<CommandSourceStack> context, boolean relative) {
/* 87 */     CommandSourceStack source = (CommandSourceStack)context.getSource();
/* 88 */     if (source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).isPresent() && source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get() != null) {
/* 89 */       ((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).setNextSpawnDay(relative ? (source.m_81372_().m_46468_() / 24000L + LongArgumentType.getLong(context, "addeddays")) : LongArgumentType.getLong(context, "day"));
/* 90 */       source.m_81354_((Component)Component.m_237110_(relative ? "commands.rootoffear.setspawndayrelative.success" : "commands.rootoffear.setspawnday.success", new Object[] { Long.valueOf(((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).getNextSpawnDay()) }), true);
/* 91 */       return (int)((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).getNextSpawnDay();
/*    */     } 
/* 93 */     source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail"));
/* 94 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\commands\SpawnDayCommands.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */