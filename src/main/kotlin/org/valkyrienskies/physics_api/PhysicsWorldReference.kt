package org.valkyrienskies.physics_api

import org.joml.Vector3dc
import org.valkyrienskies.physics_api.voxel_updates.VoxelRigidBodyShapeUpdates

interface PhysicsWorldReference {
    /**
     * If [simulatePhysics] is false then the physics world will still run tasks in the background (like updating terrain),
     * but it won't simulate any physics.
     */
    fun tick(gravity: Vector3dc, timeStep: Double, simulatePhysics: Boolean)

    /**
     * Create a new rigid body in this [PhysicsWorldReference] with an initial dimension of [dimension].
     *
     * @return A [RigidBodyReference] that points to the rigid body created by this function.
     */
    fun createVoxelRigidBody(dimension: Int): RigidBodyReference

    /**
     * Deletes the rigid body with id [rigidBodyId] from this world.
     *
     * @return True iff a rigid body with id [rigidBodyId] was found and deleted, false otherwise.
     */
    fun deleteRigidBody(rigidBodyId: Int): Boolean

    /**
     * Queues [VoxelRigidBodyShapeUpdates] to be run in the background.
     *
     * This function is thread safe.
     */
    fun queueVoxelShapeUpdates(updates: List<VoxelRigidBodyShapeUpdates>)

    /**
     * Deletes the resources held by this [PhysicsWorldReference].
     *
     * For example, in the Krunch C++ implementation this would be a pointer to the physics world in Krunch C++, and
     * this function would invoke something like "free(physicsWorldPtr)".
     */
    fun deletePhysicsWorldResources()

    /**
     * Returns true iff the resources held by this [PhysicsWorldReference] have been deleted.
     *
     * If this [PhysicsWorldReference] has has been deleted then it should not be used anymore.
     */
    fun hasBeenDeleted(): Boolean
}
