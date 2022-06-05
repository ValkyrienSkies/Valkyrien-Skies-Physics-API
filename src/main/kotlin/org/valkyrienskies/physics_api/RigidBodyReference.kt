package org.valkyrienskies.physics_api

import org.joml.Vector3dc

/**
 * A reference to a Rigid Body. The rigid body is actually stored in [physicsWorldReference]; this reference allows you
 * to view and mutate the Rigid Body.
 *
 * Note that [RigidBodyReference]s do not "own" the memory of the Rigid Body they point to (see [hasBeenDeleted]).
 */
interface RigidBodyReference { // <T : CollisionShape> {
    val rigidBodyId: Int
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
    // TODO: In the future replace dimension with a localPos -> portalTransformId map for portal physics
    @get:Throws(UsingDeletedReferenceException::class)
    val initialDimension: Int
    /**
     * Marks a rigid body as having its terrain fully loaded. The rigid body will be static until it its terrain has
     * been marked as fully loaded.
     *
     * World bodies should never be marked as fully loaded, because they are infinite in size.
     */
    @get:Throws(UsingDeletedReferenceException::class)
    @set:Throws(UsingDeletedReferenceException::class)
    var isVoxelTerrainFullyLoaded: Boolean
    val physicsWorldReference: PhysicsWorldReference

    /**
     * Returns true iff this rigid body this reference points to actually exists, false otherwise.
     *
     * If this returns false then this reference is no longer valid; using it could break things so avoid that.
     */
    fun hasBeenDeleted(): Boolean
}
