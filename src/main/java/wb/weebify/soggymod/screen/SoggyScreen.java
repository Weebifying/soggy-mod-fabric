package wb.weebify.soggymod.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.MusicType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import wb.weebify.soggymod.SoggyMod;

public class SoggyScreen extends Screen {
    private static final MinecraftClient client = MinecraftClient.getInstance();
    private static final SoundManager soundManager = client.getSoundManager();
    private static final MusicTracker musicTracker = client.getMusicTracker();

    public SoggyScreen(Text title) {
        super(title);
    }

    @Override
    public void close() {
        super.close();
        musicTracker.play(MusicType.MENU);
        if (soundManager.isPlaying(SoggyMod.sound)) {
            soundManager.stop(SoggyMod.sound);
        }
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(Identifier.of(SoggyMod.MOD_ID, "textures/sog.png"), 0, 0, 0, 0, this.width, this.height, this.width, this.height);
    }

    @Override
    public void init() {
        this.addDrawableChild(
                ButtonWidget.builder(ScreenTexts.BACK, button -> this.close())
                .dimensions(this.width / 2 - 36, this.height - 40, 72, 20)
                .build()
        );

        musicTracker.stop(MusicType.MENU);
        if (!soundManager.isPlaying(SoggyMod.sound)) {
            soundManager.play(SoggyMod.sound);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        if (!soundManager.isPlaying(SoggyMod.sound)) {
            soundManager.play(SoggyMod.sound);
        }
    }
}
