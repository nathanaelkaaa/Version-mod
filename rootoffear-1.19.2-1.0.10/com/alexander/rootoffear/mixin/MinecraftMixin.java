/*    */ package com.alexander.rootoffear.mixin;
/*    */ 
/*    */ import com.alexander.rootoffear.events.HandleClientEffectsEvent;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.client.player.LocalPlayer;
/*    */ import net.minecraft.sounds.Music;
/*    */ import net.minecraft.sounds.Musics;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({Minecraft.class})
/*    */ public abstract class MinecraftMixin
/*    */ {
/*    */   @Shadow
/*    */   @Nullable
/*    */   public LocalPlayer f_91074_;
/*    */   @Shadow
/*    */   @Nullable
/*    */   public Screen f_91080_;
/*    */   
/*    */   @Inject(at = {@At("HEAD")}, method = {"getSituationalMusic"}, cancellable = true)
/*    */   private void rootoffear_changeMusicWhenWiltedIsActive(CallbackInfoReturnable<Music> callback) {
/* 33 */     if (HandleClientEffectsEvent.changeMusic && !(this.f_91080_ instanceof net.minecraft.client.gui.screens.WinScreen) && this.f_91074_ != null)
/* 34 */       callback.setReturnValue(Musics.f_11648_); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\MinecraftMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */