/*    */ package com.alexander.rootoffear.commands;
/*    */ 
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapability;
/*    */ import com.alexander.rootoffear.capabilities.RoFLevelCapabilityProvider;
/*    */ import com.mojang.brigadier.CommandDispatcher;
/*    */ import com.mojang.brigadier.arguments.ArgumentType;
/*    */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.commands.Commands;
/*    */ import net.minecraft.commands.arguments.EntityArgument;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AssignedWiltedCommands
/*    */ {
/*    */   public static void registerGetAssignedWilted(CommandDispatcher<CommandSourceStack> dispatcher) {
/* 21 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("assignedwilted")
/* 22 */         .then(Commands.m_82127_("get")
/* 23 */           .executes(AssignedWiltedCommands::getAssignedWilted)));
/* 24 */     dispatcher.register(command);
/*    */   }
/*    */   
/*    */   private static int getAssignedWilted(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/* 28 */     CommandSourceStack source = (CommandSourceStack)context.getSource();
/* 29 */     if (source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).isPresent() && source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get() != null) {
/* 30 */       if (((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).getWiltedID() == null) {
/* 31 */         source.m_81352_((Component)Component.m_237110_("commands.rootoffear.fail_no_assigned_wilted", new Object[] { source.m_81372_().m_46472_().m_135782_().toString() }));
/* 32 */         return 0;
/*    */       } 
/* 34 */       source.m_81354_((Component)Component.m_237110_("commands.rootoffear.getassignedwilted.success", new Object[] { source.m_81372_().m_46472_().m_135782_().toString(), source.m_81372_().m_8791_(((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).getWiltedID()).m_7755_() }), true);
/* 35 */       return 1;
/*    */     } 
/*    */     
/* 38 */     source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail"));
/* 39 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerSetAssignedWilted(CommandDispatcher<CommandSourceStack> dispatcher) {
/* 47 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("assignedwilted")
/* 48 */         .then(Commands.m_82127_("set")
/* 49 */           .then(Commands.m_82129_("wilted", (ArgumentType)EntityArgument.m_91449_())
/* 50 */             .executes(AssignedWiltedCommands::setAssignedWilted))));
/* 51 */     dispatcher.register(command);
/*    */   }
/*    */   
/*    */   private static int setAssignedWilted(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/* 55 */     CommandSourceStack source = (CommandSourceStack)context.getSource();
/* 56 */     if (source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).isPresent() && source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get() != null) {
/* 57 */       Entity entity = EntityArgument.m_91452_(context, "wilted");
/* 58 */       if (entity instanceof com.alexander.rootoffear.entities.Wilted) {
/* 59 */         ((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).setWiltedID(entity.m_20148_());
/* 60 */         source.m_81354_((Component)Component.m_237110_("commands.rootoffear.setassignedwilted.success", new Object[] { entity.m_7755_(), source.m_81372_().m_46472_().m_135782_().toString() }), true);
/* 61 */         return 1;
/*    */       } 
/* 63 */       source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail_not_wilted"));
/* 64 */       return 0;
/*    */     } 
/*    */     
/* 67 */     source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail"));
/* 68 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerClearAssignedWilted(CommandDispatcher<CommandSourceStack> dispatcher) {
/* 76 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("assignedwilted")
/* 77 */         .then(Commands.m_82127_("clear")
/* 78 */           .executes(AssignedWiltedCommands::clearAssignedWilted)));
/* 79 */     dispatcher.register(command);
/*    */   }
/*    */   
/*    */   private static int clearAssignedWilted(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/* 83 */     CommandSourceStack source = (CommandSourceStack)context.getSource();
/* 84 */     if (source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).isPresent() && source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get() != null) {
/* 85 */       if (((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).getWiltedID() == null) {
/* 86 */         source.m_81352_((Component)Component.m_237110_("commands.rootoffear.fail_no_assigned_wilted", new Object[] { source.m_81372_().m_46472_().m_135782_().toString() }));
/* 87 */         return 0;
/*    */       } 
/* 89 */       source.m_81354_((Component)Component.m_237110_("commands.rootoffear.clearassignedwilted.success", new Object[] { source.m_81372_().m_46472_().m_135782_().toString() }), true);
/* 90 */       ((RoFLevelCapability)source.m_81372_().getCapability(RoFLevelCapabilityProvider.CAP).resolve().get()).setWiltedID(null);
/* 91 */       return 1;
/*    */     } 
/*    */     
/* 94 */     source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail"));
/* 95 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\commands\AssignedWiltedCommands.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */