# RustMine Fabric mod (Minecraft Java 1.21.1)

This is the first gameplay-mod stage for RustMine. It registers eight original, non-weapon survival items and adds them to the Ingredients creative tab.

## Items
- Scrap
- Cloth Bundle
- Metal Component
- Wood Bundle
- Stone Chunk
- Water Canister
- Field Backpack
- Cloth Hood

The item models and textures are copied from the checked-in `rustmine-content` resource-pack prototypes during CI packaging. The build produces a Fabric mod JAR for Minecraft Java 1.21.1 and Java 21.

## Status
This stage provides registered inventory items with names, models and textures. It does not yet implement wearable equipment behavior, custom player rendering, item-use gameplay, or first-person animations. The backpack and hood are inventory items, not wearable armor yet.

## Build
The GitHub Actions workflow builds the mod and uploads the JAR as the `RustMine-Fabric-1.21.1` artifact.
