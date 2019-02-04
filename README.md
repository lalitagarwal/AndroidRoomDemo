# AndroidRoomDemo

Function to pre-populate the database

```
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
```