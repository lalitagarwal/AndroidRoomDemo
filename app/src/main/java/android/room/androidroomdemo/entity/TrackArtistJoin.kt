package android.room.androidroomdemo.entity

import androidx.room.*

@DatabaseView("SELECT * FROM tracks INNER JOIN artists on tracks.artist_id = artists.id")
data class TrackArtistJoin (
    @Embedded(prefix = "track_")
    var tracks: Track,

    @Embedded(prefix = "artist_")
    var artists: Artist
)