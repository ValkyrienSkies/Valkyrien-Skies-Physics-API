package org.valkyrienskies.physics_api

import org.joml.Quaterniondc
import org.joml.Vector3dc

/**
 * The base pose and velocity of a rigid body.
 */
data class PoseVel(val pos: Vector3dc, val rot: Quaterniondc, val vel: Vector3dc, val omega: Vector3dc)
