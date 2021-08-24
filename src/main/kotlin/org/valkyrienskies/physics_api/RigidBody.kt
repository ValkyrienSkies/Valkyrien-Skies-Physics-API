package org.valkyrienskies.physics_api

import org.joml.Quaterniondc
import org.joml.Vector3dc

interface RigidBody<T : CollisionShape> {
    val rigidBodyId: Int
    val collisionShape: T
    val rigidBodyTransform: RigidBodyTransform
    val inertiaData: RigidBodyInertiaData
    var isStatic: Boolean
    fun setRigidBodyTransform(position: Vector3dc, rotation: Quaterniondc)
}
