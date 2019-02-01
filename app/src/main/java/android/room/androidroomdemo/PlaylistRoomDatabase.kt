package android.room.androidroomdemo

import android.content.Context
import android.room.androidroomdemo.dao.ArtistDao
import android.room.androidroomdemo.dao.TrackArtistDao
import android.room.androidroomdemo.dao.TrackDao
import android.room.androidroomdemo.entity.*
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = [Track::class, Artist::class],
          views = [TrackArtistJoin::class],
          version = 1, exportSchema = false)
@TypeConverters(DateToLongConverter::class)
abstract class PlaylistRoomDatabase: RoomDatabase() {
    abstract fun trackDao(): TrackDao
    abstract fun artistDao(): ArtistDao
    abstract fun trackArtistDao(): TrackArtistDao

    companion object {
        private var playlistRoomDatabase: PlaylistRoomDatabase? = null

        fun getInstance(context: Context): PlaylistRoomDatabase {
            return playlistRoomDatabase?.let {
                it
            } ?: kotlin.run {
                buildDbInstance(context)
            }
        }

        private fun buildDbInstance(context: Context): PlaylistRoomDatabase {
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
            CoroutineScope(Dispatchers.IO).launch {
                val calendar = Calendar.getInstance()

                // Insert Artist
                getInstance(context).artistDao().insert(Artist(1, "Pink Floyd", "Progressive Rock", "UK"))
                getInstance(context).artistDao().insert(Artist(2, "Santana", "Latin Rock", "US"))

                // Insert album
                calendar.set(1979, 11, 30)
                // Insert track
                getInstance(context).trackDao().insert(Track(artistId= 1, trackName = "The Thin Ice", duration = 245, dateReleased = calendar.time ))
                getInstance(context).trackDao().insert(Track(artistId= 1, trackName = "Another Brick in the Wall", duration = 546, dateReleased = calendar.time ))

                calendar.set(1999, 6, 15)
                getInstance(context).trackDao().insert(Track(artistId= 2, trackName = "One Fine Morning", duration = 362, dateReleased = calendar.time ))
                getInstance(context).trackDao().insert(Track(artistId= 2, trackName = "The Calling", duration = 238, dateReleased = calendar.time ))
            }
        }
    }
}