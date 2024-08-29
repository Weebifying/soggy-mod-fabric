package wb.weebify.soggymod.mixin;

import net.minecraft.client.sound.MusicTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MusicTracker.class)
interface MusicTrackerAccessor {
    @Accessor("timeUntilNextSong")
    int getTimeUntilNextSong();

    @Accessor("timeUntilNextSong")
    void setTimeUntilNextSong(int timeUntilNextSong);
}