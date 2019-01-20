package android.room.androidroomdemo.entity

import androidx.room.*
import java.util.Date

@Entity(tableName = "albums",
        foreignKeys = [ForeignKey(
            entity = ArtistEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("artist_id"),
            onDelete = ForeignKey.CASCADE
        )],
    indices = [Index(value = ["artist_id"])]
)
data class AlbumEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "artist_id")
    var artistId: Int,

    @ColumnInfo(name = "date_released")
    var dateReleased: Date
)