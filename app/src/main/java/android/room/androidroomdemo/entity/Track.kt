package android.room.androidroomdemo.entity

import androidx.annotation.NonNull
import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import java.util.*

// onDelete = Cascade specifies that if the album is deleted, delete all the tracks of that column
@Entity(tableName = "tracks",
        foreignKeys = [ForeignKey(
            entity = Artist::class,
            parentColumns = ["id"],
            childColumns = ["artist_id"],
            onDelete = CASCADE
        )],
        indices = [Index(value = ["artist_id"])]
)
data class Track (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "track_id")
    var trackId: Int = 0,

    @ColumnInfo(name = "artist_id")
    var artistId: Int,

    @ColumnInfo(name = "track_name")
    @NonNull
    var trackName: String,

    @ColumnInfo(name = "duration")
    var duration: Long,

    @ColumnInfo(name = "date_released")
    var dateReleased: Date
) {
    override fun toString(): String {
        return "$trackName, $duration sec"
    }
}