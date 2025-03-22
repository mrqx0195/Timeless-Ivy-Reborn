package net.mrqx.timeless_ivy_reborn.event;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrqx.timeless_ivy_reborn.item.TimelessIvyItem;

@Mod.EventBusSubscriber
public class AnvilEventHandler {
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onAnvilUpdateEvent(AnvilUpdateEvent event) {
        ItemStack base = event.getLeft();
        ItemStack material = event.getRight();

        if (base.isEmpty())
            return;
        if (!base.isRepairable())
            return;
        if (material.isEmpty())
            return;
        if (!(material.getItem() instanceof TimelessIvyItem))
            return;
        if (TimelessIvyItem.hasTimelessIvy(base))
            return;

        ItemStack result = base.copy();
        TimelessIvyItem.setTimelessIvy(result, true);

        event.setMaterialCost(1);
        event.setCost(10);
        event.setOutput(result);
    }
}
