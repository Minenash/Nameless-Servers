package com.minenash.nameless_servers.mixin;

import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin {

    @Shadow protected MultiplayerServerListWidget serverListWidget;

    @Redirect(method = "method_19914", at = @At(value = "NEW", ordinal = 1, target = "net/minecraft/text/TranslatableText"))
    private TranslatableText changeText(String key, Object[] old) {
        if (((String)old[0]).isBlank()) {
            String str = ((MultiplayerServerListWidget.ServerEntry) serverListWidget.getSelected()).getServer().address;
            return new TranslatableText(key, str);
        }

        return new TranslatableText(key, old);
    }

}
