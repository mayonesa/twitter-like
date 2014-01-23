package johnjimenez.usbinterview.twitterlike.util

import org.joda.time.LocalDateTime
import org.joda.time.Period
import org.joda.time.format.PeriodFormatterBuilder

class PostPrintHelper {
    // allows for centralized required output formatting
    static def getStringBuilder(posts, getStringBuilderComponent) {
        def sb = new StringBuilder('\n')
        posts.each {
            sb.append "${getStringBuilderComponent(it)}\n"
        }
        sb
    }
    
    static def getElapsedTime(initialDate) {
        def elapsedPeriod = new Period(initialDate, new LocalDateTime())
        def formatterBuilder = new PeriodFormatterBuilder()
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
