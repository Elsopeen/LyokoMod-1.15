package elsopeen.lyokomod.world.dimension;

import elsopeen.lyokomod.world.dimension.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

import javax.annotation.Nullable;

public class BanquiseDim extends Dimension {

    public BanquiseDim(World world, DimensionType dimensionType) {
        super(world, dimensionType, 0.0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new LyokoChunkGenerator(world,
                new LyokoBanquiseBiomeProvider(new LyokoBiomeProviderSettings(this.world.getWorldInfo())),
                new LyokoGenSettings());
    }

    @Nullable
    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return null;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }
}
