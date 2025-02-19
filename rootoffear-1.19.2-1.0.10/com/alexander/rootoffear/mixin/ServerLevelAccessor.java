package com.alexander.rootoffear.mixin;

import java.util.List;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.CustomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({ServerLevel.class})
public interface ServerLevelAccessor {
  @Accessor
  List<CustomSpawner> getCustomSpawners();
  
  @Mutable
  @Accessor
  void setCustomSpawners(List<CustomSpawner> paramList);
}


/* Location:              C:\Users\Black\Desktop\Root of fear\rootoffear-1.19.2-1.0.10.jar!\com\alexander\rootoffear\mixin\ServerLevelAccessor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */