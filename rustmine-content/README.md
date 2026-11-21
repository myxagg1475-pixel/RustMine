# RustMine Items — Minecraft 1.21.1

This is the first content-pack prototype for RustMine. It uses original cuboid item geometry and vanilla Minecraft textures as placeholders so the pack can be tested without redistributing Rust game assets.

## Included prototypes

- Scrap token — custom 3D cuboid model, CustomModelData 10001
- Cloth bundle — custom 3D cuboid model, CustomModelData 10002
- Metal component — custom 3D cuboid model, CustomModelData 10003

## Test

1. Copy this folder into `.minecraft/resourcepacks/RustMine-Items`.
2. Enable the pack in Minecraft 1.21.1.
3. In a world with cheats enabled, use:
   - `/give @s minecraft:paper[minecraft:custom_model_data=10001]`
   - `/give @s minecraft:paper[minecraft:custom_model_data=10002]`
   - `/give @s minecraft:paper[minecraft:custom_model_data=10003]`

These are visual prototypes, not registered mod items yet. The next stage is a Fabric mod that registers proper RustMine items and adds first-person presentation/idle animations. No Rust game files are copied.
