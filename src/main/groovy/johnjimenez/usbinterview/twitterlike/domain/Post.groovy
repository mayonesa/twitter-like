package johnjimenez.usbinterview.twitterlike.domain

import org.joda.time.LocalDateTime
import org.joda.time.Period
import org.joda.time.format.PeriodFormatterBuilder

class Post {
    private final String message
    final User poster
    private final LocalDateTime createDate
    
    Post(String message, User poster) {
        this.message = message
        this.poster = poster
        createDate = new LocalDateTime()
    }
    
    String toString() {
        "$message (${getElapsedTime()} ago)"
    }
    
    private String getElapsedTime() {
        Period elapsedPeriod = new Period(createDate, new LocalDateTime())
        PeriodFormatterBuilder formatterBuilder = new PeriodFormatterBuilder()
        if (elapsedPeriod.getYears() > 0) {
            formatterBuilder.appendYears().appendSuffix(' year', ' years')
        } else if (elapsedPeriod.getMonths() > 0) {
            formatterBuilder.appendMonths().appendSuffix(' month', ' months')
        } else if (elapsedPeriod.getWeeks() > 0) {
            formatterBuilder.appendWeeks().appendSuffix(' week', ' weeks')
        } else if (elapsedPeriod.getDays() > 0) {
            formatterBuilder.appendDays().appendSuffix(' day', ' days')
        } else if (elapsedPeriod.getHours() > 0) {
            formatterBuilder.appendHours().appendSuffix(' hour', ' hours')
        } else if (elapsedPeriod.getMinutes() > 0) {
            formatterBuilder.appendMinutes().appendSuffix(' minute', ' minutes')
        } else {
            formatterBuilder.appendSeconds().appendSuffix(' second', ' seconds')
        }
        formatterBuilder.toFormatter().print elapsedPeriod
    }
}
