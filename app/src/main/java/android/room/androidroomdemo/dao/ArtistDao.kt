package android.room.androidroomdemo.dao

import android.room.androidroomdemo.entity.Artist
import android.room.androidroomdemo.entity.ArtistAndAllTracks
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ArtistDao: BaseDao<Artist> {

    @Query("SELECT * from artist")
    fun getArtists(): List<Artist>

    @Query("SELECT * from artist")
    fun getArtistsAndAllTracks(): List<ArtistAndAllTracks>
}