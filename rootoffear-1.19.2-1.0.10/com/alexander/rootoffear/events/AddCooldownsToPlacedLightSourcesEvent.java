/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.config.RoFCommonConfig;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.utils.MiscUtils;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraftforge.event.level.BlockEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear")
/*    */ public class AddCooldownsToPlacedLightSourcesEvent
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void addCooldownsToPlacedBlocks(BlockEvent.EntityPlaceEvent event) {
/* 27 */     tryAddCooldowns(event.getLevel(), event.getEntity(), event.getPos());
/*    */   }
/*    */   
/*    */   public static void tryAddCooldowns(LevelAccessor level, Entity entity, BlockPos pos) {
/* 31 */     if (((Boolean)RoFCommonConfig.wilted_adds_cooldowns_to_nearby_light_items.get()).booleanValue() && !level.m_5776_() && entity instanceof Player) { Player player = (Player)entity; if (MiscUtils.inSurvivalMode((LivingEntity)player) && (level.m_7146_(pos) > 0 || level.m_6425_(pos).getFluidType().getLightLevel() > 0)) {
/* 32 */         ServerLevel serverLevel = (ServerLevel)level;
/* 33 */         if (level.m_45976_(Wilted.class, player.m_20191_().m_82400_(30.0D)).size() > 0) {
/* 34 */           serverLevel.m_5594_(null, pos, (SoundEvent)SoundEventInit.WILTED_CURSE_ITEM.get(), SoundSource.HOSTILE, 1.0F, 1.0F);
/* 35 */           for (ItemStack stack : (player.m_150109_()).f_35975_) {
/* 36 */             if (shouldAddCooldown(stack, serverLevel, pos)) {
/* 37 */               player.m_36335_().m_41524_(stack.m_41720_(), 200);
/*    */             }
/*    */           } 
/* 40 */           for (ItemStack stack : (player.m_150109_()).f_35974_) {
/* 41 */             if (shouldAddCooldown(stack, serverLevel, pos)) {
/* 42 */               player.m_36335_().m_41524_(stack.m_41720_(), 200);
/*    */             }
/*    */           } 
/* 45 */           for (ItemStack stack : (player.m_150109_()).f_35976_) {
/* 46 */             if (shouldAddCooldown(stack, serverLevel, pos))
/* 47 */               player.m_36335_().m_41524_(stack.m_41720_(), 200); 
/*    */           } 
/*    */         } 
/*    */       }  }
/*    */   
/*    */   }
/*    */   
/*    */   public static boolean shouldAddCooldown(ItemStack stack, ServerLevel level, BlockPos pos) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual m_41720_ : ()Lnet/minecraft/world/item/Item;
/*    */     //   4: astore #4
/*    */     //   6: aload #4
/*    */     //   8: instanceof net/minecraft/world/item/BlockItem
/*    */     //   11: ifeq -> 39
/*    */     //   14: aload #4
/*    */     //   16: checkcast net/minecraft/world/item/BlockItem
/*    */     //   19: astore_3
/*    */     //   20: aload_3
/*    */     //   21: invokevirtual m_40614_ : ()Lnet/minecraft/world/level/block/Block;
/*    */     //   24: aload_3
/*    */     //   25: invokevirtual m_40614_ : ()Lnet/minecraft/world/level/block/Block;
/*    */     //   28: invokevirtual m_49966_ : ()Lnet/minecraft/world/level/block/state/BlockState;
/*    */     //   31: aload_1
/*    */     //   32: aload_2
/*    */     //   33: invokevirtual getLightEmission : (Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)I
/*    */     //   36: ifgt -> 49
/*    */     //   39: aload_0
/*    */     //   40: getstatic com/alexander/rootoffear/init/TagInit$Items.WILTED_ADDS_COOLDOWN_TO : Lnet/minecraft/tags/TagKey;
/*    */     //   43: invokevirtual m_204117_ : (Lnet/minecraft/tags/TagKey;)Z
/*    */     //   46: ifeq -> 53
/*    */     //   49: iconst_1
/*    */     //   50: goto -> 54
/*    */     //   53: iconst_0
/*    */     //   54: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #55	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   20	19	3	blockItem	Lnet/minecraft/world/item/BlockItem;
/*    */     //   0	55	0	stack	Lnet/minecraft/world/item/ItemStack;
/*    */     //   0	55	1	level	Lnet/minecraft/server/level/ServerLevel;
/*    */     //   0	55	2	pos	Lnet/minecraft/core/BlockPos;
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\AddCooldownsToPlacedLightSourcesEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */