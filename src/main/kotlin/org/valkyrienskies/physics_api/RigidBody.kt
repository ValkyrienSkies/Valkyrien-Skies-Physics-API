package org.valkyrienskies.physics_api

interface RigidBody<T : CollisionShape> {
    val rigidBodyId: Int
    val collisionShape: T
    val rigidBodyTransform: RigidBodyTransform
    val inertiaData: RigidBodyInertiaData
}
