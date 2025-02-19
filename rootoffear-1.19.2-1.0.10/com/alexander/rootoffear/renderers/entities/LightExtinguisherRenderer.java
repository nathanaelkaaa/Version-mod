/*     */ package com.alexander.rootoffear.renderers.entities;
/*     */ import com.alexander.rootoffear.entities.LightExtinguisher;
/*     */ import com.alexander.rootoffear.events.LightExtinguisherTrackingEvent;
/*     */ import com.alexander.rootoffear.models.entities.LightExtinguisherDarknessModel;
/*     */ import com.alexander.rootoffear.models.entities.LightExtinguisherModel;
/*     */ import com.alexander.rootoffear.renderers.rendertypes.RoFRenderTypes;
/*     */ import com.alexander.rootoffear.utils.MiscUtils;
/*     */ import com.alexander.rootoffear.utils.PositionUtils;
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*     */ import com.mojang.math.Matrix3f;
/*     */ import com.mojang.math.Matrix4f;
/*     */ import net.minecraft.client.renderer.MultiBufferSource;
/*     */ import net.minecraft.client.renderer.RenderType;
/*     */ import net.minecraft.client.renderer.block.BlockRenderDispatcher;
/*     */ import net.minecraft.client.renderer.culling.Frustum;
/*     */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*     */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*     */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*     */ import net.minecraft.client.resources.model.BakedModel;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.BlockAndTintGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.RenderShape;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.client.RenderTypeHelper;
/*     */ import net.minecraftforge.client.model.data.ModelData;
/*     */ 
/*     */ @OnlyIn(Dist.CLIENT)
/*     */ public class LightExtinguisherRenderer extends EntityRenderer<LightExtinguisher> {
/*  39 */   private static final ResourceLocation TEXTURE = new ResourceLocation("rootoffear", "textures/entity/light_extinguisher.png");
/*  40 */   private static final ResourceLocation DARKNESS_TEXTURE = new ResourceLocation("rootoffear", "textures/entity/light_extinguisher_darkness.png");
/*     */   
/*  42 */   private static final ResourceLocation PULL_LOCATION = new ResourceLocation("rootoffear", "textures/entity/light_extinguisher_pull.png");
/*  43 */   private static final RenderType PULL_RENDER_TYPE = RenderType.m_110458_(PULL_LOCATION);
/*     */   
/*     */   private final LightExtinguisherModel<LightExtinguisher> model;
/*     */   private final LightExtinguisherDarknessModel<LightExtinguisher> darknessModel;
/*     */   private final BlockRenderDispatcher blockRenderDispatcher;
/*     */   
/*     */   public LightExtinguisherRenderer(EntityRendererProvider.Context context) {
/*  50 */     super(context);
/*  51 */     this.model = new LightExtinguisherModel(context.m_174023_(LightExtinguisherModel.LAYER_LOCATION));
/*  52 */     this.darknessModel = new LightExtinguisherDarknessModel(context.m_174023_(LightExtinguisherDarknessModel.LAYER_LOCATION));
/*  53 */     this.blockRenderDispatcher = context.m_234597_();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender(LightExtinguisher entity, Frustum p_114492_, double p_114493_, double p_114494_, double p_114495_) {
/*  59 */     return (MiscUtils.inSurvivalMode(entity.getPulledEntity()) || super.m_5523_((Entity)entity, p_114492_, p_114493_, p_114494_, p_114495_));
/*     */   }
/*     */   
/*     */   private Vec3 getPosition(Entity entity, Entity target, float partialTick) {
/*  63 */     double d0 = Mth.m_14139_(partialTick, target.f_19790_, target.m_20185_());
/*  64 */     double d1 = Mth.m_14139_(partialTick, target.f_19791_, target.m_20186_()) + 0.01D;
/*  65 */     double d2 = Mth.m_14139_(partialTick, target.f_19792_, target.m_20189_());
/*  66 */     return new Vec3(d0 - entity.m_20185_(), d1 - entity.m_20186_(), d2 - entity.m_20189_());
/*     */   }
/*     */   
/*     */   public void render(LightExtinguisher entity, float p_115374_, float partialTick, PoseStack stack, MultiBufferSource buffer, int packedLight) {
/*  70 */     if (!entity.killed && (
/*  71 */       MiscUtils.inSurvivalMode(entity.getPulledEntity()) || !LightExtinguisherTrackingEvent.extinguishers.containsValue(entity.m_20183_().m_7494_()) || 
/*  72 */       !LightExtinguisherTrackingEvent.extinguishers.containsValue(entity.m_20183_().m_7495_()) || 
/*  73 */       !LightExtinguisherTrackingEvent.extinguishers.containsValue(entity.m_20183_().m_122012_()) || 
/*  74 */       !LightExtinguisherTrackingEvent.extinguishers.containsValue(entity.m_20183_().m_122019_()) || 
/*  75 */       !LightExtinguisherTrackingEvent.extinguishers.containsValue(entity.m_20183_().m_122029_()) || 
/*  76 */       !LightExtinguisherTrackingEvent.extinguishers.containsValue(entity.m_20183_().m_122024_()))) {
/*     */       
/*  78 */       LivingEntity target = entity.getPulledEntity();
/*  79 */       if (target != null && entity.m_20270_((Entity)target) >= 1.25D) {
/*  80 */         stack.m_85836_();
/*  81 */         VertexConsumer vertexConsumer = buffer.m_6299_(PULL_RENDER_TYPE);
/*  82 */         PoseStack.Pose posestack$pose = stack.m_85850_();
/*  83 */         Matrix4f matrix4f = posestack$pose.m_85861_();
/*  84 */         Matrix3f matrix3f = posestack$pose.m_85864_();
/*  85 */         float pullLengthLerp = Mth.m_14179_(partialTick, entity.pullLengthLerpO, entity.pullLengthLerp);
/*  86 */         Vec3 entityPos = getPosition((Entity)entity, (Entity)entity, partialTick);
/*  87 */         Vec3 targetPos = entityPos.m_165921_(getPosition((Entity)entity, (Entity)target, partialTick), pullLengthLerp);
/*  88 */         float dist = Mth.m_14179_(pullLengthLerp, 0.0F, (float)Mth.m_14139_(partialTick, entity.pullTargetDistO, entity.pullTargetDist));
/*  89 */         float rollSpeed = 0.01F;
/*  90 */         float roll = -Mth.m_14179_(partialTick, entity.pullO * rollSpeed, entity.pull * rollSpeed);
/*  91 */         int targetLight = this.f_114476_.m_114394_((Entity)target, partialTick);
/*     */         
/*  93 */         Vec3 vec3 = PositionUtils.getOffsetPos(entityPos, (entity.m_20205_() / 2.0F), 0.0D, (-entity.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/*  94 */         vertexConsumer.m_85982_(matrix4f, (float)vec3.f_82479_, (float)vec3.f_82480_, (float)vec3.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, dist + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(packedLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/*  95 */         Vec3 vec31 = PositionUtils.getOffsetPos(targetPos, (target.m_20205_() / 2.0F), 0.0D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/*  96 */         vertexConsumer.m_85982_(matrix4f, (float)vec31.f_82479_, (float)vec31.f_82480_, (float)vec31.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, 0.0F + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/*  97 */         Vec3 vec32 = PositionUtils.getOffsetPos(targetPos, (target.m_20205_() / 2.0F), target.m_20192_() - 0.2D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/*  98 */         vertexConsumer.m_85982_(matrix4f, (float)vec32.f_82479_, (float)vec32.f_82480_, (float)vec32.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, 0.0F + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/*  99 */         Vec3 vec33 = PositionUtils.getOffsetPos(entityPos, (entity.m_20205_() / 2.0F), entity.m_20206_(), (-entity.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 100 */         vertexConsumer.m_85982_(matrix4f, (float)vec33.f_82479_, (float)vec33.f_82480_, (float)vec33.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, dist + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(packedLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/*     */         
/* 102 */         Vec3 vec34 = PositionUtils.getOffsetPos(entityPos, (-entity.m_20205_() / 2.0F), 0.0D, (-entity.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 103 */         vertexConsumer.m_85982_(matrix4f, (float)vec34.f_82479_, (float)vec34.f_82480_, (float)vec34.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, dist + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(packedLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 104 */         Vec3 vec35 = PositionUtils.getOffsetPos(targetPos, (-target.m_20205_() / 2.0F), 0.0D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 105 */         vertexConsumer.m_85982_(matrix4f, (float)vec35.f_82479_, (float)vec35.f_82480_, (float)vec35.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, 0.0F + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 106 */         Vec3 vec36 = PositionUtils.getOffsetPos(targetPos, (-target.m_20205_() / 2.0F), target.m_20192_() - 0.2D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 107 */         vertexConsumer.m_85982_(matrix4f, (float)vec36.f_82479_, (float)vec36.f_82480_, (float)vec36.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, 0.0F + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 108 */         Vec3 vec37 = PositionUtils.getOffsetPos(entityPos, (-entity.m_20205_() / 2.0F), entity.m_20206_(), (-entity.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 109 */         vertexConsumer.m_85982_(matrix4f, (float)vec37.f_82479_, (float)vec37.f_82480_, (float)vec37.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, dist + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(packedLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/*     */         
/* 111 */         Vec3 vec38 = PositionUtils.getOffsetPos(entityPos, (-entity.m_20205_() / 2.0F), 0.0D, (-entity.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 112 */         vertexConsumer.m_85982_(matrix4f, (float)vec38.f_82479_, (float)vec38.f_82480_, (float)vec38.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, dist + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(packedLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 113 */         Vec3 vec39 = PositionUtils.getOffsetPos(targetPos, (-target.m_20205_() / 2.0F), 0.0D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 114 */         vertexConsumer.m_85982_(matrix4f, (float)vec39.f_82479_, (float)vec39.f_82480_, (float)vec39.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, 0.0F + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 115 */         Vec3 vec310 = PositionUtils.getOffsetPos(targetPos, (target.m_20205_() / 2.0F), 0.0D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 116 */         vertexConsumer.m_85982_(matrix4f, (float)vec310.f_82479_, (float)vec310.f_82480_, (float)vec310.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, 0.0F + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 117 */         Vec3 vec311 = PositionUtils.getOffsetPos(entityPos, (entity.m_20205_() / 2.0F), 0.0D, (-entity.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 118 */         vertexConsumer.m_85982_(matrix4f, (float)vec311.f_82479_, (float)vec311.f_82480_, (float)vec311.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, dist + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(packedLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/*     */         
/* 120 */         Vec3 vec312 = PositionUtils.getOffsetPos(entityPos, (-entity.m_20205_() / 2.0F), entity.m_20206_(), (-entity.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 121 */         vertexConsumer.m_85982_(matrix4f, (float)vec312.f_82479_, (float)vec312.f_82480_, (float)vec312.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, dist + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(packedLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 122 */         Vec3 vec313 = PositionUtils.getOffsetPos(targetPos, (-target.m_20205_() / 2.0F), target.m_20192_() - 0.2D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 123 */         vertexConsumer.m_85982_(matrix4f, (float)vec313.f_82479_, (float)vec313.f_82480_, (float)vec313.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, 0.0F + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 124 */         Vec3 vec314 = PositionUtils.getOffsetPos(targetPos, (target.m_20205_() / 2.0F), target.m_20192_() - 0.2D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 125 */         vertexConsumer.m_85982_(matrix4f, (float)vec314.f_82479_, (float)vec314.f_82480_, (float)vec314.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, 0.0F + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 126 */         Vec3 vec315 = PositionUtils.getOffsetPos(entityPos, (entity.m_20205_() / 2.0F), entity.m_20206_(), (-entity.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 127 */         vertexConsumer.m_85982_(matrix4f, (float)vec315.f_82479_, (float)vec315.f_82480_, (float)vec315.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, dist + roll).m_86008_(OverlayTexture.f_118083_).m_85969_(packedLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/*     */         
/* 129 */         Vec3 vec316 = PositionUtils.getOffsetPos(targetPos, (target.m_20205_() / 2.0F), 0.0D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 130 */         vertexConsumer.m_85982_(matrix4f, (float)vec316.f_82479_, (float)vec316.f_82480_, (float)vec316.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, 0.0F).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 131 */         Vec3 vec317 = PositionUtils.getOffsetPos(targetPos, (target.m_20205_() / 2.0F), target.m_20192_() - 0.2D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 132 */         vertexConsumer.m_85982_(matrix4f, (float)vec317.f_82479_, (float)vec317.f_82480_, (float)vec317.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, 0.0F).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 133 */         Vec3 vec318 = PositionUtils.getOffsetPos(targetPos, (-target.m_20205_() / 2.0F), target.m_20192_() - 0.2D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 134 */         vertexConsumer.m_85982_(matrix4f, (float)vec318.f_82479_, (float)vec318.f_82480_, (float)vec318.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(1.0F, 1.0F).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/* 135 */         Vec3 vec319 = PositionUtils.getOffsetPos(targetPos, (-target.m_20205_() / 2.0F), 0.0D, (target.m_20205_() / 2.0F), 0.0F, Mth.m_14179_(partialTick, entity.facingAngleO.f_82471_, entity.facingAngle.f_82471_));
/* 136 */         vertexConsumer.m_85982_(matrix4f, (float)vec319.f_82479_, (float)vec319.f_82480_, (float)vec319.f_82481_).m_85950_(1.0F, 1.0F, 1.0F, 1.0F).m_7421_(0.0F, 1.0F).m_86008_(OverlayTexture.f_118083_).m_85969_(targetLight).m_85977_(matrix3f, 0.0F, 1.0F, 0.0F).m_5752_();
/*     */ 
/*     */         
/* 139 */         stack.m_85849_();
/*     */       } 
/*     */       
/* 142 */       if (entity.getExtinguishedPos().isPresent() && entity.getExtinguishedState().isPresent() && ((BlockState)entity.getExtinguishedState().get()).m_60799_() == RenderShape.MODEL) {
/* 143 */         BlockState blockstate = entity.getExtinguishedState().get();
/* 144 */         Level level = entity.f_19853_;
/* 145 */         if (blockstate != level.m_8055_(entity.m_20183_()) && blockstate.m_60799_() != RenderShape.INVISIBLE) {
/* 146 */           stack.m_85836_();
/* 147 */           BlockPos blockpos = new BlockPos(entity.m_20185_(), (entity.m_20191_()).f_82292_, entity.m_20189_());
/* 148 */           stack.m_85837_(-0.5D, 0.0D, -0.5D);
/* 149 */           BakedModel model = this.blockRenderDispatcher.m_110910_(blockstate);
/* 150 */           for (RenderType renderType : model.getRenderTypes(blockstate, RandomSource.m_216335_(blockstate.m_60726_(entity.getExtinguishedPos().get())), ModelData.EMPTY)) {
/* 151 */             renderType = RenderTypeHelper.getMovingBlockRenderType(renderType);
/* 152 */             this.blockRenderDispatcher.m_110937_().tesselateBlock((BlockAndTintGetter)level, model, blockstate, blockpos, stack, buffer.m_6299_(renderType), false, RandomSource.m_216327_(), blockstate.m_60726_(entity.getExtinguishedPos().get()), OverlayTexture.f_118083_, ModelData.EMPTY, renderType);
/*     */           } 
/* 154 */           stack.m_85849_();
/*     */         } 
/*     */       } 
/* 157 */       stack.m_85836_();
/* 158 */       stack.m_85837_(0.0D, 0.5D, 0.0D);
/* 159 */       stack.m_85845_(entity.attachDirection.m_122406_());
/* 160 */       stack.m_85837_(0.0D, 1.0010000467300415D, 0.0D);
/* 161 */       stack.m_85841_(-1.0F, -1.0F, 1.0F);
/* 162 */       float f = entity.f_19797_ + partialTick;
/* 163 */       this.model.setupAnim(entity, partialTick, 0.0F, f, 0.0F, 0.0F);
/* 164 */       VertexConsumer vertexconsumer = buffer.m_6299_(this.model.m_103119_(getTextureLocation(entity)));
/* 165 */       this.model.m_7695_(stack, vertexconsumer, packedLight, (entity.hurtCooldown > 0) ? 3 : OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
/* 166 */       if (entity.getExtinguishedPos().isPresent() && entity.getExtinguishedState().isPresent()) {
/* 167 */         VertexConsumer vertexconsumer2 = buffer.m_6299_(RoFRenderTypes.solidSwirl(DARKNESS_TEXTURE, f * 0.01F % 1.0F, f * 0.001F % 1.0F));
/* 168 */         this.darknessModel.m_7695_(stack, vertexconsumer2, packedLight, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, Mth.m_14179_(partialTick, entity.darknessO, entity.darkness));
/*     */       } 
/* 170 */       stack.m_85849_();
/* 171 */       super.m_7392_((Entity)entity, p_115374_, partialTick, stack, buffer, packedLight);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void vertex(VertexConsumer p_253637_, Matrix4f p_253920_, Matrix3f p_253881_, float p_253994_, float p_254492_, float p_254474_, int p_254080_, int p_253655_, int p_254133_, float p_254233_, float p_253939_) {
/* 176 */     p_253637_.m_85982_(p_253920_, p_253994_, p_254492_, p_254474_).m_6122_(p_254080_, p_253655_, p_254133_, 255).m_7421_(p_254233_, p_253939_).m_86008_(OverlayTexture.f_118083_).m_85969_(15728880).m_85977_(p_253881_, 0.0F, 1.0F, 0.0F).m_5752_();
/*     */   }
/*     */   
/*     */   public ResourceLocation getTextureLocation(LightExtinguisher entity) {
/* 180 */     return TEXTURE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\renderers\entities\LightExtinguisherRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */