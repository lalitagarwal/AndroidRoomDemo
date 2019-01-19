package android.room.androidroomdemo.dao

import android.room.androidroomdemo.entity.AlbumEntity
import androidx.room.Dao
import androidx.room.Query

@Dao
interface AlbumDao: BaseDao<AlbumEntity> {

    @Query("SELECT * from albums")
    fun getAlbums(): List<AlbumEntity>
}