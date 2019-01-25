package android.room.androidroomdemo

import android.room.androidroomdemo.dao.ArtistDao
import android.room.androidroomdemo.entity.ArtistEntity
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class ArtistEntityTest {
    private lateinit var artistDao: ArtistDao
    private lateinit var playlistRoomDatabase: PlaylistRoomDatabase

    private val FAKE_ARTIST1 = ArtistEntity(1, "Pink Floyd", "Progressive Rock", "UK")
    private val FAKE_ARTIST2 = ArtistEntity(2, "Santana", "Latin Rock", "US")

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        playlistRoomDatabase = Room.inMemoryDatabaseBuilder(
            context, PlaylistRoomDatabase::class.java
        ).build()
        artistDao = playlistRoomDatabase.artistDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        playlistRoomDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        artistDao.insert(FAKE_ARTIST1)
        artistDao.insert(FAKE_ARTIST2)

        val artistList = artistDao.getArtists()
        assert(artistList.size == 2)
        assert(artistList[0].name == FAKE_ARTIST1.name)
    }
}