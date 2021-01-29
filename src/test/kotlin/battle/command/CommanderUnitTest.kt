package battle.command

import battle.Battle
import battle.action.Action
import battle.command.exceptions.CommanderWithNoAspiringActionsException
import battle.command.impl.CommanderImpl
import battle.troop.Troop
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations.openMocks
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class CommanderUnitTest {

    @Mock
    lateinit var troop: Troop

    @Mock
    lateinit var aspiringAction0: AspiringAction

    @Mock
    lateinit var aspiringAction1: AspiringAction

    @Mock
    lateinit var action0: Action

    @Mock
    lateinit var action1: Action

    @Mock
    lateinit var battle: Battle

    private lateinit var subject: CommanderImpl

    @BeforeEach
    internal fun setUp() {
        openMocks(this)
        subject = CommanderImpl(setOf(troop), listOf(aspiringAction0, aspiringAction1))

        `when`(aspiringAction0.getAction(battle)).thenReturn(action0)
        `when`(aspiringAction1.getAction(battle)).thenReturn(action1)
    }

    @Test
    fun noAction() {
        subject = CommanderImpl(setOf(troop), emptyList())

        assertThrows<CommanderWithNoAspiringActionsException> { subject.getAction(battle) }
    }

    @Test
    fun getFirstAction() {
        `when`(aspiringAction0.checkDoability(battle)).thenReturn(true)

        val action = subject.getAction(battle)
        assertEquals(action, action0)
        assertNotEquals(action, action1)
    }

    @Test
    fun getSecondAction() {
        `when`(aspiringAction0.checkDoability(battle)).thenReturn(false)
        `when`(aspiringAction1.checkDoability(battle)).thenReturn(true)

        val action = subject.getAction(battle)
        assertNotEquals(action, action0)
        assertEquals(action, action1)
    }
}
