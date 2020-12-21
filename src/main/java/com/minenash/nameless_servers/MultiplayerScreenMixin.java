package com.minenash.nameless_servers;

import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin {

    @Shadow protected MultiplayerServerListWidget serverListWidget;

    @Redirect(method = "method_19914", at = @At(value = "NEW", target = "net/minecraft/client/gui/screen/ConfirmScreen"))
    private ConfirmScreen changeText(BooleanConsumer callback, Text title, Text message, Text text, Text text2) {
        String line = message.getString();
        if (line.contains("''")) {
            String address = ((MultiplayerServerListWidget.ServerEntry) serverListWidget.getSelected()).getServer().address;
            return new ConfirmScreen(callback, title, new LiteralText(line.replace("''", "''" + address + "'")), text, text2);
        }
        return new ConfirmScreen(callback, title, message, text, text2);
    }

}
