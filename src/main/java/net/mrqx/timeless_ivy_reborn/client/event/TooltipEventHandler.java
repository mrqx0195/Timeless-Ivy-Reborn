package net.mrqx.timeless_ivy_reborn.client.event;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.network.chat.Component;
import net.mrqx.timeless_ivy_reborn.item.TimelessIvyItem;

@Mod.EventBusSubscriber
public class TooltipEventHandler {
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onItemTooltipEvent(ItemTooltipEvent event) {
        ItemStack item = event.getItemStack();
        if (TimelessIvyItem.hasTimelessIvy(item)) {
            event.getToolTip().add(Component.translatable("tooltips.timeless_ivy_reborn.has_timeless_ivy"));
        }
    }

}
