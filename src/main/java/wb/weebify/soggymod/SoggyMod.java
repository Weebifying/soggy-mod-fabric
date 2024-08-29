package wb.weebify.soggymod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.Position;
import java.util.Random;

public class SoggyMod implements ModInitializer {
	public static final String MOD_ID = "soggy-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static PositionedSoundInstance sound;

	@Override
	public void onInitialize() {
		sound = PositionedSoundInstance.master(SoundEvent.of(Identifier.of(MOD_ID, "soggy_loop")), 1.0F);
	}
}