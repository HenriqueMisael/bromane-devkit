package battle.action

import battle.troop.Stance
import battle.troop.Troop
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.verify

internal class ChangeStanceActionUnitTest : ActionUnitTest() {

    @Mock
    lateinit var stance: Stance

    @Mock
    lateinit var troop: Troop

    @BeforeEach
    override fun setUp() {
        super.setUp()
        subject = ChangeStanceAction(stance, troop)
    }

    @Test
    fun apply() {
        subject.apply(battle)

        verify(troop).turnStance(stance)
    }
}
