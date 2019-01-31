package android.room.androidroomdemo.entity

import androidx.room.*

@DatabaseView(viewName = "trackartistjoin",
              value = "SELECT * FROM tracks INNER JOIN artists on tracks.artist_id = artists.id")
data class TrackArtistJoin (
    @Embedded
    var tracks: Track,

    @Embedded
    var artists: Artist
) {
    override fun toString(): String {
        return "${tracks.trackName} by ${artists.name}"
    }
}