package org.valkyrienskies.physics_api.voxel_updates

import org.valkyrienskies.physics_api.RigidBodyReference

data class VoxelRigidBodyShapeUpdates(val voxelRigidBody: RigidBodyReference, val shapeUpdates: List<IVoxelShapeUpdate>)
