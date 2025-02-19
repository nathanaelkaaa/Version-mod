/*    */ package com.alexander.rootoffear.models.entities;
/*    */ 
/*    */ import com.alexander.rootoffear.animations.WiltedSpearAnimations;
/*    */ import com.alexander.rootoffear.entities.WiltedSpear;
/*    */ import net.minecraft.client.model.HierarchicalModel;
/*    */ import net.minecraft.client.model.geom.ModelLayerLocation;
/*    */ import net.minecraft.client.model.geom.ModelPart;
/*    */ import net.minecraft.client.model.geom.PartPose;
/*    */ import net.minecraft.client.model.geom.builders.CubeDeformation;
/*    */ import net.minecraft.client.model.geom.builders.CubeListBuilder;
/*    */ import net.minecraft.client.model.geom.builders.LayerDefinition;
/*    */ import net.minecraft.client.model.geom.builders.MeshDefinition;
/*    */ import net.minecraft.client.model.geom.builders.PartDefinition;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ public class WiltedSpearModel<T extends WiltedSpear>
/*    */   extends HierarchicalModel<T>
/*    */ {
/* 20 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("rootoffear", "wilted_spear"), "main");
/*    */   private final ModelPart root;
/*    */   private final ModelPart everything;
/*    */   private final ModelPart rightArmLower;
/*    */   private final ModelPart rightHand;
/*    */   
/*    */   public WiltedSpearModel(ModelPart root) {
/* 27 */     this.root = root;
/* 28 */     this.everything = root.m_171324_("everything");
/* 29 */     this.rightArmLower = this.everything.m_171324_("rightArmLower");
/* 30 */     this.rightHand = this.rightArmLower.m_171324_("rightHand");
/*    */   }
/*    */   
/*    */   public static LayerDefinition createBodyLayer() {
/* 34 */     MeshDefinition meshdefinition = new MeshDefinition();
/* 35 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*    */     
/* 37 */     PartDefinition everything = partdefinition.m_171599_("everything", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
/*    */     
/* 39 */     PartDefinition rightArmLower = everything.m_171599_("rightArmLower", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 32.0F, 4.0F, new CubeDeformation(0.0F))
/* 40 */         .m_171514_(112, 0).m_171480_().m_171488_(10.0F, 14.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -2.0F, -4.0F, 0.0F, -1.5708F, 3.1416F));
/*    */     
/* 42 */     PartDefinition leaf_r1 = rightArmLower.m_171599_("leaf_r1", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.9F, 10.5F, -1.0F, -0.037F, 0.0791F, -0.176F));
/*    */     
/* 44 */     PartDefinition leaf_r2 = rightArmLower.m_171599_("leaf_r2", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(8.5F, 13.7F, -1.0F, -0.2182F, 0.0F, -2.9234F));
/*    */     
/* 46 */     PartDefinition leaf_r3 = rightArmLower.m_171599_("leaf_r3", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.5F, 15.7F, -1.0F, 3.0124F, -0.0659F, -0.691F));
/*    */     
/* 48 */     PartDefinition leaf_r4 = rightArmLower.m_171599_("leaf_r4", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(12.3F, 15.5F, 1.0F, 0.2984F, 0.6098F, -3.1078F));
/*    */     
/* 50 */     PartDefinition leaf_r5 = rightArmLower.m_171599_("leaf_r5", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(12.3F, 10.4F, 1.6F, -1.2529F, 0.5363F, 1.9591F));
/*    */     
/* 52 */     PartDefinition arm_r1 = rightArmLower.m_171599_("arm_r1", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 12.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*    */     
/* 54 */     PartDefinition rightHand = rightArmLower.m_171599_("rightHand", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 28.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
/*    */     
/* 56 */     PartDefinition leaf_r6 = rightHand.m_171599_("leaf_r6", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, -1.5F, -1.0F, 0.0F, 0.0873F, 0.2618F));
/*    */     
/* 58 */     PartDefinition arm_r2 = rightHand.m_171599_("arm_r2", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, 8.0F, 0.0F, 0.0F, -1.5708F));
/*    */     
/* 60 */     PartDefinition leaf_r7 = rightHand.m_171599_("leaf_r7", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4F, -1.8F, 9.1F, 0.5535F, 1.3543F, 0.7773F));
/*    */     
/* 62 */     PartDefinition arm_r3 = rightHand.m_171599_("arm_r3", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 8.0F, -1.5708F, 0.0F, 0.0F));
/*    */     
/* 64 */     PartDefinition arm_r4 = rightHand.m_171599_("arm_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F))
/* 65 */         .m_171514_(0, 0).m_171488_(-10.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(8.0F, 0.0F, 16.0F, -1.5708F, 0.0F, 0.0F));
/*    */     
/* 67 */     PartDefinition arm_r5 = rightHand.m_171599_("arm_r5", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -10.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.0F, 0.0F, 4.0F, -1.5708F, 0.0F, 0.0F));
/*    */     
/* 69 */     PartDefinition arm_r6 = rightHand.m_171599_("arm_r6", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171480_().m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*    */     
/* 71 */     return LayerDefinition.m_171565_(meshdefinition, 128, 128);
/*    */   }
/*    */ 
/*    */   
/*    */   public ModelPart m_142109_() {
/* 76 */     return this.root;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
/* 81 */     m_142109_().m_171331_().forEach(ModelPart::m_233569_);
/* 82 */     m_233381_(((WiltedSpear)entity).spearAnimationState, WiltedSpearAnimations.spear, ageInTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\models\entities\WiltedSpearModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */