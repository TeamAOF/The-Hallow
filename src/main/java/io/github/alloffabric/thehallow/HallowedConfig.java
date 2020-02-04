package io.github.alloffabric.thehallow;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonGrammar;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.api.SyntaxError;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HallowedConfig {

	private static final Jankson JANKSON = Jankson.builder().build();

	public static void sync() {
		File configFile = new File("config/thehallow.json5");
		JsonObject config = new JsonObject();
		if (configFile.exists()) {
			try {
				config = JANKSON.load(configFile);
				loadFrom(config);
				writeConfigFile(configFile, config);
			} catch (IOException | SyntaxError e) {
				TheHallow.LOGGER.error("The Hallow config could not be loaded. Default values will be used.", e);
			}
		} else {
			saveTo(config);
			writeConfigFile(configFile, config);
		}
	}

	private static void writeConfigFile(File file, JsonObject config) {
		saveTo(config);
		try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
			out.write(config.toJson(JsonGrammar.JANKSON).getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			TheHallow.LOGGER.error("The Hallow config could not be written. This probably won't cause any problems, but it shouldn't happen.", e);
		}
	}

	public static class HallowedDimension {
		public static boolean waterVaporizes = true;
	}

	public static class TinyPumpkin {
		public static boolean waterloggable = true;
	}

	public static class HallowedFog {
		public static int fogSmoothingRadius = 8;
	}

	public static class Tweaks {
		public static boolean pumpkinPieBlock = true;
	}

	//deserializer
	public static void loadFrom(JsonObject obj) {
		JsonObject dimension = getObjectOrEmpty("dimension", obj);
		HallowedDimension.waterVaporizes = dimension.getBoolean("water_vaporizes", HallowedDimension.waterVaporizes);

		JsonObject tinyPumpkin = getObjectOrEmpty("tiny_pumpkin", obj);
		TinyPumpkin.waterloggable = tinyPumpkin.getBoolean("waterloggable", TinyPumpkin.waterloggable);

		JsonObject fog = getObjectOrEmpty("fog", obj);
		HallowedFog.fogSmoothingRadius = fog.getInt("fogSmoothingRadius", HallowedFog.fogSmoothingRadius);

		JsonObject tweaks = getObjectOrEmpty("tweaks", obj);
		Tweaks.pumpkinPieBlock = tweaks.getBoolean("pumpkin_pie_block", Tweaks.pumpkinPieBlock);
	}

	//serializer
	public static void saveTo(JsonObject obj) {
		JsonObject dimension = defaultPutButNotNull("dimension", new JsonObject(), obj);
		dimension.putDefault("water_vaporizes", HallowedDimension.waterVaporizes, "Changed whether or not water vaporizes in The Hallow");

		JsonObject tinyPumpkin = defaultPutButNotNull("tiny_pumpkin", new JsonObject(), obj);
		tinyPumpkin.putDefault("waterloggable", TinyPumpkin.waterloggable, "Lets the Tiny Pumpkin be waterlogged");

		JsonObject fog = defaultPutButNotNull("fog", new JsonObject(), obj);
		fog.putDefault("fogSmoothingRadius", HallowedFog.fogSmoothingRadius, "Determines the radius in which biomes are checked to smooth out biome fog colors. Lower values = less intensive.");

		JsonObject tweaks = defaultPutButNotNull("tweaks", new JsonObject(), obj);
		tweaks.putDefault("pumpkin_pie_block", Tweaks.pumpkinPieBlock, "If true, allows placing pumpkin pie blocks using the vanilla pumpkin pie item");
	}

	private static JsonObject getObjectOrEmpty(String key, JsonObject on) {
		JsonObject obj = on.getObject(key);
		return obj != null ? obj:new JsonObject();
	}


	@SuppressWarnings("unchecked")
	private static <T extends JsonElement> T defaultPutButNotNull(String key, T value, JsonObject obj) {
		JsonElement result = obj.putDefault(key, value, value.getClass(), null);
		return result != null ? (T) result:value;
	}
}
