package android.room.androidroomdemo

import android.app.Application
import com.facebook.stetho.Stetho
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaylistApplication : Application() {
    var playlistRoomDatabase: PlaylistRoomDatabase? = null

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        playlistRoomDatabase = PlaylistRoomDatabase.getInstance(this)

        CoroutineScope(Dispatchers.IO).launch {
            playlistRoomDatabase?.artistDao()?.getArtists()
        }
    }
}