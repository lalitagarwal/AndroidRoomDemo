package android.room.androidroomdemo.dao

import android.room.androidroomdemo.entity.ArtistEntity
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ArtistDao: BaseDao<ArtistEntity> {

    @Query("Select * from artists")
    fun getArtists(): List<ArtistEntity>

    @Query("Select * from artists where country = :country")
    fun getArtistByCountry(country: String): ArtistEntity
}
