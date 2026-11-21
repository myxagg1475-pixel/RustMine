# RustMine

RustMine is an Android launcher project for Minecraft: Java Edition.

## Current status

- Android application shell with a dark/orange RustMine interface.
- Main navigation for Play, Microsoft sign-in, Mods, Textures, and Settings.
- GitHub Actions builds a debug APK for the `main` and `chatgpt-access-check` branches.

## Not implemented yet

The current app does **not** launch Minecraft. These major components still need implementation and device testing:

- Minecraft Java runtime integration (including a compatible Java 21 runtime for Minecraft 1.21.1).
- Game version/library/asset download and verification.
- Microsoft account authentication and Xbox/Minecraft entitlement flow.
- Native rendering, input bridge, and Android game surface.
- Fabric/Forge/NeoForge installation and mod/resource-pack management.

## Engine integration

Amethyst/PojavLauncher is a separate, substantial Android launcher codebase, not a drop-in Android library. Before integrating it, the project must review and comply with its LGPL-3.0 license, preserve required notices/source-offer obligations, and plan the native/JRE build pipeline. Simply adding its source folder or a dependency declaration is not sufficient.

## Build

GitHub Actions workflow: `.github/workflows/build.yml`.

The generated artifact is a **debug APK**. It is not a production-signed release.
