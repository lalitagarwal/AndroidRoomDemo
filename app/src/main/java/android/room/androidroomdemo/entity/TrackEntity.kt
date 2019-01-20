package android.room.androidroomdemo.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

// onDelete = Cascade specifies that if the album is deleted, delete all the tracks of that column
@Entity(tableName = "tracks",
        foreignKeys = arrayOf(ForeignKey(
            entity = AlbumEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("album_id"),
            onDelete = CASCADE
        )),
        indices = [Index(value = ["album_id"])]
)
class TrackEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "track_id")
    var trackId: Int = 0,

    @ColumnInfo(name = "album_id")
    var albumId: Int,

    @ColumnInfo(name = "track_name")
    var trackName: String,

    @ColumnInfo(name = "duration")
    var duration: Long
)