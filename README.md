# AndroidRoomDemo

Function to pre-populate the database

```
fun populateDb(context: Context) {
            CoroutineScope(Dispatchers.IO).launch {
                // Insert Artist
                getInstance(context).artistDao().insert(Artist(name = "Pink Floyd", genre = "Progressive Rock", country = "UK"))
                getInstance(context).artistDao().insert(Artist(name = "Santana", genre = "Latin Rock", country = "US"))

                // Insert track
                getInstance(context).trackDao().insert(Track(trackName = "The Thin Ice", duration = 245))
                getInstance(context).trackDao().insert(Track(trackName = "Another Brick in the Wall", duration = 546))

                getInstance(context).trackDao().insert(Track(trackName = "One Fine Morning", duration = 362))
                getInstance(context).trackDao().insert(Track(trackName = "The Calling", duration = 238))
            }
        }
```
