/*     */ package com.alexander.rootoffear.models.entities;
/*     */ 
/*     */ import com.alexander.rootoffear.animations.WiltedAnimations;
/*     */ import com.alexander.rootoffear.entities.Wilted;
/*     */ import com.alexander.rootoffear.events.CameraShakeEvents;
/*     */ import com.alexander.rootoffear.init.SoundEventInit;
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
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.AnimationState;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.Pose;
/*     */ 
/*     */ 
/*     */ public class WiltedModel<T extends Wilted>
/*     */   extends HierarchicalModel<T>
/*     */ {
/*  29 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("rootoffear", "wilted"), "main");
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
/*     */   public WiltedModel(ModelPart root) {
/*  60 */     this.root = root;
/*  61 */     this.everything = root.m_171324_("everything");
/*  62 */     this.leftLeg = this.everything.m_171324_("leftLeg");
/*  63 */     this.leftFoot = this.leftLeg.m_171324_("leftFoot");
/*  64 */     this.leftLegRoot1 = this.leftFoot.m_171324_("leftLegRoot1");
/*  65 */     this.leftLegRoot2 = this.leftFoot.m_171324_("leftLegRoot2");
/*  66 */     this.leftLegRoot3 = this.leftFoot.m_171324_("leftLegRoot3");
/*  67 */     this.leftLegRoot4 = this.leftFoot.m_171324_("leftLegRoot4");
/*  68 */     this.rightLeg = this.everything.m_171324_("rightLeg");
/*  69 */     this.rightFoot = this.rightLeg.m_171324_("rightFoot");
/*  70 */     this.rightLegRoot1 = this.rightFoot.m_171324_("rightLegRoot1");
/*  71 */     this.rightLegRoot2 = this.rightFoot.m_171324_("rightLegRoot2");
/*  72 */     this.rightLegRoot3 = this.rightFoot.m_171324_("rightLegRoot3");
/*  73 */     this.rightLegRoot4 = this.rightFoot.m_171324_("rightLegRoot4");
/*  74 */     this.body = this.everything.m_171324_("body");
/*  75 */     this.leaves = this.body.m_171324_("leaves");
/*  76 */     this.rightArm = this.body.m_171324_("rightArm");
/*  77 */     this.rightArmLower = this.rightArm.m_171324_("rightArmLower");
/*  78 */     this.rightHand = this.rightArmLower.m_171324_("rightHand");
/*  79 */     this.leftArm = this.body.m_171324_("leftArm");
/*  80 */     this.leftArmLower = this.leftArm.m_171324_("leftArmLower");
/*  81 */     this.leftHand = this.leftArmLower.m_171324_("leftHand");
/*  82 */     this.head = this.body.m_171324_("head");
/*  83 */     this.eye1 = this.head.m_171324_("eye1");
/*  84 */     this.eye2 = this.head.m_171324_("eye2");
/*  85 */     this.eye3 = this.head.m_171324_("eye3");
/*  86 */     this.eye4 = this.head.m_171324_("eye4");
/*  87 */     this.eye5 = this.head.m_171324_("eye5");
/*     */   }
/*     */   
/*     */   public static LayerDefinition createBodyLayer() {
/*  91 */     MeshDefinition meshdefinition = new MeshDefinition();
/*  92 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*     */     
/*  94 */     PartDefinition everything = partdefinition.m_171599_("everything", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
/*     */     
/*  96 */     PartDefinition leftLeg = everything.m_171599_("leftLeg", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(2.0F, 8.0F, 10.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F))
/*  97 */         .m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(2.0F, -28.0F, -6.0F));
/*     */     
/*  99 */     PartDefinition leaf_r1 = leftLeg.m_171599_("leaf_r1", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.1F, 2.5F, -1.0F, -0.0042F, -0.1659F, -0.518F));
/*     */     
/* 101 */     PartDefinition leaf_r2 = leftLeg.m_171599_("leaf_r2", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.6F, 7.2F, 13.1F, 3.0945F, -0.0618F, 0.7152F));
/*     */     
/* 103 */     PartDefinition leg_r1 = leftLeg.m_171599_("leg_r1", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-3.0F, -14.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0F, 6.0F, 12.0F, 1.5708F, 0.0F, 0.0F));
/*     */     
/* 105 */     PartDefinition leg_r2 = leftLeg.m_171599_("leg_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-4.0F, 6.0F, 0.0F, 0.0F, 1.5708F, -1.5708F));
/*     */     
/* 107 */     PartDefinition leg_r3 = leftLeg.m_171599_("leg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(5.0F, 26.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
/*     */     
/* 109 */     PartDefinition leaf_r3 = leftLeg.m_171599_("leaf_r3", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.3F, 24.1F, 9.0F, 1.7843F, -1.3807F, -1.7931F));
/*     */     
/* 111 */     PartDefinition leg_r4 = leftLeg.m_171599_("leg_r4", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-3.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0F, 26.0F, 8.0F, 1.5708F, 0.0F, 0.0F));
/*     */     
/* 113 */     PartDefinition leaf_r4 = leftLeg.m_171599_("leaf_r4", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.3F, 7.4F, 8.6F, -0.0289F, 1.2987F, -2.9498F));
/*     */     
/* 115 */     PartDefinition leftFoot = leftLeg.m_171599_("leftFoot", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 28.0F, 4.0F));
/*     */     
/* 117 */     PartDefinition leftLegRoot1 = leftFoot.m_171599_("leftLegRoot1", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171480_().m_171488_(-6.0F, -0.1F, 0.0F, 13.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 2.0F));
/*     */     
/* 119 */     PartDefinition leftLegRoot2 = leftFoot.m_171599_("leftLegRoot2", CubeListBuilder.m_171558_().m_171514_(4, 35).m_171488_(-9.0F, -0.1F, -4.0F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-2.0F, 0.0F, 0.0F));
/*     */     
/* 121 */     PartDefinition leftLegRoot3 = leftFoot.m_171599_("leftLegRoot3", CubeListBuilder.m_171558_().m_171514_(1, 46).m_171488_(0.0F, -0.1F, -6.0F, 9.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(2.0F, 0.0F, 0.0F));
/*     */     
/* 123 */     PartDefinition leftLegRoot4 = leftFoot.m_171599_("leftLegRoot4", CubeListBuilder.m_171558_().m_171514_(3, 60).m_171480_().m_171488_(-5.0F, -0.1F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, -2.0F));
/*     */     
/* 125 */     PartDefinition rightLeg = everything.m_171599_("rightLeg", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, 0.0F, -10.0F, 4.0F, 28.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-6.0F, -28.0F, 6.0F));
/*     */     
/* 127 */     PartDefinition leaf_r5 = rightLeg.m_171599_("leaf_r5", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.5F, -1.0F, -0.2F, -2.9129F, -0.0758F, -1.8014F));
/*     */     
/* 129 */     PartDefinition leaf_r6 = rightLeg.m_171599_("leaf_r6", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.4F, 0.8F, -1.9F, 0.6171F, -0.843F, 2.5426F));
/*     */     
/* 131 */     PartDefinition leg_r5 = rightLeg.m_171599_("leg_r5", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
/*     */     
/* 133 */     PartDefinition leg_r6 = rightLeg.m_171599_("leg_r6", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-3.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, 10.0F, -4.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 135 */     PartDefinition leaf_r7 = rightLeg.m_171599_("leaf_r7", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 0.8F, -8.3F, -0.2571F, 0.9752F, -0.1466F));
/*     */     
/* 137 */     PartDefinition leaf_r8 = rightLeg.m_171599_("leaf_r8", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4F, 12.2F, -6.9F, -1.5984F, -1.0335F, -1.6748F));
/*     */     
/* 139 */     PartDefinition rightFoot = rightLeg.m_171599_("rightFoot", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 28.0F, -8.0F));
/*     */     
/* 141 */     PartDefinition rightLegRoot1 = rightFoot.m_171599_("rightLegRoot1", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-6.0F, -0.05F, 0.0F, 13.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 2.0F));
/*     */     
/* 143 */     PartDefinition rightLegRoot2 = rightFoot.m_171599_("rightLegRoot2", CubeListBuilder.m_171558_().m_171514_(4, 35).m_171488_(-9.0F, -0.05F, -4.0F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-2.0F, 0.0F, 0.0F));
/*     */     
/* 145 */     PartDefinition rightLegRoot3 = rightFoot.m_171599_("rightLegRoot3", CubeListBuilder.m_171558_().m_171514_(1, 46).m_171488_(0.0F, -0.05F, -6.0F, 9.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(2.0F, 0.0F, 0.0F));
/*     */     
/* 147 */     PartDefinition rightLegRoot4 = rightFoot.m_171599_("rightLegRoot4", CubeListBuilder.m_171558_().m_171514_(3, 60).m_171488_(-5.0F, -0.05F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, -2.0F));
/*     */     
/* 149 */     PartDefinition body = everything.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 95).m_171488_(-8.0F, -28.0F, -12.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.1F))
/* 150 */         .m_171514_(48, 0).m_171488_(0.0F, -20.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
/* 151 */         .m_171514_(48, 0).m_171488_(-8.0F, -28.0F, -12.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -36.0F, 4.0F));
/*     */     
/* 153 */     PartDefinition leaf_r9 = body.m_171599_("leaf_r9", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.6F, -20.0F, -4.0F, 1.2994F, -0.6289F, 1.9096F));
/*     */     
/* 155 */     PartDefinition leaf_r10 = body.m_171599_("leaf_r10", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, -20.0F, -4.0F, 1.4601F, 1.1683F, -1.4982F));
/*     */     
/* 157 */     PartDefinition leaf_r11 = body.m_171599_("leaf_r11", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -20.0F, -11.0F, 0.0078F, 0.2185F, -2.965F));
/*     */     
/* 159 */     PartDefinition body_r1 = body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-7.0F, -12.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, -24.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 161 */     PartDefinition leaf_r12 = body.m_171599_("leaf_r12", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.0F, 3.0F, 2.8F, -0.1508F, 0.2767F, -2.879F));
/*     */     
/* 163 */     PartDefinition leaf_r13 = body.m_171599_("leaf_r13", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, 3.0F, -2.2F, 1.701F, 0.5898F, -1.5522F));
/*     */     
/* 165 */     PartDefinition leaf_r14 = body.m_171599_("leaf_r14", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.4F, 2.8F, -1.9F, 1.0446F, -1.3372F, 2.0881F));
/*     */     
/* 167 */     PartDefinition leaves_r1 = body.m_171599_("leaves_r1", CubeListBuilder.m_171558_().m_171514_(0, 95).m_171488_(-8.0F, -28.0F, -8.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, -4.0F, 0.0F, -1.5708F, 0.0F));
/*     */     
/* 169 */     PartDefinition leaves_r2 = body.m_171599_("leaves_r2", CubeListBuilder.m_171558_().m_171514_(0, 95).m_171488_(-8.0F, -28.0F, -8.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, -4.0F, 0.0F, 1.5708F, 0.0F));
/*     */     
/* 171 */     PartDefinition leaves_r3 = body.m_171599_("leaves_r3", CubeListBuilder.m_171558_().m_171514_(0, 78).m_171488_(-8.0F, -12.0F, -8.0F, 16.0F, 16.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -20.0F, 0.0F, 1.5708F, 0.0F, 3.1416F));
/*     */     
/* 173 */     PartDefinition leaves_r4 = body.m_171599_("leaves_r4", CubeListBuilder.m_171558_().m_171514_(0, 95).m_171488_(-8.0F, -28.0F, -8.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, -4.0F, 0.0F, 3.1416F, 0.0F));
/*     */     
/* 175 */     PartDefinition body_r2 = body.m_171599_("body_r2", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-4.0F, -12.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 177 */     PartDefinition leaves = body.m_171599_("leaves", CubeListBuilder.m_171558_().m_171514_(46, 95).m_171488_(0.1F, -16.0F, 0.0F, 40.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
/* 178 */         .m_171514_(46, 62).m_171488_(0.1F, -48.0F, 0.0F, 24.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
/* 179 */         .m_171514_(46, 95).m_171480_().m_171488_(-39.9F, -16.0F, 0.0F, 40.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false)
/* 180 */         .m_171514_(46, 62).m_171480_().m_171488_(-23.9F, -48.0F, 0.0F, 24.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, -12.0F, 0.0F));
/*     */     
/* 182 */     PartDefinition leaves_r5 = leaves.m_171599_("leaves_r5", CubeListBuilder.m_171558_().m_171514_(46, 95).m_171488_(0.0F, -32.0F, 0.0F, 40.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
/* 183 */         .m_171514_(46, 62).m_171488_(0.0F, -64.0F, 0.0F, 24.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.1F, 16.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
/*     */     
/* 185 */     PartDefinition leaves_r6 = leaves.m_171599_("leaves_r6", CubeListBuilder.m_171558_().m_171514_(46, 62).m_171480_().m_171488_(0.0F, -64.0F, 0.0F, 24.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.1F, 16.0F, -24.0F, 0.0F, -1.5708F, 0.0F));
/*     */     
/* 187 */     PartDefinition rightArm = body.m_171599_("rightArm", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-4.0F, -4.0F, -2.0F, 4.0F, 24.0F, 4.0F, new CubeDeformation(0.0F))
/* 188 */         .m_171514_(0, 0).m_171480_().m_171488_(-4.0F, -9.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171419_(4.0F, -16.0F, -10.0F));
/*     */     
/* 190 */     PartDefinition leaf_r15 = rightArm.m_171599_("leaf_r15", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-11.0F, 16.8F, -0.3F, -1.4467F, 0.5553F, -1.4665F));
/*     */     
/* 192 */     PartDefinition arm_r1 = rightArm.m_171599_("arm_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-12.0F, 18.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 194 */     PartDefinition leaf_r16 = rightArm.m_171599_("leaf_r16", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, 15.0F, -1.0F, -0.0865F, -0.0114F, -1.4394F));
/*     */     
/* 196 */     PartDefinition arm_r2 = rightArm.m_171599_("arm_r2", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, 18.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 198 */     PartDefinition rightArmLower = rightArm.m_171599_("rightArmLower", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, 2.0F, -2.0F, 4.0F, 32.0F, 4.0F, new CubeDeformation(0.0F))
/* 199 */         .m_171514_(112, 0).m_171480_().m_171488_(10.0F, 18.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(-10.0F, 18.0F, 0.0F));
/*     */     
/* 201 */     PartDefinition leaf_r17 = rightArmLower.m_171599_("leaf_r17", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.9F, 14.5F, -1.0F, -0.037F, 0.0791F, -0.176F));
/*     */     
/* 203 */     PartDefinition leaf_r18 = rightArmLower.m_171599_("leaf_r18", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(8.5F, 17.7F, -1.0F, -0.2182F, 0.0F, -2.9234F));
/*     */     
/* 205 */     PartDefinition leaf_r19 = rightArmLower.m_171599_("leaf_r19", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.5F, 19.7F, -1.0F, 3.0124F, -0.0659F, -0.691F));
/*     */     
/* 207 */     PartDefinition leaf_r20 = rightArmLower.m_171599_("leaf_r20", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(12.3F, 19.5F, 1.0F, 0.2984F, 0.6098F, -3.1078F));
/*     */     
/* 209 */     PartDefinition leaf_r21 = rightArmLower.m_171599_("leaf_r21", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(12.3F, 14.4F, 1.6F, -1.2529F, 0.5363F, 1.9591F));
/*     */     
/* 211 */     PartDefinition arm_r3 = rightArmLower.m_171599_("arm_r3", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 16.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/* 213 */     PartDefinition rightHand = rightArmLower.m_171599_("rightHand", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 32.0F, 0.0F));
/*     */     
/* 215 */     PartDefinition leaf_r22 = rightHand.m_171599_("leaf_r22", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, -1.5F, -1.0F, 0.0F, 0.0873F, 0.2618F));
/*     */     
/* 217 */     PartDefinition arm_r4 = rightHand.m_171599_("arm_r4", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, 8.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 219 */     PartDefinition leaf_r23 = rightHand.m_171599_("leaf_r23", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4F, -1.8F, 9.1F, 0.5535F, 1.3543F, 0.7773F));
/*     */     
/* 221 */     PartDefinition arm_r5 = rightHand.m_171599_("arm_r5", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 8.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 223 */     PartDefinition arm_r6 = rightHand.m_171599_("arm_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F))
/* 224 */         .m_171514_(0, 0).m_171488_(-10.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(8.0F, 0.0F, 16.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 226 */     PartDefinition arm_r7 = rightHand.m_171599_("arm_r7", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.0F, 0.0F, 4.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 228 */     PartDefinition arm_r8 = rightHand.m_171599_("arm_r8", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/* 230 */     PartDefinition leftArm = body.m_171599_("leftArm", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(0.0F, -10.0F, -2.0F, 4.0F, 32.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false)
/* 231 */         .m_171514_(0, 0).m_171480_().m_171488_(0.0F, -15.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171419_(4.0F, -10.0F, -10.0F));
/*     */     
/* 233 */     PartDefinition leaf_r24 = leftArm.m_171599_("leaf_r24", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.0F, 4.0F, 1.8F, -1.4588F, 1.0634F, 1.6785F));
/*     */     
/* 235 */     PartDefinition leaf_r25 = leftArm.m_171599_("leaf_r25", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.0F, -2.0F, 1.8F, -1.7915F, 0.8149F, 1.4072F));
/*     */     
/* 237 */     PartDefinition leftArmLower = leftArm.m_171599_("leftArmLower", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-10.0F, 2.0F, 10.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(2.0F, 20.0F, 0.0F));
/*     */     
/* 239 */     PartDefinition leaf_r26 = leftArmLower.m_171599_("leaf_r26", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.4F, 1.5F, 13.1F, 2.9457F, 0.0957F, -0.3424F));
/*     */     
/* 241 */     PartDefinition arm_r9 = leftArmLower.m_171599_("arm_r9", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171480_().m_171488_(-2.0F, -6.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.0F, 0.0F, 11.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 243 */     PartDefinition leaf_r27 = leftArmLower.m_171599_("leaf_r27", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, -1.3F, 6.8F, 1.0983F, -0.8697F, -1.2248F));
/*     */     
/* 245 */     PartDefinition leaf_r28 = leftArmLower.m_171599_("leaf_r28", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, -1.0F, 7.8F, -1.492F, -0.8086F, 1.5235F));
/*     */     
/* 247 */     PartDefinition arm_r10 = leftArmLower.m_171599_("arm_r10", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171480_().m_171488_(-3.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.0F, 0.0F, 4.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 249 */     PartDefinition arm_r11 = leftArmLower.m_171599_("arm_r11", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.0F, -1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-16.0F, 12.0F, 11.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 251 */     PartDefinition arm_r12 = leftArmLower.m_171599_("arm_r12", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-12.0F, 12.0F, 11.0F, 0.0F, 0.0F, -1.5708F));
/*     */     
/* 253 */     PartDefinition leaf_r29 = leftArmLower.m_171599_("leaf_r29", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.4F, 18.2F, 13.1F, 2.897F, 0.2806F, 2.9989F));
/*     */     
/* 255 */     PartDefinition arm_r13 = leftArmLower.m_171599_("arm_r13", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.0F, 20.0F, 11.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/* 257 */     PartDefinition leaf_r30 = leftArmLower.m_171599_("leaf_r30", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-9.4F, 14.2F, 12.1F, 3.0112F, -0.8175F, 0.6662F));
/*     */     
/* 259 */     PartDefinition leftHand = leftArmLower.m_171599_("leftHand", CubeListBuilder.m_171558_(), PartPose.m_171419_(-8.0F, 20.0F, 12.0F));
/*     */     
/* 261 */     PartDefinition arm_r14 = leftHand.m_171599_("arm_r14", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, -9.0F, 0.0F, 0.0F, 1.5708F));
/*     */     
/* 263 */     PartDefinition leaf_r31 = leftHand.m_171599_("leaf_r31", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.8F, -1.5F, -8.0F, -0.5092F, -1.2851F, 0.5095F));
/*     */     
/* 265 */     PartDefinition arm_r15 = leftHand.m_171599_("arm_r15", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-3.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
/* 266 */         .m_171514_(112, 0).m_171488_(-11.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(9.0F, 0.0F, -12.0F, -1.5708F, 0.0F, 0.0F));
/*     */     
/* 268 */     PartDefinition arm_r16 = leftHand.m_171599_("arm_r16", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F))
/* 269 */         .m_171514_(0, 0).m_171488_(5.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(1.0F, 0.0F, -16.5F, 1.5708F, 0.0F, 0.0F));
/*     */     
/* 271 */     PartDefinition head = body.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-4.0F, -4.0F, -8.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
/* 272 */         .m_171514_(76, 0).m_171488_(-4.0F, 12.0F, -16.01F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-4.0F, -24.0F, 4.0F));
/*     */     
/* 274 */     PartDefinition head_r1 = head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-4.0F, -12.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 16.0F, -12.0F, -1.5708F, 0.0F, -1.5708F));
/*     */     
/* 276 */     PartDefinition eye1 = head.m_171599_("eye1", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-2.5F, 14.5F, -16.0F));
/*     */     
/* 278 */     PartDefinition eye2 = head.m_171599_("eye2", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(1.5F, 12.5F, -16.0F));
/*     */     
/* 280 */     PartDefinition eye3 = head.m_171599_("eye3", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(2.5F, 15.5F, -16.0F));
/*     */     
/* 282 */     PartDefinition eye4 = head.m_171599_("eye4", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-0.5F, 19.5F, -16.0F));
/*     */     
/* 284 */     PartDefinition eye5 = head.m_171599_("eye5", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171488_(-1.5F, -0.5F, -0.11F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-1.5F, 17.5F, -16.0F));
/*     */     
/* 286 */     return LayerDefinition.m_171565_(meshdefinition, 128, 128);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelPart m_142109_() {
/* 291 */     return this.root;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
/* 296 */     m_142109_().m_171331_().forEach(ModelPart::m_233569_);
/* 297 */     System.out.print("\r\nlimbSwing: " + limbSwing);
/* 298 */     System.out.print("\r\nlimbSwingAmount: " + limbSwingAmount);
/* 299 */     if (entity.m_20089_() == Pose.DYING) {
/* 300 */       m_233381_(((Wilted)entity).deathAnimationState, WiltedAnimations.death, ageInTicks);
/*     */     } else {
/* 302 */       if (!entity.isDisguised()) {
/* 303 */         animateLookTarget((entity.m_20089_() != Pose.STANDING && ((Wilted)entity).breakBlocksAnimationState.m_216984_()) ? this.body : this.head, netHeadYaw, headPitch);
/*     */       }
/* 305 */       if (entity.m_20089_() != Pose.STANDING) {
/* 306 */         m_233381_(((Wilted)entity).revealAnimationState, WiltedAnimations.reveal, ageInTicks);
/* 307 */         m_233381_(((Wilted)entity).attackAnimationState, WiltedAnimations.grab_attack, ageInTicks);
/* 308 */         m_233381_(((Wilted)entity).teleportAnimationState, WiltedAnimations.teleport, ageInTicks);
/* 309 */         if (entity.isDisguised()) {
/* 310 */           m_233381_(((Wilted)entity).teleportAnimationState, WiltedAnimations.teleport_eyes, ageInTicks);
/*     */         } else {
/* 312 */           m_233381_(((Wilted)entity).teleportAnimationState, WiltedAnimations.idle, ageInTicks);
/*     */         } 
/* 314 */         m_233381_(((Wilted)entity).leapAnimationState, WiltedAnimations.leap, ageInTicks);
/* 315 */         m_233381_(((Wilted)entity).landAnimationState, WiltedAnimations.land, ageInTicks);
/* 316 */         m_233381_(((Wilted)entity).breakBlocksAnimationState, WiltedAnimations.break_blocks, ageInTicks);
/* 317 */         m_233381_(((Wilted)entity).groundGrabAnimationState, WiltedAnimations.ground_grab, ageInTicks);
/* 318 */         m_233381_(((Wilted)entity).spearAnimationState, WiltedAnimations.spear, ageInTicks);
/*     */       } else {
/* 320 */         float walkAnimationAmountMultiplier = 200.0F;
/* 321 */         float idleAnimationAmount = 1.0F - Math.min(limbSwingAmount * walkAnimationAmountMultiplier, 1.0F);
/* 322 */         if (entity.isDisguised()) {
/* 323 */           animateWalk(WiltedAnimations.walk_disguised, limbSwing, limbSwingAmount, 3.75F, walkAnimationAmountMultiplier);
/* 324 */           animate(((Wilted)entity).idleAnimationState, WiltedAnimations.idle_disguised, ageInTicks, 1.0F, idleAnimationAmount);
/*     */         } else {
/* 326 */           if (limbSwingAmount > 0.8D) {
/* 327 */             animateWalk(WiltedAnimations.run, limbSwing, limbSwingAmount, 0.75F, walkAnimationAmountMultiplier);
/*     */           } else {
/* 329 */             animateWalk(WiltedAnimations.walk, limbSwing, limbSwingAmount, 3.0F, walkAnimationAmountMultiplier);
/*     */           } 
/* 331 */           if (!entity.m_20067_() && Mth.m_14143_(((Wilted)entity).walkAnimation.position()) != Mth.m_14143_(((Wilted)entity).walkAnimPosO) && (Mth.m_14143_(((Wilted)entity).walkAnimation.position()) % 10 == 0 || Mth.m_14143_(((Wilted)entity).walkAnimation.position()) % 10 == 5)) {
/* 332 */             if (limbSwingAmount > 0.8D) {
/* 333 */               CameraShakeEvents.addCameraShake(((Wilted)entity).f_19853_, 3, 0.25F, entity.m_20183_(), 30);
/*     */             } else {
/* 335 */               CameraShakeEvents.addCameraShake(((Wilted)entity).f_19853_, 6, 0.25F, entity.m_20183_(), 30);
/*     */             } 
/* 337 */             ((Wilted)entity).f_19853_.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)SoundEventInit.WILTED_STEP.get(), entity.m_5720_(), 2.5F, entity.m_6100_(), false);
/*     */           } 
/* 339 */           ((Wilted)entity).walkAnimPosO = ((Wilted)entity).walkAnimation.position();
/* 340 */           animate(((Wilted)entity).idleAnimationState, WiltedAnimations.idle, ageInTicks, 1.0F, idleAnimationAmount);
/*     */         } 
/*     */       } 
/* 343 */       m_233381_(((Wilted)entity).hurtAnimationState, WiltedAnimations.hurt, ageInTicks);
/* 344 */       m_233381_(((Wilted)entity).twitchingAnimationState, WiltedAnimations.twitching, ageInTicks);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void animate(AnimationState state, AnimationDefinition definition, float ageInTicks, float speed, float amount) {
/* 349 */     state.m_216974_(ageInTicks, speed);
/* 350 */     state.m_216979_(animState -> KeyframeAnimations.m_232319_(this, definition, animState.m_216981_(), amount, f_233379_));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void animateLookTarget(ModelPart part, float yRot, float xRot) {
/* 356 */     part.f_104203_ = xRot * 0.017453292F;
/* 357 */     part.f_104204_ = yRot * 0.017453292F;
/*     */   }
/*     */   
/*     */   protected void animateWalk(AnimationDefinition p_268159_, float p_268057_, float p_268347_, float p_268138_, float p_268165_) {
/* 361 */     long i = (long)(p_268057_ * 50.0F * p_268138_);
/* 362 */     float f = Math.min(p_268347_ * p_268165_, 1.0F);
/* 363 */     KeyframeAnimations.m_232319_(this, p_268159_, i + 1L, f, f_233379_);
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\models\entities\WiltedModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */