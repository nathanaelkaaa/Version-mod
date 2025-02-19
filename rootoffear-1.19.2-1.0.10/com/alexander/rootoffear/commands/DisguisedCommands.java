/*    */ package com.alexander.rootoffear.commands;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.mojang.brigadier.CommandDispatcher;
/*    */ import com.mojang.brigadier.arguments.ArgumentType;
/*    */ import com.mojang.brigadier.arguments.BoolArgumentType;
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
/*    */ 
/*    */ public class DisguisedCommands
/*    */ {
/*    */   public static void registerSetDisguised(CommandDispatcher<CommandSourceStack> dispatcher) {
/* 22 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("setdisguised")
/* 23 */         .then(Commands.m_82129_("wilted", (ArgumentType)EntityArgument.m_91460_())
/* 24 */           .then(Commands.m_82129_("disguised", (ArgumentType)BoolArgumentType.bool())
/* 25 */             .executes(DisguisedCommands::setDisguised))));
/* 26 */     dispatcher.register(command);
/*    */   }
/*    */   
/*    */   private static int setDisguised(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/* 30 */     CommandSourceStack source = (CommandSourceStack)context.getSource();
/* 31 */     int foundWilted = 0;
/* 32 */     Wilted singleEntity = null;
/* 33 */     boolean disguised = BoolArgumentType.getBool(context, "disguised");
/* 34 */     for (Entity entity : EntityArgument.m_91461_(context, "wilted")) {
/* 35 */       if (entity instanceof Wilted) { Wilted wilted = (Wilted)entity;
/* 36 */         foundWilted++;
/* 37 */         singleEntity = wilted;
/* 38 */         if (disguised) {
/* 39 */           source.m_81372_().m_7605_((Entity)wilted, (byte)13);
/* 40 */           wilted.wantsToReveal = false;
/* 41 */           wilted.setDisguised(true); continue;
/*    */         } 
/* 43 */         wilted.wantsToReveal = true; }
/*    */     
/*    */     } 
/*    */ 
/*    */     
/* 48 */     if (foundWilted < 1) {
/* 49 */       source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail_not_wilted"));
/* 50 */     } else if (foundWilted == 1) {
/* 51 */       source.m_81354_((Component)Component.m_237110_(disguised ? "commands.rootoffear.setdisguisedtrue.success" : "commands.rootoffear.setdisguisedfalse.success", new Object[] { singleEntity.m_7755_() }), true);
/*    */     } else {
/* 53 */       source.m_81354_((Component)Component.m_237110_(disguised ? "commands.rootoffear.setdisguisedtrue.success_multiple" : "commands.rootoffear.setdisguisedfalse.success_multiple", new Object[] { Integer.valueOf(foundWilted) }), true);
/*    */     } 
/* 55 */     return foundWilted;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\commands\DisguisedCommands.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */