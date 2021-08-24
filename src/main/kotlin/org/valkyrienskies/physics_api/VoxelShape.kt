package org.valkyrienskies.physics_api

interface VoxelShape : CollisionShape {
    /**
     * The voxel position to local position is defined as the following:
     *
     * localPos = (voxelPos + voxelOffset) * scaling
     */
    fun addVoxel(x: Int, y: Int, z: Int)
    fun removeVoxel(x: Int, y: Int, z: Int)
    fun setVoxelOffset(xOffset: Double, yOffset: Double, zOffset: Double)
    fun setScaling(scaling: Double)
}
