import WallService.add
import WallService.createComment
import WallService.delete
import WallService.deleteComment
import WallService.edit
import WallService.editComment
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun testAdd() {
        val testNote: Notes= Notes(title ="test title",text = "test text" )
        val rezult=add("test title", "test text")
        assertEquals(rezult,testNote)
    }

    @Test
    fun testCreateComment() {
        val testComment: Comment= Comment(noteId = 0,message="test message")
        val rezult=createComment(0,"test message")
        assertEquals(rezult,testComment)
    }

    @Test
    fun testDelete() {
        val rezult=delete(0)
        assertTrue(rezult)
    }

    @Test
    fun testDeleteComment() {
        val rezult= deleteComment(0)
        assertFalse(rezult)
    }

    @Test
    fun testEdit() {
        val rezult= edit(0, "new title" , "new text")
        assertTrue(rezult)
    }

    @Test
    fun testEditComment() {
        val rezult= editComment(0, 0 , "new comment")
        assertFalse(rezult)
    }

}