package battle.troop

import battle.troop.impl.DefensiveStance
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class DefensiveStanceUnitTest : StanceUnitTest() {

    @BeforeEach
    override fun setUp() {
        super.setUp()
        subject = DefensiveStance()
    }

    @Test
    fun calculateAttack() {
        assertEquals(3, subject.calculateAttack(unitTypeEven))
        assertEquals(3, subject.calculateAttack(unitTypeOdd))
    }

    @Test
    fun calculateEndurance() {
        assertEquals(8, subject.calculateEndurance(unitTypeEven))
        assertEquals(10, subject.calculateEndurance(unitTypeOdd))
    }
}
