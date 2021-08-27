package org.valkyrienskies.physics_api

import it.unimi.dsi.fastutil.ints.IntList
import org.joml.Vector3dc
import org.valkyrienskies.physics_api.voxel_updates.IVoxelShapeUpdate

interface PhysicsWorld {
    fun tick(gravity: Vector3dc, timeStep: Double)
    fun createVoxelRigidBody(): VoxelRigidBody
    fun addRigidBody(rigidBody: RigidBody<*>)
    fun removeRigidBody(rigidBody: RigidBody<*>)

    /**
     * Queues [IVoxelShapeUpdate]s to be run in the background.
     */
    fun queueDenseVoxelShapeUpdates(rigidBodies: IntList, updates: List<IVoxelShapeUpdate>)
}
