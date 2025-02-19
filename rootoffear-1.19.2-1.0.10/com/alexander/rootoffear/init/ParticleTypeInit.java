/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import com.alexander.rootoffear.particles.AdvancedParticleOption;
/*    */ import com.mojang.serialization.Codec;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.ParticleType;
/*    */ import net.minecraft.core.particles.SimpleParticleType;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParticleTypeInit
/*    */ {
/* 17 */   public static final DeferredRegister<ParticleType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "rootoffear");
/*    */   
/* 19 */   public static final RegistryObject<SimpleParticleType> WILTED_WALL = REGISTER.register("wilted_wall", () -> new SimpleParticleType(false));
/* 20 */   public static final RegistryObject<ParticleType<AdvancedParticleOption>> BLOCK_BREAKING = registerAdvancedParticle("block_breaking", false);
/* 21 */   public static final RegistryObject<SimpleParticleType> WILTED_BREAK = REGISTER.register("wilted_break", () -> new SimpleParticleType(false));
/* 22 */   public static final RegistryObject<ParticleType<AdvancedParticleOption>> WILTED_LEAF = registerAdvancedParticle("wilted_leaf", false);
/* 23 */   public static final RegistryObject<ParticleType<AdvancedParticleOption>> LEAF_STORM = registerAdvancedParticle("leaf_storm", false);
/* 24 */   public static final RegistryObject<SimpleParticleType> WILTED_GLOW = REGISTER.register("wilted_glow", () -> new SimpleParticleType(false));
/*    */   
/*    */   private static RegistryObject<ParticleType<AdvancedParticleOption>> registerAdvancedParticle(String name, boolean overrideLimiter) {
/* 27 */     final Function<ParticleType<AdvancedParticleOption>, Codec<AdvancedParticleOption>> func = p_123819_ -> AdvancedParticleOption.CODEC;
/*    */ 
/*    */     
/* 30 */     return REGISTER.register(name, () -> new ParticleType<AdvancedParticleOption>(overrideLimiter, AdvancedParticleOption.DESERIALIZER)
/*    */         {
/*    */           public Codec<AdvancedParticleOption> m_7652_() {
/* 33 */             return func.apply(this);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\ParticleTypeInit.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */