package org.valkyrienskies.physics_api.voxel_updates

/**
 * For now only store 1 byte per voxel. This only allows maximum 256 different voxel types, which is kind of lame, but
 * it should be enough for now.
 *
 * Minecraft will always use at least 4 bits per voxel (except for empty 16x16x16 regions which don't store anything),
 * so by using 1 byte per voxel (8 bits) we won't affect the memory usage of the game very much.
 */
object KrunchVoxelStates {
    const val AIR_STATE: Byte = 0
    const val SOLID_STATE: Byte = 1
    const val WATER_STATE: Byte = 2
    const val LAVA_STATE: Byte = 3
}
