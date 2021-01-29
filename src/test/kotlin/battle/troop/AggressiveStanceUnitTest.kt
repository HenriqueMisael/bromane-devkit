package battle.troop

import battle.troop.impl.AggressiveStance
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AggressiveStanceUnitTest : StanceUnitTest() {

    @BeforeEach
    override fun setUp() {
        super.setUp()
        subject = AggressiveStance()
    }

    @Test
    fun calculateAttack() {
        assertEquals(6, subject.calculateAttack(unitTypeEven))
        assertEquals(7, subject.calculateAttack(unitTypeOdd))
    }

    @Test
    fun calculateEndurance() {
        assertEquals(2, subject.calculateEndurance(unitTypeEven))
        assertEquals(2, subject.calculateEndurance(unitTypeOdd))
    }
}
