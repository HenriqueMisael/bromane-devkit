package battle.action

import battle.troop.Stance
import battle.troop.Troop
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import kotlin.test.assertTrue

internal class ChangeTroopStanceActionUnitTest : ActionUnitTest() {

    @Mock
    lateinit var stance0: Stance

    @Mock
    lateinit var stance1: Stance

    @Mock
    lateinit var troop0: Troop

    @Mock
    lateinit var troop1: Troop

    @BeforeEach
    override fun setUp() {
        super.setUp()
        subject = ChangeTroopStanceAction(stance0, troop0)
    }

    @Test
    fun apply() {
        subject.apply()

        verify(troop0).turnStance(stance0)
    }

    @Test
    fun equals() {
        assertTrue { subject == subject }
        assertTrue { subject == ChangeTroopStanceAction(stance0, troop0) }
        assertFalse { subject == ChangeTroopStanceAction(stance1, troop1) }
        assertFalse { subject.equals(null) }
    }

    @Test
    fun testHashCode() {
        assertTrue { subject.hashCode() == subject.hashCode() }
        assertTrue { subject.hashCode() == ChangeTroopStanceAction(stance0, troop0).hashCode() }
        assertFalse { subject.hashCode() == ChangeTroopStanceAction(stance1, troop1).hashCode() }
    }
}
