import java.text.SimpleDateFormat

class main {
}


internal class CommentException : RuntimeException() {
    override fun toString(): String {
        return "Ошибка комментария"
    }
}

internal class NoteException : RuntimeException() {
    override fun toString(): String {
        return "Ошибка заметки"
    }
}

object WallService {
    private var comments = emptyArray<Comment>()
    private var notes = emptyArray<Notes>()

    private fun getIdNotes(): Int {
        return notes.lastIndex + 1
    }

    private fun getIdComments(): Int {
        return comments.lastIndex + 1
    }

    fun add(title:String,text:String): Notes{
        val note:Notes=Notes(noteId=notes.size,title=title,text = text)
        notes+=note
        return notes.last()
    }

    fun createComment(noteId: Int, message: String): Comment {
        val comment:Comment=Comment(commentId = comments.size,noteId = noteId,message=message)
        comments+=comment
        return comments.last()
    }

    fun delete(id: Int): Boolean {
        for ((index,note) in notes.withIndex()){
            if(index==id){
                notes[index].isDelete=true
                return true
            }
        }
        return false
    }

    fun deleteComment(id: Int): Boolean {
        for ((index,note) in comments.withIndex()){
            if(index==id){
                comments[index].isDelete=true
                return true
            }
        }
        return false
    }

    fun edit(id: Int, title:String , text:String): Boolean {
        for ((index,note) in notes.withIndex()){
            if(index==id){
                if(notes[index].isDelete==true){
                    throw NoteException()
                }else{
                    notes[index].title=title
                    notes[index].text=text
                    return true
                }
            }
        }
        return false
    }

    fun editComment(commentId: Int, ownerId:String , message:String): Boolean {
        for ((index,note) in comments.withIndex()){
            if(index==commentId){
                if(comments[index].isDelete==true){
                    throw CommentException()
                }else{
                    comments[index].message=message
                    return true
                }
            }
        }
        return false
    }

    fun getNotes(userId: Int):Array<Notes>{
        var userNotes = emptyArray<Notes>()
        for ((index,note) in notes.withIndex()){
            if(notes[index].userId==userId){
                if(notes[index].isDelete==false){
                    throw NoteException()
                }
                userNotes+= notes[index]
            }
        }
        return userNotes
    }

    fun getById(noteId: Int): Notes?{
        for ((index,note) in notes.withIndex()){
            if((notes[index].noteId==noteId)){
                if(notes[index].isDelete==false){
                    throw NoteException()
                }
                return notes[index]
            }
        }
        return null
    }
    fun getComments(noteId: Int): Array<Comment>{
        var findingComments = emptyArray<Comment>()
        for ((index,note) in comments.withIndex()){
            if(comments[index].noteId==noteId){
                if(comments[index].isDelete==true){
                    throw CommentException()
                }else{
                    findingComments+= comments[index]
                }
            }
        }
        return findingComments
    }

    fun restoreComment(commentId: Int): Boolean{
        for ((index,note) in comments.withIndex()){
            if(index==commentId){
                if(comments[index].isDelete==false){
                    throw CommentException()
                }
                comments[index].isDelete=false
                return true
            }
        }
        return false
    }
}