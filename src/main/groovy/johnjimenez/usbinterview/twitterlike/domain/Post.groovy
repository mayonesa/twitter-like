package johnjimenez.usbinterview.twitterlike.domain

import org.joda.time.LocalDateTime

import static johnjimenez.usbinterview.twitterlike.util.PostPrintHelper.getElapsedTime

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
        "$message (${getElapsedTime(createDate)} ago)"
    }
}
