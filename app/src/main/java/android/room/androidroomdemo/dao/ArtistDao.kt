package android.room.androidroomdemo.dao

import android.room.androidroomdemo.entity.Artist
import android.room.androidroomdemo.entity.ArtistAndAllTracks
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ArtistDao: BaseDao<Artist> {

    @Query("Select * from artists")
    fun getArtists(): List<Artist>

    @Query("Select * from artists where country = :country")
    fun getArtistByCountry(country: String): Artist

    @Query("SELECT * from artists")
    fun getArtistsAndAllTracks(): List<ArtistAndAllTracks>
}
