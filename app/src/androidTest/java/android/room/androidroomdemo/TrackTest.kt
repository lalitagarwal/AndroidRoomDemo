package android.room.androidroomdemo

import android.room.androidroomdemo.dao.ArtistDao
import android.room.androidroomdemo.dao.TrackDao
import android.room.androidroomdemo.entity.Artist
import android.room.androidroomdemo.entity.Track
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.util.*

class TrackTest {
    private lateinit var trackDao: TrackDao
    private lateinit var artistDao: ArtistDao
    private lateinit var playlistRoomDatabase: PlaylistRoomDatabase
    private val calendar = Calendar.getInstance()

    private val FAKE_TRACK1 = Track(trackName = "The Thin Ice", artistId = 1, duration = 245, dateReleased = calendar.time)
    private val FAKE_TRACK2 = Track(trackName = "Another Brick in the Wall", artistId = 2, duration = 546, dateReleased = calendar.time)

    private val FAKE_ARTIST1 = Artist(1, "Pink Floyd", "Progressive Rock", "UK")
    private val FAKE_ARTIST2 = Artist(2, "Santana", "Latin Rock", "US")

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        playlistRoomDatabase = Room.inMemoryDatabaseBuilder(
            context, PlaylistRoomDatabase::class.java).build()
        trackDao = playlistRoomDatabase.trackDao()
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

        trackDao.insert(FAKE_TRACK1)
        trackDao.insert(FAKE_TRACK2)

        val albumList = trackDao.getTracks()
        assertEquals(albumList.size, 2)
        assertEquals(albumList[0].trackName, FAKE_TRACK1.trackName)
    }
}