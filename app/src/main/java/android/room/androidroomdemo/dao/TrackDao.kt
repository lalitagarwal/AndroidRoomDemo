package android.room.androidroomdemo.dao

import android.room.androidroomdemo.entity.AlbumEntity
import android.room.androidroomdemo.entity.TrackEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrackDao: BaseDao<TrackEntity> {

    @Query("SELECT * from tracks")
    fun getTracks(): List<TrackEntity>
}