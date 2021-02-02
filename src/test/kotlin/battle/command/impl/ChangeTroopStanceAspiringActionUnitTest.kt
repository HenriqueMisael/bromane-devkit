package battle.command.impl

import battle.action.ChangeTroopStanceAction
import battle.command.AspiringTroopAction
import battle.troop.Stance
import battle.troop.Troop
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.openMocks
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class ChangeTroopStanceAspiringActionUnitTest {

    @Mock
    lateinit var stance: Stance

    @Mock
    lateinit var troop: Troop

    private lateinit var subject: AspiringTroopAction

    @BeforeEach
    fun setUp() {
        openMocks(this)

        subject = ChangeTroopStanceAspiringAction(stance, troop)
    }

    @Test
    fun checkDoability() {
        assertTrue { subject.isDoable }
    }

    @Test
    fun getAction() {
        assertEquals(ChangeTroopStanceAction(stance, troop), subject.action)
    }
}
