package android.room.androidroomdemo.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "track")
data class Track(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "track_id")
    var trackId: Int = 0,

    @ColumnInfo(name = "artist_id")
    var artistId: Int,

    @ColumnInfo(name = "track_name")
    @NonNull
    var trackName: String,

    @ColumnInfo(name = "track_duration")
    var duration: Long
) {
    override fun toString(): String {
        return "$trackName, $duration sec"
    }
}