package android.room.androidroomdemo

import android.content.Context
import android.room.androidroomdemo.dao.ArtistDao
import android.room.androidroomdemo.dao.TrackDao
import android.room.androidroomdemo.entity.Artist
import android.room.androidroomdemo.entity.Track
import android.room.androidroomdemo.entity.TrackArtistJoin
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Artist::class, Track::class],
          views = [TrackArtistJoin::class],
          exportSchema = false,
          version = 1)
abstract class PlaylistRoomDatabase: RoomDatabase() {
    abstract fun artistDao(): ArtistDao
    abstract fun trackDao(): TrackDao

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
                // Insert Artist
                getInstance(context).artistDao().insert(Artist(name = "Pink Floyd", genre = "Progressive Rock", country = "UK"))
                getInstance(context).artistDao().insert(Artist(name = "Santana", genre = "Latin Rock", country = "US"))

                // Insert track
                getInstance(context).trackDao().insert(Track(artistId = 1, trackName = "The Thin Ice", duration = 245))
                getInstance(context).trackDao().insert(Track(artistId = 1, trackName = "Another Brick in the Wall", duration = 546))

                getInstance(context).trackDao().insert(Track(artistId = 2, trackName = "One Fine Morning", duration = 362))
                getInstance(context).trackDao().insert(Track(artistId = 2, trackName = "The Calling", duration = 238))
            }
        }
    }
}