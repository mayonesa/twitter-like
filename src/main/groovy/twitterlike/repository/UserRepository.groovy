package twitterlike.repository

import groovy.util.logging.Log4j
import javax.inject.Inject
import org.springframework.stereotype.Repository
import org.hibernate.*

import twitterlike.domain.User
import twitterlike.exception.UserNotFoundException

@Log4j
@Repository
class UserRepository {
    @Inject
    private SessionFactory sf
    
    // creates a user if one doesn't exist
    def getUserByName(name) {
        def user = sf.currentSession.get(User.class, name)
        if (user != null) {
            user
        } else {
            createUser name
        }
    }
    
    def loadUserByName(name) throws UserNotFoundException {
        try {
            def user = sf.currentSession.load User.class, name
            def userName = user?.name
            if (userName?.empty) {
                throw new ObjectNotFoundException()
            }
            log.debug "$userName found"
            user
        } catch(ObjectNotFoundException onfe) {
            log.info "$name is not a user"
            throw new UserNotFoundException(name)
        }
    }
    
    void makeFollow(followerName, followeeName) throws UserNotFoundException {
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
