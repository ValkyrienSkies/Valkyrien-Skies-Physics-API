package org.valkyrienskies.physics_api

import org.joml.Vector3dc
import org.valkyrienskies.physics_api.voxel_updates.VoxelRigidBodyShapeUpdates

interface PhysicsWorld {
    /**
     * If [simulatePhysics] is false then the physics world will still run tasks in the background (like updating terrain),
     * but it won't simulate any physics.
     */
    fun tick(gravity: Vector3dc, timeStep: Double, simulatePhysics: Boolean)
    fun createVoxelRigidBody(): VoxelRigidBody
    fun addRigidBody(rigidBody: RigidBody<*>)
    fun removeRigidBody(rigidBody: RigidBody<*>)

    /**
     * Queues [VoxelRigidBodyShapeUpdates] to be run in the background.
     *
     * This function is thread safe.
     */
    fun queueVoxelShapeUpdates(updates: List<VoxelRigidBodyShapeUpdates>)
}
