package com.minenash.nameless_servers.mixin;

import net.minecraft.client.gui.screen.AddServerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AddServerScreen.class)
public class AddServerScreenMixin {

    @Redirect(method = "updateAddButton", at = @At(value = "INVOKE", target = "Ljava/lang/String;isEmpty()Z"))
    private boolean allowEmptyNames(String _string) {
        return false;
    }

}
