package org.valkyrienskies.physics_api.voxel_updates

import java.util.*

/**
 * A complete 16x16x16 region to be updated in a VoxelShape.
 *
 * Expected use is for when new terrain is loaded.
 */
class DenseVoxelShapeUpdate(
    override val regionX: Int,
    override val regionY: Int,
    override val regionZ: Int
) : IVoxelShapeUpdate {
    val voxelData = BitSet(4096)

    inline fun setData(function: (x: Int, y: Int, z: Int) -> Boolean) {
        iterate { x, y, z ->
            val index = toIndex(x, y, z)
            voxelData[index] = function(x, y, z)
        }
    }

    inline fun forEachVoxel(function: (x: Int, y: Int, z: Int, Boolean) -> Unit) {
        iterate { x, y, z ->
            val index = toIndex(x, y, z)
            function(x, y, z, voxelData[index])
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

    fun toIndex(x: Int, y: Int, z: Int): Int {
        return (x or (z shl 4) or (y shl 8))
    }
}
