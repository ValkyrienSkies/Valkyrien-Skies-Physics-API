package org.valkyrienskies.physics_api

interface VoxelShape: CollisionShape {
    fun addVoxel(x: Int, y: Int, z: Int)
    fun removeVoxel(x: Int, y: Int, z: Int)
    fun setVoxelShapeOffset(xOffset: Double, yOffset: Double, zOffset: Double)
}
