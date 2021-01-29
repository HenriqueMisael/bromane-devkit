package battle.troop

import battle.UnitType
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations.openMocks

open class StanceUnitTest {
    @Mock
    lateinit var unitTypeEven: UnitType

    @Mock
    lateinit var unitTypeOdd: UnitType
    protected lateinit var subject: Stance

    @BeforeEach
    internal open fun setUp() {
        openMocks(this)

        doReturn(8).`when`(unitTypeEven).health
        doReturn(6).`when`(unitTypeEven).attack
        doReturn(4).`when`(unitTypeEven).endurance

        doReturn(9).`when`(unitTypeOdd).health
        doReturn(7).`when`(unitTypeOdd).attack
        doReturn(5).`when`(unitTypeOdd).endurance
    }
}
