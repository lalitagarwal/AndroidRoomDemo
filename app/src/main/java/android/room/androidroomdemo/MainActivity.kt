package android.room.androidroomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.room.androidroomdemo.entity.AlbumEntity
import com.facebook.stetho.Stetho
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var playlistRoomDatabase: PlaylistRoomDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Stetho.initializeWithDefaults(this)

        playlistRoomDatabase = PlaylistRoomDatabase.getInstance(this)
        GlobalScope.launch {
            playlistRoomDatabase?.albumDao()?.getAlbums()
        }
    }
}
