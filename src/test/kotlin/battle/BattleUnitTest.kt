package battle

import MockitoHelper
import battle.action.Action
import battle.command.Commander
import battle.exceptions.BattleNotSetUpException
import battle.troop.Troop
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

    @Mock
    private lateinit var battlefield: Battlefield

    @Mock
    private lateinit var team0: Team

    @Mock
    private lateinit var team1: Team

    @Mock
    private lateinit var troop0: Troop

    @Mock
    private lateinit var troop1: Troop

    @Mock
    private lateinit var troop2: Troop

    @Mock
    private lateinit var troop3: Troop

    private lateinit var subject: Battle

    @BeforeEach
    internal fun setUp() {
        openMocks(this)

        `when`(commander0.team).thenReturn(team0)
        `when`(commander0.troops).thenReturn(setOf(troop0, troop1))
        `when`(commander1.team).thenReturn(team1)
        `when`(commander1.troops).thenReturn(setOf(troop2, troop3))

        subject = Battle(battlefield, setOf(commander0, commander1))

        `when`(commander0.getAction()).thenReturn(action00).thenReturn(action01)
        `when`(commander1.getAction()).thenReturn(action10).thenReturn(action11)
    }

    @Test
    fun forwardWithoutSettingUp() {
        assertThrows<BattleNotSetUpException> { subject.forward() }
    }

    @Test
    fun forwardAfterSettingUp() {

        subject.setup()
        verify(battlefield).split(MockitoHelper.collectionThat { it.containsAll(listOf(team0, team1)) })

        subject.forward()

        verify(commander0).getAction()
        verify(action00).apply()
        verify(commander1).getAction()
        verify(action10).apply()
        verify(troop0).resetEngagements()
        verify(troop1).resetEngagements()
        verify(troop2).resetEngagements()
        verify(troop3).resetEngagements()
        verify(troop0).resolveEngagements()
        verify(troop1).resolveEngagements()
        verify(troop2).resolveEngagements()
        verify(troop3).resolveEngagements()
    }
}
