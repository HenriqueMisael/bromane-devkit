package battle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TeamUnitTest {

    private lateinit var subject: Team

    @BeforeEach
    fun setUp() {
        subject = Team(1L)
    }

    @Test
    fun getId() {
        assertEquals(1, subject.id)
    }
}
