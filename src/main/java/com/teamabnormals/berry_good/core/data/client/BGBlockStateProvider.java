package com.teamabnormals.berry_good.core.data.client;

import com.teamabnormals.berry_good.core.BerryGood;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import static com.teamabnormals.berry_good.core.registry.BGBlocks.GLOW_BERRY_BASKET;
import static com.teamabnormals.berry_good.core.registry.BGBlocks.SWEET_BERRY_BASKET;

public class BGBlockStateProvider extends BlockStateProvider {

	public BGBlockStateProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
		super(generator, BerryGood.MOD_ID, fileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.directionalBlock(SWEET_BERRY_BASKET.get());
		this.directionalBlock(GLOW_BERRY_BASKET.get());
	}

	public void blockItem(Block block) {
		this.simpleBlockItem(block, new ExistingModelFile(blockTexture(block), this.models().existingFileHelper));
	}

	public void directionalBlock(Block block) {
		this.directionalBlock(block, models().cubeBottomTop(name(block), suffix(blockTexture(block), "_side"), suffix(blockTexture(block), "_bottom"), suffix(blockTexture(block), "_top")));
		this.blockItem(block);
	}

	private String name(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block).getPath();
	}

	private ResourceLocation suffix(ResourceLocation rl, String suffix) {
		return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
	}
}