package android.room.androidroomdemo

import android.os.Bundle
import android.room.androidroomdemo.entity.Artist
import android.room.androidroomdemo.entity.Track
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setList()
    }

    private fun setList() {
        var artistList: List<Artist>? = null
        var tracksList: List<Track>? = null
//        var artistAndAllTracks: List<ArtistAndAllTracks>? = null
//        var tracksArtistList: List<TrackArtistJoin>? = null

        // Artist List
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                withContext(IO) {
//                    artistList =
//                        (applicationContext as? PlaylistApplication)?.playlistRoomDatabase?.artistDao()?.getArtists()
//                }
//                val list = artistList?.map { it.toString() }
//                rv_artists.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
//                rv_artists.adapter = ItemAdapter(applicationContext, list)
//                tv_artist.visibility = VISIBLE
//            } catch (e: Exception) {}
//        }

        // Track List
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                withContext(IO) {
//                    tracksList =
//                        (applicationContext as? PlaylistApplication)?.playlistRoomDatabase?.trackDao()?.getTracks()
//                }
//                val list = tracksList?.map { it.toString() }
//                rv_tracks.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
//                rv_tracks.adapter = ItemAdapter(applicationContext, list)
//                tv_tracks.visibility = VISIBLE
//            } catch (e: Exception) {}
//        }

        // Tracks containing the word 'THE`
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                withContext(IO) {
//                    tracksList =
//                        (applicationContext as? PlaylistApplication)?.playlistRoomDatabase?.trackDao()?.getTracksWithKeyword("%the%")
//                }
//                val list = tracksList?.map { it.toString() }
//                rv_tracks_like.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
//                rv_tracks_like.adapter = ItemAdapter(applicationContext, list)
//                tv_tracks_like.visibility = VISIBLE
//            } catch (e: Exception) {}
//        }

//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                withContext(IO) {
//                    artistAndAllTracks =
//                        (applicationContext as? PlaylistApplication)?.playlistRoomDatabase?.artistDao()?.getArtistsAndAllTracks()
//                }
//                val list = artistAndAllTracks?.map { it.toString() }
//                rv_artist_all_tracks.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
//                rv_artist_all_tracks.adapter = ItemAdapter(applicationContext, list)
//                tv_artist_all_tracks.visibility = VISIBLE
//            } catch (e: Exception) {}
//        }

        // Artist Track Join List
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                withContext(IO) {
//                    tracksArtistList =
//                        (applicationContext as? PlaylistApplication)?.playlistRoomDatabase?.trackArtistDao()?.getTrackArtist()
//                }
//                val list = tracksArtistList?.map { it.toString() }
//                rv_track_artist.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
//                rv_track_artist.adapter = ItemAdapter(applicationContext, list)
//                tv_track_artist_join.visibility = VISIBLE
//            } catch (e: Exception) {}
//        }
    }
}
