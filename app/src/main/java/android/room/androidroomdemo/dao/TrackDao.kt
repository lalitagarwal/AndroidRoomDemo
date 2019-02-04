package android.room.androidroomdemo.dao

import android.room.androidroomdemo.entity.Track
import androidx.room.Dao
import androidx.room.Query

@Dao
interface TrackDao: BaseDao<Track> {

    @Query("SELECT * from tracks")
    fun getTracks(): List<Track>

    @Query("SELECT * from tracks WHERE track_name LIKE :keyword")
    fun getTracksWithKeyword(keyword: String): List<Track>
}