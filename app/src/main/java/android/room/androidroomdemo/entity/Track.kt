package android.room.androidroomdemo.entity

data class Track(
    var trackId: Int = 0,

    var trackName: String,

    var duration: Long
) {
    override fun toString(): String {
        return "$trackName, $duration sec"
    }
}