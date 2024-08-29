package wb.weebify.soggymod.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import wb.weebify.soggymod.screen.SoggyScreen;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        this.addDrawableChild(
                ButtonWidget.builder(Text.of("..."), button -> MinecraftClient.getInstance().setScreen(new SoggyScreen(Text.of("Soggy Screen"))))
                .dimensions(10, 10, 20, 20)
                .build()
        );
    }
}
