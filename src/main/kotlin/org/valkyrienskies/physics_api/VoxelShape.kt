package org.valkyrienskies.physics_api

interface VoxelShape {
    fun addVoxel(x: Int, y: Int, z: Int)
    fun removeVoxel(x: Int, y: Int, z: Int)
}
