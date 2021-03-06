package elsopeen.lyokomod.world;

import elsopeen.lyokomod.init.ModBiomes;
import elsopeen.lyokomod.init.ModStructures;
import elsopeen.lyokomod.world.template.LyokoPlacement;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorldGen {
    /**
     * List of all structures in the mod that are currently enabled (in any biome).
     */
    public static List<Structure<NoFeatureConfig>> structures = new ArrayList<>();

    /**
     * Setup World Generation
     *
     * Note: This should only ever be called from the main thread, since adding features to biomes is not thread-safe.
     */
    public static void setupWorldGen() {
        Iterator<Biome> biomes = ForgeRegistries.BIOMES.iterator();
        biomes.forEachRemaining((biome) -> {
            // Check Blacklist
            if(biome.equals(ModBiomes.BANQUISE.get()) || biome.equals(ModBiomes.FOREST.get()) ||
                    biome.equals(ModBiomes.MOUNTAIN.get()) || biome.equals(ModBiomes.DESERT.get())){
                addSurfaceStructure(biome, ModStructures.TOWER.get());
            }

        });
    }

    /**
     * Add a surface structure to the given biome.
     * @param biome The biome to add a structure to.
     * @param structure The structure to add.
     */
    private static void addSurfaceStructure(Biome biome, Structure<NoFeatureConfig> structure) {
        biome.func_226711_a_(structure.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
        biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, structure.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG).func_227228_a_(LyokoPlacement.TOWER_MIN22.func_227446_a_(new FrequencyConfig(5))));
        structures.add(structure);
    }

    /**
     * Add an underground structure to the given biome.
     * @param biome The biome to add a structure to.
     * @param structure The structure to add.
     */
    private static void addUndergroundStructure(Biome biome, Structure<NoFeatureConfig> structure) {
        biome.func_226711_a_(structure.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, structure.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG).func_227228_a_(LyokoPlacement.TOWER_MIN22.func_227446_a_(new FrequencyConfig(8))));
        structures.add(structure);
    }
}
