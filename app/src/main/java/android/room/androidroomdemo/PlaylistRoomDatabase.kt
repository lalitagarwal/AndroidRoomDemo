package android.room.androidroomdemo

import android.content.Context
import android.room.androidroomdemo.dao.AlbumDao
import android.room.androidroomdemo.dao.TrackDao
import android.room.androidroomdemo.entity.AlbumEntity
import android.room.androidroomdemo.entity.DateToLongConverter
import android.room.androidroomdemo.entity.TrackEntity
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = [AlbumEntity::class, TrackEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateToLongConverter::class)
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
                val calendar = Calendar.getInstance()

                // Insert album
                calendar.set(1979, 11, 30)
                getInstance(context).albumDao().insert(AlbumEntity(name = "The Wall", artist = "Pink Floyd", dateReleased =  calendar.time))

                calendar.set(1999, 6, 15)
                getInstance(context).albumDao().insert(AlbumEntity(name = "Supernatural", artist = "Santana", dateReleased = calendar.time))

                // Insert track
                getInstance(context).trackDao().insert(TrackEntity(albumId= 1, trackName = "The Thin Ice", duration = 245))
                getInstance(context).trackDao().insert(TrackEntity(albumId= 1, trackName = "Another Brick in the Wall", duration = 546))

                getInstance(context).trackDao().insert(TrackEntity(albumId= 2, trackName = "One Fine Morning", duration = 362))
                getInstance(context).trackDao().insert(TrackEntity(albumId= 2, trackName = "The Calling", duration = 238))
            }
        }
    }
}