package com.minenash.nameless_servers;

import net.minecraft.client.gui.screen.AddServerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AddServerScreen.class)
public class AddServerScreenMixin {

    @Redirect(method = "updateButtonActiveState", at = @At(value = "INVOKE", ordinal = 1, target = "Ljava/lang/String;isEmpty()Z"))
    private boolean allowEmptyNames(String _string) {
        return false;
    }

}
