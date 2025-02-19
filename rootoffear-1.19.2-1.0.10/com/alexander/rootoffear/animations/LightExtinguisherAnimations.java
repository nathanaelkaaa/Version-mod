/*    */ package com.alexander.rootoffear.animations;
/*    */ 
/*    */ import net.minecraft.client.animation.AnimationChannel;
/*    */ import net.minecraft.client.animation.AnimationDefinition;
/*    */ import net.minecraft.client.animation.Keyframe;
/*    */ import net.minecraft.client.animation.KeyframeAnimations;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LightExtinguisherAnimations
/*    */ {
/* 16 */   public static final AnimationDefinition extinguish = AnimationDefinition.Builder.m_232275_(1.25F)
/* 17 */     .m_232279_("main", new AnimationChannel(AnimationChannel.Targets.f_232250_, new Keyframe[] {
/* 18 */           new Keyframe(0.0F, KeyframeAnimations.m_232302_(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.25F, 
/* 19 */             KeyframeAnimations.m_232302_(0.0F, -13.75F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.375F, 
/* 20 */             KeyframeAnimations.m_232302_(0.0F, -13.66F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.6667F, 
/* 21 */             KeyframeAnimations.m_232302_(0.0F, -6.8F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.8333F, 
/* 22 */             KeyframeAnimations.m_232302_(0.0F, -5.94F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.0F, 
/* 23 */             KeyframeAnimations.m_232302_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_)
/*    */         
/* 25 */         })).m_232279_("lid1", new AnimationChannel(AnimationChannel.Targets.f_232251_, new Keyframe[] {
/* 26 */           new Keyframe(0.0F, KeyframeAnimations.m_232331_(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.125F, 
/* 27 */             KeyframeAnimations.m_232331_(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.2083F, 
/* 28 */             KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.25F, 
/* 29 */             KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_)
/*    */         
/* 31 */         })).m_232279_("lid2", new AnimationChannel(AnimationChannel.Targets.f_232251_, new Keyframe[] {
/* 32 */           new Keyframe(0.0F, KeyframeAnimations.m_232331_(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.0417F, 
/* 33 */             KeyframeAnimations.m_232331_(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.125F, 
/* 34 */             KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.1667F, 
/* 35 */             KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_)
/*    */         
/* 37 */         })).m_232279_("lid3", new AnimationChannel(AnimationChannel.Targets.f_232251_, new Keyframe[] {
/* 38 */           new Keyframe(0.0F, KeyframeAnimations.m_232331_(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.0417F, 
/* 39 */             KeyframeAnimations.m_232331_(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.125F, 
/* 40 */             KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.1667F, 
/* 41 */             KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_)
/*    */         
/* 43 */         })).m_232279_("lid4", new AnimationChannel(AnimationChannel.Targets.f_232251_, new Keyframe[] {
/* 44 */           new Keyframe(0.0F, KeyframeAnimations.m_232331_(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.0833F, 
/* 45 */             KeyframeAnimations.m_232331_(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.1667F, 
/* 46 */             KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(1.2083F, 
/* 47 */             KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_)
/*    */         
/* 49 */         })).m_232279_("everything", new AnimationChannel(AnimationChannel.Targets.f_232252_, new Keyframe[] {
/* 50 */           new Keyframe(0.0F, KeyframeAnimations.m_232298_(0.0D, 1.0D, 0.0D), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.0417F, 
/* 51 */             KeyframeAnimations.m_232298_(1.0D, 1.0D, 1.0D), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.0833F, 
/* 52 */             KeyframeAnimations.m_232298_(1.0D, 1.0D, 1.0D), AnimationChannel.Interpolations.f_232230_)
/*    */         
/* 54 */         })).m_232282_();
/*    */   
/* 56 */   public static final AnimationDefinition hurt = AnimationDefinition.Builder.m_232275_(0.25F)
/* 57 */     .m_232279_("main", new AnimationChannel(AnimationChannel.Targets.f_232251_, new Keyframe[] {
/* 58 */           new Keyframe(0.0F, KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.0417F, 
/* 59 */             KeyframeAnimations.m_232331_(2.5024F, 2.4976F, 0.1091F), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.125F, 
/* 60 */             KeyframeAnimations.m_232331_(-2.3886F, 2.6066F, 2.6102F), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.2083F, 
/* 61 */             KeyframeAnimations.m_232331_(-2.6087F, -2.603F, -2.1625F), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.25F, 
/* 62 */             KeyframeAnimations.m_232331_(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.f_232230_)
/*    */         
/* 64 */         })).m_232279_("main", new AnimationChannel(AnimationChannel.Targets.f_232252_, new Keyframe[] {
/* 65 */           new Keyframe(0.0F, KeyframeAnimations.m_232298_(1.0D, 1.0D, 1.0D), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.0417F, 
/* 66 */             KeyframeAnimations.m_232298_(1.100000023841858D, 1.100000023841858D, 1.100000023841858D), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.2083F, 
/* 67 */             KeyframeAnimations.m_232298_(1.100000023841858D, 1.100000023841858D, 1.100000023841858D), AnimationChannel.Interpolations.f_232230_), new Keyframe(0.25F, 
/* 68 */             KeyframeAnimations.m_232298_(1.0D, 1.0D, 1.0D), AnimationChannel.Interpolations.f_232230_)
/*    */         
/* 70 */         })).m_232282_();
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\animations\LightExtinguisherAnimations.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */