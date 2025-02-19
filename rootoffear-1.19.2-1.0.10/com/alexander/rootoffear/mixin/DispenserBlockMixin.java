/*    */ package com.alexander.rootoffear.mixin;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.LightExtinguisher;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Direction;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.level.block.DispenserBlock;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ @Mixin({DispenserBlock.class})
/*    */ public abstract class DispenserBlockMixin
/*    */ {
/*    */   @Inject(at = {@At("HEAD")}, method = {"dispenseFrom"}, cancellable = true)
/*    */   private void rootoffear_preventDispensingLightSources(ServerLevel level, BlockPos pos, CallbackInfo callback) {
/* 21 */     BlockPos facingPos = pos.m_121945_((Direction)level.m_8055_(pos).m_61143_((Property)DispenserBlock.f_52659_));
/* 22 */     if (level.m_45976_(LightExtinguisher.class, new AABB(facingPos.m_123341_(), facingPos.m_123342_(), facingPos.m_123343_(), (facingPos.m_123341_() + 1), (facingPos.m_123342_() + 1), (facingPos.m_123343_() + 1))).size() > 0)
/* 23 */       callback.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\DispenserBlockMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */