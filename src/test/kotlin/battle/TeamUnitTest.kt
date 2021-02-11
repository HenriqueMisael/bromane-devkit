package battle

import battle.exceptions.NotAvailableBattlefieldSettingForColumns
import battle.exceptions.NotAvailableBattlefieldSettingForRows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mock
import org.mockito.MockitoAnnotations.openMocks

internal class TeamUnitTest {

    @Mock
    lateinit var battlefieldSetting0: BattlefieldSetting

    @Mock
    lateinit var battlefieldSetting1: BattlefieldSetting


    private lateinit var subject: Team

    @BeforeEach
    fun setUp() {
        openMocks(this)
    }

    @Test
    fun getId() {
        subject = Team(1L, mapOf())
        assertEquals(1, subject.id)
    }

    @Test
    fun exactBattlefieldSetting() {
        subject = Team(1L, mapOf(3 to mapOf(4 to battlefieldSetting0)))

        assertEquals(battlefieldSetting0, subject.getBattlefieldSetting(3, 4))
    }

    @Test
    fun alternativeOnColumnsBattlefieldSetting() {
        subject = Team(1L, mapOf(3 to mapOf(4 to battlefieldSetting0, 3 to battlefieldSetting1)))

        assertEquals(battlefieldSetting0, subject.getBattlefieldSetting(3, 5))
    }

    @Test
    fun alternativeOnRowsBattlefieldSetting() {
        subject = Team(
            1L,
            mapOf(
                3 to mapOf(4 to battlefieldSetting0),
                2 to mapOf(3 to battlefieldSetting1),
                5 to mapOf(3 to battlefieldSetting1)
            )
        )

        assertEquals(battlefieldSetting0, subject.getBattlefieldSetting(4, 5))
    }

    @Test
    fun noBattlefieldSettings() {
        subject = Team(1L, emptyMap())
        assertThrows<NotAvailableBattlefieldSettingForRows> { subject.getBattlefieldSetting(2, 2) }
    }

    @Test
    fun notBattlefieldSettingForColumns() {
        subject = Team(1L, mapOf(3 to mapOf()))
        assertThrows<NotAvailableBattlefieldSettingForColumns> { subject.getBattlefieldSetting(3, 2) }
    }

    @Test
    fun notSuitableBattlefieldSettingForRows() {
        subject = Team(1L, mapOf(3 to mapOf()))
        assertThrows<NotAvailableBattlefieldSettingForRows> { subject.getBattlefieldSetting(2, 2) }
    }

    @Test
    fun notSuitableBattlefieldSettingForColumns() {
        subject = Team(1L, mapOf(3 to mapOf(4 to battlefieldSetting0)))
        assertThrows<NotAvailableBattlefieldSettingForColumns> { subject.getBattlefieldSetting(3, 2) }
    }
}
