package org.valkyrienskies.physics_api

import org.joml.Vector3dc
import org.joml.Vector3ic
import org.joml.primitives.AABBi
import org.joml.primitives.AABBic
import org.valkyrienskies.physics_api.voxel_updates.IVoxelShapeUpdate
import org.valkyrienskies.physics_api.voxel_updates.VoxelRigidBodyShapeUpdates

interface PhysicsWorldReference {
    /**
     * If [simulatePhysics] is false then the physics world will still run tasks in the background (like updating terrain),
     * but it won't simulate any physics.
     */
    @Throws(UsingDeletedReferenceException::class)
    fun tick(gravity: Vector3dc, timeStep: Double, simulatePhysics: Boolean)

    /**
     * Create a new rigid body in this [PhysicsWorldReference] with an initial dimension of [dimension].
     *
     * The voxel shape for this rigid body will be defined for all positions between [minDefined] and [maxDefined].
     * This means that everything outside this range will be assumed to be empty until a [IVoxelShapeUpdate] defines it.
     *
     *
     * For example, a typical minecraft world voxel rigid body will have these values set to the following:
     *  [minDefined] = {[Int.MIN_VALUE], 0, [Int.MIN_VALUE]}
     *  [maxDefined] = {[Int.MAX_VALUE], 255, [Int.MAX_VALUE]}
     *
     * Note that for now [minDefined] should be the min value of a chunk boundary (ex. {0, 0, 0}), and [maxDefined]
     * should be the max value of a chunk boundary (ex. {15, 15, 15}).
     *
     * @param totalVoxelRegion The maximum region the voxel shape will span. This is used for generating AABB of the
     *                         voxel shape.
     *                         For infinitely sized voxel shapes (like the ground), use [INFINITE_VOXEL_REGION].
     *
     * @return A [RigidBodyReference] that points to the rigid body created by this function.
     */
    @Throws(UsingDeletedReferenceException::class)
    fun createVoxelRigidBody(
        dimension: Int,
        minDefined: Vector3ic,
        maxDefined: Vector3ic,
        totalVoxelRegion: AABBic
    ): RigidBodyReference

    /**
     * Deletes the rigid body with id [rigidBodyId] from this world.
     *
     * @return True iff a rigid body with id [rigidBodyId] was found and deleted, false otherwise.
     */
    @Throws(UsingDeletedReferenceException::class)
    fun deleteRigidBody(rigidBodyId: Int): Boolean

    /**
     * Queues [VoxelRigidBodyShapeUpdates] to be run in the background.
     *
     * This function is thread safe.
     */
    @Throws(UsingDeletedReferenceException::class)
    fun queueVoxelShapeUpdates(updates: Array<VoxelRigidBodyShapeUpdates>)

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

    companion object {
        /**
         * The voxel region that represents an infinitely sized voxel shape, for [createVoxelRigidBody].
         *
         * THIS SHOULD ONLY BE USED FOR GROUND SHAPES! Only use 1 per dimension, otherwise you'll lag the physics.
         *
         * Note that infinitely sized voxel shapes will have an infinitely sized AABB, so they will always do
         * narrow-phase collision with everything else.
         */
        val INFINITE_VOXEL_REGION: AABBic =
            AABBi(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)
    }
}
