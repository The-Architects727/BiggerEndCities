package net.architects.BigEndCitiesMod;

import net.architects.BigEndCitiesMod.config.ModConfigs;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class BigEndCitiesMod implements ModInitializer {
	public static final String MOD_ID = "bigendcitiesmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModConfigs.registerConfigs();

	}
}