package android.room.androidroomdemo

import android.room.androidroomdemo.entity.Artist
import android.room.androidroomdemo.entity.Track
import java.util.*

class TestData {
    companion object {
        private val calendar = Calendar.getInstance()
        private val FAKE_ARTIST1 = Artist(1, "Pink Floyd", "Progressive Rock", "UK")
        private val FAKE_ARTIST2 = Artist(2, "Santana", "Latin Rock", "US")
        val ARTISTS = listOf(FAKE_ARTIST1, FAKE_ARTIST2)

        private val FAKE_TRACK1 = Track(trackName = "The Thin Ice", artistId = 1, duration = 245, dateReleased = calendar.time)
        private val FAKE_TRACK2 = Track(trackName = "Another Brick in the Wall", artistId = 2, duration = 546, dateReleased = calendar.time)
        private val FAKE_TRACK3 = Track(trackName = "One Fine Morning", artistId= 2, duration = 362, dateReleased = calendar.time )
        private val FAKE_TRACK4 = Track(trackName = "The Calling", artistId= 2, duration = 238, dateReleased = calendar.time )
        val TRACKS = listOf(FAKE_TRACK1, FAKE_TRACK2, FAKE_TRACK3, FAKE_TRACK4)
    }
}