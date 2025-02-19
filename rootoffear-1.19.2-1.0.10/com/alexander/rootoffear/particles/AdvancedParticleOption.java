/*     */ package com.alexander.rootoffear.particles;
/*     */ 
/*     */ import com.mojang.brigadier.StringReader;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import com.mojang.datafixers.kinds.App;
/*     */ import com.mojang.datafixers.kinds.Applicative;
/*     */ import com.mojang.datafixers.util.Function11;
/*     */ import com.mojang.serialization.Codec;
/*     */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleType;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import net.minecraftforge.registries.RegistryObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AdvancedParticleOption
/*     */   implements ParticleOptions
/*     */ {
/*     */   private final String particleType;
/*     */   public final double v0;
/*     */   public final double v1;
/*     */   public final double v2;
/*     */   public final double v3;
/*     */   public final double v4;
/*     */   
/*     */   static {
/*  32 */     CODEC = RecordCodecBuilder.create(codecBuilder -> codecBuilder.group((App)Codec.STRING.fieldOf("particleType").forGetter(()), (App)Codec.DOUBLE.fieldOf("value1").forGetter(()), (App)Codec.DOUBLE.fieldOf("value2").forGetter(()), (App)Codec.DOUBLE.fieldOf("value3").forGetter(()), (App)Codec.DOUBLE.fieldOf("value4").forGetter(()), (App)Codec.DOUBLE.fieldOf("value5").forGetter(()), (App)Codec.DOUBLE.fieldOf("value6").forGetter(()), (App)Codec.DOUBLE.fieldOf("value7").forGetter(()), (App)Codec.DOUBLE.fieldOf("value8").forGetter(()), (App)Codec.DOUBLE.fieldOf("value9").forGetter(()), (App)Codec.DOUBLE.fieldOf("value10").forGetter(())).apply((Applicative)codecBuilder, AdvancedParticleOption::new));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double v5;
/*     */ 
/*     */ 
/*     */   
/*     */   public final double v6;
/*     */ 
/*     */   
/*     */   public final double v7;
/*     */ 
/*     */   
/*     */   public final double v8;
/*     */ 
/*     */   
/*     */   public final double v9;
/*     */ 
/*     */   
/*     */   public static final Codec<AdvancedParticleOption> CODEC;
/*     */ 
/*     */ 
/*     */   
/*  58 */   public static final ParticleOptions.Deserializer<AdvancedParticleOption> DESERIALIZER = new ParticleOptions.Deserializer<AdvancedParticleOption>() {
/*     */       public AdvancedParticleOption fromCommand(ParticleType<AdvancedParticleOption> type, StringReader reader) throws CommandSyntaxException {
/*  60 */         reader.expect(' ');
/*  61 */         return new AdvancedParticleOption(reader.readString(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble());
/*     */       }
/*     */       
/*     */       public AdvancedParticleOption fromNetwork(ParticleType<AdvancedParticleOption> type, FriendlyByteBuf buf) {
/*  65 */         return new AdvancedParticleOption(buf.m_130277_(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble());
/*     */       }
/*     */     };
/*     */   
/*     */   public AdvancedParticleOption(String particleType, double v0, double v1, double v2, double v3, double v4, double v5, double v6, double v7, double v8, double v9) {
/*  70 */     this.particleType = particleType;
/*  71 */     this.v0 = v0;
/*  72 */     this.v1 = v1;
/*  73 */     this.v2 = v2;
/*  74 */     this.v3 = v3;
/*  75 */     this.v4 = v4;
/*  76 */     this.v5 = v5;
/*  77 */     this.v6 = v6;
/*  78 */     this.v7 = v7;
/*  79 */     this.v8 = v8;
/*  80 */     this.v9 = v9;
/*     */   }
/*     */   
/*     */   public AdvancedParticleOption(RegistryObject<? extends ParticleType> particleType, List<Double> values) {
/*  84 */     this(particleType.getId().toString(), 
/*  85 */         (values.size() >= 1) ? ((Double)values.get(0)).doubleValue() : 0.0D, 
/*  86 */         (values.size() >= 2) ? ((Double)values.get(1)).doubleValue() : 0.0D, 
/*  87 */         (values.size() >= 3) ? ((Double)values.get(2)).doubleValue() : 0.0D, 
/*  88 */         (values.size() >= 4) ? ((Double)values.get(3)).doubleValue() : 0.0D, 
/*  89 */         (values.size() >= 5) ? ((Double)values.get(4)).doubleValue() : 0.0D, 
/*  90 */         (values.size() >= 6) ? ((Double)values.get(5)).doubleValue() : 0.0D, 
/*  91 */         (values.size() >= 7) ? ((Double)values.get(6)).doubleValue() : 0.0D, 
/*  92 */         (values.size() >= 8) ? ((Double)values.get(7)).doubleValue() : 0.0D, 
/*  93 */         (values.size() >= 9) ? ((Double)values.get(8)).doubleValue() : 0.0D, 
/*  94 */         (values.size() >= 10) ? ((Double)values.get(9)).doubleValue() : 0.0D);
/*     */   }
/*     */   
/*     */   public void m_7711_(FriendlyByteBuf buf) {
/*  98 */     buf.m_130070_(this.particleType);
/*  99 */     buf.writeDouble(this.v0);
/* 100 */     buf.writeDouble(this.v1);
/* 101 */     buf.writeDouble(this.v2);
/* 102 */     buf.writeDouble(this.v3);
/* 103 */     buf.writeDouble(this.v4);
/* 104 */     buf.writeDouble(this.v5);
/* 105 */     buf.writeDouble(this.v6);
/* 106 */     buf.writeDouble(this.v7);
/* 107 */     buf.writeDouble(this.v8);
/* 108 */     buf.writeDouble(this.v9);
/*     */   }
/*     */   
/*     */   public String m_5942_() {
/* 112 */     return String.format(Locale.ROOT, "%s %s %s %s %s %s %s %s %s %s %s", new Object[] { ForgeRegistries.PARTICLE_TYPES.getKey(m_6012_()), Double.valueOf(this.v0), Double.valueOf(this.v1), Double.valueOf(this.v2), Double.valueOf(this.v3), Double.valueOf(this.v4), Double.valueOf(this.v5), Double.valueOf(this.v6), Double.valueOf(this.v7), Double.valueOf(this.v8), Double.valueOf(this.v9) });
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleType<AdvancedParticleOption> m_6012_() {
/* 117 */     return (ParticleType<AdvancedParticleOption>)ForgeRegistries.PARTICLE_TYPES.getValue(new ResourceLocation(this.particleType));
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\particles\AdvancedParticleOption.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */