package android.room.androidroomdemo.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ArtistAndAllTracks(

    @Embedded
    var artist: Artist,

    @Relation(entity = Track::class, entityColumn = "artist_id", parentColumn = "artist_id")
    var tracksList: List<Track>
) {
    override fun toString(): String {
        var str = "${artist.name} -"
        tracksList.forEach {
            str += "${it.trackName}, "
        }
        return str
    }
}
