package org.valkyrienskies.physics_api

import org.joml.Vector3dc

interface RigidBodyInertiaData {
    val mass: Double
    val momentOfInertia: Vector3dc
}
