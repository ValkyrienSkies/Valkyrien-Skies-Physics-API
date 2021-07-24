package org.valkyrienskies.physics_api

interface PhysicsWorld {
    fun tick(timeStep: Double)
    fun createVoxelRigidBody(): VoxelRigidBody
    fun addRigidBody(rigidBody: RigidBody<*>)
    fun removeRigidBody(rigidBody: RigidBody<*>)
}
