package org.valkyrienskies.physics_api

import org.joml.Quaterniondc
import org.joml.Vector3dc

interface RigidBodyTransform {
    val position: Vector3dc
    val rotation: Quaterniondc
}
