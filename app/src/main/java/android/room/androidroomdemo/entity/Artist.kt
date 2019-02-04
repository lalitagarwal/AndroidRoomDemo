package android.room.androidroomdemo.entity

data class Artist(
    var id: Int,

    var name: String,

    var genre: String,

    var country: String
) {
    override fun toString(): String {
        return "$name, $genre, $country"
    }
}