/*    */ package com.alexander.rootoffear.renderers.rendertypes;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.DefaultVertexFormat;
/*    */ import com.mojang.blaze3d.vertex.VertexFormat;
/*    */ import net.minecraft.client.renderer.RenderStateShard;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ 
/*    */ 
/*    */ public class RoFRenderTypes
/*    */ {
/*    */   public static RenderType solidSwirl(ResourceLocation texture, float xOffset, float yOffset) {
/* 13 */     return (RenderType)RenderType.m_173215_("thewilted:solid_swirl", DefaultVertexFormat.f_85812_, VertexFormat.Mode.QUADS, 256, false, true, RenderType.CompositeState.m_110628_().m_173292_(RenderType.f_173074_).m_173290_((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(texture, false, false)).m_110683_((RenderStateShard.TexturingStateShard)new RenderStateShard.OffsetTexturingStateShard(xOffset, yOffset)).m_110685_(RenderType.f_110139_).m_110661_(RenderType.f_110110_).m_110671_(RenderType.f_110152_).m_110677_(RenderType.f_110154_).m_110691_(false));
/*    */   }
/*    */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\renderers\rendertypes\RoFRenderTypes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */