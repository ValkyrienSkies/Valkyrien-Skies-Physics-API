package org.valkyrienskies.physics_api

import org.joml.Vector3d

interface RigidBodyInertiaData {
    var mass: Double
    var momentOfInertia: Vector3d
}
