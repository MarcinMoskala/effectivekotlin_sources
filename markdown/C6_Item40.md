```
class ValueMatcher<T> private constructor(
    private val value: T? = null,
    private val matcher: Matcher
) {

    fun match(value: T?) = when (matcher) {
        Matcher.EQUAL -> value == this.value
        Matcher.NOT_EQUAL -> value != this.value
        Matcher.LIST_EMPTY ->
            value is List<*> && value.isEmpty()
        Matcher.LIST_NOT_EMPTY ->
            value is List<*> && value.isNotEmpty()
    }

    enum class Matcher {
        EQUAL,
        NOT_EQUAL,
        LIST_EMPTY,
        LIST_NOT_EMPTY
    }

    companion object {
        fun <T> equal(value: T) =
            ValueMatcher<T>(
                value = value,
                matcher = Matcher.EQUAL
            )

        fun <T> notEqual(value: T) =
            ValueMatcher<T>(
                value = value,
                matcher = Matcher.NOT_EQUAL
            )

        fun <T> emptyList() =
            ValueMatcher<T>(
                matcher = Matcher.LIST_EMPTY
            )

        fun <T> notEmptyList() =
            ValueMatcher<T>(
                matcher = Matcher.LIST_NOT_EMPTY
            )
    }
}
```


```
sealed class ValueMatcher<T> {
    abstract fun match(value: T): Boolean

    class Equal<T>(val value: T) : ValueMatcher<T>() {
        override fun match(value: T): Boolean =
            value == this.value
    }

    class NotEqual<T>(val value: T) : ValueMatcher<T>() {
        override fun match(value: T): Boolean =
            value != this.value
    }

    class EmptyList<T>() : ValueMatcher<T>() {
        override fun match(value: T) =
            value is List<*> && value.isEmpty()
    }

    class NotEmptyList<T>() : ValueMatcher<T>() {
        override fun match(value: T) =
            value is List<*> && value.isNotEmpty()
    }
}
```


```
fun <T> ValueMatcher<T>.reversed(): ValueMatcher<T> =
  when (this) {
      is EmptyList -> NotEmptyList<T>()
      is NotEmptyList -> EmptyList<T>()
      is Equal -> NotEqual(value)
      is NotEqual -> Equal(value)
  }
```


```
sealed class WorkoutState

class PrepareState(
    val exercise: Exercise
) : WorkoutState()

class ExerciseState(
    val exercise: Exercise
) : WorkoutState()

object DoneState : WorkoutState()

fun List<Exercise>.toStates(): List<WorkoutState> =
    flatMap { exercise ->
        listOf(
            PrepareState(exercise),
            ExerciseState(exercise)
        )
    } + DoneState

class WorkoutPresenter( /*...*/) {
    private var state: WorkoutState = states.first()

    //...
}
```