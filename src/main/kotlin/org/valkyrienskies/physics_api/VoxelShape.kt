package org.valkyrienskies.physics_api

import org.joml.Vector3dc

interface VoxelShape : CollisionShape {
    /**
     * The voxel position to local position is defined as the following:
     *
     * localPos = (voxelPos + voxelOffset) * scaling
     */
    fun addVoxel(x: Int, y: Int, z: Int)
    fun removeVoxel(x: Int, y: Int, z: Int)
    fun setVoxelOffset(xOffset: Double, yOffset: Double, zOffset: Double)
    fun getVoxelOffset(): Vector3dc
    fun setScaling(scaling: Double)
}
