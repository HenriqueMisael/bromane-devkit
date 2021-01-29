package battle.action

import battle.Battle
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.MockitoAnnotations.openMocks

open class ActionUnitTest {

    @Mock
    lateinit var battle: Battle

    protected lateinit var subject: Action

    @BeforeEach
    open fun setUp() {
        openMocks(this)
    }
}
