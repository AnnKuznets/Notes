import org.junit.Test
import org.junit.Assert.*

class ServiceTest {
    @Test
    fun update() {
        val service = NoteService()
        service.add(
            Note(
                1, "Моя заметка", "Заметка"
            )
        )
        service.add(
            Note(
                2, "Моя заметка", "Заметка"
            )
        )

        val feature = Note(1, "Моя заметка", "Заметка")

        val result = service.update(feature)

        assertTrue(result)
    }


    @Test
    fun delete() {
        val service = NoteService()
        service.add(
            Note(
                1, "Моя заметка", "Заметка"
            )
        )
        service.add(
            Note(
                2, "Моя заметка", "Заметка"
            )
        )
        val feature = Note(1, "Моя заметка", "Заметка")

        val result = service.delete(feature)

        assertTrue(result)
    }

    @Test(expected = ElementNotFoundException::class)
    fun get() {
        val service = NoteService()
        service.add(
            Note(
                1, "Моя заметка", "Заметка"
            )
        )
        service.add(
            Note(
                2, "Моя заметка", "Заметка"
            )
        )
        val feature = Note(9, "Моя заметка", "Заметка")

        service.get(feature.id)
    }
}