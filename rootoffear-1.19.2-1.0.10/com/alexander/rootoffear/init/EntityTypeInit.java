/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.DecoyWilted;
/*    */ import com.alexander.rootoffear.entities.LightExtinguisher;
/*    */ import com.alexander.rootoffear.entities.ShadowWilted;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.entities.WiltedBarrier;
/*    */ import com.alexander.rootoffear.entities.WiltedHands;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.MobCategory;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityTypeInit
/*    */ {
/* 20 */   public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "rootoffear");
/*    */ 
/*    */   
/* 23 */   public static final RegistryObject<EntityType<Wilted>> WILTED = REGISTER.register("wilted", () -> EntityType.Builder.m_20704_(Wilted::new, MobCategory.MISC).m_20699_(1.8F, 3.8F).m_20712_((new ResourceLocation("rootoffear", "wilted")).toString()));
/*    */ 
/*    */   
/* 26 */   public static final RegistryObject<EntityType<ShadowWilted>> SHADOW_WILTED = REGISTER.register("shadow_wilted", () -> EntityType.Builder.m_20704_(ShadowWilted::new, MobCategory.MISC).m_20699_(1.8F, 3.8F).m_20712_((new ResourceLocation("rootoffear", "shadow_wilted")).toString()));
/*    */ 
/*    */   
/* 29 */   public static final RegistryObject<EntityType<DecoyWilted>> DECOY_WILTED = REGISTER.register("decoy_wilted", () -> EntityType.Builder.m_20704_(DecoyWilted::new, MobCategory.MISC).m_20699_(1.8F, 3.8F).m_20712_((new ResourceLocation("rootoffear", "decoy_wilted")).toString()));
/*    */ 
/*    */   
/* 32 */   public static final RegistryObject<EntityType<WiltedHands>> WILTED_HANDS = REGISTER.register("wilted_hands", () -> EntityType.Builder.m_20704_(WiltedHands::new, MobCategory.MISC).m_20699_(1.0F, 2.0F).m_20712_((new ResourceLocation("rootoffear", "wilted_hands")).toString()));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   public static final RegistryObject<EntityType<LightExtinguisher>> LIGHT_EXTINGUISHER = REGISTER.register("light_extinguisher", () -> EntityType.Builder.m_20704_(LightExtinguisher::new, MobCategory.MISC).m_20699_(1.0F, 1.0F).m_20719_().m_20712_((new ResourceLocation("rootoffear", "light_extinguisher")).toString()));
/*    */ 
/*    */   
/* 41 */   public static final RegistryObject<EntityType<WiltedBarrier>> WILTED_BARRIER = REGISTER.register("wilted_barrier", () -> EntityType.Builder.m_20704_(WiltedBarrier::new, MobCategory.MISC).m_20699_(0.6F, 3.0F).m_20712_((new ResourceLocation("rootoffear", "wilted_barrier")).toString()));
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\EntityTypeInit.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */