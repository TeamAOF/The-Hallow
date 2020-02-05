package io.github.alloffabric.thehallow.client.render;

import io.github.alloffabric.thehallow.TheHallow;
import io.github.alloffabric.thehallow.client.model.CrowEntityModel;
import io.github.alloffabric.thehallow.entity.CrowEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CrowEntityRenderer extends MobEntityRenderer<CrowEntity, CrowEntityModel> {
	private static final Identifier SKIN = new Identifier(TheHallow.MOD_ID, "textures/entity/crow.png");

	public CrowEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher, new CrowEntityModel(), 0.3F);
	}

	@Override
	public Identifier getTexture(CrowEntity crow) {
		return SKIN;
	}
}
