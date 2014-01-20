package johnjimenez.usbinterview.twitterlike.repository

import javax.inject.Inject
import org.springframework.stereotype.Repository
import org.hibernate.SessionFactory

import johnjimenez.usbinterview.twitterlike.domain.User

@Repository
class UserRepository {
    @Inject
    private SessionFactory sf
    
    def getUserByName(name) {
        def user = sf.currentSession.get(User.class, name)
        if (user != null) {
            user
        } else {
            createUser name
        }
    }
    
    def loadUserByName(name) {
        sf.currentSession.load User.class, name
    }
    
    void makeFollow(followerName, followeeName) {
        def follower = loadUserByName(followerName)
        follower.follow loadUserByName(followeeName)
        sf.currentSession.update follower
    }
    
    private def createUser(name) {
        def user = new User(name:name) 
        sf.currentSession.persist user
        user
    }
}
