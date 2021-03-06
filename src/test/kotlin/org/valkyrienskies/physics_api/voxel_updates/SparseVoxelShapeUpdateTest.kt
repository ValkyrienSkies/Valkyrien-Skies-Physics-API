package org.valkyrienskies.physics_api.voxel_updates

import org.joml.Vector3i
import org.joml.Vector3ic
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

internal class SparseVoxelShapeUpdateTest {

    @RepeatedTest(100)
    fun testForEachVoxelUpdate() {
        val sparseUpdate = SparseVoxelShapeUpdate(0, 0, 0)
        val groundTruthList = ArrayList<Pair<Vector3ic, Byte>>()
        for (i in 0 until 100) {
            val pos = randomVector3ic()
            val set = Random.nextBoolean()
            val voxelState = if (set) KrunchVoxelStates.SOLID_STATE else KrunchVoxelStates.AIR_STATE
            sparseUpdate.addUpdate(pos.x(), pos.y(), pos.z(), voxelState)
            groundTruthList.add(Pair(pos, voxelState))
        }

        var index = 0
        sparseUpdate.forEachVoxelUpdate { x, y, z, data ->
            val updatePair = groundTruthList[index++]
            assertEquals(updatePair.first, Vector3i(x, y, z))
            assertEquals(updatePair.second, data)
        }
    }

    private fun randomVector3ic(from: Int = 0, until: Int = 16): Vector3ic {
        return Vector3i(Random.nextInt(from, until), Random.nextInt(from, until), Random.nextInt(from, until))
    }
}
