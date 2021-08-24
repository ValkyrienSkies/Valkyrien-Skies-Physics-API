package org.valkyrienskies.physics_api

import org.joml.Quaterniondc
import org.joml.Vector3dc

interface RigidBody<T : CollisionShape> {
    val rigidBodyId: Int
    val collisionShape: T
    val rigidBodyTransform: RigidBodyTransform
    val inertiaData: RigidBodyInertiaData
    var isStatic: Boolean
    var restitutionCoefficient: Double
    var dynamicFrictionCoefficient: Double
    var staticFrictionCoefficient: Double

    fun setRigidBodyTransform(position: Vector3dc, rotation: Quaterniondc)
}
