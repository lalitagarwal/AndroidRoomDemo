package android.room.androidroomdemo

import android.content.Context
import android.room.androidroomdemo.dao.AlbumDao
import android.room.androidroomdemo.dao.TrackDao
import android.room.androidroomdemo.entity.AlbumEntity
import android.room.androidroomdemo.entity.TrackEntity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [AlbumEntity::class, TrackEntity::class], version = 1, exportSchema = false)
abstract class PlaylistRoomDatabase: RoomDatabase() {
    abstract fun albumDao(): AlbumDao
    abstract fun trackDao(): TrackDao

    companion object {
        var playlistRoomDatabase: PlaylistRoomDatabase? = null

        fun getInstance(context: Context): PlaylistRoomDatabase {
            return playlistRoomDatabase?.let {
                it
            } ?: kotlin.run {
                buildDbInstance(context)
            }
        }

        fun buildDbInstance(context: Context): PlaylistRoomDatabase {
            return Room.databaseBuilder(
                context,
                PlaylistRoomDatabase::class.java,
                "playlist.sqlite"
            )
                .build()
        }
    }
}