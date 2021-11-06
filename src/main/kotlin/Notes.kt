data class Notes (
    var noteId: Int = 0,
    var userId: Int=0,
    var title: String="",
    var text: String="",
    var date: String="",
    var privacyView: Boolean = false,
    var privacyComment: Boolean = false,
    var isDelete: Boolean = false
)