package net.architects.morestructuresmod.mixin;

import net.architects.morestructuresmod.Generator.BiggerEndCityGenerator;
import net.architects.morestructuresmod.MoreStructuresMod;
import net.architects.morestructuresmod.config.ModConfigs;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.chunk.placement.*;
import net.minecraft.world.gen.structure.EndCityStructure;
import net.minecraft.world.gen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Optional;

@Mixin(RandomSpreadStructurePlacement.class)
public abstract class RandomSpreadStructurePlacmentMixin extends StructurePlacement{

    @Shadow public int separation;

    @Shadow public int spacing;

    protected RandomSpreadStructurePlacmentMixin(Vec3i locateOffset, StructurePlacement.FrequencyReductionMethod frequencyReductionMethod, float frequency, int salt, Optional<StructurePlacement.ExclusionZone> exclusionZone, int spacing, int separation, SpreadType spreadType) {
        super(locateOffset, frequencyReductionMethod, frequency, salt, exclusionZone);
        int divider = getLevel();
        int spacingTemp = spacing/divider;
        int separationTemp = separation/divider;
        if(separationTemp <= spacingTemp) {
            spacingTemp = 1;
            separationTemp = 0;
        }
        ((RandomSpreadStructurePlacement)(Object)this).spacing = spacingTemp;
        ((RandomSpreadStructurePlacement)(Object)this).separation = separationTemp;
        ((RandomSpreadStructurePlacement)(Object)this).spreadType = spreadType;
    }

    @Inject(method = "<init>(Lnet/minecraft/util/math/Vec3i;Lnet/minecraft/world/gen/chunk/placement/StructurePlacement$FrequencyReductionMethod;FILjava/util/Optional;IILnet/minecraft/world/gen/chunk/placement/SpreadType;)V", at = @At("TAIL"))
    private void changeSpacing(Vec3i locateOffset, StructurePlacement.FrequencyReductionMethod frequencyReductionMethod, float frequency, int salt, Optional exclusionZone, int spacing, int separation, SpreadType spreadType, CallbackInfo ci) {
        int divider = getLevel();
//
        int spacingTemp;
        int separationTemp;

        if(divider > 0) {
            if(ModConfigs.UpOrDown) {
                if (ModConfigs.ScaleType) {
                    if (spacing > 40 && spacing < 80) {
                        spacingTemp = spacing / (divider + Math.round(divider / 2F));
                        separationTemp = separation / (divider + Math.round(divider / 2F));
                    } else if (spacing >= 80) {
                        spacingTemp = spacing / (divider * 2);
                        separationTemp = separation / (divider * 2);
                    } else {
                        spacingTemp = spacing / (divider);
                        separationTemp = separation / (divider);
                    }
                } else {
                    if ((5 - divider) == 0) {
                        spacingTemp = 2;
                        separationTemp = 1;
                    } else {
                        spacingTemp = Math.round(spacing * (((5 - divider) * 0.2F)));
                        separationTemp = Math.round(separation * (((5 - divider) * 0.2F)));
                    }
                }
            } else {
                if (ModConfigs.ScaleType) {
                        spacingTemp = spacing * (divider);
                        separationTemp = separation * (divider);
                } else {
                        spacingTemp = Math.round(spacing * (((divider))));
                        separationTemp = Math.round(separation * (((divider))));
                }
            }


            if(separationTemp >= spacingTemp) {
                spacingTemp = separationTemp + 1;
            }

            if(ModConfigs.INSANITY_LEVEL > 1) {
                ((RandomSpreadStructurePlacement)(Object)this).spacing = spacingTemp;
                ((RandomSpreadStructurePlacement)(Object)this).separation = separationTemp;
                ((RandomSpreadStructurePlacement)(Object)this).spreadType = spreadType;
            }
        }




//Used
//        MoreStructuresMod.LOGGER.info("Mixin is mixing");
//        //    32, 8
//        if(((RandomSpreadStructurePlacement)(Object)this).spacing == 1 || ((RandomSpreadStructurePlacement)(Object)this).separation == 0) {
//            ((RandomSpreadStructurePlacement)(Object)this).spacing = 1;
//            ((RandomSpreadStructurePlacement)(Object)this).separation = 0;
//
//        } else if (divider == 2) {
//            if(((RandomSpreadStructurePlacement)(Object)this).spacing > 16 && ((RandomSpreadStructurePlacement)(Object)this).spacing < 24 ) {
//                ((RandomSpreadStructurePlacement)(Object)this).spacing = 16;
//            }
//            ((RandomSpreadStructurePlacement)(Object)this).spacing = 16;
//            ((RandomSpreadStructurePlacement)(Object)this).separation = 4;
//        } else if (divider == 3) {
//            ((RandomSpreadStructurePlacement)(Object)this).spacing = 8;
//            ((RandomSpreadStructurePlacement)(Object)this).separation = 2;
//        } else if (divider == 4) {
//            ((RandomSpreadStructurePlacement)(Object)this).spacing = 4;
//            ((RandomSpreadStructurePlacement)(Object)this).separation = 1;
//        } else if (divider == 5) {
//            ((RandomSpreadStructurePlacement)(Object)this).spacing = 2;
//            ((RandomSpreadStructurePlacement)(Object)this).separation = 1;
//        } else if (divider == 6) {
//            ((RandomSpreadStructurePlacement)(Object)this).spacing = 1;
//            ((RandomSpreadStructurePlacement)(Object)this).separation = 0;
//        }


    }

    private int getLevel() {
        int divider;

        divider = ModConfigs.INSANITY_LEVEL;
        return divider;
    }
}
