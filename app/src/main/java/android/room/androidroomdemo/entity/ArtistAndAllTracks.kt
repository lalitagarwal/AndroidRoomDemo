package android.room.androidroomdemo.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ArtistAndAllTracks (

    @Embedded
    val artist: Artist,

    @Relation(entity = Track::class, entityColumn = "artist_id", parentColumn = "id")
    val tracksList:  List<Track>
) {
    override fun toString(): String {
        var str = artist.name + " tracks - "
        tracksList.forEach {
            str += it.trackName + ", "
        }
        return str
    }
}