package johnjimenez.usbinterview.twitterlike.repository

import javax.inject.Inject
import org.springframework.stereotype.Repository
import org.hibernate.SessionFactory
import org.hibernate.criterion.*

import johnjimenez.usbinterview.twitterlike.domain.*

@Repository
class PostRepository {
    @Inject
    private SessionFactory sf
    
    void addPost(message, poster) {
        sf.currentSession.save(new Post(message, poster))
    }
    
    def getPostsFor(User poster) {
        getPostsFor([poster])
    }
    
    def getPostsFor(Collection<User> posters) {
        sf.currentSession.createCriteria(Post.class)
            .add(Restrictions.in('poster', posters))
            .addOrder(Order.desc('createDate')).list()
    }
}
