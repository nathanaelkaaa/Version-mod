/*    */ package com.alexander.rootoffear.entities;
/*    */ import com.alexander.rootoffear.ai.goals.AdvancedNearestAttackableTargetGoal;
/*    */ import com.alexander.rootoffear.ai.goals.ApproachTargetGoal;
/*    */ import com.alexander.rootoffear.ai.goals.LookAtTargetGoal;
/*    */ import net.minecraft.world.entity.AnimationState;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.PathfinderMob;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*    */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
/*    */ import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
/*    */ import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
/*    */ import net.minecraft.world.entity.monster.Monster;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.common.ForgeMod;
/*    */ 
/*    */ public class DemolisherWilted extends Monster {
/* 23 */   public AnimationState shakingAnimationState = new AnimationState();
/* 24 */   public AnimationState idleAnimationState = new AnimationState();
/* 25 */   public AnimationState spawnAnimationState = new AnimationState();
/* 26 */   public AnimationState attackAnimationState = new AnimationState();
/*    */   
/*    */   public DemolisherWilted(EntityType<? extends DemolisherWilted> type, Level level) {
/* 29 */     super(type, level);
/*    */   }
/*    */   
/*    */   protected void m_8099_() {
/* 33 */     int p = 0;
/* 34 */     this.f_21345_.m_25352_(p++, (Goal)new LookAtTargetGoal((Mob)this));
/* 35 */     this.f_21345_.m_25352_(p++, (Goal)new ApproachTargetGoal((PathfinderMob)this, 0.0D, 1.0D, true));
/* 36 */     this.f_21345_.m_25352_(p++, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0D));
/* 37 */     this.f_21345_.m_25352_(p++, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0F));
/* 38 */     this.f_21345_.m_25352_(p++, (Goal)new RandomLookAroundGoal((Mob)this));
/* 39 */     this.f_21346_.m_25352_(0, (Goal)new AdvancedNearestAttackableTargetGoal((Mob)this, Player.class, false, false, true, true, null));
/*    */   }
/*    */   
/*    */   public boolean isLookingAtMe(Player player) {
/* 43 */     return isLookingAt(player, m_20185_(), m_20188_(), m_20189_());
/*    */   }
/*    */   
/*    */   public static boolean isLookingAt(Player player, double x, double y, double z) {
/* 47 */     Vec3 vec3 = player.m_20252_(1.0F).m_82541_();
/* 48 */     Vec3 vec31 = new Vec3(x - player.m_20185_(), y - player.m_20188_(), z - player.m_20189_());
/* 49 */     vec31 = vec31.m_82541_();
/* 50 */     double d1 = vec3.m_82526_(vec31);
/* 51 */     return (d1 > 0.5D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void m_6043_() {}
/*    */ 
/*    */   
/*    */   public void m_7601_(BlockState p_20006_, Vec3 p_20007_) {}
/*    */ 
/*    */   
/*    */   public static AttributeSupplier.Builder createAttributes() {
/* 63 */     return Monster.m_33035_().m_22268_(Attributes.f_22276_, 30.0D).m_22268_(Attributes.f_22279_, 0.2D).m_22268_(Attributes.f_22277_, 20.0D).m_22268_((Attribute)ForgeMod.STEP_HEIGHT_ADDITION.get(), 2.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6075_() {
/* 68 */     super.m_6075_();
/*    */     
/* 70 */     if (this.f_19853_.m_5776_()) {
/* 71 */       this.idleAnimationState.m_216982_(this.f_19797_);
/* 72 */       this.shakingAnimationState.m_216982_(this.f_19797_);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\entities\DemolisherWilted.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */