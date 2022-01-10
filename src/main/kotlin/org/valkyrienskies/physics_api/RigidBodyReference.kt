package org.valkyrienskies.physics_api

import org.joml.Vector3dc

/**
 * A reference to a Rigid Body. The rigid body is actually stored in [physicsWorldReference]; this reference allows you
 * to view and mutate the Rigid Body.
 *
 * Note that [RigidBodyReference]s do not "own" the memory of the Rigid Body they point to (see [isReferenceValid]).
 */
interface RigidBodyReference { // <T : CollisionShape> {
    val rigidBodyId: Int
    // For now just make the collisionShape always be voxel
    // TODO: Maybe in the future allow the collision shape to be changed. Use something like a C++ move constructor to
    //       move resources from the inputted collision shape (to efficiently move the voxel shape data to the rigid body).
    // var collisionShape: T
    var rigidBodyTransform: RigidBodyTransform
    var inertiaData: RigidBodyInertiaData
    var isStatic: Boolean
    var restitutionCoefficient: Double
    var dynamicFrictionCoefficient: Double
    var staticFrictionCoefficient: Double
    var collisionShapeScaling: Double
    var collisionShapeOffset: Vector3dc
    // TODO: In the future replace dimension with a localPos -> dimension map for portal physics
    var dimension: Int
    val physicsWorldReference: PhysicsWorldReference

    /**
     * Returns true iff this rigid body this reference points to actually exists, false otherwise.
     *
     * If this returns false then this reference is no longer valid; using it could break things so avoid that.
     */
    fun isReferenceValid(): Boolean
}
