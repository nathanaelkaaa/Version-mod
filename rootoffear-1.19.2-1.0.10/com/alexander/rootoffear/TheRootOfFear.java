/*    */ package com.alexander.rootoffear;
/*    */ 
/*    */ import com.alexander.rootoffear.config.RoFClientConfig;
/*    */ import com.alexander.rootoffear.config.RoFCommonConfig;
/*    */ import com.alexander.rootoffear.entities.ShadowWilted;
/*    */ import com.alexander.rootoffear.entities.Wilted;
/*    */ import com.alexander.rootoffear.enums.RoFBedSleepingProblems;
/*    */ import com.alexander.rootoffear.events.CapabilityEvents;
/*    */ import com.alexander.rootoffear.init.EntityTypeInit;
/*    */ import com.alexander.rootoffear.init.ItemInit;
/*    */ import com.alexander.rootoffear.init.ParticleTypeInit;
/*    */ import com.alexander.rootoffear.init.SoundEventInit;
/*    */ import com.alexander.rootoffear.network.Messages;
/*    */ import com.google.common.collect.Lists;
/*    */ import com.mojang.logging.LogUtils;
/*    */ import java.util.List;
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.SpawnPlacements;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.levelgen.Heightmap;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
/*    */ import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
/*    */ import net.minecraftforge.eventbus.api.IEventBus;
/*    */ import net.minecraftforge.fml.ModLoadingContext;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.config.IConfigSpec;
/*    */ import net.minecraftforge.fml.config.ModConfig;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*    */ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*    */ import org.slf4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod("rootoffear")
/*    */ public class TheRootOfFear
/*    */ {
/* 41 */   public static final List<ResourceKey<Level>> WILTED_SPAWNABLE_DIMENSIONS = Lists.newArrayList();
/*    */   
/*    */   public static final String MODID = "rootoffear";
/* 44 */   public static final Logger LOGGER = LogUtils.getLogger();
/*    */ 
/*    */   
/*    */   public TheRootOfFear() {
/* 48 */     IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
/*    */     
/* 50 */     CapabilityEvents.setup();
/*    */     
/* 52 */     SoundEventInit.REGISTER.register(modEventBus);
/* 53 */     ParticleTypeInit.REGISTER.register(modEventBus);
/* 54 */     EntityTypeInit.REGISTER.register(modEventBus);
/* 55 */     ItemInit.REGISTER.register(modEventBus);
/*    */     
/* 57 */     modEventBus.addListener(this::addAttributes);
/* 58 */     modEventBus.addListener(this::commonSetup);
/* 59 */     modEventBus.addListener(this::registerCustomSpawnPlacements);
/*    */     
/* 61 */     RoFBedSleepingProblems.WILTED.T();
/*    */     
/* 63 */     MinecraftForge.EVENT_BUS.register(this);
/*    */     
/* 65 */     ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, (IConfigSpec)RoFCommonConfig.SPEC, "rootoffear/common.toml");
/* 66 */     ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, (IConfigSpec)RoFClientConfig.SPEC, "rootoffear/client.toml");
/*    */   }
/*    */   
/*    */   private void registerCustomSpawnPlacements(SpawnPlacementRegisterEvent event) {
/* 70 */     event.register((EntityType)EntityTypeInit.WILTED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Wilted::checkWiltedSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*    */   }
/*    */   
/*    */   private void addAttributes(EntityAttributeCreationEvent event) {
/* 74 */     event.put((EntityType)EntityTypeInit.WILTED.get(), Wilted.createAttributes().m_22265_());
/* 75 */     event.put((EntityType)EntityTypeInit.SHADOW_WILTED.get(), ShadowWilted.createAttributes().m_22265_());
/*    */   }
/*    */   
/*    */   private void commonSetup(FMLCommonSetupEvent event) {
/* 79 */     Messages.register();
/* 80 */     for (String string : RoFCommonConfig.wilted_spawn_dimensions.get())
/* 81 */       WILTED_SPAWNABLE_DIMENSIONS.add(ResourceKey.m_135785_(Registry.f_122819_, new ResourceLocation(string))); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\TheRootOfFear.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */