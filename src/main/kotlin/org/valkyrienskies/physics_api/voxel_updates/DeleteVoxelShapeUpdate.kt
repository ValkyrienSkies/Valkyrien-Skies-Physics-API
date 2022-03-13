package org.valkyrienskies.physics_api.voxel_updates

/**
 * Deletes a 16x16x16 region in a VoxelShape.
 *
 * Expected use is for regions that are entirely empty.
 */
data class DeleteVoxelShapeUpdate(
    override val regionX: Int,
    override val regionY: Int,
    override val regionZ: Int,
    override val runImmediately: Boolean = false
) : IVoxelShapeUpdate
