# Rust Armor — Fabric 1.21.11

A Fabric mod adding two Rust-inspired armor pieces:
- **Metal Facemask** — helmet slot
- **Metal Chestplate** — chest slot

The armor uses Minecraft's built-in humanoid equipment rendering with custom steel-and-rust textures. Both items appear in the Combat creative tab.

## Build
Requires JDK 21 and Gradle 9.x.

```bash
gradle build
```

The compiled mod is placed in `build/libs/`.

## Give commands
```
/give @s rustarmor:rust_metal_facemask
/give @s rustarmor:rust_metal_chestplate
```
