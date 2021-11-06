import WallService.add
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
    fun createComment() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun deleteComment() {
    }

    @Test
    fun edit() {
    }

    @Test
    fun editComment() {
    }

    @Test
    fun get() {
    }

    @Test
    fun getById() {
    }

    @Test
    fun getComments() {
    }

    @Test
    fun restoreComment() {
    }

}