package android.room.androidroomdemo

import android.room.androidroomdemo.dao.TrackDao
import android.room.androidroomdemo.entity.TrackEntity
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TrackEntityTest {
    private lateinit var trackDao: TrackDao
    private lateinit var playlistRoomDatabase: PlaylistRoomDatabase
    private val FAKE_TRACK1 = TrackEntity(trackName = "The Thin Ice", duration = 245)
    private val FAKE_TRACK2 = TrackEntity(trackName = "Another Brick in the Wall", duration = 546)

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        playlistRoomDatabase = Room.inMemoryDatabaseBuilder(
            context, PlaylistRoomDatabase::class.java).build()
        trackDao = playlistRoomDatabase.trackDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        playlistRoomDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        trackDao.insert(FAKE_TRACK1)
        trackDao.insert(FAKE_TRACK2)

        val albumList = trackDao.getTracks()
        assert(albumList.size == 2)
        assert(albumList[0].trackName == FAKE_TRACK1.trackName)
    }
}