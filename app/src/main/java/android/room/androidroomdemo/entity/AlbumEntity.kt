package android.room.androidroomdemo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "album_id")
    var albumId: Int = 0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "year")
    var year: Int
)