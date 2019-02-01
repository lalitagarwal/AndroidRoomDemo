package android.room.androidroomdemo.dao

import android.room.androidroomdemo.entity.TrackArtistJoin
import androidx.room.Dao
import androidx.room.Query

@Dao
interface TrackArtistDao {

    @Query("SELECT * from TrackArtistJoin")
    fun getTrackArtist(): List<TrackArtistJoin>
}