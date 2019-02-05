package android.room.androidroomdemo.entity

import androidx.room.DatabaseView
import androidx.room.Embedded

@DatabaseView(viewName = "track_artist_join",
              value = "Select * from track INNER JOIN artist on track.artist_id = artist.id")
data class TrackArtistJoin(

    @Embedded
    val artist: Artist,

    @Embedded
    val track: Track
) {
    override fun toString(): String {
        return "${artist.name} ${track.trackName}"
    }
}