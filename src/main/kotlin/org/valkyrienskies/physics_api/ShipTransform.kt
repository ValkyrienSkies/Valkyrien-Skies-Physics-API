package org.valkyrienskies.physics_api

import org.joml.Matrix3dc
import org.joml.Matrix4dc
import org.joml.Vector3dc

interface ShipTransform {
    val translation: Vector3dc
    val rotation: Matrix3dc
    val scaling: Matrix3dc // Making scaling a matrix to support warping
    val overallTransform: Matrix4dc
}
