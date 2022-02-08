package org.valkyrienskies.physics_api.voxel_updates

import it.unimi.dsi.fastutil.bytes.ByteArrayList
import it.unimi.dsi.fastutil.shorts.ShortArrayList
import org.joml.Vector3ic

/**
 * A updates within 16x16x16 region to be updated in a VoxelShape.
 *
 * Expected use is for block changes to already loaded terrain.
 */
class SparseVoxelShapeUpdate(
    override val regionX: Int,
    override val regionY: Int,
    override val regionZ: Int,
    override val runImmediately: Boolean = false
) : IVoxelShapeUpdate {
    val updatesPositions = ShortArrayList()
    val updatesTypes = ByteArrayList()

    fun addUpdate(x: Int, y: Int, z: Int, voxelState: Byte) {
        val index = toIndex(x, y, z)
        updatesPositions.add(index.toShort())
        updatesTypes.add(voxelState)
    }

    inline fun forEachVoxelUpdate(function: (x: Int, y: Int, z: Int, voxelState: Byte) -> Unit) {
        for (i in 0 until updatesPositions.size) {
            val index = updatesPositions.getShort(i)
            val voxelState = updatesTypes.getByte(i)
            fromIndex(index.toInt()) { x: Int, y: Int, z: Int ->
                function(x, y, z, voxelState)
            }
        }
    }

    private fun toIndex(x: Int, y: Int, z: Int): Int {
        return (x or (z shl 4) or (y shl 8))
    }

    inline fun fromIndex(index: Int, function: (x: Int, y: Int, z: Int) -> Unit) {
        val x = index and 0xF
        val y = (index shr 8) and 0xF
        val z = (index shr 4) and 0xF
        function(x, y, z)
    }

    companion object {
        fun createSparseVoxelShapeUpdate(chunkPos: Vector3ic) =
            SparseVoxelShapeUpdate(chunkPos.x(), chunkPos.y(), chunkPos.z())
    }
}
