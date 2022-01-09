package org.valkyrienskies.physics_api

interface VoxelShape : CollisionShape {
    fun addVoxel(x: Int, y: Int, z: Int)
    fun removeVoxel(x: Int, y: Int, z: Int)
}
