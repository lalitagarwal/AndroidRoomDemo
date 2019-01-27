package android.room.androidroomdemo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "artists",
        indices = [Index(value = ["genre"])])
data class Artist (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "country")
    var country: String
)