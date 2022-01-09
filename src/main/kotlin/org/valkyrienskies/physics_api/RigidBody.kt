package org.valkyrienskies.physics_api

import org.joml.Vector3dc

interface RigidBody<T : CollisionShape> {
    val rigidBodyId: Int
    val collisionShape: T
    var rigidBodyTransform: RigidBodyTransform
    var inertiaData: RigidBodyInertiaData
    var isStatic: Boolean
    var restitutionCoefficient: Double
    var dynamicFrictionCoefficient: Double
    var staticFrictionCoefficient: Double
    var scaling: Double
    var collisionShapeOffset: Vector3dc
}
