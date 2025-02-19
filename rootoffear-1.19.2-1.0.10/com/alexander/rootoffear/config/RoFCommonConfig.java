/*    */ package com.alexander.rootoffear.config;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.List;
/*    */ import net.minecraftforge.common.ForgeConfigSpec;
/*    */ 
/*    */ 
/*    */ public final class RoFCommonConfig
/*    */ {
/* 10 */   private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
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
/*    */   public static final ForgeConfigSpec SPEC;
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
/* 40 */   public static ForgeConfigSpec.ConfigValue<Boolean> mobs_run_away_from_wilted = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Mobs Run Away From Wilted (default: true)"), true);
/*    */   
/* 42 */   public static ForgeConfigSpec.ConfigValue<Boolean> strong_mobs_dont_run_away_from_wilted = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Strong Mobs Don't Run Away From Wilted (default: true)"), true);
/*    */   
/* 44 */   public static ForgeConfigSpec.ConfigValue<Boolean> wilted_adds_cooldowns_to_nearby_light_items = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Wilted Adds Cooldowns To Nearby Light Items (default: true)"), true);
/*    */   
/* 46 */   public static ForgeConfigSpec.ConfigValue<Boolean> wilted_disables_nearby_dynamic_lights = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Wilted Disables Nearby Dynamic Lights (default: true)"), true);
/*    */   public static ForgeConfigSpec.ConfigValue<Boolean> wilted_prevents_portal_travel;
/* 48 */   public static ForgeConfigSpec.ConfigValue<Boolean> tamed_wolves_attack_wilted = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Tamed Wolves Attack Wilted (default: true)"), true);
/*    */   static {
/* 50 */     wilted_prevents_portal_travel = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Wilted Prevents Portal Travel (default: true)"), true);
/*    */     
/* 52 */     wilted_immune_to_damage = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Wilted Immune To Damage (default: true)"), true);
/*    */     
/* 54 */     wilted_first_spawn_day = BUILDER.define(List.of("Wilted First Spawn Day (default: 1)"), Integer.valueOf(1));
/*    */     
/* 56 */     min_wilted_spawn_cooldown = BUILDER.define(List.of("Minimum Wilted Spawn Cooldown (in days, default: false)"), Integer.valueOf(2));
/*    */     
/* 58 */     max_wilted_spawn_cooldown = BUILDER.define(List.of("Maximum Wilted Spawn Cooldown (in days, default: false)"), Integer.valueOf(10));
/*    */     
/* 60 */     wilted_bonus_behaviour_amount = BUILDER.define(List.of("Wilted Bonus Behaviour Amount (default: 3)"), Integer.valueOf(3));
/*    */     
/* 62 */     wilted_spawn_dimensions = BUILDER.defineList(List.of("Wilted Spawn Dimensions (default: \"minecraft:overworld\")"), Lists.newArrayList((Object[])new String[] { "minecraft:overworld" }, ), element -> element instanceof String);
/*    */     
/* 64 */     wilted_warning_sounds = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.define(List.of("Wilted Warning Sounds (default: true)"), true);
/*    */     
/* 66 */     SPEC = BUILDER.build();
/*    */   }
/*    */   
/*    */   public static ForgeConfigSpec.ConfigValue<Boolean> wilted_immune_to_damage;
/*    */   public static ForgeConfigSpec.ConfigValue<Integer> wilted_first_spawn_day;
/*    */   public static ForgeConfigSpec.ConfigValue<Integer> min_wilted_spawn_cooldown;
/*    */   public static ForgeConfigSpec.ConfigValue<Integer> max_wilted_spawn_cooldown;
/*    */   public static ForgeConfigSpec.ConfigValue<Integer> wilted_bonus_behaviour_amount;
/*    */   public static final ForgeConfigSpec.ConfigValue<List<? extends String>> wilted_spawn_dimensions;
/*    */   public static ForgeConfigSpec.ConfigValue<Boolean> wilted_warning_sounds;
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\config\RoFCommonConfig.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */