# RustMine Items — Minecraft 1.21.1

An original Rust-inspired visual content prototype for Minecraft Java 1.21.1. No Rust game assets are copied.

## Prototype items

| Custom Model Data | Item | Model |
|---:|---|---|
| 10001 | Scrap | Custom cuboid model with original pixel texture |
| 10002 | Cloth bundle | Custom cuboid model |
| 10003 | Metal component | Custom cuboid model |
| 10004 | Wood bundle | Custom cuboid model |
| 10005 | Stone chunk | Custom cuboid model |
| 10006 | Water canister | Custom cuboid model |
| 10007 | Field backpack | Custom cuboid model |
| 10008 | Cloth hood | Custom cuboid model |

The models use vanilla Minecraft textures as temporary placeholders. Custom pixel-art textures are a later task.

## Install and test

1. Copy this folder into `.minecraft/resourcepacks/RustMine-Items`.
2. Enable the pack in Minecraft 1.21.1.
3. In a world with cheats enabled, use:

```mcfunction
/give @s minecraft:paper[minecraft:custom_model_data=10001]
/give @s minecraft:paper[minecraft:custom_model_data=10002]
/give @s minecraft:paper[minecraft:custom_model_data=10003]
/give @s minecraft:paper[minecraft:custom_model_data=10004]
/give @s minecraft:paper[minecraft:custom_model_data=10005]
/give @s minecraft:paper[minecraft:custom_model_data=10006]
/give @s minecraft:paper[minecraft:custom_model_data=10007]
/give @s minecraft:paper[minecraft:custom_model_data=10008]
```

These are resource-pack prototypes, not registered Fabric mod items. They provide 3D cuboid geometry and first-/third-person display transforms, but do not yet include animated first-person movement. The next implementation stage is a Fabric mod with registered items, original textures, and safe visual/idle animations.
