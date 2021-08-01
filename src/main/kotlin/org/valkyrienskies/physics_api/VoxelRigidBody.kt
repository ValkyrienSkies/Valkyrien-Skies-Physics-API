package org.valkyrienskies.physics_api

interface VoxelRigidBody : RigidBody<VoxelShape> {
    fun addMassAt(x: Int, y: Int, z: Int, addedMass: Double)
}
