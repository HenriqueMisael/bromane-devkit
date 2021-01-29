package battle.troop

import battle.UnitType
import battle.troop.impl.TroopImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations.openMocks
import kotlin.test.assertEquals

internal class TroopUnitTest {

    @Mock
    lateinit var unitType: UnitType

    @Mock
    lateinit var stance0: Stance

    @Mock
    lateinit var stance1: Stance

    private lateinit var subject: Troop

    @BeforeEach
    internal fun setUp() {
        openMocks(this)

        subject = TroopImpl(unitType, stance0)

        doReturn(8).`when`(unitType).health
        doReturn(5).`when`(unitType).attack
        doReturn(3).`when`(unitType).endurance

        doReturn(5).`when`(stance0).calculateAttack(unitType)
        doReturn(3).`when`(stance0).calculateEndurance(unitType)

        doReturn(2).`when`(stance1).calculateAttack(unitType)
        doReturn(6).`when`(stance1).calculateEndurance(unitType)
    }

    @Test
    fun defaultStance() {
        assertEquals(8, subject.health)
        assertEquals(5, subject.attack)
        assertEquals(3, subject.endurance)
    }

    @Test
    fun changeStance() {
        subject.turnStance(stance1)

        assertEquals(8, subject.health)
        assertEquals(2, subject.attack)
        assertEquals(6, subject.endurance)
    }
}
