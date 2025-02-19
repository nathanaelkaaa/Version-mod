/*     */ package com.alexander.rootoffear.models.entities;
/*     */ 
/*     */ import com.alexander.rootoffear.animations.WiltedAnimations;
/*     */ import com.alexander.rootoffear.entities.DecoyWilted;
/*     */ import net.minecraft.client.animation.AnimationDefinition;
/*     */ import net.minecraft.client.animation.KeyframeAnimations;
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
/*     */ public class DecoyWiltedModel<T extends DecoyWilted>
/*     */   extends HierarchicalModel<T>
/*     */ {
/*  22 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("rootoffear", "decoy_wilted"), "main");
/*     */   private final ModelPart root;
/*     */   private final ModelPart everything;
/*     */   private final ModelPart leftLeg;
/*     */   private final ModelPart leftFoot;
/*     */   private final ModelPart leftLegRoot1;
/*     */   private final ModelPart leftLegRoot2;
/*     */   private final ModelPart leftLegRoot3;
/*     */   private final ModelPart leftLegRoot4;
/*     */   private final ModelPart rightLeg;
/*     */   private final ModelPart rightFoot;
/*     */   private final ModelPart rightLegRoot1;
/*     */   private final ModelPart rightLegRoot2;
/*     */   private final ModelPart rightLegRoot3;
/*     */   private final ModelPart rightLegRoot4;
/*     */   private final ModelPart body;
/*     */   private final ModelPart leaves;
/*     */   private final ModelPart rightArm;
/*     */   private final ModelPart rightArmLower;
/*     */   private final ModelPart rightHand;
/*     */   private final ModelPart leftArm;
/*     */   private final ModelPart leftArmLower;
/*     */   private final ModelPart leftHand;
/*     */   private final ModelPart head;
/*     */   private final ModelPart eye1;
/*     */   private final ModelPart eye2;
/*     */   private final ModelPart eye3;
/*     */   private final ModelPart eye4;
/*     */   private final ModelPart eye5;
/*     */   
/*     */   public DecoyWiltedModel(ModelPart root) {
/*  53 */     this.root = root;
/*  54 */     this.everything = root.m_171324_("everything");
/*  55 */     this.leftLeg = this.everything.m_171324_("leftLeg");
/*  56 */     this.leftFoot = this.leftLeg.m_171324_("leftFoot");
/*  57 */     this.leftLegRoot1 = this.leftFoot.m_171324_("leftLegRoot1");
/*  58 */     this.leftLegRoot2 = this.leftFoot.m_171324_("leftLegRoot2");
/*  59 */     this.leftLegRoot3 = this.leftFoot.m_171324_("leftLegRoot3");
/*  60 */     this.leftLegRoot4 = this.leftFoot.m_171324_("leftLegRoot4");
/*  61 */     this.rightLeg = this.everything.m_171324_("rightLeg");
/*  62 */     this.rightFoot = this.rightLeg.m_171324_("rightFoot");
/*  63 */     this.rightLegRoot1 = this.rightFoot.m_171324_("rightLegRoot1");
/*  64 */     this.rightLegRoot2 = this.rightFoot.m_171324_("rightLegRoot2");
/*  65 */     this.rightLegRoot3 = this.rightFoot.m_171324_("rightLegRoot3");
/*  66 */     this.rightLegRoot4 = this.rightFoot.m_171324_("rightLegRoot4");
/*  67 */     this.body = this.everything.m_171324_("body");
/*  68 */     this.leaves = this.body.m_171324_("leaves");
/*  69 */     this.rightArm = this.body.m_171324_("rightArm");
/*  70 */     this.rightArmLower = this.rightArm.m_171324_("rightArmLower");
/*  71 */     this.rightHand = this.rightArmLower.m_171324_("rightHand");
/*  72 */     this.leftArm = this.body.m_171324_("leftArm");
/*  73 */     this.leftArmLower = this.leftArm.m_171324_("leftArmLower");
/*  74 */     this.leftHand = this.leftArmLower.m_171324_("leftHand");
/*  75 */     this.head = this.body.m_171324_("head");
/*  76 */     this.eye1 = this.head.m_171324_("eye1");
/*  77 */     this.eye2 = this.head.m_171324_("eye2");
/*  78 */     this.eye3 = this.head.m_171324_("eye3");
/*  79 */     this.eye4 = this.head.m_171324_("eye4");
/*  80 */     this.eye5 = this.head.m_171324_("eye5");
/*     */   }
/*     */   
/*     */   public static LayerDefinition createBodyLayer() {
/*  84 */     MeshDefinition meshdefinition = new MeshDefinition();
/*  85 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*     */     
/*  87 */     PartDefinition everything = partdefinition.m_171599_("everything", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
/*     */     
/*  89 */     PartDefinition leftLeg = everything.m_171599_("leftLeg", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(2.0F, 8.0F, 10.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F))
/*  90 */         .m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(2.0F, -28.0F, -6.0F));
/*     */     
/*  92 */     PartDefinition leaf_r1 = leftLeg.m_171599_("leaf_r1", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.1F, 2.5F, -1.0F, -0.0042F, -0.1659F, -0.518F));
/*     */     
/*  94 */     PartDefinition leaf_r2 = leftLeg.m_171599_("leaf_r2", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.6F, 7.2F, 13.1F, 3.0945F, -0.0618F, 0.7152F));
/*     */     
/*  96 */     PartDefinition leg_r1 = leftLeg.m_171599_("leg_r1", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-3.0F, -14.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0F, 6.0F, 12.0F, 1.5708F, 0.0F, 0.0F));
/*     */     
/*  98 */     PartDefinition leg_r2 = leftLeg.m_171599_("leg_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-4.0F, 6.0F, 0.0F, 0.0F, 1.5708F, -1.5708F));
/*     */     
/* 100 */     PartDefinition leg_r3 = leftLeg.m_171599_("leg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(5.0F, 26.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
/*     */     
/* 102 */     PartDefinition leaf_r3 = leftLeg.m_171599_("leaf_r3", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.3F, 24.1F, 9.0F, 1.7843F, -1.3807F, -1.7931F));
/*     */     
/* 104 */     PartDefinition leg_r4 = leftLeg.m_171599_("leg_r4", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-3.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0F, 26.0F, 8.0F, 1.5708F, 0.0F, 0.0F));
/*     */     
/* 106 */     PartDefinition leaf_r4 = leftLeg.m_171599_("leaf_r4", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.3F, 7.4F, 8.6F, -0.0289F, 1.2987F, -2.9498F));
/*     */     
/* 108 */     PartDefinition leftFoot = leftLeg.m_171599_("leftFoot", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 28.0F, 4.0F));
/*     */     
/* 110 */     PartDefinition leftLegRoot1 = leftFoot.m_171599_("leftLegRoot1", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171480_().m_171488_(-6.0F, -0.1F, 0.0F, 13.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 2.0F));
/*     */     
/* 112 */     PartDefinition leftLegRoot2 = leftFoot.m_171599_("leftLegRoot2", CubeListBuilder.m_171558_().m_171514_(4, 35).m_171488_(-9.0F, -0.1F, -4.0F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-2.0F, 0.0F, 0.0F));
/*     */     
/* 114 */     PartDefinition leftLegRoot3 = leftFoot.m_171599_("leftLegRoot3", CubeListBuilder.m_171558_().m_171514_(1, 46).m_171488_(0.0F, -0.1F, -6.0F, 9.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(2.0F, 0.0F, 0.0F));
/*     */     
/* 116 */     PartDefinition leftLegRoot4 = leftFoot.m_171599_("leftLegRoot4", CubeListBuilder.m_171558_().m_171514_(3, 60).m_171480_().m_171488_(-5.0F, -0.1F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, -2.0F));
/*     */     
/* 118 */     PartDefinition rightLeg = everything.m_171599_("rightLeg", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, 0.0F, -10.0F, 4.0F, 28.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-6.0F, -28.0F, 6.0F));
/*     */     
/* 120 */     PartDefinition leaf_r5 = rightLeg.m_171599_("leaf_r5", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.5F, -1.0F, -0.2F, -2.9129F, -0.0758F, -1.8014F));
/*     */     
/* 122 */     PartDefinition leaf_r6 = rightLeg.m_171599_("leaf_r6", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.4F, 0.8F, -1.9F, 0.6171F, -0.843F, 2.5426F));
/*     */     
/* 124 */     PartDefinition leg_r5 = rightLeg.m_171599_("leg_r5", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
/*     */     
/* 126 */     PartDefinition leg_r6 = rightLeg.m_171599_("leg_r6", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-3.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, 10.0F, -4.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 128 */     PartDefinition leaf_r7 = rightLeg.m_171599_("leaf_r7", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 0.8F, -8.3F, -0.2571F, 0.9752F, -0.1466F));
/*     */     
/* 130 */     PartDefinition leaf_r8 = rightLeg.m_171599_("leaf_r8", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4F, 12.2F, -6.9F, -1.5984F, -1.0335F, -1.6748F));
/*     */     
/* 132 */     PartDefinition rightFoot = rightLeg.m_171599_("rightFoot", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 28.0F, -8.0F));
/*     */     
/* 134 */     PartDefinition rightLegRoot1 = rightFoot.m_171599_("rightLegRoot1", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-6.0F, -0.05F, 0.0F, 13.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 2.0F));
/*     */     
/* 136 */     PartDefinition rightLegRoot2 = rightFoot.m_171599_("rightLegRoot2", CubeListBuilder.m_171558_().m_171514_(4, 35).m_171488_(-9.0F, -0.05F, -4.0F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-2.0F, 0.0F, 0.0F));
/*     */     
/* 138 */     PartDefinition rightLegRoot3 = rightFoot.m_171599_("rightLegRoot3", CubeListBuilder.m_171558_().m_171514_(1, 46).m_171488_(0.0F, -0.05F, -6.0F, 9.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(2.0F, 0.0F, 0.0F));
/*     */     
/* 140 */     PartDefinition rightLegRoot4 = rightFoot.m_171599_("rightLegRoot4", CubeListBuilder.m_171558_().m_171514_(3, 60).m_171488_(-5.0F, -0.05F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, -2.0F));
/*     */     
/* 142 */     PartDefinition body = everything.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 95).m_171488_(-8.0F, -28.0F, -12.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.1F))
/* 143 */         .m_171514_(48, 0).m_171488_(0.0F, -20.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
/* 144 */         .m_171514_(48, 0).m_171488_(-8.0F, -28.0F, -12.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -36.0F, 4.0F));
/*     */     
/* 146 */     PartDefinition leaf_r9 = body.m_171599_("leaf_r9", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.6F, -20.0F, -4.0F, 1.2994F, -0.6289F, 1.9096F));
/*     */     
/* 148 */     PartDefinition leaf_r10 = body.m_171599_("leaf_r10", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, -20.0F, -4.0F, 1.4601F, 1.1683F, -1.4982F));
/*     */     
/* 150 */     PartDefinition leaf_r11 = body.m_171599_("leaf_r11", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -20.0F, -11.0F, 0.0078F, 0.2185F, -2.965F));
/*     */     
/* 152 */     PartDefinition body_r1 = body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-7.0F, -12.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, -24.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 154 */     PartDefinition leaf_r12 = body.m_171599_("leaf_r12", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.0F, 3.0F, 2.8F, -0.1508F, 0.2767F, -2.879F));
/*     */     
/* 156 */     PartDefinition leaf_r13 = body.m_171599_("leaf_r13", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, 3.0F, -2.2F, 1.701F, 0.5898F, -1.5522F));
/*     */     
/* 158 */     PartDefinition leaf_r14 = body.m_171599_("leaf_r14", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.4F, 2.8F, -1.9F, 1.0446F, -1.3372F, 2.0881F));
/*     */     
/* 160 */     PartDefinition leaves_r1 = body.m_171599_("leaves_r1", CubeListBuilder.m_171558_().m_171514_(0, 95).m_171488_(-8.0F, -28.0F, -8.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, -4.0F, 0.0F, -1.5708F, 0.0F));
/*     */     
/* 162 */     PartDefinition leaves_r2 = body.m_171599_("leaves_r2", CubeListBuilder.m_171558_().m_171514_(0, 95).m_171488_(-8.0F, -28.0F, -8.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, -4.0F, 0.0F, 1.5708F, 0.0F));
/*     */     
/* 164 */     PartDefinition leaves_r3 = body.m_171599_("leaves_r3", CubeListBuilder.m_171558_().m_171514_(0, 78).m_171488_(-8.0F, -12.0F, -8.0F, 16.0F, 16.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -20.0F, 0.0F, 1.5708F, 0.0F, 3.1416F));
/*     */     
/* 166 */     PartDefinition leaves_r4 = body.m_171599_("leaves_r4", CubeListBuilder.m_171558_().m_171514_(0, 95).m_171488_(-8.0F, -28.0F, -8.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, -4.0F, 0.0F, 3.1416F, 0.0F));
/*     */     
/* 168 */     PartDefinition body_r2 = body.m_171599_("body_r2", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-4.0F, -12.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 170 */     PartDefinition leaves = body.m_171599_("leaves", CubeListBuilder.m_171558_().m_171514_(46, 95).m_171488_(0.1F, -16.0F, 0.0F, 40.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
/* 171 */         .m_171514_(46, 62).m_171488_(0.1F, -48.0F, 0.0F, 24.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
/* 172 */         .m_171514_(46, 95).m_171480_().m_171488_(-39.9F, -16.0F, 0.0F, 40.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false)
/* 173 */         .m_171514_(46, 62).m_171480_().m_171488_(-23.9F, -48.0F, 0.0F, 24.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, -12.0F, 0.0F));
/*     */     
/* 175 */     PartDefinition leaves_r5 = leaves.m_171599_("leaves_r5", CubeListBuilder.m_171558_().m_171514_(46, 95).m_171488_(0.0F, -32.0F, 0.0F, 40.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
/* 176 */         .m_171514_(46, 62).m_171488_(0.0F, -64.0F, 0.0F, 24.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.1F, 16.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
/*     */     
/* 178 */     PartDefinition leaves_r6 = leaves.m_171599_("leaves_r6", CubeListBuilder.m_171558_().m_171514_(46, 62).m_171480_().m_171488_(0.0F, -64.0F, 0.0F, 24.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.1F, 16.0F, -24.0F, 0.0F, -1.5708F, 0.0F));
/*     */     
/* 180 */     PartDefinition rightArm = body.m_171599_("rightArm", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-4.0F, -4.0F, -2.0F, 4.0F, 24.0F, 4.0F, new CubeDeformation(0.0F))
/* 181 */         .m_171514_(0, 0).m_171480_().m_171488_(-4.0F, -9.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171419_(4.0F, -16.0F, -10.0F));
/*     */     
/* 183 */     PartDefinition leaf_r15 = rightArm.m_171599_("leaf_r15", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-11.0F, 16.8F, -0.3F, -1.4467F, 0.5553F, -1.4665F));
/*     */     
/* 185 */     PartDefinition arm_r1 = rightArm.m_171599_("arm_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-12.0F, 18.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 187 */     PartDefinition leaf_r16 = rightArm.m_171599_("leaf_r16", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, 15.0F, -1.0F, -0.0865F, -0.0114F, -1.4394F));
/*     */     
/* 189 */     PartDefinition arm_r2 = rightArm.m_171599_("arm_r2", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, 18.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 191 */     PartDefinition rightArmLower = rightArm.m_171599_("rightArmLower", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, 2.0F, -2.0F, 4.0F, 32.0F, 4.0F, new CubeDeformation(0.0F))
/* 192 */         .m_171514_(112, 0).m_171480_().m_171488_(10.0F, 18.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(-10.0F, 18.0F, 0.0F));
/*     */     
/* 194 */     PartDefinition leaf_r17 = rightArmLower.m_171599_("leaf_r17", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.9F, 14.5F, -1.0F, -0.037F, 0.0791F, -0.176F));
/*     */     
/* 196 */     PartDefinition leaf_r18 = rightArmLower.m_171599_("leaf_r18", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(8.5F, 17.7F, -1.0F, -0.2182F, 0.0F, -2.9234F));
/*     */     
/* 198 */     PartDefinition leaf_r19 = rightArmLower.m_171599_("leaf_r19", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.5F, 19.7F, -1.0F, 3.0124F, -0.0659F, -0.691F));
/*     */     
/* 200 */     PartDefinition leaf_r20 = rightArmLower.m_171599_("leaf_r20", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(12.3F, 19.5F, 1.0F, 0.2984F, 0.6098F, -3.1078F));
/*     */     
/* 202 */     PartDefinition leaf_r21 = rightArmLower.m_171599_("leaf_r21", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(12.3F, 14.4F, 1.6F, -1.2529F, 0.5363F, 1.9591F));
/*     */     
/* 204 */     PartDefinition arm_r3 = rightArmLower.m_171599_("arm_r3", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 16.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/* 206 */     PartDefinition rightHand = rightArmLower.m_171599_("rightHand", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 32.0F, 0.0F));
/*     */     
/* 208 */     PartDefinition leaf_r22 = rightHand.m_171599_("leaf_r22", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, -1.5F, -1.0F, 0.0F, 0.0873F, 0.2618F));
/*     */     
/* 210 */     PartDefinition arm_r4 = rightHand.m_171599_("arm_r4", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, 8.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 212 */     PartDefinition leaf_r23 = rightHand.m_171599_("leaf_r23", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4F, -1.8F, 9.1F, 0.5535F, 1.3543F, 0.7773F));
/*     */     
/* 214 */     PartDefinition arm_r5 = rightHand.m_171599_("arm_r5", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 8.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 216 */     PartDefinition arm_r6 = rightHand.m_171599_("arm_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F))
/* 217 */         .m_171514_(0, 0).m_171488_(-10.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(8.0F, 0.0F, 16.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 219 */     PartDefinition arm_r7 = rightHand.m_171599_("arm_r7", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.0F, 0.0F, 4.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 221 */     PartDefinition arm_r8 = rightHand.m_171599_("arm_r8", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/* 223 */     PartDefinition leftArm = body.m_171599_("leftArm", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(0.0F, -10.0F, -2.0F, 4.0F, 32.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false)
/* 224 */         .m_171514_(0, 0).m_171480_().m_171488_(0.0F, -15.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171419_(4.0F, -10.0F, -10.0F));
/*     */     
/* 226 */     PartDefinition leaf_r24 = leftArm.m_171599_("leaf_r24", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.0F, 4.0F, 1.8F, -1.4588F, 1.0634F, 1.6785F));
/*     */     
/* 228 */     PartDefinition leaf_r25 = leftArm.m_171599_("leaf_r25", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.0F, -2.0F, 1.8F, -1.7915F, 0.8149F, 1.4072F));
/*     */     
/* 230 */     PartDefinition leftArmLower = leftArm.m_171599_("leftArmLower", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-10.0F, 2.0F, 10.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(2.0F, 20.0F, 0.0F));
/*     */     
/* 232 */     PartDefinition leaf_r26 = leftArmLower.m_171599_("leaf_r26", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.4F, 1.5F, 13.1F, 2.9457F, 0.0957F, -0.3424F));
/*     */     
/* 234 */     PartDefinition arm_r9 = leftArmLower.m_171599_("arm_r9", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171480_().m_171488_(-2.0F, -6.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.0F, 0.0F, 11.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 236 */     PartDefinition leaf_r27 = leftArmLower.m_171599_("leaf_r27", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, -1.3F, 6.8F, 1.0983F, -0.8697F, -1.2248F));
/*     */     
/* 238 */     PartDefinition leaf_r28 = leftArmLower.m_171599_("leaf_r28", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, -1.0F, 7.8F, -1.492F, -0.8086F, 1.5235F));
/*     */     
/* 240 */     PartDefinition arm_r10 = leftArmLower.m_171599_("arm_r10", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171480_().m_171488_(-3.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.0F, 0.0F, 4.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 242 */     PartDefinition arm_r11 = leftArmLower.m_171599_("arm_r11", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.0F, -1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-16.0F, 12.0F, 11.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 244 */     PartDefinition arm_r12 = leftArmLower.m_171599_("arm_r12", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-12.0F, 12.0F, 11.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 246 */     PartDefinition leaf_r29 = leftArmLower.m_171599_("leaf_r29", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.4F, 18.2F, 13.1F, 2.897F, 0.2806F, 2.9989F));
/*     */     
/* 248 */     PartDefinition arm_r13 = leftArmLower.m_171599_("arm_r13", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.0F, 20.0F, 11.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/* 250 */     PartDefinition leaf_r30 = leftArmLower.m_171599_("leaf_r30", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-9.4F, 14.2F, 12.1F, 3.0112F, -0.8175F, 0.6662F));
/*     */     
/* 252 */     PartDefinition leftHand = leftArmLower.m_171599_("leftHand", CubeListBuilder.m_171558_(), PartPose.m_171419_(-8.0F, 20.0F, 12.0F));
/*     */     
/* 254 */     PartDefinition arm_r14 = leftHand.m_171599_("arm_r14", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, -9.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/* 256 */     PartDefinition leaf_r31 = leftHand.m_171599_("leaf_r31", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.8F, -1.5F, -8.0F, -0.5092F, -1.2851F, 0.5095F));
/*     */     
/* 258 */     PartDefinition arm_r15 = leftHand.m_171599_("arm_r15", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-3.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
/* 259 */         .m_171514_(112, 0).m_171488_(-11.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(9.0F, 0.0F, -12.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 261 */     PartDefinition arm_r16 = leftHand.m_171599_("arm_r16", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F))
/* 262 */         .m_171514_(0, 0).m_171488_(5.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(1.0F, 0.0F, -16.5F, 1.5708F, 0.0F, 0.0F));
/*     */     
/* 264 */     PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-4.0F, -4.0F, -8.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
/* 265 */         .m_171514_(76, 0).m_171488_(-4.0F, 12.0F, -16.01F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-4.0F, -24.0F, 4.0F));
/*     */     
/* 267 */     PartDefinition head_r1 = head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-4.0F, -12.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 16.0F, -12.0F, -1.5708F, 0.0F, -1.5708F));
/*     */     
/* 269 */     PartDefinition eye1 = head.m_171599_("eye1", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-2.5F, 14.5F, -16.0F));
/*     */     
/* 271 */     PartDefinition eye2 = head.m_171599_("eye2", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(1.5F, 12.5F, -16.0F));
/*     */     
/* 273 */     PartDefinition eye3 = head.m_171599_("eye3", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(2.5F, 15.5F, -16.0F));
/*     */     
/* 275 */     PartDefinition eye4 = head.m_171599_("eye4", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-0.5F, 19.5F, -16.0F));
/*     */     
/* 277 */     PartDefinition eye5 = head.m_171599_("eye5", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-1.5F, 17.5F, -16.0F));
/*     */     
/* 279 */     return LayerDefinition.m_171565_(meshdefinition, 128, 128);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelPart m_142109_() {
/* 284 */     return this.root;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
/* 289 */     m_142109_().m_171331_().forEach(ModelPart::m_233569_);
/* 290 */     applyStatic(WiltedAnimations.idle);
/*     */   }
/*     */   
/*     */   protected void applyStatic(AnimationDefinition p_288996_) {
/* 294 */     KeyframeAnimations.m_232319_(this, p_288996_, 1L, 1.0F, f_233379_);
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\models\entities\DecoyWiltedModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */