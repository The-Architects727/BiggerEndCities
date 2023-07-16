package net.architects.morestructuresmod;

import net.architects.morestructuresmod.config.ModConfigs;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class MoreStructuresMod implements ModInitializer {
	public static final String MOD_ID = "MoreStructuresMod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModConfigs.registerConfigs();

	}
}