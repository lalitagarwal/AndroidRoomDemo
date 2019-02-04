package android.room.androidroomdemo.entity

import androidx.annotation.NonNull
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
    @NonNull
    var name: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "country")
    var country: String
) {
    override fun toString(): String {
        return "$name, $genre, $country"
    }
}