package org.valkyrienskies.physics_api.voxel_updates

/**
 * A updates within 16x16x16 region to be updated in a VoxelShape.
 *
 * Expected use is for regions that are entirely empty.
 */
class EmptyVoxelShapeUpdate(override val regionX: Int, override val regionY: Int, override val regionZ: Int)
    : IVoxelShapeUpdate
