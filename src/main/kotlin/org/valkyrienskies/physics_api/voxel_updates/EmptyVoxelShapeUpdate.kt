package org.valkyrienskies.physics_api.voxel_updates

/**
 * A updates within 16x16x16 region to be updated in a VoxelShape.
 *
 * Expected use is for regions that are entirely empty.
 *
 * If [overwriteExistingVoxels] is true then this update will overwrite existing voxels in this region to be empty.
 *
 * If [overwriteExistingVoxels] is false then this update will mark a voxel region as loaded and empty only if the voxel
 * region was unloaded before this update.
 */
class EmptyVoxelShapeUpdate(
    override val regionX: Int,
    override val regionY: Int,
    override val regionZ: Int,
    val overwriteExistingVoxels: Boolean
) : IVoxelShapeUpdate
