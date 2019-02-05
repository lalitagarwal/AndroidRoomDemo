package android.room.androidroomdemo.dao

import android.room.androidroomdemo.entity.Track
import androidx.room.Dao
import androidx.room.Query

@Dao
interface TrackDao: BaseDao<Track> {

    @Query("SELECT * from track")
    fun getTracks(): List<Track>
}