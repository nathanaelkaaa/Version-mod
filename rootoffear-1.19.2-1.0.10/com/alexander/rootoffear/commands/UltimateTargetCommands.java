/*     */ package com.alexander.rootoffear.commands;
/*     */ 
/*     */ import com.alexander.rootoffear.entities.Wilted;
/*     */ import com.mojang.brigadier.CommandDispatcher;
/*     */ import com.mojang.brigadier.arguments.ArgumentType;
/*     */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*     */ import com.mojang.brigadier.context.CommandContext;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import net.minecraft.commands.CommandSourceStack;
/*     */ import net.minecraft.commands.Commands;
/*     */ import net.minecraft.commands.arguments.EntityArgument;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UltimateTargetCommands
/*     */ {
/*     */   public static void registerGetUltimateTarget(CommandDispatcher<CommandSourceStack> dispatcher) {
/*  20 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("ultimatetarget")
/*  21 */         .then(Commands.m_82127_("get")
/*  22 */           .then(Commands.m_82129_("wilted", (ArgumentType)EntityArgument.m_91449_())
/*  23 */             .executes(UltimateTargetCommands::getUltimateTarget))));
/*  24 */     dispatcher.register(command);
/*     */   }
/*     */   
/*     */   private static int getUltimateTarget(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/*  28 */     CommandSourceStack source = (CommandSourceStack)context.getSource();
/*  29 */     Entity entity = EntityArgument.m_91452_(context, "wilted");
/*  30 */     if (entity instanceof Wilted) { Wilted wilted = (Wilted)entity;
/*  31 */       if (wilted.getUltimateTarget() == null) {
/*  32 */         source.m_81352_((Component)Component.m_237110_("commands.rootoffear.fail_no_ultimate_target", new Object[] { wilted.m_7755_() }));
/*  33 */         return 0;
/*     */       } 
/*  35 */       source.m_81354_((Component)Component.m_237110_("commands.rootoffear.getultimatetarget.success", new Object[] { wilted.m_7755_(), wilted.getUltimateTarget().m_7755_() }), true);
/*  36 */       return 1; }
/*     */ 
/*     */     
/*  39 */     source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail_not_wilted"));
/*  40 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerSetUltimateTarget(CommandDispatcher<CommandSourceStack> dispatcher) {
/*  48 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("ultimatetarget")
/*  49 */         .then(Commands.m_82127_("set")
/*  50 */           .then(Commands.m_82129_("wilted", (ArgumentType)EntityArgument.m_91460_())
/*  51 */             .then(Commands.m_82129_("target", (ArgumentType)EntityArgument.m_91449_())
/*  52 */               .executes(UltimateTargetCommands::setUltimateTarget)))));
/*  53 */     dispatcher.register(command);
/*     */   }
/*     */   
/*     */   private static int setUltimateTarget(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/*  57 */     CommandSourceStack source = (CommandSourceStack)context.getSource();
/*  58 */     int foundWilted = 0;
/*  59 */     Wilted singleEntity = null;
/*  60 */     Entity target = EntityArgument.m_91452_(context, "target");
/*  61 */     for (Entity entity : EntityArgument.m_91461_(context, "wilted")) {
/*  62 */       if (entity instanceof Wilted) { Wilted wilted = (Wilted)entity;
/*  63 */         foundWilted++;
/*  64 */         singleEntity = wilted;
/*  65 */         wilted.ultimateTargetID = target.m_20148_(); }
/*     */     
/*     */     } 
/*     */     
/*  69 */     if (foundWilted < 1) {
/*  70 */       source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail_not_wilted"));
/*  71 */     } else if (foundWilted == 1) {
/*  72 */       source.m_81354_((Component)Component.m_237110_("commands.rootoffear.setultimatetarget.success", new Object[] { singleEntity.m_7755_(), target.m_7755_() }), true);
/*     */     } else {
/*  74 */       source.m_81354_((Component)Component.m_237110_("commands.rootoffear.setultimatetarget.success_multiple", new Object[] { Integer.valueOf(foundWilted), target.m_7755_() }), true);
/*     */     } 
/*  76 */     return foundWilted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerClearUltimateTarget(CommandDispatcher<CommandSourceStack> dispatcher) {
/*  83 */     LiteralArgumentBuilder<CommandSourceStack> command = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("rootoffear").requires(commandSource -> commandSource.m_6761_(2))).then(Commands.m_82127_("ultimatetarget")
/*  84 */         .then(Commands.m_82127_("clear")
/*  85 */           .then(Commands.m_82129_("wilted", (ArgumentType)EntityArgument.m_91460_())
/*  86 */             .executes(UltimateTargetCommands::clearUltimateTarget))));
/*  87 */     dispatcher.register(command);
/*     */   }
/*     */   
/*     */   private static int clearUltimateTarget(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/*  91 */     CommandSourceStack source = (CommandSourceStack)context.getSource();
/*  92 */     int foundWilted = 0;
/*  93 */     int foundWiltedWithUltimateTarget = 0;
/*  94 */     Wilted singleEntity = null;
/*  95 */     for (Entity entity : EntityArgument.m_91461_(context, "wilted")) {
/*  96 */       if (entity instanceof Wilted) { Wilted wilted = (Wilted)entity;
/*  97 */         foundWilted++;
/*  98 */         singleEntity = wilted;
/*  99 */         if (wilted.getUltimateTarget() != null) {
/* 100 */           foundWiltedWithUltimateTarget++;
/* 101 */           wilted.ultimateTargetID = null;
/*     */         }  }
/*     */     
/*     */     } 
/*     */     
/* 106 */     if (foundWilted < 1) {
/* 107 */       source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail_not_wilted"));
/* 108 */     } else if (foundWiltedWithUltimateTarget < 1) {
/* 109 */       source.m_81352_((Component)Component.m_237115_("commands.rootoffear.fail_no_ultimate_target"));
/* 110 */     } else if (foundWilted == 1) {
/* 111 */       source.m_81354_((Component)Component.m_237110_("commands.rootoffear.clearultimatetarget.success", new Object[] { singleEntity.m_7755_() }), true);
/*     */     } else {
/* 113 */       source.m_81354_((Component)Component.m_237110_("commands.rootoffear.clearultimatetarget.success_multiple", new Object[] { Integer.valueOf(foundWilted) }), true);
/*     */     } 
/* 115 */     return foundWilted;
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\commands\UltimateTargetCommands.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */