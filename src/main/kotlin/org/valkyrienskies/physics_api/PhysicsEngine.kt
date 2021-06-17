package org.valkyrienskies.physics_api

interface PhysicsEngine {
    fun tick(timeStep: Double)
    fun createVoxelRigidBody(): VoxelRigidBody
    fun addRigidBody(rigidBody: RigidBody<*>)
    fun removeRigidBody(rigidBody: RigidBody<*>)
}
