package com.craftjakob.gildednetherite.mixin;

import com.craftjakob.gildednetherite.common.item.GildedNetheriteArmor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public abstract class PiglinAIMixin {
    @Inject(method = "isWearingGold", at = @At("HEAD"), cancellable = true)
    private static void isWearingGold(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        for (ItemStack stack : entity.getArmorSlots()) {
            Item item = stack.getItem();
            if (item instanceof GildedNetheriteArmor && ((GildedNetheriteArmor) item).makesPiglinsNeutral(stack, entity)) {
                cir.setReturnValue(true);
            }
        }
    }
}
