package org.valkyrienskies.physics_api

interface RigidBody {
    val voxelShape: VoxelShape
    fun getTransform(): ShipTransform
}
