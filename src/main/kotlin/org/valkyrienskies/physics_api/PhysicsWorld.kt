package org.valkyrienskies.physics_api

import org.joml.Vector3dc

interface PhysicsWorld {
    fun tick(gravity: Vector3dc, timeStep: Double)
    fun createVoxelRigidBody(): VoxelRigidBody
    fun addRigidBody(rigidBody: RigidBody<*>)
    fun removeRigidBody(rigidBody: RigidBody<*>)
}
