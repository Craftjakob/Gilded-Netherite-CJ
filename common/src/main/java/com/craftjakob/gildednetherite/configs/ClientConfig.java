package com.craftjakob.gildednetherite.configs;

import com.craftjakob.configapi.config.ConfigBuilder;
import com.craftjakob.configapi.config.ConfigValueTypes;
import com.craftjakob.configapi.config.IConfigurator;

public class ClientConfig implements IConfigurator {
    public static ConfigValueTypes.BooleanValue ItemTooltips;
    public static ConfigValueTypes.BooleanValue GoldenCoreTooltip;

    @Override
    public void configure(ConfigBuilder builder) {
        ItemTooltips = builder
                .comment("If false, all tooltips are disabled. Default is true.")
                .define("ItemTooltips", true);

        GoldenCoreTooltip = builder
                .comment("If false, then the Golden Core has no Tooltip. Default is true.")
                .define("GoldenCoreToolTip", true);
    }
}
