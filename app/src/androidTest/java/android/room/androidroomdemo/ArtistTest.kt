package android.room.androidroomdemo

import android.room.androidroomdemo.TestData.Companion.ARTISTS
import android.room.androidroomdemo.TestData.Companion.FAKE_ARTIST1
import android.room.androidroomdemo.TestData.Companion.FAKE_ARTIST2
import android.room.androidroomdemo.dao.ArtistDao
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
        artistDao.insert(ARTISTS)

        val artistList = artistDao.getArtists()
        assertEquals(artistList.size,2)
        assertEquals(artistList[0].name, FAKE_ARTIST1.name)
    }

    @Test
    fun testGetArtistByCountry() {
        artistDao.insert(ARTISTS)

        val artistUS = artistDao.getArtistByCountry("US")
        assertEquals(artistUS.country, FAKE_ARTIST2.country)
    }
}