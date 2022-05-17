package org.valkyrienskies.physics_api

import org.joml.Matrix3dc

data class RigidBodyInertiaData(val invMass: Double, val invMOI: Matrix3dc)
