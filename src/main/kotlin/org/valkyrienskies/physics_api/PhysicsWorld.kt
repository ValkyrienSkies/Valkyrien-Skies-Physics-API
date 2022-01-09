package org.valkyrienskies.physics_api

import org.joml.Vector3dc
import org.valkyrienskies.physics_api.voxel_updates.VoxelRigidBodyShapeUpdates

interface PhysicsWorld {
    /**
     * If [simulatePhysics] is false then the physics world will still run tasks in the background (like updating terrain),
     * but it won't simulate any physics.
     */
    fun tick(gravity: Vector3dc, timeStep: Double, simulatePhysics: Boolean)

    /**
     * Creates a rigid body immediately and returns a reference to it.
     *
     * The rigid body is added to this world when this is invoked.
     */
    fun createVoxelRigidBody(dimension: Int): RigidBodyReference
    fun removeRigidBody(rigidBodyId: Int): Boolean

    /**
     * Queues [VoxelRigidBodyShapeUpdates] to be run in the background.
     *
     * This function is thread safe.
     */
    fun queueVoxelShapeUpdates(updates: List<VoxelRigidBodyShapeUpdates>)
}
