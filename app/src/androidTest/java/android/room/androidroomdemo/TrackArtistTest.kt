package android.room.androidroomdemo

import android.room.androidroomdemo.TestData.ARTISTS
import android.room.androidroomdemo.TestData.TRACKS
import android.room.androidroomdemo.dao.ArtistDao
import android.room.androidroomdemo.dao.TrackArtistDao
import android.room.androidroomdemo.dao.TrackDao
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TrackArtistTest {
    private lateinit var trackDao: TrackDao
    private lateinit var artistDao: ArtistDao
    private lateinit var trackArtistDao: TrackArtistDao
    private lateinit var playlistRoomDatabase: PlaylistRoomDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        playlistRoomDatabase = Room.inMemoryDatabaseBuilder(
            context, PlaylistRoomDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        trackDao = playlistRoomDatabase.trackDao()
        artistDao = playlistRoomDatabase.artistDao()
        trackArtistDao = playlistRoomDatabase.trackArtistDao()
    }

    @After
    fun closeDb() {
        playlistRoomDatabase.close()
    }

    @Test
    fun writeUserAndReadInList() {
        artistDao.insert(ARTISTS)
        trackDao.insert(TRACKS)

        val artistList = trackArtistDao.getTrackArtist()
        assertEquals(4, artistList.size)
    }
}