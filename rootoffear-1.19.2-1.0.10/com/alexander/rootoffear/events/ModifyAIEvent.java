/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.config.RoFCommonConfig;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.init.TagInit;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.PathfinderMob;
/*    */ import net.minecraft.world.entity.Pose;
/*    */ import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
/*    */ import net.minecraft.world.entity.animal.Wolf;
/*    */ import net.minecraftforge.event.entity.EntityJoinLevelEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "rootoffear")
/*    */ public class ModifyAIEvent
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void makeMobsScaredOfWilted(EntityJoinLevelEvent event) {
/* 24 */     if (!event.getLevel().m_5776_() && ((Boolean)RoFCommonConfig.mobs_run_away_from_wilted.get()).booleanValue()) { Entity entity = event.getEntity(); if (entity instanceof PathfinderMob) { PathfinderMob mob = (PathfinderMob)entity; if ((!((Boolean)RoFCommonConfig.strong_mobs_dont_run_away_from_wilted.get()).booleanValue() || mob.m_21233_() <= 100.0F) && !(mob instanceof Wilted) && !mob.m_6095_().m_204039_(TagInit.EntityTypes.NOT_SCARED_BY_WILTED))
/* 25 */           mob.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal<Wilted>(mob, Wilted.class, 15.0F, 1.0D, 1.25D)
/*    */               {
/*    */                 public boolean m_8036_() {
/*    */                   // Byte code:
/*    */                   //   0: aload_0
/*    */                   //   1: invokespecial m_8036_ : ()Z
/*    */                   //   4: ifeq -> 50
/*    */                   //   7: aload_0
/*    */                   //   8: getfield f_25015_ : Lnet/minecraft/world/entity/PathfinderMob;
/*    */                   //   11: astore_2
/*    */                   //   12: aload_2
/*    */                   //   13: instanceof net/minecraft/world/entity/animal/Wolf
/*    */                   //   16: ifeq -> 46
/*    */                   //   19: aload_2
/*    */                   //   20: checkcast net/minecraft/world/entity/animal/Wolf
/*    */                   //   23: astore_1
/*    */                   //   24: aload_1
/*    */                   //   25: invokevirtual m_21824_ : ()Z
/*    */                   //   28: ifeq -> 46
/*    */                   //   31: getstatic com/alexander/rootoffear/config/RoFCommonConfig.tamed_wolves_attack_wilted : Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
/*    */                   //   34: invokevirtual get : ()Ljava/lang/Object;
/*    */                   //   37: checkcast java/lang/Boolean
/*    */                   //   40: invokevirtual booleanValue : ()Z
/*    */                   //   43: ifne -> 50
/*    */                   //   46: iconst_1
/*    */                   //   47: goto -> 51
/*    */                   //   50: iconst_0
/*    */                   //   51: ireturn
/*    */                   // Line number table:
/*    */                   //   Java source line number -> byte code offset
/*    */                   //   #28	-> 0
/*    */                   // Local variable table:
/*    */                   //   start	length	slot	name	descriptor
/*    */                   //   24	22	1	wolf	Lnet/minecraft/world/entity/animal/Wolf;
/*    */                   //   0	52	0	this	Lcom/alexander/rootoffear/events/ModifyAIEvent$1;
/*    */                 }
/*    */ 
/*    */                 
/*    */                 public void m_8056_() {
/* 33 */                   super.m_8056_();
/* 34 */                   if (this.f_25015_ instanceof net.minecraft.world.entity.npc.Villager) {
/* 35 */                     this.f_25015_.m_20124_(Pose.STANDING);
/*    */                   }
/*    */                 }
/*    */               });  }
/*    */        }
/*    */     
/* 41 */     if (!event.getLevel().m_5776_() && ((Boolean)RoFCommonConfig.tamed_wolves_attack_wilted.get()).booleanValue()) { Entity entity = event.getEntity(); if (entity instanceof Wolf) { Wolf wolf = (Wolf)entity;
/* 42 */         wolf.f_21346_.m_25352_(0, (Goal)new NearestAttackableTargetGoal<Wilted>((Mob)wolf, Wilted.class, false)
/*    */             {
/*    */               public boolean m_8036_() {
/* 45 */                 if (super.m_8036_()) { Mob mob = this.f_26135_; if (mob instanceof Wolf) { Wolf wolf = (Wolf)mob; if (wolf.m_21824_()); }  }  return false;
/*    */               }
/*    */             }); }
/*    */        }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\ModifyAIEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */