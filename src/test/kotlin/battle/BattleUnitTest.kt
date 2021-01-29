package battle

import battle.action.Action
import battle.command.Commander
import battle.exceptions.BattleNotSetUpException
import battle.impl.BattleImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.openMocks

internal class BattleUnitTest {

    @Mock
    private lateinit var commander0: Commander

    @Mock
    private lateinit var action00: Action

    @Mock
    private lateinit var action01: Action

    @Mock
    private lateinit var commander1: Commander

    @Mock
    private lateinit var action10: Action

    @Mock
    private lateinit var action11: Action

    private lateinit var subject: BattleImpl

    @BeforeEach
    internal fun setUp() {
        openMocks(this)

        subject = BattleImpl(setOf(commander0, commander1))

        `when`(commander0.getAction(subject)).thenReturn(action00).thenReturn(action01)
        `when`(commander1.getAction(subject)).thenReturn(action10).thenReturn(action11)
    }

    @Test
    fun forwardWithoutSettingUp() {
        assertThrows<BattleNotSetUpException> { subject.forward() }
    }

    @Test
    fun forwardAfterSettingUp() {

        subject.setup()
        subject.forward()

        verify(commander0).getAction(subject)
        verify(action00).apply(subject)
        verify(commander1).getAction(subject)
        verify(action10).apply(subject)
    }
}
