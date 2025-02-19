/*    */ package com.alexander.rootoffear.events;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import net.minecraft.world.entity.PathfinderMob;
/*    */ import net.minecraft.world.entity.Pose;
/*    */ import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends AvoidEntityGoal<Wilted>
/*    */ {
/*    */   null(PathfinderMob p_25027_, Class<Wilted> p_25028_, float p_25029_, double p_25030_, double p_25031_) {
/* 25 */     super(p_25027_, p_25028_, p_25029_, p_25030_, p_25031_);
/*    */   }
/*    */   
/*    */   public boolean m_8036_() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokespecial m_8036_ : ()Z
/*    */     //   4: ifeq -> 50
/*    */     //   7: aload_0
/*    */     //   8: getfield f_25015_ : Lnet/minecraft/world/entity/PathfinderMob;
/*    */     //   11: astore_2
/*    */     //   12: aload_2
/*    */     //   13: instanceof net/minecraft/world/entity/animal/Wolf
/*    */     //   16: ifeq -> 46
/*    */     //   19: aload_2
/*    */     //   20: checkcast net/minecraft/world/entity/animal/Wolf
/*    */     //   23: astore_1
/*    */     //   24: aload_1
/*    */     //   25: invokevirtual m_21824_ : ()Z
/*    */     //   28: ifeq -> 46
/*    */     //   31: getstatic com/alexander/rootoffear/config/RoFCommonConfig.tamed_wolves_attack_wilted : Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
/*    */     //   34: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   37: checkcast java/lang/Boolean
/*    */     //   40: invokevirtual booleanValue : ()Z
/*    */     //   43: ifne -> 50
/*    */     //   46: iconst_1
/*    */     //   47: goto -> 51
/*    */     //   50: iconst_0
/*    */     //   51: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #28	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   24	22	1	wolf	Lnet/minecraft/world/entity/animal/Wolf;
/*    */     //   0	52	0	this	Lcom/alexander/rootoffear/events/ModifyAIEvent$1;
/*    */   }
/*    */   
/*    */   public void m_8056_() {
/* 33 */     super.m_8056_();
/* 34 */     if (this.f_25015_ instanceof net.minecraft.world.entity.npc.Villager)
/* 35 */       this.f_25015_.m_20124_(Pose.STANDING); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\events\ModifyAIEvent$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */