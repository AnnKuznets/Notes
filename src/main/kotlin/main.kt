import java.lang.RuntimeException


abstract class Features(val id: Int)
abstract class Service<F: Features>{
    private var features = mutableListOf<F>()

    fun add(feature: F) :F {
        features += feature
        return features.last()
    }
    fun update(feature: F): Boolean {
        features.map {
            if (feature.id == it.id)
                return true
        }
        return false
    }
    fun delete(feature: F): Boolean {
        features.remove(feature)
        return true
    }
    fun get(id: Int) : F {
        return features.find { it.id == id } ?: throw ElementNotFoundException("Element $id wasn't found!")
    }
}

class ElementNotFoundException(message: String) : RuntimeException(message)

class Comment(val noteId: Int)
class Note(id: Int, title: String,text: String) : Features(id){
    val comments = mutableListOf<Comment>()
}
class NoteService : Service<Note>() {
    fun addComment(noteId: Int, comment: Comment) {
        get(noteId).comments.add(comment)
    }
}
fun main() {
    val service = NoteService()
    service.add(Note(1,"Моя заметка", "Заметка"))
    println(service.update(Note(1,"Моя заметка", "Заметка")))
}

