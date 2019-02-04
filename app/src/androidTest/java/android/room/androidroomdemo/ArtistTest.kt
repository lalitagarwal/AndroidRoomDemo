package android.room.androidroomdemo

import android.room.androidroomdemo.TestData.Companion.ARTISTS
import android.room.androidroomdemo.dao.ArtistDao
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ArtistTest {
    private lateinit var artistDao: ArtistDao
    private lateinit var playlistRoomDatabase: PlaylistRoomDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        playlistRoomDatabase = Room.inMemoryDatabaseBuilder(
            context, PlaylistRoomDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
        artistDao = playlistRoomDatabase.artistDao()
    }

    @After
    fun closeDb() {
        playlistRoomDatabase.close()
    }

    @Test
    fun writeUserAndReadInList() {
        artistDao.insert(ARTISTS)

        val artistList = artistDao.getArtists()
        assertEquals(2, artistList.size)
        assertEquals(artistList[0].name, ARTISTS[0].name)
    }

    @Test
    fun testGetArtistByCountry() {
        artistDao.insert(ARTISTS)

        val artistUS = artistDao.getArtistByCountry("US")
        assertEquals(artistUS.country, ARTISTS[1].country)
    }
}