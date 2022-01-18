package org.valkyrienskies.physics_api

import org.joml.Vector3d
import org.joml.Vector3dc

data class RigidBodyInertiaData(val mass: Double, val momentOfInertia: Vector3dc) {
    companion object {
        fun createRigidBodyInertiaData(mass: Double, inertiaX: Double, inertiaY: Double, inertiaZ: Double): RigidBodyInertiaData {
            return RigidBodyInertiaData(mass, Vector3d(inertiaX, inertiaY, inertiaZ))
        }
    }
}
