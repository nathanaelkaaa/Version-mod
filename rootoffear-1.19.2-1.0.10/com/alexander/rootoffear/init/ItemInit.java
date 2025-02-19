/*    */ package com.alexander.rootoffear.init;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.world.item.CreativeModeTab;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraftforge.common.ForgeSpawnEggItem;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ public class ItemInit
/*    */ {
/* 14 */   public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, "rootoffear");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 19 */   public static final RegistryObject<Item> WILTED_SPAWN_EGG = REGISTER.register("wilted_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)EntityTypeInit.WILTED, 6181712, 8620160, (new Item.Properties()).m_41491_(CreativeModeTab.f_40753_)));
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\init\ItemInit.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */