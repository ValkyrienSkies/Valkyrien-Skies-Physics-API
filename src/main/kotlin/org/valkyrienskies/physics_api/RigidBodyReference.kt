package org.valkyrienskies.physics_api

import org.joml.Vector3dc
import org.joml.primitives.AABBd
import org.joml.primitives.AABBi

/**
 * A reference to a Rigid Body. The rigid body is actually stored in [physicsWorldReference]; this reference allows you
 * to view and mutate the Rigid Body.
 *
 * Note that [RigidBodyReference]s do not "own" the memory of the Rigid Body they point to (see [hasBeenDeleted]).
 */
interface RigidBodyReference { // <T : CollisionShape> {
    val rigidBodyId: Int
    val physicsWorldReference: PhysicsWorldReference

    // For now just make the collisionShape always be voxel
    // TODO: Maybe in the future allow the collision shape to be changed. Use something like a C++ move constructor to
    //       move resources from the inputted collision shape (to efficiently move the voxel shape data to the rigid body).
    // var collisionShape: T
    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var rigidBodyTransform: RigidBodyTransform

    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var velocity: Vector3dc

    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var omega: Vector3dc

    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var inertiaData: RigidBodyInertiaData

    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var isStatic: Boolean

    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var restitutionCoefficient: Double

    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var dynamicFrictionCoefficient: Double

    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var staticFrictionCoefficient: Double

    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var collisionShapeScaling: Double

    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var collisionShapeOffset: Vector3dc

    /**
     * Marks a rigid body as having its terrain fully loaded. The rigid body will be static until it its terrain has
     * been marked as fully loaded.
     *
     * World bodies should never be marked as fully loaded, because they are infinite in size.
     */
    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var isVoxelTerrainFullyLoaded: Boolean

    /**
     * Applies a torque that will be rotated as the body rotates for the duration of the next phys tick only.
     *
     * This is suitable for batching the torque from blocks whose position and force direction both depend on rotation.
     *
     * This is NOT suitable for blocks whose force direction is independent of rotation; for example, balloon blocks
     * that only push up.
     *
     * Proof of correctness:
     * Let A be the force position and let B be the force; we can rewrite the torque equation as follows:
     *
     * (R * A) x (R * B) = R * (A x B)
     */
    fun addRotDependentTorqueToNextPhysTick(torqueInLocal: Vector3dc)

    /**
     * Applies a rotation-invariant torque for the duration of the next tick only.
     */
    fun addInvariantTorqueToNextPhysTick(invariantTorque: Vector3dc)

    /**
     * Applies a force that will be rotated as the body rotates for the duration of the next tick only.
     */
    fun addRotDependentForceToNextPhysTick(forceInLocal: Vector3dc)

    /**
     * Applies a rotation-invariant force for the duration of the next tick only.
     */
    fun addInvariantForceToNextPhysTick(invariantForce: Vector3dc)

    /**
     * This will apply [invariantForce] at [forcePosInLocal] for the duration of the next tick only.
     *
     * Blocks that always push in the same direction, like balloons, should use this function.
     *
     * Blocks whose force go the same direction can be batched such that they only need 1 call to this per phys tick.
     */
    fun addInvariantForceAtPosToNextPhysTick(forcePosInLocal: Vector3dc, invariantForce: Vector3dc)

    /**
     * Returns true iff this rigid body this reference points to actually exists, false otherwise.
     *
     * If this returns false then this reference is no longer valid; using it could break things so avoid that.
     */
    fun hasBeenDeleted(): Boolean

    /**
     * @return True if the operation was successful, false otherwise
     */
    fun getVoxelShapeAABB(output: AABBi): Boolean

    /**
     * @return True if the operation was successful, false otherwise
     */
    fun getAABB(output: AABBd): Boolean
}
