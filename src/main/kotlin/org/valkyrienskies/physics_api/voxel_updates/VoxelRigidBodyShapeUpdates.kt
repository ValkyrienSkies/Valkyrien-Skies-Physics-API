package org.valkyrienskies.physics_api.voxel_updates

data class VoxelRigidBodyShapeUpdates(val rigidBodyId: Int, val shapeUpdates: Array<IVoxelShapeUpdate>) {
    // Auto generated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VoxelRigidBodyShapeUpdates

        if (rigidBodyId != other.rigidBodyId) return false
        if (!shapeUpdates.contentEquals(other.shapeUpdates)) return false

        return true
    }

    // Auto generated
    override fun hashCode(): Int {
        var result = rigidBodyId
        result = 31 * result + shapeUpdates.contentHashCode()
        return result
    }

}
