# RustMine Items — Minecraft Java 1.21.1

An original Rust-inspired visual content prototype. No Rust game assets are copied.

## Prototype items

| Custom Model Data | Item | Model and texture |
|---:|---|---|
| 10001 | Scrap | 3D cuboid + original 16×16 pixel texture |
| 10002 | Cloth bundle | 3D cuboid + original 16×16 pixel texture |
| 10003 | Metal component | 3D cuboid + original 16×16 pixel texture |
| 10004 | Wood bundle | 3D cuboid + original 16×16 pixel texture |
| 10005 | Stone chunk | 3D cuboid + original 16×16 pixel texture |
| 10006 | Water canister | 3D cuboid + original 16×16 pixel texture |
| 10007 | Field backpack | 3D cuboid + original 16×16 pixel texture |
| 10008 | Cloth hood | 3D cuboid + original 16×16 pixel texture |

## Install and test

1. Download the `RustMine-Items-1.21.1` ZIP from the latest successful GitHub Actions run.
2. Extract it into the Minecraft `.minecraft/resourcepacks/RustMine-Items` folder.
3. Enable **RustMine Items** in Minecraft 1.21.1.
4. In a world with cheats enabled, enter one of these commands:

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

## Current limitations

This is a resource-pack prototype, not a Fabric mod with registered custom items. It includes custom cuboid geometry, original pixel textures, and static first-/third-person display transforms. It does **not** yet include animated first-person hand movement, player-wearable armor behavior, or gameplay systems. Those require a separate mod implementation.
