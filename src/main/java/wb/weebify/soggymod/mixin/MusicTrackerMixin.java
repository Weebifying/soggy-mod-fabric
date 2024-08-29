package wb.weebify.soggymod.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.sound.MusicSound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import wb.weebify.soggymod.SoggyMod;
import wb.weebify.soggymod.screen.SoggyScreen;

@Mixin(MusicTracker.class)
public class MusicTrackerMixin {
    @Inject(method = "play", at = @At("HEAD"), cancellable = true)
    private void play(MusicSound type, CallbackInfo ci) {
        if (MinecraftClient.getInstance().currentScreen instanceof SoggyScreen) {
            SoggyMod.LOGGER.info("Stopped main music from playing");
            ((MusicTrackerAccessor) this).setTimeUntilNextSong(Integer.MAX_VALUE);
            ci.cancel();
        }
    }
}
