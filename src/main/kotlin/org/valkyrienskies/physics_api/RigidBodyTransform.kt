package org.valkyrienskies.physics_api

import org.joml.Quaterniond
import org.joml.Quaterniondc
import org.joml.Vector3d
import org.joml.Vector3dc

data class RigidBodyTransform(val position: Vector3dc, val rotation: Quaterniondc) {
    companion object {
        fun createRigidBodyTransform(posX: Double, posY: Double, posZ: Double, rotX: Double, rotY: Double, rotZ: Double, rotW: Double): RigidBodyTransform {
            return RigidBodyTransform(Vector3d(posX, posY, posZ), Quaterniond(rotX, rotY, rotZ, rotW))
        }
    }
}
