/*     */ package com.alexander.rootoffear.models.entities;
/*     */ 
/*     */ import com.alexander.rootoffear.animations.WiltedHandsAnimations;
/*     */ import com.alexander.rootoffear.entities.WiltedHands;
/*     */ import net.minecraft.client.model.HierarchicalModel;
/*     */ import net.minecraft.client.model.geom.ModelLayerLocation;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ import net.minecraft.client.model.geom.PartPose;
/*     */ import net.minecraft.client.model.geom.builders.CubeDeformation;
/*     */ import net.minecraft.client.model.geom.builders.CubeListBuilder;
/*     */ import net.minecraft.client.model.geom.builders.LayerDefinition;
/*     */ import net.minecraft.client.model.geom.builders.MeshDefinition;
/*     */ import net.minecraft.client.model.geom.builders.PartDefinition;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ 
/*     */ public class WiltedHandsModel<T extends WiltedHands>
/*     */   extends HierarchicalModel<T>
/*     */ {
/*  20 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("rootoffear", "wilted_hands"), "main");
/*     */   private final ModelPart root;
/*     */   private final ModelPart everything;
/*     */   private final ModelPart leftArmLower;
/*     */   private final ModelPart leftHand;
/*     */   private final ModelPart rightArmLower;
/*     */   private final ModelPart rightHand;
/*     */   
/*     */   public WiltedHandsModel(ModelPart root) {
/*  29 */     this.root = root;
/*  30 */     this.everything = root.m_171324_("everything");
/*  31 */     this.leftArmLower = this.everything.m_171324_("leftArmLower");
/*  32 */     this.leftHand = this.leftArmLower.m_171324_("leftHand");
/*  33 */     this.rightArmLower = this.everything.m_171324_("rightArmLower");
/*  34 */     this.rightHand = this.rightArmLower.m_171324_("rightHand");
/*     */   }
/*     */   
/*     */   public static LayerDefinition createBodyLayer() {
/*  38 */     MeshDefinition meshdefinition = new MeshDefinition();
/*  39 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*     */     
/*  41 */     PartDefinition everything = partdefinition.m_171599_("everything", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
/*     */     
/*  43 */     PartDefinition leftArmLower = everything.m_171599_("leftArmLower", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, 2.0F, -2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(10.0F, -2.0F, -4.0F, 3.1416F, 0.0F, 0.0F));
/*     */     
/*  45 */     PartDefinition leaf_r1 = leftArmLower.m_171599_("leaf_r1", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.6F, 1.5F, 1.1F, 2.9457F, 0.0957F, -0.3424F));
/*     */     
/*  47 */     PartDefinition arm_r1 = leftArmLower.m_171599_("arm_r1", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171480_().m_171488_(-2.0F, -6.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/*  49 */     PartDefinition leaf_r2 = leftArmLower.m_171599_("leaf_r2", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(9.0F, -1.3F, -5.2F, 1.0983F, -0.8697F, -1.2248F));
/*     */     
/*  51 */     PartDefinition leaf_r3 = leftArmLower.m_171599_("leaf_r3", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(9.0F, -1.0F, -4.2F, -1.492F, -0.8086F, 1.5235F));
/*     */     
/*  53 */     PartDefinition arm_r2 = leftArmLower.m_171599_("arm_r2", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171480_().m_171488_(-3.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(9.0F, 0.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/*  55 */     PartDefinition arm_r3 = leftArmLower.m_171599_("arm_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.0F, -1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-8.0F, 12.0F, -1.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/*  57 */     PartDefinition arm_r4 = leftArmLower.m_171599_("arm_r4", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, 12.0F, -1.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/*  59 */     PartDefinition leaf_r4 = leftArmLower.m_171599_("leaf_r4", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.6F, 18.2F, 1.1F, 2.897F, 0.2806F, 2.9989F));
/*     */     
/*  61 */     PartDefinition arm_r5 = leftArmLower.m_171599_("arm_r5", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 20.0F, -1.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/*  63 */     PartDefinition leaf_r5 = leftArmLower.m_171599_("leaf_r5", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4F, 14.2F, 0.1F, 3.0112F, -0.8175F, 0.6662F));
/*     */     
/*  65 */     PartDefinition leftHand = leftArmLower.m_171599_("leftHand", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 20.0F, 0.0F, 0.0F, 1.5708F, -1.5708F));
/*     */     
/*  67 */     PartDefinition arm_r6 = leftHand.m_171599_("arm_r6", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, -9.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/*  69 */     PartDefinition leaf_r6 = leftHand.m_171599_("leaf_r6", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.8F, -1.5F, -8.0F, -0.5092F, -1.2851F, 0.5095F));
/*     */     
/*  71 */     PartDefinition arm_r7 = leftHand.m_171599_("arm_r7", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-3.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
/*  72 */         .m_171514_(112, 0).m_171488_(-11.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(9.0F, 0.0F, -12.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/*  74 */     PartDefinition arm_r8 = leftHand.m_171599_("arm_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F))
/*  75 */         .m_171514_(0, 0).m_171488_(5.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(1.0F, 0.0F, -16.5F, 1.5708F, 0.0F, 0.0F));
/*     */     
/*  77 */     PartDefinition rightArmLower = everything.m_171599_("rightArmLower", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 32.0F, 4.0F, new CubeDeformation(0.0F))
/*  78 */         .m_171514_(112, 0).m_171480_().m_171488_(10.0F, 14.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-10.0F, -2.0F, -6.0F, 0.0F, -1.5708F, 3.1416F));
/*     */     
/*  80 */     PartDefinition leaf_r7 = rightArmLower.m_171599_("leaf_r7", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.9F, 10.5F, -1.0F, -0.037F, 0.0791F, -0.176F));
/*     */     
/*  82 */     PartDefinition leaf_r8 = rightArmLower.m_171599_("leaf_r8", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(8.5F, 13.7F, -1.0F, -0.2182F, 0.0F, -2.9234F));
/*     */     
/*  84 */     PartDefinition leaf_r9 = rightArmLower.m_171599_("leaf_r9", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.5F, 15.7F, -1.0F, 3.0124F, -0.0659F, -0.691F));
/*     */     
/*  86 */     PartDefinition leaf_r10 = rightArmLower.m_171599_("leaf_r10", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(12.3F, 15.5F, 1.0F, 0.2984F, 0.6098F, -3.1078F));
/*     */     
/*  88 */     PartDefinition leaf_r11 = rightArmLower.m_171599_("leaf_r11", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(12.3F, 10.4F, 1.6F, -1.2529F, 0.5363F, 1.9591F));
/*     */     
/*  90 */     PartDefinition arm_r9 = rightArmLower.m_171599_("arm_r9", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 12.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/*  92 */     PartDefinition rightHand = rightArmLower.m_171599_("rightHand", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 28.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/*  94 */     PartDefinition leaf_r12 = rightHand.m_171599_("leaf_r12", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, -1.5F, -1.0F, 0.0F, 0.0873F, 0.2618F));
/*     */     
/*  96 */     PartDefinition arm_r10 = rightHand.m_171599_("arm_r10", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, 8.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/*  98 */     PartDefinition leaf_r13 = rightHand.m_171599_("leaf_r13", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4F, -1.8F, 9.1F, 0.5535F, 1.3543F, 0.7773F));
/*     */     
/* 100 */     PartDefinition arm_r11 = rightHand.m_171599_("arm_r11", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 8.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 102 */     PartDefinition arm_r12 = rightHand.m_171599_("arm_r12", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F))
/* 103 */         .m_171514_(0, 0).m_171488_(-10.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(8.0F, 0.0F, 16.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 105 */     PartDefinition arm_r13 = rightHand.m_171599_("arm_r13", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.0F, 0.0F, 4.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 107 */     PartDefinition arm_r14 = rightHand.m_171599_("arm_r14", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/* 109 */     return LayerDefinition.m_171565_(meshdefinition, 128, 128);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelPart m_142109_() {
/* 114 */     return this.root;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
/* 119 */     m_142109_().m_171331_().forEach(ModelPart::m_233569_);
/* 120 */     m_233381_(((WiltedHands)entity).grabAnimationState, WiltedHandsAnimations.grab, ageInTicks);
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\models\entities\WiltedHandsModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */