package elsopeen.lyokomod.world.dimension;


import elsopeen.lyokomod.init.ModBlocks;
import elsopeen.lyokomod.world.dimension.util.LyokoForestBiomeProvider;
import elsopeen.lyokomod.world.dimension.util.LyokoBiomeProviderSettings;
import elsopeen.lyokomod.world.dimension.util.LyokoChunkGenerator;
import elsopeen.lyokomod.world.dimension.util.LyokoGenSettings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

import javax.annotation.Nullable;

public class ForestDim extends Dimension {

    public ForestDim(World world, DimensionType dimensionType) {
        super(world, dimensionType, 0.0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        LyokoGenSettings lyokoGenSettings = new LyokoGenSettings();
        lyokoGenSettings.setDefaultBlock(ModBlocks.FOREST_GRASS.get().getDefaultState());
        lyokoGenSettings.setDefaultFluid(ModBlocks.NUMERIC_SEA_FLUID_BLOCK.get().getDefaultState());
        return new LyokoChunkGenerator(world,
                new LyokoForestBiomeProvider(new LyokoBiomeProviderSettings(this.world.getWorldInfo())),
                lyokoGenSettings);
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
        return new Vec3d(0xe5,0xff,0xde);
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
