package com.rustarmor;

import java.util.Map;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class RustArmorMod implements ModInitializer {
    public static final String MOD_ID = "rustarmor";
    private static final int BASE_DURABILITY = 15;

    private static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    private static final ResourceKey<EquipmentAsset> ARMOR_ASSET =
            ResourceKey.create(EquipmentAssets.ROOT_ID, id("rust_metal"));
    private static final TagKey<Item> REPAIR_TAG =
            TagKey.create(Registries.ITEM, id("repairs_rust_armor"));

    private static final ArmorMaterial MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(ArmorType.HELMET, 3, ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6, ArmorType.BOOTS, 3),
            12, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F,
            REPAIR_TAG, ARMOR_ASSET
    );

    private static final ResourceKey<Item> FACEMASK_KEY =
            ResourceKey.create(Registries.ITEM, id("rust_metal_facemask"));
    private static final ResourceKey<Item> CHESTPLATE_KEY =
            ResourceKey.create(Registries.ITEM, id("rust_metal_chestplate"));

    public static final Item RUST_METAL_FACEMASK = registerArmor(FACEMASK_KEY, ArmorType.HELMET);
    public static final Item RUST_METAL_CHESTPLATE = registerArmor(CHESTPLATE_KEY, ArmorType.CHESTPLATE);

    private static Item registerArmor(ResourceKey<Item> key, ArmorType type) {
        Item.Properties properties = new Item.Properties()
                .humanoidArmor(MATERIAL, type)
                .durability(type.getDurability(BASE_DURABILITY))
                .setId(key);
        return Registry.register(BuiltInRegistries.ITEM, key, new Item(properties));
    }

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.accept(RUST_METAL_FACEMASK);
            entries.accept(RUST_METAL_CHESTPLATE);
        });
    }
}
