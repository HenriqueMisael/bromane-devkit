package battle

import battle.troop.Troop
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations.openMocks
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class BattlefieldUnitTest {

    @Mock
    lateinit var troop0: Troop

    @Mock
    lateinit var troop1: Troop

    @Mock
    lateinit var troop2: Troop

    @Mock
    lateinit var troop3: Troop

    @Mock
    lateinit var troop4: Troop

    @Mock
    lateinit var troop5: Troop

    @Mock
    lateinit var team0: Team

    @Mock
    lateinit var team1: Team

    private lateinit var subject: Battlefield

    @BeforeEach
    fun setUp() {
        openMocks(this)
    }

    @Test
    fun onlyFrontLinesAsymmetric() {
        subject = Battlefield(4, 5)
        `when`(team0.getBattlefieldSetting(2, 5)).thenReturn(
            BattlefieldSetting(
                listOf(
                    listOf(
                        null,
                        troop0,
                        troop1,
                        troop2,
                        null
                    )
                )
            )
        )
        `when`(team1.getBattlefieldSetting(2, 5)).thenReturn(
            BattlefieldSetting(
                listOf(
                    listOf(
                        troop3,
                        troop4,
                        troop5,
                        null,
                        null
                    )
                )
            )
        )

        assertTrue { subject.isEmpty() }

        subject.setup(listOf(team0, team1))

        assertTrue { subject[0].all { it.isEmpty() } }
        assertEquals(listOf(troop3, troop4, troop5, null, null), subject[1].map { it.content })
        assertEquals(listOf(null, troop0, troop1, troop2, null), subject[2].map { it.content })
        assertTrue { subject[3].all { it.isEmpty() } }
    }

    @Test
    fun fullBattlefield() {
        subject = Battlefield(4, 3)
        `when`(team0.getBattlefieldSetting(2, 3)).thenReturn(
            BattlefieldSetting(
                listOf(
                    listOf(troop0, troop1, troop2),
                    listOf(troop3, troop4, troop5)
                )
            )
        )
        `when`(team1.getBattlefieldSetting(2, 3)).thenReturn(
            BattlefieldSetting(
                listOf(
                    listOf(troop0, troop1, troop2),
                    listOf(troop3, troop4, troop5)
                )
            )
        )

        assertTrue { subject.isEmpty() }

        subject.setup(listOf(team0, team1))

        assertEquals(listOf(troop3, troop4, troop5), subject[0].map { it.content })
        assertEquals(listOf(troop0, troop1, troop2), subject[1].map { it.content })
        assertEquals(listOf(troop0, troop1, troop2), subject[2].map { it.content })
        assertEquals(listOf(troop3, troop4, troop5), subject[3].map { it.content })
    }
}
