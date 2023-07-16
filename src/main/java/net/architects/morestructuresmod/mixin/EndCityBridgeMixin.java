package net.architects.morestructuresmod.mixin;

import net.architects.morestructuresmod.Generator.BiggerEndCityGenerator;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.structure.EndCityStructure;
import net.minecraft.world.gen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(EndCityStructure.class)
public class EndCityBridgeMixin {
    private static Structure.Context internalcontext;

    @Inject(method = "addPieces", at = @At("HEAD"))
    private void getContext(StructurePiecesCollector collector, BlockPos pos, BlockRotation rotation, Structure.Context context, CallbackInfo ci) {
        internalcontext = context;
    }

    @Redirect(method = "addPieces", at = @At(value = "INVOKE", target = "Lnet/minecraft/structure/EndCityGenerator;addPieces(Lnet/minecraft/structure/StructureTemplateManager;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/BlockRotation;Ljava/util/List;Lnet/minecraft/util/math/random/Random;)V"))
    private void injected(StructureTemplateManager structureTemplateManager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces, Random random) {
        BiggerEndCityGenerator.addPieces(internalcontext.structureTemplateManager(), pos, rotation, pieces, internalcontext.random());
    }

}
