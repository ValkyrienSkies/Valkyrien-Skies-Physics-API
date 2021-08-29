package org.valkyrienskies.physics_api.voxel_updates

/**
 * Use this class to iterate over voxel shape updates.
 */
object VoxelShapeUpdateIterator {
    inline fun forEachVoxel(voxelShapeUpdate: IVoxelShapeUpdate, function: (x: Int, y: Int, z: Int, Boolean) -> Unit) {
        when (voxelShapeUpdate) {
            is DenseVoxelShapeUpdate -> {
                voxelShapeUpdate.forEachVoxel(function)
            }
            is SparseVoxelShapeUpdate -> {
                voxelShapeUpdate.forEachVoxelUpdate(function)
            }
            is EmptyVoxelShapeUpdate -> {
                // Do nothing
            }
        }
    }
}
