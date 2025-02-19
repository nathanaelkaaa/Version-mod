/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SoundEventInit
/*    */ {
/* 13 */   public static final DeferredRegister<SoundEvent> REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "rootoffear");
/*    */ 
/*    */ 
/*    */   
/* 17 */   public static final RegistryObject<SoundEvent> MUSIC_WILTED = REGISTER.register("music.wilted", () -> new SoundEvent(new ResourceLocation("rootoffear", "music.wilted")));
/*    */ 
/*    */   
/* 20 */   public static final RegistryObject<SoundEvent> WILTED_IDLE = REGISTER.register("entity.wilted.idle", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.idle")));
/* 21 */   public static final RegistryObject<SoundEvent> WILTED_HURT = REGISTER.register("entity.wilted.hurt", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.hurt")));
/* 22 */   public static final RegistryObject<SoundEvent> WILTED_STEP = REGISTER.register("entity.wilted.step", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.step")));
/* 23 */   public static final RegistryObject<SoundEvent> WILTED_ATTACK = REGISTER.register("entity.wilted.attack", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.attack")));
/* 24 */   public static final RegistryObject<SoundEvent> WILTED_LEAF_STORM = REGISTER.register("entity.wilted.leaf_storm", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.leaf_storm")));
/* 25 */   public static final RegistryObject<SoundEvent> WILTED_SWAY = REGISTER.register("entity.wilted.sway", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.sway")));
/* 26 */   public static final RegistryObject<SoundEvent> WILTED_EXTINGUISH = REGISTER.register("entity.wilted.extinguish", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.extinguish")));
/* 27 */   public static final RegistryObject<SoundEvent> WILTED_LEAP = REGISTER.register("entity.wilted.leap", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.leap")));
/* 28 */   public static final RegistryObject<SoundEvent> WILTED_LAND = REGISTER.register("entity.wilted.land", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.land")));
/* 29 */   public static final RegistryObject<SoundEvent> WILTED_DIG_OUT = REGISTER.register("entity.wilted.dig_out", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.dig_out")));
/* 30 */   public static final RegistryObject<SoundEvent> WILTED_DIG_IN = REGISTER.register("entity.wilted.dig_in", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.dig_in")));
/* 31 */   public static final RegistryObject<SoundEvent> WILTED_GROUND_GRAB = REGISTER.register("entity.wilted.ground_grab", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.ground_grab")));
/* 32 */   public static final RegistryObject<SoundEvent> WILTED_CURSE_ITEM = REGISTER.register("entity.wilted.curse_item", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.curse_item")));
/* 33 */   public static final RegistryObject<SoundEvent> WILTED_DEATH = REGISTER.register("entity.wilted.death", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.death")));
/* 34 */   public static final RegistryObject<SoundEvent> WILTED_PULSE = REGISTER.register("entity.wilted.pulse", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.pulse")));
/* 35 */   public static final RegistryObject<SoundEvent> WILTED_REVEAL = REGISTER.register("entity.wilted.reveal", () -> new SoundEvent(new ResourceLocation("rootoffear", "entity.wilted.reveal")));
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\SoundEventInit.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */