package android.room.androidroomdemo

import android.room.androidroomdemo.dao.ArtistDao
import android.room.androidroomdemo.entity.Artist
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

class ArtistTest {
    private lateinit var artistDao: ArtistDao
    private lateinit var playlistRoomDatabase: PlaylistRoomDatabase

    private val FAKE_ARTIST1 = Artist(1, "Pink Floyd", "Progressive Rock", "UK")
    private val FAKE_ARTIST2 = Artist(2, "Santana", "Latin Rock", "US")

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
        assertEquals(artistList.size,2)
        assertEquals(artistList[0].name, FAKE_ARTIST1.name)
    }

    @Test
    fun testGetArtistByCountry() {
        artistDao.insert(FAKE_ARTIST1)
        artistDao.insert(FAKE_ARTIST2)

        val artistUS = artistDao.getArtistByCountry("US")
        assertEquals(artistUS.country, FAKE_ARTIST2.country)
    }
}