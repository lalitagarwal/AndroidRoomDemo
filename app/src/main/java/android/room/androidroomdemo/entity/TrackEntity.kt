package android.room.androidroomdemo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracks")
class TrackEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "track_id")
    var songId: Int = 0,

    @ColumnInfo(name = "track_name")
    var trackName: String,

    @ColumnInfo(name = "duration")
    var duration: Long
)