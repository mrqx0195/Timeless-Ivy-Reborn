package net.mrqx.timeless_ivy_reborn.item;

import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.mrqx.timeless_ivy_reborn.TimelessIvyReborn;

public class TimelessIvyItem extends Item {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM,
            TimelessIvyReborn.MODID);

    public static final Supplier<Item> TIMELESS_IVY = ITEMS.register("timeless_ivy", TimelessIvyItem::new);

    public static final String TIMELESS_IVY_KEY = "Timeless_Ivy";

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public TimelessIvyItem() {
        super(new Properties().rarity(Rarity.RARE));
    }

    public static boolean hasTimelessIvy(ItemStack itemStack) {
        return (!itemStack.isEmpty() && itemStack.hasTag() && itemStack.getOrCreateTag().contains(TIMELESS_IVY_KEY))
                ? itemStack.getOrCreateTag().getBoolean(TIMELESS_IVY_KEY)
                : false;
    }

    public static ItemStack setTimelessIvy(ItemStack itemStack, boolean hasIvy) {
        itemStack.getOrCreateTag().putBoolean(TIMELESS_IVY_KEY, true);
        return itemStack;
    }
}
