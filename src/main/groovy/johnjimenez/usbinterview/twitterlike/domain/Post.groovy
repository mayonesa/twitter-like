package johnjimenez.usbinterview.twitterlike.domain

import javax.persistence.*
import org.hibernate.annotations.Type
import org.joda.time.LocalDateTime

import static johnjimenez.usbinterview.twitterlike.util.PostPrintHelper.getElapsedTime

@Entity
// serializable to allow for jms transport
class Post implements Serializable {
    @Id @GeneratedValue
    @Column(unique = true, nullable = false)
	long id

    @ManyToOne(optional=false)
    User poster
 
    @Column(nullable = false)
    private final String message
    
    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private final LocalDateTime createDate
    
    Post() { }
    
    Post(message, poster) {
        this.message = message
        this.poster = poster
        createDate = new LocalDateTime()
    }
    
    @Override
    String toString() {
        "$message (${getElapsedTime(createDate)} ago)"
    }
    
    @Override
    boolean equals(Object o) {
        if (o instanceof Post) {
            def post = (Post) o
            return post.poster == poster && post.message == message
        }
        false
    }
    
    @Override
    int hashCode() {
        message.hashCode() * (poster.hashCode() + 1)
    }
}
