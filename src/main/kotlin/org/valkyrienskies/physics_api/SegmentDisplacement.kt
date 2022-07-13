package org.valkyrienskies.physics_api

import org.joml.Matrix4dc
import org.joml.Quaterniondc
import org.joml.Vector3dc

data class SegmentDisplacement(
    val transform: Matrix4dc,
    val invTransform: Matrix4dc,
    val rotation: Quaterniondc,
    val vel: Vector3dc,
    val scaling: Double,
    val dimension: Int
)
