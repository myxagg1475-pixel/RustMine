package com.rustarmor.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;

public class RustArmorClient implements ClientModInitializer {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath("rustarmor", "textures/models/armor/rust_metal.png");
    private static final ModelLayerLocation MASK_LAYER = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath("rustarmor", "facemask"), "main");
    private static final ModelLayerLocation CHEST_LAYER = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath("rustarmor", "chestplate"), "main");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(MASK_LAYER, RustArmorClient::createMaskLayer);
        EntityModelLayerRegistry.registerModelLayer(CHEST_LAYER, RustArmorClient::createChestLayer);

        ArmorRenderer.register(context -> {
            ModelPart root = context.bakeLayer(MASK_LAYER);
            ModelPart head = root.getChild("head");
            return (matrices, queue, stack, state, slot, light, vanillaModel) -> {
                if (slot != EquipmentSlot.HEAD) return;
                head.copyFrom(vanillaModel.head);
                matrices.pushPose();
                queue.submitModelPart(head, matrices, RenderType.entityCutoutNoCull(TEXTURE),
                        light,  OverlayTexture.NO_OVERLAY, null);
                matrices.popPose();
            };
        }, com.rustarmor.RustArmorMod.RUST_METAL_FACEMASK);

        ArmorRenderer.register(context -> {
            ModelPart root = context.bakeLayer(CHEST_LAYER);
            ModelPart body = root.getChild("body");
            ModelPart rightArm = root.getChild("right_arm");
            ModelPart leftArm = root.getChild("left_arm");
            return (matrices, queue, stack, state, slot, light, vanillaModel) -> {
                if (slot != EquipmentSlot.CHEST) return;
                body.copyFrom(vanillaModel.body);
                rightArm.copyFrom(vanillaModel.rightArm);
                leftArm.copyFrom(vanillaModel.leftArm);
                matrices.pushPose();
                queue.submitModelPart(body, matrices, RenderType.entityCutoutNoCull(TEXTURE), light, OverlayTextureAccess.NO_OVERLAY, null);
                queue.submitModelPart(rightArm, matrices, RenderType.entityCutoutNoCull(TEXTURE), light, OverlayTextureAccess.NO_OVERLAY, null);
                queue.submitModelPart(leftArm, matrices, RenderType.entityCutoutNoCull(TEXTURE), light, OverlayTextureAccess.NO_OVERLAY, null);
                matrices.popPose();
            };
        }, com.rustarmor.RustArmorMod.RUST_METAL_CHESTPLATE);
    }

    private static LayerDefinition createMaskLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.35F))
                .texOffs(0, 20).addBox(-4.0F, -3.0F, -5.8F, 8.0F, 4.0F, 2.0F),
                PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 64);
    }

    private static LayerDefinition createChestLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-4.5F, 0.0F, -2.8F, 9.0F, 12.0F, 5.6F, new CubeDeformation(0.45F))
                .texOffs(0, 20).addBox(-3.0F, 2.0F, -3.4F, 6.0F, 5.0F, 1.0F),
                PartPose.ZERO);
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 0)
                .addBox(-3.2F, -2.0F, -2.8F, 5.0F, 6.0F, 5.6F, new CubeDeformation(0.3F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 0)
                .addBox(-1.8F, -2.0F, -2.8F, 5.0F, 6.0F, 5.6F, new CubeDeformation(0.3F)),
                PartPose.offset(5.0F, 2.0F, 0.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }
}
