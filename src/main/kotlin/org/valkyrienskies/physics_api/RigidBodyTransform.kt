package org.valkyrienskies.physics_api

import org.joml.Quaterniondc
import org.joml.Vector3dc

@Deprecated(
    "This is being replaced by PoseVel and Segment. However, until that transition is complete this will" +
            " represent the transform of the first segment"
)
data class RigidBodyTransform(val position: Vector3dc, val rotation: Quaterniondc, val scaling: Double = 1.0)
