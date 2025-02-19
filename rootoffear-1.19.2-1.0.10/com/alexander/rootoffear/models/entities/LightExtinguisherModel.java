/*    */ package com.alexander.rootoffear.models.entities;
/*    */ 
/*    */ import com.alexander.rootoffear.animations.LightExtinguisherAnimations;
/*    */ import com.alexander.rootoffear.entities.LightExtinguisher;
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
/*    */ public class LightExtinguisherModel<T extends LightExtinguisher>
/*    */   extends HierarchicalModel<T>
/*    */ {
/* 20 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("rootoffear", "light_extinguisher"), "main");
/*    */   private final ModelPart root;
/*    */   private final ModelPart everything;
/*    */   private final ModelPart main;
/*    */   private final ModelPart lid1;
/*    */   private final ModelPart lid2;
/*    */   private final ModelPart lid3;
/*    */   private final ModelPart lid4;
/*    */   
/*    */   public LightExtinguisherModel(ModelPart root) {
/* 30 */     this.root = root;
/* 31 */     this.everything = root.m_171324_("everything");
/* 32 */     this.main = this.everything.m_171324_("main");
/* 33 */     this.lid1 = this.main.m_171324_("lid1");
/* 34 */     this.lid2 = this.main.m_171324_("lid2");
/* 35 */     this.lid3 = this.main.m_171324_("lid3");
/* 36 */     this.lid4 = this.main.m_171324_("lid4");
/*    */   }
/*    */   
/*    */   public static LayerDefinition createBodyLayer() {
/* 40 */     MeshDefinition meshdefinition = new MeshDefinition();
/* 41 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*    */     
/* 43 */     PartDefinition everything = partdefinition.m_171599_("everything", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, 0.0F, 8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
/*    */     
/* 45 */     PartDefinition root_r1 = everything.m_171599_("root_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-8.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
/*    */     
/* 47 */     PartDefinition root_r2 = everything.m_171599_("root_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, -8.0F, 0.0F, 3.1416F, 0.0F));
/*    */     
/* 49 */     PartDefinition root_r3 = everything.m_171599_("root_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
/*    */     
/* 51 */     PartDefinition main = everything.m_171599_("main", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
/*    */     
/* 53 */     PartDefinition lid1 = main.m_171599_("lid1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(0.0F, -16.0F, -8.0F));
/*    */     
/* 55 */     PartDefinition lid2 = main.m_171599_("lid2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-8.0F, -16.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
/*    */     
/* 57 */     PartDefinition lid3 = main.m_171599_("lid3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.0F, -16.0F, 8.0F, 0.0F, 3.1416F, 0.0F));
/*    */     
/* 59 */     PartDefinition lid4 = main.m_171599_("lid4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(8.0F, -16.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
/*    */     
/* 61 */     return LayerDefinition.m_171565_(meshdefinition, 64, 64);
/*    */   }
/*    */ 
/*    */   
/*    */   public ModelPart m_142109_() {
/* 66 */     return this.root;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
/* 71 */     m_142109_().m_171331_().forEach(ModelPart::m_233569_);
/* 72 */     m_233381_(((LightExtinguisher)entity).hurtAnimationState, LightExtinguisherAnimations.hurt, ageInTicks);
/* 73 */     m_233381_(((LightExtinguisher)entity).extinguishAnimationState, LightExtinguisherAnimations.extinguish, ageInTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\models\entities\LightExtinguisherModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */