package elsopeen.lyokomod.init;

import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import elsopeen.lyokomod.tileentity.TowerBaseTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Registering class for TileEntities
 * as explained in Forge Docs 1.15.2
 */
public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, LyokoMod.MOD_ID);

    public static final RegistryObject<TileEntityType<InterfaceTileEntity>> INTERFACE =
            TILE_ENTITY_TYPES.register("interface", () ->
            TileEntityType.Builder.create(InterfaceTileEntity::new,
                    ModBlocks.INTERFACE.get())
            .build(null));

    public static final RegistryObject<TileEntityType<TowerBaseTileEntity>> TOWER_BASE =
            TILE_ENTITY_TYPES.register("tower_base", ()->
                    TileEntityType.Builder.create(TowerBaseTileEntity::new,
                            ModBlocks.TOWER_BASE.get())
            .build(null));
}
