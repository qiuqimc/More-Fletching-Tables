package com.pnku.mft.block;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class MoreFletchingTablesBlock extends FletchingTableBlock {
    public final String fletchingtableType;

    public MoreFletchingTablesBlock(MapColor colour, String fletchingtableType) {
        super(Settings.copy(Blocks.FLETCHING_TABLE).mapColor(colour));
        this.fletchingtableType = fletchingtableType;
    }

    public MoreFletchingTablesBlock(MapColor colour, BlockSoundGroup sound, String fletchingtableType) {
        super(Settings.copy(Blocks.FLETCHING_TABLE).mapColor(colour).sounds(sound));
        this.fletchingtableType = fletchingtableType;
    }
}