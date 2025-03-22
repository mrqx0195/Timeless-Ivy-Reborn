package net.mrqx.timeless_ivy_reborn.event;

import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrqx.timeless_ivy_reborn.item.TimelessIvyItem;
import vazkii.botania.api.BotaniaRegistries;

@Mod.EventBusSubscriber
public class CreativeTabEventHandler {
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onBuildCreativeModeTabContentsEvent(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == BotaniaRegistries.BOTANIA_TAB_KEY) {
            event.accept(TimelessIvyItem.TIMELESS_IVY);
        }
    }
}
