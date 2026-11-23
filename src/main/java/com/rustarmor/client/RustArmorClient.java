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
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;

public class RustArmorClient implements ClientModInitializer {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath("rustarmor", "textures/entity/equipment/humanoid/rust_metal.png");
    private static final ModelLayerLocation MASK_LAYER = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath("rustarmor", "facemask"), "main");
    private static final ModelLayerLocation CHEST_LAYER = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath("rustarmor", "chestplate"), "main");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(MASK_LAYER, RustArmorClient::createMaskLayer);
        EntityModelLayerRegistry.registerModelLayer(CHEST_LAYER, RustArmorClient::createChestLayer);

        ArmorRenderer.register(context -> {
            ModelPart head = context.bakeLayer(MASK_LAYER).getChild("head");
            return (matrices, queue, stack, state, slot, light, vanillaModel) -> {
                if (slot != EquipmentSlot.HEAD) return;
                copyPose(head, vanillaModel.head);
                matrices.pushPose();
                queue.submitModelPart(head, matrices, RenderTypes.entityCutoutNoCull(TEXTURE),
                        light, OverlayTexture.NO_OVERLAY, null);
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
                copyPose(body, vanillaModel.body);
                copyPose(rightArm, vanillaModel.rightArm);
                copyPose(leftArm, vanillaModel.leftArm);
                matrices.pushPose();
                queue.submitModelPart(body, matrices, RenderTypes.entityCutoutNoCull(TEXTURE), light, OverlayTexture.NO_OVERLAY, null);
                queue.submitModelPart(rightArm, matrices, RenderTypes.entityCutoutNoCull(TEXTURE), light, OverlayTexture.NO_OVERLAY, null);
                queue.submitModelPart(leftArm, matrices, RenderTypes.entityCutoutNoCull(TEXTURE), light, OverlayTexture.NO_OVERLAY, null);
                matrices.popPose();
            };
        }, com.rustarmor.RustArmorMod.RUST_METAL_CHESTPLATE);
    }

    private static void copyPose(ModelPart target, ModelPart source) {
        target.x = source.x;
        target.y = source.y;
        target.z = source.z;
        target.xRot = source.xRot;
        target.yRot = source.yRot;
        target.zRot = source.zRot;
        target.xScale = source.xScale;
        target.yScale = source.yScale;
        target.zScale = source.zScale;
        target.visible = true;
    }

    private static LayerDefinition createMaskLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-4.25F, -8.25F, -4.25F, 8.5F, 8.5F, 8.5F, new CubeDeformation(0.18F))
                .texOffs(0, 20).addBox(-3.5F, -3.5F, -5.0F, 7.0F, 3.5F, 1.0F)
                .texOffs(24, 20).addBox(-4.0F, -2.5F, -4.8F, 1.0F, 2.0F, 1.0F)
                .texOffs(24, 20).addBox(3.0F, -2.5F, -4.8F, 1.0F, 2.0F, 1.0F),
                PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 64);
    }

    private static LayerDefinition createChestLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-4.15F, 0.0F, -2.45F, 8.3F, 12.0F, 4.9F, new CubeDeformation(0.18F))
                .texOffs(0, 20).addBox(-3.5F, 1.5F, -2.85F, 7.0F, 5.0F, 0.55F)
                .texOffs(24, 20).addBox(-3.0F, 7.0F, -2.8F, 6.0F, 3.5F, 0.5F),
                PartPose.ZERO);
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 0)
                .addBox(-3.0F, -2.0F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.16F)),
                PartPose.ZERO);
        root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 16)
                .addBox(-1.0F, -2.0F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.16F)),
                PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 64);
    }
}