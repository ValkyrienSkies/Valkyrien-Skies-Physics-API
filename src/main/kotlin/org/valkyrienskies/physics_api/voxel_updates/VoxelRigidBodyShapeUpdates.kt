package org.valkyrienskies.physics_api.voxel_updates

import org.valkyrienskies.physics_api.VoxelRigidBody

data class VoxelRigidBodyShapeUpdates(val voxelRigidBody: VoxelRigidBody, val shapeUpdates: List<IVoxelShapeUpdate>)
