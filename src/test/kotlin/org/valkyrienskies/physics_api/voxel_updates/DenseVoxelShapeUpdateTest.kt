package org.valkyrienskies.physics_api.voxel_updates

import org.joml.Vector3i
import org.joml.Vector3ic
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

internal class DenseVoxelShapeUpdateTest {

    @RepeatedTest(100)
    fun testForEachVoxelUpdate() {
        val denseUpdate = DenseVoxelShapeUpdate(0, 0, 0)
        val groundTruthList = ArrayList<Pair<Vector3ic, Byte>>()
        for (i in 0 until 100) {
            val pos = randomVector3ic()
            denseUpdate.setVoxel(pos.x(), pos.y(), pos.z(), KrunchVoxelStates.SOLID_STATE)
            groundTruthList.add(Pair(pos, KrunchVoxelStates.SOLID_STATE))
        }

        groundTruthList.forEach {
            val pos = it.first
            val data = it.second
            assertEquals(denseUpdate.getVoxel(pos.x(), pos.y(), pos.z()), data)
        }
    }

    private fun randomVector3ic(from: Int = 0, until: Int = 16): Vector3ic {
        return Vector3i(Random.nextInt(from, until), Random.nextInt(from, until), Random.nextInt(from, until))
    }
}
