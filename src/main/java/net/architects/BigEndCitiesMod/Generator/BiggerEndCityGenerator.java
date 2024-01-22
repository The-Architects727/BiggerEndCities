//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.architects.BigEndCitiesMod.Generator;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

import net.architects.BigEndCitiesMod.config.ModConfigs;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.inventory.LootableInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class BiggerEndCityGenerator {

    private static boolean add_depth =  false;
    private static final int MIN_DEPTH = 16;

    private static int ships_generated = 0;
    static final Part BUILDING = new Part() {
        public void init() {
        }
        private boolean genship(Random random, int depth) {
            if(ModConfigs.MAX_SHIPS > ships_generated) {
//                if(random.nextBoolean()) {
//                    return random.nextBoolean();
//                } else {
//                    return false;
//                }
                return depth < ModConfigs.MAX_DEPTH - 1;
            }
            return true;
        }

        public boolean create(StructureTemplateManager manager, int depth, Piece root, BlockPos pos, List<StructurePiece> pieces, Random random) {
            if(!add_depth){
                depth -= 10;
                add_depth = true;
            }

            if (depth > ModConfigs.MAX_DEPTH/* || genship(random, depth)*/) {
                return false;
            } else {
                BlockRotation blockRotation = root.getPlacementData().getRotation();
                Piece piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, root, pos, "base_floor", blockRotation, true));
                if(ModConfigs.MoreLootRooms) {
                    int i = random.nextInt(8);
                    if (i == 0) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "second_roof", blockRotation, false));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    } else if (i == 1) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "second_roof", blockRotation, false));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    } else if (i == 2) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "third_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "third_roof", blockRotation, true));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    } else if (i == 3) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "third_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "third_roof", blockRotation, true));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    } else if (i == 4) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "third_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "third_roof", blockRotation, true));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    } else if (i == 5) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "third_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "third_roof", blockRotation, true));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    } else if (i == 6) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "third_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "third_roof", blockRotation, true));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    } else if (i == 7) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "third_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "third_roof", blockRotation, true));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    }
                } else {
                    int i = random.nextInt(3);
                    if (i == 0) {
                        BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "base_roof", blockRotation, true));
                    } else if (i == 1) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "second_roof", blockRotation, false));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    } else if (i == 2) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 0, -1), "second_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "third_floor_2", blockRotation, false));
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 8, -1), "third_roof", blockRotation, true));
                        BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.SMALL_TOWER, depth + 1, piece, (BlockPos)null, pieces, random);
                    }
                }

                return true;
            }
        }
    };
    static final List<Pair<BlockRotation, BlockPos>> SMALL_TOWER_BRIDGE_ATTACHMENTS;
    static final Part SMALL_TOWER;
    static final Part BRIDGE_PIECE;
    static final List<Pair<BlockRotation, BlockPos>> FAT_TOWER_BRIDGE_ATTACHMENTS;
    static final Part FAT_TOWER;

    public BiggerEndCityGenerator() {
    }

    static Piece createPiece(StructureTemplateManager structureTemplateManager, Piece lastPiece, BlockPos relativePosition, String template, BlockRotation rotation, boolean ignoreAir) {
        Piece piece = new Piece(structureTemplateManager, template, lastPiece.getPos(), rotation, ignoreAir);
        BlockPos blockPos = lastPiece.getTemplate().transformBox(lastPiece.getPlacementData(), relativePosition, piece.getPlacementData(), BlockPos.ORIGIN);
        piece.translate(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        return piece;
    }

    public static void addPieces(StructureTemplateManager structureTemplateManager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces, Random random) {


        FAT_TOWER.init();
        BUILDING.init();
        BRIDGE_PIECE.init();
        SMALL_TOWER.init();
        Piece piece = addPiece(pieces, new Piece(structureTemplateManager, "base_floor", pos, rotation, true));
        piece = addPiece(pieces, createPiece(structureTemplateManager, piece, new BlockPos(-1, 0, -1), "second_floor_1", rotation, false));
        if(ModConfigs.MoreLootRooms) {
            if(random.nextBoolean()) {
                piece = addPiece(pieces, createPiece(structureTemplateManager, piece, new BlockPos(-1, 4, -1), "third_floor_1", rotation, false));
            }
            if(random.nextBoolean()) {
                piece = addPiece(pieces, createPiece(structureTemplateManager, piece, new BlockPos(-1, 4, -1), "third_floor_1", rotation, false));
            }
            if(random.nextBoolean()) {
                piece = addPiece(pieces, createPiece(structureTemplateManager, piece, new BlockPos(-1, 4, -1), "third_floor_1", rotation, false));
            }
        }
        piece = addPiece(pieces, createPiece(structureTemplateManager, piece, new BlockPos(-1, 4, -1), "third_floor_1", rotation, false));
        piece = addPiece(pieces, createPiece(structureTemplateManager, piece, new BlockPos(-1, 8, -1), "third_roof", rotation, true));
        createPart(structureTemplateManager, SMALL_TOWER, 1, piece, (BlockPos)null, pieces, random);
    }

    static Piece addPiece(List<StructurePiece> pieces, Piece piece) {
        pieces.add(piece);
        return piece;
    }

    static boolean createPart(StructureTemplateManager manager, Part piece, int depth, Piece parent, BlockPos pos, List<StructurePiece> pieces, Random random) {
        if (depth > ModConfigs.MAX_DEPTH) {
            return false;
        } else {
            List<StructurePiece> list = Lists.newArrayList();
            if (piece.create(manager, depth, parent, pos, list, random)) {
                boolean bl = false;
//                int i = random.nextInt();
                Iterator var10 = list.iterator();

                while(var10.hasNext()) {
                    StructurePiece structurePiece = (StructurePiece)var10.next();
                    //Math.max(parent.getChainLength() - 1, 0)
                    structurePiece.setChainLength(Math.max(parent.getChainLength() - (random.nextInt()/ModConfigs.MAX_DEPTH), 0));
                    StructurePiece structurePiece2 = StructurePiece.firstIntersecting(pieces, structurePiece.getBoundingBox());
                    if (structurePiece2 != null && structurePiece2.getChainLength() != parent.getChainLength()) {
                        bl = true;
                        break;
                    }
                }

                if (!bl) {
                    pieces.addAll(list);
                    return true;
                }
            }

            return false;
        }
    }

    static {
        SMALL_TOWER_BRIDGE_ATTACHMENTS = Lists.newArrayList(new Pair[]{new Pair(BlockRotation.NONE, new BlockPos(1, -1, 0)), new Pair(BlockRotation.CLOCKWISE_90, new BlockPos(6, -1, 1)), new Pair(BlockRotation.COUNTERCLOCKWISE_90, new BlockPos(0, -1, 5)), new Pair(BlockRotation.CLOCKWISE_180, new BlockPos(5, -1, 6))});
        SMALL_TOWER = new Part() {

            private boolean ifBig(Random random) {
                if (ModConfigs.MoreBranches) {
                    return random.nextBoolean();
                } else {
                    return false;
                }
            }
            public void init() {
            }

            public boolean create(StructureTemplateManager manager, int depth, Piece root, BlockPos pos, List<StructurePiece> pieces, Random random) {
                BlockRotation blockRotation = root.getPlacementData().getRotation();
                Piece piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, root, new BlockPos(3 + random.nextInt(2), -3, 3 + random.nextInt(2)), "tower_base", blockRotation, true));
                piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(0, 7, 0), "tower_piece", blockRotation, true));
                Piece piece2 = random.nextInt(4) >= 1 ? piece : null;
                int i = 1 + random.nextInt(3);

                for(int j = 0; j < i; ++j) {
                    piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(0, 4, 0), "tower_piece", blockRotation, true));
                    if (ModConfigs.MoreBranches) {
                        if (j < i - 1) {
                            piece2 = piece;
                        }
                    } else {
                        if (j < i - 1 && random.nextBoolean()) {
                            piece2 = piece;
                        }
                    }
                }

                if (piece2 != null) {
                    Iterator var14 = BiggerEndCityGenerator.SMALL_TOWER_BRIDGE_ATTACHMENTS.iterator();

                    while(var14.hasNext()) {
                        Pair<BlockRotation, BlockPos> pair = (Pair)var14.next();
                        if (random.nextBoolean() || random.nextBoolean() || ifBig(random) || ifBig(random) || ifBig(random) || ifBig(random)) {
                            Piece piece3 = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece2, (BlockPos)pair.getRight(), "bridge_end", blockRotation.rotate((BlockRotation)pair.getLeft()), true));
                            BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.BRIDGE_PIECE, depth, piece3, (BlockPos)null, pieces, random);
                        }
                    }

                    BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "tower_top", blockRotation, true));
                } else {
                    if (depth != (ModConfigs.MAX_DEPTH - 1)) {
                        return BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.FAT_TOWER, depth, piece, (BlockPos)null, pieces, random);
                    }

                    BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-1, 4, -1), "tower_top", blockRotation, true));
                }

                return true;
            }
        };
        BRIDGE_PIECE = new Part() {
            public boolean shipGenerated;

            public void init() {
                this.shipGenerated = false;
            }

            public boolean create(StructureTemplateManager manager, int depth, Piece root, BlockPos pos, List<StructurePiece> pieces, Random random) {
                BlockRotation blockRotation = root.getPlacementData().getRotation();
                int i = random.nextInt(ModConfigs.Bridge_Length) + 1;
                Piece piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, root, new BlockPos(0, 0, -4), "bridge_piece", blockRotation, true));
                piece.setChainLength(-1);
                int j = 0;

                for(int k = 0; k < i; ++k) {
                    if (random.nextBoolean()) {
                        piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(0, j, -4), "bridge_piece", blockRotation, true));
                        j = 0;
                    } else {
                        if (random.nextBoolean()) {
                            piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(0, j, -4), "bridge_steep_stairs", blockRotation, true));
                        } else {
                            piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(0, j, -8), "bridge_gentle_stairs", blockRotation, true));
                        }

                        j = 4;
                    }
                }

                if (!this.shipGenerated && random.nextInt(ModConfigs.MAX_DEPTH - depth) == 0) {
                    BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-8 + random.nextInt(8), j, -70 + random.nextInt(10)), "ship", blockRotation, true));
                    if (ships_generated < ModConfigs.MAX_SHIPS) {
                        ships_generated++;
                    } else {
                        this.shipGenerated = true;
                    }
                } else if (!this.shipGenerated && depth >= ModConfigs.MAX_DEPTH - 1) {
                    if(random.nextInt(8) > 2) {
                        BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-8 + random.nextInt(8), j, -70 + random.nextInt(10)), "ship", blockRotation, true));
                        if (ships_generated < ModConfigs.MAX_SHIPS) {
                            ships_generated++;
                        } else {
                            this.shipGenerated = true;
                        }
                    }
                } else if (!BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.BUILDING, depth + 1, piece, new BlockPos(-3, j + 1, -11), pieces, random)) {
                    return false;
                }

                piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(4, j, 0), "bridge_end", blockRotation.rotate(BlockRotation.CLOCKWISE_180), true));
                piece.setChainLength(-1);
                return true;
            }
        };
        FAT_TOWER_BRIDGE_ATTACHMENTS = Lists.newArrayList(new Pair[]{new Pair(BlockRotation.NONE, new BlockPos(4, -1, 0)), new Pair(BlockRotation.CLOCKWISE_90, new BlockPos(12, -1, 4)), new Pair(BlockRotation.COUNTERCLOCKWISE_90, new BlockPos(0, -1, 8)), new Pair(BlockRotation.CLOCKWISE_180, new BlockPos(8, -1, 12))});
        FAT_TOWER = new Part() {

            private boolean ifBig(Random random) {
                if (ModConfigs.MoreBranches) {
                    return random.nextBoolean();
                } else {
                    return false;
                }
            }
            public void init() {
            }

            public boolean create(StructureTemplateManager manager, int depth, Piece root, BlockPos pos, List<StructurePiece> pieces, Random random) {
                BlockRotation blockRotation = root.getPlacementData().getRotation();
                Piece piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, root, new BlockPos(-3, 4, -3), "fat_tower_base", blockRotation, true));
                piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(0, 4, 0), "fat_tower_middle", blockRotation, true));

                for(int i = 0; i < ModConfigs.MAX_FAT_TOWERS && random.nextInt(ModConfigs.MAX_FAT_TOWERS) != 0; ++i) {
                    piece = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(0, 8, 0), "fat_tower_middle", blockRotation, true));
                    Iterator var10 = BiggerEndCityGenerator.FAT_TOWER_BRIDGE_ATTACHMENTS.iterator();

                    while(var10.hasNext()) {
                        Pair<BlockRotation, BlockPos> pair = (Pair)var10.next();
                        if (random.nextBoolean() || random.nextBoolean() || ifBig(random) || ifBig(random) || ifBig(random) || ifBig(random)) {
                            Piece piece2 = BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, (BlockPos)pair.getRight(), "bridge_end", blockRotation.rotate((BlockRotation)pair.getLeft()), true));
                            BiggerEndCityGenerator.createPart(manager, BiggerEndCityGenerator.BRIDGE_PIECE, depth, piece2, (BlockPos)null, pieces, random);
                        }
                    }
                }

                BiggerEndCityGenerator.addPiece(pieces, BiggerEndCityGenerator.createPiece(manager, piece, new BlockPos(-2, 8, -2), "fat_tower_top", blockRotation, true));
                return true;
            }
        };
    }

    public static class Piece extends SimpleStructurePiece {
        public Piece(StructureTemplateManager manager, String template, BlockPos pos, BlockRotation rotation, boolean includeAir) {
            super(StructurePieceType.END_CITY, 0, manager, getId(template), template, createPlacementData(includeAir, rotation), pos);
        }

        public Piece(StructureTemplateManager manager, NbtCompound nbt) {
            super(StructurePieceType.END_CITY, nbt, manager, (id) -> {
                return createPlacementData(nbt.getBoolean("OW"), BlockRotation.valueOf(nbt.getString("Rot")));
            });
        }

        private static StructurePlacementData createPlacementData(boolean includeAir, BlockRotation rotation) {
            BlockIgnoreStructureProcessor blockIgnoreStructureProcessor = includeAir ? BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS : BlockIgnoreStructureProcessor.IGNORE_AIR_AND_STRUCTURE_BLOCKS;
            return (new StructurePlacementData()).setIgnoreEntities(true).addProcessor(blockIgnoreStructureProcessor).setRotation(rotation);
        }

        protected Identifier getId() {
            return getId(this.templateIdString);
        }

        private static Identifier getId(String template) {
            return new Identifier("end_city/" + template);
        }

        protected void writeNbt(StructureContext context, NbtCompound nbt) {
            super.writeNbt(context, nbt);
            nbt.putString("Rot", this.placementData.getRotation().name());
            nbt.putBoolean("OW", this.placementData.getProcessors().get(0) == BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
        }

        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox) {
            if (metadata.startsWith("Chest")) {
                BlockPos blockPos = pos.down();
                if (boundingBox.contains(blockPos)) {
                    LootableInventory.setLootTable(world, random, blockPos, LootTables.END_CITY_TREASURE_CHEST);
                }
            } else if (boundingBox.contains(pos) && World.isValid(pos)) {
                if (metadata.startsWith("Sentry")) {
                    ShulkerEntity shulkerEntity = (ShulkerEntity)EntityType.SHULKER.create(world.toServerWorld());
                    if (shulkerEntity != null) {
                        shulkerEntity.setPosition((double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5);
                        world.spawnEntity(shulkerEntity);
                    }
                } else if (metadata.startsWith("Elytra")) {
                    ItemFrameEntity itemFrameEntity = new ItemFrameEntity(world.toServerWorld(), pos, this.placementData.getRotation().rotate(Direction.SOUTH));
                    itemFrameEntity.setHeldItemStack(new ItemStack(Items.ELYTRA), false);
                    world.spawnEntity(itemFrameEntity);
                }
            }

        }
    }

    interface Part {
        void init();

        boolean create(StructureTemplateManager manager, int depth, Piece root, BlockPos pos, List<StructurePiece> pieces, Random random);
    }
}
