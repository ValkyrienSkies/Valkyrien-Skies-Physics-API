package org.valkyrienskies.physics_api.voxel_updates

import org.joml.Vector3ic

/**
 * A complete 16x16x16 region to be updated in a VoxelShape.
 *
 * Expected use is for when new terrain is loaded.
 */
data class DenseVoxelShapeUpdate(
    override val regionX: Int,
    override val regionY: Int,
    override val regionZ: Int,
    override val runImmediately: Boolean = false,
    private val voxelDataRaw: ByteArray = ByteArray(4096)
) : IVoxelShapeUpdate {

    /**
     * Used to make edits to this update.
     */
    fun setVoxel(x: Int, y: Int, z: Int, data: Byte) {
        val index = toIndex(x, y, z)
        voxelDataRaw[index] = data
    }

    fun getVoxel(x: Int, y: Int, z: Int): Byte {
        val index = toIndex(x, y, z)
        return voxelDataRaw[index]
    }

    inline fun setData(function: (x: Int, y: Int, z: Int) -> Byte) {
        iterate { x, y, z ->
            setVoxel(x, y, z, function(x, y, z))
        }
    }

    inline fun forEachVoxel(function: (x: Int, y: Int, z: Int, voxelState: Byte) -> Unit) {
        iterate { x, y, z ->
            function(x, y, z, getVoxel(x, y, z))
        }
    }

    // Order optimized for reading data from minecraft chunks
    inline fun iterate(function: (x: Int, y: Int, z: Int) -> Unit) {
        for (y in 0 until 16) {
            for (z in 0 until 16) {
                for (x in 0 until 16) {
                    function(x, y, z)
                }
            }
        }
    }

    private fun toIndex(x: Int, y: Int, z: Int): Int {
        return (x or (z shl 4) or (y shl 8))
    }

    fun getVoxelDataRaw(): ByteArray {
        return voxelDataRaw
    }

    // Auto generated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DenseVoxelShapeUpdate

        if (regionX != other.regionX) return false
        if (regionY != other.regionY) return false
        if (regionZ != other.regionZ) return false
        if (runImmediately != other.runImmediately) return false
        if (!voxelDataRaw.contentEquals(other.voxelDataRaw)) return false

        return true
    }

    // Auto generated
    override fun hashCode(): Int {
        var result = regionX
        result = 31 * result + regionY
        result = 31 * result + regionZ
        result = 31 * result + runImmediately.hashCode()
        result = 31 * result + voxelDataRaw.contentHashCode()
        return result
    }

    companion object {
        fun createDenseVoxelShapeUpdate(chunkPos: Vector3ic) =
            DenseVoxelShapeUpdate(chunkPos.x(), chunkPos.y(), chunkPos.z())
    }
}
