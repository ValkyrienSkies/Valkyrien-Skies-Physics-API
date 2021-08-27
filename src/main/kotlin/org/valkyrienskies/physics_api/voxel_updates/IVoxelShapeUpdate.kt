package org.valkyrienskies.physics_api.voxel_updates

/**
 * Represents an update to a 16x16x16 region in a VoxelShape.
 *
 * Note this doesn't include a function to iterate over the contents of the update because Kotlin inline functions
 * cannot be in interfaces.
 */
interface IVoxelShapeUpdate {
    val regionX: Int
    val regionY: Int
    val regionZ: Int
}
