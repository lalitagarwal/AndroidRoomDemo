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
                .addCallback(object: RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        populateDb(context)
                    }
                })
                .build()
        }

        fun populateDb(context: Context) {
            GlobalScope.launch {
                // Insert album
                getInstance(context).albumDao().insert(AlbumEntity(name = "The Wall", year = 1979))
                getInstance(context).albumDao().insert(AlbumEntity(name = "Supernatural", year = 1999))

                // Insert track
                getInstance(context).trackDao().insert(TrackEntity(trackName = "The Thin Ice", duration = 245))
                getInstance(context).trackDao().insert(TrackEntity(trackName = "Another Brick in the Wall", duration = 546))

                getInstance(context).trackDao().insert(TrackEntity(trackName = "One Fine Morning", duration = 362))
                getInstance(context).trackDao().insert(TrackEntity(trackName = "The Calling", duration = 238))
            }
        }
    }
}