import org.mockito.ArgumentMatcher
import org.mockito.ArgumentMatchers.argThat

object MockitoHelper {
    fun <T> collectionThat(matcher: ArgumentMatcher<Collection<T>>?): Collection<T> {
        argThat(matcher)
        return emptyList()
    }

    fun <T> listThat(matcher: ArgumentMatcher<List<T>>?): List<T> {
        argThat(matcher)
        return emptyList()
    }
}
