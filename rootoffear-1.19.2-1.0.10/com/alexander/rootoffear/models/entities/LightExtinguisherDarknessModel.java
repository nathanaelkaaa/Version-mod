/*    */ package com.alexander.rootoffear.models.entities;
/*    */ 
/*    */ import com.alexander.rootoffear.entities.LightExtinguisher;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*    */ import net.minecraft.client.model.EntityModel;
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
/*    */ public class LightExtinguisherDarknessModel<T extends LightExtinguisher>
/*    */   extends EntityModel<T>
/*    */ {
/* 21 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("rootoffear", "light_extinguisher"), "darkness");
/*    */   private final ModelPart bb_main;
/*    */   
/*    */   public LightExtinguisherDarknessModel(ModelPart root) {
/* 25 */     this.bb_main = root.m_171324_("bb_main");
/*    */   }
/*    */   
/*    */   public static LayerDefinition createBodyLayer() {
/* 29 */     MeshDefinition meshdefinition = new MeshDefinition();
/* 30 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*    */     
/* 32 */     PartDefinition bb_main = partdefinition.m_171599_("bb_main", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
/*    */     
/* 34 */     return LayerDefinition.m_171565_(meshdefinition, 64, 64);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setupAnim(LightExtinguisher entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
/* 44 */     this.bb_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\models\entities\LightExtinguisherDarknessModel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */