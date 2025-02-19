/*     */ package com.alexander.rootoffear.ai.controllers.wilted;
/*     */ 
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.ai.control.MoveControl;
/*     */ import net.minecraft.world.entity.ai.navigation.PathNavigation;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.pathfinder.BlockPathTypes;
/*     */ import net.minecraft.world.level.pathfinder.NodeEvaluator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WiltedMoveControl
/*     */   extends MoveControl
/*     */ {
/*     */   public WiltedMoveControl(Mob mob) {
/*  24 */     super(mob);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_8126_() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield f_24981_ : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   4: getstatic net/minecraft/world/entity/ai/control/MoveControl$Operation.STRAFE : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   7: if_acmpne -> 198
/*     */     //   10: aload_0
/*     */     //   11: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   14: getstatic net/minecraft/world/entity/ai/attributes/Attributes.f_22279_ : Lnet/minecraft/world/entity/ai/attributes/Attribute;
/*     */     //   17: invokevirtual m_21133_ : (Lnet/minecraft/world/entity/ai/attributes/Attribute;)D
/*     */     //   20: d2f
/*     */     //   21: fstore_1
/*     */     //   22: aload_0
/*     */     //   23: getfield f_24978_ : D
/*     */     //   26: d2f
/*     */     //   27: fload_1
/*     */     //   28: fmul
/*     */     //   29: fstore_2
/*     */     //   30: aload_0
/*     */     //   31: getfield f_24979_ : F
/*     */     //   34: fstore_3
/*     */     //   35: aload_0
/*     */     //   36: getfield f_24980_ : F
/*     */     //   39: fstore #4
/*     */     //   41: fload_3
/*     */     //   42: fload_3
/*     */     //   43: fmul
/*     */     //   44: fload #4
/*     */     //   46: fload #4
/*     */     //   48: fmul
/*     */     //   49: fadd
/*     */     //   50: invokestatic m_14116_ : (F)F
/*     */     //   53: fstore #5
/*     */     //   55: fload #5
/*     */     //   57: fconst_1
/*     */     //   58: fcmpg
/*     */     //   59: ifge -> 65
/*     */     //   62: fconst_1
/*     */     //   63: fstore #5
/*     */     //   65: fload_2
/*     */     //   66: fload #5
/*     */     //   68: fdiv
/*     */     //   69: fstore #5
/*     */     //   71: fload_3
/*     */     //   72: fload #5
/*     */     //   74: fmul
/*     */     //   75: fstore_3
/*     */     //   76: fload #4
/*     */     //   78: fload #5
/*     */     //   80: fmul
/*     */     //   81: fstore #4
/*     */     //   83: aload_0
/*     */     //   84: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   87: invokevirtual m_146908_ : ()F
/*     */     //   90: ldc 0.017453292
/*     */     //   92: fmul
/*     */     //   93: invokestatic m_14031_ : (F)F
/*     */     //   96: fstore #6
/*     */     //   98: aload_0
/*     */     //   99: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   102: invokevirtual m_146908_ : ()F
/*     */     //   105: ldc 0.017453292
/*     */     //   107: fmul
/*     */     //   108: invokestatic m_14089_ : (F)F
/*     */     //   111: fstore #7
/*     */     //   113: fload_3
/*     */     //   114: fload #7
/*     */     //   116: fmul
/*     */     //   117: fload #4
/*     */     //   119: fload #6
/*     */     //   121: fmul
/*     */     //   122: fsub
/*     */     //   123: fstore #8
/*     */     //   125: fload #4
/*     */     //   127: fload #7
/*     */     //   129: fmul
/*     */     //   130: fload_3
/*     */     //   131: fload #6
/*     */     //   133: fmul
/*     */     //   134: fadd
/*     */     //   135: fstore #9
/*     */     //   137: aload_0
/*     */     //   138: fload #8
/*     */     //   140: fload #9
/*     */     //   142: invokevirtual m_24996_ : (FF)Z
/*     */     //   145: ifne -> 158
/*     */     //   148: aload_0
/*     */     //   149: fconst_1
/*     */     //   150: putfield f_24979_ : F
/*     */     //   153: aload_0
/*     */     //   154: fconst_0
/*     */     //   155: putfield f_24980_ : F
/*     */     //   158: aload_0
/*     */     //   159: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   162: fload_2
/*     */     //   163: invokevirtual m_7910_ : (F)V
/*     */     //   166: aload_0
/*     */     //   167: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   170: aload_0
/*     */     //   171: getfield f_24979_ : F
/*     */     //   174: invokevirtual m_21564_ : (F)V
/*     */     //   177: aload_0
/*     */     //   178: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   181: aload_0
/*     */     //   182: getfield f_24980_ : F
/*     */     //   185: invokevirtual m_21570_ : (F)V
/*     */     //   188: aload_0
/*     */     //   189: getstatic net/minecraft/world/entity/ai/control/MoveControl$Operation.WAIT : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   192: putfield f_24981_ : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   195: goto -> 703
/*     */     //   198: aload_0
/*     */     //   199: getfield f_24981_ : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   202: getstatic net/minecraft/world/entity/ai/control/MoveControl$Operation.MOVE_TO : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   205: if_acmpne -> 642
/*     */     //   208: aload_0
/*     */     //   209: getstatic net/minecraft/world/entity/ai/control/MoveControl$Operation.WAIT : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   212: putfield f_24981_ : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   215: aload_0
/*     */     //   216: getfield f_24975_ : D
/*     */     //   219: aload_0
/*     */     //   220: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   223: invokevirtual m_20185_ : ()D
/*     */     //   226: dsub
/*     */     //   227: dstore_1
/*     */     //   228: aload_0
/*     */     //   229: getfield f_24977_ : D
/*     */     //   232: aload_0
/*     */     //   233: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   236: invokevirtual m_20189_ : ()D
/*     */     //   239: dsub
/*     */     //   240: dstore_3
/*     */     //   241: aload_0
/*     */     //   242: getfield f_24976_ : D
/*     */     //   245: aload_0
/*     */     //   246: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   249: invokevirtual m_20186_ : ()D
/*     */     //   252: dsub
/*     */     //   253: dstore #5
/*     */     //   255: dload_1
/*     */     //   256: dload_1
/*     */     //   257: dmul
/*     */     //   258: dload #5
/*     */     //   260: dload #5
/*     */     //   262: dmul
/*     */     //   263: dadd
/*     */     //   264: dload_3
/*     */     //   265: dload_3
/*     */     //   266: dmul
/*     */     //   267: dadd
/*     */     //   268: dstore #7
/*     */     //   270: dload #7
/*     */     //   272: ldc2_w 2.500000277905201E-7
/*     */     //   275: dcmpg
/*     */     //   276: ifge -> 288
/*     */     //   279: aload_0
/*     */     //   280: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   283: fconst_0
/*     */     //   284: invokevirtual m_21564_ : (F)V
/*     */     //   287: return
/*     */     //   288: aload_0
/*     */     //   289: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   292: astore #11
/*     */     //   294: aload #11
/*     */     //   296: instanceof com/alexander/rootoffear/entities/Wilted
/*     */     //   299: ifeq -> 322
/*     */     //   302: aload #11
/*     */     //   304: checkcast com/alexander/rootoffear/entities/Wilted
/*     */     //   307: astore #10
/*     */     //   309: aload #10
/*     */     //   311: invokevirtual isDisguised : ()Z
/*     */     //   314: ifeq -> 322
/*     */     //   317: ldc 40.0
/*     */     //   319: goto -> 324
/*     */     //   322: ldc 20.0
/*     */     //   324: fstore #9
/*     */     //   326: aload_0
/*     */     //   327: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   330: invokevirtual m_146892_ : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   333: new net/minecraft/world/phys/Vec3
/*     */     //   336: dup
/*     */     //   337: aload_0
/*     */     //   338: getfield f_24975_ : D
/*     */     //   341: aload_0
/*     */     //   342: getfield f_24976_ : D
/*     */     //   345: aload_0
/*     */     //   346: getfield f_24977_ : D
/*     */     //   349: invokespecial <init> : (DDD)V
/*     */     //   352: invokestatic rotationToFace : (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec2;
/*     */     //   355: getfield f_82471_ : F
/*     */     //   358: fstore #10
/*     */     //   360: aload_0
/*     */     //   361: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   364: astore #12
/*     */     //   366: aload #12
/*     */     //   368: instanceof com/alexander/rootoffear/entities/Wilted
/*     */     //   371: ifeq -> 398
/*     */     //   374: aload #12
/*     */     //   376: checkcast com/alexander/rootoffear/entities/Wilted
/*     */     //   379: astore #11
/*     */     //   381: aload #11
/*     */     //   383: invokevirtual isDisguised : ()Z
/*     */     //   386: ifeq -> 398
/*     */     //   389: fload #10
/*     */     //   391: ldc 90.0
/*     */     //   393: invokestatic roundDegrees : (FF)F
/*     */     //   396: fstore #10
/*     */     //   398: aload_0
/*     */     //   399: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   402: invokevirtual m_146908_ : ()F
/*     */     //   405: invokestatic m_14177_ : (F)F
/*     */     //   408: fload #10
/*     */     //   410: fload #9
/*     */     //   412: invokestatic m_14148_ : (FFF)F
/*     */     //   415: invokestatic m_14177_ : (F)F
/*     */     //   418: fstore #11
/*     */     //   420: aload_0
/*     */     //   421: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   424: fload #11
/*     */     //   426: invokevirtual m_146922_ : (F)V
/*     */     //   429: aload_0
/*     */     //   430: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   433: fload #11
/*     */     //   435: invokevirtual m_5618_ : (F)V
/*     */     //   438: aload_0
/*     */     //   439: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   442: aload_0
/*     */     //   443: getfield f_24978_ : D
/*     */     //   446: aload_0
/*     */     //   447: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   450: getstatic net/minecraft/world/entity/ai/attributes/Attributes.f_22279_ : Lnet/minecraft/world/entity/ai/attributes/Attribute;
/*     */     //   453: invokevirtual m_21133_ : (Lnet/minecraft/world/entity/ai/attributes/Attribute;)D
/*     */     //   456: dmul
/*     */     //   457: d2f
/*     */     //   458: invokevirtual m_7910_ : (F)V
/*     */     //   461: aload_0
/*     */     //   462: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   465: invokevirtual m_20183_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   468: astore #12
/*     */     //   470: aload_0
/*     */     //   471: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   474: getfield f_19853_ : Lnet/minecraft/world/level/Level;
/*     */     //   477: aload #12
/*     */     //   479: invokevirtual m_8055_ : (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;
/*     */     //   482: astore #13
/*     */     //   484: aload #13
/*     */     //   486: aload_0
/*     */     //   487: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   490: getfield f_19853_ : Lnet/minecraft/world/level/Level;
/*     */     //   493: aload #12
/*     */     //   495: invokevirtual m_60812_ : (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/phys/shapes/VoxelShape;
/*     */     //   498: astore #14
/*     */     //   500: aload_0
/*     */     //   501: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   504: astore #16
/*     */     //   506: aload #16
/*     */     //   508: instanceof com/alexander/rootoffear/entities/Wilted
/*     */     //   511: ifeq -> 529
/*     */     //   514: aload #16
/*     */     //   516: checkcast com/alexander/rootoffear/entities/Wilted
/*     */     //   519: astore #15
/*     */     //   521: aload #15
/*     */     //   523: invokevirtual isPhasingThroughWall : ()Z
/*     */     //   526: ifne -> 566
/*     */     //   529: dload #5
/*     */     //   531: aload_0
/*     */     //   532: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   535: invokevirtual getStepHeight : ()F
/*     */     //   538: f2d
/*     */     //   539: dcmpl
/*     */     //   540: ifle -> 566
/*     */     //   543: dload_1
/*     */     //   544: dload_1
/*     */     //   545: dmul
/*     */     //   546: dload_3
/*     */     //   547: dload_3
/*     */     //   548: dmul
/*     */     //   549: dadd
/*     */     //   550: fconst_1
/*     */     //   551: aload_0
/*     */     //   552: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   555: invokevirtual m_20205_ : ()F
/*     */     //   558: invokestatic max : (FF)F
/*     */     //   561: f2d
/*     */     //   562: dcmpg
/*     */     //   563: iflt -> 622
/*     */     //   566: aload #14
/*     */     //   568: invokevirtual m_83281_ : ()Z
/*     */     //   571: ifne -> 639
/*     */     //   574: aload_0
/*     */     //   575: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   578: invokevirtual m_20186_ : ()D
/*     */     //   581: aload #14
/*     */     //   583: getstatic net/minecraft/core/Direction$Axis.Y : Lnet/minecraft/core/Direction$Axis;
/*     */     //   586: invokevirtual m_83297_ : (Lnet/minecraft/core/Direction$Axis;)D
/*     */     //   589: aload #12
/*     */     //   591: invokevirtual m_123342_ : ()I
/*     */     //   594: i2d
/*     */     //   595: dadd
/*     */     //   596: dcmpg
/*     */     //   597: ifge -> 639
/*     */     //   600: aload #13
/*     */     //   602: getstatic net/minecraft/tags/BlockTags.f_13103_ : Lnet/minecraft/tags/TagKey;
/*     */     //   605: invokevirtual m_204336_ : (Lnet/minecraft/tags/TagKey;)Z
/*     */     //   608: ifne -> 639
/*     */     //   611: aload #13
/*     */     //   613: getstatic net/minecraft/tags/BlockTags.f_13039_ : Lnet/minecraft/tags/TagKey;
/*     */     //   616: invokevirtual m_204336_ : (Lnet/minecraft/tags/TagKey;)Z
/*     */     //   619: ifne -> 639
/*     */     //   622: aload_0
/*     */     //   623: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   626: invokevirtual m_21569_ : ()Lnet/minecraft/world/entity/ai/control/JumpControl;
/*     */     //   629: invokevirtual m_24901_ : ()V
/*     */     //   632: aload_0
/*     */     //   633: getstatic net/minecraft/world/entity/ai/control/MoveControl$Operation.JUMPING : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   636: putfield f_24981_ : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   639: goto -> 703
/*     */     //   642: aload_0
/*     */     //   643: getfield f_24981_ : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   646: getstatic net/minecraft/world/entity/ai/control/MoveControl$Operation.JUMPING : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   649: if_acmpne -> 695
/*     */     //   652: aload_0
/*     */     //   653: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   656: aload_0
/*     */     //   657: getfield f_24978_ : D
/*     */     //   660: aload_0
/*     */     //   661: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   664: getstatic net/minecraft/world/entity/ai/attributes/Attributes.f_22279_ : Lnet/minecraft/world/entity/ai/attributes/Attribute;
/*     */     //   667: invokevirtual m_21133_ : (Lnet/minecraft/world/entity/ai/attributes/Attribute;)D
/*     */     //   670: dmul
/*     */     //   671: d2f
/*     */     //   672: invokevirtual m_7910_ : (F)V
/*     */     //   675: aload_0
/*     */     //   676: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   679: invokevirtual m_20096_ : ()Z
/*     */     //   682: ifeq -> 703
/*     */     //   685: aload_0
/*     */     //   686: getstatic net/minecraft/world/entity/ai/control/MoveControl$Operation.WAIT : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   689: putfield f_24981_ : Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;
/*     */     //   692: goto -> 703
/*     */     //   695: aload_0
/*     */     //   696: getfield f_24974_ : Lnet/minecraft/world/entity/Mob;
/*     */     //   699: fconst_0
/*     */     //   700: invokevirtual m_21564_ : (F)V
/*     */     //   703: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #29	-> 0
/*     */     //   #30	-> 10
/*     */     //   #31	-> 22
/*     */     //   #32	-> 30
/*     */     //   #33	-> 35
/*     */     //   #34	-> 41
/*     */     //   #35	-> 55
/*     */     //   #36	-> 62
/*     */     //   #39	-> 65
/*     */     //   #40	-> 71
/*     */     //   #41	-> 76
/*     */     //   #42	-> 83
/*     */     //   #43	-> 98
/*     */     //   #44	-> 113
/*     */     //   #45	-> 125
/*     */     //   #46	-> 137
/*     */     //   #47	-> 148
/*     */     //   #48	-> 153
/*     */     //   #51	-> 158
/*     */     //   #52	-> 166
/*     */     //   #53	-> 177
/*     */     //   #54	-> 188
/*     */     //   #55	-> 195
/*     */     //   #56	-> 208
/*     */     //   #57	-> 215
/*     */     //   #58	-> 228
/*     */     //   #59	-> 241
/*     */     //   #60	-> 255
/*     */     //   #61	-> 270
/*     */     //   #62	-> 279
/*     */     //   #63	-> 287
/*     */     //   #66	-> 288
/*     */     //   #67	-> 326
/*     */     //   #68	-> 360
/*     */     //   #69	-> 389
/*     */     //   #71	-> 398
/*     */     //   #72	-> 420
/*     */     //   #73	-> 429
/*     */     //   #75	-> 438
/*     */     //   #76	-> 461
/*     */     //   #77	-> 470
/*     */     //   #78	-> 484
/*     */     //   #79	-> 500
/*     */     //   #80	-> 622
/*     */     //   #81	-> 632
/*     */     //   #83	-> 639
/*     */     //   #84	-> 652
/*     */     //   #85	-> 675
/*     */     //   #86	-> 685
/*     */     //   #89	-> 695
/*     */     //   #92	-> 703
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   22	173	1	f	F
/*     */     //   30	165	2	f1	F
/*     */     //   35	160	3	f2	F
/*     */     //   41	154	4	f3	F
/*     */     //   55	140	5	f4	F
/*     */     //   98	97	6	f5	F
/*     */     //   113	82	7	f6	F
/*     */     //   125	70	8	f7	F
/*     */     //   137	58	9	f8	F
/*     */     //   309	13	10	wilted	Lcom/alexander/rootoffear/entities/Wilted;
/*     */     //   381	17	11	wilted	Lcom/alexander/rootoffear/entities/Wilted;
/*     */     //   521	8	15	wilted	Lcom/alexander/rootoffear/entities/Wilted;
/*     */     //   228	411	1	d0	D
/*     */     //   241	398	3	d1	D
/*     */     //   255	384	5	d2	D
/*     */     //   270	369	7	d3	D
/*     */     //   326	313	9	turnSpeed	F
/*     */     //   360	279	10	targetYRot	F
/*     */     //   420	219	11	f9	F
/*     */     //   470	169	12	blockpos	Lnet/minecraft/core/BlockPos;
/*     */     //   484	155	13	blockstate	Lnet/minecraft/world/level/block/state/BlockState;
/*     */     //   500	139	14	voxelshape	Lnet/minecraft/world/phys/shapes/VoxelShape;
/*     */     //   0	704	0	this	Lcom/alexander/rootoffear/ai/controllers/wilted/WiltedMoveControl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean m_24996_(float p_24997_, float p_24998_) {
/*  95 */     PathNavigation pathnavigation = this.f_24974_.m_21573_();
/*  96 */     if (pathnavigation != null) {
/*  97 */       NodeEvaluator nodeevaluator = pathnavigation.m_26575_();
/*  98 */       if (nodeevaluator != null && nodeevaluator.m_8086_((BlockGetter)this.f_24974_.f_19853_, Mth.m_14107_(this.f_24974_.m_20185_() + p_24997_), this.f_24974_.m_146904_(), Mth.m_14107_(this.f_24974_.m_20189_() + p_24998_)) != BlockPathTypes.WALKABLE) {
/*  99 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\ai\controllers\wilted\WiltedMoveControl.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */