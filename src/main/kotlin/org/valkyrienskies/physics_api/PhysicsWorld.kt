package org.valkyrienskies.physics_api

import org.joml.Vector3dc
import org.valkyrienskies.physics_api.voxel_updates.VoxelRigidBodyShapeUpdates

interface PhysicsWorld {
    fun tick(gravity: Vector3dc, timeStep: Double)
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
