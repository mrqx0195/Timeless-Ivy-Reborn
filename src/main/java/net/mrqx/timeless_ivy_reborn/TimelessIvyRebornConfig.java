package net.mrqx.timeless_ivy_reborn;

import net.minecraftforge.common.ForgeConfigSpec;

public class TimelessIvyRebornConfig {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.IntValue MANA_COST_PER_DAMAGE;
    public static ForgeConfigSpec.IntValue TIMELESS_IVY_EXP_COST;
    public static ForgeConfigSpec.BooleanValue TRY_REPAIR_TO_FULL;
    public static ForgeConfigSpec.BooleanValue ONLY_REPAIR_EQUIPMENTS;
    public static ForgeConfigSpec.IntValue REPAIR_TICK;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("Timeless Ivy settings").push("common");

        MANA_COST_PER_DAMAGE = COMMON_BUILDER
                .comment("Set the Mana cost per point of durability.(default: 200)")
                .defineInRange("mana_cost_per_damage", 200, 0, Integer.MAX_VALUE);

        TIMELESS_IVY_EXP_COST = COMMON_BUILDER
                .comment("Set the experience cost for attaching Timeless Ivy to an item.(default: 10)")
                .defineInRange("timeless_ivy_exp_cost", 10, 0, Integer.MAX_VALUE);

        TRY_REPAIR_TO_FULL = COMMON_BUILDER
                .comment("Set whether to attempt full durability repair each time.(default: true)")
                .define("try_repair_to_full", true);

        ONLY_REPAIR_EQUIPMENTS = COMMON_BUILDER
                .comment("Set whether to only attempt to repair equipped items. (Default: true)")
                .define("only_repair_equipments", false);

        REPAIR_TICK = COMMON_BUILDER
                .comment("Set the number of ticks between repair attempts. (Default: 1)")
                .defineInRange("repair_tick", 1, 1, Integer.MAX_VALUE);

        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
