package android.room.androidroomdemo.entity

import androidx.annotation.NonNull
import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = "track",
        foreignKeys = [ForeignKey(
            entity = Artist::class,
            parentColumns = ["id"],
            childColumns = ["artist_id"],
            onDelete = CASCADE
        )],
        indices = [Index(value = ["artist_id"])]
)
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