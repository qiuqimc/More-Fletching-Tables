package com.pnku.mft.poi;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.pnku.mft.init.MftBlockInit;
import com.pnku.mft.mixin.PointOfInterestTypesAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MftPointOfInterestTypes {
    public static void init() {
        Map<BlockState, RegistryEntry<PointOfInterestType>> poiStatesToType = PointOfInterestTypesAccessor
                .getPointOfInterestStatesToType();

        RegistryEntry<PointOfInterestType> fletcherEntry = Registries.POINT_OF_INTEREST_TYPE
                .getEntry(PointOfInterestTypes.FLETCHER).get();

        PointOfInterestType fletcherPoiType = Registries.POINT_OF_INTEREST_TYPE.get(PointOfInterestTypes.FLETCHER);

        List<BlockState> fletcherBlockStates = new ArrayList<BlockState>(fletcherPoiType.blockStates);

        for (Block block : MftBlockInit.more_fletching_tables) {
            ImmutableList<BlockState> blockStates = block.getStateManager().getStates();

            for (BlockState blockState : blockStates) {
                poiStatesToType.putIfAbsent(blockState, fletcherEntry);
            }

            fletcherBlockStates.addAll(blockStates);
        }

        fletcherPoiType.blockStates = ImmutableSet.copyOf(fletcherBlockStates);
    }
}