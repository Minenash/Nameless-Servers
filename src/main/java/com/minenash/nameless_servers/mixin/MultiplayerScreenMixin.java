package com.minenash.nameless_servers.mixin;

import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin {

    @Shadow protected MultiplayerServerListWidget serverListWidget;

    @ModifyArg(method = "method_19914", index = 1, at = @At(value = "INVOKE", target = "Lnet/minecraft/text/Text;translatable(Ljava/lang/String;[Ljava/lang/Object;)Lnet/minecraft/text/MutableText;"))
    private Object[] changeText(Object[] old) {
        if (((String)old[0]).isBlank()) {
            return new Object[]{((MultiplayerServerListWidget.ServerEntry) serverListWidget.getSelectedOrNull()).getServer().address};
        }
        return old;
    }

}
