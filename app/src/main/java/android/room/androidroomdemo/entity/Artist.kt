package android.room.androidroomdemo.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artist")
data class Artist(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "artist_name")
    @NonNull
    var name: String,

    @ColumnInfo(name = "artist_genre")
    var genre: String,

    @ColumnInfo(name = "artist_country")
    var country: String
) {
    override fun toString(): String {
        return "$name, $genre, $country"
    }
}