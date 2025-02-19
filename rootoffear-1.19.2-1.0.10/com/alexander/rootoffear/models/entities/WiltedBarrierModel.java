/*    */ package com.alexander.rootoffear.models.entities;
/*    */ 
/*    */ import com.alexander.rootoffear.animations.WiltedBarrierAnimations;
/*    */ import com.alexander.rootoffear.entities.WiltedBarrier;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WiltedBarrierModel<T extends WiltedBarrier>
/*    */   extends HierarchicalModel<T>
/*    */ {
/* 25 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("rootoffear", "wilted_barrier"), "main");
/*    */   private final ModelPart root;
/*    */   private final ModelPart everything;
/*    */   private final ModelPart main;
/*    */   
/*    */   public WiltedBarrierModel(ModelPart root) {
/* 31 */     this.root = root;
/* 32 */     this.everything = root.m_171324_("everything");
/* 33 */     this.main = this.everything.m_171324_("main");
/*    */   }
/*    */   
/*    */   public static LayerDefinition createBodyLayer() {
/* 37 */     MeshDefinition meshdefinition = new MeshDefinition();
/* 38 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*    */     
/* 40 */     PartDefinition everything = partdefinition.m_171599_("everything", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-7.0F, -0.05F, 4.0F, 13.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
/* 41 */         .m_171514_(4, 35).m_171488_(-13.0F, -0.05F, -4.0F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
/* 42 */         .m_171514_(1, 46).m_171488_(4.0F, -0.05F, -6.0F, 9.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
/* 43 */         .m_171514_(3, 60).m_171488_(-6.0F, -0.05F, -14.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
/*    */     
/* 45 */     PartDefinition main = everything.m_171599_("main", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-4.0F, -16.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
/*    */     
/* 47 */     PartDefinition main_r1 = main.m_171599_("main_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-6.0F, -16.0F, 1.0F, 0.0F, 1.5708F, -1.5708F));
/*    */     
/* 49 */     PartDefinition main_r2 = main.m_171599_("main_r2", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, -7.0F, -4.0F, 1.5708F, 0.0F, 0.0F));
/*    */     
/* 51 */     PartDefinition main_r3 = main.m_171599_("main_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.0F, -44.0F, -5.0F, 1.5708F, 0.0F, 3.1416F));
/*    */     
/* 53 */     PartDefinition main_r4 = main.m_171599_("main_r4", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.0F, -44.0F, -4.0F, 1.5708F, 0.0F, 3.1416F));
/*    */     
/* 55 */     PartDefinition main_r5 = main.m_171599_("main_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, -7.0F, -8.0F, 1.5708F, 0.0F, 0.0F));
/*    */     
/* 57 */     PartDefinition main_r6 = main.m_171599_("main_r6", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, -16.0F, 1.0F, 0.0F, 1.5708F, -1.5708F));
/*    */     
/* 59 */     PartDefinition main_r7 = main.m_171599_("main_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-8.0F, -36.0F, -2.0F, 0.0F, -1.5708F, -1.5708F));
/*    */     
/* 61 */     PartDefinition main_r8 = main.m_171599_("main_r8", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*    */     
/* 63 */     PartDefinition main_r9 = main.m_171599_("main_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, -4.0F, 2.0F, -3.1416F, 0.0F, -1.5708F));
/*    */     
/* 65 */     PartDefinition main_r10 = main.m_171599_("main_r10", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, -13.0F, 4.0F, -1.5708F, 0.0F, 1.5708F));
/*    */     
/* 67 */     PartDefinition main_r11 = main.m_171599_("main_r11", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, -40.0F, 8.0F, -1.5708F, 0.0F, -1.5708F));
/*    */     
/* 69 */     PartDefinition main_r12 = main.m_171599_("main_r12", CubeListBuilder.m_171558_().m_171514_(94, 0).m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, -40.0F, 4.0F, -1.5708F, 0.0F, -1.5708F));
/*    */     
/* 71 */     PartDefinition main_r13 = main.m_171599_("main_r13", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, -13.0F, 7.0F, -1.5708F, 0.0F, 1.5708F));
/*    */     
/* 73 */     PartDefinition main_r14 = main.m_171599_("main_r14", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.0F, -4.0F, 2.0F, -3.1416F, 0.0F, -1.5708F));
/*    */     
/* 75 */     PartDefinition main_r15 = main.m_171599_("main_r15", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
/*    */     
/* 77 */     PartDefinition main_r16 = main.m_171599_("main_r16", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, -36.0F, -2.0F, 0.0F, -1.5708F, -1.5708F));
/*    */     
/* 79 */     PartDefinition main_r17 = main.m_171599_("main_r17", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-4.0F, -16.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -32.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
/*    */     
/* 81 */     PartDefinition main_r18 = main.m_171599_("main_r18", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-4.0F, -16.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -16.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
/*    */     
/* 83 */     return LayerDefinition.m_171565_(meshdefinition, 128, 128);
/*    */   }
/*    */ 
/*    */   
/*    */   public ModelPart m_142109_() {
/* 88 */     return this.root;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
/* 93 */     m_142109_().m_171331_().forEach(ModelPart::m_233569_);
/* 94 */     m_233381_(((WiltedBarrier)entity).emergeAnimationState, WiltedBarrierAnimations.emerge, ageInTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\models\entities\WiltedBarrierModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */