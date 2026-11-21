# RustMine Fabric mod (Minecraft Java 1.21.1)

This stage registers nine original, non-weapon survival and utility items in the Ingredients creative tab.

## Items
- Scrap
- Cloth Bundle
- Metal Component
- Wood Bundle
- Stone Chunk
- Water Canister
- Field Backpack
- Cloth Hood
- Field Viewer — a harmless 3D utility collectible with a short first-person raise-to-view pose when used.

The models and textures are copied from the checked-in `rustmine-content` prototypes during CI packaging. The field viewer uses a vanilla first-person spyglass-style inspection pose; it has no weapon, firing, ammunition, or combat behavior.

## Status
The backpack and hood are inventory items, not wearable armor. The viewer's current animation is the built-in raise-to-view pose, not a custom hand-rig or a full CoilRust-style inspect sequence.

## Build
The GitHub Actions workflow builds the mod and uploads the JAR as the `RustMine-Fabric-1.21.1` artifact.
