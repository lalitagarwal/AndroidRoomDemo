package android.room.androidroomdemo.entity

import androidx.room.TypeConverter
import java.util.Date

class DateToLongConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun toDate(longVal: Long?): Date? {
            return if (longVal == null) null else Date(longVal)
        }

        @TypeConverter
        @JvmStatic
        fun toLong(dateVal: Date?): Long? {
            return if (dateVal == null) null else dateVal.time
        }
    }
}