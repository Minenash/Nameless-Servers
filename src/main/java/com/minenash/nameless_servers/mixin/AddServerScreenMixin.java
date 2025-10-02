package com.minenash.nameless_servers.mixin;

import net.minecraft.client.gui.screen.multiplayer.AddServerScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AddServerScreen.class)
public class AddServerScreenMixin {

    @ModifyArg(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/TextFieldWidget;setPlaceholder(Lnet/minecraft/text/Text;)V"))
    public Text removePlaceholder(Text _placeholder) {
        return Text.empty();
    }

    @Redirect(method = "addAndClose", at = @At(value = "INVOKE", target = "Lnet/minecraft/text/Text;getString()Ljava/lang/String;"))
    public String keepServerNameBlank(Text _text) {
        return "";
    }

}
