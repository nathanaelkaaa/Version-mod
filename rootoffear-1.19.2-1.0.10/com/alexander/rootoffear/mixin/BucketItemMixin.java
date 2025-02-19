/*    */ package com.alexander.rootoffear.mixin;
/*    */ 
/*    */ import com.alexander.rootoffear.events.AddCooldownsToPlacedLightSourcesEvent;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import com.llamalad7.mixinextras.sugar.ref.LocalRef;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.BucketItem;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.phys.BlockHitResult;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({BucketItem.class})
/*    */ public abstract class BucketItemMixin
/*    */ {
/*    */   @Inject(at = {@At("RETURN")}, method = {"use"}, cancellable = true)
/*    */   private void rootoffear_addItemCooldownsForPlacedEmissiveFluids(Level p_40703_, Player p_40704_, InteractionHand p_40705_, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> callback, @Local LocalRef<BlockHitResult> blockhitresult) {
/* 26 */     if (((InteractionResultHolder)callback.getReturnValue()).m_19089_() != InteractionResult.PASS && ((InteractionResultHolder)callback.getReturnValue()).m_19089_() != InteractionResult.FAIL)
/* 27 */       AddCooldownsToPlacedLightSourcesEvent.tryAddCooldowns((LevelAccessor)p_40703_, (Entity)p_40704_, ((BlockHitResult)blockhitresult.get()).m_82425_().m_121945_(((BlockHitResult)blockhitresult.get()).m_82434_())); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\BucketItemMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */