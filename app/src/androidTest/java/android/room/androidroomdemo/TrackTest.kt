package android.room.androidroomdemo

import android.room.androidroomdemo.TestData.Companion.ARTISTS
import android.room.androidroomdemo.TestData.Companion.TRACKS
import android.room.androidroomdemo.dao.ArtistDao
import android.room.androidroomdemo.dao.TrackDao
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TrackTest {
    private lateinit var trackDao: TrackDao
    private lateinit var artistDao: ArtistDao
    private lateinit var playlistRoomDatabase: PlaylistRoomDatabase

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
        artistDao.insert(ARTISTS)
        trackDao.insert(TRACKS)

        val albumList = trackDao.getTracks()
        assertEquals(albumList.size, 4)
        assertEquals(albumList[0].trackName, TRACKS[0].trackName)
    }
}