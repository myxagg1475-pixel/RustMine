package com.rustmine;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RustMineMod implements ModInitializer {
    public static final String MOD_ID = "rustmine";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item SCRAP = register("scrap");
    public static final Item CLOTH_BUNDLE = register("cloth_bundle");
    public static final Item METAL_COMPONENT = register("metal_component");
    public static final Item WOOD_BUNDLE = register("wood_bundle");
    public static final Item STONE_CHUNK = register("stone_chunk");
    public static final Item WATER_CANISTER = register("water_canister");
    public static final Item FIELD_BACKPACK = register("field_backpack");
    public static final Item CLOTH_HOOD = register("cloth_hood");

    private static Item register(String path) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
        return Registry.register(BuiltInRegistries.ITEM, id, new Item(new Item.Properties()));
    }

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(SCRAP);
            entries.accept(CLOTH_BUNDLE);
            entries.accept(METAL_COMPONENT);
            entries.accept(WOOD_BUNDLE);
            entries.accept(STONE_CHUNK);
            entries.accept(WATER_CANISTER);
            entries.accept(FIELD_BACKPACK);
            entries.accept(CLOTH_HOOD);
        });
        LOGGER.info("RustMine registered 8 survival items.");
    }
}
