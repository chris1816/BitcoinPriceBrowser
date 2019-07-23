import java.math.BigDecimal

class TimeStampUtils {
    companion object {
        fun convertTimeStamp(timeStamp: Float): String {
            val initTime = BigDecimal(timeStamp.toDouble()).toString()
            val tmpTime =  java.util.Date(initTime.toLong() *1000).toString()
            val tmpChars = tmpTime.split(" ")
            return if (tmpChars.size >= 3) tmpChars[1] + " ${tmpChars[2]}" else ""
        }
    }
}