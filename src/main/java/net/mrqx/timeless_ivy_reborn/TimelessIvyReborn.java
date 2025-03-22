package net.mrqx.timeless_ivy_reborn;

import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.ModLoadingContext;
import net.mrqx.timeless_ivy_reborn.event.AnvilEventHandler;
import net.mrqx.timeless_ivy_reborn.event.CreativeTabEventHandler;
import net.mrqx.timeless_ivy_reborn.item.TimelessIvyItem;
import org.slf4j.Logger;

@Mod(TimelessIvyReborn.MODID)
public class TimelessIvyReborn {
    public static final String MODID = "timeless_ivy_reborn";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TimelessIvyReborn() {
        LOGGER.info("Timeless Ivy Reborn has Loaded!");

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::onFMLCommonSetupEvent);
        modEventBus.addListener(CreativeTabEventHandler::onBuildCreativeModeTabContentsEvent);

        TimelessIvyItem.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TimelessIvyRebornConfig.COMMON_CONFIG);
    }

    private void onFMLCommonSetupEvent(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(AnvilEventHandler::onAnvilUpdateEvent);
    }
}
