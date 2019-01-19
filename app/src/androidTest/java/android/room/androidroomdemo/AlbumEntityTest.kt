package android.room.androidroomdemo

import android.room.androidroomdemo.dao.AlbumDao
import android.room.androidroomdemo.entity.AlbumEntity
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class AlbumEntityTest {
    private lateinit var albumDao: AlbumDao
    private lateinit var playlistRoomDatabase: PlaylistRoomDatabase
    private val FAKE_ALBUM1 = AlbumEntity(name = "The Wall", year = 1979)
    private val FAKE_ALBUM2 = AlbumEntity(name = "Supernatural", year = 1999)

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        playlistRoomDatabase = Room.inMemoryDatabaseBuilder(
            context, PlaylistRoomDatabase::class.java).build()
        albumDao = playlistRoomDatabase.albumDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        playlistRoomDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        albumDao.insert(FAKE_ALBUM1)
        albumDao.insert(FAKE_ALBUM2)

        val albumList = albumDao.getAlbums()
        assert(albumList.size == 2)
        assert(albumList[0].name == FAKE_ALBUM1.name)
    }
}