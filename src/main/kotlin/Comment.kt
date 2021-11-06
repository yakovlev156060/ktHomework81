data class Comment(
    var commentId: Int = 0,
    var noteId: Int=0,
    var replyTo: Int=0,
    var message: String="",
    var isDelete: Boolean = false
)