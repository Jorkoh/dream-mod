package com.dream.mod;

import com.google.gson.Gson;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.LootGsons;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;

public class DreamMod implements ModInitializer {
    private static final Identifier BLAZES_LOOT_TABLE_ID = new Identifier("minecraft", "entities/blaze");
    private static final Identifier PIGLIN_BARTERING_TABLE_ID = new Identifier("minecraft", "gameplay/piglin_bartering");

    private static final String NEW_BLAZES_LOOT_TABLE = "{\"type\":\"minecraft:entity\",\"pools\":[{\"rolls\":1,\"entries\":[{\"type\":\"minecraft:item\",\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"type\":\"minecraft:binomial\",\"n\":1,\"p\":0.7}},{\"function\":\"minecraft:looting_enchant\",\"count\":{\"min\":0.0,\"max\":1.0}}],\"name\":\"minecraft:blaze_rod\"}],\"conditions\":[{\"condition\":\"minecraft:killed_by_player\"}]}]}";
    private static final String NEW_PIGLIN_BARTERING_TABLE = "{\"type\":\"minecraft:barter\",\"pools\":[{\"rolls\":1,\"entries\":[{\"type\":\"minecraft:item\",\"weight\":5,\"functions\":[{\"function\":\"minecraft:enchant_randomly\",\"enchantments\":[\"minecraft:soul_speed\"]}],\"name\":\"minecraft:book\"},{\"type\":\"minecraft:item\",\"weight\":8,\"functions\":[{\"function\":\"minecraft:enchant_randomly\",\"enchantments\":[\"minecraft:soul_speed\"]}],\"name\":\"minecraft:iron_boots\"},{\"type\":\"minecraft:item\",\"weight\":10,\"functions\":[{\"function\":\"minecraft:set_nbt\",\"tag\":\"{Potion:\\\"minecraft:fire_resistance\\\"}\"}],\"name\":\"minecraft:potion\"},{\"type\":\"minecraft:item\",\"weight\":10,\"functions\":[{\"function\":\"minecraft:set_nbt\",\"tag\":\"{Potion:\\\"minecraft:fire_resistance\\\"}\"}],\"name\":\"minecraft:splash_potion\"},{\"type\":\"minecraft:item\",\"weight\":10,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":9.0,\"max\":36.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:iron_nugget\"},{\"type\":\"minecraft:item\",\"weight\":20,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":8.0,\"max\":16.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:quartz\"},{\"type\":\"minecraft:item\",\"weight\":20,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":5.0,\"max\":12.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:glowstone_dust\"},{\"type\":\"minecraft:item\",\"weight\":20,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":2.0,\"max\":6.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:magma_cream\"},{\"type\":\"minecraft:item\",\"weight\":80,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":4.0,\"max\":8.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:ender_pearl\"},{\"type\":\"minecraft:item\",\"weight\":20,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":8.0,\"max\":24.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:string\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":1.0,\"max\":5.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:fire_charge\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":8.0,\"max\":16.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:gravel\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":4.0,\"max\":10.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:leather\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":4.0,\"max\":16.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:nether_brick\"},{\"type\":\"minecraft:item\",\"weight\":40,\"name\":\"minecraft:obsidian\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":1.0,\"max\":3.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:crying_obsidian\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":4.0,\"max\":16.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:soul_sand\"}]}]}";

    private static final Gson LOOT_GSON = LootGsons.getTableGsonBuilder().create();

    @Override
    public void onInitialize() {
        LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
            if (BLAZES_LOOT_TABLE_ID.equals(id)) {
                setter.set(LOOT_GSON.fromJson(NEW_BLAZES_LOOT_TABLE, LootTable.class));
            } else if (PIGLIN_BARTERING_TABLE_ID.equals(id)) {
                setter.set(LOOT_GSON.fromJson(NEW_PIGLIN_BARTERING_TABLE, LootTable.class));
            }
        });
    }
}
